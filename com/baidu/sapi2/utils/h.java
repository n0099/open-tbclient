package com.baidu.sapi2.utils;

import android.util.Base64;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11508a = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";

    /* renamed from: b  reason: collision with root package name */
    public static final String f11509b = "aHR0cDovL3dhcHBhc3MuYmFpZHUuY29t";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11510c = "aHR0cHM6Ly9vcGVuYXBpLmJhaWR1LmNvbQ==";

    /* renamed from: d  reason: collision with root package name */
    public static final String f11511d = "aHR0cHM6Ly93YXBwYXNzLmJkaW1nLmNvbQ==";

    /* renamed from: e  reason: collision with root package name */
    public static final String f11512e = "aHR0cHM6Ly9wYXNzcG9ydC5iYWlkdS5jb20=";

    /* renamed from: f  reason: collision with root package name */
    public static final String f11513f = "aHR0cDovL3Bhc3Nwb3J0LnFhdGVzdC5iYWlkdS5jb20=";

    /* renamed from: h  reason: collision with root package name */
    public static final String f11515h = "aHR0cDovL2RiLWluZmJrLW9ubGluZS0xNy5kYjAxLmJhaWR1LmNvbTo4MDgw";
    public static final String j = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";
    public static final String k = "aHR0cHM6Ly9uc2NsaWNrLmJhaWR1LmNvbS92LmdpZg==";
    public static final String l = "aHR0cHM6Ly93d3cuYmFpZHUuY29t";
    public static final String m = "aHR0cHM6Ly93YXAuYmFpZHUuY29tL2FjdGlvbl9pbnRlcmNlcHRfYW5kcm9pZA==";

    /* renamed from: g  reason: collision with root package name */
    public static String f11514g = "aHR0cDovL3dhcHBhc3MucWF0ZXN0LmJhaWR1LmNvbQ==";
    public static final String i = f11514g;

    public static String a(String str) {
        try {
            return new String(Base64.decode(str.getBytes(), 0));
        } catch (Exception unused) {
            return "";
        }
    }
}
