package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f7982a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNIFavorite f7983b;

    /* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0104a {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f7984a = false;

        public static void b() {
            f7984a = true;
        }
    }

    public a() {
        this.f7983b = null;
        this.f7983b = new JNIFavorite();
    }

    public int a(Bundle bundle) {
        try {
            return this.f7983b.GetAll(this.f7982a, bundle);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public long a() {
        long Create = this.f7983b.Create();
        this.f7982a = Create;
        return Create;
    }

    public boolean a(int i2) {
        return this.f7983b.SetType(this.f7982a, i2);
    }

    public boolean a(String str) {
        return this.f7983b.Remove(this.f7982a, str);
    }

    public boolean a(String str, String str2) {
        C0104a.b();
        return this.f7983b.Add(this.f7982a, str, str2);
    }

    public boolean a(String str, String str2, String str3, int i2, int i3, int i4) {
        return this.f7983b.Load(this.f7982a, str, str2, str3, i2, i3, i4);
    }

    public int b() {
        return this.f7983b.Release(this.f7982a);
    }

    public String b(String str) {
        try {
            return this.f7983b.GetValue(this.f7982a, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(String str, String str2) {
        C0104a.b();
        return this.f7983b.Update(this.f7982a, str, str2);
    }

    public boolean c() {
        return this.f7983b.Clear(this.f7982a);
    }

    public boolean c(String str) {
        try {
            return this.f7983b.IsExist(this.f7982a, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean d() {
        return this.f7983b.SaveCache(this.f7982a);
    }
}
