package com.baidu.apollon.permission;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3789a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3790b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3791c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static final b f3792d;

    /* renamed from: com.baidu.apollon.permission.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0062a extends b {
        public C0062a() {
            super();
        }

        @Override // com.baidu.apollon.permission.a.b
        public String a(String str) {
            return com.baidu.apollon.permission.b.a(str);
        }

        @Override // com.baidu.apollon.permission.a.b
        public int a(Context context, String str, int i2, String str2) {
            return com.baidu.apollon.permission.b.a(context, str, i2, str2);
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

        public int a(Context context, String str, int i2, String str2) {
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
            f3792d = new C0062a();
        } else {
            f3792d = new b();
        }
    }

    public static String a(@NonNull String str) {
        return f3792d.a(str);
    }

    public static int a(@NonNull Context context, @NonNull String str, int i2, @NonNull String str2) {
        return f3792d.a(context, str, i2, str2);
    }

    public static int a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return f3792d.a(context, str, str2);
    }
}
