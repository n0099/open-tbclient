package com.baidu.ala.dumixar.utils;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes3.dex */
public class FrameIntervalReport {
    private static final String FRAME_INTERVAL_ACTION = "com.baidu.report.frame.interval";
    private static final int PROFILE_LOG_SIZE = 1;
    private Context mContext;
    private long mDrawFrameTime;
    private int mFrameIndex = 0;
    private long mIntervalSum;

    public void onFrameAvailable(Context context) {
        this.mContext = context;
        if (this.mDrawFrameTime != 0) {
            if (this.mFrameIndex == 1) {
                Long valueOf = Long.valueOf(1000 / this.mIntervalSum);
                Long valueOf2 = Long.valueOf(this.mIntervalSum / 1);
                this.mFrameIndex = 0;
                this.mIntervalSum = 0L;
                report(valueOf.longValue(), valueOf2.longValue());
            } else {
                this.mFrameIndex++;
                this.mIntervalSum += System.currentTimeMillis() - this.mDrawFrameTime;
            }
        }
        this.mDrawFrameTime = System.currentTimeMillis();
    }

    private void report(long j, long j2) {
        if (this.mContext != null) {
            Intent intent = new Intent();
            intent.setAction(FRAME_INTERVAL_ACTION);
            intent.putExtra("profile_frame_fps_avg", j);
            intent.putExtra("profile_frame_interval_avg", j2);
            this.mContext.sendBroadcast(intent);
        }
    }
}
