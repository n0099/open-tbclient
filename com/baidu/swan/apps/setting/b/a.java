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
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final Map<String, a> cWp = new HashMap();
    private e bWU;
    private final String cVQ;
    private boolean cVT;
    public JSONObject cVz;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ap.e.b<a>> cqf = new HashSet();
    private TaskState cWq = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.am.a cWr = new com.baidu.swan.apps.am.a().bO(8).sm("OpenData");
    private boolean cWs = false;
    private boolean cWt = false;
    private final com.baidu.swan.apps.ap.d.a cWu = new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ap.e.b<a> bVar) {
        synchronized (cWp) {
            String Z = Z(str, z);
            a aVar = cWp.get(Z);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                cWp.put(Z, aVar2);
                aVar2.C(bVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar.toString());
                aVar.B(bVar);
            }
        }
    }

    private static String Z(String str, boolean z) {
        return str + "/" + (z ? "1" : "0");
    }

    public boolean aCa() {
        return TaskState.FINISHED == this.cWq && 0 == this.cWr.aEc() && this.cVz != null;
    }

    public boolean aCb() {
        return TaskState.FINISHED == this.cWq && this.cVz != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.cVQ = str2;
        this.cVT = z;
    }

    private a B(com.baidu.swan.apps.ap.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.cqf) {
                this.cqf.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ap.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.cWq = TaskState.CALLING;
        this.cWs = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.bWU = e.azI();
        if (this.bWU == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.cWr.bQ(10001L);
            finish();
            jr(10001);
            return;
        }
        this.bWU.azU().cUu.b(this.cWu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.bWU.azV().isLogin(this.mActivity);
        aCc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCc() {
        d.azE().azG().Yq().aah().a(this.mActivity, this.mScope, this.cVQ, this.cVT, this.mIsLogin).A(new com.baidu.swan.apps.ap.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void I(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.cWr.bQ(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.cWr.bQ(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.cWr.sm(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.cWr.aDY()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.cWr.bQ(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.cWr.bQ(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bE = com.baidu.swan.apps.setting.oauth.e.bE(optJSONObject.optJSONObject("scope"));
                if (bE == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.cWr.bQ(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                a.this.cVz = optJSONObject.optJSONObject("opendata");
                if (!a.this.cVT && bE.cVk < 0) {
                    if (bE.cVk == -2) {
                        a.this.cWr.bQ(10006L);
                    } else {
                        a.this.cWr.bQ(10005L);
                        a.this.a(10005, bE);
                    }
                    a.this.finish();
                } else if (bE.cVk <= 0) {
                    if (!a.this.bWU.abL()) {
                        if (!a.this.mIsLogin && bE.aBG()) {
                            if (!TextUtils.equals(bE.id, "mobile") || f.bTS.abA()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aCd();
                                return;
                            }
                        } else if (!TextUtils.equals(bE.id, "mobile") || !a.this.cWt) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.bWU, bE, a.this.cVz, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.cWr.bQ(10003L);
                                    }
                                    a.this.fO(z);
                                }
                            });
                            return;
                        } else {
                            a.this.fO(true);
                            return;
                        }
                    }
                    a.this.cWr.bQ(10005L);
                    a.this.finish();
                    a.this.a(10005, bE);
                } else {
                    a.this.cVz = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aBy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCd() {
        com.baidu.swan.apps.t.a.aoO().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.cWr.bQ(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cWr.bQ(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.cWt = true;
                        a.this.aCc();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.bWU.azV().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.cWr.bQ(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cWr.bQ(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aCc();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO(final boolean z) {
        if (TextUtils.isEmpty(this.cVQ)) {
            d.azE().azG().Yq().aah().a(this.mActivity, z, this.mScope, this.cVQ).A(new com.baidu.swan.apps.ap.e.b<h<a.C0445a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void I(h<a.C0445a> hVar) {
                    if (!z && !a.this.cWs) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.cVR == null) {
                        a.this.cWr.bQ(10002L).sm("bad Accredit response");
                        a.this.finish();
                        a.this.jr(10002);
                    } else {
                        a.this.cVz = hVar.mData.cVR;
                        a.this.finish();
                    }
                }
            }).aBy();
        } else {
            d.azE().azG().Yq().aah().a(this.mActivity, true, z, new String[]{this.mScope}, this.cVQ, true).A(new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void I(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.cWr.bQ(10002L).sm("bad authorize response");
                        a.this.jr(10002);
                    }
                    a.this.finish();
                }
            }).aBy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.cWu.finish();
        synchronized (cWp) {
            cWp.remove(Z(this.mScope, this.cVT));
        }
        this.cWq = TaskState.FINISHED;
        if (this.cVz == null && 0 == this.cWr.aEc()) {
            if (this.mIsLogin) {
                this.cWr.bQ(10001L);
            } else {
                this.cWr.bQ(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.cqf) {
                    for (com.baidu.swan.apps.ap.e.b bVar : a.this.cqf) {
                        bVar.I(a.this);
                    }
                    a.this.cqf.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aCa()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.cWr));
        if (this.cVz != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.cVz));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.cWq));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.i(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e azJ = e.azJ();
        if (azJ == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d rv = new com.baidu.swan.apps.statistic.a.d().jw(i).a(azJ.XZ()).ru(com.baidu.swan.apps.statistic.h.jv(azJ.XP())).rv(azJ.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", azJ.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gC(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.cVf);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        rv.bN(jSONObject);
        com.baidu.swan.apps.statistic.h.b(rv);
    }

    public static void aCe() {
        synchronized (cWp) {
            cWp.clear();
        }
    }
}
