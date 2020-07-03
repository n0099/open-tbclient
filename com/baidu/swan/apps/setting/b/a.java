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
    private static final Map<String, a> cKc = new HashMap();
    private e bQB;
    private final String cJD;
    private boolean cJG;
    public JSONObject cJq;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.aq.e.b<a>> cze = new HashSet();
    private TaskState cKd = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.an.a cKe = new com.baidu.swan.apps.an.a().bw(8).pB("OpenData");
    private boolean cKf = false;
    private boolean cKg = false;
    private final com.baidu.swan.apps.aq.d.a cKh = new com.baidu.swan.apps.aq.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.aq.e.b<a> bVar) {
        synchronized (cKc) {
            String V = V(str, z);
            a aVar = cKc.get(V);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                cKc.put(V, aVar2);
                aVar2.s(bVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar.toString());
                aVar.r(bVar);
            }
        }
    }

    private static String V(String str, boolean z) {
        return str + "/" + (z ? "1" : "0");
    }

    public boolean arV() {
        return TaskState.FINISHED == this.cKd && 0 == this.cKe.atS() && this.cJq != null;
    }

    public boolean arW() {
        return TaskState.FINISHED == this.cKd && this.cJq != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.cJD = str2;
        this.cJG = z;
    }

    private a r(com.baidu.swan.apps.aq.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.cze) {
                this.cze.add(bVar);
            }
        }
        return this;
    }

    private void s(com.baidu.swan.apps.aq.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.cKd = TaskState.CALLING;
        this.cKf = TextUtils.equals(this.mScope, "snsapi_userinfo");
        r(bVar);
        this.bQB = e.apM();
        if (this.bQB == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.cKe.by(10001L);
            finish();
            hb(10001);
            return;
        }
        this.bQB.apY().cIo.b(this.cKh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.bQB.apZ().isLogin(this.mActivity);
        arX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arX() {
        d.apI().apK().Se().TF().a(this.mActivity, this.mScope, this.cJD, this.cJG, this.mIsLogin).q(new com.baidu.swan.apps.aq.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.cKe.by(10001L);
                    a.this.finish();
                    a.this.hb(10001);
                    return;
                }
                c.i("OpenData", hVar.mData.toString());
                a.this.cKe.by(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.cKe.pB(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.cKe.atO()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.cKe.by(10001L);
                    a.this.finish();
                    a.this.hb(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.cKe.by(10001L);
                    a.this.finish();
                    a.this.hb(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e br = com.baidu.swan.apps.setting.oauth.e.br(optJSONObject.optJSONObject("scope"));
                if (br == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.cKe.by(10001L);
                    a.this.finish();
                    a.this.hb(10001);
                    return;
                }
                a.this.cJq = optJSONObject.optJSONObject("opendata");
                if (!a.this.cJG && br.cJe < 0) {
                    if (br.cJe == -2) {
                        a.this.cKe.by(10006L);
                    } else {
                        a.this.cKe.by(10005L);
                        a.this.a(10005, br);
                    }
                    a.this.finish();
                } else if (br.cJe <= 0) {
                    if (!a.this.bQB.Va()) {
                        if (!a.this.mIsLogin && br.arG()) {
                            if (TextUtils.equals(br.id, "mobile")) {
                                a.this.arY();
                                return;
                            } else {
                                a.this.login();
                                return;
                            }
                        } else if (!TextUtils.equals(br.id, "mobile") || !a.this.cKg) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.bQB, br, a.this.cJq, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.cKe.by(10003L);
                                    }
                                    a.this.fm(z);
                                }
                            });
                            return;
                        } else {
                            a.this.fm(true);
                            return;
                        }
                    }
                    a.this.cKe.by(10005L);
                    a.this.finish();
                    a.this.a(10005, br);
                } else {
                    a.this.cJq = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).ary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arY() {
        com.baidu.swan.apps.u.a.agc().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.cKe.by(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cKe.by(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.cKg = true;
                        a.this.arX();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.bQB.apZ().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.cKe.by(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.cKe.by(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.arX();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(final boolean z) {
        if (TextUtils.isEmpty(this.cJD)) {
            d.apI().apK().Se().TF().a(this.mActivity, z, this.mScope, this.cJD).q(new com.baidu.swan.apps.aq.e.b<h<a.C0393a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<a.C0393a> hVar) {
                    if (!z && !a.this.cKf) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.cJE == null) {
                        a.this.cKe.by(10002L).pB("bad Accredit response");
                        a.this.finish();
                        a.this.hb(10002);
                    } else {
                        a.this.cJq = hVar.mData.cJE;
                        a.this.finish();
                    }
                }
            }).ary();
        } else {
            d.apI().apK().Se().TF().a(this.mActivity, true, z, new String[]{this.mScope}, this.cJD, true).q(new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.cKe.by(10002L).pB("bad authorize response");
                        a.this.hb(10002);
                    }
                    a.this.finish();
                }
            }).ary();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.cKh.finish();
        synchronized (cKc) {
            cKc.remove(V(this.mScope, this.cJG));
        }
        this.cKd = TaskState.FINISHED;
        if (this.cJq == null && 0 == this.cKe.atS()) {
            if (this.mIsLogin) {
                this.cKe.by(10001L);
            } else {
                this.cKe.by(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.k(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.cze) {
                    for (com.baidu.swan.apps.aq.e.b bVar : a.this.cze) {
                        bVar.H(a.this);
                    }
                    a.this.cze.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(arV()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.cKe));
        if (this.cJq != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.cJq));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.cKd));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hb(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.i(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e apN = e.apN();
        if (apN == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d oL = new com.baidu.swan.apps.statistic.a.d().hg(i).a(apN.RP()).oK(com.baidu.swan.apps.statistic.h.hf(apN.RF())).oL(apN.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", apN.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gZ(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.cIZ);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        oL.bA(jSONObject);
        com.baidu.swan.apps.statistic.h.b(oL);
    }
}
