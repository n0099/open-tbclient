package com.baidu.sapi2.utils;

import android.util.Base64;
/* loaded from: classes.dex */
public class SapiHost {
    public static final String ACTION_INTERCEPT_URL = "aHR0cHM6Ly93YXAuYmFpZHUuY29tL2FjdGlvbl9pbnRlcmNlcHRfYW5kcm9pZA==";
    public static final String DOMAIN_BAIDU_HTTPS_URL = "aHR0cHM6Ly93d3cuYmFpZHUuY29t";
    public static final String DOMAIN_BDIMG = "aHR0cDovL2hpbWcuYmRpbWcuY29t";
    public static final String DOMAIN_NEW_QA_CONFIG_HTTPS_URL = "aHR0cDovL3dhcHBhc3NhbGx0ZXN0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_NEW_QA_DEVICE_URL = "aHR0cDovL2RiLWluZmJrLW9ubGluZS0xNy5kYjAxLmJhaWR1LmNvbTo4MDgw";
    public static final String DOMAIN_NEW_QA_PASSPORT_URL = "aHR0cDovL3Bhc3Nwb3J0YWxsdGVzdC5iYWlkdS5jb20=";
    public static final String DOMAIN_NEW_QA_PORTRAIT_URL = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_NEW_QA_WAPPASS_URL = "aHR0cDovL3dhcHBhc3NhbGx0ZXN0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_NSCLICK_URL = "aHR0cHM6Ly9uc2NsaWNrLmJhaWR1LmNvbS92LmdpZg==";
    public static final String DOMAIN_ONLINE_CONFIG_HTTPS_URL = "aHR0cHM6Ly9nc3MwLmJkc3RhdGljLmNvbQ==";
    public static final String DOMAIN_ONLINE_DEVICE_URL = "aHR0cHM6Ly9vcGVuYXBpLmJhaWR1LmNvbQ==";
    public static final String DOMAIN_ONLINE_PASSPORT_URL = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_ONLINE_PORTRAIT_URL = "aHR0cHM6Ly9wYXNzcG9ydC5iYWlkdS5jb20=";
    public static final String DOMAIN_ONLINE_WAPPASS_URL = "aHR0cDovL3dhcHBhc3MuYmFpZHUuY29t";
    public static final String DOMAIN_PORTRAIT_HTTPS_URL = "aHR0cHM6Ly9zczAuYmRzdGF0aWMuY29tLzdMczBhOFNtMUE1QnBoR2xuWUc=";
    public static final String DOMAIN_QA_DEVICE_URL = "aHR0cDovL2RiLWluZmJrLW9ubGluZS0xNy5kYjAxLmJhaWR1LmNvbTo4MDgw";
    public static final String DOMAIN_QA_PASSPORT_URL = "aHR0cDovL3Bhc3Nwb3J0LnFhdGVzdC5iYWlkdS5jb20=";
    public static final String DOMAIN_QA_PORTRAIT_URL = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_RD_CONFIG_HTTPS_URL = "aHR0cDovL3dhcHBhc3MtcmR0ZXN0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_RD_DEVICE_URL = "aHR0cDovL2RibC1kZXYtcmQyMy52bS5iYWlkdS5jb206ODA4MA==";
    public static final String DOMAIN_RD_PASSPORT_URL = "aHR0cDovL3Bhc3Nwb3J0LXJkdGVzdC5iYWlkdS5jb20=";
    public static final String DOMAIN_RD_PORTRAIT_URL = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_RD_WAPPASS_URL = "aHR0cDovL3dhcHBhc3MtcmR0ZXN0LmJhaWR1LmNvbQ==";
    public static String DOMAIN_QA_WAPPASS_URL = "aHR0cDovL3dhcHBhc3MucWF0ZXN0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_QA_CONFIG_HTTPS_URL = DOMAIN_QA_WAPPASS_URL;

    public static String getHost(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }
}
