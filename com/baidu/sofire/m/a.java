package com.baidu.sofire.m;
/* loaded from: classes3.dex */
public final class a {
    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
