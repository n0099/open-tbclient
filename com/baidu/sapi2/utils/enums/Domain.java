package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.f;
/* loaded from: classes6.dex */
public enum Domain {
    DOMAIN_ONLINE("aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", f.b, f.c, f.d, f.e),
    DOMAIN_QA(f.f, f.g, f.h, f.i, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==");
    

    /* renamed from: a  reason: collision with root package name */
    private String f3550a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;

    Domain(String str, String str2, String str3, String str4, String str5) {
        this.f3550a = f.a(str);
        this.b = f.a(str2);
        this.c = f.a(str3);
        this.d = f.a(str4);
        this.e = f.a(str5);
    }

    public Domain forceHttps(boolean z) {
        this.f = z;
        return this;
    }

    public String getConfigHttpsUrl() {
        return this.d;
    }

    public String getDeviceUrl() {
        return this.c;
    }

    public String getPortraitUrl() {
        return this.e;
    }

    public String getURL() {
        return getURL(SapiUtils.getDefaultHttpsEnabled());
    }

    public String getUrlDomain() {
        return getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
    }

    public String getWap() {
        return (!(equals(DOMAIN_ONLINE) && SapiUtils.getDefaultHttpsEnabled()) && (equals(DOMAIN_ONLINE) || !this.f)) ? this.b : this.b.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public String getWapDomain() {
        return getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
    }

    public String getURL(boolean z) {
        return (!(equals(DOMAIN_ONLINE) && z) && (equals(DOMAIN_ONLINE) || !this.f)) ? this.f3550a : this.f3550a.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }
}
