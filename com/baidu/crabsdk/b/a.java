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
    private static Activity UZ;
    private static long Vd;
    private static com.baidu.crabsdk.c.b<List> Va = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean Vb = false;
    private static boolean Vc = true;
    private static int aP = 0;
    private static int aQ = 0;
    private static int aR = 0;

    public static void a(Activity activity) {
        Vb = true;
        UZ = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        Va.add(arrayList);
        int size = Va.size();
        if (size >= 2) {
            List list = Va.get(size - 2);
            if (list.size() == 3 && ((Date) Va.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aP++;
            }
        } else {
            aP++;
        }
        aQ = (aQ + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (Vc) {
            Vc = false;
            Vd = System.currentTimeMillis();
            if (com.baidu.crabsdk.c.c.qm() >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (UZ != null && activity != null && UZ.hashCode() == activity.hashCode()) {
            UZ = null;
        }
        int i = aQ - aR;
        int size = Va.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = Va.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        aR = (aR + 1) % 100;
    }

    public static void doActivityStart(Activity activity) {
        if (com.baidu.crabsdk.c.c.qm() < 14) {
            a(activity);
        }
    }

    public static void doActivityStop(Activity activity) {
        if (com.baidu.crabsdk.c.c.qm() < 14) {
            b(activity);
        }
    }

    public static String p() {
        StringBuilder sb = new StringBuilder();
        int size = Va.size();
        for (int i = 0; i < size; i++) {
            List list = Va.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.e((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.e((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.e((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String q() {
        return UZ == null ? "N/A" : UZ.getClass().getName();
    }

    public static long qe() {
        return Vd;
    }

    public static byte[] qf() {
        if (UZ == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = UZ.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.cv("getScreenshot failed, curActivity " + UZ.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.f("getScreenshot failed, curActivity " + UZ.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
