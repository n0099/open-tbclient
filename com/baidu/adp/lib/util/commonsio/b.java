package com.baidu.adp.lib.util.commonsio;

import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static final String nO = Character.toString('.');
    private static final char nP = File.separatorChar;
    private static final char nQ;

    static {
        if (fB()) {
            nQ = '/';
        } else {
            nQ = '\\';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean fB() {
        return nP == '\\';
    }

    public static int aG(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int aH(String str) {
        int lastIndexOf;
        if (str != null && aG(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static String aI(String str) {
        if (str == null) {
            return null;
        }
        int aH = aH(str);
        if (aH == -1) {
            return "";
        }
        return str.substring(aH + 1);
    }
}
