package com.baidu.swan.apps.ao;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.ar.constants.HttpConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes9.dex */
public class ac {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String sRomName;
    private static String sRomVersion;

    public static boolean dD(Context context) {
        if (context == null) {
            return false;
        }
        if (isEmui()) {
            return dE(context);
        }
        if (isVivo()) {
            return dF(context);
        }
        if (isOppo()) {
            return dG(context);
        }
        if (isMiui()) {
            return dH(context);
        }
        return false;
    }

    private static boolean dE(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    private static boolean dF(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    private static boolean dG(@NonNull Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    private static boolean dH(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static int dI(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return aRA();
        }
        if (dD(context)) {
            if (isMiui()) {
                Resources resources = context.getResources();
                try {
                    int identifier = resources.getIdentifier("notch_height", "dimen", HttpConstants.OS_TYPE_VALUE);
                    if (identifier > 0) {
                        return resources.getDimensionPixelSize(identifier);
                    }
                } catch (Exception e) {
                    return 0;
                }
            }
            if (isEmui()) {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return ((int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]))[1];
                } catch (Exception e2) {
                    return 0;
                }
            } else if (isOppo()) {
                return 80;
            } else {
                if (isVivo()) {
                    return ah.O(32.0f);
                }
                return 0;
            }
        }
        return 0;
    }

    @RequiresApi(28)
    private static int aRA() {
        DisplayCutout displayCutout;
        int i = 0;
        if (com.baidu.swan.apps.runtime.e.aMl() != null && com.baidu.swan.apps.runtime.e.aMl().getActivity() != null) {
            try {
                WindowInsets rootWindowInsets = com.baidu.swan.apps.runtime.e.aMl().getActivity().getWindow().getDecorView().getRootWindowInsets();
                if (rootWindowInsets != null && (displayCutout = rootWindowInsets.getDisplayCutout()) != null) {
                    i = displayCutout.getSafeInsetTop();
                    if (DEBUG) {
                        Log.d("SwanAppRomUtils", "刘海屏高度:" + i);
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.w("SwanAppRomUtils", e);
                }
            }
        }
        return i;
    }

    public static boolean isEmui() {
        return check(RomUtils.ROM_EMUI);
    }

    public static boolean isMiui() {
        return check(RomUtils.ROM_MIUI);
    }

    public static boolean isVivo() {
        return check(RomUtils.ROM_VIVO);
    }

    public static boolean isOppo() {
        return check(RomUtils.ROM_OPPO);
    }

    public static boolean check(String str) {
        if (sRomName != null) {
            return sRomName.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        sRomVersion = prop;
        if (!TextUtils.isEmpty(prop)) {
            sRomName = RomUtils.ROM_MIUI;
        } else {
            String prop2 = getProp("ro.build.version.emui");
            sRomVersion = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                sRomName = RomUtils.ROM_EMUI;
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                sRomVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sRomName = RomUtils.ROM_OPPO;
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    sRomVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sRomName = RomUtils.ROM_VIVO;
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        sRomVersion = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            sRomName = RomUtils.ROM_SMARTISAN;
                        } else {
                            String prop6 = getProp("ro.gn.sv.version");
                            sRomVersion = prop6;
                            if (!TextUtils.isEmpty(prop6)) {
                                sRomName = RomUtils.ROM_SMARTISAN;
                            } else {
                                String prop7 = getProp("ro.build.rom.id");
                                sRomVersion = prop7;
                                if (!TextUtils.isEmpty(prop7)) {
                                    sRomName = RomUtils.ROM_NUBIA;
                                } else {
                                    sRomVersion = Build.DISPLAY;
                                    if (sRomVersion.toUpperCase().contains(RomUtils.ROM_FLYME)) {
                                        sRomName = RomUtils.ROM_FLYME;
                                    } else {
                                        sRomVersion = "unknown";
                                        sRomName = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return sRomName.equals(str);
    }

    public static String getProp(String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
                try {
                    str2 = bufferedReader.readLine();
                    com.baidu.swan.c.d.closeSafely(bufferedReader);
                } catch (IOException e) {
                    e = e;
                    if (DEBUG) {
                        Log.e("SwanAppRomUtils", "Unable to read prop " + str, e);
                    }
                    com.baidu.swan.c.d.closeSafely(bufferedReader);
                    com.baidu.swan.c.d.closeSafely(bufferedReader);
                    return str2;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.d.closeSafely(null);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.swan.c.d.closeSafely(null);
            throw th;
        }
        return str2;
    }
}
