package com.baidu.swan.apps.res.widget.b;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class c {
    private static String aNk = null;
    private static String aNl = null;
    private static String aNm = null;
    private static boolean aMU = com.baidu.swan.apps.b.DEBUG;

    public static boolean bU(Context context) {
        return (bV(context) || IF()) || bW(context);
    }

    private static boolean bV(Context context) {
        if (IG()) {
            return (IE() && isFloatWindowOpAllowed(context)) ? false : true;
        }
        return false;
    }

    private static boolean IE() {
        String[] split;
        if (aNl == null) {
            aNl = getProp("ro.build.version.incremental");
        }
        if (aMU) {
            Log.d("ToastUtils", "sMiuiVersion = " + aNl);
        }
        if (!TextUtils.isEmpty(aNl) && (split = aNl.split(".")) != null && split.length >= 1 && split[0].length() >= 2) {
            String substring = split[0].substring(1);
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            try {
                return Integer.parseInt(substring) < 9;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    private static boolean IF() {
        return Build.VERSION.SDK_INT >= 25;
    }

    private static boolean IG() {
        if (aNk == null) {
            aNk = getProp("ro.miui.ui.version.name");
        }
        if (aMU) {
            Log.d("ToastUtils", "OsName = " + aNk);
        }
        return !TextUtils.isEmpty(aNk);
    }

    public static boolean IH() {
        if (aNm == null) {
            aNm = getProp("ro.build.version.opporom");
        }
        if (aMU) {
            Log.d("ToastUtils", "OsName = " + aNm);
        }
        return !TextUtils.isEmpty(aNm);
    }

    private static boolean bW(Context context) {
        return II() && !isFloatWindowOpAllowed(context) && Build.VERSION.SDK_INT >= 23;
    }

    private static boolean II() {
        return Build.FINGERPRINT.contains("Flyme") || Pattern.compile("Flyme", 2).matcher(Build.DISPLAY).find();
    }

    public static void a(Toast toast, @StyleRes int i) {
        Object d;
        try {
            Object d2 = d(toast, "mTN");
            if (d2 != null && (d = d(d2, "mParams")) != null && (d instanceof WindowManager.LayoutParams)) {
                ((WindowManager.LayoutParams) d).windowAnimations = i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object d(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField;
        if (obj == null || (declaredField = obj.getClass().getDeclaredField(str)) == null) {
            return null;
        }
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static boolean isFloatWindowOpAllowed(Context context) {
        Method method;
        if (context != null && Build.VERSION.SDK_INT >= 19) {
            try {
                Object systemService = context.getSystemService("appops");
                if (systemService == null || (method = systemService.getClass().getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class)) == null) {
                    return false;
                }
                return ((Integer) method.invoke(systemService, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [461=4] */
    private static String getProp(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return readLine == null ? "" : readLine;
            } catch (IOException e2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        return "";
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return "";
                    }
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }
}
