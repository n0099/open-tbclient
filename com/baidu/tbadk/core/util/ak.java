package com.baidu.tbadk.core.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ak {
    private static String dzJ;
    private static String dzK;

    public static boolean isEmui() {
        return aOM();
    }

    public static boolean aOM() {
        return check(RomUtils.ROM_EMUI) && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean check(String str) {
        if (dzJ != null) {
            return dzJ.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        dzK = prop;
        if (!TextUtils.isEmpty(prop)) {
            dzJ = RomUtils.ROM_MIUI;
        } else {
            String prop2 = getProp("ro.build.version.emui");
            dzK = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                dzJ = RomUtils.ROM_EMUI;
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                dzK = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    dzJ = RomUtils.ROM_OPPO;
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    dzK = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        dzJ = RomUtils.ROM_VIVO;
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        dzK = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            dzJ = RomUtils.ROM_SMARTISAN;
                        } else {
                            dzK = Build.DISPLAY;
                            if (dzK.toUpperCase().contains(RomUtils.ROM_FLYME)) {
                                dzJ = RomUtils.ROM_FLYME;
                            } else {
                                dzK = "unknown";
                                dzJ = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return dzJ.equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [91=4] */
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
