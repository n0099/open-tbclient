package com.baidu.sapi2.utils;

import android.util.Base64;
/* loaded from: classes2.dex */
public class SapiHost {
    public static final String ACTION_INTERCEPT_URL = "aHR0cHM6Ly93YXAuYmFpZHUuY29tL2FjdGlvbl9pbnRlcmNlcHRfYW5kcm9pZA==";
    public static final String DOMAIN_BAIDU_HTTPS_URL = "aHR0cHM6Ly93d3cuYmFpZHUuY29t";
    public static final String DOMAIN_NSCLICK_URL = "aHR0cHM6Ly9uc2NsaWNrLmJhaWR1LmNvbS92LmdpZg==";
    public static final String DOMAIN_ONLINE_CONFIG_HTTPS_URL = "aHR0cHM6Ly93YXBwYXNzLmJkaW1nLmNvbQ==";
    public static final String DOMAIN_ONLINE_DEVICE_URL = "aHR0cHM6Ly9vcGVuYXBpLmJhaWR1LmNvbQ==";
    public static final String DOMAIN_ONLINE_PASSPORT_URL = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_ONLINE_PORTRAIT_URL = "aHR0cHM6Ly9wYXNzcG9ydC5iYWlkdS5jb20=";
    public static final String DOMAIN_ONLINE_WAPPASS_URL = "aHR0cDovL3dhcHBhc3MuYmFpZHUuY29t";
    public static final String DOMAIN_QA_CONFIG_HTTPS_URL = "aHR0cDovL3dhcHBhc3MucWF0ZXN0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_QA_DEVICE_URL = "aHR0cDovL2RiLWluZmJrLW9ubGluZS0xNy5kYjAxLmJhaWR1LmNvbTo4MDgw";
    public static final String DOMAIN_QA_PASSPORT_URL = "aHR0cDovL3Bhc3Nwb3J0LnFhdGVzdC5iYWlkdS5jb20=";
    public static final String DOMAIN_QA_PORTRAIT_URL = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";
    public static String DOMAIN_QA_WAPPASS_URL = "aHR0cDovL3dhcHBhc3MucWF0ZXN0LmJhaWR1LmNvbQ==";

    public static String getHost(String str) {
        try {
            return new String(Base64.decode(str.getBytes(), 0));
        } catch (Exception unused) {
            return "";
        }
    }
}
