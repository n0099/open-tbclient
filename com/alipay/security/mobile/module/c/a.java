package com.alipay.security.mobile.module.c;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f2056a;

    /* renamed from: b  reason: collision with root package name */
    public String f2057b;

    /* renamed from: c  reason: collision with root package name */
    public String f2058c;

    /* renamed from: d  reason: collision with root package name */
    public String f2059d;

    /* renamed from: e  reason: collision with root package name */
    public String f2060e;

    /* renamed from: f  reason: collision with root package name */
    public String f2061f;

    /* renamed from: g  reason: collision with root package name */
    public String f2062g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f2056a = str;
        this.f2057b = str2;
        this.f2058c = str3;
        this.f2059d = str4;
        this.f2060e = str5;
        this.f2061f = str6;
        this.f2062g = str7;
    }

    public final String toString() {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        String str3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.f2056a);
        stringBuffer.append("," + this.f2057b);
        stringBuffer.append("," + this.f2058c);
        stringBuffer.append("," + this.f2059d);
        if (com.alipay.security.mobile.module.a.a.a(this.f2060e) || this.f2060e.length() < 20) {
            sb = new StringBuilder(",");
            str = this.f2060e;
        } else {
            sb = new StringBuilder(",");
            str = this.f2060e.substring(0, 20);
        }
        sb.append(str);
        stringBuffer.append(sb.toString());
        if (com.alipay.security.mobile.module.a.a.a(this.f2061f) || this.f2061f.length() < 20) {
            sb2 = new StringBuilder(",");
            str2 = this.f2061f;
        } else {
            sb2 = new StringBuilder(",");
            str2 = this.f2061f.substring(0, 20);
        }
        sb2.append(str2);
        stringBuffer.append(sb2.toString());
        if (com.alipay.security.mobile.module.a.a.a(this.f2062g) || this.f2062g.length() < 20) {
            sb3 = new StringBuilder(",");
            str3 = this.f2062g;
        } else {
            sb3 = new StringBuilder(",");
            str3 = this.f2062g.substring(0, 20);
        }
        sb3.append(str3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }
}
