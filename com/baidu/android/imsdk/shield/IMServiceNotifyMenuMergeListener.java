package com.baidu.android.imsdk.shield;

import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.android.imsdk.shield.model.GetSubscriptionResult;
/* loaded from: classes.dex */
public class IMServiceNotifyMenuMergeListener implements IGetSubscriptionListener, IGetShieldAndTopListener {
    public int mCategory;
    public IGetServiceNotifyMenuListener mListener;
    public GetShieldAndTopResult mShieldResult = null;
    public GetSubscriptionResult mSubscriptionResult = null;

    public IMServiceNotifyMenuMergeListener(int i, IGetServiceNotifyMenuListener iGetServiceNotifyMenuListener) {
        this.mListener = iGetServiceNotifyMenuListener;
        this.mCategory = i;
    }

    @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
    public synchronized void onResult(GetShieldAndTopResult getShieldAndTopResult) {
        if (this.mListener == null) {
            return;
        }
        this.mShieldResult = getShieldAndTopResult;
        if (this.mCategory == 0) {
            this.mListener.onResult(getShieldAndTopResult, null);
        } else if (this.mSubscriptionResult != null) {
            this.mListener.onResult(getShieldAndTopResult, this.mSubscriptionResult);
        }
    }

    @Override // com.baidu.android.imsdk.shield.IGetSubscriptionListener
    public synchronized void onResult(GetSubscriptionResult getSubscriptionResult) {
        if (this.mListener == null) {
            return;
        }
        this.mSubscriptionResult = getSubscriptionResult;
        if (this.mCategory == 1) {
            this.mListener.onResult(null, getSubscriptionResult);
        } else if (this.mShieldResult != null) {
            this.mListener.onResult(this.mShieldResult, getSubscriptionResult);
        }
    }
}
