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
    private static final Map<String, a> ctr = new HashMap();
    private e cfX;
    public JSONObject csD;
    private final String csR;
    private boolean csU;
    public final Activity mActivity;
    private final String mScope;
    private final Set<b<a>> ciJ = new HashSet();
    private TaskState cts = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ap.a ctt = new com.baidu.swan.apps.ap.a().bn(8).nL("OpenData");
    private boolean ctu = false;
    private final com.baidu.swan.apps.as.c.a ctv = new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, b<a> bVar) {
        synchronized (ctr) {
            String H = H(str, z);
            a aVar = ctr.get(H);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                ctr.put(H, aVar2);
                aVar2.j(bVar);
            } else {
                c.i("OpenData", "reuse session : " + aVar.toString());
                aVar.i(bVar);
            }
        }
    }

    private static String H(String str, boolean z) {
        return str + "/" + (z ? "1" : "0");
    }

    public boolean amM() {
        return TaskState.FINISHED == this.cts && 0 == this.ctt.aos() && this.csD != null;
    }

    public boolean amN() {
        return TaskState.FINISHED == this.cts && this.csD != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.csR = str2;
        this.csU = z;
    }

    private a i(b<a> bVar) {
        if (bVar != null) {
            synchronized (this.ciJ) {
                this.ciJ.add(bVar);
            }
        }
        return this;
    }

    private void j(b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.cts = TaskState.CALLING;
        this.ctu = TextUtils.equals(this.mScope, "snsapi_userinfo");
        i(bVar);
        this.cfX = e.akN();
        if (this.cfX == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.ctt.bp(10001L);
            finish();
            return;
        }
        this.cfX.akX().crz.b(this.ctv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.cfX.akY().isLogin(this.mActivity);
        amO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amO() {
        d.akK().akM().ON().PH().a(this.mActivity, this.mScope, this.csR, this.csU, this.mIsLogin).h(new b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.ctt.bp(10001L);
                    a.this.finish();
                    return;
                }
                c.i("OpenData", hVar.mData.toString());
                a.this.ctt.bp(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.ctt.nL(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.ctt.aop()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.ctt.bp(10001L);
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.ctt.bp(10001L);
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bb = com.baidu.swan.apps.setting.oauth.e.bb(optJSONObject.optJSONObject("scope"));
                if (bb == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.ctt.bp(10001L);
                    a.this.finish();
                    return;
                }
                a.this.csD = optJSONObject.optJSONObject("opendata");
                if (!a.this.csU && bb.csr < 0) {
                    if (bb.csr == -2) {
                        a.this.ctt.bp(10006L);
                    } else {
                        a.this.ctt.bp(10005L);
                    }
                    a.this.finish();
                } else if (bb.csr <= 0) {
                    if (!a.this.cfX.Ru()) {
                        if (a.this.mIsLogin || !bb.amy()) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.cfX, bb, a.this.csD, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.ctt.bp(10003L);
                                    }
                                    a.this.eN(z);
                                }
                            });
                            return;
                        } else {
                            a.this.login();
                            return;
                        }
                    }
                    a.this.ctt.bp(10005L);
                    a.this.finish();
                } else {
                    a.this.csD = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).amq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.cfX.akY().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.ctt.bp(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.ctt.bp(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.amO();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(final boolean z) {
        if (TextUtils.isEmpty(this.csR)) {
            d.akK().akM().ON().PH().a(this.mActivity, z, this.mScope, this.csR).h(new b<h<a.C0324a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void E(h<a.C0324a> hVar) {
                    if (!z && !a.this.ctu) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.csS == null) {
                        a.this.ctt.bp(10002L).nL("bad Accredit response");
                        a.this.finish();
                    } else {
                        a.this.csD = hVar.mData.csS;
                        a.this.finish();
                    }
                }
            }).amq();
        } else {
            d.akK().akM().ON().PH().a(this.mActivity, true, z, new String[]{this.mScope}, this.csR, true).h(new b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void E(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.ctt.bp(10002L).nL("bad authorize response");
                    }
                    a.this.finish();
                }
            }).amq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.ctv.finish();
        synchronized (ctr) {
            ctr.remove(H(this.mScope, this.csU));
        }
        this.cts = TaskState.FINISHED;
        if (this.csD == null && 0 == this.ctt.aos()) {
            if (this.mIsLogin) {
                this.ctt.bp(10001L);
            } else {
                this.ctt.bp(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.j(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.ciJ) {
                    for (com.baidu.swan.apps.as.d.b bVar : a.this.ciJ) {
                        bVar.E(a.this);
                    }
                    a.this.ciJ.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(amM()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.ctt));
        if (this.csD != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.csD));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.cts));
        return sb.toString();
    }
}
