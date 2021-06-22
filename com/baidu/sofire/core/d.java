package com.baidu.sofire.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.utility.s;
import com.baidu.sofire.utility.t;
import com.baidu.sofire.utility.u;
import com.baidu.sofire.utility.x;
import com.yy.gslbsdk.db.DelayTB;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f10250a = "";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f10251b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f10252c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f10253d = false;

    public static synchronized void b(final Context context) {
        synchronized (d.class) {
            if (context == null) {
                return;
            }
            try {
                if (f10252c) {
                    f10252c = false;
                    x.a(context).b(new Runnable() { // from class: com.baidu.sofire.core.d.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                c a2 = c.a(context);
                                if (a2 != null) {
                                    c.a(1);
                                    a2.b();
                                }
                            } catch (Throwable unused) {
                                com.baidu.sofire.utility.c.a();
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public static String c(Context context) {
        com.baidu.sofire.h.a a2;
        String E;
        byte[] re;
        try {
            a2 = com.baidu.sofire.h.a.a(context);
            E = a2.E();
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        if (!TextUtils.isEmpty(E)) {
            f10250a = E;
            return E;
        }
        String string = a2.f10323c.getString("xytk_m", "");
        if (!TextUtils.isEmpty(string)) {
            f10250a = string;
            return string;
        }
        String b2 = com.baidu.sofire.utility.e.b(context);
        if (!TextUtils.isEmpty(b2)) {
            String[] split = b2.split("\\|");
            if (split != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                if (F.getInstance().re(split[1].getBytes(), split[0].getBytes()) != null) {
                    String str = split[0] + com.baidu.sofire.utility.c.a(re);
                    a2.f10324d.putString("xytk_m", str);
                    if (Build.VERSION.SDK_INT >= 9) {
                        a2.f10324d.apply();
                    } else {
                        a2.f10324d.commit();
                    }
                    f10250a = str;
                    return str;
                }
            }
            f10250a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        }
        f10250a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
    }

    public static synchronized void a(final Context context, final int i2, final String str, final String str2, final int... iArr) {
        synchronized (d.class) {
            if (context == null) {
                return;
            }
            try {
                if (f10251b) {
                    return;
                }
                f10251b = true;
                c.f10234b = context;
                x.a(context).b(new Runnable() { // from class: com.baidu.sofire.core.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.baidu.sofire.utility.c.j(context);
                        try {
                            s.a(context);
                            if (com.baidu.sofire.utility.c.a(context, true)) {
                                if (com.baidu.sofire.utility.c.a(context) != 1) {
                                    Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
                                    intent.setClass(context, MyService.class);
                                    intent.setPackage(context.getPackageName());
                                    intent.addCategory("com.baidu.category.SOFIRE");
                                    intent.addCategory("android.intent.category.DEFAULT");
                                    Bundle bundle = new Bundle();
                                    bundle.putStringArray("appkey", new String[]{str, str2});
                                    bundle.putIntArray("key", iArr);
                                    bundle.putInt(DelayTB.DELAY, i2);
                                    intent.putExtra("bundle", bundle);
                                    context.startService(intent);
                                    com.baidu.sofire.mutiprocess.b.b(context);
                                    return;
                                }
                                d.a(context);
                                c a2 = c.a(context);
                                com.baidu.sofire.utility.e.a(context);
                                com.baidu.sofire.utility.e.b(context);
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                    String str3 = str;
                                    String str4 = str2;
                                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && (!com.baidu.sofire.utility.c.f10403e.equals(str3) || !com.baidu.sofire.utility.c.f10404f.equals(str4))) {
                                        com.baidu.sofire.h.a aVar = a2.f10239a;
                                        SharedPreferences.Editor editor = aVar.f10322b;
                                        editor.putString("svi", str3 + "-" + str4);
                                        aVar.f10322b.commit();
                                    }
                                }
                                if (i2 > 0) {
                                    Thread.sleep(i2 * 1000);
                                }
                                com.baidu.sofire.h.a.a(context).a(iArr);
                                if (!t.a(context)) {
                                    boolean unused = d.f10252c = true;
                                    return;
                                }
                                c.a(1);
                                a2.b();
                            }
                        } catch (Throwable unused2) {
                            com.baidu.sofire.utility.c.a();
                        }
                    }
                });
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
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
            com.baidu.sofire.utility.c.a();
        }
        if (a2 == null) {
            return new Pair<>(3, null);
        }
        ApkInfo d2 = a2.d("com.baidu.sofire.x0");
        if (d2 != null) {
            Class<?> a3 = ((e) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
            return new Pair<>(0, com.baidu.sofire.utility.c.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, c.f10234b), str, clsArr, objArr));
        }
        return new Pair<>(3, null);
    }

    public static Pair<Integer, Object> a(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Context context = c.f10234b;
            if (context == null) {
                return new Pair<>(4, null);
            }
            if (!t.a(c.f10234b)) {
                return new Pair<>(12, null);
            }
            if (!com.baidu.sofire.utility.c.a(c.f10234b, false)) {
                return new Pair<>(11, null);
            }
            String b2 = com.baidu.sofire.utility.c.b(c.f10234b);
            if (TextUtils.isEmpty(b2)) {
                if (com.baidu.sofire.utility.c.b(c.f10234b.getPackageName())) {
                    return new Pair<>(5, null);
                }
                return c.a(context).a(i2, str, clsArr, objArr);
            } else if (com.baidu.sofire.utility.c.b(b2)) {
                return b(c.f10234b, i2, str, clsArr, objArr);
            } else {
                return c.a(context).a(i2, str, clsArr, objArr);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return new Pair<>(3, null);
        }
    }

    public static String b(Context context, String str, int i2, String str2) {
        if (context == null) {
            return "";
        }
        if (i2 != 0) {
            if (TextUtils.isEmpty(str2) && t.a(context)) {
                a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i2));
            } else {
                a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i2), str2);
            }
        }
        return c(context);
    }

    public static Pair<Integer, Object> b(Context context, int i2, String str, Class<?>[] clsArr, Object... objArr) {
        return a(context, i2, 1, str, clsArr, objArr);
    }

    public static synchronized void b(Context context, boolean z) {
        synchronized (d.class) {
            if (context == null) {
                return;
            }
            try {
                int a2 = com.baidu.sofire.utility.c.a(context);
                if (a2 == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("_agree_policy", z);
                    u.a(context, "setAgreePolicy", bundle);
                    return;
                }
                if (a2 == 1) {
                    t.a(context, z);
                    if (z && !f10253d) {
                        f10253d = true;
                        b(context);
                    }
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public static Pair<Integer, Object> a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Context context = c.f10234b;
            if (context == null) {
                return new Pair<>(4, null);
            }
            if (!com.baidu.sofire.utility.c.a(c.f10234b, false)) {
                return new Pair<>(11, null);
            }
            String b2 = com.baidu.sofire.utility.c.b(c.f10234b);
            if (TextUtils.isEmpty(b2)) {
                if (com.baidu.sofire.utility.c.b(c.f10234b.getPackageName())) {
                    return new Pair<>(5, null);
                }
                c.a(context);
                return b(str, clsArr, objArr);
            } else if (com.baidu.sofire.utility.c.b(b2)) {
                return b(c.f10234b, 1, str, clsArr, objArr);
            } else {
                c.a(context);
                return b(str, clsArr, objArr);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return new Pair<>(3, null);
        }
    }

    public static void b(Context context, String str) {
        if (context != null) {
            try {
                if (t.a(context)) {
                    com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                    a2.f10324d.putString("s_h_d_id", str);
                    if (Build.VERSION.SDK_INT >= 9) {
                        a2.f10324d.apply();
                    } else {
                        a2.f10324d.commit();
                    }
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public static boolean a(final int i2, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            return x.a(c.f10234b).a(new Runnable() { // from class: com.baidu.sofire.core.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Context context = c.f10234b;
                        if (context == null) {
                            for (int i3 = 0; i3 < 20; i3++) {
                                try {
                                    Thread.sleep(50L);
                                } catch (InterruptedException unused) {
                                    com.baidu.sofire.utility.c.a();
                                }
                                context = c.f10234b;
                                if (context != null) {
                                    break;
                                }
                            }
                            if (context == null) {
                                if (Callback.this != null) {
                                    Callback.this.onError(4);
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Throwable unused2) {
                        com.baidu.sofire.utility.c.a();
                    }
                    if (!t.a(c.f10234b)) {
                        Callback.this.onError(12);
                    } else if (!com.baidu.sofire.utility.c.a(c.f10234b, false)) {
                        if (Callback.this != null) {
                            Callback.this.onError(11);
                        }
                    } else {
                        String b2 = com.baidu.sofire.utility.c.b(c.f10234b);
                        if (TextUtils.isEmpty(b2)) {
                            if (com.baidu.sofire.utility.c.b(c.f10234b.getPackageName())) {
                                if (Callback.this != null) {
                                    Callback.this.onError(5);
                                    return;
                                }
                                return;
                            }
                            c a2 = c.a();
                            if (a2 == null) {
                                for (int i4 = 0; i4 < 20; i4++) {
                                    try {
                                        Thread.sleep(50L);
                                    } catch (InterruptedException unused3) {
                                        com.baidu.sofire.utility.c.a();
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
                            a2.a(i2, str, Callback.this, clsArr, objArr);
                            return;
                        } else if (com.baidu.sofire.utility.c.b(b2)) {
                            d.a(c.f10234b, i2, str, Callback.this, clsArr, objArr);
                            return;
                        } else {
                            c a3 = c.a();
                            if (a3 == null) {
                                for (int i5 = 0; i5 < 20; i5++) {
                                    try {
                                        Thread.sleep(50L);
                                    } catch (InterruptedException unused4) {
                                        com.baidu.sofire.utility.c.a();
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
                            a3.a(i2, str, Callback.this, clsArr, objArr);
                            return;
                        }
                        com.baidu.sofire.utility.c.a();
                    }
                }
            }) == 1;
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return false;
        }
    }

    public static String a(Context context, String str, int i2, String str2) {
        if (context == null) {
            return "";
        }
        try {
            if (!TextUtils.isEmpty(f10250a)) {
                if (i2 != 0 && t.a(context)) {
                    if (TextUtils.isEmpty(str2)) {
                        a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i2));
                    } else {
                        a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i2), str2);
                    }
                }
                return f10250a;
            } else if (com.baidu.sofire.utility.c.a(context, false)) {
                String b2 = com.baidu.sofire.utility.c.b(context);
                if (TextUtils.isEmpty(b2)) {
                    return com.baidu.sofire.utility.c.b(context.getPackageName()) ? "" : b(context, str, i2, str2);
                } else if (com.baidu.sofire.utility.c.b(b2)) {
                    Pair<Integer, Object> b3 = b(context, 0, "gzfi", null, str, Integer.valueOf(i2), str2);
                    return (b3 == null || ((Integer) b3.first).intValue() != 0) ? "" : (String) b3.second;
                } else {
                    return b(context, str, i2, str2);
                }
            } else {
                return "";
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        return "";
    }

    public static void a(Context context, boolean z) {
        if (context == null || !t.a(context)) {
            return;
        }
        com.baidu.sofire.h.a.a(context).a(z);
    }

    public static String a(Context context) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        if (!TextUtils.isEmpty(f10250a)) {
            return f10250a;
        }
        if (context != null && com.baidu.sofire.utility.c.a(context, false)) {
            String b2 = com.baidu.sofire.utility.c.b(context);
            if (TextUtils.isEmpty(b2)) {
                return com.baidu.sofire.utility.c.b(context.getPackageName()) ? "" : c(context);
            } else if (com.baidu.sofire.utility.c.b(b2)) {
                Pair<Integer, Object> b3 = b(context, 0, "gz", null, new Object[0]);
                if (b3 != null) {
                    return ((Integer) b3.first).intValue() == 0 ? (String) b3.second : "";
                }
                f10250a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            } else {
                return c(context);
            }
        }
        return "";
    }

    public static String a(Context context, String str) {
        int i2;
        if (context != null) {
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                i2 = 501;
            }
            if (t.a(context)) {
                Pair<Integer, Object> a2 = a("xgz", new Class[]{String.class}, str);
                if (((Integer) a2.first).intValue() == 0 && !TextUtils.isEmpty((String) a2.second)) {
                    return (String) a2.second;
                }
                i2 = ((Integer) a2.first).intValue() == 0 ? 502 : ((Integer) a2.first).intValue();
                try {
                    return new JSONObject().put("rc", i2).put("z", a(context)).toString();
                } catch (Throwable unused2) {
                    com.baidu.sofire.utility.c.a();
                    return "";
                }
            }
        }
        return "";
    }

    public static String a(Context context, String str, String str2, int i2, String str3) {
        if (context != null) {
            try {
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (t.a(context)) {
                if (TextUtils.isEmpty(str)) {
                    return com.baidu.sofire.utility.c.a(context, 8);
                }
                Pair<Integer, Object> a2 = a(100067, "retrieveToken", new Class[]{String.class, String.class, Integer.TYPE, String.class}, str, str2, Integer.valueOf(i2), str3);
                if (((Integer) a2.first).intValue() == 0) {
                    String str4 = (String) a2.second;
                    return !TextUtils.isEmpty(str4) ? str4 : com.baidu.sofire.utility.c.a(context, 9);
                }
                if (((Integer) a2.first).intValue() != 4 && ((Integer) a2.first).intValue() != 3) {
                    if (((Integer) a2.first).intValue() == 5 || ((Integer) a2.first).intValue() == 11) {
                        return com.baidu.sofire.utility.c.a(context, 7);
                    }
                    return com.baidu.sofire.utility.c.a(context, 8);
                }
                String[] g2 = com.baidu.sofire.utility.c.g(context);
                a(context, 0, g2[0], g2[1], 100067);
                return com.baidu.sofire.utility.c.a(context, ((Integer) a2.first).intValue() == 3 ? 5 : 2);
            }
            return "";
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078 A[Catch: all -> 0x0095, TryCatch #4 {all -> 0x0180, blocks: (B:3:0x000c, B:6:0x0022, B:8:0x0027, B:28:0x009c, B:30:0x00a6, B:32:0x00ab, B:67:0x0155, B:69:0x015d, B:71:0x016a, B:72:0x016e, B:74:0x017c, B:9:0x002c, B:11:0x003d, B:13:0x0042, B:21:0x007c, B:23:0x0088, B:24:0x008c, B:20:0x0078, B:14:0x0054, B:16:0x0059, B:33:0x00b0, B:35:0x00c9, B:36:0x00cc, B:38:0x00cf, B:40:0x00d9, B:42:0x00e1, B:44:0x00e7, B:46:0x00f4, B:45:0x00ea, B:47:0x00f7, B:50:0x00fd, B:52:0x0106, B:54:0x010f, B:56:0x0124, B:63:0x0147, B:53:0x010b, B:58:0x012b, B:62:0x0141), top: B:79:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088 A[Catch: all -> 0x0095, TryCatch #4 {all -> 0x0180, blocks: (B:3:0x000c, B:6:0x0022, B:8:0x0027, B:28:0x009c, B:30:0x00a6, B:32:0x00ab, B:67:0x0155, B:69:0x015d, B:71:0x016a, B:72:0x016e, B:74:0x017c, B:9:0x002c, B:11:0x003d, B:13:0x0042, B:21:0x007c, B:23:0x0088, B:24:0x008c, B:20:0x0078, B:14:0x0054, B:16:0x0059, B:33:0x00b0, B:35:0x00c9, B:36:0x00cc, B:38:0x00cf, B:40:0x00d9, B:42:0x00e1, B:44:0x00e7, B:46:0x00f4, B:45:0x00ea, B:47:0x00f7, B:50:0x00fd, B:52:0x0106, B:54:0x010f, B:56:0x0124, B:63:0x0147, B:53:0x010b, B:58:0x012b, B:62:0x0141), top: B:79:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008c A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #4 {all -> 0x0180, blocks: (B:3:0x000c, B:6:0x0022, B:8:0x0027, B:28:0x009c, B:30:0x00a6, B:32:0x00ab, B:67:0x0155, B:69:0x015d, B:71:0x016a, B:72:0x016e, B:74:0x017c, B:9:0x002c, B:11:0x003d, B:13:0x0042, B:21:0x007c, B:23:0x0088, B:24:0x008c, B:20:0x0078, B:14:0x0054, B:16:0x0059, B:33:0x00b0, B:35:0x00c9, B:36:0x00cc, B:38:0x00cf, B:40:0x00d9, B:42:0x00e1, B:44:0x00e7, B:46:0x00f4, B:45:0x00ea, B:47:0x00f7, B:50:0x00fd, B:52:0x0106, B:54:0x010f, B:56:0x0124, B:63:0x0147, B:53:0x010b, B:58:0x012b, B:62:0x0141), top: B:79:0x000c }] */
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
            Class[] clsArr = null;
            String str3 = null;
            if ("gzfi".equals(str)) {
                bundle2.putBoolean("handle_flag", true);
                if (bundle != null) {
                    CallArgs callArgs = new CallArgs();
                    bundle.setClassLoader(MyProvider.class.getClassLoader());
                    CallArgs callArgs2 = (CallArgs) bundle.getParcelable("args");
                    if (callArgs2 != null) {
                        if (callArgs2.f10222e.length == 2) {
                            num = (Integer) callArgs2.f10222e[1];
                            str3 = (String) callArgs2.f10222e[0];
                            str2 = null;
                        } else if (callArgs2.f10222e.length == 3) {
                            str3 = (String) callArgs2.f10222e[0];
                            Integer num2 = (Integer) callArgs2.f10222e[1];
                            str2 = (String) callArgs2.f10222e[2];
                            num = num2;
                        }
                        b2 = b(context, str3, num != null ? 0 : num.intValue(), str2);
                        if (!TextUtils.isEmpty(b2)) {
                            bundle2.putInt("status", 8);
                        } else {
                            callArgs.f10223f = b2;
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
            } else if ("invokeMethod".equals(str)) {
                bundle2.putBoolean("handle_flag", true);
                if (bundle != null) {
                    final CallArgs callArgs3 = new CallArgs();
                    bundle.setClassLoader(MyProvider.class.getClassLoader());
                    CallArgs callArgs4 = (CallArgs) bundle.getParcelable("args");
                    int i2 = callArgs4.f10218a;
                    int i3 = callArgs4.f10219b;
                    final String str4 = callArgs4.f10220c;
                    Object[] objArr = callArgs4.f10221d;
                    if (objArr != null) {
                        clsArr = new Class[objArr.length];
                        for (int i4 = 0; i4 < objArr.length; i4++) {
                            String str5 = (String) objArr[i4];
                            if (!TextUtils.isEmpty(str5) && str5.contains("@@")) {
                                Class<?> a3 = com.baidu.sofire.utility.c.a(str5);
                                if (a3 != null) {
                                    clsArr[i4] = a3;
                                }
                            } else {
                                clsArr[i4] = Class.forName((String) objArr[i4]);
                            }
                        }
                    }
                    Object[] objArr2 = callArgs4.f10222e;
                    if (i3 == 1) {
                        if (i2 == 1 && "xgz".equals(str4)) {
                            a2 = b(str4, clsArr, objArr2);
                        } else {
                            a2 = a(i2, str4, clsArr, objArr2);
                        }
                        bundle2.putInt("status", ((Integer) a2.first).intValue());
                        if (((Integer) a2.first).intValue() == 0) {
                            callArgs3.f10223f = a2.second;
                        }
                    } else if (i3 == 0) {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        a(i2, str4, new Callback() { // from class: com.baidu.sofire.core.d.4
                            @Override // com.baidu.sofire.ac.Callback
                            public final Object onEnd(Object... objArr3) {
                                try {
                                    try {
                                        bundle2.putInt("status", 0);
                                        callArgs3.f10223f = objArr3[0];
                                    } catch (Throwable unused) {
                                        com.baidu.sofire.utility.c.a();
                                    }
                                    countDownLatch.countDown();
                                    return null;
                                } catch (Throwable th) {
                                    countDownLatch.countDown();
                                    throw th;
                                }
                            }

                            @Override // com.baidu.sofire.ac.Callback
                            public final Object onError(Object... objArr3) {
                                try {
                                    try {
                                        bundle2.putInt("status", ((Integer) objArr3[0]).intValue());
                                    } catch (Throwable unused) {
                                        com.baidu.sofire.utility.c.a();
                                    }
                                    countDownLatch.countDown();
                                    return null;
                                } catch (Throwable th) {
                                    countDownLatch.countDown();
                                    throw th;
                                }
                            }
                        }, clsArr, objArr2);
                        try {
                            countDownLatch.await(180000L, TimeUnit.MILLISECONDS);
                        } catch (Throwable unused) {
                            bundle2.putInt("status", 3);
                            com.baidu.sofire.utility.c.a();
                        }
                    }
                    bundle2.putParcelable("result", callArgs3);
                    return bundle2;
                }
            } else if ("gz".equals(str)) {
                bundle2.putBoolean("handle_flag", true);
                String c2 = c(context);
                if (TextUtils.isEmpty(c2)) {
                    bundle2.putInt("status", 8);
                } else {
                    CallArgs callArgs5 = new CallArgs();
                    callArgs5.f10223f = c2;
                    bundle2.putParcelable("result", callArgs5);
                    bundle2.putInt("status", 0);
                }
                return bundle2;
            } else {
                bundle2.putInt("status", 2);
                return bundle2;
            }
        } catch (Throwable unused2) {
            com.baidu.sofire.utility.c.a();
        }
        bundle2.putInt("status", 10);
        return bundle2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034 A[Catch: all -> 0x00b6, TryCatch #0 {all -> 0x00b6, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0012, B:9:0x001a, B:14:0x0027, B:16:0x0034, B:17:0x0038, B:19:0x003b, B:21:0x0043, B:23:0x004f, B:25:0x006b, B:24:0x0063, B:26:0x006e, B:27:0x0070, B:29:0x0082, B:31:0x008b, B:33:0x009d, B:35:0x00a7, B:39:0x00b1, B:38:0x00af), top: B:43:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082 A[Catch: all -> 0x00b6, TryCatch #0 {all -> 0x00b6, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0012, B:9:0x001a, B:14:0x0027, B:16:0x0034, B:17:0x0038, B:19:0x003b, B:21:0x0043, B:23:0x004f, B:25:0x006b, B:24:0x0063, B:26:0x006e, B:27:0x0070, B:29:0x0082, B:31:0x008b, B:33:0x009d, B:35:0x00a7, B:39:0x00b1, B:38:0x00af), top: B:43:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b A[Catch: all -> 0x00b6, TryCatch #0 {all -> 0x00b6, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0012, B:9:0x001a, B:14:0x0027, B:16:0x0034, B:17:0x0038, B:19:0x003b, B:21:0x0043, B:23:0x004f, B:25:0x006b, B:24:0x0063, B:26:0x006e, B:27:0x0070, B:29:0x0082, B:31:0x008b, B:33:0x009d, B:35:0x00a7, B:39:0x00b1, B:38:0x00af), top: B:43:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Object> a(Context context, int i2, int i3, String str, Class<?>[] clsArr, Object... objArr) {
        String str2;
        Bundle a2;
        try {
            if (TextUtils.isEmpty(str)) {
                return Pair.create(1, null);
            }
            if (!"gzfi".equals(str) && !"gz".equals(str)) {
                str2 = "invokeMethod";
                CallArgs callArgs = new CallArgs();
                callArgs.f10218a = i2;
                callArgs.f10220c = str;
                callArgs.f10219b = i3;
                if (clsArr != null) {
                    Object[] objArr2 = new Object[clsArr.length];
                    for (int i4 = 0; i4 < clsArr.length; i4++) {
                        if (clsArr[i4].isPrimitive()) {
                            String a3 = com.baidu.sofire.utility.c.a(clsArr[i4]);
                            if (!TextUtils.isEmpty(a3)) {
                                objArr2[i4] = a3 + "@@";
                            }
                        } else {
                            objArr2[i4] = clsArr[i4].getName();
                        }
                    }
                    callArgs.f10221d = objArr2;
                }
                callArgs.f10222e = objArr;
                Bundle bundle = new Bundle();
                bundle.putParcelable("args", callArgs);
                a2 = u.a(context, str2, bundle);
                if (a2 != null) {
                    return Pair.create(3, null);
                }
                a2.setClassLoader(CallArgs.class.getClassLoader());
                int i5 = a2.getInt("status");
                CallArgs callArgs2 = i5 == 0 ? (CallArgs) a2.getParcelable("result") : null;
                return Pair.create(Integer.valueOf(i5), callArgs2 == null ? null : callArgs2.f10223f);
            }
            str2 = str;
            CallArgs callArgs3 = new CallArgs();
            callArgs3.f10218a = i2;
            callArgs3.f10220c = str;
            callArgs3.f10219b = i3;
            if (clsArr != null) {
            }
            callArgs3.f10222e = objArr;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("args", callArgs3);
            a2 = u.a(context, str2, bundle2);
            if (a2 != null) {
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return Pair.create(3, null);
        }
    }

    public static /* synthetic */ void a(final Context context, final int i2, final String str, final Callback callback, final Class[] clsArr, final Object[] objArr) {
        try {
            if (!TextUtils.isEmpty(str)) {
                x.a(context).a(new Runnable() { // from class: com.baidu.sofire.core.d.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        Callback callback2 = Callback.this;
                        if (callback2 != null) {
                            callback2.onBegin(new Object[0]);
                        }
                        Pair a2 = d.a(context, i2, 0, str, clsArr, objArr);
                        if (Callback.this != null) {
                            if (((Integer) a2.first).intValue() != 0) {
                                Callback.this.onError(a2.first);
                            } else {
                                Callback.this.onEnd(a2.second);
                            }
                        }
                    }
                });
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
            com.baidu.sofire.utility.c.a();
        }
    }
}
