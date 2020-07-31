package com.baidu.swan.apps.setting.b;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.c.a.f;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.swan.apps.setting.oauth.a.a;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final Map<String, a> cNt = new HashMap();
    private e bRs;
    public JSONObject cMD;
    private final String cMU;
    private boolean cMX;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.aq.e.b<a>> cBE = new HashSet();
    private TaskState cNu = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.an.a cNv = new com.baidu.swan.apps.an.a().bJ(8).qm("OpenData");
    private boolean cNw = false;
    private boolean cNx = false;
    private final com.baidu.swan.apps.aq.d.a cNy = new com.baidu.swan.apps.aq.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.aq.e.b<a> bVar) {
        synchronized (cNt) {
            String U = U(str, z);
            a aVar = cNt.get(U);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                cNt.put(U, aVar2);
                aVar2.v(bVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar.toString());
                aVar.u(bVar);
            }
        }
    }

    private static String U(String str, boolean z) {
        return str + "/" + (z ? "1" : "0");
    }

    public boolean atR() {
        return TaskState.FINISHED == this.cNu && 0 == this.cNv.avT() && this.cMD != null;
    }

    public boolean atS() {
        return TaskState.FINISHED == this.cNu && this.cMD != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.cMU = str2;
        this.cMX = z;
    }

    private a u(com.baidu.swan.apps.aq.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.cBE) {
                this.cBE.add(bVar);
            }
        }
        return this;
    }

    private void v(com.baidu.swan.apps.aq.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.cNu = TaskState.CALLING;
        this.cNw = TextUtils.equals(this.mScope, "snsapi_userinfo");
        u(bVar);
        this.bRs = e.arv();
        if (this.bRs == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.cNv.bL(10001L);
            finish();
            hk(10001);
            return;
        }
        this.bRs.arH().cLx.b(this.cNy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.bRs.arI().isLogin(this.mActivity);
        atT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atT() {
        d.arr().art().Sv().Uf().a(this.mActivity, this.mScope, this.cMU, this.cMX, this.mIsLogin).t(new com.baidu.swan.apps.aq.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.cNv.bL(10001L);
                    a.this.finish();
                    a.this.hk(10001);
                    return;
                }
                c.c("OpenData", "opendata=", hVar.mData);
                a.this.cNv.bL(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.cNv.qm(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.cNv.avP()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.cNv.bL(10001L);
                    a.this.finish();
                    a.this.hk(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.cNv.bL(10001L);
                    a.this.finish();
                    a.this.hk(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bw = com.baidu.swan.apps.setting.oauth.e.bw(optJSONObject.optJSONObject("scope"));
                if (bw == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.cNv.bL(10001L);
                    a.this.finish();
                    a.this.hk(10001);
                    return;
                }
                a.this.cMD = optJSONObject.optJSONObject("opendata");
                if (!a.this.cMX && bw.cMo < 0) {
                    if (bw.cMo == -2) {
                        a.this.cNv.bL(10006L);
                    } else {
                        a.this.cNv.bL(10005L);
                        a.this.a(10005, bw);
                    }
                    a.this.finish();
                } else if (bw.cMo <= 0) {
                    if (!a.this.bRs.VF()) {
                        if (!a.this.mIsLogin && bw.aty()) {
                            if (!TextUtils.equals(bw.id, "mobile") || f.bOu.Vu()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.atU();
                                return;
                            }
                        } else if (!TextUtils.equals(bw.id, "mobile") || !a.this.cNx) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.bRs, bw, a.this.cMD, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.cNv.bL(10003L);
                                    }
                                    a.this.fv(z);
                                }
                            });
                            return;
                        } else {
                            a.this.fv(true);
                            return;
                        }
                    }
                    a.this.cNv.bL(10005L);
                    a.this.finish();
                    a.this.a(10005, bw);
                } else {
                    a.this.cMD = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).atq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atU() {
        com.baidu.swan.apps.t.a.aho().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.cNv.bL(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cNv.bL(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.cNx = true;
                        a.this.atT();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.bRs.arI().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.cNv.bL(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cNv.bL(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.atT();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv(final boolean z) {
        if (TextUtils.isEmpty(this.cMU)) {
            d.arr().art().Sv().Uf().a(this.mActivity, z, this.mScope, this.cMU).t(new com.baidu.swan.apps.aq.e.b<h<a.C0399a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<a.C0399a> hVar) {
                    if (!z && !a.this.cNw) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.cMV == null) {
                        a.this.cNv.bL(10002L).qm("bad Accredit response");
                        a.this.finish();
                        a.this.hk(10002);
                    } else {
                        a.this.cMD = hVar.mData.cMV;
                        a.this.finish();
                    }
                }
            }).atq();
        } else {
            d.arr().art().Sv().Uf().a(this.mActivity, true, z, new String[]{this.mScope}, this.cMU, true).t(new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.cNv.bL(10002L).qm("bad authorize response");
                        a.this.hk(10002);
                    }
                    a.this.finish();
                }
            }).atq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.cNy.finish();
        synchronized (cNt) {
            cNt.remove(U(this.mScope, this.cMX));
        }
        this.cNu = TaskState.FINISHED;
        if (this.cMD == null && 0 == this.cNv.avT()) {
            if (this.mIsLogin) {
                this.cNv.bL(10001L);
            } else {
                this.cNv.bL(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.k(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.cBE) {
                    for (com.baidu.swan.apps.aq.e.b bVar : a.this.cBE) {
                        bVar.H(a.this);
                    }
                    a.this.cBE.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(atR()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.cNv));
        if (this.cMD != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.cMD));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.cNu));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.i(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e arw = e.arw();
        if (arw == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d pv = new com.baidu.swan.apps.statistic.a.d().hp(i).a(arw.Se()).pu(com.baidu.swan.apps.statistic.h.ho(arw.RU())).pv(arw.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", arw.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.eE(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.cMj);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        pv.bF(jSONObject);
        com.baidu.swan.apps.statistic.h.b(pv);
    }

    public static void atV() {
        synchronized (cNt) {
            cNt.clear();
        }
    }
}
