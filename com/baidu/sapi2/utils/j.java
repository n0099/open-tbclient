package com.baidu.sapi2.utils;

import android.util.Base64;
/* loaded from: classes19.dex */
public class j {
    public static final String a = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";
    public static final String b = "aHR0cDovL3dhcHBhc3MuYmFpZHUuY29t";
    public static final String c = "aHR0cHM6Ly9vcGVuYXBpLmJhaWR1LmNvbQ==";
    public static final String d = "aHR0cHM6Ly93YXBwYXNzLmJkaW1nLmNvbQ==";
    public static final String e = "aHR0cHM6Ly9wYXNzcG9ydC5iYWlkdS5jb20=";
    public static final String f = "aHR0cDovL3Bhc3Nwb3J0LnFhdGVzdC5iYWlkdS5jb20=";
    public static final String h = "aHR0cDovL2RiLWluZmJrLW9ubGluZS0xNy5kYjAxLmJhaWR1LmNvbTo4MDgw";
    public static final String j = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";
    public static final String k = "aHR0cHM6Ly9uc2NsaWNrLmJhaWR1LmNvbS92LmdpZg==";
    public static final String l = "aHR0cHM6Ly93d3cuYmFpZHUuY29t";
    public static final String m = "aHR0cHM6Ly93YXAuYmFpZHUuY29tL2FjdGlvbl9pbnRlcmNlcHRfYW5kcm9pZA==";
    public static String g = "aHR0cDovL3dhcHBhc3MucWF0ZXN0LmJhaWR1LmNvbQ==";
    public static final String i = g;

    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }
}
