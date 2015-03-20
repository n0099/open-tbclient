package com.baidu.adp.lib.util.commonsio;

import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static final String zr = Character.toString('.');
    private static final char zs = File.separatorChar;
    private static final char zt;

    static {
        if (jf()) {
            zt = '/';
        } else {
            zt = '\\';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean jf() {
        return zs == '\\';
    }

    public static int aQ(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int aR(String str) {
        int lastIndexOf;
        if (str != null && aQ(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static String aS(String str) {
        if (str == null) {
            return null;
        }
        int aR = aR(str);
        if (aR == -1) {
            return "";
        }
        return str.substring(aR + 1);
    }
}
