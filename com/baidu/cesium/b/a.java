package com.baidu.cesium.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cesium.e.a;
import com.baidu.cesium.g;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public abstract class a {
    public static Comparator<a> alK = new Comparator<a>() { // from class: com.baidu.cesium.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long b2 = aVar.b() - aVar2.b();
            return b2 != 0 ? b2 > 0 ? -1 : 1 : aVar.a().compareTo(aVar2.a());
        }
    };
    protected C0098a alI;
    protected a.C0101a alJ;
    private final String e;
    private long f;

    /* renamed from: com.baidu.cesium.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C0098a {
        public Context a;
        public com.baidu.cesium.e.a alL;
    }

    /* loaded from: classes18.dex */
    public static abstract class b {
        private a.C0101a alM;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0101a c0101a, String str) {
            this.alM = c0101a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.d = z;
        }

        public boolean a() {
            String a = this.alM.a(this.c, true);
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
                    this.alM.c(this.c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes18.dex */
    public static class c {
    }

    /* loaded from: classes18.dex */
    public static class d {
    }

    /* loaded from: classes18.dex */
    public static class e {
        public Exception e;
        private int f;
        private int g;

        public e(int i, int i2, Exception exc) {
            this.f = i;
            this.g = i2;
            this.e = exc;
        }

        public static e bF(int i) {
            return new e(-1, i, null);
        }

        public static e ur() {
            return new e(0, 0, null);
        }

        public static e us() {
            return bF(0);
        }
    }

    /* loaded from: classes18.dex */
    public static class f {
        public boolean a;
    }

    /* loaded from: classes18.dex */
    public static class g {
        public g.a a;
        public Exception acI;
        public int b;

        public g(int i, g.a aVar, Exception exc) {
            this.b = i;
            this.a = aVar;
            this.acI = exc;
        }

        public static g bG(int i) {
            return new g(i, null, null);
        }

        public static g d(g.a aVar) {
            return new g(0, aVar, null);
        }

        public static g ut() {
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

    public final void a(C0098a c0098a) {
        this.alI = c0098a;
        this.alJ = c0098a.alL.uw().m21do(IXAdRequestInfo.CS);
    }

    public abstract void a(c cVar);

    public long b() {
        return this.f;
    }
}
