package com.baidu.pass.http;

import android.util.Log;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9676a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f9677b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: c  reason: collision with root package name */
    public static boolean f9678c = false;

    public static void a(String str, String str2) {
        if (f9678c) {
            Log.e(str, str2);
        }
    }

    public static boolean b(String str) {
        return f9677b.matcher(str).matches();
    }

    public static void a(String str) {
        a(f9676a, str);
    }
}
