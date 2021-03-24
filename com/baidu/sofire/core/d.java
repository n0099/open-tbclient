package com.baidu.sofire.core;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.g.r;
import com.baidu.sofire.g.s;
import com.baidu.sofire.g.t;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f11674a = "";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f11675b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f11676c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f11677d = false;

    public static synchronized void b(final Context context) {
        synchronized (d.class) {
            if (context == null) {
                return;
            }
            try {
                if (f11676c) {
                    f11676c = false;
                    new Thread() { // from class: com.baidu.sofire.core.d.2
                        @Override // java.lang.Thread, java.lang.Runnable
                        public final void run() {
                            try {
                                c a2 = c.a(context);
                                if (a2 != null) {
                                    c.a(1);
                                    a2.b();
                                }
                            } catch (Throwable unused) {
                                com.baidu.sofire.g.d.a();
                            }
                        }
                    }.start();
                }
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
            }
        }
    }

    public static String c(Context context) {
        com.baidu.sofire.g gVar;
        String a2;
        String b2;
        String[] split;
        byte[] re;
        try {
            gVar = new com.baidu.sofire.g(context);
            a2 = gVar.a();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        if (TextUtils.isEmpty(a2)) {
            String b3 = gVar.b();
            if (TextUtils.isEmpty(b3)) {
                if (com.baidu.sofire.g.d.b(context) == 0) {
                    b2 = com.baidu.sofire.g.f.c(context);
                } else {
                    b2 = com.baidu.sofire.g.f.b(context);
                }
                if (!TextUtils.isEmpty(b2) && (split = b2.split("\\|")) != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && (re = F.getInstance().re(split[1].getBytes(), split[0].getBytes())) != null) {
                    String str = split[0] + com.baidu.sofire.g.d.a(re);
                    gVar.a(str);
                    return str;
                }
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            }
            return b3;
        }
        return a2;
    }

    public static String d(Context context) {
        com.baidu.sofire.g gVar;
        String a2;
        byte[] re;
        try {
            gVar = new com.baidu.sofire.g(context);
            a2 = gVar.a();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        if (!TextUtils.isEmpty(a2)) {
            f11674a = a2;
            return a2;
        }
        String b2 = gVar.b();
        if (!TextUtils.isEmpty(b2)) {
            f11674a = b2;
            return b2;
        }
        String b3 = com.baidu.sofire.g.f.b(context);
        if (!TextUtils.isEmpty(b3)) {
            String[] split = b3.split("\\|");
            if (split != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                if (F.getInstance().re(split[1].getBytes(), split[0].getBytes()) != null) {
                    String str = split[0] + com.baidu.sofire.g.d.a(re);
                    gVar.a(str);
                    f11674a = str;
                    return str;
                }
            }
            f11674a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        }
        f11674a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
    }

    public static synchronized void a(final Context context, final int i, final String str, final String str2, final int... iArr) {
        synchronized (d.class) {
            try {
                if (f11675b) {
                    return;
                }
                f11675b = true;
                c.f11658b = context;
                new Thread(new Runnable() { // from class: com.baidu.sofire.core.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.baidu.sofire.g.d.k(context);
                        try {
                            r.a(context);
                            if (!com.baidu.sofire.g.d.a(context, true)) {
                                com.baidu.sofire.b.a();
                                return;
                            }
                            int a2 = com.baidu.sofire.g.d.a(context);
                            if (a2 != 1 && a2 != 3) {
                                if (a2 == 2 || a2 == 4) {
                                    com.baidu.sofire.b.a();
                                    Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
                                    intent.setClass(context, MyService.class);
                                    intent.setPackage(context.getPackageName());
                                    intent.addCategory("com.baidu.category.SOFIRE");
                                    intent.addCategory("android.intent.category.DEFAULT");
                                    Bundle bundle = new Bundle();
                                    bundle.putStringArray("appkey", new String[]{str, str2});
                                    bundle.putIntArray("key", iArr);
                                    bundle.putInt("delay", i);
                                    intent.putExtra("bundle", bundle);
                                    context.startService(intent);
                                    com.baidu.sofire.mutiprocess.b.b(context);
                                }
                                com.baidu.sofire.b.a();
                                return;
                            }
                            d.a(context);
                            c a3 = c.a(context);
                            com.baidu.sofire.g.f.a(context);
                            com.baidu.sofire.g.f.b(context);
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                String str3 = str;
                                String str4 = str2;
                                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && (!com.baidu.sofire.g.d.f11751e.equals(str3) || !com.baidu.sofire.g.d.f11752f.equals(str4))) {
                                    com.baidu.sofire.e eVar = a3.f11663a;
                                    SharedPreferences.Editor editor = eVar.f11730c;
                                    editor.putString("svi", str3 + "-" + str4);
                                    eVar.f11730c.commit();
                                }
                            }
                            if (i > 0) {
                                Thread.sleep(i * 1000);
                            }
                            new com.baidu.sofire.e(context).a(iArr);
                            if (!s.a(context)) {
                                boolean unused = d.f11676c = true;
                                return;
                            }
                            c.a(1);
                            a3.b();
                        } catch (Throwable unused2) {
                            com.baidu.sofire.g.d.a();
                        }
                    }
                }).start();
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
            }
        }
    }

    public static Pair<Integer, Object> b(String str, Class<?>[] clsArr, Object... objArr) {
        f a2;
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(1, null);
        }
        try {
            a2 = f.a();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        if (a2 == null) {
            return new Pair<>(3, null);
        }
        ApkInfo d2 = a2.d("com.baidu.sofire.x0");
        if (d2 != null) {
            Class<?> a3 = ((e) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
            return new Pair<>(0, com.baidu.sofire.g.d.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, c.f11658b), str, clsArr, objArr));
        }
        return new Pair<>(3, null);
    }

    public static Pair<Integer, Object> a(int i, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Context context = c.f11658b;
            if (context == null) {
                return new Pair<>(4, null);
            }
            if (!s.a(c.f11658b)) {
                return new Pair<>(12, null);
            }
            if (!com.baidu.sofire.g.d.a(c.f11658b, false)) {
                com.baidu.sofire.b.a();
                return new Pair<>(11, null);
            }
            String c2 = com.baidu.sofire.g.d.c(c.f11658b);
            if (TextUtils.isEmpty(c2)) {
                if (com.baidu.sofire.g.d.b(c.f11658b.getPackageName())) {
                    return new Pair<>(5, null);
                }
                com.baidu.sofire.b.a();
                return c.a(context).a(i, str, clsArr, objArr);
            } else if (com.baidu.sofire.g.d.b(c2)) {
                com.baidu.sofire.b.a();
                return b(c.f11658b, i, str, clsArr, objArr);
            } else {
                com.baidu.sofire.b.a();
                return c.a(context).a(i, str, clsArr, objArr);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return new Pair<>(3, null);
        }
    }

    public static String b(Context context, String str, int i, String str2) {
        try {
            if (!s.a(context)) {
                return "";
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        if (i != 0) {
            if (TextUtils.isEmpty(str2)) {
                a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
            } else {
                a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i), str2);
            }
        }
        return d(context);
    }

    public static Pair<Integer, Object> b(Context context, int i, String str, Class<?>[] clsArr, Object... objArr) {
        return a(context, i, 1, str, clsArr, objArr);
    }

    public static synchronized void b(Context context, boolean z) {
        synchronized (d.class) {
            if (context == null) {
                return;
            }
            try {
                int b2 = com.baidu.sofire.g.d.b(context);
                if (b2 == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("_agree_policy", z);
                    com.baidu.sofire.g.d.a(context, "setAgreePolicy", bundle);
                    return;
                }
                if (b2 == 1) {
                    com.baidu.sofire.g.d.a(context, ".ffnpp", z ? 0 : 1);
                    com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                    eVar.f11731d.putBoolean("s_a_pl", z);
                    if (Build.VERSION.SDK_INT >= 9) {
                        eVar.f11731d.apply();
                    } else {
                        eVar.f11731d.commit();
                    }
                    if (z && !f11677d) {
                        f11677d = true;
                        b(context);
                    }
                }
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
            }
        }
    }

    public static Pair<Integer, Object> a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Context context = c.f11658b;
            if (context == null) {
                return new Pair<>(4, null);
            }
            if (!com.baidu.sofire.g.d.a(c.f11658b, false)) {
                return new Pair<>(11, null);
            }
            String c2 = com.baidu.sofire.g.d.c(c.f11658b);
            if (TextUtils.isEmpty(c2)) {
                if (com.baidu.sofire.g.d.b(c.f11658b.getPackageName())) {
                    return new Pair<>(5, null);
                }
                c.a(context);
                return b(str, clsArr, objArr);
            } else if (com.baidu.sofire.g.d.b(c2)) {
                return b(c.f11658b, 1, str, clsArr, objArr);
            } else {
                c.a(context);
                return b(str, clsArr, objArr);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return new Pair<>(3, null);
        }
    }

    public static void b(Context context, String str) {
        try {
            if (s.a(context)) {
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                eVar.f11731d.putString("s_h_d_id", str);
                if (Build.VERSION.SDK_INT >= 9) {
                    eVar.f11731d.apply();
                } else {
                    eVar.f11731d.commit();
                }
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    public static boolean a(final int i, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            t.a(c.f11658b).a(new Runnable() { // from class: com.baidu.sofire.core.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Context context = c.f11658b;
                        if (context == null) {
                            for (int i2 = 0; i2 < 20; i2++) {
                                try {
                                    Thread.sleep(50L);
                                } catch (InterruptedException unused) {
                                    com.baidu.sofire.g.d.a();
                                }
                                context = c.f11658b;
                                if (context != null) {
                                    break;
                                }
                            }
                            if (context == null) {
                                com.baidu.sofire.b.a();
                                if (Callback.this != null) {
                                    Callback.this.onError(4);
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Throwable unused2) {
                        com.baidu.sofire.g.d.a();
                    }
                    if (!s.a(c.f11658b)) {
                        Callback.this.onError(12);
                    } else if (!com.baidu.sofire.g.d.a(c.f11658b, false)) {
                        com.baidu.sofire.b.a();
                        if (Callback.this != null) {
                            Callback.this.onError(11);
                        }
                    } else {
                        String c2 = com.baidu.sofire.g.d.c(c.f11658b);
                        if (TextUtils.isEmpty(c2)) {
                            if (com.baidu.sofire.g.d.b(c.f11658b.getPackageName())) {
                                if (Callback.this != null) {
                                    Callback.this.onError(5);
                                    return;
                                }
                                return;
                            }
                            com.baidu.sofire.b.a();
                            c a2 = c.a();
                            if (a2 == null) {
                                for (int i3 = 0; i3 < 20; i3++) {
                                    try {
                                        Thread.sleep(50L);
                                    } catch (InterruptedException unused3) {
                                        com.baidu.sofire.g.d.a();
                                    }
                                    a2 = c.a();
                                    if (a2 != null) {
                                        break;
                                    }
                                }
                                if (a2 == null) {
                                    if (Callback.this != null) {
                                        Callback.this.onError(11);
                                        return;
                                    }
                                    return;
                                }
                            }
                            a2.a(i, str, Callback.this, clsArr, objArr);
                            return;
                        } else if (com.baidu.sofire.g.d.b(c2)) {
                            com.baidu.sofire.b.a();
                            d.a(c.f11658b, i, str, Callback.this, clsArr, objArr);
                            return;
                        } else {
                            com.baidu.sofire.b.a();
                            c a3 = c.a();
                            if (a3 == null) {
                                for (int i4 = 0; i4 < 20; i4++) {
                                    try {
                                        Thread.sleep(50L);
                                    } catch (InterruptedException unused4) {
                                        com.baidu.sofire.g.d.a();
                                    }
                                    a3 = c.a();
                                    if (a3 != null) {
                                        break;
                                    }
                                }
                                if (a3 == null) {
                                    if (Callback.this != null) {
                                        Callback.this.onError(11);
                                        return;
                                    }
                                    return;
                                }
                            }
                            a3.a(i, str, Callback.this, clsArr, objArr);
                            return;
                        }
                        com.baidu.sofire.g.d.a();
                    }
                }
            });
            return true;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return false;
        }
    }

    public static String a(Context context, String str, int i, String str2) {
        try {
            if (!s.a(context)) {
                return c(context);
            }
            if (!TextUtils.isEmpty(f11674a)) {
                if (i != 0) {
                    if (TextUtils.isEmpty(str2)) {
                        a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
                    } else {
                        a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i), str2);
                    }
                }
                return f11674a;
            } else if (!com.baidu.sofire.g.d.a(context, false)) {
                com.baidu.sofire.b.a();
                return "";
            } else {
                String c2 = com.baidu.sofire.g.d.c(context);
                if (TextUtils.isEmpty(c2)) {
                    if (com.baidu.sofire.g.d.b(context.getPackageName())) {
                        return "";
                    }
                    com.baidu.sofire.b.a();
                    return b(context, str, i, str2);
                } else if (com.baidu.sofire.g.d.b(c2)) {
                    com.baidu.sofire.b.a();
                    Pair<Integer, Object> b2 = b(context, 0, "gzfi", null, str, Integer.valueOf(i), str2);
                    return (b2 == null || ((Integer) b2.first).intValue() != 0) ? "" : (String) b2.second;
                } else {
                    com.baidu.sofire.b.a();
                    return b(context, str, i, str2);
                }
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        return "";
    }

    public static void a(Context context, boolean z) {
        if (s.a(context)) {
            new com.baidu.sofire.e(context).a(z);
        }
    }

    public static String a(Context context) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        if (!TextUtils.isEmpty(f11674a)) {
            return f11674a;
        }
        if (!s.a(context)) {
            return c(context);
        }
        if (!com.baidu.sofire.g.d.a(context, false)) {
            com.baidu.sofire.b.a();
            return "";
        }
        String c2 = com.baidu.sofire.g.d.c(context);
        if (TextUtils.isEmpty(c2)) {
            if (com.baidu.sofire.g.d.b(context.getPackageName())) {
                return "";
            }
            com.baidu.sofire.b.a();
            return d(context);
        } else if (com.baidu.sofire.g.d.b(c2)) {
            com.baidu.sofire.b.a();
            Pair<Integer, Object> b2 = b(context, 0, "gz", null, new Object[0]);
            if (b2 != null) {
                return ((Integer) b2.first).intValue() == 0 ? (String) b2.second : "";
            }
            f11674a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        } else {
            com.baidu.sofire.b.a();
            return d(context);
        }
    }

    public static String a(Context context, String str) {
        int i;
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            i = 501;
        }
        if (s.a(context)) {
            Pair<Integer, Object> a2 = a("xgz", new Class[]{String.class}, str);
            if (((Integer) a2.first).intValue() == 0 && !TextUtils.isEmpty((String) a2.second)) {
                return (String) a2.second;
            }
            i = ((Integer) a2.first).intValue() == 0 ? 502 : ((Integer) a2.first).intValue();
            try {
                return new JSONObject().put("rc", i).put("z", a(context)).toString();
            } catch (Throwable unused2) {
                com.baidu.sofire.g.d.a();
                return "";
            }
        }
        return "";
    }

    public static String a(Context context, String str, String str2, int i, String str3) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        if (s.a(context)) {
            if (context != null && !TextUtils.isEmpty(str)) {
                Pair<Integer, Object> a2 = a(100067, "retrieveToken", new Class[]{String.class, String.class, Integer.TYPE, String.class}, str, str2, Integer.valueOf(i), str3);
                if (((Integer) a2.first).intValue() == 0) {
                    String str4 = (String) a2.second;
                    com.baidu.sofire.b.a();
                    return !TextUtils.isEmpty(str4) ? str4 : com.baidu.sofire.g.d.a(context, 9);
                }
                new StringBuilder("gt failed ").append(a2.first);
                com.baidu.sofire.b.a();
                if (((Integer) a2.first).intValue() != 4 && ((Integer) a2.first).intValue() != 3) {
                    if (((Integer) a2.first).intValue() == 5 || ((Integer) a2.first).intValue() == 11) {
                        return com.baidu.sofire.g.d.a(context, 7);
                    }
                    return com.baidu.sofire.g.d.a(context, 8);
                }
                String[] h2 = com.baidu.sofire.g.d.h(context);
                StringBuilder sb = new StringBuilder("gt method try ");
                sb.append(h2[0]);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                sb.append(h2[1]);
                com.baidu.sofire.b.a();
                a(context, 0, h2[0], h2[1], 100067);
                return com.baidu.sofire.g.d.a(context, ((Integer) a2.first).intValue() == 3 ? 5 : 2);
            }
            return com.baidu.sofire.g.d.a(context, 8);
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0092 A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x01b7, blocks: (B:3:0x000b, B:7:0x002c, B:27:0x00b6, B:30:0x00c2, B:65:0x018f, B:67:0x0197, B:69:0x01a1, B:70:0x01a5, B:72:0x01b3, B:31:0x00c7, B:33:0x00e0, B:34:0x00e3, B:36:0x00e6, B:38:0x00f0, B:40:0x00f8, B:42:0x00fe, B:44:0x011c, B:43:0x0112, B:45:0x0120, B:48:0x0126, B:50:0x012e, B:52:0x0137, B:54:0x014c, B:61:0x016f, B:51:0x0133, B:56:0x0153, B:58:0x0163, B:8:0x0031, B:10:0x0042, B:12:0x0047, B:20:0x0096, B:22:0x00a2, B:23:0x00a6, B:19:0x0092, B:13:0x006e, B:15:0x0073), top: B:77:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2 A[Catch: all -> 0x00af, TryCatch #2 {all -> 0x01b7, blocks: (B:3:0x000b, B:7:0x002c, B:27:0x00b6, B:30:0x00c2, B:65:0x018f, B:67:0x0197, B:69:0x01a1, B:70:0x01a5, B:72:0x01b3, B:31:0x00c7, B:33:0x00e0, B:34:0x00e3, B:36:0x00e6, B:38:0x00f0, B:40:0x00f8, B:42:0x00fe, B:44:0x011c, B:43:0x0112, B:45:0x0120, B:48:0x0126, B:50:0x012e, B:52:0x0137, B:54:0x014c, B:61:0x016f, B:51:0x0133, B:56:0x0153, B:58:0x0163, B:8:0x0031, B:10:0x0042, B:12:0x0047, B:20:0x0096, B:22:0x00a2, B:23:0x00a6, B:19:0x0092, B:13:0x006e, B:15:0x0073), top: B:77:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6 A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #2 {all -> 0x01b7, blocks: (B:3:0x000b, B:7:0x002c, B:27:0x00b6, B:30:0x00c2, B:65:0x018f, B:67:0x0197, B:69:0x01a1, B:70:0x01a5, B:72:0x01b3, B:31:0x00c7, B:33:0x00e0, B:34:0x00e3, B:36:0x00e6, B:38:0x00f0, B:40:0x00f8, B:42:0x00fe, B:44:0x011c, B:43:0x0112, B:45:0x0120, B:48:0x0126, B:50:0x012e, B:52:0x0137, B:54:0x014c, B:61:0x016f, B:51:0x0133, B:56:0x0153, B:58:0x0163, B:8:0x0031, B:10:0x0042, B:12:0x0047, B:20:0x0096, B:22:0x00a2, B:23:0x00a6, B:19:0x0092, B:13:0x006e, B:15:0x0073), top: B:77:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle a(Context context, String str, Bundle bundle) {
        Pair<Integer, Object> a2;
        Integer num;
        String str2;
        String b2;
        final Bundle bundle2 = new Bundle();
        try {
            new StringBuilder().append(str);
            com.baidu.sofire.b.a();
            Class[] clsArr = null;
            String str3 = null;
            if ("gzfi".equals(str)) {
                if (bundle != null) {
                    CallArgs callArgs = new CallArgs();
                    bundle.setClassLoader(MyProvider.class.getClassLoader());
                    CallArgs callArgs2 = (CallArgs) bundle.getParcelable("args");
                    if (callArgs2 != null) {
                        if (callArgs2.f11647e.length == 2) {
                            String str4 = (String) callArgs2.f11647e[0];
                            num = (Integer) callArgs2.f11647e[1];
                            StringBuilder sb = new StringBuilder("args ");
                            sb.append(str4);
                            sb.append(" ");
                            sb.append(num);
                            com.baidu.sofire.b.a();
                            str3 = str4;
                            str2 = null;
                        } else if (callArgs2.f11647e.length == 3) {
                            str3 = (String) callArgs2.f11647e[0];
                            Integer num2 = (Integer) callArgs2.f11647e[1];
                            str2 = (String) callArgs2.f11647e[2];
                            num = num2;
                        }
                        b2 = b(context, str3, num != null ? 0 : num.intValue(), str2);
                        if (!TextUtils.isEmpty(b2)) {
                            bundle2.putInt("status", 8);
                        } else {
                            callArgs.f11648f = b2;
                            bundle2.putParcelable("result", callArgs);
                            bundle2.putInt("status", 0);
                        }
                        return bundle2;
                    }
                    num = null;
                    str2 = null;
                    b2 = b(context, str3, num != null ? 0 : num.intValue(), str2);
                    if (!TextUtils.isEmpty(b2)) {
                    }
                    return bundle2;
                }
            } else if (!"invokeMethod".equals(str)) {
                if ("gz".equals(str)) {
                    String d2 = d(context);
                    if (TextUtils.isEmpty(d2)) {
                        bundle2.putInt("status", 8);
                    } else {
                        CallArgs callArgs3 = new CallArgs();
                        callArgs3.f11648f = d2;
                        bundle2.putParcelable("result", callArgs3);
                        bundle2.putInt("status", 0);
                    }
                    return bundle2;
                }
                bundle2.putInt("status", 2);
                return bundle2;
            } else if (bundle != null) {
                final CallArgs callArgs4 = new CallArgs();
                bundle.setClassLoader(MyProvider.class.getClassLoader());
                CallArgs callArgs5 = (CallArgs) bundle.getParcelable("args");
                int i = callArgs5.f11643a;
                int i2 = callArgs5.f11644b;
                final String str5 = callArgs5.f11645c;
                Object[] objArr = callArgs5.f11646d;
                if (objArr != null) {
                    clsArr = new Class[objArr.length];
                    for (int i3 = 0; i3 < objArr.length; i3++) {
                        String str6 = (String) objArr[i3];
                        if (!TextUtils.isEmpty(str6) && str6.contains("@@")) {
                            Class<?> a3 = com.baidu.sofire.g.d.a(str6);
                            if (a3 != null) {
                                new StringBuilder("convert back class name ").append(a3.getCanonicalName());
                                com.baidu.sofire.b.a();
                                clsArr[i3] = a3;
                            }
                        } else {
                            clsArr[i3] = Class.forName((String) objArr[i3]);
                        }
                    }
                }
                Object[] objArr2 = callArgs5.f11647e;
                if (i2 == 1) {
                    if (i == 1 && "xgz".equals(str5)) {
                        a2 = b(str5, clsArr, objArr2);
                    } else {
                        a2 = a(i, str5, clsArr, objArr2);
                    }
                    bundle2.putInt("status", ((Integer) a2.first).intValue());
                    if (((Integer) a2.first).intValue() == 0) {
                        callArgs4.f11648f = a2.second;
                    }
                } else if (i2 == 0) {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    a(i, str5, new Callback() { // from class: com.baidu.sofire.core.d.4
                        @Override // com.baidu.sofire.ac.Callback
                        public final Object onEnd(Object... objArr3) {
                            try {
                                try {
                                    bundle2.putInt("status", 0);
                                    callArgs4.f11648f = objArr3[0];
                                } catch (Throwable th) {
                                    countDownLatch.countDown();
                                    throw th;
                                }
                            } catch (Throwable unused) {
                                com.baidu.sofire.g.d.a();
                            }
                            countDownLatch.countDown();
                            return null;
                        }

                        @Override // com.baidu.sofire.ac.Callback
                        public final Object onError(Object... objArr3) {
                            try {
                                try {
                                    bundle2.putInt("status", ((Integer) objArr3[0]).intValue());
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(str5);
                                    sb2.append("onError ");
                                    sb2.append(String.valueOf(objArr3[0]));
                                    com.baidu.sofire.b.a();
                                } catch (Throwable th) {
                                    countDownLatch.countDown();
                                    throw th;
                                }
                            } catch (Throwable unused) {
                                com.baidu.sofire.g.d.a();
                            }
                            countDownLatch.countDown();
                            return null;
                        }
                    }, clsArr, objArr2);
                    countDownLatch.await(180000L, TimeUnit.MILLISECONDS);
                }
                new StringBuilder("return bundle").append(bundle2.getInt("status"));
                com.baidu.sofire.b.a();
                bundle2.putParcelable("result", callArgs4);
                return bundle2;
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        bundle2.putInt("status", 10);
        return bundle2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[Catch: all -> 0x017d, TryCatch #4 {all -> 0x017d, blocks: (B:3:0x0004, B:5:0x000b, B:7:0x0014, B:9:0x001c, B:14:0x0029, B:16:0x0037, B:17:0x003b, B:19:0x003e, B:21:0x0046, B:23:0x0052, B:25:0x006e, B:24:0x0066, B:26:0x0071, B:27:0x0073, B:33:0x00ae, B:64:0x0134, B:66:0x013d, B:68:0x014e, B:70:0x0158, B:74:0x0162, B:73:0x0160, B:38:0x00b9, B:44:0x00c6, B:46:0x00cc, B:47:0x00d5, B:49:0x00df, B:62:0x012f, B:51:0x00e8, B:53:0x00f6, B:54:0x00f9, B:56:0x00ff, B:58:0x011c, B:59:0x011f, B:36:0x00b4), top: B:89:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c6 A[Catch: all -> 0x017d, TryCatch #4 {all -> 0x017d, blocks: (B:3:0x0004, B:5:0x000b, B:7:0x0014, B:9:0x001c, B:14:0x0029, B:16:0x0037, B:17:0x003b, B:19:0x003e, B:21:0x0046, B:23:0x0052, B:25:0x006e, B:24:0x0066, B:26:0x0071, B:27:0x0073, B:33:0x00ae, B:64:0x0134, B:66:0x013d, B:68:0x014e, B:70:0x0158, B:74:0x0162, B:73:0x0160, B:38:0x00b9, B:44:0x00c6, B:46:0x00cc, B:47:0x00d5, B:49:0x00df, B:62:0x012f, B:51:0x00e8, B:53:0x00f6, B:54:0x00f9, B:56:0x00ff, B:58:0x011c, B:59:0x011f, B:36:0x00b4), top: B:89:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0134 A[Catch: all -> 0x017d, TryCatch #4 {all -> 0x017d, blocks: (B:3:0x0004, B:5:0x000b, B:7:0x0014, B:9:0x001c, B:14:0x0029, B:16:0x0037, B:17:0x003b, B:19:0x003e, B:21:0x0046, B:23:0x0052, B:25:0x006e, B:24:0x0066, B:26:0x0071, B:27:0x0073, B:33:0x00ae, B:64:0x0134, B:66:0x013d, B:68:0x014e, B:70:0x0158, B:74:0x0162, B:73:0x0160, B:38:0x00b9, B:44:0x00c6, B:46:0x00cc, B:47:0x00d5, B:49:0x00df, B:62:0x012f, B:51:0x00e8, B:53:0x00f6, B:54:0x00f9, B:56:0x00ff, B:58:0x011c, B:59:0x011f, B:36:0x00b4), top: B:89:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013d A[Catch: all -> 0x017d, TryCatch #4 {all -> 0x017d, blocks: (B:3:0x0004, B:5:0x000b, B:7:0x0014, B:9:0x001c, B:14:0x0029, B:16:0x0037, B:17:0x003b, B:19:0x003e, B:21:0x0046, B:23:0x0052, B:25:0x006e, B:24:0x0066, B:26:0x0071, B:27:0x0073, B:33:0x00ae, B:64:0x0134, B:66:0x013d, B:68:0x014e, B:70:0x0158, B:74:0x0162, B:73:0x0160, B:38:0x00b9, B:44:0x00c6, B:46:0x00cc, B:47:0x00d5, B:49:0x00df, B:62:0x012f, B:51:0x00e8, B:53:0x00f6, B:54:0x00f9, B:56:0x00ff, B:58:0x011c, B:59:0x011f, B:36:0x00b4), top: B:89:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Object> a(Context context, int i, int i2, String str, Class<?>[] clsArr, Object... objArr) {
        String str2;
        ContentProviderClient contentProviderClient;
        Bundle bundle;
        try {
            if (TextUtils.isEmpty(str)) {
                return Pair.create(1, null);
            }
            if (!"gzfi".equals(str) && !"gz".equals(str)) {
                str2 = "invokeMethod";
                CallArgs callArgs = new CallArgs();
                callArgs.f11643a = i;
                callArgs.f11645c = str;
                callArgs.f11644b = i2;
                if (clsArr != null) {
                    Object[] objArr2 = new Object[clsArr.length];
                    for (int i3 = 0; i3 < clsArr.length; i3++) {
                        if (clsArr[i3].isPrimitive()) {
                            String a2 = com.baidu.sofire.g.d.a(clsArr[i3]);
                            if (!TextUtils.isEmpty(a2)) {
                                objArr2[i3] = a2 + "@@";
                            }
                        } else {
                            objArr2[i3] = clsArr[i3].getName();
                        }
                    }
                    callArgs.f11646d = objArr2;
                }
                callArgs.f11647e = objArr;
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("args", callArgs);
                Uri parse = Uri.parse("content://" + context.getPackageName() + ".sofire.ac.provider");
                if (Build.VERSION.SDK_INT < 17) {
                    try {
                        contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(parse);
                    } catch (Throwable unused) {
                        contentProviderClient = null;
                    }
                    try {
                        bundle = contentProviderClient.call(str2, null, bundle2);
                        if (contentProviderClient != 0) {
                            contentProviderClient.release();
                        }
                    } catch (Throwable unused2) {
                        com.baidu.sofire.g.d.a();
                        if (contentProviderClient != null) {
                            contentProviderClient.release();
                        }
                        bundle = null;
                        if (bundle == null) {
                        }
                    }
                } else if (Build.VERSION.SDK_INT >= 11) {
                    bundle = context.getContentResolver().call(parse, str2, (String) null, bundle2);
                } else {
                    ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                    if (acquireContentProviderClient == null) {
                        return Pair.create(3, null);
                    }
                    Field declaredField = ContentProviderClient.class.getDeclaredField("mContentProvider");
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(acquireContentProviderClient);
                    if (obj != null) {
                        Method declaredMethod = Class.forName("android.content.IContentProvider").getDeclaredMethod(NotificationCompat.CATEGORY_CALL, String.class, String.class, Bundle.class);
                        if (!declaredMethod.isAccessible()) {
                            declaredMethod.setAccessible(true);
                        }
                        bundle = (Bundle) declaredMethod.invoke(obj, str2, null, bundle2);
                    } else {
                        bundle = null;
                    }
                    acquireContentProviderClient.release();
                }
                if (bundle == null) {
                    return Pair.create(3, null);
                }
                bundle.setClassLoader(CallArgs.class.getClassLoader());
                int i4 = bundle.getInt("status");
                CallArgs callArgs2 = i4 == 0 ? (CallArgs) bundle.getParcelable("result") : null;
                return Pair.create(Integer.valueOf(i4), callArgs2 == null ? null : callArgs2.f11648f);
            }
            str2 = str;
            CallArgs callArgs3 = new CallArgs();
            callArgs3.f11643a = i;
            callArgs3.f11645c = str;
            callArgs3.f11644b = i2;
            if (clsArr != null) {
            }
            callArgs3.f11647e = objArr;
            Bundle bundle22 = new Bundle();
            bundle22.putParcelable("args", callArgs3);
            Uri parse2 = Uri.parse("content://" + context.getPackageName() + ".sofire.ac.provider");
            if (Build.VERSION.SDK_INT < 17) {
            }
            if (bundle == null) {
            }
        } catch (Throwable unused3) {
            com.baidu.sofire.g.d.a();
            return Pair.create(3, null);
        }
    }

    public static /* synthetic */ void a(final Context context, final int i, final String str, final Callback callback, final Class[] clsArr, final Object[] objArr) {
        try {
            if (!TextUtils.isEmpty(str)) {
                new Thread() { // from class: com.baidu.sofire.core.d.5
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        super.run();
                        Callback callback2 = Callback.this;
                        if (callback2 != null) {
                            callback2.onBegin(new Object[0]);
                        }
                        Pair a2 = d.a(context, i, 0, str, clsArr, objArr);
                        if (Callback.this != null) {
                            if (((Integer) a2.first).intValue() != 0) {
                                Callback.this.onError(a2.first);
                            } else {
                                Callback.this.onEnd(a2.second);
                            }
                        }
                    }
                }.start();
            } else if (callback != null) {
                callback.onError(1);
            }
        } catch (Throwable unused) {
            if (callback != null) {
                try {
                    callback.onError(3);
                } catch (Throwable unused2) {
                }
            }
            com.baidu.sofire.g.d.a();
        }
    }
}
