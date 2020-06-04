package com.baidu.helios.channels;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.common.c.a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class a {
    public static Comparator<a> apD = new Comparator<a>() { // from class: com.baidu.helios.channels.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long priority = aVar.getPriority() - aVar2.getPriority();
            return priority != 0 ? priority > 0 ? -1 : 1 : aVar.getName().compareTo(aVar2.getName());
        }
    };
    protected C0136a apB;
    protected a.C0141a apC;
    private final String b;
    private long c;

    /* renamed from: com.baidu.helios.channels.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0136a {
        public com.baidu.helios.common.c.a apE;
        public com.baidu.helios.ids.b apF;
        public Context applicationContext;
    }

    /* loaded from: classes6.dex */
    public static abstract class b {
        private a.C0141a apk;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0141a c0141a, String str) {
            this.apk = c0141a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void aK(boolean z) {
            this.d = z;
        }

        public abstract void o(JSONObject jSONObject);

        public abstract void p(JSONObject jSONObject);

        public boolean tW() {
            String q = this.apk.q(this.c, true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    o(new JSONObject(q));
                    aK(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }

        public boolean tX() {
            if (this.d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    p(jSONObject);
                    this.apk.d(this.c, jSONObject.toString(), true);
                    aK(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
    }

    /* loaded from: classes6.dex */
    public static class d {
    }

    /* loaded from: classes6.dex */
    public static class e {
        private int a;
        private int b;
        public Exception exception;

        public e(int i, int i2, Exception exc) {
            this.a = i;
            this.b = i2;
            this.exception = exc;
        }

        public static e bv(int i) {
            return new e(-1, i, null);
        }

        public static e i(Exception exc) {
            return new e(-1, 0, exc);
        }

        public static e tY() {
            return new e(0, 0, null);
        }

        public static e tZ() {
            return bv(0);
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public boolean apG;
    }

    /* loaded from: classes6.dex */
    public static class g {
        public int errCode;
        public Exception exception;
        public String id;

        public g(int i, String str, Exception exc) {
            this.errCode = i;
            this.id = str;
            this.exception = exc;
        }

        public static g bw(int i) {
            return new g(i, null, null);
        }

        public static g dZ(String str) {
            return new g(0, str, null);
        }

        public static g e(int i, Exception exc) {
            return new g(i, null, exc);
        }

        public static g j(Exception exc) {
            return new g(-1, null, exc);
        }

        public boolean isSuccess() {
            return this.errCode == 0;
        }
    }

    public a(String str, long j) {
        this.b = str;
        this.c = j;
    }

    public abstract e a(d dVar);

    public abstract g a(String str, f fVar);

    public final void a(C0136a c0136a) {
        this.apB = c0136a;
        this.apC = c0136a.apE.us().eb(IXAdRequestInfo.CS);
    }

    public abstract void a(c cVar);

    public String getName() {
        return this.b;
    }

    public long getPriority() {
        return this.c;
    }

    public void setPriority(long j) {
        this.c = j;
    }
}
