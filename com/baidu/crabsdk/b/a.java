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
/* loaded from: classes8.dex */
public final class a {
    private static long aR;
    private static Activity ajT;
    private static com.baidu.crabsdk.c.b<List> ajU = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean ajV = false;
    private static boolean ajW = true;
    private static int ajX = 0;
    private static int ajY = 0;
    private static int aU = 0;
    private static boolean ajZ = false;

    public static void a(Activity activity) {
        ajV = true;
        ajT = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        ajU.add(arrayList);
        int size = ajU.size();
        if (size >= 2) {
            List list = ajU.get(size - 2);
            if (list.size() == 3 && ((Date) ajU.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                ajX++;
            }
        } else {
            ajX++;
        }
        ajY = (ajY + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (ajW) {
            ajW = false;
            aR = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (ajT != null && activity != null && ajT.hashCode() == activity.hashCode()) {
            ajT = null;
        }
        int i = ajY - aU;
        int size = ajU.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = ajU.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        aU = (aU + 1) % 100;
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
        return aR;
    }

    public static String q() {
        StringBuilder sb = new StringBuilder();
        int size = ajU.size();
        for (int i = 0; i < size; i++) {
            List list = ajU.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.a((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String r() {
        if (ajT == null) {
            com.baidu.crabsdk.c.a.de("cur Page info is null!");
            return "N/A";
        }
        return ajT.getClass().getName();
    }

    public static byte[] sA() {
        if (ajT == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = ajT.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.de("getScreenshot failed, curActivity " + ajT.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.f("getScreenshot failed, curActivity " + ajT.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
