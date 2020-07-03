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
    private static Activity ama;
    private static long amd;
    private static com.baidu.crabsdk.c.b<List> amb = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean amc = false;
    private static boolean aQ = true;
    private static int aS = 0;
    private static int ame = 0;
    private static int amf = 0;
    private static boolean amg = false;

    public static void a(Activity activity) {
        amc = true;
        ama = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        amb.add(arrayList);
        int size = amb.size();
        if (size >= 2) {
            List list = amb.get(size - 2);
            if (list.size() == 3 && ((Date) amb.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aS++;
            }
        } else {
            aS++;
        }
        ame = (ame + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (aQ) {
            aQ = false;
            amd = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (ama != null && activity != null && ama.hashCode() == activity.hashCode()) {
            ama = null;
        }
        int i = ame - amf;
        int size = amb.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = amb.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        amf = (amf + 1) % 100;
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
        return amd;
    }

    public static String q() {
        StringBuilder sb = new StringBuilder();
        int size = amb.size();
        for (int i = 0; i < size; i++) {
            List list = amb.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.a((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String r() {
        if (ama == null) {
            com.baidu.crabsdk.c.a.di("cur Page info is null!");
            return "N/A";
        }
        return ama.getClass().getName();
    }

    public static byte[] te() {
        if (ama == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = ama.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.di("getScreenshot failed, curActivity " + ama.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("getScreenshot failed, curActivity " + ama.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
