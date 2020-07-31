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
/* loaded from: classes12.dex */
public final class a {
    private static Activity alV;
    private static long alY;
    private static com.baidu.crabsdk.c.b<List> alW = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean alX = false;
    private static boolean aQ = true;
    private static int aS = 0;
    private static int alZ = 0;
    private static int ama = 0;
    private static boolean amb = false;

    public static void a(Activity activity) {
        alX = true;
        alV = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        alW.add(arrayList);
        int size = alW.size();
        if (size >= 2) {
            List list = alW.get(size - 2);
            if (list.size() == 3 && ((Date) alW.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aS++;
            }
        } else {
            aS++;
        }
        alZ = (alZ + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (aQ) {
            aQ = false;
            alY = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (alV != null && activity != null && alV.hashCode() == activity.hashCode()) {
            alV = null;
        }
        int i = alZ - ama;
        int size = alW.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = alW.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        ama = (ama + 1) % 100;
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
        return alY;
    }

    public static String q() {
        StringBuilder sb = new StringBuilder();
        int size = alW.size();
        for (int i = 0; i < size; i++) {
            List list = alW.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.a((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String r() {
        if (alV == null) {
            com.baidu.crabsdk.c.a.dh("cur Page info is null!");
            return "N/A";
        }
        return alV.getClass().getName();
    }

    public static byte[] tg() {
        if (alV == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = alV.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.dh("getScreenshot failed, curActivity " + alV.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("getScreenshot failed, curActivity " + alV.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
