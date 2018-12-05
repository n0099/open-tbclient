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
/* loaded from: classes6.dex */
public final class a {
    private static Activity XM;
    private static long XQ;
    private static com.baidu.crabsdk.c.b<List> XN = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean XO = false;
    private static boolean XP = true;
    private static int aQ = 0;
    private static int aR = 0;
    private static int aS = 0;

    public static void a(Activity activity) {
        XO = true;
        XM = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        XN.add(arrayList);
        int size = XN.size();
        if (size >= 2) {
            List list = XN.get(size - 2);
            if (list.size() == 3 && ((Date) XN.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aQ++;
            }
        } else {
            aQ++;
        }
        aR = (aR + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (XP) {
            XP = false;
            XQ = System.currentTimeMillis();
            if (com.baidu.crabsdk.c.c.rr() >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (XM != null && activity != null && XM.hashCode() == activity.hashCode()) {
            XM = null;
        }
        int i = aR - aS;
        int size = XN.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = XN.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        aS = (aS + 1) % 100;
    }

    public static void doActivityStart(Activity activity) {
        if (com.baidu.crabsdk.c.c.rr() < 14) {
            a(activity);
        }
    }

    public static void doActivityStop(Activity activity) {
        if (com.baidu.crabsdk.c.c.rr() < 14) {
            b(activity);
        }
    }

    public static String p() {
        StringBuilder sb = new StringBuilder();
        int size = XN.size();
        for (int i = 0; i < size; i++) {
            List list = XN.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.e((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.e((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.e((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String q() {
        return XM == null ? "N/A" : XM.getClass().getName();
    }

    public static long rl() {
        return XQ;
    }

    public static byte[] rm() {
        if (XM == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = XM.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.cG("getScreenshot failed, curActivity " + XM.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.f("getScreenshot failed, curActivity " + XM.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
