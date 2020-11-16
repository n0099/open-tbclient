package com.baidu.cesium.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cesium.e.a;
import com.baidu.cesium.g;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public abstract class a {
    public static Comparator<a> amj = new Comparator<a>() { // from class: com.baidu.cesium.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long b2 = aVar.b() - aVar2.b();
            return b2 != 0 ? b2 > 0 ? -1 : 1 : aVar.a().compareTo(aVar2.a());
        }
    };
    protected C0098a amh;
    protected a.C0101a ami;
    private final String e;
    private long f;

    /* renamed from: com.baidu.cesium.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C0098a {

        /* renamed from: a  reason: collision with root package name */
        public Context f1297a;
        public com.baidu.cesium.e.a amk;
    }

    /* loaded from: classes19.dex */
    public static abstract class b {
        private a.C0101a aml;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0101a c0101a, String str) {
            this.aml = c0101a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.d = z;
        }

        public boolean a() {
            String a2 = this.aml.a(this.c, true);
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
                    this.aml.c(this.c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes19.dex */
    public static class c {
    }

    /* loaded from: classes19.dex */
    public static class d {
    }

    /* loaded from: classes19.dex */
    public static class e {
        public Exception e;
        private int f;
        private int g;

        public e(int i, int i2, Exception exc) {
            this.f = i;
            this.g = i2;
            this.e = exc;
        }

        public static e bD(int i) {
            return new e(-1, i, null);
        }

        public static e uq() {
            return new e(0, 0, null);
        }

        public static e ur() {
            return bD(0);
        }
    }

    /* loaded from: classes19.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1298a;
    }

    /* loaded from: classes19.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public g.a f1299a;
        public Exception adf;
        public int b;

        public g(int i, g.a aVar, Exception exc) {
            this.b = i;
            this.f1299a = aVar;
            this.adf = exc;
        }

        public static g bE(int i) {
            return new g(i, null, null);
        }

        public static g d(g.a aVar) {
            return new g(0, aVar, null);
        }

        public static g us() {
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
        this.amh = c0098a;
        this.ami = c0098a.amk.uv().dq(IXAdRequestInfo.CS);
    }

    public abstract void a(c cVar);

    public long b() {
        return this.f;
    }
}
