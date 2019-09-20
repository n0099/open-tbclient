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
    private static final Map<String, a> aVP = new HashMap();
    private com.baidu.swan.apps.ae.b aGg;
    public final String aVI;
    public JSONObject aVR;
    public final Activity mActivity;
    public final String mScope;
    private final Set<com.baidu.swan.apps.an.d.a<a>> aUD = new HashSet();
    private TaskState aVQ = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ak.a aVS = new com.baidu.swan.apps.ak.a().Z(8).ii("OpenData");
    private boolean aVT = false;
    private final com.baidu.swan.apps.an.c.a aVU = new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, com.baidu.swan.apps.an.d.a<a> aVar) {
        synchronized (aVP) {
            String aB = aB(str, str2);
            a aVar2 = aVP.get(aB);
            if (aVar2 == null) {
                a aVar3 = new a(activity, str, str2);
                aVP.put(aB, aVar3);
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

    public boolean NE() {
        return TaskState.FINISHED == this.aVQ && 0 == this.aVS.OZ() && this.aVR != null;
    }

    public boolean NF() {
        return TaskState.FINISHED == this.aVQ && this.aVR != null;
    }

    private a(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.aVI = str2;
    }

    private a h(com.baidu.swan.apps.an.d.a<a> aVar) {
        if (aVar != null) {
            synchronized (this.aUD) {
                this.aUD.add(aVar);
            }
        }
        return this;
    }

    private void i(com.baidu.swan.apps.an.d.a<a> aVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.aVQ = TaskState.CALLING;
        this.aVT = TextUtils.equals(this.mScope, "snsapi_userinfo");
        h(aVar);
        this.aGg = com.baidu.swan.apps.ae.b.Mh();
        if (this.aGg == null) {
            this.aVS.ab(11L).ii("SwanApp is null");
            finish();
            return;
        }
        this.aGg.Ml().aUF.b(this.aVU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.aGg.Mm().aD(this.mActivity);
        NG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NG() {
        e.Mz().aRo.get().wd().wE().b(this.mActivity, this.mScope, this.aVI).g(new com.baidu.swan.apps.an.d.a<g<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(g<JSONObject> gVar) {
                if (gVar == null || !gVar.isOk() || gVar.mData == null) {
                    a.this.aVS.ab(10002L).ii("bad MaOpenData response");
                    a.this.finish();
                    return;
                }
                c.i("OpenData", gVar.mData.toString());
                a.this.aVS.ab(gVar.mData.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE));
                a.this.aVS.ii(gVar.mData.optString("errmsg", ""));
                if (0 != a.this.aVS.OW()) {
                    a.this.aVS.ii("by errno");
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = gVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    a.this.aVS.ab(14L).ii("by data parse");
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e ag = com.baidu.swan.apps.setting.oauth.e.ag(optJSONObject.optJSONObject("scope"));
                if (ag == null) {
                    a.this.aVS.ab(14L).ii("illegal scope");
                    a.this.finish();
                    return;
                }
                a.this.aVR = optJSONObject.optJSONObject("opendata");
                if (ag.aVq < 0) {
                    a.this.aVS.ab(10005L).ii("by tipStatus");
                    a.this.finish();
                } else if (ag.aVq <= 0) {
                    if (a.this.mIsLogin || !ag.NA()) {
                        com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.aGg, ag, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                            @Override // com.baidu.swan.apps.setting.oauth.a
                            public void bE(boolean z) {
                                if (!z) {
                                    a.this.aVS.ab(10003L).ii("by dialog cancel");
                                }
                                a.this.cw(z);
                            }
                        });
                    } else {
                        a.this.login();
                    }
                } else {
                    a.this.aVR = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).Ns();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.aGg.Mm().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.a("onResult :: " + i, (Boolean) false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_UESR_REFUSE", (Boolean) true);
                        a.this.aVS.ab(10004L).ii("login cancel by user");
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_LOGIN", (Boolean) true);
                        a.this.aVS.ab(10004L).ii("system login error");
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.a("Login Preparation ok, is already login", (Boolean) false);
                        a.this.mIsLogin = true;
                        a.this.NG();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(final boolean z) {
        e.Mz().aRo.get().wd().wE().a(this.mActivity, z, this.mScope).g(new com.baidu.swan.apps.an.d.a<g<a.C0189a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(g<a.C0189a> gVar) {
                if (!z && !a.this.aVT) {
                    a.this.finish();
                } else if (gVar == null || !gVar.isOk() || gVar.mData == null || gVar.mData.aVv == null) {
                    a.this.aVS.ab(10002L).ii("bad Accredit response");
                    a.this.finish();
                } else {
                    a.this.aVR = gVar.mData.aVv;
                    a.this.finish();
                }
            }
        }).Ns();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.aVU.finish();
        synchronized (aVP) {
            aVP.remove(aB(this.mScope, this.aVI));
        }
        this.aVQ = TaskState.FINISHED;
        if (this.aVR == null && 0 == this.aVS.OZ()) {
            this.aVS.ab(15L);
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.aUD) {
                    for (com.baidu.swan.apps.an.d.a aVar : a.this.aUD) {
                        aVar.D(a.this);
                    }
                    a.this.aUD.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(NE()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.aVS));
        if (this.aVR != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.aVR));
        }
        return sb.toString();
    }
}
