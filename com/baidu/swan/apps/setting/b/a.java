package com.baidu.swan.apps.setting.b;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiGIDEvent;
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
    private static final Map<String, a> aUH = new HashMap();
    private com.baidu.swan.apps.ae.b aFa;
    public final String aUA;
    public JSONObject aUJ;
    public final Activity mActivity;
    public final String mScope;
    private final Set<com.baidu.swan.apps.an.d.a<a>> aTv = new HashSet();
    private TaskState aUI = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ak.a aUK = new com.baidu.swan.apps.ak.a().Y(8).hY("OpenData");
    private boolean aUL = false;
    private final com.baidu.swan.apps.an.c.a aUM = new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, com.baidu.swan.apps.an.d.a<a> aVar) {
        synchronized (aUH) {
            String aB = aB(str, str2);
            a aVar2 = aUH.get(aB);
            if (aVar2 == null) {
                a aVar3 = new a(activity, str, str2);
                aUH.put(aB, aVar3);
                aVar3.i(aVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar2.toString());
                aVar2.h(aVar);
            }
        }
    }

    private static String aB(String str, String str2) {
        return str + "/" + str2;
    }

    public boolean ML() {
        return TaskState.FINISHED == this.aUI && 0 == this.aUK.Og() && this.aUJ != null;
    }

    public boolean MM() {
        return TaskState.FINISHED == this.aUI && this.aUJ != null;
    }

    private a(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.aUA = str2;
    }

    private a h(com.baidu.swan.apps.an.d.a<a> aVar) {
        if (aVar != null) {
            synchronized (this.aTv) {
                this.aTv.add(aVar);
            }
        }
        return this;
    }

    private void i(com.baidu.swan.apps.an.d.a<a> aVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.aUI = TaskState.CALLING;
        this.aUL = TextUtils.equals(this.mScope, "snsapi_userinfo");
        h(aVar);
        this.aFa = com.baidu.swan.apps.ae.b.Lq();
        if (this.aFa == null) {
            this.aUK.aa(11L).hY("SwanApp is null");
            finish();
            return;
        }
        this.aFa.Lu().aTx.b(this.aUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.aFa.Lv().aD(this.mActivity);
        MN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MN() {
        e.LH().aQg.get().vy().vZ().b(this.mActivity, this.mScope, this.aUA).g(new com.baidu.swan.apps.an.d.a<g<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(g<JSONObject> gVar) {
                if (gVar == null || !gVar.isOk() || gVar.mData == null) {
                    a.this.aUK.aa(10002L).hY("bad MaOpenData response");
                    a.this.finish();
                    return;
                }
                c.i("OpenData", gVar.mData.toString());
                a.this.aUK.aa(gVar.mData.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE));
                a.this.aUK.hY(gVar.mData.optString("errmsg", ""));
                if (0 != a.this.aUK.Od()) {
                    a.this.aUK.hY("by errno");
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = gVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    a.this.aUK.aa(14L).hY("by data parse");
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e ag = com.baidu.swan.apps.setting.oauth.e.ag(optJSONObject.optJSONObject("scope"));
                if (ag == null) {
                    a.this.aUK.aa(14L).hY("illegal scope");
                    a.this.finish();
                    return;
                }
                a.this.aUJ = optJSONObject.optJSONObject("opendata");
                if (ag.aUi < 0) {
                    a.this.aUK.aa(10005L).hY("by tipStatus");
                    a.this.finish();
                } else if (ag.aUi <= 0) {
                    if (a.this.mIsLogin || !ag.MH()) {
                        com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.aFa, ag, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                            @Override // com.baidu.swan.apps.setting.oauth.a
                            public void bB(boolean z) {
                                if (!z) {
                                    a.this.aUK.aa(10003L).hY("by dialog cancel");
                                }
                                a.this.ct(z);
                            }
                        });
                    } else {
                        a.this.login();
                    }
                } else {
                    a.this.aUJ = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).MA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.aFa.Lv().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.a("onResult :: " + i, (Boolean) false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_UESR_REFUSE", (Boolean) true);
                        a.this.aUK.aa(10004L).hY("login cancel by user");
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_LOGIN", (Boolean) true);
                        a.this.aUK.aa(10004L).hY("system login error");
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.a("Login Preparation ok, is already login", (Boolean) false);
                        a.this.mIsLogin = true;
                        a.this.MN();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(final boolean z) {
        e.LH().aQg.get().vy().vZ().a(this.mActivity, z, this.mScope).g(new com.baidu.swan.apps.an.d.a<g<a.C0178a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(g<a.C0178a> gVar) {
                if (!z && !a.this.aUL) {
                    a.this.finish();
                } else if (gVar == null || !gVar.isOk() || gVar.mData == null || gVar.mData.aUn == null) {
                    a.this.aUK.aa(10002L).hY("bad Accredit response");
                    a.this.finish();
                } else {
                    a.this.aUJ = gVar.mData.aUn;
                    a.this.finish();
                }
            }
        }).MA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.aUM.finish();
        synchronized (aUH) {
            aUH.remove(aB(this.mScope, this.aUA));
        }
        this.aUI = TaskState.FINISHED;
        if (this.aUJ == null && 0 == this.aUK.Og()) {
            this.aUK.aa(15L);
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.aTv) {
                    for (com.baidu.swan.apps.an.d.a aVar : a.this.aTv) {
                        aVar.D(a.this);
                    }
                    a.this.aTv.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(ML()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.aUK));
        if (this.aUJ != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.aUJ));
        }
        return sb.toString();
    }
}
