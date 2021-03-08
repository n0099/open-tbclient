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
    private static final Map<String, a> dLM = new HashMap();
    private e cIT;
    public JSONObject dKW;
    private final String dLn;
    private boolean dLq;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ao.e.b<a>> dbO = new HashSet();
    private TaskState dLN = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.al.a dLO = new com.baidu.swan.apps.al.a().db(8).tO("OpenData");
    private boolean dLP = false;
    private boolean dLQ = false;
    private final com.baidu.swan.apps.ao.d.a dLR = new com.baidu.swan.apps.ao.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ao.e.b<a> bVar) {
        synchronized (dLM) {
            String af = af(str, z);
            a aVar = dLM.get(af);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                dLM.put(af, aVar2);
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

    public boolean aLg() {
        return TaskState.FINISHED == this.dLN && 0 == this.dLO.aNi() && this.dKW != null;
    }

    public boolean aLh() {
        return TaskState.FINISHED == this.dLN && this.dKW != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dLn = str2;
        this.dLq = z;
    }

    private a B(com.baidu.swan.apps.ao.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.dbO) {
                this.dbO.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ao.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.dLN = TaskState.CALLING;
        this.dLP = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.cIT = e.aIN();
        if (this.cIT == null) {
            com.baidu.swan.apps.setting.oauth.c.d("SwanApp is null", true);
            this.dLO.dd(10001L);
            finish();
            js(10001);
            return;
        }
        this.cIT.aIZ().dJR.b(this.dLR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.cIT.aJa().isLogin(this.mActivity);
        aLi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLi() {
        d.aIJ().aIL().agv().aio().a(this.mActivity, this.mScope, this.dLn, this.dLq, this.mIsLogin).A(new com.baidu.swan.apps.ao.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.d("bad MaOpenData response", true);
                    a.this.dLO.dd(10001L);
                    a.this.finish();
                    a.this.js(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.dLO.dd(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.dLO.tO(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.dLO.aNe()) {
                    com.baidu.swan.apps.setting.oauth.c.d("by errno", true);
                    a.this.dLO.dd(10001L);
                    a.this.finish();
                    a.this.js(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.d("by data parse", true);
                    a.this.dLO.dd(10001L);
                    a.this.finish();
                    a.this.js(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e ca = com.baidu.swan.apps.setting.oauth.e.ca(optJSONObject.optJSONObject("scope"));
                if (ca == null) {
                    com.baidu.swan.apps.setting.oauth.c.d("illegal scope", true);
                    a.this.dLO.dd(10001L);
                    a.this.finish();
                    a.this.js(10001);
                    return;
                }
                a.this.dKW = optJSONObject.optJSONObject("opendata");
                if (!a.this.dLq && ca.dKH < 0) {
                    if (ca.dKH == -2) {
                        a.this.dLO.dd(10006L);
                    } else {
                        a.this.dLO.dd(10005L);
                        a.this.a(10005, ca);
                    }
                    a.this.finish();
                } else if (ca.dKH <= 0) {
                    if (!a.this.cIT.ajS()) {
                        if (!a.this.mIsLogin && ca.aKM()) {
                            if (!TextUtils.equals(ca.id, "mobile") || f.cFS.ajH()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aLj();
                                return;
                            }
                        } else if (!TextUtils.equals(ca.id, "mobile") || !a.this.dLQ) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.cIT, ca, a.this.dKW, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.dLO.dd(10003L);
                                    }
                                    a.this.hn(z);
                                }
                            });
                            return;
                        } else {
                            a.this.hn(true);
                            return;
                        }
                    }
                    a.this.dLO.dd(10005L);
                    a.this.finish();
                    a.this.a(10005, ca);
                } else {
                    a.this.dKW = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aKE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLj() {
        com.baidu.swan.apps.t.a.axe().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.d("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.d("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dLO.dd(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.d("login error ERR_BY_LOGIN", true);
                        a.this.dLO.dd(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.d("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.dLQ = true;
                        a.this.aLi();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.cIT.aJa().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.d("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.d("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dLO.dd(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.d("login error ERR_BY_LOGIN", true);
                        a.this.dLO.dd(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.d("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aLi();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(final boolean z) {
        if (TextUtils.isEmpty(this.dLn)) {
            d.aIJ().aIL().agv().aio().a(this.mActivity, z, this.mScope, this.dLn).A(new com.baidu.swan.apps.ao.e.b<h<a.C0472a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void N(h<a.C0472a> hVar) {
                    if (!z && !a.this.dLP) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.dLo == null) {
                        a.this.dLO.dd(10002L).tO("bad Accredit response");
                        a.this.finish();
                        a.this.js(10002);
                    } else {
                        a.this.dKW = hVar.mData.dLo;
                        a.this.finish();
                    }
                }
            }).aKE();
        } else {
            d.aIJ().aIL().agv().aio().a(this.mActivity, true, z, new String[]{this.mScope}, this.dLn, true).A(new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void N(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.dLO.dd(10002L).tO("bad authorize response");
                        a.this.js(10002);
                    }
                    a.this.finish();
                }
            }).aKE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.dLR.finish();
        synchronized (dLM) {
            dLM.remove(af(this.mScope, this.dLq));
        }
        this.dLN = TaskState.FINISHED;
        if (this.dKW == null && 0 == this.dLO.aNi()) {
            if (this.mIsLogin) {
                this.dLO.dd(10001L);
            } else {
                this.dLO.dd(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.e(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.dbO) {
                    for (com.baidu.swan.apps.ao.e.b bVar : a.this.dbO) {
                        bVar.N(a.this);
                    }
                    a.this.dbO.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aLg()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.dLO));
        if (this.dKW != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.dKW));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.dLN));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.m(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e aIO = e.aIO();
        if (aIO == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d sX = new com.baidu.swan.apps.statistic.a.d().jw(i).a(aIO.agc()).sW(com.baidu.swan.apps.statistic.h.jv(aIO.getFrameType())).sX(aIO.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aIO.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gp(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.dKC);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        sX.cj(jSONObject);
        com.baidu.swan.apps.statistic.h.b(sX);
    }

    public static void aLk() {
        synchronized (dLM) {
            dLM.clear();
        }
    }
}
