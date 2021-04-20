package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public enum FastLoginFeature {
    TX_WEIXIN_SSO(a.f11063a),
    SINA_WEIBO_SSO(a.f11064b),
    SINA_WEIBO_WEBVIEW("tsina"),
    TX_QQ_SSO(a.f11066d),
    QR_LOGIN(a.f11067e),
    HUAWEI_LOGIN(a.f11068f),
    GLORY_LOGIN(a.f11069g),
    MEIZU_SSO(a.f11070h),
    XIAOMI_SSO(a.i),
    YY_SSO(a.j);
    

    /* renamed from: a  reason: collision with root package name */
    public String f11062a;

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f11063a = "tweixin_sso";

        /* renamed from: b  reason: collision with root package name */
        public static final String f11064b = "tsina_sso";

        /* renamed from: c  reason: collision with root package name */
        public static final String f11065c = "tsina";

        /* renamed from: d  reason: collision with root package name */
        public static final String f11066d = "qq_sso";

        /* renamed from: e  reason: collision with root package name */
        public static final String f11067e = "qr_app_login";

        /* renamed from: f  reason: collision with root package name */
        public static final String f11068f = "huawei_login";

        /* renamed from: g  reason: collision with root package name */
        public static final String f11069g = "glory_login";

        /* renamed from: h  reason: collision with root package name */
        public static final String f11070h = "meizu_sso";
        public static final String i = "xiaomi_sso";
        public static final String j = "yy";
    }

    FastLoginFeature(String str) {
        this.f11062a = str;
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
        return this.f11062a;
    }
}
