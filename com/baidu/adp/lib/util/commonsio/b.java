package com.baidu.adp.lib.util.commonsio;

import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static final String nQ = Character.toString('.');
    private static final char nR = File.separatorChar;
    private static final char nS;

    static {
        if (fD()) {
            nS = '/';
        } else {
            nS = '\\';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean fD() {
        return nR == '\\';
    }

    public static int aI(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int aJ(String str) {
        int lastIndexOf;
        if (str != null && aI(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static String aK(String str) {
        if (str == null) {
            return null;
        }
        int aJ = aJ(str);
        if (aJ == -1) {
            return "";
        }
        return str.substring(aJ + 1);
    }
}
