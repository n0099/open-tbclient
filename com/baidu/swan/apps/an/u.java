package com.baidu.swan.apps.an;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public class u {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String btC;
    private static String btD;

    public static boolean bN(Context context) {
        if (context == null) {
            return false;
        }
        if (Uq()) {
            return bO(context);
        }
        if (Ur()) {
            return bP(context);
        }
        if (Us()) {
            return bQ(context);
        }
        return false;
    }

    private static boolean bO(@NonNull Context context) {
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

    private static boolean bP(@NonNull Context context) {
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

    private static boolean bQ(@NonNull Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean Uq() {
        return check("EMUI");
    }

    public static boolean Ur() {
        return check("VIVO");
    }

    public static boolean Us() {
        return check("OPPO");
    }

    public static boolean check(String str) {
        if (btC != null) {
            return btC.equals(str);
        }
        String hk = hk("ro.miui.ui.version.name");
        btD = hk;
        if (!TextUtils.isEmpty(hk)) {
            btC = "MIUI";
        } else {
            String hk2 = hk("ro.build.version.emui");
            btD = hk2;
            if (!TextUtils.isEmpty(hk2)) {
                btC = "EMUI";
            } else {
                String hk3 = hk("ro.build.version.opporom");
                btD = hk3;
                if (!TextUtils.isEmpty(hk3)) {
                    btC = "OPPO";
                } else {
                    String hk4 = hk("ro.vivo.os.version");
                    btD = hk4;
                    if (!TextUtils.isEmpty(hk4)) {
                        btC = "VIVO";
                    } else {
                        String hk5 = hk("ro.smartisan.version");
                        btD = hk5;
                        if (!TextUtils.isEmpty(hk5)) {
                            btC = "SMARTISAN";
                        } else {
                            String hk6 = hk("ro.gn.sv.version");
                            btD = hk6;
                            if (!TextUtils.isEmpty(hk6)) {
                                btC = "SMARTISAN";
                            } else {
                                String hk7 = hk("ro.build.rom.id");
                                btD = hk7;
                                if (!TextUtils.isEmpty(hk7)) {
                                    btC = "NUBIA";
                                } else {
                                    btD = Build.DISPLAY;
                                    if (btD.toUpperCase().contains("FLYME")) {
                                        btC = "FLYME";
                                    } else {
                                        btD = "unknown";
                                        btC = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return btC.equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [236=4] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String hk(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return readLine;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return readLine;
                        }
                    }
                    return readLine;
                } catch (IOException e2) {
                    e = e2;
                    Log.e("SwanAppRomUtils", "Unable to read prop " + str, e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }
}
