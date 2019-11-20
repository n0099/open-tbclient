package com.baidu.tbadk.core.util;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ak {
    private static String cjk;
    private static String cjl;

    public static boolean Uo() {
        return amD();
    }

    public static boolean amD() {
        return check("EMUI") && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean check(String str) {
        if (cjk != null) {
            return cjk.equals(str);
        }
        String hk = hk("ro.miui.ui.version.name");
        cjl = hk;
        if (!TextUtils.isEmpty(hk)) {
            cjk = "MIUI";
        } else {
            String hk2 = hk("ro.build.version.emui");
            cjl = hk2;
            if (!TextUtils.isEmpty(hk2)) {
                cjk = "EMUI";
            } else {
                String hk3 = hk("ro.build.version.opporom");
                cjl = hk3;
                if (!TextUtils.isEmpty(hk3)) {
                    cjk = "OPPO";
                } else {
                    String hk4 = hk("ro.vivo.os.version");
                    cjl = hk4;
                    if (!TextUtils.isEmpty(hk4)) {
                        cjk = "VIVO";
                    } else {
                        String hk5 = hk("ro.smartisan.version");
                        cjl = hk5;
                        if (!TextUtils.isEmpty(hk5)) {
                            cjk = "SMARTISAN";
                        } else {
                            cjl = Build.DISPLAY;
                            if (cjl.toUpperCase().contains("FLYME")) {
                                cjk = "FLYME";
                            } else {
                                cjl = "unknown";
                                cjk = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return cjk.equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [91=4] */
    public static String hk(String str) {
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
