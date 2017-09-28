package com.baidu.sofire.ac;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b.d;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.e;
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
                        new e(context).c(iArr);
                        c aq = c.aq(context);
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                            String[] e = d.e(context);
                            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                                aq.a(e[0], e[1]);
                            }
                        } else {
                            aq.a(str, str2);
                        }
                        c.a(1);
                        aq.b();
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
        c nq = c.nq();
        return nq == null ? new Pair<>(3, null) : nq.a(i, str, clsArr, objArr);
    }

    public static boolean call(int i, String str, Callback callback) {
        return call(i, str, callback, null, new Object[0]);
    }

    public static boolean call(int i, String str, Class<?>[] clsArr, Object... objArr) {
        return call(i, str, null, clsArr, objArr);
    }

    public static boolean call(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        try {
            c nq = c.nq();
            if (nq == null) {
                for (int i2 = 0; i2 < 20; i2++) {
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e) {
                        d.a(e);
                    }
                    nq = c.nq();
                    if (nq != null) {
                        break;
                    }
                }
                if (nq == null) {
                    return false;
                }
            }
            nq.a(i, str, callback, clsArr, objArr);
            return true;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static boolean isInitSuc(int i) {
        ApkInfo aX;
        com.baidu.sofire.core.e nr;
        a aVar = a.PJ;
        return (aVar == null || (aX = aVar.aX(i)) == null || aX.initStatus != 1 || (nr = com.baidu.sofire.core.e.nr()) == null || nr.bT(aX.packageName) == null) ? false : true;
    }

    public static Object getPInfo(int i, int i2) {
        switch (i2) {
            case 1:
                if (i <= 0) {
                    return "";
                }
                try {
                    com.baidu.sofire.core.e nr = com.baidu.sofire.core.e.nr();
                    if (nr == null) {
                        return "";
                    }
                    List<ApkInfo> b = nr.b();
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
        return "2.0.8";
    }

    public static String gz(Context context) {
        try {
            return com.baidu.sofire.b.e.a(context);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }
}
