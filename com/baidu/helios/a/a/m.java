package com.baidu.helios.a.a;

import android.content.Context;
import com.baidu.helios.common.c.a;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class m implements i {
    private a aqn;

    /* loaded from: classes6.dex */
    private class a {
        private a.C0141a aqo;
        private JSONObject aqp;
        private JSONObject aqq;
        private Context i;
        private boolean k;
        private boolean l;
        private boolean m;
        private long n;
        private long q;

        public a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            this.aqo = new com.baidu.helios.common.c.a(context.getApplicationContext()).us().eb("cloud").eb("cstore");
        }

        private boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
            JSONArray jSONArray;
            JSONArray jSONArray2 = null;
            try {
                jSONArray = k.b(jSONObject.optJSONArray("sids"), Config.INPUT_DEF_PKG);
                try {
                    jSONArray2 = k.b(jSONObject2.optJSONArray("sids"), Config.INPUT_DEF_PKG);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                jSONArray = null;
            }
            return m.a(jSONArray, jSONArray2) || k.a(jSONObject, jSONObject2, "oid") || k.a(jSONObject, jSONObject2, "gaid") || k.a(jSONObject, jSONObject2, "iid") || k.a(jSONObject, jSONObject2, "adrid") || k.a(jSONObject, jSONObject2, "aid");
        }

        private synchronized boolean b() {
            boolean a;
            if (this.aqp == null) {
                a = true;
            } else if (this.aqq == null) {
                throw new IllegalArgumentException("you forgot invoke methond :IMatchConditions.setComparedCStoreParams before ");
            } else {
                a = a(this.aqp, this.aqq);
            }
            return a;
        }

        private boolean c() {
            return Math.abs(System.currentTimeMillis() - this.q) / 1000 > this.n;
        }

        private long d() {
            if (this.aqp == null) {
                return 0L;
            }
            return this.aqp.optLong("ctime", 0L);
        }

        private void e() {
            try {
                this.aqp = l.a(this.aqo.q("cs.dat", true));
                this.q = d();
            } catch (Exception e) {
                this.q = 0L;
            }
        }

        private void f() {
            try {
                JSONObject a = l.a(this.aqo.q("ct.dat", true));
                if (a == null) {
                    this.n = 172800L;
                } else {
                    this.n = a.optLong("TIME_OUT", 172800L);
                }
            } catch (Exception e) {
                this.n = 172800L;
            }
        }

        private void g() {
            try {
                JSONObject a = l.a(this.aqo.q("ci.dat", true));
                if (a == null) {
                    this.k = true;
                } else {
                    this.k = a.optBoolean("isOn", true);
                }
            } catch (Exception e) {
                this.k = true;
            }
        }

        private boolean h() {
            try {
                this.aqo.d("cs.dat", this.aqp.toString(), true);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        private boolean i() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isOn", this.k);
                this.aqo.d("ci.dat", jSONObject.toString(), true);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        private boolean j() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("TIME_OUT", this.n);
                this.aqo.d("ct.dat", jSONObject.toString(), true);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        private synchronized void k() {
            synchronized (this) {
                if (this.l) {
                    this.l = !i();
                }
                if (this.m) {
                    this.m = j() ? false : true;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void l() {
            i();
            this.m = !j();
        }

        private void m() {
            e();
            f();
            g();
        }

        public void a(JSONObject jSONObject) {
            this.aqq = jSONObject;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
            if (b() != false) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean a() {
            boolean z = false;
            synchronized (this) {
                k();
                m();
                boolean tQ = com.baidu.helios.b.ae(this.i).tQ();
                if (this.k && tQ) {
                    if (this.aqp == null) {
                        z = true;
                    } else {
                        if (!c()) {
                        }
                        z = true;
                    }
                }
            }
            return z;
        }

        public void b(JSONObject jSONObject) {
            this.aqp = jSONObject;
            h();
        }
    }

    public m(Context context) {
        if (context == null) {
            throw new NullPointerException("context should not be null");
        }
        if (this.aqn == null) {
            this.aqn = new a(context.getApplicationContext());
        }
    }

    static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        int length = jSONArray == null ? 0 : jSONArray.length();
        if (length != (jSONArray2 == null ? 0 : jSONArray2.length())) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            JSONObject optJSONObject2 = jSONArray2.optJSONObject(i);
            if (k.a(optJSONObject, optJSONObject2, Config.INPUT_DEF_PKG) || k.a(optJSONObject, optJSONObject2, "aid") || k.b(optJSONObject, optJSONObject2, "priority")) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.helios.a.a.i
    public boolean a() {
        return this.aqn.a();
    }

    @Override // com.baidu.helios.a.a.i
    public void b() {
        this.aqn.l();
    }

    @Override // com.baidu.helios.a.a.i
    public void b(JSONObject jSONObject) {
        this.aqn.b(jSONObject);
    }

    @Override // com.baidu.helios.a.a.i
    public i q(JSONObject jSONObject) {
        this.aqn.a(jSONObject);
        return this;
    }
}
