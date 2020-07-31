package com.baidu.live.tbadk.pay;

import android.content.Context;
import com.baidu.live.tbadk.pay.channel.PayChannelManager;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
/* loaded from: classes4.dex */
public class PayHelper {
    public static final int PAY_CANCEL = 1;
    public static final int PAY_FAIL_GET_ORDER = 3;
    public static final int PAY_FAIL_RETRY = 6;
    public static final int PAY_FAIL_VALIDATE_PAY = 4;
    public static final int PAY_FAIL_WALLET = 5;
    public static final int PAY_FAIL_WRONG_PAYCONFIG = 2;
    public static final int PAY_SUCC = 0;
    public static final String STATUS_CANCEL = "1000";
    public static final String STATUS_CANCEL_DESC = "取消";
    public static final String STATUS_FAIL = "1002";
    public static final String STATUS_FAIL_DESC = "失败";
    public static final String STATUS_SUCC = "1001";
    public static final String STATUS_SUCC_DESC = "成功";
    public static final String STATUS_TIMEOUT = "1003";
    public static final String STATUS_TIMEOUT_DESC = "超时";

    public static void notifyPayResult(String str, String str2, String str3, Context context, boolean z, PayChannelType payChannelType) {
        IPayChannel buildPayChannel = PayChannelManager.getInstance().buildPayChannel(payChannelType);
        if (buildPayChannel != null) {
            buildPayChannel.onPayResult(str, str2, str3, context, z);
        }
    }
}
