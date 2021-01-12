package com.baidu.ala.helper;

import com.baidu.ala.adp.lib.safe.SafeHandler;
/* loaded from: classes14.dex */
public class EncodePerformanceHelper {
    private static volatile EncodePerformanceHelper mInst = null;
    long mEndTime;
    private FrameReport mFrameReport;
    long mStartTime;
    long mEncoderCostMs = 0;
    int mEncoderCostCount = 0;

    /* loaded from: classes14.dex */
    public interface FrameReport {
        void onFrameEncodeCost(float f);
    }

    private EncodePerformanceHelper() {
    }

    public void setFrameReport(FrameReport frameReport) {
        this.mFrameReport = frameReport;
    }

    public void before() {
        if (this.mFrameReport != null) {
            this.mStartTime = System.currentTimeMillis();
        }
    }

    public void after() {
        if (this.mFrameReport != null) {
            this.mEndTime = System.currentTimeMillis();
            this.mEncoderCostCount++;
            this.mEncoderCostMs += this.mEndTime - this.mStartTime;
            if (this.mEncoderCostCount % 20 == 0) {
                final float f = (((float) this.mEncoderCostMs) * 1.0f) / this.mEncoderCostCount;
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.ala.helper.EncodePerformanceHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EncodePerformanceHelper.this.mFrameReport.onFrameEncodeCost(f);
                    }
                });
            }
        }
    }

    public void finish() {
        this.mFrameReport = null;
    }

    public static EncodePerformanceHelper getInst() {
        if (mInst == null) {
            synchronized (EncodePerformanceHelper.class) {
                if (mInst == null) {
                    mInst = new EncodePerformanceHelper();
                }
            }
        }
        return mInst;
    }

    public static void release() {
        if (mInst != null) {
            mInst.finish();
            mInst = null;
        }
    }
}
