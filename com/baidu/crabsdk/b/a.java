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
    private static Activity St;
    private static long Sx;
    private static com.baidu.crabsdk.c.b<List> Su = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean Sv = false;
    private static boolean Sw = true;
    private static int aP = 0;
    private static int aQ = 0;
    private static int aR = 0;

    public static void a(Activity activity) {
        Sv = true;
        St = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        Su.add(arrayList);
        int size = Su.size();
        if (size >= 2) {
            List list = Su.get(size - 2);
            if (list.size() == 3 && ((Date) Su.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aP++;
            }
        } else {
            aP++;
        }
        aQ = (aQ + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (Sw) {
            Sw = false;
            Sx = System.currentTimeMillis();
            if (com.baidu.crabsdk.c.c.pj() >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (St != null && activity != null && St.hashCode() == activity.hashCode()) {
            St = null;
        }
        int i = aQ - aR;
        int size = Su.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = Su.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        aR = (aR + 1) % 100;
    }

    public static void doActivityStart(Activity activity) {
        if (com.baidu.crabsdk.c.c.pj() < 14) {
            a(activity);
        }
    }

    public static void doActivityStop(Activity activity) {
        if (com.baidu.crabsdk.c.c.pj() < 14) {
            b(activity);
        }
    }

    public static String p() {
        StringBuilder sb = new StringBuilder();
        int size = Su.size();
        for (int i = 0; i < size; i++) {
            List list = Su.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.e((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.e((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.e((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static long pb() {
        return Sx;
    }

    public static byte[] pc() {
        if (St == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = St.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.ce("getScreenshot failed, curActivity " + St.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.b("getScreenshot failed, curActivity " + St.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String q() {
        return St == null ? "N/A" : St.getClass().getName();
    }
}
