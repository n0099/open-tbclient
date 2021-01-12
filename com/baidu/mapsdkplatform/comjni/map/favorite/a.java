package com.baidu.mapsdkplatform.comjni.map.favorite;

import android.os.Bundle;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f3176a = 0;

    /* renamed from: b  reason: collision with root package name */
    private JNIFavorite f3177b;

    /* renamed from: com.baidu.mapsdkplatform.comjni.map.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0254a {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f3178a = false;

        /* JADX INFO: Access modifiers changed from: private */
        public static void b() {
            f3178a = true;
        }
    }

    public a() {
        this.f3177b = null;
        this.f3177b = new JNIFavorite();
    }

    public int a(Bundle bundle) {
        try {
            return this.f3177b.GetAll(this.f3176a, bundle);
        } catch (Throwable th) {
            return 0;
        }
    }

    public long a() {
        this.f3176a = this.f3177b.Create();
        return this.f3176a;
    }

    public boolean a(int i) {
        return this.f3177b.SetType(this.f3176a, i);
    }

    public boolean a(String str) {
        return this.f3177b.Remove(this.f3176a, str);
    }

    public boolean a(String str, String str2) {
        C0254a.b();
        return this.f3177b.Add(this.f3176a, str, str2);
    }

    public boolean a(String str, String str2, String str3, int i, int i2, int i3) {
        return this.f3177b.Load(this.f3176a, str, str2, str3, i, i2, i3);
    }

    public int b() {
        return this.f3177b.Release(this.f3176a);
    }

    public String b(String str) {
        try {
            return this.f3177b.GetValue(this.f3176a, str);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean b(String str, String str2) {
        C0254a.b();
        return this.f3177b.Update(this.f3176a, str, str2);
    }

    public boolean c() {
        return this.f3177b.Clear(this.f3176a);
    }

    public boolean c(String str) {
        try {
            return this.f3177b.IsExist(this.f3176a, str);
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean d() {
        return this.f3177b.SaveCache(this.f3176a);
    }
}
