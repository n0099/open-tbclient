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
    private static final Map<String, a> bUp = new HashMap();
    private e bHb;
    public JSONObject bTB;
    private final String bTP;
    private boolean bTS;
    public final Activity mActivity;
    private final String mScope;
    private final Set<b<a>> bJM = new HashSet();
    private TaskState bUq = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ap.a bUr = new com.baidu.swan.apps.ap.a().aI(8).mz("OpenData");
    private boolean bUs = false;
    private final com.baidu.swan.apps.as.c.a bUt = new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, b<a> bVar) {
        synchronized (bUp) {
            String C = C(str, z);
            a aVar = bUp.get(C);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                bUp.put(C, aVar2);
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

    public boolean aeC() {
        return TaskState.FINISHED == this.bUq && 0 == this.bUr.agi() && this.bTB != null;
    }

    public boolean aeD() {
        return TaskState.FINISHED == this.bUq && this.bTB != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.bTP = str2;
        this.bTS = z;
    }

    private a i(b<a> bVar) {
        if (bVar != null) {
            synchronized (this.bJM) {
                this.bJM.add(bVar);
            }
        }
        return this;
    }

    private void j(b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.bUq = TaskState.CALLING;
        this.bUs = TextUtils.equals(this.mScope, "snsapi_userinfo");
        i(bVar);
        this.bHb = e.acD();
        if (this.bHb == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.bUr.aK(10001L);
            finish();
            return;
        }
        this.bHb.acN().bSx.b(this.bUt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.bHb.acO().isLogin(this.mActivity);
        aeE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeE() {
        d.acA().acC().GT().HQ().a(this.mActivity, this.mScope, this.bTP, this.bTS, this.mIsLogin).h(new b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.bUr.aK(10001L);
                    a.this.finish();
                    return;
                }
                c.i("OpenData", hVar.mData.toString());
                a.this.bUr.aK(hVar.mData.optInt("errno", 10001));
                a.this.bUr.mz(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.bUr.agf()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.bUr.aK(10001L);
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.bUr.aK(10001L);
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e aQ = com.baidu.swan.apps.setting.oauth.e.aQ(optJSONObject.optJSONObject("scope"));
                if (aQ == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.bUr.aK(10001L);
                    a.this.finish();
                    return;
                }
                a.this.bTB = optJSONObject.optJSONObject("opendata");
                if (!a.this.bTS && aQ.bTp < 0) {
                    if (aQ.bTp == -2) {
                        a.this.bUr.aK(10006L);
                    } else {
                        a.this.bUr.aK(10005L);
                    }
                    a.this.finish();
                } else if (aQ.bTp <= 0) {
                    if (!a.this.bHb.JD()) {
                        if (a.this.mIsLogin || !aQ.aeo()) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.bHb, aQ, a.this.bTB, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.bUr.aK(10003L);
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
                    a.this.bUr.aK(10005L);
                    a.this.finish();
                } else {
                    a.this.bTB = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).aeg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.bHb.acO().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.bUr.aK(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.bUr.aK(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.aeE();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(final boolean z) {
        if (TextUtils.isEmpty(this.bTP)) {
            d.acA().acC().GT().HQ().a(this.mActivity, z, this.mScope, this.bTP).h(new b<h<a.C0294a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(h<a.C0294a> hVar) {
                    if (!z && !a.this.bUs) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.bTQ == null) {
                        a.this.bUr.aK(10002L).mz("bad Accredit response");
                        a.this.finish();
                    } else {
                        a.this.bTB = hVar.mData.bTQ;
                        a.this.finish();
                    }
                }
            }).aeg();
        } else {
            d.acA().acC().GT().HQ().a(this.mActivity, true, z, new String[]{this.mScope}, this.bTP, true).h(new b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.bUr.aK(10002L).mz("bad authorize response");
                    }
                    a.this.finish();
                }
            }).aeg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.bUt.finish();
        synchronized (bUp) {
            bUp.remove(C(this.mScope, this.bTS));
        }
        this.bUq = TaskState.FINISHED;
        if (this.bTB == null && 0 == this.bUr.agi()) {
            if (this.mIsLogin) {
                this.bUr.aK(10001L);
            } else {
                this.bUr.aK(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.bJM) {
                    for (com.baidu.swan.apps.as.d.b bVar : a.this.bJM) {
                        bVar.D(a.this);
                    }
                    a.this.bJM.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(aeC()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.bUr));
        if (this.bTB != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.bTB));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.bUq));
        return sb.toString();
    }
}
