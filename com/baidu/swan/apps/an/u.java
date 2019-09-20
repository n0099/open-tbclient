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
    private static String baD;
    private static String baE;

    public static boolean bM(Context context) {
        if (context == null) {
            return false;
        }
        if (PA()) {
            return bN(context);
        }
        if (PB()) {
            return bO(context);
        }
        if (PC()) {
            return bP(context);
        }
        return false;
    }

    private static boolean bN(@NonNull Context context) {
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

    private static boolean bO(@NonNull Context context) {
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

    private static boolean bP(@NonNull Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean PA() {
        return check("EMUI");
    }

    public static boolean PB() {
        return check("VIVO");
    }

    public static boolean PC() {
        return check("OPPO");
    }

    public static boolean check(String str) {
        if (baD != null) {
            return baD.equals(str);
        }
        String gG = gG("ro.miui.ui.version.name");
        baE = gG;
        if (!TextUtils.isEmpty(gG)) {
            baD = "MIUI";
        } else {
            String gG2 = gG("ro.build.version.emui");
            baE = gG2;
            if (!TextUtils.isEmpty(gG2)) {
                baD = "EMUI";
            } else {
                String gG3 = gG("ro.build.version.opporom");
                baE = gG3;
                if (!TextUtils.isEmpty(gG3)) {
                    baD = "OPPO";
                } else {
                    String gG4 = gG("ro.vivo.os.version");
                    baE = gG4;
                    if (!TextUtils.isEmpty(gG4)) {
                        baD = "VIVO";
                    } else {
                        String gG5 = gG("ro.smartisan.version");
                        baE = gG5;
                        if (!TextUtils.isEmpty(gG5)) {
                            baD = "SMARTISAN";
                        } else {
                            String gG6 = gG("ro.gn.sv.version");
                            baE = gG6;
                            if (!TextUtils.isEmpty(gG6)) {
                                baD = "SMARTISAN";
                            } else {
                                String gG7 = gG("ro.build.rom.id");
                                baE = gG7;
                                if (!TextUtils.isEmpty(gG7)) {
                                    baD = "NUBIA";
                                } else {
                                    baE = Build.DISPLAY;
                                    if (baE.toUpperCase().contains("FLYME")) {
                                        baD = "FLYME";
                                    } else {
                                        baE = "unknown";
                                        baD = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return baD.equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [236=4] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String gG(String str) {
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
