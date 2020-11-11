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
    private static final Map<String, a> dyX = new HashMap();
    private e czM;
    private boolean dyB;
    public JSONObject dyh;
    private final String dyy;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ap.e.b<a>> cSM = new HashSet();
    private TaskState dyY = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.am.a dyZ = new com.baidu.swan.apps.am.a().cv(8).ua("OpenData");
    private boolean dza = false;
    private boolean dzb = false;
    private final com.baidu.swan.apps.ap.d.a dzc = new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ap.e.b<a> bVar) {
        synchronized (dyX) {
            String af = af(str, z);
            a aVar = dyX.get(af);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                dyX.put(af, aVar2);
                aVar2.C(bVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar.toString());
                aVar.B(bVar);
            }
        }
    }

    private static String af(String str, boolean z) {
        return str + "/" + (z ? "1" : "0");
    }

    public boolean aJN() {
        return TaskState.FINISHED == this.dyY && 0 == this.dyZ.aLP() && this.dyh != null;
    }

    public boolean aJO() {
        return TaskState.FINISHED == this.dyY && this.dyh != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dyy = str2;
        this.dyB = z;
    }

    private a B(com.baidu.swan.apps.ap.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.cSM) {
                this.cSM.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ap.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.dyY = TaskState.CALLING;
        this.dza = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.czM = e.aHu();
        if (this.czM == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.dyZ.cx(10001L);
            finish();
            ku(10001);
            return;
        }
        this.czM.aHG().dxc.b(this.dzc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.czM.aHH().isLogin(this.mActivity);
        aJP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJP() {
        d.aHq().aHs().agf().ahW().a(this.mActivity, this.mScope, this.dyy, this.dyB, this.mIsLogin).A(new com.baidu.swan.apps.ap.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.dyZ.cx(10001L);
                    a.this.finish();
                    a.this.ku(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.dyZ.cx(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.dyZ.ua(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.dyZ.aLL()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.dyZ.cx(10001L);
                    a.this.finish();
                    a.this.ku(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.dyZ.cx(10001L);
                    a.this.finish();
                    a.this.ku(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bX = com.baidu.swan.apps.setting.oauth.e.bX(optJSONObject.optJSONObject("scope"));
                if (bX == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.dyZ.cx(10001L);
                    a.this.finish();
                    a.this.ku(10001);
                    return;
                }
                a.this.dyh = optJSONObject.optJSONObject("opendata");
                if (!a.this.dyB && bX.dxS < 0) {
                    if (bX.dxS == -2) {
                        a.this.dyZ.cx(10006L);
                    } else {
                        a.this.dyZ.cx(10005L);
                        a.this.a(10005, bX);
                    }
                    a.this.finish();
                } else if (bX.dxS <= 0) {
                    if (!a.this.czM.ajA()) {
                        if (!a.this.mIsLogin && bX.aJt()) {
                            if (!TextUtils.equals(bX.id, "mobile") || f.cwK.ajp()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aJQ();
                                return;
                            }
                        } else if (!TextUtils.equals(bX.id, "mobile") || !a.this.dzb) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.czM, bX, a.this.dyh, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.dyZ.cx(10003L);
                                    }
                                    a.this.gF(z);
                                }
                            });
                            return;
                        } else {
                            a.this.gF(true);
                            return;
                        }
                    }
                    a.this.dyZ.cx(10005L);
                    a.this.finish();
                    a.this.a(10005, bX);
                } else {
                    a.this.dyh = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aJl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJQ() {
        com.baidu.swan.apps.t.a.awF().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dyZ.cx(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dyZ.cx(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.dzb = true;
                        a.this.aJP();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.czM.aHH().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dyZ.cx(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dyZ.cx(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aJP();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(final boolean z) {
        if (TextUtils.isEmpty(this.dyy)) {
            d.aHq().aHs().agf().ahW().a(this.mActivity, z, this.mScope, this.dyy).A(new com.baidu.swan.apps.ap.e.b<h<a.C0483a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<a.C0483a> hVar) {
                    if (!z && !a.this.dza) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.dyz == null) {
                        a.this.dyZ.cx(10002L).ua("bad Accredit response");
                        a.this.finish();
                        a.this.ku(10002);
                    } else {
                        a.this.dyh = hVar.mData.dyz;
                        a.this.finish();
                    }
                }
            }).aJl();
        } else {
            d.aHq().aHs().agf().ahW().a(this.mActivity, true, z, new String[]{this.mScope}, this.dyy, true).A(new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.dyZ.cx(10002L).ua("bad authorize response");
                        a.this.ku(10002);
                    }
                    a.this.finish();
                }
            }).aJl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.dzc.finish();
        synchronized (dyX) {
            dyX.remove(af(this.mScope, this.dyB));
        }
        this.dyY = TaskState.FINISHED;
        if (this.dyh == null && 0 == this.dyZ.aLP()) {
            if (this.mIsLogin) {
                this.dyZ.cx(10001L);
            } else {
                this.dyZ.cx(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.cSM) {
                    for (com.baidu.swan.apps.ap.e.b bVar : a.this.cSM) {
                        bVar.M(a.this);
                    }
                    a.this.cSM.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aJN()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.dyZ));
        if (this.dyh != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.dyh));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.dyY));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ku(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.k(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e aHv = e.aHv();
        if (aHv == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d tj = new com.baidu.swan.apps.statistic.a.d().kz(i).a(aHv.afO()).ti(com.baidu.swan.apps.statistic.h.ky(aHv.afE())).tj(aHv.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aHv.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.hD(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.dxN);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        tj.cg(jSONObject);
        com.baidu.swan.apps.statistic.h.b(tj);
    }

    public static void aJR() {
        synchronized (dyX) {
            dyX.clear();
        }
    }
}
