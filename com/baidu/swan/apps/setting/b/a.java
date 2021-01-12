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
    private static final Map<String, a> dIh = new HashMap();
    private e cEY;
    private final String dHI;
    private boolean dHL;
    public JSONObject dHr;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ao.e.b<a>> cYb = new HashSet();
    private TaskState dIi = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.al.a dIj = new com.baidu.swan.apps.al.a().cV(8).to("OpenData");
    private boolean dIk = false;
    private boolean dIl = false;
    private final com.baidu.swan.apps.ao.d.a dIm = new com.baidu.swan.apps.ao.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ao.e.b<a> bVar) {
        synchronized (dIh) {
            String ag = ag(str, z);
            a aVar = dIh.get(ag);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                dIh.put(ag, aVar2);
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

    public boolean aKK() {
        return TaskState.FINISHED == this.dIi && 0 == this.dIj.aMM() && this.dHr != null;
    }

    public boolean aKL() {
        return TaskState.FINISHED == this.dIi && this.dHr != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dHI = str2;
        this.dHL = z;
    }

    private a B(com.baidu.swan.apps.ao.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.cYb) {
                this.cYb.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ao.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.dIi = TaskState.CALLING;
        this.dIk = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.cEY = e.aIr();
        if (this.cEY == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.dIj.cX(10001L);
            finish();
            jo(10001);
            return;
        }
        this.cEY.aID().dGm.b(this.dIm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.cEY.aIE().isLogin(this.mActivity);
        aKM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKM() {
        d.aIn().aIp().afU().ahN().a(this.mActivity, this.mScope, this.dHI, this.dHL, this.mIsLogin).A(new com.baidu.swan.apps.ao.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.dIj.cX(10001L);
                    a.this.finish();
                    a.this.jo(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.dIj.cX(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.dIj.to(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.dIj.aMI()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.dIj.cX(10001L);
                    a.this.finish();
                    a.this.jo(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.dIj.cX(10001L);
                    a.this.finish();
                    a.this.jo(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e cb = com.baidu.swan.apps.setting.oauth.e.cb(optJSONObject.optJSONObject("scope"));
                if (cb == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.dIj.cX(10001L);
                    a.this.finish();
                    a.this.jo(10001);
                    return;
                }
                a.this.dHr = optJSONObject.optJSONObject("opendata");
                if (!a.this.dHL && cb.dHc < 0) {
                    if (cb.dHc == -2) {
                        a.this.dIj.cX(10006L);
                    } else {
                        a.this.dIj.cX(10005L);
                        a.this.a(10005, cb);
                    }
                    a.this.finish();
                } else if (cb.dHc <= 0) {
                    if (!a.this.cEY.ajr()) {
                        if (!a.this.mIsLogin && cb.aKq()) {
                            if (!TextUtils.equals(cb.id, "mobile") || f.cBW.ajg()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aKN();
                                return;
                            }
                        } else if (!TextUtils.equals(cb.id, "mobile") || !a.this.dIl) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.cEY, cb, a.this.dHr, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.dIj.cX(10003L);
                                    }
                                    a.this.hl(z);
                                }
                            });
                            return;
                        } else {
                            a.this.hl(true);
                            return;
                        }
                    }
                    a.this.dIj.cX(10005L);
                    a.this.finish();
                    a.this.a(10005, cb);
                } else {
                    a.this.dHr = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aKi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKN() {
        com.baidu.swan.apps.t.a.awD().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dIj.cX(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dIj.cX(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.dIl = true;
                        a.this.aKM();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.cEY.aIE().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dIj.cX(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dIj.cX(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aKM();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl(final boolean z) {
        if (TextUtils.isEmpty(this.dHI)) {
            d.aIn().aIp().afU().ahN().a(this.mActivity, z, this.mScope, this.dHI).A(new com.baidu.swan.apps.ao.e.b<h<a.C0469a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(h<a.C0469a> hVar) {
                    if (!z && !a.this.dIk) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.dHJ == null) {
                        a.this.dIj.cX(10002L).to("bad Accredit response");
                        a.this.finish();
                        a.this.jo(10002);
                    } else {
                        a.this.dHr = hVar.mData.dHJ;
                        a.this.finish();
                    }
                }
            }).aKi();
        } else {
            d.aIn().aIp().afU().ahN().a(this.mActivity, true, z, new String[]{this.mScope}, this.dHI, true).A(new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.dIj.cX(10002L).to("bad authorize response");
                        a.this.jo(10002);
                    }
                    a.this.finish();
                }
            }).aKi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.dIm.finish();
        synchronized (dIh) {
            dIh.remove(ag(this.mScope, this.dHL));
        }
        this.dIi = TaskState.FINISHED;
        if (this.dHr == null && 0 == this.dIj.aMM()) {
            if (this.mIsLogin) {
                this.dIj.cX(10001L);
            } else {
                this.dIj.cX(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.cYb) {
                    for (com.baidu.swan.apps.ao.e.b bVar : a.this.cYb) {
                        bVar.L(a.this);
                    }
                    a.this.cYb.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aKK()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.dIj));
        if (this.dHr != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.dHr));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.dIi));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jo(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.l(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e aIs = e.aIs();
        if (aIs == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d sx = new com.baidu.swan.apps.statistic.a.d().js(i).a(aIs.afB()).sw(com.baidu.swan.apps.statistic.h.jr(aIs.afr())).sx(aIs.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aIs.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gk(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.dGX);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        sx.ck(jSONObject);
        com.baidu.swan.apps.statistic.h.b(sx);
    }

    public static void aKO() {
        synchronized (dIh) {
            dIh.clear();
        }
    }
}
