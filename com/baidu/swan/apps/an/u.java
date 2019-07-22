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
    private static String baf;
    private static String bag;

    public static boolean bM(Context context) {
        if (context == null) {
            return false;
        }
        if (Pw()) {
            return bN(context);
        }
        if (Px()) {
            return bO(context);
        }
        if (Py()) {
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

    public static boolean Pw() {
        return check("EMUI");
    }

    public static boolean Px() {
        return check("VIVO");
    }

    public static boolean Py() {
        return check("OPPO");
    }

    public static boolean check(String str) {
        if (baf != null) {
            return baf.equals(str);
        }
        String gE = gE("ro.miui.ui.version.name");
        bag = gE;
        if (!TextUtils.isEmpty(gE)) {
            baf = "MIUI";
        } else {
            String gE2 = gE("ro.build.version.emui");
            bag = gE2;
            if (!TextUtils.isEmpty(gE2)) {
                baf = "EMUI";
            } else {
                String gE3 = gE("ro.build.version.opporom");
                bag = gE3;
                if (!TextUtils.isEmpty(gE3)) {
                    baf = "OPPO";
                } else {
                    String gE4 = gE("ro.vivo.os.version");
                    bag = gE4;
                    if (!TextUtils.isEmpty(gE4)) {
                        baf = "VIVO";
                    } else {
                        String gE5 = gE("ro.smartisan.version");
                        bag = gE5;
                        if (!TextUtils.isEmpty(gE5)) {
                            baf = "SMARTISAN";
                        } else {
                            String gE6 = gE("ro.gn.sv.version");
                            bag = gE6;
                            if (!TextUtils.isEmpty(gE6)) {
                                baf = "SMARTISAN";
                            } else {
                                String gE7 = gE("ro.build.rom.id");
                                bag = gE7;
                                if (!TextUtils.isEmpty(gE7)) {
                                    baf = "NUBIA";
                                } else {
                                    bag = Build.DISPLAY;
                                    if (bag.toUpperCase().contains("FLYME")) {
                                        baf = "FLYME";
                                    } else {
                                        bag = "unknown";
                                        baf = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return baf.equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [236=4] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String gE(String str) {
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
