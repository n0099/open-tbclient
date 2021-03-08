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
/* loaded from: classes5.dex */
public final class a {
    private static Activity aqh;
    private static long aqk;
    private static com.baidu.crabsdk.c.b<List> aqi = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean aqj = false;
    private static boolean aQ = true;
    private static int aql = 0;
    private static int aT = 0;
    private static int aqm = 0;
    private static boolean aqn = false;

    public static void a(Activity activity) {
        aqj = true;
        aqh = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        aqi.add(arrayList);
        int size = aqi.size();
        if (size >= 2) {
            List list = aqi.get(size - 2);
            if (list.size() == 3 && ((Date) aqi.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aql++;
            }
        } else {
            aql++;
        }
        aT = (aT + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (aQ) {
            aQ = false;
            aqk = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (aqh != null && activity != null && aqh.hashCode() == activity.hashCode()) {
            aqh = null;
        }
        int i = aT - aqm;
        int size = aqi.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = aqi.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        aqm = (aqm + 1) % 100;
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
        return aqk;
    }

    public static String q() {
        StringBuilder sb = new StringBuilder();
        int size = aqi.size();
        for (int i = 0; i < size; i++) {
            List list = aqi.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.a((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String r() {
        if (aqh == null) {
            com.baidu.crabsdk.c.a.dw("cur Page info is null!");
            return "N/A";
        }
        return aqh.getClass().getName();
    }

    public static byte[] un() {
        if (aqh == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = aqh.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.dw("getScreenshot failed, curActivity " + aqh.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("getScreenshot failed, curActivity " + aqh.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
