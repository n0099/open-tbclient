package com.baidu.adp.lib.util.commonsio;

import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static final String zg = Character.toString('.');
    private static final char zh = File.separatorChar;
    private static final char zi;

    static {
        if (jw()) {
            zi = '/';
        } else {
            zi = '\\';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean jw() {
        return zh == '\\';
    }

    public static int ba(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int bb(String str) {
        int lastIndexOf;
        if (str != null && ba(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static String bc(String str) {
        if (str == null) {
            return null;
        }
        int bb = bb(str);
        if (bb == -1) {
            return "";
        }
        return str.substring(bb + 1);
    }
}
