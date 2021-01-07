package com.baidu.tbadk.core.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class am {
    private static String fdf;
    private static String fdg;

    public static boolean isEmui() {
        return bwh();
    }

    public static boolean bwh() {
        return check(RomUtils.ROM_EMUI) && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean bwi() {
        return check("ONEPLUS");
    }

    public static boolean bwj() {
        return check(RomUtils.ROM_OPPO);
    }

    public static boolean check(String str) {
        if (fdf != null) {
            return fdf.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        fdg = prop;
        if (!TextUtils.isEmpty(prop)) {
            fdf = RomUtils.ROM_MIUI;
        } else {
            String prop2 = getProp("ro.build.version.emui");
            fdg = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                fdf = RomUtils.ROM_EMUI;
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                fdg = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    fdf = RomUtils.ROM_OPPO;
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    fdg = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        fdf = RomUtils.ROM_VIVO;
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        fdg = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            fdf = RomUtils.ROM_SMARTISAN;
                        } else {
                            fdg = Build.DISPLAY;
                            if (fdg.toUpperCase().contains(RomUtils.ROM_FLYME)) {
                                fdf = RomUtils.ROM_FLYME;
                            } else {
                                fdg = "unknown";
                                fdf = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return fdf.equals(str);
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
