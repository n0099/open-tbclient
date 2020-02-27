package com.baidu.swan.apps.res.widget.b;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
/* loaded from: classes11.dex */
public class c {
    private static String sMiOsName = null;
    private static String sMiuiVersion = null;
    private static String sOppoOsName = null;
    private static boolean sDebug = com.baidu.swan.apps.b.DEBUG;

    public static boolean shouldShowSystemToast(Context context) {
        return (shouldShowMiToast(context) || checkVersionIsHigh25()) || shouldShowMeizuToast(context);
    }

    private static boolean shouldShowMiToast(Context context) {
        if (checkIsMiuiRom()) {
            return (checkMiuiVersionIsLow9() && isFloatWindowOpAllowed(context)) ? false : true;
        }
        return false;
    }

    private static boolean checkMiuiVersionIsLow9() {
        String[] split;
        if (sMiuiVersion == null) {
            sMiuiVersion = getProp(RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL);
        }
        if (sDebug) {
            Log.d("ToastUtils", "sMiuiVersion = " + sMiuiVersion);
        }
        if (!TextUtils.isEmpty(sMiuiVersion) && (split = sMiuiVersion.split(".")) != null && split.length >= 1 && split[0].length() >= 2) {
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

    private static boolean checkVersionIsHigh25() {
        return Build.VERSION.SDK_INT >= 25;
    }

    private static boolean checkIsMiuiRom() {
        if (sMiOsName == null) {
            sMiOsName = getProp("ro.miui.ui.version.name");
        }
        if (sDebug) {
            Log.d("ToastUtils", "OsName = " + sMiOsName);
        }
        return !TextUtils.isEmpty(sMiOsName);
    }

    public static boolean checkIsOppoRom() {
        if (sOppoOsName == null) {
            sOppoOsName = getProp("ro.build.version.opporom");
        }
        if (sDebug) {
            Log.d("ToastUtils", "OsName = " + sOppoOsName);
        }
        return !TextUtils.isEmpty(sOppoOsName);
    }

    private static boolean shouldShowMeizuToast(Context context) {
        return checkIsMeizuRom() && !isFloatWindowOpAllowed(context) && Build.VERSION.SDK_INT >= 23;
    }

    private static boolean checkIsMeizuRom() {
        return Build.FINGERPRINT.contains("Flyme") || Pattern.compile("Flyme", 2).matcher(Build.DISPLAY).find();
    }

    public static void setToastAnimation(Toast toast, @StyleRes int i) {
        Object field;
        try {
            Object field2 = getField(toast, "mTN");
            if (field2 != null && (field = getField(field2, "mParams")) != null && (field instanceof WindowManager.LayoutParams)) {
                ((WindowManager.LayoutParams) field).windowAnimations = i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object getField(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
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
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    com.baidu.swan.d.c.closeSafely(bufferedReader);
                    return readLine == null ? "" : readLine;
                } catch (IOException e) {
                    com.baidu.swan.d.c.closeSafely(bufferedReader);
                    com.baidu.swan.d.c.closeSafely(bufferedReader);
                    return "";
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.d.c.closeSafely(bufferedReader);
                throw th;
            }
        } catch (IOException e2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            com.baidu.swan.d.c.closeSafely(bufferedReader);
            throw th;
        }
    }
}
