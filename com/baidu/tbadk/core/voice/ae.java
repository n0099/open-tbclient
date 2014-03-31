package com.baidu.tbadk.core.voice;

import android.app.Application;
import android.os.Build;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class ae {
    private static final String[] a = new String[0];
    private static final String[] b = {"meizu"};

    public static String a(int i) {
        Application b2 = TbadkApplication.j().b();
        return b2 == null ? "" : b2.getString(i);
    }

    public static boolean a() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (int i = 0; i < b.length; i++) {
            if (b[i].equals(lowerCase)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        String str = Build.MODEL;
        if (str == null) {
            return true;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(str)) {
                return false;
            }
        }
        return true;
    }
}
