package com.alipay.security.mobile.module.c;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f2058a;

    /* renamed from: b  reason: collision with root package name */
    public String f2059b;

    /* renamed from: c  reason: collision with root package name */
    public String f2060c;

    /* renamed from: d  reason: collision with root package name */
    public String f2061d;

    /* renamed from: e  reason: collision with root package name */
    public String f2062e;

    /* renamed from: f  reason: collision with root package name */
    public String f2063f;

    /* renamed from: g  reason: collision with root package name */
    public String f2064g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f2058a = str;
        this.f2059b = str2;
        this.f2060c = str3;
        this.f2061d = str4;
        this.f2062e = str5;
        this.f2063f = str6;
        this.f2064g = str7;
    }

    public final String toString() {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        String str3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.f2058a);
        stringBuffer.append("," + this.f2059b);
        stringBuffer.append("," + this.f2060c);
        stringBuffer.append("," + this.f2061d);
        if (com.alipay.security.mobile.module.a.a.a(this.f2062e) || this.f2062e.length() < 20) {
            sb = new StringBuilder(",");
            str = this.f2062e;
        } else {
            sb = new StringBuilder(",");
            str = this.f2062e.substring(0, 20);
        }
        sb.append(str);
        stringBuffer.append(sb.toString());
        if (com.alipay.security.mobile.module.a.a.a(this.f2063f) || this.f2063f.length() < 20) {
            sb2 = new StringBuilder(",");
            str2 = this.f2063f;
        } else {
            sb2 = new StringBuilder(",");
            str2 = this.f2063f.substring(0, 20);
        }
        sb2.append(str2);
        stringBuffer.append(sb2.toString());
        if (com.alipay.security.mobile.module.a.a.a(this.f2064g) || this.f2064g.length() < 20) {
            sb3 = new StringBuilder(",");
            str3 = this.f2064g;
        } else {
            sb3 = new StringBuilder(",");
            str3 = this.f2064g.substring(0, 20);
        }
        sb3.append(str3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }
}
