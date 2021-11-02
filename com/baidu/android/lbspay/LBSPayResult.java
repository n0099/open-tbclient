package com.baidu.android.lbspay;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.presenter.JuheH5PayResultProcess;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class LBSPayResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ACTION_EXIT = "com.baidu.android.lbspay.EXIT";
    public transient /* synthetic */ FieldHolder $fh;
    public String mOrderInfo;
    public String mOrderNo;
    public String mStateCode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(59400157, "Lcom/baidu/android/lbspay/LBSPayResult;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(59400157, "Lcom/baidu/android/lbspay/LBSPayResult;");
        }
    }

    public LBSPayResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void payResult(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, context, i2, str) == null) {
            payResult(context, i2, str, null);
        }
    }

    public static void payResult(Context context, int i2, String str, AbstractChannelPay abstractChannelPay) {
        GetPayBean payBean;
        GetPayContent payResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65539, null, context, i2, str, abstractChannelPay) == null) {
            List<String> collectData = StatHelper.collectData(StatHelper.getOrderId(), StatHelper.getChannelId());
            HashMap hashMap = new HashMap();
            hashMap.put("pay_amount", StatHelper.getPayAmount());
            if (i2 == 0) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_SUCCESS, collectData, hashMap);
            } else if (i2 == 1) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_PAYING, collectData, hashMap);
            } else if (i2 == 2) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_CANCEL, collectData, hashMap);
            } else {
                StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_ERROR, collectData, hashMap);
            }
            String orderNo = LBSPayInner.getInstance().getOrderNo();
            if (orderNo == null) {
                orderNo = "";
            }
            if (str == null) {
                str = "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("statecode={");
            stringBuffer.append(String.valueOf(i2));
            stringBuffer.append("};");
            stringBuffer.append("order_no={");
            stringBuffer.append(orderNo);
            stringBuffer.append("};");
            stringBuffer.append("notify={");
            stringBuffer.append(str);
            stringBuffer.append("};");
            String stringBuffer2 = stringBuffer.toString();
            String str2 = "result=" + stringBuffer2;
            if (abstractChannelPay != null && context != null && (payBean = abstractChannelPay.getPayBean()) != null && (payResponse = abstractChannelPay.getPayResponse()) != null) {
                JuheH5PayResultProcess juheH5PayResultProcess = new JuheH5PayResultProcess(context, payResponse.pay_result_url, payResponse.pay_result_param, payBean, stringBuffer2);
                juheH5PayResultProcess.beforeShow();
                juheH5PayResultProcess.show();
                return;
            }
            Intent intent = new Intent(ACTION_EXIT);
            LBSPayBack callBack = LBSPayInner.getInstance().getCallBack();
            if (callBack != null) {
                if (context != null) {
                    try {
                        StatisticManager.onEvent("#onPayResult");
                    } catch (Exception e2) {
                        LogUtil.e("Pay", "call back error", e2);
                    }
                }
                callBack.onPayResult(i2, stringBuffer2);
            }
            LBSPayInner.getInstance().clearLbsPayBack();
            if (context != null) {
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        }
    }
}
