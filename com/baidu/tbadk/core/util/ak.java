package com.baidu.tbadk.core.util;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ak {
    private static String bTY;
    private static String bTZ;

    public static boolean PA() {
        return ajm();
    }

    public static boolean ajm() {
        return check("EMUI") && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean check(String str) {
        if (bTY != null) {
            return bTY.equals(str);
        }
        String gG = gG("ro.miui.ui.version.name");
        bTZ = gG;
        if (!TextUtils.isEmpty(gG)) {
            bTY = "MIUI";
        } else {
            String gG2 = gG("ro.build.version.emui");
            bTZ = gG2;
            if (!TextUtils.isEmpty(gG2)) {
                bTY = "EMUI";
            } else {
                String gG3 = gG("ro.build.version.opporom");
                bTZ = gG3;
                if (!TextUtils.isEmpty(gG3)) {
                    bTY = "OPPO";
                } else {
                    String gG4 = gG("ro.vivo.os.version");
                    bTZ = gG4;
                    if (!TextUtils.isEmpty(gG4)) {
                        bTY = "VIVO";
                    } else {
                        String gG5 = gG("ro.smartisan.version");
                        bTZ = gG5;
                        if (!TextUtils.isEmpty(gG5)) {
                            bTY = "SMARTISAN";
                        } else {
                            bTZ = Build.DISPLAY;
                            if (bTZ.toUpperCase().contains("FLYME")) {
                                bTY = "FLYME";
                            } else {
                                bTZ = "unknown";
                                bTY = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return bTY.equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [91=4] */
    public static String gG(String str) {
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
