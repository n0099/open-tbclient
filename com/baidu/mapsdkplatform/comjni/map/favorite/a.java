package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f2293a = 0;
    private JNIFavorite b;

    /* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0261a {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f2294a = false;

        /* JADX INFO: Access modifiers changed from: private */
        public static void b() {
            f2294a = true;
        }
    }

    public a() {
        this.b = null;
        this.b = new JNIFavorite();
    }

    public int a(Bundle bundle) {
        try {
            return this.b.GetAll(this.f2293a, bundle);
        } catch (Throwable th) {
            return 0;
        }
    }

    public long a() {
        this.f2293a = this.b.Create();
        return this.f2293a;
    }

    public boolean a(int i) {
        return this.b.SetType(this.f2293a, i);
    }

    public boolean a(String str) {
        return this.b.Remove(this.f2293a, str);
    }

    public boolean a(String str, String str2) {
        C0261a.b();
        return this.b.Add(this.f2293a, str, str2);
    }

    public boolean a(String str, String str2, String str3, int i, int i2, int i3) {
        return this.b.Load(this.f2293a, str, str2, str3, i, i2, i3);
    }

    public int b() {
        return this.b.Release(this.f2293a);
    }

    public String b(String str) {
        try {
            return this.b.GetValue(this.f2293a, str);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean b(String str, String str2) {
        C0261a.b();
        return this.b.Update(this.f2293a, str, str2);
    }

    public boolean c() {
        return this.b.Clear(this.f2293a);
    }

    public boolean c(String str) {
        try {
            return this.b.IsExist(this.f2293a, str);
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean d() {
        return this.b.SaveCache(this.f2293a);
    }
}
