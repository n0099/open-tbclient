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
    public static Activity f4667a;

    /* renamed from: d  reason: collision with root package name */
    public static long f4670d;

    /* renamed from: b  reason: collision with root package name */
    public static b<List> f4668b = new b<>(com.baidu.crabsdk.a.f4639e);

    /* renamed from: c  reason: collision with root package name */
    public static boolean f4669c = true;

    /* renamed from: e  reason: collision with root package name */
    public static int f4671e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static int f4672f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f4673g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f4674h = false;

    /* JADX WARN: Code restructure failed: missing block: B:7:0x005c, code lost:
        if ((((java.util.Date) com.baidu.crabsdk.b.a.f4668b.get(r5 - 1).get(1)).getTime() - ((java.util.Date) r3.get(2)).getTime()) > com.baidu.crabsdk.a.l) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Activity activity) {
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
    public static void b(Application application) {
        if (f4669c) {
            f4669c = false;
            f4670d = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new d.b.n.b.a());
            }
        }
    }

    public static void c(Activity activity) {
        Activity activity2 = f4667a;
        if (activity2 != null && activity != null && activity2.hashCode() == activity.hashCode()) {
            f4667a = null;
        }
        int i = f4672f - f4673g;
        int size = f4668b.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = f4668b.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        f4673g = (f4673g + 1) % 100;
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
        return f4670d;
    }

    public static String h() {
        String str;
        StringBuilder sb = new StringBuilder();
        int size = f4668b.size();
        for (int i = 0; i < size; i++) {
            List list = f4668b.get((size - i) - 1);
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
        Activity activity = f4667a;
        if (activity == null) {
            com.baidu.crabsdk.c.a.b("cur Page info is null!");
            return "N/A";
        }
        return activity.getClass().getName();
    }

    public static byte[] j() {
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
                com.baidu.crabsdk.c.a.b("getScreenshot failed, curActivity " + f4667a.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e2) {
            com.baidu.crabsdk.c.a.a("getScreenshot failed, curActivity " + f4667a.getClass().getName(), e2);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
