package com.baidu.cesium.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cesium.e.a;
import com.baidu.cesium.g;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class a {
    public static Comparator<a> alk = new Comparator<a>() { // from class: com.baidu.cesium.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long b2 = aVar.b() - aVar2.b();
            return b2 != 0 ? b2 > 0 ? -1 : 1 : aVar.a().compareTo(aVar2.a());
        }
    };
    protected C0097a ali;
    protected a.C0100a alj;
    private final String e;
    private long f;

    /* renamed from: com.baidu.cesium.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0097a {
        public Context a;
        public com.baidu.cesium.e.a alm;
    }

    /* loaded from: classes9.dex */
    public static abstract class b {
        private a.C0100a aln;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0100a c0100a, String str) {
            this.aln = c0100a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.d = z;
        }

        public boolean a() {
            String a = this.aln.a(this.c, true);
            if (!TextUtils.isEmpty(a)) {
                try {
                    a(new JSONObject(a));
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
                    this.aln.c(this.c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
    }

    /* loaded from: classes9.dex */
    public static class d {
    }

    /* loaded from: classes9.dex */
    public static class e {
        public Exception e;
        private int f;
        private int g;

        public e(int i, int i2, Exception exc) {
            this.f = i;
            this.g = i2;
            this.e = exc;
        }

        public static e bB(int i) {
            return new e(-1, i, null);
        }

        public static e ul() {
            return new e(0, 0, null);
        }

        public static e um() {
            return bB(0);
        }
    }

    /* loaded from: classes9.dex */
    public static class f {
        public boolean a;
    }

    /* loaded from: classes9.dex */
    public static class g {
        public g.a a;
        public Exception acp;
        public int b;

        public g(int i, g.a aVar, Exception exc) {
            this.b = i;
            this.a = aVar;
            this.acp = exc;
        }

        public static g bC(int i) {
            return new g(i, null, null);
        }

        public static g d(g.a aVar) {
            return new g(0, aVar, null);
        }

        public static g un() {
            return new g(-1, null, null);
        }

        public boolean a() {
            return this.b == 0;
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

    public final void a(C0097a c0097a) {
        this.ali = c0097a;
        this.alj = c0097a.alm.uq().dm(IXAdRequestInfo.CS);
    }

    public abstract void a(c cVar);

    public long b() {
        return this.f;
    }
}
