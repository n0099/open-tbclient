package com.baidu.android.imsdk.internal;
/* loaded from: classes9.dex */
public class IMNetWorkFlowStatic {
    private static IMNetWorkFlowStatic mStatic = null;
    private long mMobileFlow;
    private long mWifiFlow;

    private IMNetWorkFlowStatic() {
    }

    public IMNetWorkFlowStatic getInstance() {
        if (mStatic == null) {
            mStatic = new IMNetWorkFlowStatic();
        }
        return mStatic;
    }

    public long getMobileFlow() {
        return mStatic.mMobileFlow;
    }

    public long getWifiFlow() {
        return mStatic.mWifiFlow;
    }

    public void clear() {
        mStatic.mMobileFlow = 0L;
        mStatic.mMobileFlow = 0L;
    }
}
