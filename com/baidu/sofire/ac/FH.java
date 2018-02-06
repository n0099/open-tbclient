package com.baidu.sofire.ac;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.f;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.e;
import java.util.List;
/* loaded from: classes.dex */
public class FH {
    public static final int TYPE_VERSION = 1;

    private FH() {
    }

    public static void init(Context context, String str, String str2, int... iArr) {
        d.a(context, str, str2, iArr);
    }

    public static void initDelay(final Context context, final int i, final String str, final String str2, final int... iArr) {
        try {
            new Thread(new Runnable() { // from class: com.baidu.sofire.ac.FH.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        f.a(context);
                        if (i > 0) {
                            Thread.sleep(i * 1000);
                        }
                        new e(context).k(iArr);
                        c aC = c.aC(context);
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            aC.a(str, str2);
                        }
                        c.a(1);
                        aC.a((Callback) null);
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
            c vE = c.vE();
            if (vE == null) {
                a = new Pair<>(3, null);
            } else {
                a = vE.a(i, str, clsArr, objArr);
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

    public static boolean call(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        return d.a(i, str, callback, clsArr, objArr);
    }

    public static Object getPInfo(int i, int i2) {
        switch (i2) {
            case 1:
                if (i <= 0) {
                    return "";
                }
                try {
                    com.baidu.sofire.core.e vF = com.baidu.sofire.core.e.vF();
                    if (vF == null) {
                        return "";
                    }
                    List<ApkInfo> b = vF.b();
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
        return "3.1.0";
    }

    public static String gzfi(Context context, String str, int i) {
        if (i != 0) {
            call(1, "ice", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
        }
        return gz(context);
    }

    public static String gz(Context context) {
        e eVar;
        String string;
        byte[] re;
        try {
            eVar = new e(context);
            string = eVar.b.getString("xytk", "");
        } catch (Throwable th) {
            d.a(th);
        }
        if (TextUtils.isEmpty(string)) {
            String a = f.a(context);
            if (!TextUtils.isEmpty(a)) {
                String[] split = a.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
                if (split != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                    if (F.getInstance().re(split[1].getBytes(), split[0].getBytes()) != null) {
                        String str = split[0] + d.a(re);
                        eVar.d.putString("xytk", str);
                        eVar.d.commit();
                        return str;
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
        com.baidu.sofire.core.e vF;
        try {
            a aVar = a.aGn;
            if (aVar == null || (dW = aVar.dW(i)) == null || dW.initStatus != 1 || (vF = com.baidu.sofire.core.e.vF()) == null) {
                return false;
            }
            return vF.cm(dW.packageName) != null;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }
}
