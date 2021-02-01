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
    private static final Map<String, a> dKl = new HashMap();
    private e cHt;
    private final String dJM;
    private boolean dJP;
    public JSONObject dJv;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ao.e.b<a>> dal = new HashSet();
    private TaskState dKm = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.al.a dKn = new com.baidu.swan.apps.al.a().db(8).tH("OpenData");
    private boolean dKo = false;
    private boolean dKp = false;
    private final com.baidu.swan.apps.ao.d.a dKq = new com.baidu.swan.apps.ao.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ao.e.b<a> bVar) {
        synchronized (dKl) {
            String af = af(str, z);
            a aVar = dKl.get(af);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                dKl.put(af, aVar2);
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

    public boolean aLd() {
        return TaskState.FINISHED == this.dKm && 0 == this.dKn.aNf() && this.dJv != null;
    }

    public boolean aLe() {
        return TaskState.FINISHED == this.dKm && this.dJv != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dJM = str2;
        this.dJP = z;
    }

    private a B(com.baidu.swan.apps.ao.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.dal) {
                this.dal.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ao.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.dKm = TaskState.CALLING;
        this.dKo = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.cHt = e.aIK();
        if (this.cHt == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.dKn.dd(10001L);
            finish();
            jr(10001);
            return;
        }
        this.cHt.aIW().dIq.b(this.dKq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.cHt.aIX().isLogin(this.mActivity);
        aLf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLf() {
        d.aIG().aII().ags().ail().a(this.mActivity, this.mScope, this.dJM, this.dJP, this.mIsLogin).A(new com.baidu.swan.apps.ao.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.dKn.dd(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.dKn.dd(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.dKn.tH(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.dKn.aNb()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.dKn.dd(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.dKn.dd(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bY = com.baidu.swan.apps.setting.oauth.e.bY(optJSONObject.optJSONObject("scope"));
                if (bY == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.dKn.dd(10001L);
                    a.this.finish();
                    a.this.jr(10001);
                    return;
                }
                a.this.dJv = optJSONObject.optJSONObject("opendata");
                if (!a.this.dJP && bY.dJg < 0) {
                    if (bY.dJg == -2) {
                        a.this.dKn.dd(10006L);
                    } else {
                        a.this.dKn.dd(10005L);
                        a.this.a(10005, bY);
                    }
                    a.this.finish();
                } else if (bY.dJg <= 0) {
                    if (!a.this.cHt.ajP()) {
                        if (!a.this.mIsLogin && bY.aKJ()) {
                            if (!TextUtils.equals(bY.id, "mobile") || f.cEs.ajE()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aLg();
                                return;
                            }
                        } else if (!TextUtils.equals(bY.id, "mobile") || !a.this.dKp) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.cHt, bY, a.this.dJv, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.dKn.dd(10003L);
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
                    a.this.dKn.dd(10005L);
                    a.this.finish();
                    a.this.a(10005, bY);
                } else {
                    a.this.dJv = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aKB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLg() {
        com.baidu.swan.apps.t.a.axb().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dKn.dd(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dKn.dd(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.dKp = true;
                        a.this.aLf();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.cHt.aIX().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dKn.dd(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dKn.dd(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aLf();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(final boolean z) {
        if (TextUtils.isEmpty(this.dJM)) {
            d.aIG().aII().ags().ail().a(this.mActivity, z, this.mScope, this.dJM).A(new com.baidu.swan.apps.ao.e.b<h<a.C0466a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(h<a.C0466a> hVar) {
                    if (!z && !a.this.dKo) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.dJN == null) {
                        a.this.dKn.dd(10002L).tH("bad Accredit response");
                        a.this.finish();
                        a.this.jr(10002);
                    } else {
                        a.this.dJv = hVar.mData.dJN;
                        a.this.finish();
                    }
                }
            }).aKB();
        } else {
            d.aIG().aII().ags().ail().a(this.mActivity, true, z, new String[]{this.mScope}, this.dJM, true).A(new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.dKn.dd(10002L).tH("bad authorize response");
                        a.this.jr(10002);
                    }
                    a.this.finish();
                }
            }).aKB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.dKq.finish();
        synchronized (dKl) {
            dKl.remove(af(this.mScope, this.dJP));
        }
        this.dKm = TaskState.FINISHED;
        if (this.dJv == null && 0 == this.dKn.aNf()) {
            if (this.mIsLogin) {
                this.dKn.dd(10001L);
            } else {
                this.dKn.dd(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.f(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.dal) {
                    for (com.baidu.swan.apps.ao.e.b bVar : a.this.dal) {
                        bVar.L(a.this);
                    }
                    a.this.dal.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aLd()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.dKn));
        if (this.dJv != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.dJv));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.dKm));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.l(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e aIL = e.aIL();
        if (aIL == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d sQ = new com.baidu.swan.apps.statistic.a.d().jv(i).a(aIL.afZ()).sP(com.baidu.swan.apps.statistic.h.ju(aIL.getFrameType())).sQ(aIL.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aIL.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gn(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.dJb);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        sQ.ch(jSONObject);
        com.baidu.swan.apps.statistic.h.b(sQ);
    }

    public static void aLh() {
        synchronized (dKl) {
            dKl.clear();
        }
    }
}
