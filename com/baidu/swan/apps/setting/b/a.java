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
    private static final Map<String, a> cWt = new HashMap();
    private e bWY;
    public JSONObject cVD;
    private final String cVU;
    private boolean cVX;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ap.e.b<a>> cqj = new HashSet();
    private TaskState cWu = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.am.a cWv = new com.baidu.swan.apps.am.a().bO(8).sn("OpenData");
    private boolean cWw = false;
    private boolean cWx = false;
    private final com.baidu.swan.apps.ap.d.a cWy = new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ap.e.b<a> bVar) {
        synchronized (cWt) {
            String Z = Z(str, z);
            a aVar = cWt.get(Z);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                cWt.put(Z, aVar2);
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
        return TaskState.FINISHED == this.cWu && 0 == this.cWv.aEc() && this.cVD != null;
    }

    public boolean aCb() {
        return TaskState.FINISHED == this.cWu && this.cVD != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.cVU = str2;
        this.cVX = z;
    }

    private a B(com.baidu.swan.apps.ap.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.cqj) {
                this.cqj.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ap.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.cWu = TaskState.CALLING;
        this.cWw = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.bWY = e.azI();
        if (this.bWY == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.cWv.bQ(10001L);
            finish();
            jr(10001);
            return;
        }
        this.bWY.azU().cUy.b(this.cWy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.bWY.azV().isLogin(this.mActivity);
        aCc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCc() {
        d.azE().azG().Yq().aah().a(this.mActivity, this.mScope, this.cVU, this.cVX, this.mIsLogin).A(new com.baidu.swan.apps.ap.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void I(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.cWv.bQ(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.cWv.bQ(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.cWv.sn(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.cWv.aDY()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.cWv.bQ(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.cWv.bQ(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bE = com.baidu.swan.apps.setting.oauth.e.bE(optJSONObject.optJSONObject("scope"));
                if (bE == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.cWv.bQ(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                a.this.cVD = optJSONObject.optJSONObject("opendata");
                if (!a.this.cVX && bE.cVo < 0) {
                    if (bE.cVo == -2) {
                        a.this.cWv.bQ(10006L);
                    } else {
                        a.this.cWv.bQ(10005L);
                        a.this.a(10005, bE);
                    }
                    a.this.finish();
                } else if (bE.cVo <= 0) {
                    if (!a.this.bWY.abL()) {
                        if (!a.this.mIsLogin && bE.aBG()) {
                            if (!TextUtils.equals(bE.id, "mobile") || f.bTW.abA()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aCd();
                                return;
                            }
                        } else if (!TextUtils.equals(bE.id, "mobile") || !a.this.cWx) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.bWY, bE, a.this.cVD, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.cWv.bQ(10003L);
                                    }
                                    a.this.fP(z);
                                }
                            });
                            return;
                        } else {
                            a.this.fP(true);
                            return;
                        }
                    }
                    a.this.cWv.bQ(10005L);
                    a.this.finish();
                    a.this.a(10005, bE);
                } else {
                    a.this.cVD = optJSONObject.optJSONObject("opendata");
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
                        a.this.cWv.bQ(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cWv.bQ(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.cWx = true;
                        a.this.aCc();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.bWY.azV().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.cWv.bQ(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cWv.bQ(10004L);
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
    public void fP(final boolean z) {
        if (TextUtils.isEmpty(this.cVU)) {
            d.azE().azG().Yq().aah().a(this.mActivity, z, this.mScope, this.cVU).A(new com.baidu.swan.apps.ap.e.b<h<a.C0445a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void I(h<a.C0445a> hVar) {
                    if (!z && !a.this.cWw) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.cVV == null) {
                        a.this.cWv.bQ(10002L).sn("bad Accredit response");
                        a.this.finish();
                        a.this.jr(10002);
                    } else {
                        a.this.cVD = hVar.mData.cVV;
                        a.this.finish();
                    }
                }
            }).aBy();
        } else {
            d.azE().azG().Yq().aah().a(this.mActivity, true, z, new String[]{this.mScope}, this.cVU, true).A(new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void I(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.cWv.bQ(10002L).sn("bad authorize response");
                        a.this.jr(10002);
                    }
                    a.this.finish();
                }
            }).aBy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.cWy.finish();
        synchronized (cWt) {
            cWt.remove(Z(this.mScope, this.cVX));
        }
        this.cWu = TaskState.FINISHED;
        if (this.cVD == null && 0 == this.cWv.aEc()) {
            if (this.mIsLogin) {
                this.cWv.bQ(10001L);
            } else {
                this.cWv.bQ(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.cqj) {
                    for (com.baidu.swan.apps.ap.e.b bVar : a.this.cqj) {
                        bVar.I(a.this);
                    }
                    a.this.cqj.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aCa()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.cWv));
        if (this.cVD != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.cVD));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.cWu));
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
        com.baidu.swan.apps.statistic.a.d rw = new com.baidu.swan.apps.statistic.a.d().jw(i).a(azJ.XZ()).rv(com.baidu.swan.apps.statistic.h.jv(azJ.XP())).rw(azJ.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", azJ.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gC(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.cVj);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        rw.bN(jSONObject);
        com.baidu.swan.apps.statistic.h.b(rw);
    }

    public static void aCe() {
        synchronized (cWt) {
            cWt.clear();
        }
    }
}
