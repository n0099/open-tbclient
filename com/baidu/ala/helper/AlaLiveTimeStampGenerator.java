package com.baidu.ala.helper;

import android.util.Log;
/* loaded from: classes6.dex */
public class AlaLiveTimeStampGenerator {
    private static AlaLiveTimeStampGenerator mInstance = new AlaLiveTimeStampGenerator();
    private volatile long mStartTimeStamp = 0;
    private volatile long mOffsetTimeStamp = 0;
    private volatile long mResult = 0;
    public boolean mIsFirstVideo = true;

    public static AlaLiveTimeStampGenerator sharedInstance() {
        return mInstance;
    }

    private AlaLiveTimeStampGenerator() {
    }

    public void stop() {
    }

    public void reset() {
        this.mStartTimeStamp = System.nanoTime();
        this.mOffsetTimeStamp = 0L;
        this.mResult = 0L;
        this.mIsFirstVideo = true;
    }

    public void start() {
        this.mStartTimeStamp = System.nanoTime();
        this.mOffsetTimeStamp = this.mResult > 0 ? this.mResult + 89694000 : this.mResult;
        if (this.mResult == 0) {
            this.mIsFirstVideo = true;
        }
        Log.i("TimeStampGenerator offset=", "" + this.mOffsetTimeStamp);
    }

    public void pause() {
    }

    public synchronized long getAudioStamp() {
        long nanoTime;
        nanoTime = (System.nanoTime() - this.mStartTimeStamp) + this.mOffsetTimeStamp;
        this.mResult = Math.max(this.mResult, nanoTime);
        return nanoTime / 1000;
    }

    public long getDuration() {
        return this.mResult;
    }

    public synchronized long getVideoStamp() {
        long nanoTime;
        nanoTime = (System.nanoTime() - this.mStartTimeStamp) + this.mOffsetTimeStamp;
        this.mResult = Math.max(this.mResult, nanoTime);
        if (this.mIsFirstVideo) {
            this.mIsFirstVideo = false;
            nanoTime = 0;
        }
        return nanoTime;
    }
}
