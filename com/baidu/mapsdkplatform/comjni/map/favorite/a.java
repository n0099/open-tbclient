package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f8039a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNIFavorite f8040b;

    /* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0102a {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f8041a = false;

        public static void b() {
            f8041a = true;
        }
    }

    public a() {
        this.f8040b = null;
        this.f8040b = new JNIFavorite();
    }

    public int a(Bundle bundle) {
        try {
            return this.f8040b.GetAll(this.f8039a, bundle);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public long a() {
        long Create = this.f8040b.Create();
        this.f8039a = Create;
        return Create;
    }

    public boolean a(int i2) {
        return this.f8040b.SetType(this.f8039a, i2);
    }

    public boolean a(String str) {
        return this.f8040b.Remove(this.f8039a, str);
    }

    public boolean a(String str, String str2) {
        C0102a.b();
        return this.f8040b.Add(this.f8039a, str, str2);
    }

    public boolean a(String str, String str2, String str3, int i2, int i3, int i4) {
        return this.f8040b.Load(this.f8039a, str, str2, str3, i2, i3, i4);
    }

    public int b() {
        return this.f8040b.Release(this.f8039a);
    }

    public String b(String str) {
        try {
            return this.f8040b.GetValue(this.f8039a, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(String str, String str2) {
        C0102a.b();
        return this.f8040b.Update(this.f8039a, str, str2);
    }

    public boolean c() {
        return this.f8040b.Clear(this.f8039a);
    }

    public boolean c(String str) {
        try {
            return this.f8040b.IsExist(this.f8039a, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean d() {
        return this.f8040b.SaveCache(this.f8039a);
    }
}
