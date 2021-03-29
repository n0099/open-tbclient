package com.baidu.apollon.permission;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3702a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3703b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3704c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static final b f3705d;

    /* renamed from: com.baidu.apollon.permission.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0063a extends b {
        public C0063a() {
            super();
        }

        @Override // com.baidu.apollon.permission.a.b
        public String a(String str) {
            return com.baidu.apollon.permission.b.a(str);
        }

        @Override // com.baidu.apollon.permission.a.b
        public int a(Context context, String str, int i, String str2) {
            return com.baidu.apollon.permission.b.a(context, str, i, str2);
        }

        @Override // com.baidu.apollon.permission.a.b
        public int a(Context context, String str, String str2) {
            return com.baidu.apollon.permission.b.a(context, str, str2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public b() {
        }

        public int a(Context context, String str, int i, String str2) {
            return 1;
        }

        public int a(Context context, String str, String str2) {
            return 1;
        }

        public String a(String str) {
            return null;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f3705d = new C0063a();
        } else {
            f3705d = new b();
        }
    }

    public static String a(@NonNull String str) {
        return f3705d.a(str);
    }

    public static int a(@NonNull Context context, @NonNull String str, int i, @NonNull String str2) {
        return f3705d.a(context, str, i, str2);
    }

    public static int a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return f3705d.a(context, str, str2);
    }
}
