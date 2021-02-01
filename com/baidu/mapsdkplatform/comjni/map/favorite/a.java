package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f3174a = 0;

    /* renamed from: b  reason: collision with root package name */
    private JNIFavorite f3175b;

    /* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0255a {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f3176a = false;

        /* JADX INFO: Access modifiers changed from: private */
        public static void b() {
            f3176a = true;
        }
    }

    public a() {
        this.f3175b = null;
        this.f3175b = new JNIFavorite();
    }

    public int a(Bundle bundle) {
        try {
            return this.f3175b.GetAll(this.f3174a, bundle);
        } catch (Throwable th) {
            return 0;
        }
    }

    public long a() {
        this.f3174a = this.f3175b.Create();
        return this.f3174a;
    }

    public boolean a(int i) {
        return this.f3175b.SetType(this.f3174a, i);
    }

    public boolean a(String str) {
        return this.f3175b.Remove(this.f3174a, str);
    }

    public boolean a(String str, String str2) {
        C0255a.b();
        return this.f3175b.Add(this.f3174a, str, str2);
    }

    public boolean a(String str, String str2, String str3, int i, int i2, int i3) {
        return this.f3175b.Load(this.f3174a, str, str2, str3, i, i2, i3);
    }

    public int b() {
        return this.f3175b.Release(this.f3174a);
    }

    public String b(String str) {
        try {
            return this.f3175b.GetValue(this.f3174a, str);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean b(String str, String str2) {
        C0255a.b();
        return this.f3175b.Update(this.f3174a, str, str2);
    }

    public boolean c() {
        return this.f3175b.Clear(this.f3174a);
    }

    public boolean c(String str) {
        try {
            return this.f3175b.IsExist(this.f3174a, str);
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean d() {
        return this.f3175b.SaveCache(this.f3174a);
    }
}
