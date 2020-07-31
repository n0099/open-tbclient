package com.baidu.helios.channels;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.common.c.a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class a {
    public static Comparator<a> aqR = new Comparator<a>() { // from class: com.baidu.helios.channels.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long priority = aVar.getPriority() - aVar2.getPriority();
            return priority != 0 ? priority > 0 ? -1 : 1 : aVar.getName().compareTo(aVar2.getName());
        }
    };
    protected C0136a aqP;
    protected a.C0141a aqQ;
    private final String b;
    private long c;

    /* renamed from: com.baidu.helios.channels.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0136a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a aqS;
        public com.baidu.helios.ids.b aqT;
    }

    /* loaded from: classes11.dex */
    public static abstract class b {
        private a.C0141a aqz;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0141a c0141a, String str) {
            this.aqz = c0141a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void aO(boolean z) {
            this.d = z;
        }

        public abstract void p(JSONObject jSONObject);

        public abstract void q(JSONObject jSONObject);

        public boolean uo() {
            String q = this.aqz.q(this.c, true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    p(new JSONObject(q));
                    aO(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }

        public boolean up() {
            if (this.d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    q(jSONObject);
                    this.aqz.d(this.c, jSONObject.toString(), true);
                    aO(false);
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
    }

    /* loaded from: classes11.dex */
    public static class d {
    }

    /* loaded from: classes11.dex */
    public static class e {
        private int a;
        private int b;
        public Exception exception;

        public e(int i, int i2, Exception exc) {
            this.a = i;
            this.b = i2;
            this.exception = exc;
        }

        public static e bC(int i) {
            return new e(-1, i, null);
        }

        public static e i(Exception exc) {
            return new e(-1, 0, exc);
        }

        public static e uq() {
            return new e(0, 0, null);
        }

        public static e ur() {
            return bC(0);
        }
    }

    /* loaded from: classes11.dex */
    public static class f {
        public boolean aqU;
    }

    /* loaded from: classes11.dex */
    public static class g {
        public int errCode;
        public Exception exception;
        public String id;

        public g(int i, String str, Exception exc) {
            this.errCode = i;
            this.id = str;
            this.exception = exc;
        }

        public static g bD(int i) {
            return new g(i, null, null);
        }

        public static g e(int i, Exception exc) {
            return new g(i, null, exc);
        }

        public static g ea(String str) {
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

    public final void a(C0136a c0136a) {
        this.aqP = c0136a;
        this.aqQ = c0136a.aqS.uK().ec(IXAdRequestInfo.CS);
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
