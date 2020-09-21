package com.baidu.tbadk.core.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class an {
    private static String enc;
    private static String ene;

    public static boolean isEmui() {
        return bkc();
    }

    public static boolean bkc() {
        return check(RomUtils.ROM_EMUI) && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean bkd() {
        return check("ONEPLUS");
    }

    public static boolean bke() {
        return check(RomUtils.ROM_OPPO);
    }

    public static boolean check(String str) {
        if (enc != null) {
            return enc.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        ene = prop;
        if (!TextUtils.isEmpty(prop)) {
            enc = RomUtils.ROM_MIUI;
        } else {
            String prop2 = getProp("ro.build.version.emui");
            ene = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                enc = RomUtils.ROM_EMUI;
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                ene = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    enc = RomUtils.ROM_OPPO;
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    ene = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        enc = RomUtils.ROM_VIVO;
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        ene = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            enc = RomUtils.ROM_SMARTISAN;
                        } else {
                            ene = Build.DISPLAY;
                            if (ene.toUpperCase().contains(RomUtils.ROM_FLYME)) {
                                enc = RomUtils.ROM_FLYME;
                            } else {
                                ene = "unknown";
                                enc = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return enc.equals(str);
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
