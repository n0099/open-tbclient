package com.baidu.sapi2.utils.enums;
/* loaded from: classes.dex */
public enum FastLoginFeature {
    SINA_WEIBO_SSO("tsina_sso"),
    SINA_WEIBO_WEBVIEW("tsina"),
    TX_WEIBO_WEBVIEW("tqq"),
    TX_QQ_WEBVIEW("qzone"),
    RENREN_WEBVIEW("renren"),
    QR_LOGIN("qr_login");
    
    private String a;

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
