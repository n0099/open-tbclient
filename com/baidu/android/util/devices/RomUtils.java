package com.baidu.android.util.devices;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class RomUtils {
    public static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    public static final String KEY_VERSION_GIONEE = "ro.gn.sv.version";
    public static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    public static final String KEY_VERSION_NUBIA = "ro.build.rom.id";
    public static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    public static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    public static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String MANUFACTURER_GIONEE = "gionee";
    public static final String MANUFACTURER_HUAWEI = "huawei";
    public static final String MANUFACTURER_MEIZU = "meizu";
    public static final String MANUFACTURER_NUBIA = "nubia";
    public static final String MANUFACTURER_OPPO = "oppo";
    public static final String MANUFACTURER_SMARTISAN = "smartisan";
    public static final String MANUFACTURER_VIVO = "vivo";
    public static final String MANUFACTURER_XIAOMI = "xiaomi";
    public static final String PROP_RO_BUILD_DISPLAY_ID = "ro.build.display.id";
    public static final String PROP_RO_BUILD_FINGERPRINT = "ro.build.fingerprint";
    public static final String PROP_RO_BUILD_VERSION_INCREMENTAL = "ro.build.version.incremental";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_GIONEE = "GIONEE";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_NUBIA = "NUBIA";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_UNKNOWN = "ROM_UNKNOWN";
    public static final String ROM_VIVO = "VIVO";
    public static final String TAG = "Rom";
    public static final String UNKNOWN = "UNKNOWN";
    public static String sRomName;
    public static String sRomVersion;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String check() {
        char c2;
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        switch (lowerCase.hashCode()) {
            case -1443430368:
                if (lowerCase.equals(MANUFACTURER_SMARTISAN)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1245779295:
                if (lowerCase.equals(MANUFACTURER_GIONEE)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1206476313:
                if (lowerCase.equals(MANUFACTURER_HUAWEI)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -759499589:
                if (lowerCase.equals(MANUFACTURER_XIAOMI)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3418016:
                if (lowerCase.equals(MANUFACTURER_OPPO)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3620012:
                if (lowerCase.equals(MANUFACTURER_VIVO)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 103777484:
                if (lowerCase.equals(MANUFACTURER_MEIZU)) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 105170387:
                if (lowerCase.equals("nubia")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                String prop = getProp("ro.build.version.emui");
                sRomVersion = prop;
                if (!TextUtils.isEmpty(prop)) {
                    sRomName = "EMUI";
                    return "EMUI";
                }
                return getOtherRomName();
            case 1:
                String prop2 = getProp("ro.miui.ui.version.name");
                sRomVersion = prop2;
                if (!TextUtils.isEmpty(prop2)) {
                    sRomName = "MIUI";
                    return "MIUI";
                }
                return getOtherRomName();
            case 2:
                String prop3 = getProp("ro.build.version.opporom");
                sRomVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sRomName = "OPPO";
                    return "OPPO";
                }
                return getOtherRomName();
            case 3:
                String prop4 = getProp("ro.vivo.os.version");
                sRomVersion = prop4;
                if (!TextUtils.isEmpty(prop4)) {
                    sRomName = "VIVO";
                    return "VIVO";
                }
                return getOtherRomName();
            case 4:
                String prop5 = getProp("ro.smartisan.version");
                sRomVersion = prop5;
                if (!TextUtils.isEmpty(prop5)) {
                    sRomName = "SMARTISAN";
                    return "SMARTISAN";
                }
                return getOtherRomName();
            case 5:
                String prop6 = getProp(KEY_VERSION_GIONEE);
                sRomVersion = prop6;
                if (!TextUtils.isEmpty(prop6)) {
                    sRomName = ROM_GIONEE;
                    return ROM_GIONEE;
                }
                return getOtherRomName();
            case 6:
                String prop7 = getProp(KEY_VERSION_NUBIA);
                sRomVersion = prop7;
                if (!TextUtils.isEmpty(prop7)) {
                    sRomName = ROM_NUBIA;
                    return ROM_NUBIA;
                }
                return getOtherRomName();
            case 7:
                if (Build.DISPLAY.toUpperCase().contains("FLYME")) {
                    sRomName = "FLYME";
                    return "FLYME";
                }
                return getOtherRomName();
            default:
                return getOtherRomName();
        }
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceName() {
        return Build.PRODUCT;
    }

    public static String getIncrementalVersion() {
        return getProp(PROP_RO_BUILD_VERSION_INCREMENTAL);
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getName() {
        String str = sRomName;
        return str == null ? check() : str;
    }

    public static String getOtherRomName() {
        String str = Build.DISPLAY;
        sRomVersion = str;
        if (str.toUpperCase().contains("FLYME")) {
            sRomName = "FLYME";
        } else {
            sRomVersion = "unknown";
            sRomName = Build.MANUFACTURER.toUpperCase();
        }
        return sRomName;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return readLine;
                } catch (IOException e3) {
                    e = e3;
                    Log.e("Rom", "Unable to read prop " + str, e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
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
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    public static String getVersion() {
        if (sRomVersion == null) {
            check();
        }
        return sRomVersion;
    }

    public static boolean is360() {
        return check("QIKU") || check("360");
    }

    public static boolean isEmui() {
        return check("EMUI");
    }

    public static boolean isFlyme() {
        return check("FLYME");
    }

    public static boolean isFlymeQuickly() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toUpperCase().contains("FLYME");
    }

    public static boolean isMagicBoxDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("MagicBox") && Build.PRODUCT.equalsIgnoreCase("MagicBox");
    }

    public static boolean isMiBox2Device() {
        return Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && Build.PRODUCT.equalsIgnoreCase("dredd");
    }

    public static boolean isMiui() {
        return check("MIUI");
    }

    public static boolean isNubia() {
        return check(ROM_NUBIA);
    }

    public static boolean isOppo() {
        return check("OPPO");
    }

    public static boolean isSmartisan() {
        return check("SMARTISAN");
    }

    public static boolean isVivo() {
        return check("VIVO");
    }

    public static boolean check(String str) {
        String str2 = sRomName;
        if (str2 != null) {
            return str2.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        sRomVersion = prop;
        if (!TextUtils.isEmpty(prop)) {
            sRomName = "MIUI";
        } else {
            String prop2 = getProp("ro.build.version.emui");
            sRomVersion = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                sRomName = "EMUI";
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                sRomVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sRomName = "OPPO";
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    sRomVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sRomName = "VIVO";
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        sRomVersion = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            sRomName = "SMARTISAN";
                        } else {
                            String prop6 = getProp(KEY_VERSION_GIONEE);
                            sRomVersion = prop6;
                            if (!TextUtils.isEmpty(prop6)) {
                                sRomName = ROM_GIONEE;
                            } else {
                                String prop7 = getProp(KEY_VERSION_NUBIA);
                                sRomVersion = prop7;
                                if (!TextUtils.isEmpty(prop7)) {
                                    sRomName = ROM_NUBIA;
                                } else {
                                    String str3 = Build.DISPLAY;
                                    sRomVersion = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
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
}
