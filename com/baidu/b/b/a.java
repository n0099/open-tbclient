package com.baidu.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.b.e.a;
import com.baidu.b.h;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public abstract class a {
    public static Comparator<a> adW = new com.baidu.b.b.b();
    protected C0091a adU;
    protected a.C0093a adV;
    private final String d;
    private long e;

    /* renamed from: com.baidu.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0091a {

        /* renamed from: a  reason: collision with root package name */
        public Context f1248a;
        public com.baidu.b.e.a adX;
    }

    /* loaded from: classes26.dex */
    public static abstract class b {
        private a.C0093a adY;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0093a c0093a, String str) {
            this.adY = c0093a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.d = z;
        }

        public boolean a() {
            String a2 = this.adY.a(this.c, true);
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
                    this.adY.c(this.c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes26.dex */
    public static class c {
    }

    /* loaded from: classes26.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1249a;
    }

    /* loaded from: classes26.dex */
    public static class e {
        public h.a adZ;
        public Exception aea;
        public int b;

        public e(int i, h.a aVar, Exception exc) {
            this.b = i;
            this.adZ = aVar;
            this.aea = exc;
        }

        public static e a(h.a aVar) {
            return new e(0, aVar, null);
        }

        public static e bn(int i) {
            return new e(i, null, null);
        }

        public static e sL() {
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

    public final void a(C0091a c0091a) {
        this.adU = c0091a;
        this.adV = c0091a.adX.sR().dc(IXAdRequestInfo.CS);
    }

    public abstract void a(c cVar);

    public long b() {
        return this.e;
    }
}
