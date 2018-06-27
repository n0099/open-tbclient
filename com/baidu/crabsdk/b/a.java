package com.baidu.crabsdk.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.view.View;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {
    private static long SA;
    private static Activity Sw;
    private static com.baidu.crabsdk.c.b<List> Sx = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean Sy = false;
    private static boolean Sz = true;
    private static int aP = 0;
    private static int aQ = 0;
    private static int aR = 0;

    public static void a(Activity activity) {
        Sy = true;
        Sw = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        Sx.add(arrayList);
        int size = Sx.size();
        if (size >= 2) {
            List list = Sx.get(size - 2);
            if (list.size() == 3 && ((Date) Sx.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aP++;
            }
        } else {
            aP++;
        }
        aQ = (aQ + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (Sz) {
            Sz = false;
            SA = System.currentTimeMillis();
            if (com.baidu.crabsdk.c.c.pf() >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (Sw != null && activity != null && Sw.hashCode() == activity.hashCode()) {
            Sw = null;
        }
        int i = aQ - aR;
        int size = Sx.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = Sx.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        aR = (aR + 1) % 100;
    }

    public static void doActivityStart(Activity activity) {
        if (com.baidu.crabsdk.c.c.pf() < 14) {
            a(activity);
        }
    }

    public static void doActivityStop(Activity activity) {
        if (com.baidu.crabsdk.c.c.pf() < 14) {
            b(activity);
        }
    }

    public static long oX() {
        return SA;
    }

    public static byte[] oY() {
        if (Sw == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = Sw.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.cd("getScreenshot failed, curActivity " + Sw.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.b("getScreenshot failed, curActivity " + Sw.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String p() {
        StringBuilder sb = new StringBuilder();
        int size = Sx.size();
        for (int i = 0; i < size; i++) {
            List list = Sx.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.f((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.f((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.f((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String q() {
        return Sw == null ? "N/A" : Sw.getClass().getName();
    }
}
