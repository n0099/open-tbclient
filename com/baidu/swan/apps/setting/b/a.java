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
    private static final Map<String, a> boT = new HashMap();
    private com.baidu.swan.apps.ae.b aZv;
    public final String boM;
    public JSONObject boV;
    public final Activity mActivity;
    public final String mScope;
    private final Set<com.baidu.swan.apps.an.d.a<a>> bnH = new HashSet();
    private TaskState boU = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ak.a boW = new com.baidu.swan.apps.ak.a().as(8).iL("OpenData");
    private boolean boX = false;
    private final com.baidu.swan.apps.an.c.a boY = new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, com.baidu.swan.apps.an.d.a<a> aVar) {
        synchronized (boT) {
            String aJ = aJ(str, str2);
            a aVar2 = boT.get(aJ);
            if (aVar2 == null) {
                a aVar3 = new a(activity, str, str2);
                boT.put(aJ, aVar3);
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

    public boolean Su() {
        return TaskState.FINISHED == this.boU && 0 == this.boW.TP() && this.boV != null;
    }

    public boolean Sv() {
        return TaskState.FINISHED == this.boU && this.boV != null;
    }

    private a(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.boM = str2;
    }

    private a h(com.baidu.swan.apps.an.d.a<a> aVar) {
        if (aVar != null) {
            synchronized (this.bnH) {
                this.bnH.add(aVar);
            }
        }
        return this;
    }

    private void i(com.baidu.swan.apps.an.d.a<a> aVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.boU = TaskState.CALLING;
        this.boX = TextUtils.equals(this.mScope, "snsapi_userinfo");
        h(aVar);
        this.aZv = com.baidu.swan.apps.ae.b.QZ();
        if (this.aZv == null) {
            this.boW.au(11L).iL("SwanApp is null");
            finish();
            return;
        }
        this.aZv.Rd().bnJ.b(this.boY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.aZv.Re().isLogin(this.mActivity);
        Sw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sw() {
        e.Rr().bks.get().AX().By().b(this.mActivity, this.mScope, this.boM).g(new com.baidu.swan.apps.an.d.a<g<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(g<JSONObject> gVar) {
                if (gVar == null || !gVar.isOk() || gVar.mData == null) {
                    a.this.boW.au(10002L).iL("bad MaOpenData response");
                    a.this.finish();
                    return;
                }
                c.i("OpenData", gVar.mData.toString());
                a.this.boW.au(gVar.mData.optInt("errno", 11001));
                a.this.boW.iL(gVar.mData.optString("errmsg", ""));
                if (0 != a.this.boW.TM()) {
                    a.this.boW.iL("by errno");
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = gVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    a.this.boW.au(14L).iL("by data parse");
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e aE = com.baidu.swan.apps.setting.oauth.e.aE(optJSONObject.optJSONObject("scope"));
                if (aE == null) {
                    a.this.boW.au(14L).iL("illegal scope");
                    a.this.finish();
                    return;
                }
                a.this.boV = optJSONObject.optJSONObject("opendata");
                if (aE.bou < 0) {
                    a.this.boW.au(10005L).iL("by tipStatus");
                    a.this.finish();
                } else if (aE.bou <= 0) {
                    if (a.this.mIsLogin || !aE.Sq()) {
                        com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.aZv, aE, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                            @Override // com.baidu.swan.apps.setting.oauth.a
                            public void onResult(boolean z) {
                                if (!z) {
                                    a.this.boW.au(10003L).iL("by dialog cancel");
                                }
                                a.this.cN(z);
                            }
                        });
                    } else {
                        a.this.login();
                    }
                } else {
                    a.this.boV = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).Si();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.aZv.Re().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.a("onResult :: " + i, (Boolean) false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_UESR_REFUSE", (Boolean) true);
                        a.this.boW.au(10004L).iL("login cancel by user");
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_LOGIN", (Boolean) true);
                        a.this.boW.au(10004L).iL("system login error");
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.a("Login Preparation ok, is already login", (Boolean) false);
                        a.this.mIsLogin = true;
                        a.this.Sw();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(final boolean z) {
        e.Rr().bks.get().AX().By().a(this.mActivity, z, this.mScope).g(new com.baidu.swan.apps.an.d.a<g<a.C0221a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(g<a.C0221a> gVar) {
                if (!z && !a.this.boX) {
                    a.this.finish();
                } else if (gVar == null || !gVar.isOk() || gVar.mData == null || gVar.mData.boz == null) {
                    a.this.boW.au(10002L).iL("bad Accredit response");
                    a.this.finish();
                } else {
                    a.this.boV = gVar.mData.boz;
                    a.this.finish();
                }
            }
        }).Si();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.boY.finish();
        synchronized (boT) {
            boT.remove(aJ(this.mScope, this.boM));
        }
        this.boU = TaskState.FINISHED;
        if (this.boV == null && 0 == this.boW.TP()) {
            this.boW.au(15L);
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.e(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.bnH) {
                    for (com.baidu.swan.apps.an.d.a aVar : a.this.bnH) {
                        aVar.B(a.this);
                    }
                    a.this.bnH.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(Su()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.boW));
        if (this.boV != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.boV));
        }
        return sb.toString();
    }
}
