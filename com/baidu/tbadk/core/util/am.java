package com.baidu.tbadk.core.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class am {
    private static String eba;
    private static String ebb;

    public static boolean isEmui() {
        return baJ();
    }

    public static boolean baJ() {
        return check(RomUtils.ROM_EMUI) && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean baK() {
        return check("ONEPLUS");
    }

    public static boolean check(String str) {
        if (eba != null) {
            return eba.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        ebb = prop;
        if (!TextUtils.isEmpty(prop)) {
            eba = RomUtils.ROM_MIUI;
        } else {
            String prop2 = getProp("ro.build.version.emui");
            ebb = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                eba = RomUtils.ROM_EMUI;
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                ebb = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    eba = RomUtils.ROM_OPPO;
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    ebb = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        eba = RomUtils.ROM_VIVO;
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        ebb = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            eba = RomUtils.ROM_SMARTISAN;
                        } else {
                            ebb = Build.DISPLAY;
                            if (ebb.toUpperCase().contains(RomUtils.ROM_FLYME)) {
                                eba = RomUtils.ROM_FLYME;
                            } else {
                                ebb = "unknown";
                                eba = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return eba.equals(str);
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
