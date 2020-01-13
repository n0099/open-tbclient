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
/* loaded from: classes6.dex */
public final class a {
    private static Activity PP;
    private static long PU;
    private static com.baidu.crabsdk.c.b<List> PQ = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean PR = false;
    private static boolean PT = true;
    private static int aQ = 0;
    private static int PV = 0;
    private static int PW = 0;

    public static void a(Activity activity) {
        PR = true;
        PP = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        PQ.add(arrayList);
        int size = PQ.size();
        if (size >= 2) {
            List list = PQ.get(size - 2);
            if (list.size() == 3 && ((Date) PQ.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aQ++;
            }
        } else {
            aQ++;
        }
        PV = (PV + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (PT) {
            PT = false;
            PU = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (PP != null && activity != null && PP.hashCode() == activity.hashCode()) {
            PP = null;
        }
        int i = PV - PW;
        int size = PQ.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = PQ.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        PW = (PW + 1) % 100;
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

    public static byte[] nx() {
        if (PP == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = PP.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.cb("getScreenshot failed, curActivity " + PP.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.f("getScreenshot failed, curActivity " + PP.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static long o() {
        return PU;
    }

    public static String p() {
        StringBuilder sb = new StringBuilder();
        int size = PQ.size();
        for (int i = 0; i < size; i++) {
            List list = PQ.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.a((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String q() {
        return PP == null ? "N/A" : PP.getClass().getName();
    }
}
