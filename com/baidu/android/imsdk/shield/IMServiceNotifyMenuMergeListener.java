package com.baidu.android.imsdk.shield;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.android.imsdk.shield.model.GetSubscriptionResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class IMServiceNotifyMenuMergeListener implements IGetSubscriptionListener, IGetShieldAndTopListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCategory;
    public IGetServiceNotifyMenuListener mListener;
    public GetShieldAndTopResult mShieldResult;
    public GetSubscriptionResult mSubscriptionResult;

    public IMServiceNotifyMenuMergeListener(int i2, IGetServiceNotifyMenuListener iGetServiceNotifyMenuListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), iGetServiceNotifyMenuListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mShieldResult = null;
        this.mSubscriptionResult = null;
        this.mListener = iGetServiceNotifyMenuListener;
        this.mCategory = i2;
    }

    @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
    public synchronized void onResult(GetShieldAndTopResult getShieldAndTopResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, getShieldAndTopResult) == null) {
            synchronized (this) {
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
        }
    }

    @Override // com.baidu.android.imsdk.shield.IGetSubscriptionListener
    public synchronized void onResult(GetSubscriptionResult getSubscriptionResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getSubscriptionResult) == null) {
            synchronized (this) {
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
    }
}
