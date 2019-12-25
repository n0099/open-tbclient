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
/* loaded from: classes9.dex */
public final class a {
    private static final Map<String, a> bPA = new HashMap();
    private e bCj;
    public JSONObject bOM;
    private final String bPa;
    private boolean bPd;
    public final Activity mActivity;
    private final String mScope;
    private final Set<b<a>> bEW = new HashSet();
    private TaskState bPB = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ap.a bPC = new com.baidu.swan.apps.ap.a().aB(8).mh("OpenData");
    private boolean bPD = false;
    private final com.baidu.swan.apps.as.c.a bPE = new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, b<a> bVar) {
        synchronized (bPA) {
            String C = C(str, z);
            a aVar = bPA.get(C);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                bPA.put(C, aVar2);
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

    public boolean abR() {
        return TaskState.FINISHED == this.bPB && 0 == this.bPC.adB() && this.bOM != null;
    }

    public boolean abS() {
        return TaskState.FINISHED == this.bPB && this.bOM != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.bPa = str2;
        this.bPd = z;
    }

    private a i(b<a> bVar) {
        if (bVar != null) {
            synchronized (this.bEW) {
                this.bEW.add(bVar);
            }
        }
        return this;
    }

    private void j(b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.bPB = TaskState.CALLING;
        this.bPD = TextUtils.equals(this.mScope, "snsapi_userinfo");
        i(bVar);
        this.bCj = e.ZS();
        if (this.bCj == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.bPC.aD(10001L);
            finish();
            return;
        }
        this.bCj.aac().bNI.b(this.bPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.bCj.aad().isLogin(this.mActivity);
        abT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abT() {
        d.ZP().ZR().Ei().Ff().a(this.mActivity, this.mScope, this.bPa, this.bPd, this.mIsLogin).h(new b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.bPC.aD(10001L);
                    a.this.finish();
                    return;
                }
                c.i("OpenData", hVar.mData.toString());
                a.this.bPC.aD(hVar.mData.optInt("errno", 10001));
                a.this.bPC.mh(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.bPC.ady()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.bPC.aD(10001L);
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.bPC.aD(10001L);
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e aQ = com.baidu.swan.apps.setting.oauth.e.aQ(optJSONObject.optJSONObject("scope"));
                if (aQ == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.bPC.aD(10001L);
                    a.this.finish();
                    return;
                }
                a.this.bOM = optJSONObject.optJSONObject("opendata");
                if (!a.this.bPd && aQ.bOA < 0) {
                    if (aQ.bOA == -2) {
                        a.this.bPC.aD(10006L);
                    } else {
                        a.this.bPC.aD(10005L);
                    }
                    a.this.finish();
                } else if (aQ.bOA <= 0) {
                    if (!a.this.bCj.GS()) {
                        if (a.this.mIsLogin || !aQ.abD()) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.bCj, aQ, a.this.bOM, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.bPC.aD(10003L);
                                    }
                                    a.this.dE(z);
                                }
                            });
                            return;
                        } else {
                            a.this.login();
                            return;
                        }
                    }
                    a.this.bPC.aD(10005L);
                    a.this.finish();
                } else {
                    a.this.bOM = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).abv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.bCj.aad().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.bPC.aD(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.bPC.aD(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.abT();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(final boolean z) {
        if (TextUtils.isEmpty(this.bPa)) {
            d.ZP().ZR().Ei().Ff().a(this.mActivity, z, this.mScope, this.bPa).h(new b<h<a.C0282a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(h<a.C0282a> hVar) {
                    if (!z && !a.this.bPD) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.bPb == null) {
                        a.this.bPC.aD(10002L).mh("bad Accredit response");
                        a.this.finish();
                    } else {
                        a.this.bOM = hVar.mData.bPb;
                        a.this.finish();
                    }
                }
            }).abv();
        } else {
            d.ZP().ZR().Ei().Ff().a(this.mActivity, true, z, new String[]{this.mScope}, this.bPa, true).h(new b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.bPC.aD(10002L).mh("bad authorize response");
                    }
                    a.this.finish();
                }
            }).abv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.bPE.finish();
        synchronized (bPA) {
            bPA.remove(C(this.mScope, this.bPd));
        }
        this.bPB = TaskState.FINISHED;
        if (this.bOM == null && 0 == this.bPC.adB()) {
            if (this.mIsLogin) {
                this.bPC.aD(10001L);
            } else {
                this.bPC.aD(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.bEW) {
                    for (com.baidu.swan.apps.as.d.b bVar : a.this.bEW) {
                        bVar.B(a.this);
                    }
                    a.this.bEW.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(abR()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.bPC));
        if (this.bOM != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.bOM));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.bPB));
        return sb.toString();
    }
}
