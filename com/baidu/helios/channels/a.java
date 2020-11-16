package com.baidu.helios.channels;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.common.c.a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public abstract class a {
    public static Comparator<a> avr = new Comparator<a>() { // from class: com.baidu.helios.channels.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long priority = aVar.getPriority() - aVar2.getPriority();
            return priority != 0 ? priority > 0 ? -1 : 1 : aVar.getName().compareTo(aVar2.getName());
        }
    };
    protected C0146a avp;
    protected a.C0151a avq;
    private final String b;
    private long c;

    /* renamed from: com.baidu.helios.channels.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0146a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a avs;
        public com.baidu.helios.ids.b avt;
    }

    /* loaded from: classes14.dex */
    public static abstract class b {
        private a.C0151a auZ;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0151a c0151a, String str) {
            this.auZ = c0151a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void aY(boolean z) {
            this.d = z;
        }

        public abstract void j(JSONObject jSONObject);

        public abstract void k(JSONObject jSONObject);

        public boolean zy() {
            String q = this.auZ.q(this.c, true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    j(new JSONObject(q));
                    aY(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }

        public boolean zz() {
            if (this.d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    k(jSONObject);
                    this.auZ.d(this.c, jSONObject.toString(), true);
                    aY(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes14.dex */
    public static class c {
    }

    /* loaded from: classes14.dex */
    public static class d {
    }

    /* loaded from: classes14.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private int f1797a;
        private int b;
        public Exception exception;

        public e(int i, int i2, Exception exc) {
            this.f1797a = i;
            this.b = i2;
            this.exception = exc;
        }

        public static e dm(int i) {
            return new e(-1, i, null);
        }

        public static e i(Exception exc) {
            return new e(-1, 0, exc);
        }

        public static e zA() {
            return new e(0, 0, null);
        }

        public static e zB() {
            return dm(0);
        }
    }

    /* loaded from: classes14.dex */
    public static class f {
        public boolean useCache;
    }

    /* loaded from: classes14.dex */
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

        public static g fv(String str) {
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

    public final void a(C0146a c0146a) {
        this.avp = c0146a;
        this.avq = c0146a.avs.zU().fx(IXAdRequestInfo.CS);
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
