package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes.dex */
public enum FastLoginFeature {
    TX_WEIXIN_SSO("tweixin_sso"),
    SINA_WEIBO_SSO("tsina_sso"),
    SINA_WEIBO_WEBVIEW("tsina"),
    TX_QQ_SSO("qq_sso"),
    QR_LOGIN("qr_app_login"),
    HUAWEI_LOGIN("huawei_login"),
    MEIZU_SSO("meizu_sso");
    
    private String a;

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

    public static FastLoginFeature getDefault() {
        return SINA_WEIBO_SSO;
    }

    FastLoginFeature(String str) {
        this.a = str;
    }

    public String getStrValue() {
        return this.a;
    }
}
