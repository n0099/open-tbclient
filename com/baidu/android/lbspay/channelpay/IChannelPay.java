package com.baidu.android.lbspay.channelpay;

import android.app.Activity;
import com.baidu.android.lbspay.network.GetPayContent;
/* loaded from: classes2.dex */
public interface IChannelPay {
    public static final String BAIDU_CHANNEL_ALIAS = "BAIDU-BAIFUBAO-WISE-CARD";
    public static final int ID_ALI_PAY = 105;
    public static final int ID_BAIDU_PAY = 126;
    public static final int ID_BAIFUBAO_WISE_CARD = -2;
    public static final int ID_BANK_CARD_PAY = 178;
    public static final int ID_CARD_PAY = -1;
    public static final int ID_FAST_PAY = 107;
    public static final int ID_IPAY_PAY_GAME = 164;
    public static final int ID_IPAY_PAY_RECHARGEABLE_CARD = 163;
    public static final int ID_IPAY_PAY_SMS = 165;
    public static final int ID_IPAY_PAY_VIRTUALBALANCE = 166;
    public static final int ID_KUAIQIAN_CARD = -3;
    public static final int ID_SMS_PAY = 175;
    public static final int ID_WX_PAY = 158;
    public static final String KUAIQIAN_CHANNEL_ALIAS = "BAIDU-QUICKPAY-WISE";

    /* loaded from: classes2.dex */
    public enum State {
        Init,
        Paying,
        PayEnd
    }

    int getChannelId();

    PayDataBean getPayData(GetPayContent getPayContent);

    State getState();

    void pay(Activity activity, Activity activity2, GetPayContent getPayContent);

    void pay(Activity activity, GetPayContent getPayContent);

    void payCancel();

    void payError(String str, String str2);

    void paySuccess(String str);

    void paying();
}
