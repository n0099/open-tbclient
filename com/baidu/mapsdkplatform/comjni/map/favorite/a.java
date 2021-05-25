package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f7939a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNIFavorite f7940b;

    /* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0103a {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f7941a = false;

        public static void b() {
            f7941a = true;
        }
    }

    public a() {
        this.f7940b = null;
        this.f7940b = new JNIFavorite();
    }

    public int a(Bundle bundle) {
        try {
            return this.f7940b.GetAll(this.f7939a, bundle);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public long a() {
        long Create = this.f7940b.Create();
        this.f7939a = Create;
        return Create;
    }

    public boolean a(int i2) {
        return this.f7940b.SetType(this.f7939a, i2);
    }

    public boolean a(String str) {
        return this.f7940b.Remove(this.f7939a, str);
    }

    public boolean a(String str, String str2) {
        C0103a.b();
        return this.f7940b.Add(this.f7939a, str, str2);
    }

    public boolean a(String str, String str2, String str3, int i2, int i3, int i4) {
        return this.f7940b.Load(this.f7939a, str, str2, str3, i2, i3, i4);
    }

    public int b() {
        return this.f7940b.Release(this.f7939a);
    }

    public String b(String str) {
        try {
            return this.f7940b.GetValue(this.f7939a, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(String str, String str2) {
        C0103a.b();
        return this.f7940b.Update(this.f7939a, str, str2);
    }

    public boolean c() {
        return this.f7940b.Clear(this.f7939a);
    }

    public boolean c(String str) {
        try {
            return this.f7940b.IsExist(this.f7939a, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean d() {
        return this.f7940b.SaveCache(this.f7939a);
    }
}
