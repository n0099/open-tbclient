package com.baidu.tbadk.core.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class an {
    private static String ekN;
    private static String ekO;

    public static boolean isEmui() {
        return bjh();
    }

    public static boolean bjh() {
        return check(RomUtils.ROM_EMUI) && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean bji() {
        return check("ONEPLUS");
    }

    public static boolean bjj() {
        return check(RomUtils.ROM_OPPO);
    }

    public static boolean check(String str) {
        if (ekN != null) {
            return ekN.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        ekO = prop;
        if (!TextUtils.isEmpty(prop)) {
            ekN = RomUtils.ROM_MIUI;
        } else {
            String prop2 = getProp("ro.build.version.emui");
            ekO = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                ekN = RomUtils.ROM_EMUI;
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                ekO = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    ekN = RomUtils.ROM_OPPO;
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    ekO = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        ekN = RomUtils.ROM_VIVO;
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        ekO = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            ekN = RomUtils.ROM_SMARTISAN;
                        } else {
                            ekO = Build.DISPLAY;
                            if (ekO.toUpperCase().contains(RomUtils.ROM_FLYME)) {
                                ekN = RomUtils.ROM_FLYME;
                            } else {
                                ekO = "unknown";
                                ekN = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return ekN.equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [101=4] */
    public static String getProp(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader3.readLine();
                bufferedReader3.close();
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        return readLine;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return readLine;
                    }
                }
                return readLine;
            } catch (IOException e2) {
                bufferedReader = bufferedReader3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader3;
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
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
