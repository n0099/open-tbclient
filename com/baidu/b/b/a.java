package com.baidu.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.b.e.a;
import com.baidu.b.h;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public abstract class a {
    public static Comparator<a> c = new com.baidu.b.b.b();
    protected C0083a aeK;
    protected a.C0085a aeL;
    private final String d;
    private long e;

    /* renamed from: com.baidu.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0083a {

        /* renamed from: a  reason: collision with root package name */
        public Context f1574a;
        public com.baidu.b.e.a aeM;
    }

    /* loaded from: classes15.dex */
    public static abstract class b {
        private a.C0085a aeN;

        /* renamed from: b  reason: collision with root package name */
        private String f1575b;
        private String c;
        private boolean d = true;

        public b(a.C0085a c0085a, String str) {
            this.aeN = c0085a;
            this.f1575b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.d = z;
        }

        public boolean a() {
            String a2 = this.aeN.a(this.c, true);
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
                    this.aeN.a(this.c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes15.dex */
    public static class c {
    }

    /* loaded from: classes15.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1576a;
    }

    /* loaded from: classes15.dex */
    public static class e {
        public h.a aeO;
        public Exception aeP;

        /* renamed from: b  reason: collision with root package name */
        public int f1577b;

        public e(int i, h.a aVar, Exception exc) {
            this.f1577b = i;
            this.aeO = aVar;
            this.aeP = exc;
        }

        public static e a(h.a aVar) {
            return new e(0, aVar, null);
        }

        public static e bn(int i) {
            return new e(i, null, null);
        }

        public static e sm() {
            return new e(-1, null, null);
        }

        public boolean a() {
            return this.f1577b == 0;
        }
    }

    public a(String str, long j) {
        this.d = str;
        this.e = j;
    }

    public abstract e a(String str, d dVar);

    public String a() {
        return this.d;
    }

    public final void a(C0083a c0083a) {
        this.aeK = c0083a;
        this.aeL = c0083a.aeM.sr().cV(IXAdRequestInfo.CS);
    }

    public abstract void a(c cVar);

    public long b() {
        return this.e;
    }
}
