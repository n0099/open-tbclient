package com.baidu.pass.http;

import android.util.Log;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class c {
    private static final String b = c.class.getSimpleName();
    private static final Pattern c = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    public static boolean a = false;

    public static void a(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }

    public static void a(String str) {
        a(b, str);
    }

    public static boolean b(String str) {
        return c.matcher(str).matches();
    }
}
