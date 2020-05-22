package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;
/* loaded from: classes8.dex */
public class a {
    private long a = 0;
    private JNIFavorite b;

    /* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0201a {
        public static boolean a = false;

        /* JADX INFO: Access modifiers changed from: private */
        public static void b() {
            a = true;
        }
    }

    public a() {
        this.b = null;
        this.b = new JNIFavorite();
    }

    public int a(Bundle bundle) {
        try {
            return this.b.GetAll(this.a, bundle);
        } catch (Throwable th) {
            return 0;
        }
    }

    public long a() {
        this.a = this.b.Create();
        return this.a;
    }

    public boolean a(int i) {
        return this.b.SetType(this.a, i);
    }

    public boolean a(String str) {
        return this.b.Remove(this.a, str);
    }

    public boolean a(String str, String str2) {
        C0201a.b();
        return this.b.Add(this.a, str, str2);
    }

    public boolean a(String str, String str2, String str3, int i, int i2, int i3) {
        return this.b.Load(this.a, str, str2, str3, i, i2, i3);
    }

    public int b() {
        return this.b.Release(this.a);
    }

    public String b(String str) {
        try {
            return this.b.GetValue(this.a, str);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean b(String str, String str2) {
        C0201a.b();
        return this.b.Update(this.a, str, str2);
    }

    public boolean c() {
        return this.b.Clear(this.a);
    }

    public boolean c(String str) {
        try {
            return this.b.IsExist(this.a, str);
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean d() {
        return this.b.SaveCache(this.a);
    }
}
