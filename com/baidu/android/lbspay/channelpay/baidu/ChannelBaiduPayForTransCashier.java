package com.baidu.android.lbspay.channelpay.baidu;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.pay.PayCallBack;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ChannelBaiduPayForTransCashier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static ChannelBaiduPayForTransCashier a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-155396990, "Lcom/baidu/android/lbspay/channelpay/baidu/ChannelBaiduPayForTransCashier$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-155396990, "Lcom/baidu/android/lbspay/channelpay/baidu/ChannelBaiduPayForTransCashier$a;");
                    return;
                }
            }
            a = new ChannelBaiduPayForTransCashier();
        }
    }

    public static ChannelBaiduPayForTransCashier getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (ChannelBaiduPayForTransCashier) invokeV.objValue;
    }

    private String getNotify(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void handlepayResult(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, this, context, i2, str) == null) {
            if (i2 == 0) {
                paySuccess(context, str);
            } else if (i2 == 1) {
                paying(context);
            } else if (i2 != 2) {
            } else {
                payCancel(context);
            }
        }
    }

    private void paySuccess(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, context, str) == null) {
            LBSPayResult.payResult(context, 0, getNotify(str));
            StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "success");
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

    public void pay(Context context, String str, PrecashierCreateOrderResponse precashierCreateOrderResponse, CashierDataNew cashierDataNew) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, precashierCreateOrderResponse, cashierDataNew) == null) || TextUtils.isEmpty(str) || precashierCreateOrderResponse == null) {
            return;
        }
        String str2 = StatServiceEvent.LBS_TRANSPARENT_POLYMERPAY;
        StatisticManager.onEventWithValue(str2, cashierDataNew.getCustomId() + "|" + cashierDataNew.getOrderNo());
        StringBuilder sb = new StringBuilder();
        sb.append(WalletLoginHelper.getInstance().getLoginType());
        sb.append("");
        sb.toString();
        WalletLoginHelper.getInstance().getLoginToken();
        BaiduPayDelegate.getInstance().doPrecashierPay(context, str, new PayCallBack(this, context) { // from class: com.baidu.android.lbspay.channelpay.baidu.ChannelBaiduPayForTransCashier.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ChannelBaiduPayForTransCashier f30217b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f30217b = this;
                this.a = context;
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
                    this.f30217b.handlepayResult(this.a, i2, str3);
                }
            }
        }, new HashMap(), precashierCreateOrderResponse, null);
    }

    public void payCancel(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) || context == null) {
            return;
        }
        LBSPayResult.payResult(context, 2, "");
        StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "canncel");
    }

    public void paying(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LBSPayResult.payResult(context, 1, "");
            StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "paying");
        }
    }

    public ChannelBaiduPayForTransCashier() {
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
}
