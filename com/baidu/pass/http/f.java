package com.baidu.pass.http;

import android.util.Log;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2846a = "f";
    private static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    public static boolean c = false;

    public static void a(String str, String str2) {
        if (c) {
            Log.e(str, str2);
        }
    }

    public static boolean b(String str) {
        return b.matcher(str).matches();
    }

    public static void a(String str) {
        a(f2846a, str);
    }
}
