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
/* loaded from: classes7.dex */
public final class a {
    private static Activity aos;
    private static long aov;
    private static com.baidu.crabsdk.c.b<List> aot = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean aou = false;
    private static boolean aQ = true;
    private static int aow = 0;
    private static int aT = 0;
    private static int aox = 0;
    private static boolean aV = false;

    public static void a(Activity activity) {
        aou = true;
        aos = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        aot.add(arrayList);
        int size = aot.size();
        if (size >= 2) {
            List list = aot.get(size - 2);
            if (list.size() == 3 && ((Date) aot.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aow++;
            }
        } else {
            aow++;
        }
        aT = (aT + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (aQ) {
            aQ = false;
            aov = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (aos != null && activity != null && aos.hashCode() == activity.hashCode()) {
            aos = null;
        }
        int i = aT - aox;
        int size = aot.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = aot.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        aox = (aox + 1) % 100;
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
        return aov;
    }

    public static String q() {
        StringBuilder sb = new StringBuilder();
        int size = aot.size();
        for (int i = 0; i < size; i++) {
            List list = aot.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.a((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String r() {
        if (aos == null) {
            com.baidu.crabsdk.c.a.dC("cur Page info is null!");
            return "N/A";
        }
        return aos.getClass().getName();
    }

    public static byte[] vk() {
        if (aos == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = aos.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.dC("getScreenshot failed, curActivity " + aos.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("getScreenshot failed, curActivity " + aos.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
