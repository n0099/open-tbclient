package com.alipay.security.mobile.module.c;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f2083a;

    /* renamed from: b  reason: collision with root package name */
    public String f2084b;

    /* renamed from: c  reason: collision with root package name */
    public String f2085c;

    /* renamed from: d  reason: collision with root package name */
    public String f2086d;

    /* renamed from: e  reason: collision with root package name */
    public String f2087e;

    /* renamed from: f  reason: collision with root package name */
    public String f2088f;

    /* renamed from: g  reason: collision with root package name */
    public String f2089g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f2083a = str;
        this.f2084b = str2;
        this.f2085c = str3;
        this.f2086d = str4;
        this.f2087e = str5;
        this.f2088f = str6;
        this.f2089g = str7;
    }

    public final String toString() {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        String str3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.f2083a);
        stringBuffer.append("," + this.f2084b);
        stringBuffer.append("," + this.f2085c);
        stringBuffer.append("," + this.f2086d);
        if (com.alipay.security.mobile.module.a.a.a(this.f2087e) || this.f2087e.length() < 20) {
            sb = new StringBuilder(",");
            str = this.f2087e;
        } else {
            sb = new StringBuilder(",");
            str = this.f2087e.substring(0, 20);
        }
        sb.append(str);
        stringBuffer.append(sb.toString());
        if (com.alipay.security.mobile.module.a.a.a(this.f2088f) || this.f2088f.length() < 20) {
            sb2 = new StringBuilder(",");
            str2 = this.f2088f;
        } else {
            sb2 = new StringBuilder(",");
            str2 = this.f2088f.substring(0, 20);
        }
        sb2.append(str2);
        stringBuffer.append(sb2.toString());
        if (com.alipay.security.mobile.module.a.a.a(this.f2089g) || this.f2089g.length() < 20) {
            sb3 = new StringBuilder(",");
            str3 = this.f2089g;
        } else {
            sb3 = new StringBuilder(",");
            str3 = this.f2089g.substring(0, 20);
        }
        sb3.append(str3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }
}
