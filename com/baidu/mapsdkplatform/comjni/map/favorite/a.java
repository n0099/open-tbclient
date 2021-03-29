package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f7905a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNIFavorite f7906b;

    /* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0103a {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f7907a = false;

        public static void b() {
            f7907a = true;
        }
    }

    public a() {
        this.f7906b = null;
        this.f7906b = new JNIFavorite();
    }

    public int a(Bundle bundle) {
        try {
            return this.f7906b.GetAll(this.f7905a, bundle);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public long a() {
        long Create = this.f7906b.Create();
        this.f7905a = Create;
        return Create;
    }

    public boolean a(int i) {
        return this.f7906b.SetType(this.f7905a, i);
    }

    public boolean a(String str) {
        return this.f7906b.Remove(this.f7905a, str);
    }

    public boolean a(String str, String str2) {
        C0103a.b();
        return this.f7906b.Add(this.f7905a, str, str2);
    }

    public boolean a(String str, String str2, String str3, int i, int i2, int i3) {
        return this.f7906b.Load(this.f7905a, str, str2, str3, i, i2, i3);
    }

    public int b() {
        return this.f7906b.Release(this.f7905a);
    }

    public String b(String str) {
        try {
            return this.f7906b.GetValue(this.f7905a, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(String str, String str2) {
        C0103a.b();
        return this.f7906b.Update(this.f7905a, str, str2);
    }

    public boolean c() {
        return this.f7906b.Clear(this.f7905a);
    }

    public boolean c(String str) {
        try {
            return this.f7906b.IsExist(this.f7905a, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean d() {
        return this.f7906b.SaveCache(this.f7905a);
    }
}
