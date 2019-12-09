package com.baidu.swan.apps.setting.b;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.swan.apps.ae.e;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.swan.apps.setting.oauth.a.a;
import com.baidu.swan.apps.setting.oauth.g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final Map<String, a> boB = new HashMap();
    private com.baidu.swan.apps.ae.b aZd;
    public JSONObject boD;
    public final String bou;
    public final Activity mActivity;
    public final String mScope;
    private final Set<com.baidu.swan.apps.an.d.a<a>> bnp = new HashSet();
    private TaskState boC = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ak.a boE = new com.baidu.swan.apps.ak.a().ar(8).iL("OpenData");
    private boolean boF = false;
    private final com.baidu.swan.apps.an.c.a boG = new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, com.baidu.swan.apps.an.d.a<a> aVar) {
        synchronized (boB) {
            String aJ = aJ(str, str2);
            a aVar2 = boB.get(aJ);
            if (aVar2 == null) {
                a aVar3 = new a(activity, str, str2);
                boB.put(aJ, aVar3);
                aVar3.i(aVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar2.toString());
                aVar2.h(aVar);
            }
        }
    }

    private static String aJ(String str, String str2) {
        return str + "/" + str2;
    }

    public boolean Sw() {
        return TaskState.FINISHED == this.boC && 0 == this.boE.TN() && this.boD != null;
    }

    public boolean Sx() {
        return TaskState.FINISHED == this.boC && this.boD != null;
    }

    private a(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.bou = str2;
    }

    private a h(com.baidu.swan.apps.an.d.a<a> aVar) {
        if (aVar != null) {
            synchronized (this.bnp) {
                this.bnp.add(aVar);
            }
        }
        return this;
    }

    private void i(com.baidu.swan.apps.an.d.a<a> aVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.boC = TaskState.CALLING;
        this.boF = TextUtils.equals(this.mScope, "snsapi_userinfo");
        h(aVar);
        this.aZd = com.baidu.swan.apps.ae.b.Ra();
        if (this.aZd == null) {
            this.boE.at(11L).iL("SwanApp is null");
            finish();
            return;
        }
        this.aZd.Rf().bnr.b(this.boG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.aZd.Rg().isLogin(this.mActivity);
        Sy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sy() {
        e.Rt().bka.get().AY().Bz().b(this.mActivity, this.mScope, this.bou).g(new com.baidu.swan.apps.an.d.a<g<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(g<JSONObject> gVar) {
                if (gVar == null || !gVar.isOk() || gVar.mData == null) {
                    a.this.boE.at(10002L).iL("bad MaOpenData response");
                    a.this.finish();
                    return;
                }
                c.i("OpenData", gVar.mData.toString());
                a.this.boE.at(gVar.mData.optInt("errno", 11001));
                a.this.boE.iL(gVar.mData.optString("errmsg", ""));
                if (0 != a.this.boE.TK()) {
                    a.this.boE.iL("by errno");
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = gVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    a.this.boE.at(14L).iL("by data parse");
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e aF = com.baidu.swan.apps.setting.oauth.e.aF(optJSONObject.optJSONObject("scope"));
                if (aF == null) {
                    a.this.boE.at(14L).iL("illegal scope");
                    a.this.finish();
                    return;
                }
                a.this.boD = optJSONObject.optJSONObject("opendata");
                if (aF.boc < 0) {
                    a.this.boE.at(10005L).iL("by tipStatus");
                    a.this.finish();
                } else if (aF.boc <= 0) {
                    if (a.this.mIsLogin || !aF.Ss()) {
                        com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.aZd, aF, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                            @Override // com.baidu.swan.apps.setting.oauth.a
                            public void onResult(boolean z) {
                                if (!z) {
                                    a.this.boE.at(10003L).iL("by dialog cancel");
                                }
                                a.this.cN(z);
                            }
                        });
                    } else {
                        a.this.login();
                    }
                } else {
                    a.this.boD = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).Sk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.aZd.Rg().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.a("onResult :: " + i, (Boolean) false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_UESR_REFUSE", (Boolean) true);
                        a.this.boE.at(10004L).iL("login cancel by user");
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_LOGIN", (Boolean) true);
                        a.this.boE.at(10004L).iL("system login error");
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.a("Login Preparation ok, is already login", (Boolean) false);
                        a.this.mIsLogin = true;
                        a.this.Sy();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(final boolean z) {
        e.Rt().bka.get().AY().Bz().a(this.mActivity, z, this.mScope).g(new com.baidu.swan.apps.an.d.a<g<a.C0216a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(g<a.C0216a> gVar) {
                if (!z && !a.this.boF) {
                    a.this.finish();
                } else if (gVar == null || !gVar.isOk() || gVar.mData == null || gVar.mData.boh == null) {
                    a.this.boE.at(10002L).iL("bad Accredit response");
                    a.this.finish();
                } else {
                    a.this.boD = gVar.mData.boh;
                    a.this.finish();
                }
            }
        }).Sk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.boG.finish();
        synchronized (boB) {
            boB.remove(aJ(this.mScope, this.bou));
        }
        this.boC = TaskState.FINISHED;
        if (this.boD == null && 0 == this.boE.TN()) {
            this.boE.at(15L);
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.e(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.bnp) {
                    for (com.baidu.swan.apps.an.d.a aVar : a.this.bnp) {
                        aVar.B(a.this);
                    }
                    a.this.bnp.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(Sw()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.boE));
        if (this.boD != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.boD));
        }
        return sb.toString();
    }
}
