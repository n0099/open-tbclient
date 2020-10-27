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
    private static final Map<String, a> dte = new HashMap();
    private e ctR;
    private final String dsF;
    private boolean dsI;
    public JSONObject dsn;
    public final Activity mActivity;
    private final String mScope;
    private final Set<com.baidu.swan.apps.ap.e.b<a>> cMT = new HashSet();
    private TaskState dtf = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.am.a dtg = new com.baidu.swan.apps.am.a().bZ(8).tM("OpenData");
    private boolean dth = false;
    private boolean dti = false;
    private final com.baidu.swan.apps.ap.d.a dtj = new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, com.baidu.swan.apps.ap.e.b<a> bVar) {
        synchronized (dte) {
            String af = af(str, z);
            a aVar = dte.get(af);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                dte.put(af, aVar2);
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

    public boolean aHn() {
        return TaskState.FINISHED == this.dtf && 0 == this.dtg.aJp() && this.dsn != null;
    }

    public boolean aHo() {
        return TaskState.FINISHED == this.dtf && this.dsn != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dsF = str2;
        this.dsI = z;
    }

    private a B(com.baidu.swan.apps.ap.e.b<a> bVar) {
        if (bVar != null) {
            synchronized (this.cMT) {
                this.cMT.add(bVar);
            }
        }
        return this;
    }

    private void C(com.baidu.swan.apps.ap.e.b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.dtf = TaskState.CALLING;
        this.dth = TextUtils.equals(this.mScope, "snsapi_userinfo");
        B(bVar);
        this.ctR = e.aEU();
        if (this.ctR == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.dtg.cb(10001L);
            finish();
            kk(10001);
            return;
        }
        this.ctR.aFg().drh.b(this.dtj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.ctR.aFh().isLogin(this.mActivity);
        aHp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHp() {
        d.aEQ().aES().adF().afw().a(this.mActivity, this.mScope, this.dsF, this.dsI, this.mIsLogin).A(new com.baidu.swan.apps.ap.e.b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.dtg.cb(10001L);
                    a.this.finish();
                    a.this.kk(10001);
                    return;
                }
                c.d("OpenData", "opendata=", hVar.mData);
                a.this.dtg.cb(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.dtg.tM(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.dtg.aJl()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.dtg.cb(10001L);
                    a.this.finish();
                    a.this.kk(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.dtg.cb(10001L);
                    a.this.finish();
                    a.this.kk(10001);
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bR = com.baidu.swan.apps.setting.oauth.e.bR(optJSONObject.optJSONObject("scope"));
                if (bR == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.dtg.cb(10001L);
                    a.this.finish();
                    a.this.kk(10001);
                    return;
                }
                a.this.dsn = optJSONObject.optJSONObject("opendata");
                if (!a.this.dsI && bR.drY < 0) {
                    if (bR.drY == -2) {
                        a.this.dtg.cb(10006L);
                    } else {
                        a.this.dtg.cb(10005L);
                        a.this.a(10005, bR);
                    }
                    a.this.finish();
                } else if (bR.drY <= 0) {
                    if (!a.this.ctR.aha()) {
                        if (!a.this.mIsLogin && bR.aGT()) {
                            if (!TextUtils.equals(bR.id, "mobile") || f.cqM.agP()) {
                                a.this.login();
                                return;
                            } else {
                                a.this.aHq();
                                return;
                            }
                        } else if (!TextUtils.equals(bR.id, "mobile") || !a.this.dti) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.ctR, bR, a.this.dsn, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.dtg.cb(10003L);
                                    }
                                    a.this.gw(z);
                                }
                            });
                            return;
                        } else {
                            a.this.gw(true);
                            return;
                        }
                    }
                    a.this.dtg.cb(10005L);
                    a.this.finish();
                    a.this.a(10005, bR);
                } else {
                    a.this.dsn = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aGL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHq() {
        com.baidu.swan.apps.t.a.auf().b(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dtg.cb(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dtg.cb(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.dti = true;
                        a.this.aHp();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.ctR.aFh().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.4
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.dtg.cb(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.dtg.cb(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aHp();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(final boolean z) {
        if (TextUtils.isEmpty(this.dsF)) {
            d.aEQ().aES().adF().afw().a(this.mActivity, z, this.mScope, this.dsF).A(new com.baidu.swan.apps.ap.e.b<h<a.C0471a>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<a.C0471a> hVar) {
                    if (!z && !a.this.dth) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.dsG == null) {
                        a.this.dtg.cb(10002L).tM("bad Accredit response");
                        a.this.finish();
                        a.this.kk(10002);
                    } else {
                        a.this.dsn = hVar.mData.dsG;
                        a.this.finish();
                    }
                }
            }).aGL();
        } else {
            d.aEQ().aES().adF().afw().a(this.mActivity, true, z, new String[]{this.mScope}, this.dsF, true).A(new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.dtg.cb(10002L).tM("bad authorize response");
                        a.this.kk(10002);
                    }
                    a.this.finish();
                }
            }).aGL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.dtj.finish();
        synchronized (dte) {
            dte.remove(af(this.mScope, this.dsI));
        }
        this.dtf = TaskState.FINISHED;
        if (this.dsn == null && 0 == this.dtg.aJp()) {
            if (this.mIsLogin) {
                this.dtg.cb(10001L);
            } else {
                this.dtg.cb(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.cMT) {
                    for (com.baidu.swan.apps.ap.e.b bVar : a.this.cMT) {
                        bVar.M(a.this);
                    }
                    a.this.cMT.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aHn()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.dtg));
        if (this.dsn != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.dsn));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.dtf));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk(int i) {
        a(i, com.baidu.swan.apps.setting.oauth.e.i(this.mScope, new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        e aEV = e.aEV();
        if (aEV == null) {
            if (DEBUG) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d sV = new com.baidu.swan.apps.statistic.a.d().kp(i).a(aEV.ado()).sU(com.baidu.swan.apps.statistic.h.ko(aEV.ade())).sV(aEV.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aEV.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.ht(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.drT);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        sV.ca(jSONObject);
        com.baidu.swan.apps.statistic.h.b(sV);
    }

    public static void aHr() {
        synchronized (dte) {
            dte.clear();
        }
    }
}
