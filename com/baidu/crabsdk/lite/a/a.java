package com.baidu.crabsdk.lite.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.crabsdk.lite.b.b;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Activity f4667a;

    /* renamed from: d  reason: collision with root package name */
    public static long f4670d;

    /* renamed from: b  reason: collision with root package name */
    public static b<List> f4668b = new b<>(com.baidu.crabsdk.lite.a.f4660c);

    /* renamed from: c  reason: collision with root package name */
    public static boolean f4669c = true;

    /* renamed from: e  reason: collision with root package name */
    public static int f4671e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static int f4672f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f4673g = 0;

    public static long a() {
        return f4670d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x005c, code lost:
        if ((((java.util.Date) com.baidu.crabsdk.lite.a.a.f4668b.get(r5 - 1).get(1)).getTime() - ((java.util.Date) r3.get(2)).getTime()) > com.baidu.crabsdk.lite.a.f4663f) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Activity activity) {
        f4667a = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        f4668b.add(arrayList);
        int size = f4668b.size();
        if (size >= 2) {
            List list = f4668b.get(size - 2);
            if (list.size() == 3) {
            }
            f4672f = (f4672f + 1) % 100;
        }
        f4671e++;
        f4672f = (f4672f + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void c(String str, Context context) {
        if (f4669c) {
            f4669c = false;
            f4670d = System.currentTimeMillis();
            if (com.baidu.crabsdk.lite.b.c.g() >= 14) {
                if (!(context instanceof Application)) {
                    com.baidu.crabsdk.lite.b.a.g(str, "传入的不是一个Application对象!");
                    return;
                }
                com.baidu.crabsdk.lite.b.a.c(str, "传入的是一个Application对象");
                ((Application) context).registerActivityLifecycleCallbacks(new d.a.m.a.a.a());
            }
        }
    }

    public static String d() {
        String str;
        StringBuilder sb = new StringBuilder();
        int size = f4668b.size();
        for (int i2 = 0; i2 < size; i2++) {
            List list = f4668b.get((size - i2) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0));
                sb.append(" from ");
                sb.append(com.baidu.crabsdk.lite.b.c.b((Date) list.get(1)));
                sb.append(" to ");
                sb.append(com.baidu.crabsdk.lite.b.c.b((Date) list.get(2)));
                str = "\n";
            } else if (list.size() == 2) {
                sb.append((String) list.get(0));
                sb.append(" from ");
                sb.append(com.baidu.crabsdk.lite.b.c.b((Date) list.get(1)));
                str = " to ...\n";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static /* synthetic */ void e(Activity activity) {
        Activity activity2 = f4667a;
        if (activity2 != null && activity != null && activity2.hashCode() == activity.hashCode()) {
            f4667a = null;
        }
        int i2 = f4672f - f4673g;
        int size = f4668b.size();
        if (i2 < 0) {
            i2 += 100;
        }
        if (i2 > 0 && size >= i2) {
            List list = f4668b.get(size - i2);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        f4673g = (f4673g + 1) % 100;
    }

    public static String f() {
        Activity activity = f4667a;
        return activity == null ? "N/A" : activity.getClass().getName();
    }

    public static byte[] g(String str) {
        if (f4667a == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = f4667a.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.lite.b.a.f(str, "getScreenshot failed, curActivity " + f4667a.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e2) {
            com.baidu.crabsdk.lite.b.a.e(str, "getScreenshot failed, curActivity " + f4667a.getClass().getName(), e2);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
