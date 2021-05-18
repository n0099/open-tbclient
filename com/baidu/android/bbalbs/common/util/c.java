package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static b f2542b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f2543c = "";

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f2544d = "";

    /* renamed from: a  reason: collision with root package name */
    public final Context f2545a;

    public c(Context context) {
        this.f2545a = context.getApplicationContext();
    }

    public static String a() {
        if (TextUtils.isEmpty(f2543c)) {
            f2543c = "0newiqr3mini0";
        }
        return f2543c;
    }

    public static String a(Context context) {
        return b(context).a();
    }

    public static void a(String str) {
        if (!d.a(str, 5)) {
            throw new IllegalArgumentException("expect src only letter or number , less than 6");
        }
        synchronized (b.class) {
            if (TextUtils.isEmpty(f2544d)) {
                f2544d = str;
                int length = 5 - str.length();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("0newiqr3");
                stringBuffer.append(str);
                for (int i2 = 0; i2 < length; i2++) {
                    stringBuffer.append("0");
                }
                f2543c = stringBuffer.toString().trim();
            }
        }
    }

    private b b() {
        b b2 = b.b(this.f2545a);
        boolean z = b2 == null;
        if (b2 == null) {
            a b3 = a.b(this.f2545a);
            if (b3 == null) {
                b2 = b.a(this.f2545a, a());
            } else {
                b3.c();
                b2 = b.a(b3);
            }
        }
        if (z) {
            b2.a(this.f2545a);
        }
        a.a(this.f2545a);
        return b2;
    }

    public static b b(Context context) {
        if (f2542b == null) {
            synchronized (b.class) {
                if (f2542b == null) {
                    f2542b = new c(context).b();
                }
            }
        }
        return f2542b;
    }
}
