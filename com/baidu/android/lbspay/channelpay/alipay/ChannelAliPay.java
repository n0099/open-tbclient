package com.baidu.android.lbspay.channelpay.alipay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.app.PayTask;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.statistics.LbsStatistics;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.statistics.api.StatisticManager;
/* loaded from: classes.dex */
public class ChannelAliPay extends AbstractChannelPay {
    public static final int MSG_AILI_PAY = 100;
    @SuppressLint({"HandlerLeak"})
    public Handler mAliPayChannelHandler = new Handler() { // from class: com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                Object obj = message.obj;
                Result result = new Result((obj == null || !(obj instanceof String)) ? "" : (String) obj);
                if (Result.RESULT_SUCCESS.equals(result.resultStatus)) {
                    ChannelAliPay.this.paySuccess(result.result);
                } else if (Result.RESULT_CANCLE.equals(result.resultStatus)) {
                    ChannelAliPay.this.payCancel();
                } else if ("8000".equals(result.resultStatus)) {
                    ChannelAliPay.this.paying();
                } else if (Result.RESULT_NETWROK_ERROR.equals(result.resultStatus)) {
                    ChannelAliPay.this.payError(Result.RESULT_NETWROK_ERROR, "网络连接出错");
                } else {
                    ChannelAliPay.this.payError(Result.RESULT_FAILED, result.memo);
                }
            }
        }
    };
    public LBSPayAli.INoSupportAliAuthorizePay mAliPayNoSupportCallBack;
    public Handler mHandler;
    public int mPayTag;

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public int getChannelId() {
        return this.mPayTag;
    }

    public String getUrl(GetPayContent getPayContent) {
        return getPayContent.payurl;
    }

    @Override // com.baidu.android.lbspay.channelpay.AbstractChannelPay, com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(final Activity activity, GetPayContent getPayContent) {
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
        final String str = (payData == null || TextUtils.isEmpty(payData.appurl)) ? "" : payData.appurl;
        this.mHandler = new Handler();
        new Thread() { // from class: com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                StatisticManager.onEventStart(StatServiceEvent.LBS_ALIPAY);
                String pay = new PayTask(activity).pay(str, true);
                Message message = new Message();
                message.what = 100;
                message.obj = pay;
                ChannelAliPay.this.mAliPayChannelHandler.sendMessage(message);
            }
        }.start();
    }

    public void setAliPayNoSupportCallBack(LBSPayAli.INoSupportAliAuthorizePay iNoSupportAliAuthorizePay) {
        this.mAliPayNoSupportCallBack = iNoSupportAliAuthorizePay;
    }

    @Override // com.baidu.android.lbspay.channelpay.AbstractChannelPay, com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(Activity activity, final Activity activity2, GetPayContent getPayContent) {
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
        final String str = (payData == null || TextUtils.isEmpty(payData.appurl)) ? "" : payData.appurl;
        this.mHandler = new Handler();
        new Thread() { // from class: com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                StatisticManager.onEventStart(LbsStatistics.LBS_ALIPAY);
                String pay = new PayTask(activity2).pay(str, true);
                Message message = new Message();
                message.what = 100;
                message.obj = pay;
                ChannelAliPay.this.mAliPayChannelHandler.sendMessage(message);
            }
        }.start();
    }
}
