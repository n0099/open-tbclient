package com.baidu.android.lbspay.channelpay.wxpay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class ChannelWXPay extends AbstractChannelPay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int WX_PAY_CANCLE = -2;
    public static final int WX_PAY_FAILED = -1;
    public static final int WX_PAY_SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.lbspay.channelpay.wxpay.ChannelWXPay$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static ChannelWXPay f36842a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(687801150, "Lcom/baidu/android/lbspay/channelpay/wxpay/ChannelWXPay$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(687801150, "Lcom/baidu/android/lbspay/channelpay/wxpay/ChannelWXPay$a;");
                    return;
                }
            }
            f36842a = new ChannelWXPay(null);
        }
    }

    public /* synthetic */ ChannelWXPay(AnonymousClass1 anonymousClass1) {
        this();
    }

    private PayReq genPayReq(PayDataBean payDataBean) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, payDataBean)) == null) {
            PayReq payReq = new PayReq();
            payReq.appId = payDataBean.appid;
            payReq.partnerId = payDataBean.partnerid;
            payReq.prepayId = payDataBean.prepayid;
            payReq.packageValue = payDataBean.packagealias;
            payReq.nonceStr = payDataBean.noncestr;
            payReq.timeStamp = payDataBean.timestamp;
            payReq.sign = payDataBean.sign;
            return payReq;
        }
        return (PayReq) invokeL.objValue;
    }

    public static ChannelWXPay getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f36842a : (ChannelWXPay) invokeV.objValue;
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public int getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 158;
        }
        return invokeV.intValue;
    }

    public void handlerPayResult(Context context, BaseResp baseResp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, baseResp) == null) {
            if (baseResp == null) {
                GlobalUtils.toast(context, "微信返回失败");
                payCancel();
                return;
            }
            int i2 = baseResp.errCode;
            String str = "";
            if (i2 == 0) {
                paySuccess("");
            } else if (i2 == -1) {
                try {
                    str = String.valueOf(i2);
                } catch (Exception unused) {
                }
                payError(str, baseResp.errStr);
            } else if (i2 == -2) {
                payCancel();
            }
        }
    }

    public void handlerPayResultBundle(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bundle) == null) || bundle == null) {
            return;
        }
        handlerPayResult(context, new PayResp(bundle));
    }

    @Override // com.baidu.android.lbspay.channelpay.AbstractChannelPay, com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(Activity activity, GetPayContent getPayContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, activity, getPayContent) == null) {
            super.pay(activity, getPayContent);
            PayDataBean payData = getPayData(getPayContent);
            PayReq genPayReq = payData != null ? genPayReq(payData) : null;
            if (genPayReq != null && !TextUtils.isEmpty(genPayReq.appId)) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(activity, null);
                if (createWXAPI == null) {
                    payError("-1", ResUtils.getString(activity, "lbspay_wx_start_failed"));
                    return;
                }
                createWXAPI.registerApp(genPayReq.appId);
                if (createWXAPI.isWXAppInstalled()) {
                    if (createWXAPI.sendReq(genPayReq)) {
                        return;
                    }
                    payError("-1", ResUtils.getString(activity, "lbspay_wx_start_failed"));
                    return;
                }
                payError("-1", ResUtils.getString(activity, "lbspay_wx_not_installed"));
                return;
            }
            payError("-1", ResUtils.getString(activity, "lbspay_wx_getpay_failed"));
        }
    }

    public ChannelWXPay() {
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
