package com.baidu.android.lbspay;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.presenter.JuheH5PayResultProcess;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.statistics.api.StatisticManager;
/* loaded from: classes.dex */
public class LBSPayResult {
    public static String ACTION_EXIT = "com.baidu.android.lbspay.EXIT";
    public String mOrderInfo;
    public String mOrderNo;
    public String mStateCode;

    public static void payResult(Context context, int i2, String str) {
        payResult(context, i2, str, null);
    }

    public static void payResult(Context context, int i2, String str, AbstractChannelPay abstractChannelPay) {
        GetPayBean payBean;
        GetPayContent payResponse;
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
        LogUtil.logd("result=" + stringBuffer2);
        if (abstractChannelPay != null && context != null && (payBean = abstractChannelPay.getPayBean()) != null && (payResponse = abstractChannelPay.getPayResponse()) != null) {
            JuheH5PayResultProcess juheH5PayResultProcess = new JuheH5PayResultProcess(context, payResponse.pay_result_url, payResponse.pay_result_param, payBean, stringBuffer2);
            juheH5PayResultProcess.beforeShow();
            juheH5PayResultProcess.show();
            return;
        }
        Intent intent = new Intent(ACTION_EXIT);
        LBSPayBack callBack = LBSPayInner.getInstance().getCallBack();
        if (callBack != null) {
            LogUtil.logd("callback 不为空");
            if (context != null) {
                try {
                    StatisticManager.onEvent(StatServiceEvent.EVENT_API_ONPAYRESULT);
                } catch (Exception e2) {
                    LogUtil.e("Pay", "call back error", e2);
                }
            }
            callBack.onPayResult(i2, stringBuffer2);
        } else {
            LogUtil.logd("callback 为空");
        }
        LBSPayInner.getInstance().clearLbsPayBack();
        if (context != null) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }
}
