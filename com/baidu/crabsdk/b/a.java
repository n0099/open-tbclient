package com.baidu.crabsdk.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes11.dex */
public final class a {
    private static Activity aol;
    private static long aoo;
    private static com.baidu.crabsdk.c.b<List> aom = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean aon = false;
    private static boolean aQ = true;
    private static int aop = 0;
    private static int aT = 0;
    private static int aoq = 0;
    private static boolean aV = false;

    public static void a(Activity activity) {
        aon = true;
        aol = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        aom.add(arrayList);
        int size = aom.size();
        if (size >= 2) {
            List list = aom.get(size - 2);
            if (list.size() == 3 && ((Date) aom.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aop++;
            }
        } else {
            aop++;
        }
        aT = (aT + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (aQ) {
            aQ = false;
            aoo = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (aol != null && activity != null && aol.hashCode() == activity.hashCode()) {
            aol = null;
        }
        int i = aT - aoq;
        int size = aom.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = aom.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        aoq = (aoq + 1) % 100;
    }

    public static void doActivityStart(Activity activity) {
        if (Build.VERSION.SDK_INT < 14) {
            a(activity);
        }
    }

    public static void doActivityStop(Activity activity) {
        if (Build.VERSION.SDK_INT < 14) {
            b(activity);
        }
    }

    public static long p() {
        return aoo;
    }

    public static String q() {
        StringBuilder sb = new StringBuilder();
        int size = aom.size();
        for (int i = 0; i < size; i++) {
            List list = aom.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.a((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String r() {
        if (aol == null) {
            com.baidu.crabsdk.c.a.dA("cur Page info is null!");
            return "N/A";
        }
        return aol.getClass().getName();
    }

    public static byte[] vl() {
        if (aol == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = aol.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.dA("getScreenshot failed, curActivity " + aol.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("getScreenshot failed, curActivity " + aol.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
