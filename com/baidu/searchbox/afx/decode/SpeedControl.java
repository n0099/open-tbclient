package com.baidu.searchbox.afx.decode;

import android.util.Log;
import com.baidu.searchbox.afx.decode.VideoPlayer;
/* loaded from: classes2.dex */
public class SpeedControl implements VideoPlayer.FrameCallback {
    public static final long ONE_MILLION = 1000000;
    public static final String TAG = "SpeedControl";
    public long mFixedFrameDurationUsec;
    public boolean mLoopReset;
    public long mPrevMonoUsec;
    public long mPrevPresentUsec;

    @Override // com.baidu.searchbox.afx.decode.VideoPlayer.FrameCallback
    public void loopReset() {
        this.mLoopReset = true;
    }

    @Override // com.baidu.searchbox.afx.decode.VideoPlayer.FrameCallback
    public void preRender(long j) {
        long j2 = 0;
        if (this.mPrevMonoUsec == 0) {
            this.mPrevMonoUsec = System.nanoTime() / 1000;
            this.mPrevPresentUsec = j;
            return;
        }
        if (this.mLoopReset) {
            this.mPrevPresentUsec = j - 40000;
            this.mLoopReset = false;
        }
        long j3 = this.mFixedFrameDurationUsec;
        if (j3 == 0) {
            j3 = j - this.mPrevPresentUsec;
        }
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i2 < 0) {
            Log.w(TAG, "Weird, video times went backward");
        } else {
            if (i2 == 0) {
                Log.w(TAG, "Warning: current frame and previous frame had same timestamp");
            } else if (j3 > 10000000) {
                j2 = 5000000;
            }
            j2 = j3;
        }
        long j4 = this.mPrevMonoUsec + j2;
        long nanoTime = System.nanoTime();
        while (true) {
            long j5 = nanoTime / 1000;
            if (j5 < j4 - 100) {
                long j6 = j4 - j5;
                if (j6 > 500000) {
                    j6 = 500000;
                }
                try {
                    Thread.sleep(j6 / 1000, ((int) (j6 % 1000)) * 1000);
                } catch (InterruptedException unused) {
                }
                nanoTime = System.nanoTime();
            } else {
                this.mPrevMonoUsec += j2;
                this.mPrevPresentUsec += j2;
                return;
            }
        }
    }

    @Override // com.baidu.searchbox.afx.decode.VideoPlayer.FrameCallback
    public void reset() {
        this.mPrevPresentUsec = 0L;
        this.mPrevMonoUsec = 0L;
        this.mFixedFrameDurationUsec = 0L;
        this.mLoopReset = false;
    }

    public void setFixedPlaybackRate(int i2) {
        this.mFixedFrameDurationUsec = 1000000 / i2;
    }
}
