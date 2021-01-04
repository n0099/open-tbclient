package com.baidu.searchbox.afx.decode;

import android.util.Log;
import com.baidu.searchbox.afx.decode.VideoPlayer;
/* loaded from: classes3.dex */
public class SpeedControl implements VideoPlayer.FrameCallback {
    private static final long ONE_MILLION = 1000000;
    private static final String TAG = "SpeedControl";
    private long mFixedFrameDurationUsec;
    private boolean mLoopReset;
    private long mPrevMonoUsec;
    private long mPrevPresentUsec;

    public void setFixedPlaybackRate(int i) {
        this.mFixedFrameDurationUsec = 1000000 / i;
    }

    @Override // com.baidu.searchbox.afx.decode.VideoPlayer.FrameCallback
    public void preRender(long j) {
        long j2;
        if (this.mPrevMonoUsec == 0) {
            this.mPrevMonoUsec = System.nanoTime() / 1000;
            this.mPrevPresentUsec = j;
            return;
        }
        if (this.mLoopReset) {
            this.mPrevPresentUsec = j - 40000;
            this.mLoopReset = false;
        }
        if (this.mFixedFrameDurationUsec != 0) {
            j2 = this.mFixedFrameDurationUsec;
        } else {
            j2 = j - this.mPrevPresentUsec;
        }
        if (j2 < 0) {
            Log.w(TAG, "Weird, video times went backward");
            j2 = 0;
        } else if (j2 == 0) {
            Log.w(TAG, "Warning: current frame and previous frame had same timestamp");
        } else if (j2 > 10000000) {
            j2 = 5000000;
        }
        long j3 = this.mPrevMonoUsec + j2;
        long nanoTime = System.nanoTime();
        while (true) {
            long j4 = nanoTime / 1000;
            if (j4 < j3 - 100) {
                long j5 = j3 - j4;
                if (j5 > 500000) {
                    j5 = 500000;
                }
                try {
                    Thread.sleep(j5 / 1000, ((int) (j5 % 1000)) * 1000);
                } catch (InterruptedException e) {
                }
                nanoTime = System.nanoTime();
            } else {
                this.mPrevMonoUsec += j2;
                this.mPrevPresentUsec = j2 + this.mPrevPresentUsec;
                return;
            }
        }
    }

    @Override // com.baidu.searchbox.afx.decode.VideoPlayer.FrameCallback
    public void loopReset() {
        this.mLoopReset = true;
    }

    @Override // com.baidu.searchbox.afx.decode.VideoPlayer.FrameCallback
    public void reset() {
        this.mPrevPresentUsec = 0L;
        this.mPrevMonoUsec = 0L;
        this.mFixedFrameDurationUsec = 0L;
        this.mLoopReset = false;
    }
}
