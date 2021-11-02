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
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ChannelAliPay extends AbstractChannelPay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_AILI_PAY = 100;
    public static final int MSG_AILI_PAYV2 = 101;
    public static final int PAY_VERSION = 2;
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
            public final /* synthetic */ ChannelAliPay f34886a;

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
                this.f34886a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                String str2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (i4 == 100 || i4 == 101) {
                        List<String> collectData = StatHelper.collectData(StatHelper.getOrderId(), StatHelper.getAlipayVersion());
                        HashMap hashMap = new HashMap();
                        hashMap.put("pay_amount", StatHelper.getPayAmount());
                        Object obj = message.obj;
                        String str3 = "";
                        String str4 = (obj == null || !(obj instanceof String)) ? "" : (String) obj;
                        if (message.what == 100) {
                            Result result = new Result(str4);
                            str2 = result.resultStatus;
                            str = result.result;
                            str3 = result.memo;
                        } else {
                            try {
                                JSONObject jSONObject = new JSONObject(str4);
                                str2 = jSONObject.optString("resultStatus");
                                str = jSONObject.optString("result");
                                str3 = jSONObject.optString("memo");
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                                str = EventAlias.PayEventAlias.PAY_FAIL;
                                this.f34886a.payError(Result.RESULT_FAILED, EventAlias.PayEventAlias.PAY_FAIL);
                                str2 = Result.RESULT_FAILED;
                            }
                        }
                        if (Result.RESULT_SUCCESS.equals(str2)) {
                            this.f34886a.paySuccess(str);
                        } else if (Result.RESULT_CANCLE.equals(str2)) {
                            this.f34886a.payCancel();
                        } else if ("8000".equals(str2)) {
                            this.f34886a.paying();
                        } else if (Result.RESULT_NETWROK_ERROR.equals(str2)) {
                            this.f34886a.payError(Result.RESULT_NETWROK_ERROR, "网络连接出错");
                        } else {
                            this.f34886a.payError(Result.RESULT_FAILED, str3);
                        }
                        collectData.add(str2);
                        if (TextUtils.isEmpty(str)) {
                            collectData.add(str3);
                        } else {
                            collectData.add(str);
                        }
                        StatisticManager.onEventWithValues(PayStatServiceEvent.ALIPAY_RESULT, collectData, hashMap);
                    }
                }
            }
        };
    }

    private void startAlipay(Activity activity, String str, PayDataBean payDataBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, activity, str, payDataBean) == null) {
            this.mHandler = new Handler();
            new Thread(this, activity, payDataBean, str) { // from class: com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f34887a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PayDataBean f34888b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f34889c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ ChannelAliPay f34890d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, payDataBean, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34890d = this;
                    this.f34887a = activity;
                    this.f34888b = payDataBean;
                    this.f34889c = str;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisticManager.onEventStart(StatServiceEvent.LBS_ALIPAY);
                        PayTask payTask = new PayTask(this.f34887a);
                        Message message = new Message();
                        List<String> collectData = StatHelper.collectData(StatHelper.getOrderId(), new String[0]);
                        HashMap hashMap = new HashMap();
                        hashMap.put("pay_amount", StatHelper.getPayAmount());
                        PayDataBean payDataBean2 = this.f34888b;
                        int i2 = 1;
                        if (payDataBean2 != null && 2 == payDataBean2.alipayVersion) {
                            LogUtil.d("alipay:", "alipayV2");
                            int i3 = this.f34888b.alipayVersion;
                            message.obj = new JSONObject(payTask.payV2(this.f34889c, true)).toString();
                            message.what = 101;
                            i2 = i3;
                        } else {
                            LogUtil.d("alipay:", "alipayV1");
                            message.obj = payTask.pay(this.f34889c, true);
                            message.what = 100;
                        }
                        collectData.add(i2 + "");
                        StatHelper.cacheAlipayVersion(i2 + "");
                        StatisticManager.onEventWithValues(PayStatServiceEvent.ALIPAY_ENTER, collectData, hashMap);
                        this.f34890d.mAliPayChannelHandler.sendMessage(message);
                    }
                }
            }.start();
        }
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
            startAlipay(activity, (payData == null || TextUtils.isEmpty(payData.appurl)) ? "" : payData.appurl, payData);
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
            startAlipay(activity2, (payData == null || TextUtils.isEmpty(payData.appurl)) ? "" : payData.appurl, payData);
        }
    }
}
