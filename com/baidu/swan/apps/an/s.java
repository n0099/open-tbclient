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
    private static String aWq;
    private static String aWr;

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
        if (aWq != null) {
            return aWq.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        aWr = prop;
        if (!TextUtils.isEmpty(prop)) {
            aWq = RomTypeUtil.ROM_MIUI;
        } else {
            String prop2 = getProp("ro.build.version.emui");
            aWr = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                aWq = RomTypeUtil.ROM_EMUI;
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                aWr = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    aWq = RomTypeUtil.ROM_OPPO;
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    aWr = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        aWq = RomTypeUtil.ROM_VIVO;
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        aWr = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            aWq = RomTypeUtil.ROM_SMARTISAN;
                        } else {
                            String prop6 = getProp("ro.gn.sv.version");
                            aWr = prop6;
                            if (!TextUtils.isEmpty(prop6)) {
                                aWq = RomTypeUtil.ROM_SMARTISAN;
                            } else {
                                String prop7 = getProp("ro.build.rom.id");
                                aWr = prop7;
                                if (!TextUtils.isEmpty(prop7)) {
                                    aWq = "NUBIA";
                                } else {
                                    aWr = Build.DISPLAY;
                                    if (aWr.toUpperCase().contains(RomTypeUtil.ROM_FLYME)) {
                                        aWq = RomTypeUtil.ROM_FLYME;
                                    } else {
                                        aWr = "unknown";
                                        aWq = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return aWq.equals(str);
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
