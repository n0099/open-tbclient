package com.baidu.android.imsdk.shield;

import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.android.imsdk.shield.model.GetSubscriptionResult;
/* loaded from: classes18.dex */
public class IMServiceNotifyMenuMergeListener implements IGetShieldAndTopListener, IGetSubscriptionListener {
    private int mCategory;
    private IGetServiceNotifyMenuListener mListener;
    private GetShieldAndTopResult mShieldResult = null;
    private GetSubscriptionResult mSubscriptionResult = null;

    public IMServiceNotifyMenuMergeListener(int i, IGetServiceNotifyMenuListener iGetServiceNotifyMenuListener) {
        this.mListener = iGetServiceNotifyMenuListener;
        this.mCategory = i;
    }

    @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
    public synchronized void onResult(GetShieldAndTopResult getShieldAndTopResult) {
        if (this.mListener != null) {
            this.mShieldResult = getShieldAndTopResult;
            if (this.mCategory == 0) {
                this.mListener.onResult(this.mShieldResult, null);
            } else if (this.mSubscriptionResult != null) {
                this.mListener.onResult(this.mShieldResult, this.mSubscriptionResult);
            }
        }
    }

    @Override // com.baidu.android.imsdk.shield.IGetSubscriptionListener
    public synchronized void onResult(GetSubscriptionResult getSubscriptionResult) {
        if (this.mListener != null) {
            this.mSubscriptionResult = getSubscriptionResult;
            if (this.mCategory == 1) {
                this.mListener.onResult(null, this.mSubscriptionResult);
            } else if (this.mShieldResult != null) {
                this.mListener.onResult(this.mShieldResult, this.mSubscriptionResult);
            }
        }
    }
}
