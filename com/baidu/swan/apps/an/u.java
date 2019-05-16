package com.baidu.swan.apps.an;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.keepLive.util.RomTypeUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public class u {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String aZv;
    private static String aZw;

    public static boolean bM(Context context) {
        if (context == null) {
            return false;
        }
        if (isEmui()) {
            return bN(context);
        }
        if (OH()) {
            return bO(context);
        }
        if (OI()) {
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

    public static boolean isEmui() {
        return check(RomTypeUtil.ROM_EMUI);
    }

    public static boolean OH() {
        return check(RomTypeUtil.ROM_VIVO);
    }

    public static boolean OI() {
        return check(RomTypeUtil.ROM_OPPO);
    }

    public static boolean check(String str) {
        if (aZv != null) {
            return aZv.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        aZw = prop;
        if (!TextUtils.isEmpty(prop)) {
            aZv = RomTypeUtil.ROM_MIUI;
        } else {
            String prop2 = getProp("ro.build.version.emui");
            aZw = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                aZv = RomTypeUtil.ROM_EMUI;
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                aZw = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    aZv = RomTypeUtil.ROM_OPPO;
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    aZw = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        aZv = RomTypeUtil.ROM_VIVO;
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        aZw = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            aZv = RomTypeUtil.ROM_SMARTISAN;
                        } else {
                            String prop6 = getProp("ro.gn.sv.version");
                            aZw = prop6;
                            if (!TextUtils.isEmpty(prop6)) {
                                aZv = RomTypeUtil.ROM_SMARTISAN;
                            } else {
                                String prop7 = getProp("ro.build.rom.id");
                                aZw = prop7;
                                if (!TextUtils.isEmpty(prop7)) {
                                    aZv = "NUBIA";
                                } else {
                                    aZw = Build.DISPLAY;
                                    if (aZw.toUpperCase().contains(RomTypeUtil.ROM_FLYME)) {
                                        aZv = RomTypeUtil.ROM_FLYME;
                                    } else {
                                        aZw = "unknown";
                                        aZv = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return aZv.equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [236=4] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getProp(String str) {
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
