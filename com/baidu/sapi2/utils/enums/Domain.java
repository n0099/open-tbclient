package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.utils.SapiHost;
/* loaded from: classes.dex */
public enum Domain {
    DOMAIN_ONLINE("aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", "aHR0cDovL3dhcHBhc3MuYmFpZHUuY29t", SapiHost.DOMAIN_ONLINE_DEVICE_URL, "aHR0cDovL3dhcHBhc3MuYmFpZHUuY29t", SapiHost.DOMAIN_ONLINE_CONFIG_HTTPS_URL, SapiHost.DOMAIN_ONLINE_PORTRAIT_URL, "aHR0cHM6Ly9zcGsuYmFpZHUuY29tL2VjaG8uZmNnaQ=="),
    DOMAIN_RD(SapiHost.DOMAIN_RD_PASSPORT_URL, "aHR0cDovL3dhcHBhc3MtcmR0ZXN0LmJhaWR1LmNvbQ==", SapiHost.DOMAIN_RD_DEVICE_URL, "aHR0cDovL3dhcHBhc3MtcmR0ZXN0LmJhaWR1LmNvbQ==", "aHR0cDovL3dhcHBhc3MtcmR0ZXN0LmJhaWR1LmNvbQ==", "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", "aHR0cHM6Ly9zcGsuYmFpZHUuY29tL2VjaG8uZmNnaQ=="),
    DOMAIN_QA(SapiHost.DOMAIN_QA_PASSPORT_URL, SapiHost.DOMAIN_QA_WAPPASS_URL, "aHR0cDovL2RiLWluZmJrLW9ubGluZS0xNy5kYjAxLmJhaWR1LmNvbTo4MDgw", SapiHost.DOMAIN_QA_CONFIG_URL, SapiHost.DOMAIN_QA_CONFIG_HTTPS_URL, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", "aHR0cHM6Ly9zcGsuYmFpZHUuY29tL2VjaG8uZmNnaQ=="),
    DOMAIN_NEW_QA(SapiHost.DOMAIN_NEW_QA_PASSPORT_URL, "aHR0cDovL3dhcHBhc3NhbGx0ZXN0LmJhaWR1LmNvbQ==", "aHR0cDovL2RiLWluZmJrLW9ubGluZS0xNy5kYjAxLmJhaWR1LmNvbTo4MDgw", "aHR0cDovL3dhcHBhc3NhbGx0ZXN0LmJhaWR1LmNvbQ==", "aHR0cDovL3dhcHBhc3NhbGx0ZXN0LmJhaWR1LmNvbQ==", "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", "aHR0cHM6Ly9zcGsuYmFpZHUuY29tL2VjaG8uZmNnaQ==");
    
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private boolean h;

    Domain(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = SapiHost.getHost(str);
        this.b = SapiHost.getHost(str2);
        this.c = SapiHost.getHost(str3);
        this.d = SapiHost.getHost(str4);
        this.e = SapiHost.getHost(str5);
        this.f = SapiHost.getHost(str6);
        this.g = SapiHost.getHost(str7);
    }

    public String getURL(boolean z) {
        return (!(equals(DOMAIN_ONLINE) && z) && (equals(DOMAIN_ONLINE) || !this.h)) ? this.a : this.a.replace("http://", "https://");
    }

    public String getWap(boolean z) {
        return (!(equals(DOMAIN_ONLINE) && z) && (equals(DOMAIN_ONLINE) || !this.h)) ? this.b : this.b.replace("http://", "https://");
    }

    public String getDeviceUrl() {
        return this.c;
    }

    public String getConfigUrl() {
        return this.d;
    }

    public String getConfigHttpsUrl() {
        return this.e;
    }

    public String getPortraitUrl() {
        return this.f;
    }

    public String getVoiceLoginUrl() {
        return this.g;
    }

    public Domain forceHttps(boolean z) {
        this.h = z;
        return this;
    }
}
