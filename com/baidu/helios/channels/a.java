package com.baidu.helios.channels;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.common.c.a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public abstract class a {
    public static Comparator<a> avO = new Comparator<a>() { // from class: com.baidu.helios.channels.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long priority = aVar.getPriority() - aVar2.getPriority();
            return priority != 0 ? priority > 0 ? -1 : 1 : aVar.getName().compareTo(aVar2.getName());
        }
    };
    protected C0143a avM;
    protected a.C0148a avN;
    private final String b;
    private long c;

    /* renamed from: com.baidu.helios.channels.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C0143a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a avP;
        public com.baidu.helios.ids.b avQ;
    }

    /* loaded from: classes12.dex */
    public static abstract class b {
        private a.C0148a avw;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0148a c0148a, String str) {
            this.avw = c0148a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void aT(boolean z) {
            this.d = z;
        }

        public abstract void p(JSONObject jSONObject);

        public abstract void q(JSONObject jSONObject);

        public boolean zL() {
            String q = this.avw.q(this.c, true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    p(new JSONObject(q));
                    aT(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }

        public boolean zM() {
            if (this.d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    q(jSONObject);
                    this.avw.d(this.c, jSONObject.toString(), true);
                    aT(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes12.dex */
    public static class c {
    }

    /* loaded from: classes12.dex */
    public static class d {
    }

    /* loaded from: classes12.dex */
    public static class e {
        private int a;
        private int b;
        public Exception exception;

        public e(int i, int i2, Exception exc) {
            this.a = i;
            this.b = i2;
            this.exception = exc;
        }

        public static e dm(int i) {
            return new e(-1, i, null);
        }

        public static e i(Exception exc) {
            return new e(-1, 0, exc);
        }

        public static e zN() {
            return new e(0, 0, null);
        }

        public static e zO() {
            return dm(0);
        }
    }

    /* loaded from: classes12.dex */
    public static class f {
        public boolean useCache;
    }

    /* loaded from: classes12.dex */
    public static class g {
        public int errCode;
        public Exception exception;
        public String id;

        public g(int i, String str, Exception exc) {
            this.errCode = i;
            this.id = str;
            this.exception = exc;
        }

        public static g dn(int i) {
            return new g(i, null, null);
        }

        public static g e(int i, Exception exc) {
            return new g(i, null, exc);
        }

        public static g ft(String str) {
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
        this.b = str;
        this.c = j;
    }

    public abstract e a(d dVar);

    public abstract g a(String str, f fVar);

    public final void a(C0143a c0143a) {
        this.avM = c0143a;
        this.avN = c0143a.avP.Ah().fv(IXAdRequestInfo.CS);
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
