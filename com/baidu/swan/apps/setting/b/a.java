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
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final Map<String, a> cYt = new HashMap();
    private e bYZ;
    public JSONObject cXD;
    private final String cXU;
    private boolean cXX;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ap.e.b<a>> csm = new HashSet();
    private TaskState cYu = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.am.a cYv = new com.baidu.swan.apps.am.a().bP(8).sH("OpenData");
    private boolean cYw = false;
    private boolean cYx = false;
    private final com.baidu.swan.apps.ap.d.a cYy = new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ap.e.b<a> bVar) {
        synchronized (cYt) {
            String Z = Z(str, z);
            a aVar = cYt.get(Z);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                cYt.put(Z, aVar2);
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

    public boolean aCK() {
        return TaskState.FINISHED == this.cYu && 0 == this.cYv.aEM() && this.cXD != null;
    }

    public boolean aCL() {
        return TaskState.FINISHED == this.cYu && this.cXD != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.cXU = str2;
        this.cXX = z;
    }

    private a B(com.baidu.swan.apps.ap.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.csm) {
                this.csm.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ap.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.cYu = TaskState.CALLING;
        this.cYw = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.bYZ = e.aAr();
        if (this.bYZ == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.cYv.bR(10001L);
            finish();
            jC(10001);
            return;
        }
        this.bYZ.aAD().cWy.b(this.cYy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.bYZ.aAE().isLogin(this.mActivity);
        aCM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCM() {
        d.aAn().aAp().YZ().aaQ().a(this.mActivity, this.mScope, this.cXU, this.cXX, this.mIsLogin).A(new com.baidu.swan.apps.ap.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void J(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.cYv.bR(10001L);
                    a.this.finish();
                    a.this.jC(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.cYv.bR(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.cYv.sH(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.cYv.aEI()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.cYv.bR(10001L);
                    a.this.finish();
                    a.this.jC(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.cYv.bR(10001L);
                    a.this.finish();
                    a.this.jC(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bH = com.baidu.swan.apps.setting.oauth.e.bH(optJSONObject.optJSONObject("scope"));
                if (bH == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.cYv.bR(10001L);
                    a.this.finish();
                    a.this.jC(10001);
                    return;
                }
                a.this.cXD = optJSONObject.optJSONObject("opendata");
                if (!a.this.cXX && bH.cXo < 0) {
                    if (bH.cXo == -2) {
                        a.this.cYv.bR(10006L);
                    } else {
                        a.this.cYv.bR(10005L);
                        a.this.a(10005, bH);
                    }
                    a.this.finish();
                } else if (bH.cXo <= 0) {
                    if (!a.this.bYZ.acu()) {
                        if (!a.this.mIsLogin && bH.aCq()) {
                            if (!TextUtils.equals(bH.id, "mobile") || f.bVX.acj()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aCN();
                                return;
                            }
                        } else if (!TextUtils.equals(bH.id, "mobile") || !a.this.cYx) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.bYZ, bH, a.this.cXD, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.cYv.bR(10003L);
                                    }
                                    a.this.fN(z);
                                }
                            });
                            return;
                        } else {
                            a.this.fN(true);
                            return;
                        }
                    }
                    a.this.cYv.bR(10005L);
                    a.this.finish();
                    a.this.a(10005, bH);
                } else {
                    a.this.cXD = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aCi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCN() {
        com.baidu.swan.apps.t.a.apz().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.cYv.bR(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cYv.bR(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.cYx = true;
                        a.this.aCM();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.bYZ.aAE().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.cYv.bR(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cYv.bR(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aCM();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(final boolean z) {
        if (TextUtils.isEmpty(this.cXU)) {
            d.aAn().aAp().YZ().aaQ().a(this.mActivity, z, this.mScope, this.cXU).A(new com.baidu.swan.apps.ap.e.b<h<a.C0440a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void J(h<a.C0440a> hVar) {
                    if (!z && !a.this.cYw) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.cXV == null) {
                        a.this.cYv.bR(10002L).sH("bad Accredit response");
                        a.this.finish();
                        a.this.jC(10002);
                    } else {
                        a.this.cXD = hVar.mData.cXV;
                        a.this.finish();
                    }
                }
            }).aCi();
        } else {
            d.aAn().aAp().YZ().aaQ().a(this.mActivity, true, z, new String[]{this.mScope}, this.cXU, true).A(new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void J(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.cYv.bR(10002L).sH("bad authorize response");
                        a.this.jC(10002);
                    }
                    a.this.finish();
                }
            }).aCi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.cYy.finish();
        synchronized (cYt) {
            cYt.remove(Z(this.mScope, this.cXX));
        }
        this.cYu = TaskState.FINISHED;
        if (this.cXD == null && 0 == this.cYv.aEM()) {
            if (this.mIsLogin) {
                this.cYv.bR(10001L);
            } else {
                this.cYv.bR(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.csm) {
                    for (com.baidu.swan.apps.ap.e.b bVar : a.this.csm) {
                        bVar.J(a.this);
                    }
                    a.this.csm.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aCK()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.cYv));
        if (this.cXD != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.cXD));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.cYu));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jC(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.i(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e aAs = e.aAs();
        if (aAs == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d rP = new com.baidu.swan.apps.statistic.a.d().jH(i).a(aAs.YI()).rO(com.baidu.swan.apps.statistic.h.jG(aAs.Yy())).rP(aAs.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aAs.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gL(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.cXj);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        rP.bQ(jSONObject);
        com.baidu.swan.apps.statistic.h.b(rP);
    }

    public static void aCO() {
        synchronized (cYt) {
            cYt.clear();
        }
    }
}
