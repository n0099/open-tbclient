package com.baidu.android.lbspay.channelpay.baidu;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.activity.LBSTransCashierActivity;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.pay.PayCallBack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class ChannelBaiduPay extends AbstractChannelPay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CashierDataNew mOrderInfo;
    public WeakReference<Activity> mWeakReference;

    public ChannelBaiduPay() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String gatValue(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String str3 = str2 + "={";
            return str.substring(str.indexOf(str3) + str3.length(), str.indexOf("}"));
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public int getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 126;
        }
        return invokeV.intValue;
    }

    public String getNotify(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String str2 = "";
            if (!TextUtils.isEmpty(str)) {
                try {
                    for (String str3 : str.split(";")) {
                        if (str3.startsWith("notify")) {
                            str2 = gatValue(str3, "notify");
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public void handlepayResult(int i2, String str) {
        CashierDataNew cashierDataNew;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            if (i2 == 0) {
                paySuccess(getNotify(str));
            } else if (i2 != 1) {
                payCancel();
                WeakReference<Activity> weakReference = this.mWeakReference;
                Activity activity = weakReference == null ? null : weakReference.get();
                if (activity == null || (cashierDataNew = this.mOrderInfo) == null || !cashierDataNew.isShowAllPayType()) {
                    return;
                }
                Intent intent = new Intent(activity, LBSTransCashierActivity.class);
                intent.setFlags(268435456);
                intent.putExtra(CashierDataNew.DELIVERY_CASHIER_DATA, this.mOrderInfo);
                activity.startActivity(intent);
            } else {
                paying();
            }
        }
    }

    @Override // com.baidu.android.lbspay.channelpay.AbstractChannelPay, com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(Activity activity, GetPayContent getPayContent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, getPayContent) == null) {
            this.mWeakReference = new WeakReference<>(activity);
            if (getPayContent != null) {
                this.mOrderInfo = getPayContent.extraOrderInfo;
            }
            super.pay(activity, getPayContent);
            boolean z = true;
            if (getPayContent != null && getPayContent.checkResponseValidity()) {
                HashMap hashMap = new HashMap();
                PayDataBean payData = getPayData(getPayContent);
                if (payData != null) {
                    String str2 = payData.params;
                    if (payData.isBaifubaoAuthPay()) {
                        hashMap.put("pay_from", BaiduPay.PAY_FROM_AUTHORIZE);
                    }
                    str = str2;
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    StatHelper.cachePayFrom("2");
                    PrecashierCreateOrderResponse precashierCreateOrderResponse = getPayContent.sdk_info;
                    if (precashierCreateOrderResponse != null) {
                        if (!TextUtils.isEmpty(precashierCreateOrderResponse.ret) && getPayContent.sdk_info.ret.equals(String.valueOf(5003))) {
                            AccountManager.getInstance(activity).logout();
                            WalletLoginHelper.getInstance().logout(false);
                            WalletLoginHelper.getInstance().handlerWalletError(5003);
                            if (!TextUtils.isEmpty(getPayContent.sdk_info.msg)) {
                                GlobalUtils.toast(activity, getPayContent.sdk_info.msg);
                            }
                        } else {
                            StatisticManager.onEventWithValue(StatServiceEvent.LBS_PREPAY_RESULET, "1");
                            BaiduPayDelegate.getInstance().doPrecashierPay(activity, str, new PayCallBack(this) { // from class: com.baidu.android.lbspay.channelpay.baidu.ChannelBaiduPay.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ ChannelBaiduPay a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                @Override // com.baidu.android.pay.PayCallBack
                                public boolean isHideLoadingDialog() {
                                    InterceptResult invokeV;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                        return false;
                                    }
                                    return invokeV.booleanValue;
                                }

                                @Override // com.baidu.android.pay.PayCallBack
                                public void onPayResult(int i2, String str3) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) {
                                        this.a.handlepayResult(i2, str3);
                                    }
                                }
                            }, hashMap, getPayContent.sdk_info, null);
                        }
                    } else {
                        StatisticManager.onEventWithValue(StatServiceEvent.LBS_PREPAY_RESULET, "0");
                        BaiduPayDelegate.getInstance().doPay(activity, str, new PayCallBack(this) { // from class: com.baidu.android.lbspay.channelpay.baidu.ChannelBaiduPay.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ChannelBaiduPay a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // com.baidu.android.pay.PayCallBack
                            public boolean isHideLoadingDialog() {
                                InterceptResult invokeV;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                    return false;
                                }
                                return invokeV.booleanValue;
                            }

                            @Override // com.baidu.android.pay.PayCallBack
                            public void onPayResult(int i2, String str3) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) {
                                    this.a.handlepayResult(i2, str3);
                                }
                            }
                        }, hashMap);
                    }
                    z = false;
                }
            }
            if (z && this.mNotifyOnError) {
                payCancel();
            }
        }
    }
}
