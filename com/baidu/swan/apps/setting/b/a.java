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
    private static final Map<String, a> aVr = new HashMap();
    private com.baidu.swan.apps.ae.b aFI;
    public final String aVk;
    public JSONObject aVt;
    public final Activity mActivity;
    public final String mScope;
    private final Set<com.baidu.swan.apps.an.d.a<a>> aUf = new HashSet();
    private TaskState aVs = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ak.a aVu = new com.baidu.swan.apps.ak.a().Z(8).ig("OpenData");
    private boolean aVv = false;
    private final com.baidu.swan.apps.an.c.a aVw = new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, com.baidu.swan.apps.an.d.a<a> aVar) {
        synchronized (aVr) {
            String aB = aB(str, str2);
            a aVar2 = aVr.get(aB);
            if (aVar2 == null) {
                a aVar3 = new a(activity, str, str2);
                aVr.put(aB, aVar3);
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

    public boolean NA() {
        return TaskState.FINISHED == this.aVs && 0 == this.aVu.OV() && this.aVt != null;
    }

    public boolean NB() {
        return TaskState.FINISHED == this.aVs && this.aVt != null;
    }

    private a(Activity activity, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.aVk = str2;
    }

    private a h(com.baidu.swan.apps.an.d.a<a> aVar) {
        if (aVar != null) {
            synchronized (this.aUf) {
                this.aUf.add(aVar);
            }
        }
        return this;
    }

    private void i(com.baidu.swan.apps.an.d.a<a> aVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.aVs = TaskState.CALLING;
        this.aVv = TextUtils.equals(this.mScope, "snsapi_userinfo");
        h(aVar);
        this.aFI = com.baidu.swan.apps.ae.b.Md();
        if (this.aFI == null) {
            this.aVu.ab(11L).ig("SwanApp is null");
            finish();
            return;
        }
        this.aFI.Mh().aUh.b(this.aVw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.aFI.Mi().aD(this.mActivity);
        NC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NC() {
        e.Mv().aQQ.get().vZ().wA().b(this.mActivity, this.mScope, this.aVk).g(new com.baidu.swan.apps.an.d.a<g<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(g<JSONObject> gVar) {
                if (gVar == null || !gVar.isOk() || gVar.mData == null) {
                    a.this.aVu.ab(10002L).ig("bad MaOpenData response");
                    a.this.finish();
                    return;
                }
                c.i("OpenData", gVar.mData.toString());
                a.this.aVu.ab(gVar.mData.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE));
                a.this.aVu.ig(gVar.mData.optString("errmsg", ""));
                if (0 != a.this.aVu.OS()) {
                    a.this.aVu.ig("by errno");
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = gVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    a.this.aVu.ab(14L).ig("by data parse");
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e ag = com.baidu.swan.apps.setting.oauth.e.ag(optJSONObject.optJSONObject("scope"));
                if (ag == null) {
                    a.this.aVu.ab(14L).ig("illegal scope");
                    a.this.finish();
                    return;
                }
                a.this.aVt = optJSONObject.optJSONObject("opendata");
                if (ag.aUS < 0) {
                    a.this.aVu.ab(10005L).ig("by tipStatus");
                    a.this.finish();
                } else if (ag.aUS <= 0) {
                    if (a.this.mIsLogin || !ag.Nw()) {
                        com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.aFI, ag, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                            @Override // com.baidu.swan.apps.setting.oauth.a
                            public void bE(boolean z) {
                                if (!z) {
                                    a.this.aVu.ab(10003L).ig("by dialog cancel");
                                }
                                a.this.cw(z);
                            }
                        });
                    } else {
                        a.this.login();
                    }
                } else {
                    a.this.aVt = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).No();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.aFI.Mi().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.a("onResult :: " + i, (Boolean) false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_UESR_REFUSE", (Boolean) true);
                        a.this.aVu.ab(10004L).ig("login cancel by user");
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.a("login error ERR_BY_LOGIN", (Boolean) true);
                        a.this.aVu.ab(10004L).ig("system login error");
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.a("Login Preparation ok, is already login", (Boolean) false);
                        a.this.mIsLogin = true;
                        a.this.NC();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(final boolean z) {
        e.Mv().aQQ.get().vZ().wA().a(this.mActivity, z, this.mScope).g(new com.baidu.swan.apps.an.d.a<g<a.C0180a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(g<a.C0180a> gVar) {
                if (!z && !a.this.aVv) {
                    a.this.finish();
                } else if (gVar == null || !gVar.isOk() || gVar.mData == null || gVar.mData.aUX == null) {
                    a.this.aVu.ab(10002L).ig("bad Accredit response");
                    a.this.finish();
                } else {
                    a.this.aVt = gVar.mData.aUX;
                    a.this.finish();
                }
            }
        }).No();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.aVw.finish();
        synchronized (aVr) {
            aVr.remove(aB(this.mScope, this.aVk));
        }
        this.aVs = TaskState.FINISHED;
        if (this.aVt == null && 0 == this.aVu.OV()) {
            this.aVu.ab(15L);
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.aUf) {
                    for (com.baidu.swan.apps.an.d.a aVar : a.this.aUf) {
                        aVar.D(a.this);
                    }
                    a.this.aUf.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(NA()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.aVu));
        if (this.aVt != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.aVt));
        }
        return sb.toString();
    }
}
