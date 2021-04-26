package com.baidu.crabsdk.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import com.baidu.crabsdk.c.b;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Activity f4813a;

    /* renamed from: d  reason: collision with root package name */
    public static long f4816d;

    /* renamed from: b  reason: collision with root package name */
    public static b<List> f4814b = new b<>(com.baidu.crabsdk.a.f4783e);

    /* renamed from: c  reason: collision with root package name */
    public static boolean f4815c = true;

    /* renamed from: e  reason: collision with root package name */
    public static int f4817e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static int f4818f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f4819g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f4820h = false;

    /* JADX WARN: Code restructure failed: missing block: B:7:0x005c, code lost:
        if ((((java.util.Date) com.baidu.crabsdk.b.a.f4814b.get(r5 - 1).get(1)).getTime() - ((java.util.Date) r3.get(2)).getTime()) > com.baidu.crabsdk.a.l) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Activity activity) {
        f4813a = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        f4814b.add(arrayList);
        int size = f4814b.size();
        if (size >= 2) {
            List list = f4814b.get(size - 2);
            if (list.size() == 3) {
            }
            f4818f = (f4818f + 1) % 100;
        }
        f4817e++;
        f4818f = (f4818f + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void b(Application application) {
        if (f4815c) {
            f4815c = false;
            f4816d = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new d.a.m.b.a());
            }
        }
    }

    public static void c(Activity activity) {
        Activity activity2 = f4813a;
        if (activity2 != null && activity != null && activity2.hashCode() == activity.hashCode()) {
            f4813a = null;
        }
        int i2 = f4818f - f4819g;
        int size = f4814b.size();
        if (i2 < 0) {
            i2 += 100;
        }
        if (i2 > 0 && size >= i2) {
            List list = f4814b.get(size - i2);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        f4819g = (f4819g + 1) % 100;
    }

    public static void e(Activity activity) {
        if (Build.VERSION.SDK_INT < 14) {
            a(activity);
        }
    }

    public static void f(Activity activity) {
        if (Build.VERSION.SDK_INT < 14) {
            c(activity);
        }
    }

    public static long g() {
        return f4816d;
    }

    public static String h() {
        String str;
        StringBuilder sb = new StringBuilder();
        int size = f4814b.size();
        for (int i2 = 0; i2 < size; i2++) {
            List list = f4814b.get((size - i2) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0));
                sb.append(" from ");
                sb.append(com.baidu.crabsdk.c.c.a((Date) list.get(1)));
                sb.append(" to ");
                sb.append(com.baidu.crabsdk.c.c.a((Date) list.get(2)));
                str = "\n";
            } else if (list.size() == 2) {
                sb.append((String) list.get(0));
                sb.append(" from ");
                sb.append(com.baidu.crabsdk.c.c.a((Date) list.get(1)));
                str = " to ...\n";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static String i() {
        Activity activity = f4813a;
        if (activity == null) {
            com.baidu.crabsdk.c.a.b("cur Page info is null!");
            return "N/A";
        }
        return activity.getClass().getName();
    }

    public static byte[] j() {
        if (f4813a == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = f4813a.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.b("getScreenshot failed, curActivity " + f4813a.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e2) {
            com.baidu.crabsdk.c.a.a("getScreenshot failed, curActivity " + f4813a.getClass().getName(), e2);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
