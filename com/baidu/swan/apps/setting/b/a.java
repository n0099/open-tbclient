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
    private static final Map<String, a> aRP = new HashMap();
    private com.baidu.swan.apps.ae.b aDj;
    public final String aRI;
    public JSONObject aRR;
    public final Activity mActivity;
    public final String mScope;
    private final Set<com.baidu.swan.apps.an.c.a<a>> aQD = new HashSet();
    private TaskState aRQ = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ak.a aRS = new com.baidu.swan.apps.ak.a().L(8).hw("OpenData");
    private boolean aRT = false;
    private final com.baidu.swan.apps.an.b.a aRU = new com.baidu.swan.apps.an.b.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, com.baidu.swan.apps.an.c.a<a> aVar) {
        synchronized (aRP) {
            String az = az(str, str2);
            a aVar2 = aRP.get(az);
            if (aVar2 == null) {
                a aVar3 = new a(activity, str, str2);
                aRP.put(az, aVar3);
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

    public boolean Kn() {
        return TaskState.FINISHED == this.aRQ && 0 == this.aRS.LC() && this.aRR != null;
    }

    public boolean Ko() {
        return TaskState.FINISHED == this.aRQ && this.aRR != null;
    }

    private a(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.aRI = str2;
    }

    private a d(com.baidu.swan.apps.an.c.a<a> aVar) {
        if (aVar != null) {
            synchronized (this.aQD) {
                this.aQD.add(aVar);
            }
        }
        return this;
    }

    private void e(com.baidu.swan.apps.an.c.a<a> aVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.aRQ = TaskState.CALLING;
        this.aRT = TextUtils.equals(this.mScope, "snsapi_userinfo");
        d(aVar);
        this.aDj = com.baidu.swan.apps.ae.b.IX();
        if (this.aDj == null) {
            this.aRS.N(11L).hw("SwanApp is null");
            finish();
            return;
        }
        this.aDj.Jb().aQF.b(this.aRU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.aDj.Jc().bk(this.mActivity);
        Kp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kp() {
        e.Jo().aNZ.get().uP().uT().b(this.mActivity, this.mScope, this.aRI).c(new com.baidu.swan.apps.an.c.a<g<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: a */
            public void D(g<JSONObject> gVar) {
                if (gVar == null || !gVar.isOk() || gVar.mData == null) {
                    a.this.aRS.N(10002L).hw("bad MaOpenData response");
                    a.this.finish();
                    return;
                }
                c.i("OpenData", gVar.mData.toString());
                a.this.aRS.N(gVar.mData.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE));
                a.this.aRS.hw(gVar.mData.optString("errmsg", ""));
                if (0 != a.this.aRS.Lz()) {
                    a.this.aRS.hw("by errno");
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = gVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    a.this.aRS.N(14L).hw("by data parse");
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e af = com.baidu.swan.apps.setting.oauth.e.af(optJSONObject.optJSONObject("scope"));
                if (af == null) {
                    a.this.aRS.N(14L).hw("illegal scope");
                    a.this.finish();
                    return;
                }
                a.this.aRR = optJSONObject.optJSONObject("opendata");
                if (af.aRp < 0) {
                    a.this.aRS.N(10005L).hw("by tipStatus");
                    a.this.finish();
                } else if (af.aRp <= 0) {
                    if (a.this.mIsLogin || !af.Kj()) {
                        com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.aDj, af, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                            @Override // com.baidu.swan.apps.setting.oauth.a
                            public void bt(boolean z) {
                                if (!z) {
                                    a.this.aRS.N(10003L).hw("by dialog cancel");
                                }
                                a.this.cf(z);
                            }
                        });
                    } else {
                        a.this.login();
                    }
                } else {
                    a.this.aRR = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).Kc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.aDj.Jc().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.a("onResult :: " + i, (Boolean) false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_UESR_REFUSE", (Boolean) true);
                        a.this.aRS.N(10004L).hw("login cancel by user");
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_LOGIN", (Boolean) true);
                        a.this.aRS.N(10004L).hw("system login error");
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.a("Login Preparation ok, is already login", (Boolean) false);
                        a.this.mIsLogin = true;
                        a.this.Kp();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cf(final boolean z) {
        e.Jo().aNZ.get().uP().uT().a(this.mActivity, z, this.mScope).c(new com.baidu.swan.apps.an.c.a<g<a.C0171a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: a */
            public void D(g<a.C0171a> gVar) {
                if (!z && !a.this.aRT) {
                    a.this.finish();
                } else if (gVar == null || !gVar.isOk() || gVar.mData == null || gVar.mData.aRu == null) {
                    a.this.aRS.N(10002L).hw("bad Accredit response");
                    a.this.finish();
                } else {
                    a.this.aRR = gVar.mData.aRu;
                    a.this.finish();
                }
            }
        }).Kc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.aRU.finish();
        synchronized (aRP) {
            aRP.remove(az(this.mScope, this.aRI));
        }
        this.aRQ = TaskState.FINISHED;
        if (this.aRR == null && 0 == this.aRS.LC()) {
            this.aRS.N(15L);
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.aQD) {
                    for (com.baidu.swan.apps.an.c.a aVar : a.this.aQD) {
                        aVar.D(a.this);
                    }
                    a.this.aQD.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(Kn()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.aRS));
        if (this.aRR != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.aRR));
        }
        return sb.toString();
    }
}
