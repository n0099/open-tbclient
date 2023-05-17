package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes3.dex */
public enum Domain {
    DOMAIN_ONLINE("aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", SapiHost.DOMAIN_ONLINE_WAPPASS_URL, SapiHost.DOMAIN_ONLINE_DEVICE_URL, SapiHost.DOMAIN_ONLINE_CONFIG_HTTPS_URL, SapiHost.DOMAIN_ONLINE_PORTRAIT_URL),
    DOMAIN_QA(SapiHost.DOMAIN_QA_PASSPORT_URL, SapiHost.DOMAIN_QA_WAPPASS_URL, SapiHost.DOMAIN_QA_DEVICE_URL, SapiHost.DOMAIN_QA_CONFIG_HTTPS_URL, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==");
    
    public String configHttpsUrl;
    public String deviceUrl;
    public boolean forceHttps;
    public String portraitUrl;
    public String url;
    public String wap;

    Domain(String str, String str2, String str3, String str4, String str5) {
        this.url = SapiHost.getHost(str);
        this.wap = SapiHost.getHost(str2);
        this.deviceUrl = SapiHost.getHost(str3);
        this.configHttpsUrl = SapiHost.getHost(str4);
        this.portraitUrl = SapiHost.getHost(str5);
    }

    public Domain forceHttps(boolean z) {
        this.forceHttps = z;
        return this;
    }

    public String getURL(boolean z) {
        if ((equals(DOMAIN_ONLINE) && z) || (!equals(DOMAIN_ONLINE) && this.forceHttps)) {
            return this.url.replace("http://", "https://");
        }
        return this.url;
    }

    public String getConfigHttpsUrl() {
        return this.configHttpsUrl;
    }

    public String getDeviceUrl() {
        return this.deviceUrl;
    }

    public String getPortraitUrl() {
        return this.portraitUrl;
    }

    public String getURL() {
        return getURL(SapiUtils.getDefaultHttpsEnabled());
    }

    public String getUrlDomain() {
        return getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
    }

    public String getWap() {
        if ((equals(DOMAIN_ONLINE) && SapiUtils.getDefaultHttpsEnabled()) || (!equals(DOMAIN_ONLINE) && this.forceHttps)) {
            return this.wap.replace("http://", "https://");
        }
        return this.wap;
    }

    public String getWapDomain() {
        return getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
    }
}
