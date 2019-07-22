package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes.dex */
public enum Domain {
    DOMAIN_ONLINE("aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", SapiHost.DOMAIN_ONLINE_WAPPASS_URL, SapiHost.DOMAIN_ONLINE_DEVICE_URL, SapiHost.DOMAIN_ONLINE_CONFIG_HTTPS_URL, SapiHost.DOMAIN_ONLINE_PORTRAIT_URL),
    DOMAIN_RD(SapiHost.DOMAIN_RD_PASSPORT_URL, "aHR0cDovL3dhcHBhc3MtcmR0ZXN0LmJhaWR1LmNvbQ==", SapiHost.DOMAIN_RD_DEVICE_URL, "aHR0cDovL3dhcHBhc3MtcmR0ZXN0LmJhaWR1LmNvbQ==", "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ=="),
    DOMAIN_QA(SapiHost.DOMAIN_QA_PASSPORT_URL, SapiHost.DOMAIN_QA_WAPPASS_URL, "aHR0cDovL2RiLWluZmJrLW9ubGluZS0xNy5kYjAxLmJhaWR1LmNvbTo4MDgw", SapiHost.DOMAIN_QA_CONFIG_HTTPS_URL, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ=="),
    DOMAIN_NEW_QA(SapiHost.DOMAIN_NEW_QA_PASSPORT_URL, "aHR0cDovL3dhcHBhc3NhbGx0ZXN0LmJhaWR1LmNvbQ==", "aHR0cDovL2RiLWluZmJrLW9ubGluZS0xNy5kYjAxLmJhaWR1LmNvbTo4MDgw", "aHR0cDovL3dhcHBhc3NhbGx0ZXN0LmJhaWR1LmNvbQ==", "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==");
    
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;

    Domain(String str, String str2, String str3, String str4, String str5) {
        this.a = SapiHost.getHost(str);
        this.b = SapiHost.getHost(str2);
        this.c = SapiHost.getHost(str3);
        this.d = SapiHost.getHost(str4);
        this.e = SapiHost.getHost(str5);
    }

    public String getURL() {
        return getURL(SapiUtils.getDefaultHttpsEnabled());
    }

    public String getURL(boolean z) {
        return (!(equals(DOMAIN_ONLINE) && z) && (equals(DOMAIN_ONLINE) || !this.f)) ? this.a : this.a.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public String getWap() {
        return (!(equals(DOMAIN_ONLINE) && SapiUtils.getDefaultHttpsEnabled()) && (equals(DOMAIN_ONLINE) || !this.f)) ? this.b : this.b.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    public String getDeviceUrl() {
        return this.c;
    }

    public String getConfigHttpsUrl() {
        return this.d;
    }

    public String getPortraitUrl() {
        return this.e;
    }

    public Domain forceHttps(boolean z) {
        this.f = z;
        return this;
    }
}
