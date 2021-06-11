package com.baidu.pass.http;

import android.util.Log;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9254a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f9255b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f9256c = false;

    public static void a(String str, String str2) {
        if (f9256c) {
            Log.e(str, str2);
        }
    }

    public static boolean b(String str) {
        return f9255b.matcher(str).matches();
    }

    public static void a(String str) {
        a(f9254a, str);
    }
}
