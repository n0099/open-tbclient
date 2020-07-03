package com.baidu.tbadk.core.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class al {
    private static String dUH;
    private static String dUI;

    public static boolean isEmui() {
        return aWI();
    }

    public static boolean aWI() {
        return check(RomUtils.ROM_EMUI) && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean aWJ() {
        return check("ONEPLUS");
    }

    public static boolean check(String str) {
        if (dUH != null) {
            return dUH.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        dUI = prop;
        if (!TextUtils.isEmpty(prop)) {
            dUH = RomUtils.ROM_MIUI;
        } else {
            String prop2 = getProp("ro.build.version.emui");
            dUI = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                dUH = RomUtils.ROM_EMUI;
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                dUI = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    dUH = RomUtils.ROM_OPPO;
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    dUI = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        dUH = RomUtils.ROM_VIVO;
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        dUI = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            dUH = RomUtils.ROM_SMARTISAN;
                        } else {
                            dUI = Build.DISPLAY;
                            if (dUI.toUpperCase().contains(RomUtils.ROM_FLYME)) {
                                dUH = RomUtils.ROM_FLYME;
                            } else {
                                dUI = "unknown";
                                dUH = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return dUH.equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [96=4] */
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
