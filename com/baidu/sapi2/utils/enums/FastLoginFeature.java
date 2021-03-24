package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public enum FastLoginFeature {
    TX_WEIXIN_SSO(a.f11478a),
    SINA_WEIBO_SSO(a.f11479b),
    SINA_WEIBO_WEBVIEW("tsina"),
    TX_QQ_SSO(a.f11481d),
    QR_LOGIN(a.f11482e),
    HUAWEI_LOGIN(a.f11483f),
    GLORY_LOGIN(a.f11484g),
    MEIZU_SSO(a.f11485h),
    XIAOMI_SSO(a.i),
    YY_SSO(a.j);
    

    /* renamed from: a  reason: collision with root package name */
    public String f11477a;

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f11478a = "tweixin_sso";

        /* renamed from: b  reason: collision with root package name */
        public static final String f11479b = "tsina_sso";

        /* renamed from: c  reason: collision with root package name */
        public static final String f11480c = "tsina";

        /* renamed from: d  reason: collision with root package name */
        public static final String f11481d = "qq_sso";

        /* renamed from: e  reason: collision with root package name */
        public static final String f11482e = "qr_app_login";

        /* renamed from: f  reason: collision with root package name */
        public static final String f11483f = "huawei_login";

        /* renamed from: g  reason: collision with root package name */
        public static final String f11484g = "glory_login";

        /* renamed from: h  reason: collision with root package name */
        public static final String f11485h = "meizu_sso";
        public static final String i = "xiaomi_sso";
        public static final String j = "yy";
    }

    FastLoginFeature(String str) {
        this.f11477a = str;
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
        return this.f11477a;
    }
}
