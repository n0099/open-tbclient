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
    public static Comparator<a> f8061c = new Comparator<a>() { // from class: com.baidu.mobads.cid.cesium.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            int i2 = ((aVar.b() - aVar2.b()) > 0L ? 1 : ((aVar.b() - aVar2.b()) == 0L ? 0 : -1));
            return i2 != 0 ? i2 > 0 ? -1 : 1 : aVar.a().compareTo(aVar2.a());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public C0104a f8062a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0106a f8063b;

    /* renamed from: d  reason: collision with root package name */
    public final String f8064d;

    /* renamed from: e  reason: collision with root package name */
    public long f8065e;

    /* renamed from: com.baidu.mobads.cid.cesium.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0104a {

        /* renamed from: a  reason: collision with root package name */
        public Context f8066a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.mobads.cid.cesium.e.a f8067b;
    }

    /* loaded from: classes2.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public a.C0106a f8068a;

        /* renamed from: b  reason: collision with root package name */
        public String f8069b;

        /* renamed from: c  reason: collision with root package name */
        public String f8070c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8071d = true;

        public b(a.C0106a c0106a, String str) {
            this.f8068a = c0106a;
            this.f8069b = str;
            this.f8070c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.f8071d = z;
        }

        public boolean a() {
            String a2 = this.f8068a.a(this.f8070c, true);
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
            if (this.f8071d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    b(jSONObject);
                    this.f8068a.a(this.f8070c, jSONObject.toString(), true);
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
        public boolean f8072a;
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public g.a f8073a;

        /* renamed from: b  reason: collision with root package name */
        public int f8074b;

        /* renamed from: c  reason: collision with root package name */
        public Exception f8075c;

        public e(int i2, g.a aVar, Exception exc) {
            this.f8074b = i2;
            this.f8073a = aVar;
            this.f8075c = exc;
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
            return this.f8074b == 0;
        }
    }

    public a(String str, long j) {
        this.f8064d = str;
        this.f8065e = j;
    }

    public abstract e a(String str, d dVar);

    public String a() {
        return this.f8064d;
    }

    public final void a(C0104a c0104a) {
        this.f8062a = c0104a;
        this.f8063b = c0104a.f8067b.b().a("cs");
    }

    public abstract void a(c cVar);

    public long b() {
        return this.f8065e;
    }
}
