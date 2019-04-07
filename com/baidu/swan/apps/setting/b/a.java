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
    private static final Map<String, a> aRS = new HashMap();
    private com.baidu.swan.apps.ae.b aDm;
    public final String aRL;
    public JSONObject aRU;
    public final Activity mActivity;
    public final String mScope;
    private final Set<com.baidu.swan.apps.an.c.a<a>> aQG = new HashSet();
    private TaskState aRT = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ak.a aRV = new com.baidu.swan.apps.ak.a().L(8).hx("OpenData");
    private boolean aRW = false;
    private final com.baidu.swan.apps.an.b.a aRX = new com.baidu.swan.apps.an.b.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, com.baidu.swan.apps.an.c.a<a> aVar) {
        synchronized (aRS) {
            String az = az(str, str2);
            a aVar2 = aRS.get(az);
            if (aVar2 == null) {
                a aVar3 = new a(activity, str, str2);
                aRS.put(az, aVar3);
                aVar3.e(aVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar2.toString());
                aVar2.d(aVar);
            }
        }
    }

    private static String az(String str, String str2) {
        return str + "/" + str2;
    }

    public boolean Kl() {
        return TaskState.FINISHED == this.aRT && 0 == this.aRV.LA() && this.aRU != null;
    }

    public boolean Km() {
        return TaskState.FINISHED == this.aRT && this.aRU != null;
    }

    private a(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.aRL = str2;
    }

    private a d(com.baidu.swan.apps.an.c.a<a> aVar) {
        if (aVar != null) {
            synchronized (this.aQG) {
                this.aQG.add(aVar);
            }
        }
        return this;
    }

    private void e(com.baidu.swan.apps.an.c.a<a> aVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.aRT = TaskState.CALLING;
        this.aRW = TextUtils.equals(this.mScope, "snsapi_userinfo");
        d(aVar);
        this.aDm = com.baidu.swan.apps.ae.b.IV();
        if (this.aDm == null) {
            this.aRV.N(11L).hx("SwanApp is null");
            finish();
            return;
        }
        this.aDm.IZ().aQI.b(this.aRX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.aDm.Ja().bk(this.mActivity);
        Kn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kn() {
        e.Jm().aOc.get().uO().uS().b(this.mActivity, this.mScope, this.aRL).c(new com.baidu.swan.apps.an.c.a<g<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: a */
            public void D(g<JSONObject> gVar) {
                if (gVar == null || !gVar.isOk() || gVar.mData == null) {
                    a.this.aRV.N(10002L).hx("bad MaOpenData response");
                    a.this.finish();
                    return;
                }
                c.i("OpenData", gVar.mData.toString());
                a.this.aRV.N(gVar.mData.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE));
                a.this.aRV.hx(gVar.mData.optString("errmsg", ""));
                if (0 != a.this.aRV.Lx()) {
                    a.this.aRV.hx("by errno");
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = gVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    a.this.aRV.N(14L).hx("by data parse");
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e af = com.baidu.swan.apps.setting.oauth.e.af(optJSONObject.optJSONObject("scope"));
                if (af == null) {
                    a.this.aRV.N(14L).hx("illegal scope");
                    a.this.finish();
                    return;
                }
                a.this.aRU = optJSONObject.optJSONObject("opendata");
                if (af.aRs < 0) {
                    a.this.aRV.N(10005L).hx("by tipStatus");
                    a.this.finish();
                } else if (af.aRs <= 0) {
                    if (a.this.mIsLogin || !af.Kh()) {
                        com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.aDm, af, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                            @Override // com.baidu.swan.apps.setting.oauth.a
                            public void bt(boolean z) {
                                if (!z) {
                                    a.this.aRV.N(10003L).hx("by dialog cancel");
                                }
                                a.this.cf(z);
                            }
                        });
                    } else {
                        a.this.login();
                    }
                } else {
                    a.this.aRU = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).Ka();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.aDm.Ja().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.a("onResult :: " + i, (Boolean) false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_UESR_REFUSE", (Boolean) true);
                        a.this.aRV.N(10004L).hx("login cancel by user");
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_LOGIN", (Boolean) true);
                        a.this.aRV.N(10004L).hx("system login error");
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.a("Login Preparation ok, is already login", (Boolean) false);
                        a.this.mIsLogin = true;
                        a.this.Kn();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cf(final boolean z) {
        e.Jm().aOc.get().uO().uS().a(this.mActivity, z, this.mScope).c(new com.baidu.swan.apps.an.c.a<g<a.C0171a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: a */
            public void D(g<a.C0171a> gVar) {
                if (!z && !a.this.aRW) {
                    a.this.finish();
                } else if (gVar == null || !gVar.isOk() || gVar.mData == null || gVar.mData.aRx == null) {
                    a.this.aRV.N(10002L).hx("bad Accredit response");
                    a.this.finish();
                } else {
                    a.this.aRU = gVar.mData.aRx;
                    a.this.finish();
                }
            }
        }).Ka();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.aRX.finish();
        synchronized (aRS) {
            aRS.remove(az(this.mScope, this.aRL));
        }
        this.aRT = TaskState.FINISHED;
        if (this.aRU == null && 0 == this.aRV.LA()) {
            this.aRV.N(15L);
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.aQG) {
                    for (com.baidu.swan.apps.an.c.a aVar : a.this.aQG) {
                        aVar.D(a.this);
                    }
                    a.this.aQG.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(Kl()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.aRV));
        if (this.aRU != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.aRU));
        }
        return sb.toString();
    }
}
