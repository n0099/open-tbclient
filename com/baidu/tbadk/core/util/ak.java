package com.baidu.tbadk.core.util;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ak {
    private static String ckb;
    private static String ckc;

    public static boolean Uq() {
        return amF();
    }

    public static boolean amF() {
        return check("EMUI") && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean check(String str) {
        if (ckb != null) {
            return ckb.equals(str);
        }
        String hk = hk("ro.miui.ui.version.name");
        ckc = hk;
        if (!TextUtils.isEmpty(hk)) {
            ckb = "MIUI";
        } else {
            String hk2 = hk("ro.build.version.emui");
            ckc = hk2;
            if (!TextUtils.isEmpty(hk2)) {
                ckb = "EMUI";
            } else {
                String hk3 = hk("ro.build.version.opporom");
                ckc = hk3;
                if (!TextUtils.isEmpty(hk3)) {
                    ckb = "OPPO";
                } else {
                    String hk4 = hk("ro.vivo.os.version");
                    ckc = hk4;
                    if (!TextUtils.isEmpty(hk4)) {
                        ckb = "VIVO";
                    } else {
                        String hk5 = hk("ro.smartisan.version");
                        ckc = hk5;
                        if (!TextUtils.isEmpty(hk5)) {
                            ckb = "SMARTISAN";
                        } else {
                            ckc = Build.DISPLAY;
                            if (ckc.toUpperCase().contains("FLYME")) {
                                ckb = "FLYME";
                            } else {
                                ckc = "unknown";
                                ckb = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return ckb.equals(str);
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
