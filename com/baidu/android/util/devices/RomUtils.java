package com.baidu.android.util.devices;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes18.dex */
public class RomUtils {
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_GIONEE = "ro.gn.sv.version";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_NUBIA = "ro.build.rom.id";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
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
    private static final String TAG = "Rom";
    public static final String UNKNOWN = "UNKNOWN";
    private static String sRomName;
    private static String sRomVersion;

    public static boolean isEmui() {
        return check(ROM_EMUI);
    }

    public static boolean isMiui() {
        return check(ROM_MIUI);
    }

    public static boolean isVivo() {
        return check(ROM_VIVO);
    }

    public static boolean isOppo() {
        return check(ROM_OPPO);
    }

    public static boolean isFlyme() {
        return check(ROM_FLYME);
    }

    public static boolean is360() {
        return check(ROM_QIKU) || check("360");
    }

    public static boolean isSmartisan() {
        return check(ROM_SMARTISAN);
    }

    public static boolean isNubia() {
        return check(ROM_NUBIA);
    }

    public static String getName() {
        return sRomName == null ? check() : sRomName;
    }

    public static String getVersion() {
        if (sRomVersion == null) {
            check();
        }
        return sRomVersion;
    }

    public static String getIncrementalVersion() {
        return getProp(PROP_RO_BUILD_VERSION_INCREMENTAL);
    }

    public static String check() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -1443430368:
                if (lowerCase.equals(MANUFACTURER_SMARTISAN)) {
                    c = 4;
                    break;
                }
                break;
            case -1245779295:
                if (lowerCase.equals(MANUFACTURER_GIONEE)) {
                    c = 5;
                    break;
                }
                break;
            case -1206476313:
                if (lowerCase.equals(MANUFACTURER_HUAWEI)) {
                    c = 0;
                    break;
                }
                break;
            case -759499589:
                if (lowerCase.equals(MANUFACTURER_XIAOMI)) {
                    c = 1;
                    break;
                }
                break;
            case 3418016:
                if (lowerCase.equals(MANUFACTURER_OPPO)) {
                    c = 2;
                    break;
                }
                break;
            case 3620012:
                if (lowerCase.equals(MANUFACTURER_VIVO)) {
                    c = 3;
                    break;
                }
                break;
            case 103777484:
                if (lowerCase.equals(MANUFACTURER_MEIZU)) {
                    c = 7;
                    break;
                }
                break;
            case 105170387:
                if (lowerCase.equals(MANUFACTURER_NUBIA)) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                String prop = getProp(KEY_VERSION_EMUI);
                sRomVersion = prop;
                if (!TextUtils.isEmpty(prop)) {
                    sRomName = ROM_EMUI;
                    return ROM_EMUI;
                }
                return getOtherRomName();
            case 1:
                String prop2 = getProp(KEY_VERSION_MIUI);
                sRomVersion = prop2;
                if (!TextUtils.isEmpty(prop2)) {
                    sRomName = ROM_MIUI;
                    return ROM_MIUI;
                }
                return getOtherRomName();
            case 2:
                String prop3 = getProp(KEY_VERSION_OPPO);
                sRomVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sRomName = ROM_OPPO;
                    return ROM_OPPO;
                }
                return getOtherRomName();
            case 3:
                String prop4 = getProp(KEY_VERSION_VIVO);
                sRomVersion = prop4;
                if (!TextUtils.isEmpty(prop4)) {
                    sRomName = ROM_VIVO;
                    return ROM_VIVO;
                }
                return getOtherRomName();
            case 4:
                String prop5 = getProp(KEY_VERSION_SMARTISAN);
                sRomVersion = prop5;
                if (!TextUtils.isEmpty(prop5)) {
                    sRomName = ROM_SMARTISAN;
                    return ROM_SMARTISAN;
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
                if (Build.DISPLAY.toUpperCase().contains(ROM_FLYME)) {
                    sRomName = ROM_FLYME;
                    return ROM_FLYME;
                }
                return getOtherRomName();
            default:
                return getOtherRomName();
        }
    }

    public static boolean check(String str) {
        if (sRomName != null) {
            return sRomName.equals(str);
        }
        String prop = getProp(KEY_VERSION_MIUI);
        sRomVersion = prop;
        if (!TextUtils.isEmpty(prop)) {
            sRomName = ROM_MIUI;
        } else {
            String prop2 = getProp(KEY_VERSION_EMUI);
            sRomVersion = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                sRomName = ROM_EMUI;
            } else {
                String prop3 = getProp(KEY_VERSION_OPPO);
                sRomVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sRomName = ROM_OPPO;
                } else {
                    String prop4 = getProp(KEY_VERSION_VIVO);
                    sRomVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sRomName = ROM_VIVO;
                    } else {
                        String prop5 = getProp(KEY_VERSION_SMARTISAN);
                        sRomVersion = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            sRomName = ROM_SMARTISAN;
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
                                    sRomVersion = Build.DISPLAY;
                                    if (sRomVersion.toUpperCase().contains(ROM_FLYME)) {
                                        sRomName = ROM_FLYME;
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

    public static String getOtherRomName() {
        sRomVersion = Build.DISPLAY;
        if (sRomVersion.toUpperCase().contains(ROM_FLYME)) {
            sRomName = ROM_FLYME;
        } else {
            sRomVersion = "unknown";
            sRomName = Build.MANUFACTURER.toUpperCase();
        }
        return sRomName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [233=4] */
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

    public static boolean isFlymeQuickly() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toUpperCase().contains(ROM_FLYME);
    }
}
