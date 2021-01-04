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
    public static Comparator<a> awK = new Comparator<a>() { // from class: com.baidu.helios.channels.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long priority = aVar.getPriority() - aVar2.getPriority();
            return priority != 0 ? priority > 0 ? -1 : 1 : aVar.getName().compareTo(aVar2.getName());
        }
    };
    protected C0136a awI;
    protected a.C0141a awJ;

    /* renamed from: b  reason: collision with root package name */
    private final String f2465b;
    private long c;

    /* renamed from: com.baidu.helios.channels.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0136a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a awL;
        public com.baidu.helios.ids.b awM;
    }

    /* loaded from: classes6.dex */
    public static abstract class b {
        private a.C0141a awu;

        /* renamed from: b  reason: collision with root package name */
        private String f2466b;
        private String c;
        private boolean d = true;

        public b(a.C0141a c0141a, String str) {
            this.awu = c0141a;
            this.f2466b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void aV(boolean z) {
            this.d = z;
        }

        public abstract void q(JSONObject jSONObject);

        public abstract void r(JSONObject jSONObject);

        public boolean yH() {
            String p = this.awu.p(this.c, true);
            if (!TextUtils.isEmpty(p)) {
                try {
                    q(new JSONObject(p));
                    aV(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }

        public boolean yI() {
            if (this.d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    r(jSONObject);
                    this.awu.c(this.c, jSONObject.toString(), true);
                    aV(false);
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

        /* renamed from: a  reason: collision with root package name */
        private int f2467a;

        /* renamed from: b  reason: collision with root package name */
        private int f2468b;
        public Exception exception;

        public e(int i, int i2, Exception exc) {
            this.f2467a = i;
            this.f2468b = i2;
            this.exception = exc;
        }

        public static e dq(int i) {
            return new e(-1, i, null);
        }

        public static e i(Exception exc) {
            return new e(-1, 0, exc);
        }

        public static e yJ() {
            return new e(0, 0, null);
        }

        public static e yK() {
            return dq(0);
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public boolean useCache;
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

        public static g dr(int i) {
            return new g(i, null, null);
        }

        public static g e(int i, Exception exc) {
            return new g(i, null, exc);
        }

        public static g fk(String str) {
            return new g(0, str, null);
        }

        public static g j(Exception exc) {
            return new g(-1, null, exc);
        }

        public boolean isSuccess() {
            return this.errCode == 0;
        }
    }

    public a(String str, long j) {
        this.f2465b = str;
        this.c = j;
    }

    public abstract e a(d dVar);

    public abstract g a(String str, f fVar);

    public final void a(C0136a c0136a) {
        this.awI = c0136a;
        this.awJ = c0136a.awL.zf().fm(IXAdRequestInfo.CS);
    }

    public abstract void a(c cVar);

    public String getName() {
        return this.f2465b;
    }

    public long getPriority() {
        return this.c;
    }

    public void setPriority(long j) {
        this.c = j;
    }
}
