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
    public static Comparator<a> f8058c = new Comparator<a>() { // from class: com.baidu.mobads.cid.cesium.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            int i = ((aVar.b() - aVar2.b()) > 0L ? 1 : ((aVar.b() - aVar2.b()) == 0L ? 0 : -1));
            return i != 0 ? i > 0 ? -1 : 1 : aVar.a().compareTo(aVar2.a());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public C0103a f8059a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0105a f8060b;

    /* renamed from: d  reason: collision with root package name */
    public final String f8061d;

    /* renamed from: e  reason: collision with root package name */
    public long f8062e;

    /* renamed from: com.baidu.mobads.cid.cesium.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0103a {

        /* renamed from: a  reason: collision with root package name */
        public Context f8063a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.mobads.cid.cesium.e.a f8064b;
    }

    /* loaded from: classes2.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public a.C0105a f8065a;

        /* renamed from: b  reason: collision with root package name */
        public String f8066b;

        /* renamed from: c  reason: collision with root package name */
        public String f8067c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8068d = true;

        public b(a.C0105a c0105a, String str) {
            this.f8065a = c0105a;
            this.f8066b = str;
            this.f8067c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.f8068d = z;
        }

        public boolean a() {
            String a2 = this.f8065a.a(this.f8067c, true);
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
            if (this.f8068d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    b(jSONObject);
                    this.f8065a.a(this.f8067c, jSONObject.toString(), true);
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
        public boolean f8069a;
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public g.a f8070a;

        /* renamed from: b  reason: collision with root package name */
        public int f8071b;

        /* renamed from: c  reason: collision with root package name */
        public Exception f8072c;

        public e(int i, g.a aVar, Exception exc) {
            this.f8071b = i;
            this.f8070a = aVar;
            this.f8072c = exc;
        }

        public static e a(int i) {
            return new e(i, null, null);
        }

        public static e a(g.a aVar) {
            return new e(0, aVar, null);
        }

        public static e b() {
            return new e(-1, null, null);
        }

        public boolean a() {
            return this.f8071b == 0;
        }
    }

    public a(String str, long j) {
        this.f8061d = str;
        this.f8062e = j;
    }

    public abstract e a(String str, d dVar);

    public String a() {
        return this.f8061d;
    }

    public final void a(C0103a c0103a) {
        this.f8059a = c0103a;
        this.f8060b = c0103a.f8064b.b().a("cs");
    }

    public abstract void a(c cVar);

    public long b() {
        return this.f8062e;
    }
}
