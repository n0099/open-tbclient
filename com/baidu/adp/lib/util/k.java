package com.baidu.adp.lib.util;
/* loaded from: classes.dex */
public final class k {
    private static final String[] b = new String[48];
    public static final String a = System.getProperty("line.separator");

    public static boolean a(String str) {
        if (str != null && str.trim().length() != 0) {
            return false;
        }
        return true;
    }
}
