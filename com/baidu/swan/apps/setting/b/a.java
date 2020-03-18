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
    private static final Map<String, a> bUC = new HashMap();
    private e bHo;
    public JSONObject bTO;
    private final String bUc;
    private boolean bUf;
    public final Activity mActivity;
    private final String mScope;
    private final Set<b<a>> bJZ = new HashSet();
    private TaskState bUD = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ap.a bUE = new com.baidu.swan.apps.ap.a().aI(8).my("OpenData");
    private boolean bUF = false;
    private final com.baidu.swan.apps.as.c.a bUG = new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, b<a> bVar) {
        synchronized (bUC) {
            String C = C(str, z);
            a aVar = bUC.get(C);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                bUC.put(C, aVar2);
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

    public boolean aeH() {
        return TaskState.FINISHED == this.bUD && 0 == this.bUE.agn() && this.bTO != null;
    }

    public boolean aeI() {
        return TaskState.FINISHED == this.bUD && this.bTO != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.bUc = str2;
        this.bUf = z;
    }

    private a i(b<a> bVar) {
        if (bVar != null) {
            synchronized (this.bJZ) {
                this.bJZ.add(bVar);
            }
        }
        return this;
    }

    private void j(b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.bUD = TaskState.CALLING;
        this.bUF = TextUtils.equals(this.mScope, "snsapi_userinfo");
        i(bVar);
        this.bHo = e.acI();
        if (this.bHo == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.bUE.aK(10001L);
            finish();
            return;
        }
        this.bHo.acS().bSK.b(this.bUG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.bHo.acT().isLogin(this.mActivity);
        aeJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeJ() {
        d.acF().acH().Ha().HV().a(this.mActivity, this.mScope, this.bUc, this.bUf, this.mIsLogin).h(new b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.bUE.aK(10001L);
                    a.this.finish();
                    return;
                }
                c.i("OpenData", hVar.mData.toString());
                a.this.bUE.aK(hVar.mData.optInt("errno", 10001));
                a.this.bUE.my(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.bUE.agk()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.bUE.aK(10001L);
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.bUE.aK(10001L);
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e aQ = com.baidu.swan.apps.setting.oauth.e.aQ(optJSONObject.optJSONObject("scope"));
                if (aQ == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.bUE.aK(10001L);
                    a.this.finish();
                    return;
                }
                a.this.bTO = optJSONObject.optJSONObject("opendata");
                if (!a.this.bUf && aQ.bTC < 0) {
                    if (aQ.bTC == -2) {
                        a.this.bUE.aK(10006L);
                    } else {
                        a.this.bUE.aK(10005L);
                    }
                    a.this.finish();
                } else if (aQ.bTC <= 0) {
                    if (!a.this.bHo.JI()) {
                        if (a.this.mIsLogin || !aQ.aet()) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.bHo, aQ, a.this.bTO, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.bUE.aK(10003L);
                                    }
                                    a.this.dR(z);
                                }
                            });
                            return;
                        } else {
                            a.this.login();
                            return;
                        }
                    }
                    a.this.bUE.aK(10005L);
                    a.this.finish();
                } else {
                    a.this.bTO = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).ael();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.bHo.acT().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.bUE.aK(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.bUE.aK(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aeJ();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dR(final boolean z) {
        if (TextUtils.isEmpty(this.bUc)) {
            d.acF().acH().Ha().HV().a(this.mActivity, z, this.mScope, this.bUc).h(new b<h<a.C0294a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(h<a.C0294a> hVar) {
                    if (!z && !a.this.bUF) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.bUd == null) {
                        a.this.bUE.aK(10002L).my("bad Accredit response");
                        a.this.finish();
                    } else {
                        a.this.bTO = hVar.mData.bUd;
                        a.this.finish();
                    }
                }
            }).ael();
        } else {
            d.acF().acH().Ha().HV().a(this.mActivity, true, z, new String[]{this.mScope}, this.bUc, true).h(new b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.bUE.aK(10002L).my("bad authorize response");
                    }
                    a.this.finish();
                }
            }).ael();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.bUG.finish();
        synchronized (bUC) {
            bUC.remove(C(this.mScope, this.bUf));
        }
        this.bUD = TaskState.FINISHED;
        if (this.bTO == null && 0 == this.bUE.agn()) {
            if (this.mIsLogin) {
                this.bUE.aK(10001L);
            } else {
                this.bUE.aK(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.bJZ) {
                    for (com.baidu.swan.apps.as.d.b bVar : a.this.bJZ) {
                        bVar.D(a.this);
                    }
                    a.this.bJZ.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aeH()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.bUE));
        if (this.bTO != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.bTO));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.bUD));
        return sb.toString();
    }
}
