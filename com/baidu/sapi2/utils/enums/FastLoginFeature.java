package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes.dex */
public enum FastLoginFeature {
    SINA_WEIBO_SSO("tsina_sso"),
    SINA_WEIBO_WEBVIEW("tsina"),
    TX_WEIBO_WEBVIEW("tqq"),
    TX_QQ_WEBVIEW("qzone"),
    RENREN_WEBVIEW("renren"),
    DEVICE_LOGIN("device_login"),
    QR_LOGIN("qr_app_login"),
    NM_LOGIN("nm_login"),
    VOICE_LOGIN("voice_login");
    
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
