package com.baidu.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.b.e.a;
import com.baidu.b.h;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public abstract class a {
    public static Comparator<a> acj = new com.baidu.b.b.b();
    protected C0088a ach;
    protected a.C0090a aci;
    private final String d;
    private long e;

    /* renamed from: com.baidu.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C0088a {
        public Context a;
        public com.baidu.b.e.a acm;
    }

    /* loaded from: classes20.dex */
    public static abstract class b {
        private a.C0090a acn;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0090a c0090a, String str) {
            this.acn = c0090a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.d = z;
        }

        public boolean a() {
            String a = this.acn.a(this.c, true);
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
                    this.acn.c(this.c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes20.dex */
    public static class c {
    }

    /* loaded from: classes20.dex */
    public static class d {
        public boolean a;
    }

    /* loaded from: classes20.dex */
    public static class e {
        public h.a aco;
        public Exception acp;
        public int b;

        public e(int i, h.a aVar, Exception exc) {
            this.b = i;
            this.aco = aVar;
            this.acp = exc;
        }

        public static e a(h.a aVar) {
            return new e(0, aVar, null);
        }

        public static e bf(int i) {
            return new e(i, null, null);
        }

        public static e sD() {
            return new e(-1, null, null);
        }

        public boolean a() {
            return this.b == 0;
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

    public final void a(C0088a c0088a) {
        this.ach = c0088a;
        this.aci = c0088a.acm.sJ().cV(IXAdRequestInfo.CS);
    }

    public abstract void a(c cVar);

    public long b() {
        return this.e;
    }
}
