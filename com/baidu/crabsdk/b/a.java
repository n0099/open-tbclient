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
    private static Activity akE;
    private static long akH;
    private static com.baidu.crabsdk.c.b<List> akF = new com.baidu.crabsdk.c.b<>(com.baidu.crabsdk.a.e);
    private static boolean akG = false;
    private static boolean aQ = true;
    private static int akI = 0;
    private static int akJ = 0;
    private static int akK = 0;
    private static boolean akL = false;

    public static void a(Activity activity) {
        akG = true;
        akE = activity;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getClass().getName());
        arrayList.add(new Date());
        akF.add(arrayList);
        int size = akF.size();
        if (size >= 2) {
            List list = akF.get(size - 2);
            if (list.size() == 3 && ((Date) akF.get(size - 1).get(1)).getTime() - ((Date) list.get(2)).getTime() > com.baidu.crabsdk.a.l) {
                akI++;
            }
        } else {
            akI++;
        }
        akJ = (akJ + 1) % 100;
    }

    @SuppressLint({"NewApi"})
    public static void a(Application application) {
        if (aQ) {
            aQ = false;
            akH = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        if (akE != null && activity != null && akE.hashCode() == activity.hashCode()) {
            akE = null;
        }
        int i = akJ - akK;
        int size = akF.size();
        if (i < 0) {
            i += 100;
        }
        if (i > 0 && size >= i) {
            List list = akF.get(size - i);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        akK = (akK + 1) % 100;
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
        return akH;
    }

    public static String q() {
        StringBuilder sb = new StringBuilder();
        int size = akF.size();
        for (int i = 0; i < size; i++) {
            List list = akF.get((size - i) - 1);
            if (list.size() == 3) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ").append(com.baidu.crabsdk.c.c.a((Date) list.get(2))).append("\n");
            } else if (list.size() == 2) {
                sb.append((String) list.get(0)).append(" from ").append(com.baidu.crabsdk.c.c.a((Date) list.get(1))).append(" to ...\n");
            }
        }
        return sb.toString();
    }

    public static String r() {
        if (akE == null) {
            com.baidu.crabsdk.c.a.dg("cur Page info is null!");
            return "N/A";
        }
        return akE.getClass().getName();
    }

    public static byte[] sJ() {
        if (akE == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = akE.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                com.baidu.crabsdk.c.a.dg("getScreenshot failed, curActivity " + akE.getClass().getName());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("getScreenshot failed, curActivity " + akE.getClass().getName(), e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
