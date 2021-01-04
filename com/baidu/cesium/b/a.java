package com.baidu.cesium.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cesium.e.a;
import com.baidu.cesium.g;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class a {
    public static Comparator<a> d = new Comparator<a>() { // from class: com.baidu.cesium.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long b2 = aVar.b() - aVar2.b();
            return b2 != 0 ? b2 > 0 ? -1 : 1 : aVar.a().compareTo(aVar2.a());
        }
    };
    protected C0091a anL;
    protected a.C0094a anM;
    private final String e;
    private long f;

    /* renamed from: com.baidu.cesium.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0091a {

        /* renamed from: a  reason: collision with root package name */
        public Context f1669a;
        public com.baidu.cesium.e.a anN;
    }

    /* loaded from: classes4.dex */
    public static abstract class b {
        private a.C0094a anO;

        /* renamed from: b  reason: collision with root package name */
        private String f1670b;
        private String c;
        private boolean d = true;

        public b(a.C0094a c0094a, String str) {
            this.anO = c0094a;
            this.f1670b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.d = z;
        }

        public boolean a() {
            String a2 = this.anO.a(this.c, true);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    a(new JSONObject(a2));
                    a(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }

        public abstract void b(JSONObject jSONObject);

        public boolean b() {
            if (this.d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    b(jSONObject);
                    this.anO.a(this.c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
    }

    /* loaded from: classes4.dex */
    public static class d {
    }

    /* loaded from: classes4.dex */
    public static class e {
        public Exception e;
        private int f;
        private int g;

        public e(int i, int i2, Exception exc) {
            this.f = i;
            this.g = i2;
            this.e = exc;
        }

        public static e bH(int i) {
            return new e(-1, i, null);
        }

        public static e tS() {
            return new e(0, 0, null);
        }

        public static e tT() {
            return bH(0);
        }
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1671a;
    }

    /* loaded from: classes4.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public g.a f1672a;
        public Exception aeP;

        /* renamed from: b  reason: collision with root package name */
        public int f1673b;

        public g(int i, g.a aVar, Exception exc) {
            this.f1673b = i;
            this.f1672a = aVar;
            this.aeP = exc;
        }

        public static g bI(int i) {
            return new g(i, null, null);
        }

        public static g d(g.a aVar) {
            return new g(0, aVar, null);
        }

        public static g tU() {
            return new g(-1, null, null);
        }

        public boolean a() {
            return this.f1673b == 0;
        }
    }

    public a(String str, long j) {
        this.e = str;
        this.f = j;
    }

    public abstract e a(d dVar, g.a aVar);

    public abstract g a(String str, f fVar);

    public String a() {
        return this.e;
    }

    public final void a(C0091a c0091a) {
        this.anL = c0091a;
        this.anM = c0091a.anN.tX().dm(IXAdRequestInfo.CS);
    }

    public abstract void a(c cVar);

    public long b() {
        return this.f;
    }
}
