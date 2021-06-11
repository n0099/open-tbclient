package com.baidu.mobads.cid.cesium.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.cid.cesium.g;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: c  reason: collision with root package name */
    public static Comparator<a> f8123c = new Comparator<a>() { // from class: com.baidu.mobads.cid.cesium.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            int i2 = ((aVar.b() - aVar2.b()) > 0L ? 1 : ((aVar.b() - aVar2.b()) == 0L ? 0 : -1));
            return i2 != 0 ? i2 > 0 ? -1 : 1 : aVar.a().compareTo(aVar2.a());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public C0105a f8124a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0107a f8125b;

    /* renamed from: d  reason: collision with root package name */
    public final String f8126d;

    /* renamed from: e  reason: collision with root package name */
    public long f8127e;

    /* renamed from: com.baidu.mobads.cid.cesium.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0105a {

        /* renamed from: a  reason: collision with root package name */
        public Context f8128a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.mobads.cid.cesium.e.a f8129b;
    }

    /* loaded from: classes2.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public a.C0107a f8130a;

        /* renamed from: b  reason: collision with root package name */
        public String f8131b;

        /* renamed from: c  reason: collision with root package name */
        public String f8132c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8133d = true;

        public b(a.C0107a c0107a, String str) {
            this.f8130a = c0107a;
            this.f8131b = str;
            this.f8132c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.f8133d = z;
        }

        public boolean a() {
            String a2 = this.f8130a.a(this.f8132c, true);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    a(new JSONObject(a2));
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public abstract void b(JSONObject jSONObject);

        public boolean b() {
            if (this.f8133d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    b(jSONObject);
                    this.f8130a.a(this.f8132c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f8134a;
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public g.a f8135a;

        /* renamed from: b  reason: collision with root package name */
        public int f8136b;

        /* renamed from: c  reason: collision with root package name */
        public Exception f8137c;

        public e(int i2, g.a aVar, Exception exc) {
            this.f8136b = i2;
            this.f8135a = aVar;
            this.f8137c = exc;
        }

        public static e a(int i2) {
            return new e(i2, null, null);
        }

        public static e a(g.a aVar) {
            return new e(0, aVar, null);
        }

        public static e b() {
            return new e(-1, null, null);
        }

        public boolean a() {
            return this.f8136b == 0;
        }
    }

    public a(String str, long j) {
        this.f8126d = str;
        this.f8127e = j;
    }

    public abstract e a(String str, d dVar);

    public String a() {
        return this.f8126d;
    }

    public final void a(C0105a c0105a) {
        this.f8124a = c0105a;
        this.f8125b = c0105a.f8129b.b().a("cs");
    }

    public abstract void a(c cVar);

    public long b() {
        return this.f8127e;
    }
}
