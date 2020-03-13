package com.baidu.swan.apps.setting.b;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.swan.apps.as.d.b;
import com.baidu.swan.apps.console.c;
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
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final Map<String, a> bUr = new HashMap();
    private e bHd;
    public JSONObject bTD;
    private final String bTR;
    private boolean bTU;
    public final Activity mActivity;
    private final String mScope;
    private final Set<b<a>> bJO = new HashSet();
    private TaskState bUs = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ap.a bUt = new com.baidu.swan.apps.ap.a().aI(8).mz("OpenData");
    private boolean bUu = false;
    private final com.baidu.swan.apps.as.c.a bUv = new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, b<a> bVar) {
        synchronized (bUr) {
            String C = C(str, z);
            a aVar = bUr.get(C);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                bUr.put(C, aVar2);
                aVar2.j(bVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar.toString());
                aVar.i(bVar);
            }
        }
    }

    private static String C(String str, boolean z) {
        return str + "/" + (z ? "1" : "0");
    }

    public boolean aeE() {
        return TaskState.FINISHED == this.bUs && 0 == this.bUt.agk() && this.bTD != null;
    }

    public boolean aeF() {
        return TaskState.FINISHED == this.bUs && this.bTD != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.bTR = str2;
        this.bTU = z;
    }

    private a i(b<a> bVar) {
        if (bVar != null) {
            synchronized (this.bJO) {
                this.bJO.add(bVar);
            }
        }
        return this;
    }

    private void j(b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.bUs = TaskState.CALLING;
        this.bUu = TextUtils.equals(this.mScope, "snsapi_userinfo");
        i(bVar);
        this.bHd = e.acF();
        if (this.bHd == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.bUt.aK(10001L);
            finish();
            return;
        }
        this.bHd.acP().bSz.b(this.bUv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.bHd.acQ().isLogin(this.mActivity);
        aeG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeG() {
        d.acC().acE().GV().HS().a(this.mActivity, this.mScope, this.bTR, this.bTU, this.mIsLogin).h(new b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.bUt.aK(10001L);
                    a.this.finish();
                    return;
                }
                c.i("OpenData", hVar.mData.toString());
                a.this.bUt.aK(hVar.mData.optInt("errno", 10001));
                a.this.bUt.mz(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.bUt.agh()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.bUt.aK(10001L);
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.bUt.aK(10001L);
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e aQ = com.baidu.swan.apps.setting.oauth.e.aQ(optJSONObject.optJSONObject("scope"));
                if (aQ == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.bUt.aK(10001L);
                    a.this.finish();
                    return;
                }
                a.this.bTD = optJSONObject.optJSONObject("opendata");
                if (!a.this.bTU && aQ.bTr < 0) {
                    if (aQ.bTr == -2) {
                        a.this.bUt.aK(10006L);
                    } else {
                        a.this.bUt.aK(10005L);
                    }
                    a.this.finish();
                } else if (aQ.bTr <= 0) {
                    if (!a.this.bHd.JF()) {
                        if (a.this.mIsLogin || !aQ.aeq()) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.bHd, aQ, a.this.bTD, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.bUt.aK(10003L);
                                    }
                                    a.this.dQ(z);
                                }
                            });
                            return;
                        } else {
                            a.this.login();
                            return;
                        }
                    }
                    a.this.bUt.aK(10005L);
                    a.this.finish();
                } else {
                    a.this.bTD = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aei();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.bHd.acQ().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.bUt.aK(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.bUt.aK(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aeG();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(final boolean z) {
        if (TextUtils.isEmpty(this.bTR)) {
            d.acC().acE().GV().HS().a(this.mActivity, z, this.mScope, this.bTR).h(new b<h<a.C0294a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(h<a.C0294a> hVar) {
                    if (!z && !a.this.bUu) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.bTS == null) {
                        a.this.bUt.aK(10002L).mz("bad Accredit response");
                        a.this.finish();
                    } else {
                        a.this.bTD = hVar.mData.bTS;
                        a.this.finish();
                    }
                }
            }).aei();
        } else {
            d.acC().acE().GV().HS().a(this.mActivity, true, z, new String[]{this.mScope}, this.bTR, true).h(new b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.bUt.aK(10002L).mz("bad authorize response");
                    }
                    a.this.finish();
                }
            }).aei();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.bUv.finish();
        synchronized (bUr) {
            bUr.remove(C(this.mScope, this.bTU));
        }
        this.bUs = TaskState.FINISHED;
        if (this.bTD == null && 0 == this.bUt.agk()) {
            if (this.mIsLogin) {
                this.bUt.aK(10001L);
            } else {
                this.bUt.aK(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.bJO) {
                    for (com.baidu.swan.apps.as.d.b bVar : a.this.bJO) {
                        bVar.D(a.this);
                    }
                    a.this.bJO.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aeE()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.bUt));
        if (this.bTD != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.bTD));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.bUs));
        return sb.toString();
    }
}
