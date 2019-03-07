package com.baidu.sofire.core;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.F;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e {
    public static String a = "";

    public static void a(final Context context, final int i, final String str, final String str2, final int... iArr) {
        try {
            new Thread(new Runnable() { // from class: com.baidu.sofire.core.e.1
                /* JADX WARN: Code restructure failed: missing block: B:42:0x0109, code lost:
                    if (r5[1].equals(new java.lang.StringBuffer(r4).reverse().toString()) == false) goto L27;
                 */
                /* JADX WARN: Removed duplicated region for block: B:28:0x00b7 A[Catch: Throwable -> 0x015c, TRY_LEAVE, TryCatch #3 {Throwable -> 0x001f, blocks: (B:3:0x0002, B:5:0x000f, B:7:0x0013, B:9:0x001b, B:13:0x0024, B:29:0x00bf, B:31:0x00d3, B:33:0x00db, B:39:0x00ec, B:34:0x00df, B:36:0x00e5, B:56:0x0162, B:58:0x016b, B:60:0x0174, B:26:0x00b3, B:28:0x00b7, B:14:0x0036, B:16:0x008b, B:18:0x0094, B:20:0x009d, B:22:0x00a1, B:24:0x00aa, B:41:0x00f5, B:44:0x010d, B:49:0x0152, B:51:0x0158), top: B:66:0x0002 }] */
                /* JADX WARN: Removed duplicated region for block: B:31:0x00d3 A[Catch: Throwable -> 0x001f, TryCatch #3 {Throwable -> 0x001f, blocks: (B:3:0x0002, B:5:0x000f, B:7:0x0013, B:9:0x001b, B:13:0x0024, B:29:0x00bf, B:31:0x00d3, B:33:0x00db, B:39:0x00ec, B:34:0x00df, B:36:0x00e5, B:56:0x0162, B:58:0x016b, B:60:0x0174, B:26:0x00b3, B:28:0x00b7, B:14:0x0036, B:16:0x008b, B:18:0x0094, B:20:0x009d, B:22:0x00a1, B:24:0x00aa, B:41:0x00f5, B:44:0x010d, B:49:0x0152, B:51:0x0158), top: B:66:0x0002 }] */
                /* JADX WARN: Removed duplicated region for block: B:44:0x010d A[Catch: Throwable -> 0x014c, TRY_LEAVE, TryCatch #3 {Throwable -> 0x001f, blocks: (B:3:0x0002, B:5:0x000f, B:7:0x0013, B:9:0x001b, B:13:0x0024, B:29:0x00bf, B:31:0x00d3, B:33:0x00db, B:39:0x00ec, B:34:0x00df, B:36:0x00e5, B:56:0x0162, B:58:0x016b, B:60:0x0174, B:26:0x00b3, B:28:0x00b7, B:14:0x0036, B:16:0x008b, B:18:0x0094, B:20:0x009d, B:22:0x00a1, B:24:0x00aa, B:41:0x00f5, B:44:0x010d, B:49:0x0152, B:51:0x0158), top: B:66:0x0002 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() {
                    String str3;
                    String str4;
                    boolean z = true;
                    try {
                        d.b = context;
                        if (!com.baidu.sofire.b.e.a(context, true)) {
                            com.baidu.sofire.b.a();
                        } else if (!com.baidu.sofire.b.e.a(context)) {
                            com.baidu.sofire.b.a();
                        } else {
                            e.a(context);
                            d a2 = d.a(context);
                            com.baidu.sofire.b.g.a(context);
                            Context context2 = context;
                            String d = com.baidu.sofire.b.g.d(context2);
                            String e = com.baidu.sofire.b.g.e(context2);
                            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context2);
                            String string = eVar.a.getString("cczd_s", "");
                            String o = eVar.o();
                            new StringBuilder("sj iem ").append(d).append(" zdd ").append(o);
                            com.baidu.sofire.b.a();
                            String a3 = com.baidu.sofire.b.g.a((d + e).getBytes());
                            if (TextUtils.isEmpty(string)) {
                                eVar.b(a3);
                                if (!TextUtils.isEmpty(o)) {
                                    String[] split = o.split("\\|");
                                    if (split != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                    }
                                    if (i > 0) {
                                        Thread.sleep(i * 1000);
                                    }
                                    new com.baidu.sofire.e(context).a(iArr);
                                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                        str3 = str;
                                        str4 = str2;
                                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && (!"3".equals(str3) || !"925fc15df8a49bed0b3eca8d2b44cb7b".equals(str4))) {
                                            com.baidu.sofire.e eVar2 = a2.a;
                                            eVar2.c.putString("svi", str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str4);
                                            eVar2.c.commit();
                                        }
                                    }
                                    d.a(1);
                                    a2.a((Callback) null);
                                }
                                z = false;
                                if (z) {
                                    com.baidu.sofire.b.a();
                                    eVar.a("");
                                    com.baidu.sofire.b.g.a(context2);
                                    e.a = "";
                                    com.baidu.sofire.g gVar = new com.baidu.sofire.g(context2);
                                    gVar.b.putString("xytk", "");
                                    gVar.b.commit();
                                    gVar.a("");
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("0", o);
                                    com.baidu.sofire.b.e.a(context2, "1003142", hashMap);
                                }
                                if (i > 0) {
                                }
                                new com.baidu.sofire.e(context).a(iArr);
                                if (!TextUtils.isEmpty(str)) {
                                    str3 = str;
                                    str4 = str2;
                                    if (!TextUtils.isEmpty(str3)) {
                                        com.baidu.sofire.e eVar22 = a2.a;
                                        eVar22.c.putString("svi", str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str4);
                                        eVar22.c.commit();
                                    }
                                }
                                d.a(1);
                                a2.a((Callback) null);
                            }
                            if (!string.equals(a3)) {
                                eVar.b(a3);
                                if (z) {
                                }
                                if (i > 0) {
                                }
                                new com.baidu.sofire.e(context).a(iArr);
                                if (!TextUtils.isEmpty(str)) {
                                }
                                d.a(1);
                                a2.a((Callback) null);
                            }
                            z = false;
                            if (z) {
                            }
                            if (i > 0) {
                            }
                            new com.baidu.sofire.e(context).a(iArr);
                            if (!TextUtils.isEmpty(str)) {
                            }
                            d.a(1);
                            a2.a((Callback) null);
                        }
                    } catch (Throwable th) {
                        com.baidu.sofire.b.e.a();
                    }
                }
            }).start();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
    }

    public static Pair<Integer, Object> a(int i, String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> a2;
        try {
            Context context = d.b;
            if (context == null) {
                a2 = new Pair<>(4, null);
            } else if (!com.baidu.sofire.b.e.a(d.b, false)) {
                com.baidu.sofire.b.a();
                a2 = new Pair<>(11, null);
            } else {
                String b = com.baidu.sofire.b.e.b(d.b);
                if (TextUtils.isEmpty(b)) {
                    if (com.baidu.sofire.b.e.b(d.b.getPackageName())) {
                        a2 = new Pair<>(5, null);
                    } else {
                        com.baidu.sofire.b.a();
                        a2 = d.a(context).a(i, str, clsArr, objArr);
                    }
                } else if (com.baidu.sofire.b.e.b(b)) {
                    com.baidu.sofire.b.a();
                    a2 = b(d.b, i, str, clsArr, objArr);
                } else {
                    com.baidu.sofire.b.a();
                    a2 = d.a(context).a(i, str, clsArr, objArr);
                }
            }
            return a2;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
            return new Pair<>(3, null);
        }
    }

    private static Pair<Integer, Object> a(String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> b;
        try {
            Context context = d.b;
            if (context == null) {
                b = new Pair<>(4, null);
            } else if (!com.baidu.sofire.b.e.a(d.b, false)) {
                com.baidu.sofire.b.a();
                b = new Pair<>(11, null);
            } else {
                String b2 = com.baidu.sofire.b.e.b(d.b);
                if (TextUtils.isEmpty(b2)) {
                    if (com.baidu.sofire.b.e.b(d.b.getPackageName())) {
                        b = new Pair<>(5, null);
                    } else {
                        com.baidu.sofire.b.a();
                        d.a(context);
                        b = b(str, clsArr, objArr);
                    }
                } else if (com.baidu.sofire.b.e.b(b2)) {
                    com.baidu.sofire.b.a();
                    b = b(d.b, 1, str, clsArr, objArr);
                } else {
                    com.baidu.sofire.b.a();
                    d.a(context);
                    b = b(str, clsArr, objArr);
                }
            }
            return b;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
            return new Pair<>(3, null);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0029 -> B:17:0x0012). Please submit an issue!!! */
    private static Pair<Integer, Object> b(String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> pair;
        g a2;
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(1, null);
        }
        try {
            a2 = g.a();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
        if (a2 == null) {
            pair = new Pair<>(3, null);
        } else {
            ApkInfo d = a2.d("com.baidu.sofire.x0");
            if (d != null) {
                Class<?> a3 = ((f) d.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                pair = new Pair<>(0, com.baidu.sofire.b.e.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, d.b), str, clsArr, objArr));
            }
            pair = new Pair<>(3, null);
        }
        return pair;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.sofire.core.e$3] */
    public static boolean a(final int i, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            Context context = d.b;
            if (context == null) {
                com.baidu.sofire.b.a();
                if (callback != null) {
                    callback.onError(4);
                }
                return false;
            } else if (!com.baidu.sofire.b.e.a(d.b, false)) {
                com.baidu.sofire.b.a();
                if (callback != null) {
                    callback.onError(11);
                }
                return false;
            } else {
                String b = com.baidu.sofire.b.e.b(d.b);
                if (TextUtils.isEmpty(b)) {
                    if (com.baidu.sofire.b.e.b(d.b.getPackageName())) {
                        if (callback != null) {
                            callback.onError(5);
                        }
                        return false;
                    }
                    com.baidu.sofire.b.a();
                    d.a(context).a(i, str, callback, clsArr, objArr);
                    return true;
                } else if (com.baidu.sofire.b.e.b(b)) {
                    com.baidu.sofire.b.a();
                    final Context context2 = d.b;
                    if (TextUtils.isEmpty(str)) {
                        if (callback != null) {
                            callback.onError(1);
                        }
                    } else {
                        new Thread() { // from class: com.baidu.sofire.core.e.3
                            @Override // java.lang.Thread, java.lang.Runnable
                            public final void run() {
                                super.run();
                                if (Callback.this != null) {
                                    Callback.this.onBegin(new Object[0]);
                                }
                                Pair a2 = e.a(context2, i, 0, str, clsArr, objArr);
                                if (Callback.this != null) {
                                    if (((Integer) a2.first).intValue() != 0) {
                                        Callback.this.onError(a2.first);
                                    } else {
                                        Callback.this.onEnd(a2.second);
                                    }
                                }
                            }
                        }.start();
                    }
                    return true;
                } else {
                    com.baidu.sofire.b.a();
                    d.a(context).a(i, str, callback, clsArr, objArr);
                    return true;
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
            return false;
        }
    }

    public static String a(Context context, String str, int i, String str2) {
        try {
            if (!TextUtils.isEmpty(a)) {
                if (TextUtils.isEmpty(str2)) {
                    a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
                } else {
                    a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i), str2);
                }
                return a;
            } else if (!com.baidu.sofire.b.e.a(context, false)) {
                com.baidu.sofire.b.a();
                return "";
            } else {
                String b = com.baidu.sofire.b.e.b(context);
                if (TextUtils.isEmpty(b)) {
                    if (com.baidu.sofire.b.e.b(context.getPackageName())) {
                        return "";
                    }
                    com.baidu.sofire.b.a();
                    return b(context, str, i, str2);
                } else if (com.baidu.sofire.b.e.b(b)) {
                    com.baidu.sofire.b.a();
                    Pair<Integer, Object> b2 = b(context, 0, "gzfi", null, str, Integer.valueOf(i), str2);
                    if (b2 != null && ((Integer) b2.first).intValue() == 0) {
                        return (String) b2.second;
                    }
                    return "";
                } else {
                    com.baidu.sofire.b.a();
                    return b(context, str, i, str2);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
        return "";
    }

    private static String b(Context context, String str, int i, String str2) {
        if (i != 0) {
            if (TextUtils.isEmpty(str2)) {
                a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
            } else {
                a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i), str2);
            }
        }
        return b(context);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002b -> B:5:0x0011). Please submit an issue!!! */
    private static String b(Context context) {
        com.baidu.sofire.g gVar;
        String a2;
        byte[] re;
        try {
            gVar = new com.baidu.sofire.g(context);
            a2 = gVar.a();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
        if (!TextUtils.isEmpty(a2)) {
            a = a2;
            return a2;
        }
        String string = gVar.a.getString("xytk_m", "");
        if (!TextUtils.isEmpty(string)) {
            a = string;
            return string;
        }
        String a3 = com.baidu.sofire.b.g.a(context);
        if (!TextUtils.isEmpty(a3)) {
            String[] split = a3.split("\\|");
            if (split == null || split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
                a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            }
            if (F.getInstance().re(split[1].getBytes(), split[0].getBytes()) != null) {
                String str = split[0] + com.baidu.sofire.b.e.a(re);
                gVar.a(str);
                a = str;
                return str;
            }
        }
        a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0069 -> B:5:0x000a). Please submit an issue!!! */
    public static String a(Context context) {
        try {
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
        if (!TextUtils.isEmpty(a)) {
            return a;
        } else if (!com.baidu.sofire.b.e.a(context, false)) {
            return "";
        } else {
            String b = com.baidu.sofire.b.e.b(context);
            if (TextUtils.isEmpty(b)) {
                if (com.baidu.sofire.b.e.b(context.getPackageName())) {
                    return "";
                }
                return b(context);
            } else if (com.baidu.sofire.b.e.b(b)) {
                com.baidu.sofire.b.a();
                Pair<Integer, Object> b2 = b(context, 0, "gz", null, new Object[0]);
                if (b2 != null) {
                    if (((Integer) b2.first).intValue() == 0) {
                        return (String) b2.second;
                    }
                    return "";
                }
                a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            } else {
                com.baidu.sofire.b.a();
                return b(context);
            }
        }
    }

    public static String a(Context context, String str) {
        int i;
        Pair<Integer, Object> a2;
        try {
            a2 = a("xgz", new Class[]{String.class}, str);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
            i = 501;
        }
        if (((Integer) a2.first).intValue() == 0 && !TextUtils.isEmpty((String) a2.second)) {
            return (String) a2.second;
        }
        i = ((Integer) a2.first).intValue() == 0 ? 502 : ((Integer) a2.first).intValue();
        try {
            return new JSONObject().put("rc", i).put("z", a(context)).toString();
        } catch (Throwable th2) {
            com.baidu.sofire.b.e.a();
            return "";
        }
    }

    public static String a(Context context, String str, String str2, int i, String str3) {
        if (context != null) {
            try {
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a();
            }
            if (!TextUtils.isEmpty(str)) {
                Pair<Integer, Object> a2 = a(100067, "retrieveToken", new Class[]{String.class, String.class, Integer.TYPE, String.class}, str, str2, Integer.valueOf(i), str3);
                if (((Integer) a2.first).intValue() == 0) {
                    String str4 = (String) a2.second;
                    com.baidu.sofire.b.a();
                    if (TextUtils.isEmpty(str4)) {
                        return com.baidu.sofire.b.e.a(context, 9);
                    }
                    return str4;
                }
                new StringBuilder("gt failed ").append(a2.first);
                com.baidu.sofire.b.a();
                if (((Integer) a2.first).intValue() == 4 || ((Integer) a2.first).intValue() == 3) {
                    String[] g = com.baidu.sofire.b.e.g(context);
                    new StringBuilder("gt method try ").append(g[0]).append(" : ").append(g[1]);
                    com.baidu.sofire.b.a();
                    a(context, 0, g[0], g[1], 100067);
                    return com.baidu.sofire.b.e.a(context, ((Integer) a2.first).intValue() == 3 ? 5 : 2);
                }
                if (((Integer) a2.first).intValue() == 5 || ((Integer) a2.first).intValue() == 11) {
                    return com.baidu.sofire.b.e.a(context, 7);
                }
                return com.baidu.sofire.b.e.a(context, 8);
            }
        }
        return com.baidu.sofire.b.e.a(context, 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006d A[Catch: Throwable -> 0x00b3, TryCatch #2 {Throwable -> 0x0207, blocks: (B:3:0x0005, B:6:0x0013, B:24:0x00c0, B:27:0x00cb, B:67:0x01c4, B:69:0x01cd, B:71:0x01d7, B:73:0x01e2, B:78:0x0216, B:7:0x001b, B:9:0x002f, B:11:0x0035, B:12:0x005f, B:14:0x006d, B:20:0x0093, B:17:0x0077, B:19:0x007d, B:28:0x00d0, B:30:0x00ed, B:31:0x00f2, B:33:0x00f5, B:35:0x0102, B:37:0x010b, B:39:0x0111, B:40:0x0125, B:41:0x0129, B:47:0x0149, B:51:0x0151, B:53:0x015a, B:54:0x015f, B:56:0x0177, B:57:0x017b, B:58:0x0199, B:60:0x01a1, B:62:0x01b2), top: B:81:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093 A[Catch: Throwable -> 0x00b3, TRY_LEAVE, TryCatch #2 {Throwable -> 0x0207, blocks: (B:3:0x0005, B:6:0x0013, B:24:0x00c0, B:27:0x00cb, B:67:0x01c4, B:69:0x01cd, B:71:0x01d7, B:73:0x01e2, B:78:0x0216, B:7:0x001b, B:9:0x002f, B:11:0x0035, B:12:0x005f, B:14:0x006d, B:20:0x0093, B:17:0x0077, B:19:0x007d, B:28:0x00d0, B:30:0x00ed, B:31:0x00f2, B:33:0x00f5, B:35:0x0102, B:37:0x010b, B:39:0x0111, B:40:0x0125, B:41:0x0129, B:47:0x0149, B:51:0x0151, B:53:0x015a, B:54:0x015f, B:56:0x0177, B:57:0x017b, B:58:0x0199, B:60:0x01a1, B:62:0x01b2), top: B:81:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle a(Context context, String str, Bundle bundle) {
        Pair<Integer, Object> a2;
        String str2;
        Integer num;
        String str3;
        String b;
        final Bundle bundle2 = new Bundle();
        try {
            com.baidu.sofire.b.a();
            if ("gzfi".equals(str)) {
                if (bundle != null) {
                    c cVar = new c();
                    bundle.setClassLoader(MyProvider.class.getClassLoader());
                    c cVar2 = (c) bundle.getParcelable("args");
                    if (cVar2 != null) {
                        if (cVar2.e.length == 2) {
                            str3 = (String) cVar2.e[0];
                            Integer num2 = (Integer) cVar2.e[1];
                            new StringBuilder("args ").append(str3).append(" ").append(num2);
                            com.baidu.sofire.b.a();
                            num = num2;
                            str2 = null;
                        } else if (cVar2.e.length == 3) {
                            str3 = (String) cVar2.e[0];
                            num = (Integer) cVar2.e[1];
                            str2 = (String) cVar2.e[2];
                        }
                        b = b(context, str3, num.intValue(), str2);
                        if (!TextUtils.isEmpty(b)) {
                            bundle2.putInt("status", 8);
                        } else {
                            cVar.f = b;
                            new StringBuilder("gzfi return zid: ").append(cVar.f);
                            com.baidu.sofire.b.a();
                            bundle2.putParcelable("result", cVar);
                            bundle2.putInt("status", 0);
                        }
                        return bundle2;
                    }
                    str2 = null;
                    num = null;
                    str3 = null;
                    b = b(context, str3, num.intValue(), str2);
                    if (!TextUtils.isEmpty(b)) {
                    }
                    return bundle2;
                }
            } else if ("invokeMethod".equals(str)) {
                if (bundle != null) {
                    final c cVar3 = new c();
                    bundle.setClassLoader(MyProvider.class.getClassLoader());
                    c cVar4 = (c) bundle.getParcelable("args");
                    int i = cVar4.a;
                    int i2 = cVar4.b;
                    final String str4 = cVar4.c;
                    Object[] objArr = cVar4.d;
                    Class[] clsArr = null;
                    if (objArr != null) {
                        Class[] clsArr2 = new Class[objArr.length];
                        for (int i3 = 0; i3 < objArr.length; i3++) {
                            String str5 = (String) objArr[i3];
                            com.baidu.sofire.b.a();
                            if (!TextUtils.isEmpty(str5) && str5.contains("@@")) {
                                Class<?> a3 = com.baidu.sofire.b.e.a(str5);
                                if (a3 != null) {
                                    new StringBuilder("convert back class name ").append(a3.getCanonicalName());
                                    com.baidu.sofire.b.a();
                                    clsArr2[i3] = a3;
                                }
                            } else {
                                clsArr2[i3] = Class.forName((String) objArr[i3]);
                            }
                        }
                        clsArr = clsArr2;
                    }
                    Object[] objArr2 = cVar4.e;
                    if (i2 == 1) {
                        if (i == 1 && "xgz".equals(str4)) {
                            a2 = b(str4, clsArr, objArr2);
                        } else {
                            a2 = a(i, str4, clsArr, objArr2);
                        }
                        bundle2.putInt("status", ((Integer) a2.first).intValue());
                        if (((Integer) a2.first).intValue() == 0) {
                            cVar3.f = a2.second;
                        }
                    } else if (i2 == 0) {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        a(i, str4, new Callback() { // from class: com.baidu.sofire.core.e.2
                            @Override // com.baidu.sofire.ac.Callback
                            public final Object onEnd(Object... objArr3) {
                                try {
                                    bundle2.putInt("status", 0);
                                    cVar3.f = objArr3[0];
                                    return null;
                                } catch (Throwable th) {
                                    try {
                                        com.baidu.sofire.b.e.a();
                                        return null;
                                    } finally {
                                        countDownLatch.countDown();
                                    }
                                }
                            }

                            @Override // com.baidu.sofire.ac.Callback
                            public final Object onError(Object... objArr3) {
                                try {
                                    bundle2.putInt("status", ((Integer) objArr3[0]).intValue());
                                    new StringBuilder().append(str4).append("onError ").append(String.valueOf(objArr3[0]));
                                    com.baidu.sofire.b.a();
                                    return null;
                                } catch (Throwable th) {
                                    try {
                                        com.baidu.sofire.b.e.a();
                                        return null;
                                    } finally {
                                        countDownLatch.countDown();
                                    }
                                }
                            }
                        }, clsArr, objArr2);
                        countDownLatch.await(180000L, TimeUnit.MILLISECONDS);
                    }
                    new StringBuilder("return bundle").append(bundle2.getInt("status"));
                    com.baidu.sofire.b.a();
                    bundle2.putParcelable("result", cVar3);
                    return bundle2;
                }
            } else if ("gz".equals(str)) {
                String b2 = b(context);
                if (TextUtils.isEmpty(b2)) {
                    bundle2.putInt("status", 8);
                } else {
                    c cVar5 = new c();
                    cVar5.f = b2;
                    new StringBuilder("gz return zid: ").append(cVar5.f);
                    com.baidu.sofire.b.a();
                    bundle2.putParcelable("result", cVar5);
                    bundle2.putInt("status", 0);
                }
                return bundle2;
            } else {
                bundle2.putInt("status", 2);
                return bundle2;
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
        bundle2.putInt("status", 10);
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Pair<Integer, Object> a(Context context, int i, int i2, String str, Class<?>[] clsArr, Object... objArr) {
        Bundle bundle;
        try {
            if (TextUtils.isEmpty(str)) {
                return Pair.create(1, null);
            }
            String str2 = ("gzfi".equals(str) || "gz".equals(str)) ? str : "invokeMethod";
            c cVar = new c();
            cVar.a = i;
            cVar.c = str;
            cVar.b = i2;
            if (clsArr != null) {
                Object[] objArr2 = new Object[clsArr.length];
                for (int i3 = 0; i3 < clsArr.length; i3++) {
                    if (clsArr[i3].isPrimitive()) {
                        String a2 = com.baidu.sofire.b.e.a(clsArr[i3]);
                        if (!TextUtils.isEmpty(a2)) {
                            objArr2[i3] = a2 + "@@";
                        }
                    } else {
                        objArr2[i3] = clsArr[i3].getCanonicalName();
                    }
                }
                cVar.d = objArr2;
            }
            cVar.e = objArr;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("args", cVar);
            StringBuilder sb = new StringBuilder("content://");
            sb.append(context.getPackageName()).append(".sofire.ac.provider");
            Uri parse = Uri.parse(sb.toString());
            Bundle bundle3 = null;
            if (Build.VERSION.SDK_INT >= 11) {
                bundle = context.getContentResolver().call(parse, str2, (String) null, bundle2);
            } else {
                com.baidu.sofire.b.a();
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
                    bundle3 = (Bundle) declaredMethod.invoke(obj, str2, null, bundle2);
                }
                acquireContentProviderClient.release();
                bundle = bundle3;
            }
            if (bundle == null) {
                return Pair.create(3, null);
            }
            bundle.setClassLoader(c.class.getClassLoader());
            int i4 = bundle.getInt("status");
            c cVar2 = null;
            com.baidu.sofire.b.a();
            if (i4 == 0) {
                cVar2 = (c) bundle.getParcelable("result");
            }
            return Pair.create(Integer.valueOf(i4), cVar2 == null ? null : cVar2.f);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
            return Pair.create(3, null);
        }
    }

    private static Pair<Integer, Object> b(Context context, int i, String str, Class<?>[] clsArr, Object... objArr) {
        return a(context, i, 1, str, clsArr, objArr);
    }
}
