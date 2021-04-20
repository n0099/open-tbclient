package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.h;
/* loaded from: classes2.dex */
public enum Domain {
    DOMAIN_ONLINE("aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", h.f11094b, h.f11095c, h.f11096d, h.f11097e),
    DOMAIN_QA(h.f11098f, h.f11099g, h.f11100h, h.i, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==");
    

    /* renamed from: a  reason: collision with root package name */
    public String f11055a;

    /* renamed from: b  reason: collision with root package name */
    public String f11056b;

    /* renamed from: c  reason: collision with root package name */
    public String f11057c;

    /* renamed from: d  reason: collision with root package name */
    public String f11058d;

    /* renamed from: e  reason: collision with root package name */
    public String f11059e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11060f;

    Domain(String str, String str2, String str3, String str4, String str5) {
        this.f11055a = h.a(str);
        this.f11056b = h.a(str2);
        this.f11057c = h.a(str3);
        this.f11058d = h.a(str4);
        this.f11059e = h.a(str5);
    }

    public Domain forceHttps(boolean z) {
        this.f11060f = z;
        return this;
    }

    public String getConfigHttpsUrl() {
        return this.f11058d;
    }

    public String getDeviceUrl() {
        return this.f11057c;
    }

    public String getPortraitUrl() {
        return this.f11059e;
    }

    public String getURL() {
        return getURL(SapiUtils.getDefaultHttpsEnabled());
    }

    public String getUrlDomain() {
        return getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
    }

    public String getWap() {
        if ((equals(DOMAIN_ONLINE) && SapiUtils.getDefaultHttpsEnabled()) || (!equals(DOMAIN_ONLINE) && this.f11060f)) {
            return this.f11056b.replace("http://", "https://");
        }
        return this.f11056b;
    }

    public String getWapDomain() {
        return getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
    }

    public String getURL(boolean z) {
        if ((equals(DOMAIN_ONLINE) && z) || (!equals(DOMAIN_ONLINE) && this.f11060f)) {
            return this.f11055a.replace("http://", "https://");
        }
        return this.f11055a;
    }
}
