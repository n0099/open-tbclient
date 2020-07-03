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
    public static Comparator<a> aqV = new Comparator<a>() { // from class: com.baidu.helios.channels.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long priority = aVar.getPriority() - aVar2.getPriority();
            return priority != 0 ? priority > 0 ? -1 : 1 : aVar.getName().compareTo(aVar2.getName());
        }
    };
    protected C0138a aqT;
    protected a.C0143a aqU;
    private final String b;
    private long c;

    /* renamed from: com.baidu.helios.channels.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0138a {
        public Context applicationContext;
        public com.baidu.helios.common.c.a aqW;
        public com.baidu.helios.ids.b aqX;
    }

    /* loaded from: classes6.dex */
    public static abstract class b {
        private a.C0143a aqD;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0143a c0143a, String str) {
            this.aqD = c0143a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void aL(boolean z) {
            this.d = z;
        }

        public abstract void p(JSONObject jSONObject);

        public abstract void q(JSONObject jSONObject);

        public boolean uo() {
            String q = this.aqD.q(this.c, true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    p(new JSONObject(q));
                    aL(false);
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
                    this.aqD.d(this.c, jSONObject.toString(), true);
                    aL(false);
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

        public static e bA(int i) {
            return new e(-1, i, null);
        }

        public static e i(Exception exc) {
            return new e(-1, 0, exc);
        }

        public static e uq() {
            return new e(0, 0, null);
        }

        public static e ur() {
            return bA(0);
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public boolean aqY;
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

        public static g bB(int i) {
            return new g(i, null, null);
        }

        public static g e(int i, Exception exc) {
            return new g(i, null, exc);
        }

        public static g eb(String str) {
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

    public final void a(C0138a c0138a) {
        this.aqT = c0138a;
        this.aqU = c0138a.aqW.uK().ed(IXAdRequestInfo.CS);
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
