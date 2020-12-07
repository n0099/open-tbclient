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
    public static Comparator<a> awp = new Comparator<a>() { // from class: com.baidu.helios.channels.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long priority = aVar.getPriority() - aVar2.getPriority();
            return priority != 0 ? priority > 0 ? -1 : 1 : aVar.getName().compareTo(aVar2.getName());
        }
    };
    protected C0144a awn;
    protected a.C0149a awo;
    private final String b;
    private long c;

    /* renamed from: com.baidu.helios.channels.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0144a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a awq;
        public com.baidu.helios.ids.b awr;
    }

    /* loaded from: classes14.dex */
    public static abstract class b {
        private a.C0149a avX;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0149a c0149a, String str) {
            this.avX = c0149a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void aY(boolean z) {
            this.d = z;
        }

        public abstract void j(JSONObject jSONObject);

        public abstract void k(JSONObject jSONObject);

        public boolean zq() {
            String p = this.avX.p(this.c, true);
            if (!TextUtils.isEmpty(p)) {
                try {
                    j(new JSONObject(p));
                    aY(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }

        public boolean zr() {
            if (this.d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    k(jSONObject);
                    this.avX.d(this.c, jSONObject.toString(), true);
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
        private int f1799a;
        private int b;
        public Exception exception;

        public e(int i, int i2, Exception exc) {
            this.f1799a = i;
            this.b = i2;
            this.exception = exc;
        }

        public static e dq(int i) {
            return new e(-1, i, null);
        }

        public static e i(Exception exc) {
            return new e(-1, 0, exc);
        }

        public static e zs() {
            return new e(0, 0, null);
        }

        public static e zt() {
            return dq(0);
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

        public static g dr(int i) {
            return new g(i, null, null);
        }

        public static g e(int i, Exception exc) {
            return new g(i, null, exc);
        }

        public static g fz(String str) {
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

    public final void a(C0144a c0144a) {
        this.awn = c0144a;
        this.awo = c0144a.awq.zO().fB(IXAdRequestInfo.CS);
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
