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
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final Map<String, a> dkD = new HashMap();
    private e clo;
    public JSONObject djN;
    private final String dke;
    private boolean dkh;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ap.e.b<a>> cEx = new HashSet();
    private TaskState dkE = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.am.a dkF = new com.baidu.swan.apps.am.a().bX(8).tt("OpenData");
    private boolean dkG = false;
    private boolean dkH = false;
    private final com.baidu.swan.apps.ap.d.a dkI = new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ap.e.b<a> bVar) {
        synchronized (dkD) {
            String ad = ad(str, z);
            a aVar = dkD.get(ad);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                dkD.put(ad, aVar2);
                aVar2.C(bVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar.toString());
                aVar.B(bVar);
            }
        }
    }

    private static String ad(String str, boolean z) {
        return str + "/" + (z ? "1" : "0");
    }

    public boolean aFt() {
        return TaskState.FINISHED == this.dkE && 0 == this.dkF.aHv() && this.djN != null;
    }

    public boolean aFu() {
        return TaskState.FINISHED == this.dkE && this.djN != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dke = str2;
        this.dkh = z;
    }

    private a B(com.baidu.swan.apps.ap.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.cEx) {
                this.cEx.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ap.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.dkE = TaskState.CALLING;
        this.dkG = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.clo = e.aDa();
        if (this.clo == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.dkF.bZ(10001L);
            finish();
            jZ(10001);
            return;
        }
        this.clo.aDm().diI.b(this.dkI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.clo.aDn().isLogin(this.mActivity);
        aFv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFv() {
        d.aCW().aCY().abL().adC().a(this.mActivity, this.mScope, this.dke, this.dkh, this.mIsLogin).A(new com.baidu.swan.apps.ap.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.dkF.bZ(10001L);
                    a.this.finish();
                    a.this.jZ(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.dkF.bZ(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.dkF.tt(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.dkF.aHr()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.dkF.bZ(10001L);
                    a.this.finish();
                    a.this.jZ(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.dkF.bZ(10001L);
                    a.this.finish();
                    a.this.jZ(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bO = com.baidu.swan.apps.setting.oauth.e.bO(optJSONObject.optJSONObject("scope"));
                if (bO == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.dkF.bZ(10001L);
                    a.this.finish();
                    a.this.jZ(10001);
                    return;
                }
                a.this.djN = optJSONObject.optJSONObject("opendata");
                if (!a.this.dkh && bO.djy < 0) {
                    if (bO.djy == -2) {
                        a.this.dkF.bZ(10006L);
                    } else {
                        a.this.dkF.bZ(10005L);
                        a.this.a(10005, bO);
                    }
                    a.this.finish();
                } else if (bO.djy <= 0) {
                    if (!a.this.clo.afg()) {
                        if (!a.this.mIsLogin && bO.aEZ()) {
                            if (!TextUtils.equals(bO.id, "mobile") || f.cim.aeV()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aFw();
                                return;
                            }
                        } else if (!TextUtils.equals(bO.id, "mobile") || !a.this.dkH) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.clo, bO, a.this.djN, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.dkF.bZ(10003L);
                                    }
                                    a.this.gj(z);
                                }
                            });
                            return;
                        } else {
                            a.this.gj(true);
                            return;
                        }
                    }
                    a.this.dkF.bZ(10005L);
                    a.this.finish();
                    a.this.a(10005, bO);
                } else {
                    a.this.djN = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aER();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFw() {
        com.baidu.swan.apps.t.a.ask().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dkF.bZ(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dkF.bZ(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.dkH = true;
                        a.this.aFv();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.clo.aDn().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dkF.bZ(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dkF.bZ(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aFv();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(final boolean z) {
        if (TextUtils.isEmpty(this.dke)) {
            d.aCW().aCY().abL().adC().a(this.mActivity, z, this.mScope, this.dke).A(new com.baidu.swan.apps.ap.e.b<h<a.C0457a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<a.C0457a> hVar) {
                    if (!z && !a.this.dkG) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.dkf == null) {
                        a.this.dkF.bZ(10002L).tt("bad Accredit response");
                        a.this.finish();
                        a.this.jZ(10002);
                    } else {
                        a.this.djN = hVar.mData.dkf;
                        a.this.finish();
                    }
                }
            }).aER();
        } else {
            d.aCW().aCY().abL().adC().a(this.mActivity, true, z, new String[]{this.mScope}, this.dke, true).A(new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.dkF.bZ(10002L).tt("bad authorize response");
                        a.this.jZ(10002);
                    }
                    a.this.finish();
                }
            }).aER();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.dkI.finish();
        synchronized (dkD) {
            dkD.remove(ad(this.mScope, this.dkh));
        }
        this.dkE = TaskState.FINISHED;
        if (this.djN == null && 0 == this.dkF.aHv()) {
            if (this.mIsLogin) {
                this.dkF.bZ(10001L);
            } else {
                this.dkF.bZ(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.cEx) {
                    for (com.baidu.swan.apps.ap.e.b bVar : a.this.cEx) {
                        bVar.M(a.this);
                    }
                    a.this.cEx.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aFt()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.dkF));
        if (this.djN != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.djN));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.dkE));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jZ(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.i(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e aDb = e.aDb();
        if (aDb == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d sC = new com.baidu.swan.apps.statistic.a.d().ke(i).a(aDb.abu()).sB(com.baidu.swan.apps.statistic.h.kd(aDb.abk())).sC(aDb.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aDb.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.hi(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.djt);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        sC.bX(jSONObject);
        com.baidu.swan.apps.statistic.h.b(sC);
    }

    public static void aFx() {
        synchronized (dkD) {
            dkD.clear();
        }
    }
}
