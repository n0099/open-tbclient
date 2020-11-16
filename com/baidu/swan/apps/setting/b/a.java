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
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final Map<String, a> dxq = new HashMap();
    private e cyc;
    public JSONObject dwA;
    private final String dwR;
    private boolean dwU;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ap.e.b<a>> cRc = new HashSet();
    private TaskState dxr = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.am.a dxs = new com.baidu.swan.apps.am.a().cv(8).tV("OpenData");
    private boolean dxt = false;
    private boolean dxu = false;
    private final com.baidu.swan.apps.ap.d.a dxv = new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ap.e.b<a> bVar) {
        synchronized (dxq) {
            String af = af(str, z);
            a aVar = dxq.get(af);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                dxq.put(af, aVar2);
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

    public boolean aJf() {
        return TaskState.FINISHED == this.dxr && 0 == this.dxs.aLh() && this.dwA != null;
    }

    public boolean aJg() {
        return TaskState.FINISHED == this.dxr && this.dwA != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dwR = str2;
        this.dwU = z;
    }

    private a B(com.baidu.swan.apps.ap.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.cRc) {
                this.cRc.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ap.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.dxr = TaskState.CALLING;
        this.dxt = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.cyc = e.aGM();
        if (this.cyc == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.dxs.cx(10001L);
            finish();
            kq(10001);
            return;
        }
        this.cyc.aGY().dvv.b(this.dxv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.cyc.aGZ().isLogin(this.mActivity);
        aJh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJh() {
        d.aGI().aGK().afx().aho().a(this.mActivity, this.mScope, this.dwR, this.dwU, this.mIsLogin).A(new com.baidu.swan.apps.ap.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.dxs.cx(10001L);
                    a.this.finish();
                    a.this.kq(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.dxs.cx(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.dxs.tV(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.dxs.aLd()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.dxs.cx(10001L);
                    a.this.finish();
                    a.this.kq(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.dxs.cx(10001L);
                    a.this.finish();
                    a.this.kq(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bR = com.baidu.swan.apps.setting.oauth.e.bR(optJSONObject.optJSONObject("scope"));
                if (bR == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.dxs.cx(10001L);
                    a.this.finish();
                    a.this.kq(10001);
                    return;
                }
                a.this.dwA = optJSONObject.optJSONObject("opendata");
                if (!a.this.dwU && bR.dwl < 0) {
                    if (bR.dwl == -2) {
                        a.this.dxs.cx(10006L);
                    } else {
                        a.this.dxs.cx(10005L);
                        a.this.a(10005, bR);
                    }
                    a.this.finish();
                } else if (bR.dwl <= 0) {
                    if (!a.this.cyc.aiS()) {
                        if (!a.this.mIsLogin && bR.aIL()) {
                            if (!TextUtils.equals(bR.id, "mobile") || f.cva.aiH()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aJi();
                                return;
                            }
                        } else if (!TextUtils.equals(bR.id, "mobile") || !a.this.dxu) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.cyc, bR, a.this.dwA, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.dxs.cx(10003L);
                                    }
                                    a.this.gI(z);
                                }
                            });
                            return;
                        } else {
                            a.this.gI(true);
                            return;
                        }
                    }
                    a.this.dxs.cx(10005L);
                    a.this.finish();
                    a.this.a(10005, bR);
                } else {
                    a.this.dwA = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aID();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJi() {
        com.baidu.swan.apps.t.a.avX().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dxs.cx(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dxs.cx(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.dxu = true;
                        a.this.aJh();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.cyc.aGZ().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dxs.cx(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dxs.cx(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aJh();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(final boolean z) {
        if (TextUtils.isEmpty(this.dwR)) {
            d.aGI().aGK().afx().aho().a(this.mActivity, z, this.mScope, this.dwR).A(new com.baidu.swan.apps.ap.e.b<h<a.C0481a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<a.C0481a> hVar) {
                    if (!z && !a.this.dxt) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.dwS == null) {
                        a.this.dxs.cx(10002L).tV("bad Accredit response");
                        a.this.finish();
                        a.this.kq(10002);
                    } else {
                        a.this.dwA = hVar.mData.dwS;
                        a.this.finish();
                    }
                }
            }).aID();
        } else {
            d.aGI().aGK().afx().aho().a(this.mActivity, true, z, new String[]{this.mScope}, this.dwR, true).A(new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.dxs.cx(10002L).tV("bad authorize response");
                        a.this.kq(10002);
                    }
                    a.this.finish();
                }
            }).aID();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.dxv.finish();
        synchronized (dxq) {
            dxq.remove(af(this.mScope, this.dwU));
        }
        this.dxr = TaskState.FINISHED;
        if (this.dwA == null && 0 == this.dxs.aLh()) {
            if (this.mIsLogin) {
                this.dxs.cx(10001L);
            } else {
                this.dxs.cx(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.cRc) {
                    for (com.baidu.swan.apps.ap.e.b bVar : a.this.cRc) {
                        bVar.M(a.this);
                    }
                    a.this.cRc.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aJf()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.dxs));
        if (this.dwA != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.dwA));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.dxr));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kq(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.k(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e aGN = e.aGN();
        if (aGN == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d te = new com.baidu.swan.apps.statistic.a.d().kv(i).a(aGN.afg()).td(com.baidu.swan.apps.statistic.h.ku(aGN.aeW())).te(aGN.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aGN.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.hz(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.dwg);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        te.ca(jSONObject);
        com.baidu.swan.apps.statistic.h.b(te);
    }

    public static void aJj() {
        synchronized (dxq) {
            dxq.clear();
        }
    }
}
