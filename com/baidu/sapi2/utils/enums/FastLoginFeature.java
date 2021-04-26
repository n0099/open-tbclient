package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public enum FastLoginFeature {
    TX_WEIXIN_SSO(SSOLoginType.WEIXIN),
    SINA_WEIBO_SSO(SSOLoginType.SINA_SSO),
    SINA_WEIBO_WEBVIEW("tsina"),
    TX_QQ_SSO(SSOLoginType.QQ),
    QR_LOGIN(SSOLoginType.QR_APP_LOGIN),
    HUAWEI_LOGIN(SSOLoginType.HUAWEI),
    GLORY_LOGIN(SSOLoginType.HONOR),
    MEIZU_SSO(SSOLoginType.MEIZU),
    XIAOMI_SSO(SSOLoginType.XIAOMI),
    YY_SSO(SSOLoginType.YY);
    
    public String mStrValue;

    /* loaded from: classes2.dex */
    public interface SSOLoginType {
        public static final String HONOR = "glory_login";
        public static final String HUAWEI = "huawei_login";
        public static final String MEIZU = "meizu_sso";
        public static final String QQ = "qq_sso";
        public static final String QR_APP_LOGIN = "qr_app_login";
        public static final String SINA_SSO = "tsina_sso";
        public static final String SINA_WEB = "tsina";
        public static final String WEIXIN = "tweixin_sso";
        public static final String XIAOMI = "xiaomi_sso";
        public static final String YY = "yy";
    }

    FastLoginFeature(String str) {
        this.mStrValue = str;
    }

    public static FastLoginFeature getDefault() {
        return SINA_WEIBO_SSO;
    }

    public static FastLoginFeature mapStrToValue(String str) {
        FastLoginFeature[] values;
        if (TextUtils.isEmpty(str)) {
            return getDefault();
        }
        for (FastLoginFeature fastLoginFeature : values()) {
            if (str.equals(fastLoginFeature.getStrValue())) {
                return fastLoginFeature;
            }
        }
        return getDefault();
    }

    public String getStrValue() {
        return this.mStrValue;
    }
}
