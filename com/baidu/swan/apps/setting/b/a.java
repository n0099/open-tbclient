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
    private static final Map<String, a> aRT = new HashMap();
    private com.baidu.swan.apps.ae.b aDn;
    public final String aRM;
    public JSONObject aRV;
    public final Activity mActivity;
    public final String mScope;
    private final Set<com.baidu.swan.apps.an.c.a<a>> aQH = new HashSet();
    private TaskState aRU = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ak.a aRW = new com.baidu.swan.apps.ak.a().L(8).hx("OpenData");
    private boolean aRX = false;
    private final com.baidu.swan.apps.an.b.a aRY = new com.baidu.swan.apps.an.b.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, com.baidu.swan.apps.an.c.a<a> aVar) {
        synchronized (aRT) {
            String az = az(str, str2);
            a aVar2 = aRT.get(az);
            if (aVar2 == null) {
                a aVar3 = new a(activity, str, str2);
                aRT.put(az, aVar3);
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
        return TaskState.FINISHED == this.aRU && 0 == this.aRW.LA() && this.aRV != null;
    }

    public boolean Km() {
        return TaskState.FINISHED == this.aRU && this.aRV != null;
    }

    private a(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.aRM = str2;
    }

    private a d(com.baidu.swan.apps.an.c.a<a> aVar) {
        if (aVar != null) {
            synchronized (this.aQH) {
                this.aQH.add(aVar);
            }
        }
        return this;
    }

    private void e(com.baidu.swan.apps.an.c.a<a> aVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.aRU = TaskState.CALLING;
        this.aRX = TextUtils.equals(this.mScope, "snsapi_userinfo");
        d(aVar);
        this.aDn = com.baidu.swan.apps.ae.b.IV();
        if (this.aDn == null) {
            this.aRW.N(11L).hx("SwanApp is null");
            finish();
            return;
        }
        this.aDn.IZ().aQJ.b(this.aRY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.aDn.Ja().bk(this.mActivity);
        Kn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kn() {
        e.Jm().aOd.get().uO().uS().b(this.mActivity, this.mScope, this.aRM).c(new com.baidu.swan.apps.an.c.a<g<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: a */
            public void D(g<JSONObject> gVar) {
                if (gVar == null || !gVar.isOk() || gVar.mData == null) {
                    a.this.aRW.N(10002L).hx("bad MaOpenData response");
                    a.this.finish();
                    return;
                }
                c.i("OpenData", gVar.mData.toString());
                a.this.aRW.N(gVar.mData.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE));
                a.this.aRW.hx(gVar.mData.optString("errmsg", ""));
                if (0 != a.this.aRW.Lx()) {
                    a.this.aRW.hx("by errno");
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = gVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    a.this.aRW.N(14L).hx("by data parse");
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e af = com.baidu.swan.apps.setting.oauth.e.af(optJSONObject.optJSONObject("scope"));
                if (af == null) {
                    a.this.aRW.N(14L).hx("illegal scope");
                    a.this.finish();
                    return;
                }
                a.this.aRV = optJSONObject.optJSONObject("opendata");
                if (af.aRt < 0) {
                    a.this.aRW.N(10005L).hx("by tipStatus");
                    a.this.finish();
                } else if (af.aRt <= 0) {
                    if (a.this.mIsLogin || !af.Kh()) {
                        com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.aDn, af, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                            @Override // com.baidu.swan.apps.setting.oauth.a
                            public void bt(boolean z) {
                                if (!z) {
                                    a.this.aRW.N(10003L).hx("by dialog cancel");
                                }
                                a.this.cf(z);
                            }
                        });
                    } else {
                        a.this.login();
                    }
                } else {
                    a.this.aRV = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).Ka();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.aDn.Ja().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.a("onResult :: " + i, (Boolean) false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_UESR_REFUSE", (Boolean) true);
                        a.this.aRW.N(10004L).hx("login cancel by user");
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_LOGIN", (Boolean) true);
                        a.this.aRW.N(10004L).hx("system login error");
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
        e.Jm().aOd.get().uO().uS().a(this.mActivity, z, this.mScope).c(new com.baidu.swan.apps.an.c.a<g<a.C0171a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: a */
            public void D(g<a.C0171a> gVar) {
                if (!z && !a.this.aRX) {
                    a.this.finish();
                } else if (gVar == null || !gVar.isOk() || gVar.mData == null || gVar.mData.aRy == null) {
                    a.this.aRW.N(10002L).hx("bad Accredit response");
                    a.this.finish();
                } else {
                    a.this.aRV = gVar.mData.aRy;
                    a.this.finish();
                }
            }
        }).Ka();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.aRY.finish();
        synchronized (aRT) {
            aRT.remove(az(this.mScope, this.aRM));
        }
        this.aRU = TaskState.FINISHED;
        if (this.aRV == null && 0 == this.aRW.LA()) {
            this.aRW.N(15L);
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.aQH) {
                    for (com.baidu.swan.apps.an.c.a aVar : a.this.aQH) {
                        aVar.D(a.this);
                    }
                    a.this.aQH.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(Kl()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.aRW));
        if (this.aRV != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.aRV));
        }
        return sb.toString();
    }
}
