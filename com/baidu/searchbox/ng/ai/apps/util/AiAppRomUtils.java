package com.baidu.searchbox.ng.ai.apps.util;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public class AiAppRomUtils {
    private static final boolean DEBUG = false;
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_GIONEE = "ro.gn.sv.version";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_NUBIA = "ro.build.rom.id";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String PROP_RO_BUILD_DISPLAY_ID = "ro.build.display.id";
    public static final String PROP_RO_BUILD_FINGERPRINT = "ro.build.fingerprint";
    public static final String PROP_RO_BUILD_VERSION_INCREMENTAL = "ro.build.version.incremental";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_NUBIA = "NUBIA";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_UNKNOWN = "ROM_UNKNOWN";
    public static final String ROM_VIVO = "VIVO";
    private static final String TAG = "AiAppRomUtils";
    public static final String UNKNOWN = "UNKNOWN";
    private static final int VIVO_NOTCH = 32;
    private static String sRomName;
    private static String sRomVersion;

    public static boolean hasNotch(Context context) {
        if (context == null) {
            return false;
        }
        if (isEmui()) {
            return hasNotchAtHuawei(context);
        }
        if (isVivo()) {
            return hasNotchAtVivo(context);
        }
        if (isOppo()) {
            return hasNotchAtOPPO(context);
        }
        return false;
    }

    private static boolean hasNotchAtHuawei(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean hasNotchAtVivo(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean hasNotchAtOPPO(@NonNull Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean isEmui() {
        return check("EMUI");
    }

    public static boolean isMiui() {
        return check("MIUI");
    }

    public static boolean isVivo() {
        return check("VIVO");
    }

    public static boolean isOppo() {
        return check("OPPO");
    }

    public static boolean isFlyme() {
        return check("FLYME");
    }

    public static boolean is360() {
        return check("QIKU") || check("360");
    }

    public static boolean isSmartisan() {
        return check("SMARTISAN");
    }

    public static boolean isNubia() {
        return check(ROM_NUBIA);
    }

    public static String getName() {
        if (sRomName == null) {
            check("");
        }
        return sRomName;
    }

    public static String getVersion() {
        if (sRomVersion == null) {
            check("");
        }
        return sRomVersion;
    }

    public static String getIncrementalVersion() {
        return getProp(PROP_RO_BUILD_VERSION_INCREMENTAL);
    }

    public static boolean check(String str) {
        if (sRomName != null) {
            return sRomName.equals(str);
        }
        String prop = getProp(KEY_VERSION_MIUI);
        sRomVersion = prop;
        if (!TextUtils.isEmpty(prop)) {
            sRomName = "MIUI";
        } else {
            String prop2 = getProp(KEY_VERSION_EMUI);
            sRomVersion = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                sRomName = "EMUI";
            } else {
                String prop3 = getProp(KEY_VERSION_OPPO);
                sRomVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sRomName = "OPPO";
                } else {
                    String prop4 = getProp(KEY_VERSION_VIVO);
                    sRomVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sRomName = "VIVO";
                    } else {
                        String prop5 = getProp(KEY_VERSION_SMARTISAN);
                        sRomVersion = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            sRomName = "SMARTISAN";
                        } else {
                            String prop6 = getProp(KEY_VERSION_GIONEE);
                            sRomVersion = prop6;
                            if (!TextUtils.isEmpty(prop6)) {
                                sRomName = "SMARTISAN";
                            } else {
                                String prop7 = getProp(KEY_VERSION_NUBIA);
                                sRomVersion = prop7;
                                if (!TextUtils.isEmpty(prop7)) {
                                    sRomName = ROM_NUBIA;
                                } else {
                                    sRomVersion = Build.DISPLAY;
                                    if (sRomVersion.toUpperCase().contains("FLYME")) {
                                        sRomName = "FLYME";
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
                    Log.e(TAG, "Unable to read prop " + str, e);
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
