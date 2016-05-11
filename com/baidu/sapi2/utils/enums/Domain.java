package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes.dex */
public enum Domain {
    DOMAIN_ONLINE("http://passport.baidu.com", "http://wappass.baidu.com", "https://openapi.baidu.com", "http://wappass.bdimg.com", "https://gss0.bdstatic.com", "http://himg.baidu.com"),
    DOMAIN_RD("http://passport.rdtest.baidu.com", "http://passport.rdtest.baidu.com:8000", "http://dbl-dev-rd23.vm.baidu.com:8080", "http://passport.rdtest.baidu.com:8000", "http://passport.rdtest.baidu.com:8000", "http://passport.baidu.com"),
    DOMAIN_QA("http://passport.qatest.baidu.com", "http://wappass.qatest.baidu.com", "http://db-infbk-online-17.db01.baidu.com:8080", "http://wappass.qatest.baidu.com", "http://wappass.qatest.baidu.com", "http://passport.baidu.com");
    
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;

    Domain(String str, String str2, String str3, String str4, String str5, String str6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public String getURL() {
        return (!(equals(DOMAIN_ONLINE) && SapiUtils.getDefaultHttpsEnabled()) && (equals(DOMAIN_ONLINE) || !this.g)) ? this.a : this.a.replace("http://", "https://");
    }

    public String getWap() {
        return (!(equals(DOMAIN_ONLINE) && SapiUtils.getDefaultHttpsEnabled()) && (equals(DOMAIN_ONLINE) || !this.g)) ? this.b : this.b.replace("http://", "https://");
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

    public Domain forceHttps(boolean z) {
        this.g = z;
        return this;
    }
}
