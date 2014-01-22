package com.baidu.sapi2.utils.enums;
/* loaded from: classes.dex */
public enum Domain {
    DOMAIN_ONLINE("http://passport.baidu.com", "http://wappass.baidu.com", "http://wappass.bdimg.com"),
    DOMAIN_RD("http://cq01-pass-test01-bbtocq.vm.baidu.com:8200", "http://cq01-pass-test01-bbtocq.vm.baidu.com:8000", "http://cq01-pass-test01-bbtocq.vm.baidu.com:8000"),
    DOMAIN_QA("http://passport.qatest.baidu.com", "http://wappass.qatest.baidu.com", "http://wappass.qatest.baidu.com");
    
    private String a;
    private String b;
    private String c;

    Domain(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String getURL() {
        return this.a;
    }

    public String getWap() {
        return this.b;
    }

    public String getConfigUrl() {
        return this.c;
    }
}
