package com.baidu.swan.apps.setting.b;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.swan.apps.b;
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
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final Map<String, a> cFs = new HashMap();
    private e bLN;
    public JSONObject cEG;
    private final String cET;
    private boolean cEW;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.aq.e.b<a>> cus = new HashSet();
    private TaskState cFt = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.an.a cFu = new com.baidu.swan.apps.an.a().bw(8).pt("OpenData");
    private boolean cFv = false;
    private boolean cFw = false;
    private final com.baidu.swan.apps.aq.d.a cFx = new com.baidu.swan.apps.aq.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.aq.e.b<a> bVar) {
        synchronized (cFs) {
            String T = T(str, z);
            a aVar = cFs.get(T);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                cFs.put(T, aVar2);
                aVar2.s(bVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar.toString());
                aVar.r(bVar);
            }
        }
    }

    private static String T(String str, boolean z) {
        return str + "/" + (z ? "1" : "0");
    }

    public boolean aqP() {
        return TaskState.FINISHED == this.cFt && 0 == this.cFu.asM() && this.cEG != null;
    }

    public boolean aqQ() {
        return TaskState.FINISHED == this.cFt && this.cEG != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.cET = str2;
        this.cEW = z;
    }

    private a r(com.baidu.swan.apps.aq.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.cus) {
                this.cus.add(bVar);
            }
        }
        return this;
    }

    private void s(com.baidu.swan.apps.aq.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.cFt = TaskState.CALLING;
        this.cFv = TextUtils.equals(this.mScope, "snsapi_userinfo");
        r(bVar);
        this.bLN = e.aoF();
        if (this.bLN == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.cFu.by(10001L);
            finish();
            gO(10001);
            return;
        }
        this.bLN.aoR().cDE.b(this.cFx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.bLN.aoS().isLogin(this.mActivity);
        aqR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqR() {
        d.aoB().aoD().QY().Sz().a(this.mActivity, this.mScope, this.cET, this.cEW, this.mIsLogin).q(new com.baidu.swan.apps.aq.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.cFu.by(10001L);
                    a.this.finish();
                    a.this.gO(10001);
                    return;
                }
                c.i("OpenData", hVar.mData.toString());
                a.this.cFu.by(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.cFu.pt(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.cFu.asI()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.cFu.by(10001L);
                    a.this.finish();
                    a.this.gO(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.cFu.by(10001L);
                    a.this.finish();
                    a.this.gO(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bk = com.baidu.swan.apps.setting.oauth.e.bk(optJSONObject.optJSONObject("scope"));
                if (bk == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.cFu.by(10001L);
                    a.this.finish();
                    a.this.gO(10001);
                    return;
                }
                a.this.cEG = optJSONObject.optJSONObject("opendata");
                if (!a.this.cEW && bk.cEu < 0) {
                    if (bk.cEu == -2) {
                        a.this.cFu.by(10006L);
                    } else {
                        a.this.cFu.by(10005L);
                        a.this.a(10005, bk);
                    }
                    a.this.finish();
                } else if (bk.cEu <= 0) {
                    if (!a.this.bLN.TU()) {
                        if (!a.this.mIsLogin && bk.aqA()) {
                            if (TextUtils.equals(bk.id, "mobile")) {
                                a.this.aqS();
                                return;
                            } else {
                                a.this.login();
                                return;
                            }
                        } else if (!TextUtils.equals(bk.id, "mobile") || !a.this.cFw) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.bLN, bk, a.this.cEG, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.cFu.by(10003L);
                                    }
                                    a.this.fh(z);
                                }
                            });
                            return;
                        } else {
                            a.this.fh(true);
                            return;
                        }
                    }
                    a.this.cFu.by(10005L);
                    a.this.finish();
                    a.this.a(10005, bk);
                } else {
                    a.this.cEG = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aqs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqS() {
        com.baidu.swan.apps.u.a.aeW().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.cFu.by(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cFu.by(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.cFw = true;
                        a.this.aqR();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.bLN.aoS().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.cFu.by(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cFu.by(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aqR();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(final boolean z) {
        if (TextUtils.isEmpty(this.cET)) {
            d.aoB().aoD().QY().Sz().a(this.mActivity, z, this.mScope, this.cET).q(new com.baidu.swan.apps.aq.e.b<h<a.C0387a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<a.C0387a> hVar) {
                    if (!z && !a.this.cFv) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.cEU == null) {
                        a.this.cFu.by(10002L).pt("bad Accredit response");
                        a.this.finish();
                        a.this.gO(10002);
                    } else {
                        a.this.cEG = hVar.mData.cEU;
                        a.this.finish();
                    }
                }
            }).aqs();
        } else {
            d.aoB().aoD().QY().Sz().a(this.mActivity, true, z, new String[]{this.mScope}, this.cET, true).q(new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.cFu.by(10002L).pt("bad authorize response");
                        a.this.gO(10002);
                    }
                    a.this.finish();
                }
            }).aqs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.cFx.finish();
        synchronized (cFs) {
            cFs.remove(T(this.mScope, this.cEW));
        }
        this.cFt = TaskState.FINISHED;
        if (this.cEG == null && 0 == this.cFu.asM()) {
            if (this.mIsLogin) {
                this.cFu.by(10001L);
            } else {
                this.cFu.by(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.k(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.cus) {
                    for (com.baidu.swan.apps.aq.e.b bVar : a.this.cus) {
                        bVar.H(a.this);
                    }
                    a.this.cus.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aqP()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.cFu));
        if (this.cEG != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.cEG));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.cFt));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.i(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e aoG = e.aoG();
        if (aoG == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d oD = new com.baidu.swan.apps.statistic.a.d().gT(i).a(aoG.QJ()).oC(com.baidu.swan.apps.statistic.h.gS(aoG.Qz())).oD(aoG.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aoG.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gM(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.cEp);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        oD.bt(jSONObject);
        com.baidu.swan.apps.statistic.h.b(oD);
    }
}
