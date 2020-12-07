package com.baidu.sofire.core;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.i.u;
import com.baidu.sofire.i.w;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f3612a = "";
    public static String b = "";
    private static boolean c = false;

    public static synchronized void a(final Context context, final int i, final String str, final String str2, final int... iArr) {
        synchronized (d.class) {
            try {
                if (!c) {
                    c = true;
                    c.b = context;
                    new Thread(new Runnable() { // from class: com.baidu.sofire.core.d.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.baidu.sofire.i.e.j(context);
                            try {
                                if (!com.baidu.sofire.i.e.a(context, true)) {
                                    com.baidu.sofire.b.a();
                                    return;
                                }
                                int a2 = com.baidu.sofire.i.e.a(context);
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
                                d.b(context);
                                c a3 = c.a(context);
                                com.baidu.sofire.i.h.a(context);
                                com.baidu.sofire.i.h.b(context);
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                    String str3 = str;
                                    String str4 = str2;
                                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && (!com.baidu.sofire.i.e.e.equals(str3) || !com.baidu.sofire.i.e.f.equals(str4))) {
                                        com.baidu.sofire.e eVar = a3.f3608a;
                                        eVar.c.putString("svi", str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str4);
                                        eVar.c.commit();
                                    }
                                }
                                d.c(context);
                                if (i > 0) {
                                    Thread.sleep(i * 1000);
                                }
                                new com.baidu.sofire.e(context).a(iArr);
                                c.a(1);
                                a3.b();
                            } catch (Throwable th) {
                                com.baidu.sofire.i.e.a();
                            }
                        }
                    }).start();
                }
            } finally {
            }
        }
    }

    public static Pair<Integer, Object> a(int i, String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> a2;
        try {
            Context context = c.b;
            if (context == null) {
                a2 = new Pair<>(4, null);
            } else if (!com.baidu.sofire.i.e.a(c.b, false)) {
                com.baidu.sofire.b.a();
                a2 = new Pair<>(11, null);
            } else {
                String b2 = com.baidu.sofire.i.e.b(c.b);
                if (TextUtils.isEmpty(b2)) {
                    if (com.baidu.sofire.i.e.b(c.b.getPackageName())) {
                        a2 = new Pair<>(5, null);
                    } else {
                        com.baidu.sofire.b.a();
                        a2 = c.a(context).a(i, str, clsArr, objArr);
                    }
                } else if (com.baidu.sofire.i.e.b(b2)) {
                    com.baidu.sofire.b.a();
                    a2 = b(c.b, i, str, clsArr, objArr);
                } else {
                    com.baidu.sofire.b.a();
                    a2 = c.a(context).a(i, str, clsArr, objArr);
                }
            }
            return a2;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return new Pair<>(3, null);
        }
    }

    private static Pair<Integer, Object> a(String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> b2;
        try {
            Context context = c.b;
            if (context == null) {
                b2 = new Pair<>(4, null);
            } else if (!com.baidu.sofire.i.e.a(c.b, false)) {
                b2 = new Pair<>(11, null);
            } else {
                String b3 = com.baidu.sofire.i.e.b(c.b);
                if (TextUtils.isEmpty(b3)) {
                    if (com.baidu.sofire.i.e.b(c.b.getPackageName())) {
                        b2 = new Pair<>(5, null);
                    } else {
                        c.a(context);
                        b2 = b(str, clsArr, objArr);
                    }
                } else if (com.baidu.sofire.i.e.b(b3)) {
                    b2 = b(c.b, 1, str, clsArr, objArr);
                } else {
                    c.a(context);
                    b2 = b(str, clsArr, objArr);
                }
            }
            return b2;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return new Pair<>(3, null);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0029 -> B:17:0x0012). Please submit an issue!!! */
    private static Pair<Integer, Object> b(String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> pair;
        f a2;
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(1, null);
        }
        try {
            a2 = f.a();
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
        if (a2 == null) {
            pair = new Pair<>(3, null);
        } else {
            ApkInfo d = a2.d("com.baidu.sofire.x0");
            if (d != null) {
                Class<?> a3 = ((e) d.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                pair = new Pair<>(0, com.baidu.sofire.i.e.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, c.b), str, clsArr, objArr));
            }
            pair = new Pair<>(3, null);
        }
        return pair;
    }

    public static boolean a(final int i, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            w.a().a(new Runnable() { // from class: com.baidu.sofire.core.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = 0;
                    try {
                        Context context = c.b;
                        if (context == null) {
                            for (int i3 = 0; i3 < 20; i3++) {
                                try {
                                    Thread.sleep(50L);
                                } catch (InterruptedException e) {
                                    com.baidu.sofire.i.e.a();
                                }
                                context = c.b;
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
                    } catch (Throwable th) {
                        com.baidu.sofire.i.e.a();
                    }
                    if (!com.baidu.sofire.i.e.a(c.b, false)) {
                        com.baidu.sofire.b.a();
                        if (Callback.this != null) {
                            Callback.this.onError(11);
                            return;
                        }
                        return;
                    }
                    String b2 = com.baidu.sofire.i.e.b(c.b);
                    if (TextUtils.isEmpty(b2)) {
                        if (com.baidu.sofire.i.e.b(c.b.getPackageName())) {
                            if (Callback.this != null) {
                                Callback.this.onError(5);
                                return;
                            }
                            return;
                        }
                        com.baidu.sofire.b.a();
                        c a2 = c.a();
                        if (a2 == null) {
                            while (i2 < 20) {
                                try {
                                    Thread.sleep(50L);
                                } catch (InterruptedException e2) {
                                    com.baidu.sofire.i.e.a();
                                }
                                a2 = c.a();
                                if (a2 != null) {
                                    break;
                                }
                                i2++;
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
                    } else if (com.baidu.sofire.i.e.b(b2)) {
                        com.baidu.sofire.b.a();
                        d.a(c.b, i, str, Callback.this, clsArr, objArr);
                        return;
                    } else {
                        com.baidu.sofire.b.a();
                        c a3 = c.a();
                        if (a3 == null) {
                            while (i2 < 20) {
                                try {
                                    Thread.sleep(50L);
                                } catch (InterruptedException e3) {
                                    com.baidu.sofire.i.e.a();
                                }
                                a3 = c.a();
                                if (a3 != null) {
                                    break;
                                }
                                i2++;
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
                    com.baidu.sofire.i.e.a();
                }
            });
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return false;
        }
    }

    public static String a(Context context, String str, int i, String str2) {
        try {
            if (!TextUtils.isEmpty(f3612a)) {
                if (i != 0) {
                    if (TextUtils.isEmpty(str2)) {
                        a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
                    } else {
                        a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i), str2);
                    }
                }
                return f3612a;
            } else if (!com.baidu.sofire.i.e.a(context, false)) {
                com.baidu.sofire.b.a();
                return "";
            } else {
                String b2 = com.baidu.sofire.i.e.b(context);
                if (TextUtils.isEmpty(b2)) {
                    if (com.baidu.sofire.i.e.b(context.getPackageName())) {
                        return "";
                    }
                    com.baidu.sofire.b.a();
                    return b(context, str, i, str2);
                } else if (com.baidu.sofire.i.e.b(b2)) {
                    com.baidu.sofire.b.a();
                    Pair<Integer, Object> b3 = b(context, 0, "gzfi", null, str, Integer.valueOf(i), str2);
                    if (b3 != null && ((Integer) b3.first).intValue() == 0) {
                        return (String) b3.second;
                    }
                    return "";
                } else {
                    com.baidu.sofire.b.a();
                    return b(context, str, i, str2);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
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
        return d(context);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002b -> B:5:0x0011). Please submit an issue!!! */
    private static String d(Context context) {
        com.baidu.sofire.g gVar;
        String a2;
        byte[] re;
        try {
            gVar = new com.baidu.sofire.g(context);
            a2 = gVar.a();
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
        if (!TextUtils.isEmpty(a2)) {
            f3612a = a2;
            return a2;
        }
        String string = gVar.f3629a.getString("xytk_m", "");
        if (!TextUtils.isEmpty(string)) {
            f3612a = string;
            return string;
        }
        String b2 = com.baidu.sofire.i.h.b(context);
        if (!TextUtils.isEmpty(b2)) {
            String[] split = b2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            if (split == null || split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
                f3612a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            }
            if (F.getInstance().re(split[1].getBytes(), split[0].getBytes()) != null) {
                String str = split[0] + com.baidu.sofire.i.e.a(re);
                gVar.b.putString("xytk_m", str);
                gVar.b.commit();
                f3612a = str;
                return str;
            }
        }
        f3612a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
    }

    public static void a(Context context, boolean z) {
        new com.baidu.sofire.e(context).a(z);
    }

    public static String a(final Context context) {
        try {
            com.baidu.sofire.b.a();
            Pair<Integer, Object> a2 = a("gtdid", (Class<?>[]) null, new Object[0]);
            if (((Integer) a2.first).intValue() == 0 && !TextUtils.isEmpty((String) a2.second)) {
                return (String) a2.second;
            }
            com.baidu.sofire.b.a();
            if (TextUtils.isEmpty(b)) {
                b = u.a(context).c();
            }
            if (TextUtils.isEmpty(b)) {
                b = u.a(context).b();
            }
            final String str = b;
            w.a().a(new Runnable() { // from class: com.baidu.sofire.core.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (d.class) {
                        com.baidu.sofire.g gVar = new com.baidu.sofire.g(context);
                        int b2 = gVar.b() + 1;
                        if (b2 < 0) {
                            b2 = 0;
                        }
                        gVar.b.putInt("td_a_c", b2);
                        gVar.b.commit();
                        d.b = u.a(context).a(str, b2);
                    }
                }
            });
            return b;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return "";
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x006f -> B:5:0x000a). Please submit an issue!!! */
    public static String b(Context context) {
        try {
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
        if (!TextUtils.isEmpty(f3612a)) {
            return f3612a;
        } else if (!com.baidu.sofire.i.e.a(context, false)) {
            com.baidu.sofire.b.a();
            return "";
        } else {
            String b2 = com.baidu.sofire.i.e.b(context);
            if (TextUtils.isEmpty(b2)) {
                if (com.baidu.sofire.i.e.b(context.getPackageName())) {
                    return "";
                }
                com.baidu.sofire.b.a();
                return d(context);
            } else if (com.baidu.sofire.i.e.b(b2)) {
                com.baidu.sofire.b.a();
                Pair<Integer, Object> b3 = b(context, 0, "gz", null, new Object[0]);
                if (b3 != null) {
                    if (((Integer) b3.first).intValue() == 0) {
                        return (String) b3.second;
                    }
                    return "";
                }
                f3612a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            } else {
                com.baidu.sofire.b.a();
                return d(context);
            }
        }
    }

    public static String a(Context context, String str) {
        int i;
        Pair<Integer, Object> a2;
        try {
            a2 = a("xgz", new Class[]{String.class}, str);
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            i = 501;
        }
        if (((Integer) a2.first).intValue() == 0 && !TextUtils.isEmpty((String) a2.second)) {
            return (String) a2.second;
        }
        i = ((Integer) a2.first).intValue() == 0 ? 502 : ((Integer) a2.first).intValue();
        try {
            return new JSONObject().put("rc", i).put(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, b(context)).toString();
        } catch (Throwable th2) {
            com.baidu.sofire.i.e.a();
            return "";
        }
    }

    public static String a(Context context, String str, String str2, int i, String str3) {
        if (context != null) {
            try {
            } catch (Throwable th) {
                com.baidu.sofire.i.e.a();
            }
            if (!TextUtils.isEmpty(str)) {
                Pair<Integer, Object> a2 = a(100067, "retrieveToken", new Class[]{String.class, String.class, Integer.TYPE, String.class}, str, str2, Integer.valueOf(i), str3);
                if (((Integer) a2.first).intValue() == 0) {
                    String str4 = (String) a2.second;
                    com.baidu.sofire.b.a();
                    if (TextUtils.isEmpty(str4)) {
                        return com.baidu.sofire.i.e.a(context, 9);
                    }
                    return str4;
                }
                new StringBuilder("gt failed ").append(a2.first);
                com.baidu.sofire.b.a();
                if (((Integer) a2.first).intValue() == 4 || ((Integer) a2.first).intValue() == 3) {
                    String[] g = com.baidu.sofire.i.e.g(context);
                    new StringBuilder("gt method try ").append(g[0]).append(" : ").append(g[1]);
                    com.baidu.sofire.b.a();
                    a(context, 0, g[0], g[1], 100067);
                    return com.baidu.sofire.i.e.a(context, ((Integer) a2.first).intValue() == 3 ? 5 : 2);
                }
                if (((Integer) a2.first).intValue() == 5 || ((Integer) a2.first).intValue() == 11) {
                    return com.baidu.sofire.i.e.a(context, 7);
                }
                return com.baidu.sofire.i.e.a(context, 8);
            }
        }
        return com.baidu.sofire.i.e.a(context, 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074 A[Catch: Throwable -> 0x00b3, TryCatch #2 {Throwable -> 0x01f4, blocks: (B:3:0x0005, B:6:0x001b, B:27:0x00c0, B:30:0x00cb, B:70:0x01c1, B:72:0x01ca, B:74:0x01d4, B:76:0x01df, B:81:0x0203, B:7:0x0023, B:9:0x0037, B:11:0x003d, B:14:0x006a, B:16:0x0074, B:23:0x00a3, B:22:0x009e, B:19:0x007e, B:21:0x0084, B:31:0x00d0, B:33:0x00ed, B:34:0x00f2, B:36:0x00f5, B:38:0x00ff, B:40:0x0108, B:42:0x010e, B:43:0x0122, B:44:0x0126, B:50:0x0146, B:54:0x014e, B:56:0x0157, B:57:0x015c, B:59:0x0174, B:60:0x0178, B:61:0x0196, B:63:0x019e, B:65:0x01af), top: B:84:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009e A[Catch: Throwable -> 0x00b3, TryCatch #2 {Throwable -> 0x01f4, blocks: (B:3:0x0005, B:6:0x001b, B:27:0x00c0, B:30:0x00cb, B:70:0x01c1, B:72:0x01ca, B:74:0x01d4, B:76:0x01df, B:81:0x0203, B:7:0x0023, B:9:0x0037, B:11:0x003d, B:14:0x006a, B:16:0x0074, B:23:0x00a3, B:22:0x009e, B:19:0x007e, B:21:0x0084, B:31:0x00d0, B:33:0x00ed, B:34:0x00f2, B:36:0x00f5, B:38:0x00ff, B:40:0x0108, B:42:0x010e, B:43:0x0122, B:44:0x0126, B:50:0x0146, B:54:0x014e, B:56:0x0157, B:57:0x015c, B:59:0x0174, B:60:0x0178, B:61:0x0196, B:63:0x019e, B:65:0x01af), top: B:84:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3 A[Catch: Throwable -> 0x00b3, TRY_LEAVE, TryCatch #2 {Throwable -> 0x01f4, blocks: (B:3:0x0005, B:6:0x001b, B:27:0x00c0, B:30:0x00cb, B:70:0x01c1, B:72:0x01ca, B:74:0x01d4, B:76:0x01df, B:81:0x0203, B:7:0x0023, B:9:0x0037, B:11:0x003d, B:14:0x006a, B:16:0x0074, B:23:0x00a3, B:22:0x009e, B:19:0x007e, B:21:0x0084, B:31:0x00d0, B:33:0x00ed, B:34:0x00f2, B:36:0x00f5, B:38:0x00ff, B:40:0x0108, B:42:0x010e, B:43:0x0122, B:44:0x0126, B:50:0x0146, B:54:0x014e, B:56:0x0157, B:57:0x015c, B:59:0x0174, B:60:0x0178, B:61:0x0196, B:63:0x019e, B:65:0x01af), top: B:84:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle a(Context context, String str, Bundle bundle) {
        Pair<Integer, Object> a2;
        Integer num;
        String str2;
        String str3;
        String b2;
        final Bundle bundle2 = new Bundle();
        try {
            new StringBuilder().append(str);
            com.baidu.sofire.b.a();
            if ("gzfi".equals(str)) {
                if (bundle != null) {
                    CallArgs callArgs = new CallArgs();
                    bundle.setClassLoader(MyProvider.class.getClassLoader());
                    CallArgs callArgs2 = (CallArgs) bundle.getParcelable("args");
                    if (callArgs2 != null) {
                        if (callArgs2.e.length == 2) {
                            String str4 = (String) callArgs2.e[0];
                            num = (Integer) callArgs2.e[1];
                            new StringBuilder("args ").append(str4).append(" ").append(num);
                            com.baidu.sofire.b.a();
                            str3 = str4;
                            str2 = null;
                        } else if (callArgs2.e.length == 3) {
                            String str5 = (String) callArgs2.e[2];
                            num = (Integer) callArgs2.e[1];
                            str3 = (String) callArgs2.e[0];
                            str2 = str5;
                        }
                        b2 = b(context, str3, num != null ? 0 : num.intValue(), str2);
                        if (!TextUtils.isEmpty(b2)) {
                            bundle2.putInt("status", 8);
                        } else {
                            callArgs.f = b2;
                            bundle2.putParcelable("result", callArgs);
                            bundle2.putInt("status", 0);
                        }
                        return bundle2;
                    }
                    num = null;
                    str2 = null;
                    str3 = null;
                    b2 = b(context, str3, num != null ? 0 : num.intValue(), str2);
                    if (!TextUtils.isEmpty(b2)) {
                    }
                    return bundle2;
                }
            } else if ("invokeMethod".equals(str)) {
                if (bundle != null) {
                    final CallArgs callArgs3 = new CallArgs();
                    bundle.setClassLoader(MyProvider.class.getClassLoader());
                    CallArgs callArgs4 = (CallArgs) bundle.getParcelable("args");
                    int i = callArgs4.f3605a;
                    int i2 = callArgs4.b;
                    final String str6 = callArgs4.c;
                    Object[] objArr = callArgs4.d;
                    Class[] clsArr = null;
                    if (objArr != null) {
                        Class[] clsArr2 = new Class[objArr.length];
                        for (int i3 = 0; i3 < objArr.length; i3++) {
                            String str7 = (String) objArr[i3];
                            if (!TextUtils.isEmpty(str7) && str7.contains("@@")) {
                                Class<?> a3 = com.baidu.sofire.i.e.a(str7);
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
                    Object[] objArr2 = callArgs4.e;
                    if (i2 == 1) {
                        if (i == 1 && "xgz".equals(str6)) {
                            a2 = b(str6, clsArr, objArr2);
                        } else {
                            a2 = a(i, str6, clsArr, objArr2);
                        }
                        bundle2.putInt("status", ((Integer) a2.first).intValue());
                        if (((Integer) a2.first).intValue() == 0) {
                            callArgs3.f = a2.second;
                        }
                    } else if (i2 == 0) {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        a(i, str6, new Callback() { // from class: com.baidu.sofire.core.d.4
                            @Override // com.baidu.sofire.ac.Callback
                            public final Object onEnd(Object... objArr3) {
                                try {
                                    bundle2.putInt("status", 0);
                                    callArgs3.f = objArr3[0];
                                    return null;
                                } catch (Throwable th) {
                                    try {
                                        com.baidu.sofire.i.e.a();
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
                                    new StringBuilder().append(str6).append("onError ").append(String.valueOf(objArr3[0]));
                                    com.baidu.sofire.b.a();
                                    return null;
                                } catch (Throwable th) {
                                    try {
                                        com.baidu.sofire.i.e.a();
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
                    bundle2.putParcelable("result", callArgs3);
                    return bundle2;
                }
            } else if ("gz".equals(str)) {
                String d = d(context);
                if (TextUtils.isEmpty(d)) {
                    bundle2.putInt("status", 8);
                } else {
                    CallArgs callArgs5 = new CallArgs();
                    callArgs5.f = d;
                    bundle2.putParcelable("result", callArgs5);
                    bundle2.putInt("status", 0);
                }
                return bundle2;
            } else {
                bundle2.putInt("status", 2);
                return bundle2;
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
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
            CallArgs callArgs = new CallArgs();
            callArgs.f3605a = i;
            callArgs.c = str;
            callArgs.b = i2;
            if (clsArr != null) {
                Object[] objArr2 = new Object[clsArr.length];
                for (int i3 = 0; i3 < clsArr.length; i3++) {
                    if (clsArr[i3].isPrimitive()) {
                        String a2 = com.baidu.sofire.i.e.a(clsArr[i3]);
                        if (!TextUtils.isEmpty(a2)) {
                            objArr2[i3] = a2 + "@@";
                        }
                    } else {
                        objArr2[i3] = clsArr[i3].getCanonicalName();
                    }
                }
                callArgs.d = objArr2;
            }
            callArgs.e = objArr;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("args", callArgs);
            StringBuilder sb = new StringBuilder("content://");
            sb.append(context.getPackageName()).append(".sofire.ac.provider");
            Uri parse = Uri.parse(sb.toString());
            Bundle bundle3 = null;
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(parse);
                Bundle call = acquireUnstableContentProviderClient.call(str2, null, bundle2);
                if (acquireUnstableContentProviderClient != 0) {
                    acquireUnstableContentProviderClient.release();
                    bundle = call;
                } else {
                    bundle = call;
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
                    bundle3 = (Bundle) declaredMethod.invoke(obj, str2, null, bundle2);
                }
                acquireContentProviderClient.release();
                bundle = bundle3;
            }
            if (bundle == null) {
                return Pair.create(3, null);
            }
            bundle.setClassLoader(CallArgs.class.getClassLoader());
            int i4 = bundle.getInt("status");
            CallArgs callArgs2 = null;
            if (i4 == 0) {
                callArgs2 = (CallArgs) bundle.getParcelable("result");
            }
            return Pair.create(Integer.valueOf(i4), callArgs2 == null ? null : callArgs2.f);
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return Pair.create(3, null);
        }
    }

    private static Pair<Integer, Object> b(Context context, int i, String str, Class<?>[] clsArr, Object... objArr) {
        return a(context, i, 1, str, clsArr, objArr);
    }

    public static void b(Context context, boolean z) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            eVar.d.putBoolean("s_a_pl", z);
            eVar.d.commit();
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }

    public static void b(Context context, String str) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            eVar.d.putString("s_h_d_id", str);
            eVar.d.commit();
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }

    static /* synthetic */ void c(Context context) {
        try {
            if (TextUtils.isEmpty(u.a(context).c())) {
                u.a(context).a(u.a(context).b());
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.sofire.core.d$5] */
    static /* synthetic */ void a(final Context context, final int i, final String str, final Callback callback, final Class[] clsArr, final Object[] objArr) {
        try {
            if (TextUtils.isEmpty(str)) {
                if (callback != null) {
                    callback.onError(1);
                }
            } else {
                new Thread() { // from class: com.baidu.sofire.core.d.5
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        super.run();
                        if (Callback.this != null) {
                            Callback.this.onBegin(new Object[0]);
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
            }
        } catch (Throwable th) {
            if (callback != null) {
                try {
                    callback.onError(3);
                } catch (Throwable th2) {
                }
            }
            com.baidu.sofire.i.e.a();
        }
    }
}
