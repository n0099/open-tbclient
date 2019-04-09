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
public class s {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String aWr;
    private static String aWs;

    public static boolean ck(Context context) {
        if (context == null) {
            return false;
        }
        if (isEmui()) {
            return cl(context);
        }
        if (Ma()) {
            return cm(context);
        }
        if (Mb()) {
            return cn(context);
        }
        return false;
    }

    private static boolean cl(@NonNull Context context) {
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

    private static boolean cm(@NonNull Context context) {
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

    private static boolean cn(@NonNull Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean isEmui() {
        return check(RomTypeUtil.ROM_EMUI);
    }

    public static boolean Ma() {
        return check(RomTypeUtil.ROM_VIVO);
    }

    public static boolean Mb() {
        return check(RomTypeUtil.ROM_OPPO);
    }

    public static boolean check(String str) {
        if (aWr != null) {
            return aWr.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        aWs = prop;
        if (!TextUtils.isEmpty(prop)) {
            aWr = RomTypeUtil.ROM_MIUI;
        } else {
            String prop2 = getProp("ro.build.version.emui");
            aWs = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                aWr = RomTypeUtil.ROM_EMUI;
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                aWs = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    aWr = RomTypeUtil.ROM_OPPO;
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    aWs = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        aWr = RomTypeUtil.ROM_VIVO;
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        aWs = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            aWr = RomTypeUtil.ROM_SMARTISAN;
                        } else {
                            String prop6 = getProp("ro.gn.sv.version");
                            aWs = prop6;
                            if (!TextUtils.isEmpty(prop6)) {
                                aWr = RomTypeUtil.ROM_SMARTISAN;
                            } else {
                                String prop7 = getProp("ro.build.rom.id");
                                aWs = prop7;
                                if (!TextUtils.isEmpty(prop7)) {
                                    aWr = "NUBIA";
                                } else {
                                    aWs = Build.DISPLAY;
                                    if (aWs.toUpperCase().contains(RomTypeUtil.ROM_FLYME)) {
                                        aWr = RomTypeUtil.ROM_FLYME;
                                    } else {
                                        aWs = "unknown";
                                        aWr = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return aWr.equals(str);
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
