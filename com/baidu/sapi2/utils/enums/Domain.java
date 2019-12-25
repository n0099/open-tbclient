package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.h;
/* loaded from: classes4.dex */
public enum Domain {
    DOMAIN_ONLINE("aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", h.b, h.c, h.d, h.e),
    DOMAIN_RD(h.f, "aHR0cDovL3dhcHBhc3MtcmR0ZXN0LmJhaWR1LmNvbQ==", h.h, "aHR0cDovL3dhcHBhc3MtcmR0ZXN0LmJhaWR1LmNvbQ==", "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ=="),
    DOMAIN_QA(h.k, h.l, h.m, h.n, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==");
    
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;

    Domain(String str, String str2, String str3, String str4, String str5) {
        this.b = h.a(str);
        this.c = h.a(str2);
        this.d = h.a(str3);
        this.e = h.a(str4);
        this.f = h.a(str5);
    }

    public Domain forceHttps(boolean z) {
        this.g = z;
        return this;
    }

    public String getConfigHttpsUrl() {
        return this.e;
    }

    public String getDeviceUrl() {
        return this.d;
    }

    public String getPortraitUrl() {
        return this.f;
    }

    public String getURL() {
        return getURL(SapiUtils.getDefaultHttpsEnabled());
    }

    public String getWap() {
        return (!(equals(DOMAIN_ONLINE) && SapiUtils.getDefaultHttpsEnabled()) && (equals(DOMAIN_ONLINE) || !this.g)) ? this.c : this.c.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public String getURL(boolean z) {
        return (!(equals(DOMAIN_ONLINE) && z) && (equals(DOMAIN_ONLINE) || !this.g)) ? this.b : this.b.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }
}
