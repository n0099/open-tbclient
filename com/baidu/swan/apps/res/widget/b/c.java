package com.baidu.swan.apps.res.widget.b;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.StyleRes;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class c {
    private static String dBj = null;
    private static String dBk = null;
    private static String dBl = null;
    private static boolean sDebug = com.baidu.swan.apps.b.DEBUG;

    public static boolean dk(Context context) {
        return (dl(context) || aHU()) || dm(context);
    }

    private static boolean dl(Context context) {
        if (aHV()) {
            return (aHT() && isFloatWindowOpAllowed(context)) ? false : true;
        }
        return false;
    }

    private static boolean aHT() {
        String[] split;
        if (dBk == null) {
            dBk = getProp(RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL);
        }
        if (sDebug) {
            Log.d("ToastUtils", "sMiuiVersion = " + dBk);
        }
        if (!TextUtils.isEmpty(dBk) && (split = dBk.split(".")) != null && split.length >= 1 && split[0].length() >= 2) {
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

    private static boolean aHU() {
        return Build.VERSION.SDK_INT >= 25;
    }

    private static boolean aHV() {
        if (dBj == null) {
            dBj = getProp("ro.miui.ui.version.name");
        }
        if (sDebug) {
            Log.d("ToastUtils", "OsName = " + dBj);
        }
        return !TextUtils.isEmpty(dBj);
    }

    public static boolean aHW() {
        if (dBl == null) {
            dBl = getProp("ro.build.version.opporom");
        }
        if (sDebug) {
            Log.d("ToastUtils", "OsName = " + dBl);
        }
        return !TextUtils.isEmpty(dBl);
    }

    private static boolean dm(Context context) {
        return aHX() && !isFloatWindowOpAllowed(context) && Build.VERSION.SDK_INT >= 23;
    }

    private static boolean aHX() {
        return Build.FINGERPRINT.contains("Flyme") || Pattern.compile("Flyme", 2).matcher(Build.DISPLAY).find();
    }

    public static void a(Toast toast, @StyleRes int i) {
        Object f;
        try {
            Object f2 = f(toast, "mTN");
            if (f2 != null && (f = f(f2, "mParams")) != null && (f instanceof WindowManager.LayoutParams)) {
                ((WindowManager.LayoutParams) f).windowAnimations = i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object f(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
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

    private static String getProp(String str) {
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                try {
                    String readLine = bufferedReader2.readLine();
                    com.baidu.swan.c.d.closeSafely(bufferedReader2);
                    return readLine == null ? "" : readLine;
                } catch (IOException e) {
                    com.baidu.swan.c.d.closeSafely(bufferedReader2);
                    com.baidu.swan.c.d.closeSafely(bufferedReader2);
                    return "";
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                com.baidu.swan.c.d.closeSafely(bufferedReader);
                throw th;
            }
        } catch (IOException e2) {
            bufferedReader2 = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            com.baidu.swan.c.d.closeSafely(bufferedReader);
            throw th;
        }
    }
}
