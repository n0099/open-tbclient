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
/* loaded from: classes10.dex */
public final class a {
    private static final Map<String, a> bQk = new HashMap();
    private e bCV;
    private final String bPK;
    private boolean bPN;
    public JSONObject bPw;
    public final Activity mActivity;
    private final String mScope;
    private final Set<b<a>> bFH = new HashSet();
    private TaskState bQl = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ap.a bQm = new com.baidu.swan.apps.ap.a().aE(8).mk("OpenData");
    private boolean bQn = false;
    private final com.baidu.swan.apps.as.c.a bQo = new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, b<a> bVar) {
        synchronized (bQk) {
            String C = C(str, z);
            a aVar = bQk.get(C);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                bQk.put(C, aVar2);
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

    public boolean aco() {
        return TaskState.FINISHED == this.bQl && 0 == this.bQm.adU() && this.bPw != null;
    }

    public boolean acp() {
        return TaskState.FINISHED == this.bQl && this.bPw != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.bPK = str2;
        this.bPN = z;
    }

    private a i(b<a> bVar) {
        if (bVar != null) {
            synchronized (this.bFH) {
                this.bFH.add(bVar);
            }
        }
        return this;
    }

    private void j(b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.bQl = TaskState.CALLING;
        this.bQn = TextUtils.equals(this.mScope, "snsapi_userinfo");
        i(bVar);
        this.bCV = e.aap();
        if (this.bCV == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.bQm.aG(10001L);
            finish();
            return;
        }
        this.bCV.aaz().bOs.b(this.bQo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.bCV.aaA().isLogin(this.mActivity);
        acq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acq() {
        d.aam().aao().EE().FB().a(this.mActivity, this.mScope, this.bPK, this.bPN, this.mIsLogin).h(new b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.bQm.aG(10001L);
                    a.this.finish();
                    return;
                }
                c.i("OpenData", hVar.mData.toString());
                a.this.bQm.aG(hVar.mData.optInt("errno", 10001));
                a.this.bQm.mk(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.bQm.adR()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.bQm.aG(10001L);
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.bQm.aG(10001L);
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e aQ = com.baidu.swan.apps.setting.oauth.e.aQ(optJSONObject.optJSONObject("scope"));
                if (aQ == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.bQm.aG(10001L);
                    a.this.finish();
                    return;
                }
                a.this.bPw = optJSONObject.optJSONObject("opendata");
                if (!a.this.bPN && aQ.bPk < 0) {
                    if (aQ.bPk == -2) {
                        a.this.bQm.aG(10006L);
                    } else {
                        a.this.bQm.aG(10005L);
                    }
                    a.this.finish();
                } else if (aQ.bPk <= 0) {
                    if (!a.this.bCV.Ho()) {
                        if (a.this.mIsLogin || !aQ.aca()) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.bCV, aQ, a.this.bPw, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.bQm.aG(10003L);
                                    }
                                    a.this.dJ(z);
                                }
                            });
                            return;
                        } else {
                            a.this.login();
                            return;
                        }
                    }
                    a.this.bQm.aG(10005L);
                    a.this.finish();
                } else {
                    a.this.bPw = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).abS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.bCV.aaA().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.bQm.aG(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.bQm.aG(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.acq();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJ(final boolean z) {
        if (TextUtils.isEmpty(this.bPK)) {
            d.aam().aao().EE().FB().a(this.mActivity, z, this.mScope, this.bPK).h(new b<h<a.C0284a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(h<a.C0284a> hVar) {
                    if (!z && !a.this.bQn) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.bPL == null) {
                        a.this.bQm.aG(10002L).mk("bad Accredit response");
                        a.this.finish();
                    } else {
                        a.this.bPw = hVar.mData.bPL;
                        a.this.finish();
                    }
                }
            }).abS();
        } else {
            d.aam().aao().EE().FB().a(this.mActivity, true, z, new String[]{this.mScope}, this.bPK, true).h(new b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.bQm.aG(10002L).mk("bad authorize response");
                    }
                    a.this.finish();
                }
            }).abS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.bQo.finish();
        synchronized (bQk) {
            bQk.remove(C(this.mScope, this.bPN));
        }
        this.bQl = TaskState.FINISHED;
        if (this.bPw == null && 0 == this.bQm.adU()) {
            if (this.mIsLogin) {
                this.bQm.aG(10001L);
            } else {
                this.bQm.aG(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.bFH) {
                    for (com.baidu.swan.apps.as.d.b bVar : a.this.bFH) {
                        bVar.B(a.this);
                    }
                    a.this.bFH.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aco()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.bQm));
        if (this.bPw != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.bPw));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.bQl));
        return sb.toString();
    }
}
