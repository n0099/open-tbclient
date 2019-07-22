package com.baidu.tbadk.core.util;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ak {
    private static String bTr;
    private static String sVersion;

    public static boolean Pw() {
        return ajg();
    }

    public static boolean ajg() {
        return check("EMUI") && Build.VERSION.SDK_INT >= 24;
    }

    public static boolean check(String str) {
        if (bTr != null) {
            return bTr.equals(str);
        }
        String gE = gE("ro.miui.ui.version.name");
        sVersion = gE;
        if (!TextUtils.isEmpty(gE)) {
            bTr = "MIUI";
        } else {
            String gE2 = gE("ro.build.version.emui");
            sVersion = gE2;
            if (!TextUtils.isEmpty(gE2)) {
                bTr = "EMUI";
            } else {
                String gE3 = gE("ro.build.version.opporom");
                sVersion = gE3;
                if (!TextUtils.isEmpty(gE3)) {
                    bTr = "OPPO";
                } else {
                    String gE4 = gE("ro.vivo.os.version");
                    sVersion = gE4;
                    if (!TextUtils.isEmpty(gE4)) {
                        bTr = "VIVO";
                    } else {
                        String gE5 = gE("ro.smartisan.version");
                        sVersion = gE5;
                        if (!TextUtils.isEmpty(gE5)) {
                            bTr = "SMARTISAN";
                        } else {
                            sVersion = Build.DISPLAY;
                            if (sVersion.toUpperCase().contains("FLYME")) {
                                bTr = "FLYME";
                            } else {
                                sVersion = "unknown";
                                bTr = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return bTr.equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [91=4] */
    public static String gE(String str) {
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
