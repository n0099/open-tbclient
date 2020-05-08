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
    private static final Map<String, a> cty = new HashMap();
    private e cgd;
    public JSONObject csJ;
    private final String csX;
    private boolean cta;
    public final Activity mActivity;
    private final String mScope;
    private final Set<b<a>> ciP = new HashSet();
    private TaskState ctz = TaskState.INIT;
    private boolean mIsLogin = false;
    public final com.baidu.swan.apps.ap.a ctA = new com.baidu.swan.apps.ap.a().bn(8).nL("OpenData");
    private boolean ctB = false;
    private final com.baidu.swan.apps.as.c.a ctC = new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.onStart();
        }
    };

    public static void a(Activity activity, String str, String str2, boolean z, b<a> bVar) {
        synchronized (cty) {
            String H = H(str, z);
            a aVar = cty.get(H);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                cty.put(H, aVar2);
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

    public boolean amL() {
        return TaskState.FINISHED == this.ctz && 0 == this.ctA.aor() && this.csJ != null;
    }

    public boolean amM() {
        return TaskState.FINISHED == this.ctz && this.csJ != null;
    }

    private a(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.csX = str2;
        this.cta = z;
    }

    private a i(b<a> bVar) {
        if (bVar != null) {
            synchronized (this.ciP) {
                this.ciP.add(bVar);
            }
        }
        return this;
    }

    private void j(b<a> bVar) {
        c.i("OpenData", "start session : " + this.mScope);
        this.ctz = TaskState.CALLING;
        this.ctB = TextUtils.equals(this.mScope, "snsapi_userinfo");
        i(bVar);
        this.cgd = e.akM();
        if (this.cgd == null) {
            com.baidu.swan.apps.setting.oauth.c.c("SwanApp is null", true);
            this.ctA.bp(10001L);
            finish();
            return;
        }
        this.cgd.akW().crF.b(this.ctC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        this.mIsLogin = this.cgd.akX().isLogin(this.mActivity);
        amN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amN() {
        d.akJ().akL().OM().PG().a(this.mActivity, this.mScope, this.csX, this.cta, this.mIsLogin).h(new b<h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.b.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void F(h<JSONObject> hVar) {
                if (hVar == null || !hVar.isOk() || hVar.mData == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad MaOpenData response", true);
                    a.this.ctA.bp(10001L);
                    a.this.finish();
                    return;
                }
                c.i("OpenData", hVar.mData.toString());
                a.this.ctA.bp(hVar.mData.optInt(BaseJsonData.TAG_ERRNO, 10001));
                a.this.ctA.nL(hVar.mData.optString(BaseJsonData.TAG_ERRMSG, "internal error"));
                if (0 != a.this.ctA.aoo()) {
                    com.baidu.swan.apps.setting.oauth.c.c("by errno", true);
                    a.this.ctA.bp(10001L);
                    a.this.finish();
                    return;
                }
                JSONObject optJSONObject = hVar.mData.optJSONObject("data");
                if (optJSONObject == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("by data parse", true);
                    a.this.ctA.bp(10001L);
                    a.this.finish();
                    return;
                }
                com.baidu.swan.apps.setting.oauth.e bb = com.baidu.swan.apps.setting.oauth.e.bb(optJSONObject.optJSONObject("scope"));
                if (bb == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("illegal scope", true);
                    a.this.ctA.bp(10001L);
                    a.this.finish();
                    return;
                }
                a.this.csJ = optJSONObject.optJSONObject("opendata");
                if (!a.this.cta && bb.csx < 0) {
                    if (bb.csx == -2) {
                        a.this.ctA.bp(10006L);
                    } else {
                        a.this.ctA.bp(10005L);
                    }
                    a.this.finish();
                } else if (bb.csx <= 0) {
                    if (!a.this.cgd.Rt()) {
                        if (a.this.mIsLogin || !bb.amx()) {
                            com.baidu.swan.apps.setting.oauth.c.a(a.this.mActivity, a.this.cgd, bb, a.this.csJ, new com.baidu.swan.apps.setting.oauth.a() { // from class: com.baidu.swan.apps.setting.b.a.2.1
                                @Override // com.baidu.swan.apps.setting.oauth.a
                                public void onResult(boolean z) {
                                    if (!z) {
                                        a.this.ctA.bp(10003L);
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
                    a.this.ctA.bp(10005L);
                    a.this.finish();
                } else {
                    a.this.csJ = optJSONObject.optJSONObject("opendata");
                    a.this.finish();
                }
            }
        }).amp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        this.cgd.akX().a(this.mActivity, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.b.a.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                com.baidu.swan.apps.setting.oauth.c.c("onResult :: " + i, false);
                switch (i) {
                    case -2:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_UESR_REFUSE", true);
                        a.this.ctA.bp(10004L);
                        a.this.finish();
                        return;
                    case -1:
                    default:
                        com.baidu.swan.apps.setting.oauth.c.c("login error ERR_BY_LOGIN", true);
                        a.this.ctA.bp(10004L);
                        a.this.finish();
                        return;
                    case 0:
                        com.baidu.swan.apps.setting.oauth.c.c("Login Preparation ok, is already login", false);
                        a.this.mIsLogin = true;
                        a.this.amN();
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(final boolean z) {
        if (TextUtils.isEmpty(this.csX)) {
            d.akJ().akL().OM().PG().a(this.mActivity, z, this.mScope, this.csX).h(new b<h<a.C0345a>>() { // from class: com.baidu.swan.apps.setting.b.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void F(h<a.C0345a> hVar) {
                    if (!z && !a.this.ctB) {
                        a.this.finish();
                    } else if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.csY == null) {
                        a.this.ctA.bp(10002L).nL("bad Accredit response");
                        a.this.finish();
                    } else {
                        a.this.csJ = hVar.mData.csY;
                        a.this.finish();
                    }
                }
            }).amp();
        } else {
            d.akJ().akL().OM().PG().a(this.mActivity, true, z, new String[]{this.mScope}, this.csX, true).h(new b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.b.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void F(h<b.d> hVar) {
                    if (hVar == null || !hVar.isOk()) {
                        a.this.ctA.bp(10002L).nL("bad authorize response");
                    }
                    a.this.finish();
                }
            }).amp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.ctC.finish();
        synchronized (cty) {
            cty.remove(H(this.mScope, this.cta));
        }
        this.ctz = TaskState.FINISHED;
        if (this.csJ == null && 0 == this.ctA.aor()) {
            if (this.mIsLogin) {
                this.ctA.bp(10001L);
            } else {
                this.ctA.bp(10004L);
            }
        }
        c.i("OpenData", "onFinish" + toString());
        com.baidu.swan.apps.setting.oauth.c.j(new Runnable() { // from class: com.baidu.swan.apps.setting.b.a.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.ciP) {
                    for (com.baidu.swan.apps.as.d.b bVar : a.this.ciP) {
                        bVar.F(a.this);
                    }
                    a.this.ciP.clear();
                }
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.mScope, Boolean.valueOf(amL()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.ctA));
        if (this.csJ != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.csJ));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.ctz));
        return sb.toString();
    }
}
