package com.baidu.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.b.e.a;
import com.baidu.b.h;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a {
    public static Comparator<a> acV = new com.baidu.b.b.b();
    protected C0090a acT;
    protected a.C0092a acU;
    private final String d;
    private long e;

    /* renamed from: com.baidu.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0090a {

        /* renamed from: a  reason: collision with root package name */
        public Context f1246a;
        public com.baidu.b.e.a acW;
    }

    /* loaded from: classes7.dex */
    public static abstract class b {
        private a.C0092a acX;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0092a c0092a, String str) {
            this.acX = c0092a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void a(boolean z) {
            this.d = z;
        }

        public boolean a() {
            String a2 = this.acX.a(this.c, true);
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
                    this.acX.c(this.c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1247a;
    }

    /* loaded from: classes7.dex */
    public static class e {
        public h.a acY;
        public Exception acZ;
        public int b;

        public e(int i, h.a aVar, Exception exc) {
            this.b = i;
            this.acY = aVar;
            this.acZ = exc;
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

    public final void a(C0090a c0090a) {
        this.acT = c0090a;
        this.acU = c0090a.acW.sO().cX(IXAdRequestInfo.CS);
    }

    public abstract void a(c cVar);

    public long b() {
        return this.e;
    }
}
