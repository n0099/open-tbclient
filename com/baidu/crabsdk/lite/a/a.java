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
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Activity f4723a;

    /* renamed from: d  reason: collision with root package name */
    public static long f4726d;

    /* renamed from: b  reason: collision with root package name */
    public static b<List> f4724b = new b<>(com.baidu.crabsdk.lite.a.f4717c);

    /* renamed from: c  reason: collision with root package name */
    public static boolean f4725c = true;

    /* renamed from: e  reason: collision with root package name */
    public static int f4727e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static int f4728f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f4729g = 0;

    public static long a() {
        return f4726d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x005c, code lost:
        if ((((java.util.Date) com.baidu.crabsdk.lite.a.a.f4724b.get(r5 - 1).get(1)).getTime() - ((java.util.Date) r3.get(2)).getTime()) > com.baidu.crabsdk.lite.a.f4720f) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Activity activity) {
        f4723a = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        f4724b.add(arrayList);
        int size = f4724b.size();
        if (size >= 2) {
            List list = f4724b.get(size - 2);
            if (list.size() == 3) {
            }
            f4728f = (f4728f + 1) % 100;
        }
        f4727e++;
        f4728f = (f4728f + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void c(String str, Context context) {
        if (f4725c) {
            f4725c = false;
            f4726d = System.currentTimeMillis();
            if (com.baidu.crabsdk.lite.b.c.g() >= 14) {
                if (!(context instanceof Application)) {
                    com.baidu.crabsdk.lite.b.a.g(str, "传入的不是一个Application对象!");
                    return;
                }
                com.baidu.crabsdk.lite.b.a.c(str, "传入的是一个Application对象");
                ((Application) context).registerActivityLifecycleCallbacks(new d.b.n.c.a.a());
            }
        }
    }

    public static String d() {
        String str;
        StringBuilder sb = new StringBuilder();
        int size = f4724b.size();
        for (int i = 0; i < size; i++) {
            List list = f4724b.get((size - i) - 1);
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
        Activity activity2 = f4723a;
        if (activity2 != null && activity != null && activity2.hashCode() == activity.hashCode()) {
            f4723a = null;
        }
        int i = f4728f - f4729g;
        int size = f4724b.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = f4724b.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        f4729g = (f4729g + 1) % 100;
    }

    public static String f() {
        Activity activity = f4723a;
        return activity == null ? "N/A" : activity.getClass().getName();
    }

    public static byte[] g(String str) {
        if (f4723a == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = f4723a.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.lite.b.a.f(str, "getScreenshot failed, curActivity " + f4723a.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e2) {
            com.baidu.crabsdk.lite.b.a.e(str, "getScreenshot failed, curActivity " + f4723a.getClass().getName(), e2);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
