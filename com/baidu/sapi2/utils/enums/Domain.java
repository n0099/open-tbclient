package com.baidu.sapi2.utils.enums;
/* loaded from: classes.dex */
public enum Domain {
    DOMAIN_ONLINE("http://passport.baidu.com", "http://wappass.baidu.com", "https://openapi.baidu.com", "http://wappass.bdimg.com"),
    DOMAIN_RD("http://passport.rdtest.baidu.com", "http://passport.rdtest.baidu.com:8000", "http://dbl-dev-rd23.vm.baidu.com:8080", "http://passport.rdtest.baidu.com:8000"),
    DOMAIN_QA("http://passport.qatest.baidu.com", "http://wappass.qatest.baidu.com", "http://db-infbk-online-17.db01.baidu.com:8080", "http://wappass.qatest.baidu.com");
    
    private String a;
    private String b;
    private String c;
    private String d;

    Domain(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public String getURL() {
        return this.a;
    }

    public String getWap() {
        return this.b;
    }

    public String getDeviceUrl() {
        return this.c;
    }

    public String getConfigUrl() {
        return this.d;
    }
}
