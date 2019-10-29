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
/* loaded from: classes3.dex */
public final class a {
    private static Activity JL;
    private static long JP;
    private static com.baidu.crabsdk.c.b<List> JM = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean JN = false;
    private static boolean JO = true;
    private static int aQ = 0;
    private static int JQ = 0;
    private static int JR = 0;

    public static void a(Activity activity) {
        JN = true;
        JL = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        JM.add(arrayList);
        int size = JM.size();
        if (size >= 2) {
            List list = JM.get(size - 2);
            if (list.size() == 3 && ((Date) JM.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aQ++;
            }
        } else {
            aQ++;
        }
        JQ = (JQ + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (JO) {
            JO = false;
            JP = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (JL != null && activity != null && JL.hashCode() == activity.hashCode()) {
            JL = null;
        }
        int i = JQ - JR;
        int size = JM.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = JM.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        JR = (JR + 1) % 100;
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

    public static byte[] mn() {
        if (JL == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = JL.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.bu("getScreenshot failed, curActivity " + JL.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.f("getScreenshot failed, curActivity " + JL.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static long o() {
        return JP;
    }

    public static String p() {
        StringBuilder sb = new StringBuilder();
        int size = JM.size();
        for (int i = 0; i < size; i++) {
            List list = JM.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.a((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String q() {
        return JL == null ? "N/A" : JL.getClass().getName();
    }
}
