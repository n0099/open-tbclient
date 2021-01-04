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
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final Map<String, a> dMT = new HashMap();
    private e cJK;
    public JSONObject dMd;
    private final String dMu;
    private boolean dMx;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ao.e.b<a>> dcQ = new HashSet();
    private TaskState dMU = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.al.a dMV = new com.baidu.swan.apps.al.a().cV(8).uz("OpenData");
    private boolean dMW = false;
    private boolean dMX = false;
    private final com.baidu.swan.apps.ao.d.a dMY = new com.baidu.swan.apps.ao.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ao.e.b<a> bVar) {
        synchronized (dMT) {
            String ag = ag(str, z);
            a aVar = dMT.get(ag);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                dMT.put(ag, aVar2);
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

    public boolean aOD() {
        return TaskState.FINISHED == this.dMU && 0 == this.dMV.aQF() && this.dMd != null;
    }

    public boolean aOE() {
        return TaskState.FINISHED == this.dMU && this.dMd != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dMu = str2;
        this.dMx = z;
    }

    private a B(com.baidu.swan.apps.ao.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.dcQ) {
                this.dcQ.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ao.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.dMU = TaskState.CALLING;
        this.dMW = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.cJK = e.aMk();
        if (this.cJK == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.dMV.cX(10001L);
            finish();
            kU(10001);
            return;
        }
        this.cJK.aMw().dKY.b(this.dMY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.cJK.aMx().isLogin(this.mActivity);
        aOF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOF() {
        d.aMg().aMi().ajN().alG().a(this.mActivity, this.mScope, this.dMu, this.dMx, this.mIsLogin).A(new com.baidu.swan.apps.ao.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.dMV.cX(10001L);
                    a.this.finish();
                    a.this.kU(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.dMV.cX(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.dMV.uz(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.dMV.aQB()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.dMV.cX(10001L);
                    a.this.finish();
                    a.this.kU(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.dMV.cX(10001L);
                    a.this.finish();
                    a.this.kU(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e cb = com.baidu.swan.apps.setting.oauth.e.cb(optJSONObject.optJSONObject("scope"));
                if (cb == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.dMV.cX(10001L);
                    a.this.finish();
                    a.this.kU(10001);
                    return;
                }
                a.this.dMd = optJSONObject.optJSONObject("opendata");
                if (!a.this.dMx && cb.dLO < 0) {
                    if (cb.dLO == -2) {
                        a.this.dMV.cX(10006L);
                    } else {
                        a.this.dMV.cX(10005L);
                        a.this.a(10005, cb);
                    }
                    a.this.finish();
                } else if (cb.dLO <= 0) {
                    if (!a.this.cJK.ank()) {
                        if (!a.this.mIsLogin && cb.aOj()) {
                            if (!TextUtils.equals(cb.id, "mobile") || f.cGI.amZ()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aOG();
                                return;
                            }
                        } else if (!TextUtils.equals(cb.id, "mobile") || !a.this.dMX) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.cJK, cb, a.this.dMd, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.dMV.cX(10003L);
                                    }
                                    a.this.hp(z);
                                }
                            });
                            return;
                        } else {
                            a.this.hp(true);
                            return;
                        }
                    }
                    a.this.dMV.cX(10005L);
                    a.this.finish();
                    a.this.a(10005, cb);
                } else {
                    a.this.dMd = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aOb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOG() {
        com.baidu.swan.apps.t.a.aAw().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dMV.cX(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dMV.cX(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.dMX = true;
                        a.this.aOF();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.cJK.aMx().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dMV.cX(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dMV.cX(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aOF();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp(final boolean z) {
        if (TextUtils.isEmpty(this.dMu)) {
            d.aMg().aMi().ajN().alG().a(this.mActivity, z, this.mScope, this.dMu).A(new com.baidu.swan.apps.ao.e.b<h<a.C0486a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(h<a.C0486a> hVar) {
                    if (!z && !a.this.dMW) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.dMv == null) {
                        a.this.dMV.cX(10002L).uz("bad Accredit response");
                        a.this.finish();
                        a.this.kU(10002);
                    } else {
                        a.this.dMd = hVar.mData.dMv;
                        a.this.finish();
                    }
                }
            }).aOb();
        } else {
            d.aMg().aMi().ajN().alG().a(this.mActivity, true, z, new String[]{this.mScope}, this.dMu, true).A(new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.dMV.cX(10002L).uz("bad authorize response");
                        a.this.kU(10002);
                    }
                    a.this.finish();
                }
            }).aOb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.dMY.finish();
        synchronized (dMT) {
            dMT.remove(ag(this.mScope, this.dMx));
        }
        this.dMU = TaskState.FINISHED;
        if (this.dMd == null && 0 == this.dMV.aQF()) {
            if (this.mIsLogin) {
                this.dMV.cX(10001L);
            } else {
                this.dMV.cX(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.dcQ) {
                    for (com.baidu.swan.apps.ao.e.b bVar : a.this.dcQ) {
                        bVar.L(a.this);
                    }
                    a.this.dcQ.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aOD()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.dMV));
        if (this.dMd != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.dMd));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.dMU));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kU(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.l(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e aMl = e.aMl();
        if (aMl == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d tI = new com.baidu.swan.apps.statistic.a.d().kY(i).a(aMl.aju()).tH(com.baidu.swan.apps.statistic.h.kX(aMl.ajk())).tI(aMl.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aMl.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.hR(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.dLJ);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        tI.ck(jSONObject);
        com.baidu.swan.apps.statistic.h.b(tI);
    }

    public static void aOH() {
        synchronized (dMT) {
            dMT.clear();
        }
    }
}
