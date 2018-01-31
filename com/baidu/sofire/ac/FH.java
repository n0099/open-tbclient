package com.baidu.sofire.ac;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.a.a;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.b.e;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.d;
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
                        new d(context).l(iArr);
                        c aB = c.aB(context);
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                            String[] e = com.baidu.sofire.b.d.e(context);
                            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                                aB.a(e[0], e[1]);
                            }
                        } else {
                            aB.a(str, str2);
                        }
                        c.a(1);
                        aB.a((Callback) null);
                    } catch (Throwable th) {
                        com.baidu.sofire.b.d.a(th);
                    }
                }
            }).start();
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
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
                        new d(context).l(iArr);
                        c aB = c.aB(context);
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                            String[] e = com.baidu.sofire.b.d.e(context);
                            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                                aB.a(e[0], e[1]);
                            }
                        } else {
                            aB.a(str, str2);
                        }
                        c.a(1);
                        aB.a((Callback) null);
                    } catch (Throwable th) {
                        com.baidu.sofire.b.d.a(th);
                    }
                }
            }).start();
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
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
            c uR = c.uR();
            if (uR == null) {
                a = new Pair<>(3, null);
            } else {
                a = uR.a(i, str, clsArr, objArr);
            }
            return a;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
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
            final c uR = c.uR();
            if (uR == null) {
                for (int i2 = 0; i2 < 20; i2++) {
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e) {
                        com.baidu.sofire.b.d.a(e);
                    }
                    uR = c.uR();
                    if (uR != null) {
                        break;
                    }
                }
                if (uR == null) {
                    return false;
                }
            }
            new StringBuilder().append(str);
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "0");
            com.baidu.sofire.b.d.a(uR.a, "1003136", hashMap);
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
                            if (c.this.aFc.dX(i)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                while (c.this.aFc.dX(i) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                                    SystemClock.sleep(300L);
                                }
                            }
                            if (!c.this.aFc.dX(i)) {
                                if (!c.this.d) {
                                    c.a(3);
                                    c.this.a((Callback) null);
                                }
                                e aC = e.aC(c.this.a.getApplicationContext());
                                long currentTimeMillis2 = System.currentTimeMillis();
                                while (System.currentTimeMillis() - currentTimeMillis2 <= 120000) {
                                    apkInfo2 = c.this.aFc.dW(i);
                                    if (apkInfo2 != null) {
                                        if (aC.cf(apkInfo2.packageName) == null) {
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
                                Class<?> ce = ((d) aC.cf(apkInfo.packageName).classLoader).ce("com.baidu.sofire.engine.EngineImpl");
                                Object a = com.baidu.sofire.b.d.a(ce.getDeclaredMethod("getInstance", Context.class).invoke(ce, c.this.a), str, clsArr, objArr);
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
            com.baidu.sofire.b.d.a(th);
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
                    com.baidu.sofire.core.e uS = com.baidu.sofire.core.e.uS();
                    if (uS == null) {
                        return "";
                    }
                    List<ApkInfo> b = uS.b();
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
                    com.baidu.sofire.b.d.a(th);
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
            string = new d(context).b.getString("xytk", "");
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
        if (TextUtils.isEmpty(string)) {
            String a = e.a(context);
            if (!TextUtils.isEmpty(a)) {
                String[] split = a.split("\\|");
                if (split != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                    byte[] re = F.getInstance().re(split[1].getBytes(), split[0].getBytes());
                    if (re != null) {
                        return split[0] + com.baidu.sofire.b.d.a(re);
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
        ApkInfo dW;
        com.baidu.sofire.core.e uS;
        try {
            a aVar = a.aES;
            if (aVar == null || (dW = aVar.dW(i)) == null || dW.initStatus != 1 || (uS = com.baidu.sofire.core.e.uS()) == null) {
                return false;
            }
            return uS.cf(dW.packageName) != null;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return false;
        }
    }
}
