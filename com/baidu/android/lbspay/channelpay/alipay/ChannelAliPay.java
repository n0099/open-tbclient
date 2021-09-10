package com.baidu.android.lbspay.channelpay.alipay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.app.PayTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.statistics.LbsStatistics;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
/* loaded from: classes4.dex */
public class ChannelAliPay extends AbstractChannelPay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_AILI_PAY = 100;
    public transient /* synthetic */ FieldHolder $fh;
    @SuppressLint({"HandlerLeak"})
    public Handler mAliPayChannelHandler;
    public LBSPayAli.INoSupportAliAuthorizePay mAliPayNoSupportCallBack;
    public Handler mHandler;
    public int mPayTag;

    public ChannelAliPay() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAliPayChannelHandler = new Handler(this) { // from class: com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ChannelAliPay f36781a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36781a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 100) {
                    Object obj = message.obj;
                    Result result = new Result((obj == null || !(obj instanceof String)) ? "" : (String) obj);
                    if (Result.RESULT_SUCCESS.equals(result.resultStatus)) {
                        this.f36781a.paySuccess(result.result);
                    } else if (Result.RESULT_CANCLE.equals(result.resultStatus)) {
                        this.f36781a.payCancel();
                    } else if ("8000".equals(result.resultStatus)) {
                        this.f36781a.paying();
                    } else if (Result.RESULT_NETWROK_ERROR.equals(result.resultStatus)) {
                        this.f36781a.payError(Result.RESULT_NETWROK_ERROR, "网络连接出错");
                    } else {
                        this.f36781a.payError(Result.RESULT_FAILED, result.memo);
                    }
                }
            }
        };
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public int getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPayTag : invokeV.intValue;
    }

    public String getUrl(GetPayContent getPayContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getPayContent)) == null) ? getPayContent.payurl : (String) invokeL.objValue;
    }

    @Override // com.baidu.android.lbspay.channelpay.AbstractChannelPay, com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(Activity activity, GetPayContent getPayContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, activity, getPayContent) == null) {
            super.pay(activity, getPayContent);
            this.mPayTag = 105;
            PayDataBean payData = getPayData(getPayContent);
            if (payData != null && payData.isAliAuthPay()) {
                if (LBSPayAli.getInstance().aliAuthorizePay(activity, payData.auth_appurl, this)) {
                    return;
                }
                LBSPayAli.INoSupportAliAuthorizePay iNoSupportAliAuthorizePay = this.mAliPayNoSupportCallBack;
                if (iNoSupportAliAuthorizePay != null) {
                    iNoSupportAliAuthorizePay.onNoSupportAliAuthorizePay();
                    return;
                }
                StatisticManager.onEvent(LbsStatistics.WALLET_LBS_FRONT_CASHIER_ALI_AUTHORIZE_PAY_CANCEL);
                LBSPayResult.payResult(activity, 2, ResUtils.getString(activity, "lbspay_pay_guide_install_ali_pay_pkg_msg"));
                return;
            }
            String str = (payData == null || TextUtils.isEmpty(payData.appurl)) ? "" : payData.appurl;
            this.mHandler = new Handler();
            new Thread(this, activity, str) { // from class: com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f36782a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f36783b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ChannelAliPay f36784c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36784c = this;
                    this.f36782a = activity;
                    this.f36783b = str;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisticManager.onEventStart(StatServiceEvent.LBS_ALIPAY);
                        String pay = new PayTask(this.f36782a).pay(this.f36783b, true);
                        Message message = new Message();
                        message.what = 100;
                        message.obj = pay;
                        this.f36784c.mAliPayChannelHandler.sendMessage(message);
                    }
                }
            }.start();
        }
    }

    public void setAliPayNoSupportCallBack(LBSPayAli.INoSupportAliAuthorizePay iNoSupportAliAuthorizePay) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iNoSupportAliAuthorizePay) == null) {
            this.mAliPayNoSupportCallBack = iNoSupportAliAuthorizePay;
        }
    }

    @Override // com.baidu.android.lbspay.channelpay.AbstractChannelPay, com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(Activity activity, Activity activity2, GetPayContent getPayContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, activity2, getPayContent) == null) {
            super.pay(activity, getPayContent);
            this.mPayTag = 105;
            PayDataBean payData = getPayData(getPayContent);
            if (payData != null && payData.isAliAuthPay()) {
                if (LBSPayAli.getInstance().aliAuthorizePay(activity, payData.auth_appurl, this)) {
                    return;
                }
                StatisticManager.onEvent(LbsStatistics.WALLET_LBS_FRONT_CASHIER_ALI_AUTHORIZE_PAY_CANCEL);
                LBSPayResult.payResult(activity, 2, ResUtils.getString(activity, "lbspay_pay_guide_install_ali_pay_pkg_msg"));
                return;
            }
            String str = (payData == null || TextUtils.isEmpty(payData.appurl)) ? "" : payData.appurl;
            this.mHandler = new Handler();
            new Thread(this, activity2, str) { // from class: com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f36785a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f36786b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ChannelAliPay f36787c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity2, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36787c = this;
                    this.f36785a = activity2;
                    this.f36786b = str;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisticManager.onEventStart(LbsStatistics.LBS_ALIPAY);
                        String pay = new PayTask(this.f36785a).pay(this.f36786b, true);
                        Message message = new Message();
                        message.what = 100;
                        message.obj = pay;
                        this.f36787c.mAliPayChannelHandler.sendMessage(message);
                    }
                }
            }.start();
        }
    }
}
