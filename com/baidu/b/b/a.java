package com.baidu.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.b.e.a;
import com.baidu.b.h;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a {
    public static Comparator<a> acE = new com.baidu.b.b.b();
    protected C0089a acC;
    protected a.C0091a acD;
    private final String d;
    private long e;

    /* renamed from: com.baidu.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0089a {
        public Context a;
        public com.baidu.b.e.a acF;
    }

    /* loaded from: classes3.dex */
    public static abstract class b {
        private a.C0091a acG;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0091a c0091a, String str) {
            this.acG = c0091a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.d = z;
        }

        public boolean a() {
            String a = this.acG.a(this.c, true);
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
                    this.acG.c(this.c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
    }

    /* loaded from: classes3.dex */
    public static class d {
        public boolean a;
    }

    /* loaded from: classes3.dex */
    public static class e {
        public h.a acH;
        public Exception acI;
        public int b;

        public e(int i, h.a aVar, Exception exc) {
            this.b = i;
            this.acH = aVar;
            this.acI = exc;
        }

        public static e a(h.a aVar) {
            return new e(0, aVar, null);
        }

        public static e bj(int i) {
            return new e(i, null, null);
        }

        public static e sI() {
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

    public final void a(C0089a c0089a) {
        this.acC = c0089a;
        this.acD = c0089a.acF.sO().cX(IXAdRequestInfo.CS);
    }

    public abstract void a(c cVar);

    public long b() {
        return this.e;
    }
}
