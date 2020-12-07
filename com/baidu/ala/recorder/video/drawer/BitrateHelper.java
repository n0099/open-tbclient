package com.baidu.ala.recorder.video.drawer;

import com.baidu.android.imsdk.internal.IMConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class BitrateHelper {
    private static final int MAX_TIME_LEN = 8000;
    private static final int MIN_TIME_LEN = 3000;
    private Callback callback;
    private long inputSize;
    private long startTimestamp;
    private long keyframes = 0;
    private long frames = 0;

    /* loaded from: classes9.dex */
    interface Callback {
        void onBitrate(long j);
    }

    public BitrateHelper(Callback callback) {
        this.callback = null;
        this.inputSize = 0L;
        this.startTimestamp = 0L;
        this.callback = callback;
        this.inputSize = 0L;
        this.startTimestamp = 0L;
    }

    public void inputData(boolean z, long j, long j2) {
        if (z) {
            this.keyframes++;
        }
        if (this.startTimestamp != 0 || this.keyframes != 0) {
            this.frames++;
            if (this.startTimestamp == 0 && this.keyframes == 1) {
                this.startTimestamp = j2;
            }
            long j3 = (j2 <= this.startTimestamp || this.startTimestamp <= 0) ? 0L : j2 - this.startTimestamp;
            if (j3 > IMConnection.RETRY_DELAY_TIMES && this.keyframes == 2) {
                long reset = reset(j2);
                if (this.callback != null && reset > 0) {
                    this.callback.onBitrate(reset);
                }
                this.inputSize += j;
            } else if (j3 > 8000) {
                long reset2 = reset(j2);
                if (this.callback != null && reset2 > 0) {
                    this.callback.onBitrate(reset2);
                }
                this.inputSize += j;
            } else {
                this.inputSize += j;
            }
        }
    }

    private long reset(long j) {
        long j2 = j > this.startTimestamp ? (((float) this.inputSize) * 8.0f) / ((float) (j - this.startTimestamp)) : 0L;
        this.inputSize = 0L;
        this.startTimestamp = 0L;
        this.keyframes = 0L;
        this.frames = 0L;
        return j2;
    }
}
