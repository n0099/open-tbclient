package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.h;
/* loaded from: classes2.dex */
public enum Domain {
    DOMAIN_ONLINE("aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", h.f11510b, h.f11511c, h.f11512d, h.f11513e),
    DOMAIN_QA(h.f11514f, h.f11515g, h.f11516h, h.i, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==");
    

    /* renamed from: a  reason: collision with root package name */
    public String f11471a;

    /* renamed from: b  reason: collision with root package name */
    public String f11472b;

    /* renamed from: c  reason: collision with root package name */
    public String f11473c;

    /* renamed from: d  reason: collision with root package name */
    public String f11474d;

    /* renamed from: e  reason: collision with root package name */
    public String f11475e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11476f;

    Domain(String str, String str2, String str3, String str4, String str5) {
        this.f11471a = h.a(str);
        this.f11472b = h.a(str2);
        this.f11473c = h.a(str3);
        this.f11474d = h.a(str4);
        this.f11475e = h.a(str5);
    }

    public Domain forceHttps(boolean z) {
        this.f11476f = z;
        return this;
    }

    public String getConfigHttpsUrl() {
        return this.f11474d;
    }

    public String getDeviceUrl() {
        return this.f11473c;
    }

    public String getPortraitUrl() {
        return this.f11475e;
    }

    public String getURL() {
        return getURL(SapiUtils.getDefaultHttpsEnabled());
    }

    public String getUrlDomain() {
        return getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
    }

    public String getWap() {
        if ((equals(DOMAIN_ONLINE) && SapiUtils.getDefaultHttpsEnabled()) || (!equals(DOMAIN_ONLINE) && this.f11476f)) {
            return this.f11472b.replace("http://", "https://");
        }
        return this.f11472b;
    }

    public String getWapDomain() {
        return getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
    }

    public String getURL(boolean z) {
        if ((equals(DOMAIN_ONLINE) && z) || (!equals(DOMAIN_ONLINE) && this.f11476f)) {
            return this.f11471a.replace("http://", "https://");
        }
        return this.f11471a;
    }
}
