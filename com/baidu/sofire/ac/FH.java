package com.baidu.sofire.ac;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.a.a;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.e;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class FH {
    public static final int TYPE_VERSION = 1;

    private FH() {
    }

    public static void init(final Context context, final String str, final String str2, final int... iArr) {
        try {
            new Thread(new Runnable() { // from class: com.baidu.sofire.ac.FH.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        e.a(context);
                        new com.baidu.sofire.e(context).e(iArr);
                        c ap = c.ap(context);
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                            String[] e = d.e(context);
                            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                                ap.a(e[0], e[1]);
                            }
                        } else {
                            ap.a(str, str2);
                        }
                        c.a(1);
                        ap.a((Callback) null);
                    } catch (Throwable th) {
                        d.a(th);
                    }
                }
            }).start();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void initDelay(final Context context, final int i, final String str, final String str2, final int... iArr) {
        try {
            new Thread(new Runnable() { // from class: com.baidu.sofire.ac.FH.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        e.a(context);
                        if (i > 0) {
                            Thread.sleep(i * 1000);
                        }
                        new com.baidu.sofire.e(context).e(iArr);
                        c ap = c.ap(context);
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                            String[] e = d.e(context);
                            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                                ap.a(e[0], e[1]);
                            }
                        } else {
                            ap.a(str, str2);
                        }
                        c.a(1);
                        ap.a((Callback) null);
                    } catch (Throwable th) {
                        d.a(th);
                    }
                }
            }).start();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static boolean call(int i, String str) {
        return call(i, str, null);
    }

    public static Pair<Integer, Object> callSync(int i, String str) {
        return callSync(i, str, null, new Object[0]);
    }

    public static Pair<Integer, Object> callSync(int i, String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> a;
        try {
            c nn = c.nn();
            if (nn == null) {
                a = new Pair<>(3, null);
            } else {
                a = nn.a(i, str, clsArr, objArr);
            }
            return a;
        } catch (Throwable th) {
            d.a(th);
            return new Pair<>(3, null);
        }
    }

    public static boolean call(int i, String str, Callback callback) {
        return call(i, str, callback, null, new Object[0]);
    }

    public static boolean call(int i, String str, Class<?>[] clsArr, Object... objArr) {
        return call(i, str, null, clsArr, objArr);
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.sofire.core.c$3] */
    public static boolean call(final int i, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            final c nn = c.nn();
            if (nn == null) {
                for (int i2 = 0; i2 < 20; i2++) {
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e) {
                        d.a(e);
                    }
                    nn = c.nn();
                    if (nn != null) {
                        break;
                    }
                }
                if (nn == null) {
                    return false;
                }
            }
            new StringBuilder().append(str);
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "0");
            d.a(nn.a, "1003136", hashMap);
            if (TextUtils.isEmpty(str)) {
                if (callback != null) {
                    callback.onError(1);
                }
            } else {
                new Thread() { // from class: com.baidu.sofire.core.c.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        ApkInfo apkInfo;
                        boolean z;
                        ApkInfo apkInfo2 = null;
                        super.run();
                        try {
                            if (callback != null) {
                                callback.onBegin(new Object[0]);
                            }
                            if (c.this.Qs.aW(i)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                while (c.this.Qs.aW(i) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                                    SystemClock.sleep(300L);
                                }
                            }
                            if (!c.this.Qs.aW(i)) {
                                if (!c.this.d) {
                                    c.a(3);
                                    c.this.a((Callback) null);
                                }
                                e aq = e.aq(c.this.a.getApplicationContext());
                                long currentTimeMillis2 = System.currentTimeMillis();
                                while (System.currentTimeMillis() - currentTimeMillis2 <= 120000) {
                                    apkInfo2 = c.this.Qs.aV(i);
                                    if (apkInfo2 != null) {
                                        if (aq.bY(apkInfo2.packageName) == null) {
                                            if (apkInfo2.initStatus == -1) {
                                                break;
                                            }
                                        } else {
                                            apkInfo = apkInfo2;
                                            z = true;
                                            break;
                                        }
                                    }
                                    SystemClock.sleep(1000L);
                                }
                                apkInfo = apkInfo2;
                                z = false;
                                if (!z) {
                                    if (callback != null) {
                                        callback.onError(4);
                                        return;
                                    }
                                    return;
                                }
                                Class<?> bX = ((d) aq.bY(apkInfo.packageName).classLoader).bX("com.baidu.sofire.engine.EngineImpl");
                                Object a = com.baidu.sofire.b.d.a(bX.getDeclaredMethod("getInstance", Context.class).invoke(bX, c.this.a), str, clsArr, objArr);
                                try {
                                    new StringBuilder().append(a);
                                } catch (Throwable th) {
                                    com.baidu.sofire.b.d.a(th);
                                }
                                if (callback != null) {
                                    callback.onEnd(a);
                                }
                            } else if (callback != null) {
                                callback.onError(3);
                            }
                        } catch (IllegalAccessException e2) {
                            e2.getMessage();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (IllegalArgumentException e3) {
                            e3.getMessage();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (NoSuchMethodException e4) {
                            e4.getMessage();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (InvocationTargetException e5) {
                            e5.getMessage();
                            if (callback != null) {
                                callback.onError(2);
                            }
                        } catch (Throwable th2) {
                            th2.getMessage();
                            if (callback != null) {
                                callback.onError(3);
                            }
                        }
                    }
                }.start();
            }
            return true;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static Object getPInfo(int i, int i2) {
        switch (i2) {
            case 1:
                if (i <= 0) {
                    return "";
                }
                try {
                    com.baidu.sofire.core.e no = com.baidu.sofire.core.e.no();
                    if (no == null) {
                        return "";
                    }
                    List<ApkInfo> b = no.b();
                    if (b == null || b.size() <= 0) {
                        return "";
                    }
                    for (ApkInfo apkInfo : b) {
                        if (apkInfo.key == i) {
                            if (apkInfo.versionName == null) {
                                return "";
                            }
                            return apkInfo.versionName;
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    d.a(th);
                    return "";
                }
            default:
                return "";
        }
    }

    public static String getVersion(Context context) {
        return "3.0.6.1";
    }

    public static String gz(Context context) {
        String string;
        try {
            string = new com.baidu.sofire.e(context).b.getString("xytk", "");
        } catch (Throwable th) {
            d.a(th);
        }
        if (TextUtils.isEmpty(string)) {
            String a = e.a(context);
            if (!TextUtils.isEmpty(a)) {
                String[] split = a.split("\\|");
                if (split != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                    byte[] re = F.getInstance().re(split[1].getBytes(), split[0].getBytes());
                    if (re != null) {
                        return split[0] + d.a(re);
                    }
                } else {
                    return a;
                }
            }
            return "";
        }
        return string;
    }

    public static boolean isInitSuc(int i) {
        ApkInfo aV;
        com.baidu.sofire.core.e no;
        try {
            a aVar = a.Qi;
            if (aVar == null || (aV = aVar.aV(i)) == null || aV.initStatus != 1 || (no = com.baidu.sofire.core.e.no()) == null) {
                return false;
            }
            return no.bY(aV.packageName) != null;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }
}
