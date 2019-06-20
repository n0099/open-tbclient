package com.baidu.crabsdk.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import com.baidu.sapi2.base.network.Apn;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public final class a {
    private static Activity Zp;
    private static long Zt;
    private static com.baidu.crabsdk.c.b<List> Zq = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean Zr = false;
    private static boolean Zs = true;
    private static int aQ = 0;
    private static int aR = 0;
    private static int aS = 0;

    public static void a(Activity activity) {
        Zr = true;
        Zp = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        Zq.add(arrayList);
        int size = Zq.size();
        if (size >= 2) {
            List list = Zq.get(size - 2);
            if (list.size() == 3 && ((Date) Zq.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                aQ++;
            }
        } else {
            aQ++;
        }
        aR = (aR + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (Zs) {
            Zs = false;
            Zt = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (Zp != null && activity != null && Zp.hashCode() == activity.hashCode()) {
            Zp = null;
        }
        int i = aR - aS;
        int size = Zq.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = Zq.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        aS = (aS + 1) % 100;
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

    public static String p() {
        StringBuilder sb = new StringBuilder();
        int size = Zq.size();
        for (int i = 0; i < size; i++) {
            List list = Zq.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.e((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.e((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.e((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String q() {
        return Zp == null ? Apn.APN_UNKNOWN : Zp.getClass().getName();
    }

    public static long qK() {
        return Zt;
    }

    public static byte[] qL() {
        if (Zp == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = Zp.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.cf("getScreenshot failed, curActivity " + Zp.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("getScreenshot failed, curActivity " + Zp.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
