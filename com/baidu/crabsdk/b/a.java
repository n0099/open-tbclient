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
    private static Activity Jl;
    private static long Jp;
    private static com.baidu.crabsdk.c.b<List> Jm = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean Jn = false;
    private static boolean Jo = true;
    private static int aQ = 0;
    private static int Jq = 0;
    private static int Jr = 0;

    public static void a(Activity activity) {
        Jn = true;
        Jl = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        Jm.add(arrayList);
        int size = Jm.size();
        if (size >= 2) {
            List list = Jm.get(size - 2);
            if (list.size() == 3 && ((Date) Jm.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aQ++;
            }
        } else {
            aQ++;
        }
        Jq = (Jq + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (Jo) {
            Jo = false;
            Jp = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (Jl != null && activity != null && Jl.hashCode() == activity.hashCode()) {
            Jl = null;
        }
        int i = Jq - Jr;
        int size = Jm.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = Jm.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        Jr = (Jr + 1) % 100;
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
        if (Jl == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = Jl.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.bu("getScreenshot failed, curActivity " + Jl.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.f("getScreenshot failed, curActivity " + Jl.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static long o() {
        return Jp;
    }

    public static String p() {
        StringBuilder sb = new StringBuilder();
        int size = Jm.size();
        for (int i = 0; i < size; i++) {
            List list = Jm.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.a((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String q() {
        return Jl == null ? "N/A" : Jl.getClass().getName();
    }
}
