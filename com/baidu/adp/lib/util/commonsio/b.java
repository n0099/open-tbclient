package com.baidu.adp.lib.util.commonsio;

import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static final String a = Character.toString('.');
    private static final char b = File.separatorChar;
    private static final char c;

    static {
        if (a()) {
            c = '/';
        } else {
            c = '\\';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return b == '\\';
    }
}
