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
/* loaded from: classes14.dex */
public final class a {
    private static Activity aoR;
    private static long aoU;
    private static com.baidu.crabsdk.c.b<List> aoS = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean aoT = false;
    private static boolean aQ = true;
    private static int aoV = 0;
    private static int aT = 0;
    private static int aoW = 0;
    private static boolean aV = false;

    public static void a(Activity activity) {
        aoT = true;
        aoR = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        aoS.add(arrayList);
        int size = aoS.size();
        if (size >= 2) {
            List list = aoS.get(size - 2);
            if (list.size() == 3 && ((Date) aoS.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aoV++;
            }
        } else {
            aoV++;
        }
        aT = (aT + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (aQ) {
            aQ = false;
            aoU = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (aoR != null && activity != null && aoR.hashCode() == activity.hashCode()) {
            aoR = null;
        }
        int i = aT - aoW;
        int size = aoS.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = aoS.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        aoW = (aoW + 1) % 100;
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
        return aoU;
    }

    public static String q() {
        StringBuilder sb = new StringBuilder();
        int size = aoS.size();
        for (int i = 0; i < size; i++) {
            List list = aoS.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.a((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String r() {
        if (aoR == null) {
            com.baidu.crabsdk.c.a.ds("cur Page info is null!");
            return "N/A";
        }
        return aoR.getClass().getName();
    }

    public static byte[] uq() {
        if (aoR == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = aoR.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.ds("getScreenshot failed, curActivity " + aoR.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("getScreenshot failed, curActivity " + aoR.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
