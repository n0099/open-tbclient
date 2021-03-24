package com.baidu.android.imsdk.internal;
/* loaded from: classes2.dex */
public class IMNetWorkFlowStatic {
    public static IMNetWorkFlowStatic mStatic;
    public long mMobileFlow;
    public long mWifiFlow;

    public void clear() {
        IMNetWorkFlowStatic iMNetWorkFlowStatic = mStatic;
        iMNetWorkFlowStatic.mMobileFlow = 0L;
        iMNetWorkFlowStatic.mMobileFlow = 0L;
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
}
