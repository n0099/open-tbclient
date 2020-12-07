package com.baidu.swan.apps.setting.b;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.d.a.f;
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
/* loaded from: classes25.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final Map<String, a> dEp = new HashMap();
    private e cEU;
    private final String dDQ;
    private boolean dDT;
    public JSONObject dDz;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ap.e.b<a>> cXV = new HashSet();
    private TaskState dEq = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.am.a dEr = new com.baidu.swan.apps.am.a().cU(8).uC("OpenData");
    private boolean dEs = false;
    private boolean dEt = false;
    private final com.baidu.swan.apps.ap.d.a dEu = new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ap.e.b<a> bVar) {
        synchronized (dEp) {
            String ag = ag(str, z);
            a aVar = dEp.get(ag);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                dEp.put(ag, aVar2);
                aVar2.C(bVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar.toString());
                aVar.B(bVar);
            }
        }
    }

    private static String ag(String str, boolean z) {
        return str + "/" + (z ? "1" : "0");
    }

    public boolean aMn() {
        return TaskState.FINISHED == this.dEq && 0 == this.dEr.aOo() && this.dDz != null;
    }

    public boolean aMo() {
        return TaskState.FINISHED == this.dEq && this.dDz != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dDQ = str2;
        this.dDT = z;
    }

    private a B(com.baidu.swan.apps.ap.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.cXV) {
                this.cXV.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ap.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.dEq = TaskState.CALLING;
        this.dEs = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.cEU = e.aJU();
        if (this.cEU == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.dEr.cW(10001L);
            finish();
            kO(10001);
            return;
        }
        this.cEU.aKg().dCu.b(this.dEu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.cEU.aKh().isLogin(this.mActivity);
        aMp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMp() {
        d.aJQ().aJS().aiF().akw().a(this.mActivity, this.mScope, this.dDQ, this.dDT, this.mIsLogin).A(new com.baidu.swan.apps.ap.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.dEr.cW(10001L);
                    a.this.finish();
                    a.this.kO(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.dEr.cW(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.dEr.uC(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.dEr.aOk()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.dEr.cW(10001L);
                    a.this.finish();
                    a.this.kO(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.dEr.cW(10001L);
                    a.this.finish();
                    a.this.kO(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bT = com.baidu.swan.apps.setting.oauth.e.bT(optJSONObject.optJSONObject("scope"));
                if (bT == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.dEr.cW(10001L);
                    a.this.finish();
                    a.this.kO(10001);
                    return;
                }
                a.this.dDz = optJSONObject.optJSONObject("opendata");
                if (!a.this.dDT && bT.dDk < 0) {
                    if (bT.dDk == -2) {
                        a.this.dEr.cW(10006L);
                    } else {
                        a.this.dEr.cW(10005L);
                        a.this.a(10005, bT);
                    }
                    a.this.finish();
                } else if (bT.dDk <= 0) {
                    if (!a.this.cEU.ama()) {
                        if (!a.this.mIsLogin && bT.aLT()) {
                            if (!TextUtils.equals(bT.id, "mobile") || f.cBS.alP()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aMq();
                                return;
                            }
                        } else if (!TextUtils.equals(bT.id, "mobile") || !a.this.dEt) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.cEU, bT, a.this.dDz, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.dEr.cW(10003L);
                                    }
                                    a.this.gX(z);
                                }
                            });
                            return;
                        } else {
                            a.this.gX(true);
                            return;
                        }
                    }
                    a.this.dEr.cW(10005L);
                    a.this.finish();
                    a.this.a(10005, bT);
                } else {
                    a.this.dDz = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aLL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMq() {
        com.baidu.swan.apps.t.a.azf().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dEr.cW(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dEr.cW(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.dEt = true;
                        a.this.aMp();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.cEU.aKh().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dEr.cW(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dEr.cW(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aMp();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(final boolean z) {
        if (TextUtils.isEmpty(this.dDQ)) {
            d.aJQ().aJS().aiF().akw().a(this.mActivity, z, this.mScope, this.dDQ).A(new com.baidu.swan.apps.ap.e.b<h<a.C0493a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<a.C0493a> hVar) {
                    if (!z && !a.this.dEs) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.dDR == null) {
                        a.this.dEr.cW(10002L).uC("bad Accredit response");
                        a.this.finish();
                        a.this.kO(10002);
                    } else {
                        a.this.dDz = hVar.mData.dDR;
                        a.this.finish();
                    }
                }
            }).aLL();
        } else {
            d.aJQ().aJS().aiF().akw().a(this.mActivity, true, z, new String[]{this.mScope}, this.dDQ, true).A(new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.dEr.cW(10002L).uC("bad authorize response");
                        a.this.kO(10002);
                    }
                    a.this.finish();
                }
            }).aLL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.dEu.finish();
        synchronized (dEp) {
            dEp.remove(ag(this.mScope, this.dDT));
        }
        this.dEq = TaskState.FINISHED;
        if (this.dDz == null && 0 == this.dEr.aOo()) {
            if (this.mIsLogin) {
                this.dEr.cW(10001L);
            } else {
                this.dEr.cW(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.cXV) {
                    for (com.baidu.swan.apps.ap.e.b bVar : a.this.cXV) {
                        bVar.M(a.this);
                    }
                    a.this.cXV.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aMn()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.dEr));
        if (this.dDz != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.dDz));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.dEq));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.k(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e aJV = e.aJV();
        if (aJV == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d tL = new com.baidu.swan.apps.statistic.a.d().kT(i).a(aJV.aio()).tK(com.baidu.swan.apps.statistic.h.kS(aJV.aie())).tL(aJV.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aJV.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.hX(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.dDf);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        tL.cc(jSONObject);
        com.baidu.swan.apps.statistic.h.b(tL);
    }

    public static void aMr() {
        synchronized (dEp) {
            dEp.clear();
        }
    }
}
