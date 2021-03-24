package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f7904a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNIFavorite f7905b;

    /* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0102a {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f7906a = false;

        public static void b() {
            f7906a = true;
        }
    }

    public a() {
        this.f7905b = null;
        this.f7905b = new JNIFavorite();
    }

    public int a(Bundle bundle) {
        try {
            return this.f7905b.GetAll(this.f7904a, bundle);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public long a() {
        long Create = this.f7905b.Create();
        this.f7904a = Create;
        return Create;
    }

    public boolean a(int i) {
        return this.f7905b.SetType(this.f7904a, i);
    }

    public boolean a(String str) {
        return this.f7905b.Remove(this.f7904a, str);
    }

    public boolean a(String str, String str2) {
        C0102a.b();
        return this.f7905b.Add(this.f7904a, str, str2);
    }

    public boolean a(String str, String str2, String str3, int i, int i2, int i3) {
        return this.f7905b.Load(this.f7904a, str, str2, str3, i, i2, i3);
    }

    public int b() {
        return this.f7905b.Release(this.f7904a);
    }

    public String b(String str) {
        try {
            return this.f7905b.GetValue(this.f7904a, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(String str, String str2) {
        C0102a.b();
        return this.f7905b.Update(this.f7904a, str, str2);
    }

    public boolean c() {
        return this.f7905b.Clear(this.f7904a);
    }

    public boolean c(String str) {
        try {
            return this.f7905b.IsExist(this.f7904a, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean d() {
        return this.f7905b.SaveCache(this.f7904a);
    }
}
