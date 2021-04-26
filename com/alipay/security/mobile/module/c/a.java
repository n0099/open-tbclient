package com.alipay.security.mobile.module.c;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f2043a;

    /* renamed from: b  reason: collision with root package name */
    public String f2044b;

    /* renamed from: c  reason: collision with root package name */
    public String f2045c;

    /* renamed from: d  reason: collision with root package name */
    public String f2046d;

    /* renamed from: e  reason: collision with root package name */
    public String f2047e;

    /* renamed from: f  reason: collision with root package name */
    public String f2048f;

    /* renamed from: g  reason: collision with root package name */
    public String f2049g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f2043a = str;
        this.f2044b = str2;
        this.f2045c = str3;
        this.f2046d = str4;
        this.f2047e = str5;
        this.f2048f = str6;
        this.f2049g = str7;
    }

    public final String toString() {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        String str3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.f2043a);
        stringBuffer.append("," + this.f2044b);
        stringBuffer.append("," + this.f2045c);
        stringBuffer.append("," + this.f2046d);
        if (com.alipay.security.mobile.module.a.a.a(this.f2047e) || this.f2047e.length() < 20) {
            sb = new StringBuilder(",");
            str = this.f2047e;
        } else {
            sb = new StringBuilder(",");
            str = this.f2047e.substring(0, 20);
        }
        sb.append(str);
        stringBuffer.append(sb.toString());
        if (com.alipay.security.mobile.module.a.a.a(this.f2048f) || this.f2048f.length() < 20) {
            sb2 = new StringBuilder(",");
            str2 = this.f2048f;
        } else {
            sb2 = new StringBuilder(",");
            str2 = this.f2048f.substring(0, 20);
        }
        sb2.append(str2);
        stringBuffer.append(sb2.toString());
        if (com.alipay.security.mobile.module.a.a.a(this.f2049g) || this.f2049g.length() < 20) {
            sb3 = new StringBuilder(",");
            str3 = this.f2049g;
        } else {
            sb3 = new StringBuilder(",");
            str3 = this.f2049g.substring(0, 20);
        }
        sb3.append(str3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }
}
