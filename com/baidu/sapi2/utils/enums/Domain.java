package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.h;
/* loaded from: classes2.dex */
public enum Domain {
    DOMAIN_ONLINE("aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", h.f11509b, h.f11510c, h.f11511d, h.f11512e),
    DOMAIN_QA(h.f11513f, h.f11514g, h.f11515h, h.i, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==");
    

    /* renamed from: a  reason: collision with root package name */
    public String f11470a;

    /* renamed from: b  reason: collision with root package name */
    public String f11471b;

    /* renamed from: c  reason: collision with root package name */
    public String f11472c;

    /* renamed from: d  reason: collision with root package name */
    public String f11473d;

    /* renamed from: e  reason: collision with root package name */
    public String f11474e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11475f;

    Domain(String str, String str2, String str3, String str4, String str5) {
        this.f11470a = h.a(str);
        this.f11471b = h.a(str2);
        this.f11472c = h.a(str3);
        this.f11473d = h.a(str4);
        this.f11474e = h.a(str5);
    }

    public Domain forceHttps(boolean z) {
        this.f11475f = z;
        return this;
    }

    public String getConfigHttpsUrl() {
        return this.f11473d;
    }

    public String getDeviceUrl() {
        return this.f11472c;
    }

    public String getPortraitUrl() {
        return this.f11474e;
    }

    public String getURL() {
        return getURL(SapiUtils.getDefaultHttpsEnabled());
    }

    public String getUrlDomain() {
        return getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
    }

    public String getWap() {
        if ((equals(DOMAIN_ONLINE) && SapiUtils.getDefaultHttpsEnabled()) || (!equals(DOMAIN_ONLINE) && this.f11475f)) {
            return this.f11471b.replace("http://", "https://");
        }
        return this.f11471b;
    }

    public String getWapDomain() {
        return getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
    }

    public String getURL(boolean z) {
        if ((equals(DOMAIN_ONLINE) && z) || (!equals(DOMAIN_ONLINE) && this.f11475f)) {
            return this.f11470a.replace("http://", "https://");
        }
        return this.f11470a;
    }
}
