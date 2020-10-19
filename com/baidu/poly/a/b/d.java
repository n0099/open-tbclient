package com.baidu.poly.a.b;
/* loaded from: classes6.dex */
public final class d {
    private static final String getDomain() {
        return a.q() != 1 ? "https://trade.baidu-int.com/sandbox/tradegateway" : "https://etrade-api.baidu.com";
    }

    public static final String r() {
        return getDomain() + "/cps/user/recordBatch/sapp";
    }

    public static final String t() {
        return getDomain() + "/cashier/calcMoney";
    }

    public static final String u() {
        return getDomain() + "/cashier/channelAllInfo";
    }

    public static final String w() {
        return getDomain() + "/cps/user/record/sapp";
    }

    public static final String x() {
        return getDomain() + "/cashier/launchpayment";
    }

    public static final String y() {
        return getDomain() + "/cashier/pay";
    }

    public static final String z() {
        return getDomain() + "/cashier/sdkAdaptH5QueryPay";
    }
}
