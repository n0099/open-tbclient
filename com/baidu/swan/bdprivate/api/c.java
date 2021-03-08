package com.baidu.swan.bdprivate.api;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.swan.bdprivate.extensions.quicklogin.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b uC(String str) {
        if (DEBUG) {
            Log.d("Api-QuickLogin", "exec quickLogin");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-QuickLogin", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bh.first;
        if (!bVar.isSuccess() || bh.second == null) {
            com.baidu.swan.apps.console.c.e("Api-QuickLogin", "parse fail");
            return bVar;
        }
        final String optString = ((JSONObject) bh.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(1001, "cb is empty");
        }
        e aIO = e.aIO();
        if (aIO == null) {
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        aIO.aIZ().b(getContext(), "scope_quick_login", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.bdprivate.api.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    c.this.uD(optString);
                    return;
                }
                int errorCode = hVar.getErrorCode();
                String gp = com.baidu.swan.apps.setting.oauth.c.gp(errorCode);
                if (d.DEBUG) {
                    Log.e("Api-QuickLogin", "quick login failed: auth fail(" + errorCode + ", " + gp + ")");
                }
                c.this.a(optString, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.gp(errorCode)));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(final String str) {
        f.a(new com.baidu.swan.bdprivate.extensions.quicklogin.c() { // from class: com.baidu.swan.bdprivate.api.c.2
            @Override // com.baidu.swan.bdprivate.extensions.quicklogin.c
            public void a(QuickLoginInfo quickLoginInfo) {
                if (quickLoginInfo == null) {
                    c.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                boolean z = quickLoginInfo.supportQuickLogin;
                int i = quickLoginInfo.loginMode;
                if (z) {
                    f.a(com.baidu.swan.apps.runtime.d.aIJ().aIH(), i, new com.baidu.swan.bdprivate.extensions.quicklogin.e() { // from class: com.baidu.swan.bdprivate.api.c.2.1
                        @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
                        public void onResult(int i2) {
                            if (i2 == 0) {
                                c.this.a(str, new com.baidu.swan.apps.api.c.b(0));
                            } else {
                                c.this.a(str, new com.baidu.swan.apps.api.c.b(10004, "user not logged in"));
                            }
                        }
                    });
                } else {
                    c.this.a(str, new com.baidu.swan.apps.api.c.b(10004, "user not logged in"));
                }
            }
        });
    }

    public com.baidu.swan.apps.api.c.b uE(String str) {
        if (DEBUG) {
            Log.d("Api-QuickLogin", "query quick login info");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-QuickLogin", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bh.first;
        if (!bVar.isSuccess() || bh.second == null) {
            com.baidu.swan.apps.console.c.e("Api-QuickLogin", "parse fail");
            return bVar;
        }
        final String optString = ((JSONObject) bh.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(1001, "cb is empty");
        }
        e aIO = e.aIO();
        if (aIO == null) {
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        aIO.aIZ().b(getContext(), "scope_quick_login", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.bdprivate.api.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    c.this.uF(optString);
                    return;
                }
                int errorCode = hVar.getErrorCode();
                String gp = com.baidu.swan.apps.setting.oauth.c.gp(errorCode);
                if (d.DEBUG) {
                    Log.e("Api-QuickLogin", "query quick login info failed: auth fail(" + errorCode + ", " + gp + ")");
                }
                c.this.a(optString, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.gp(errorCode)));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uF(final String str) {
        f.a(new com.baidu.swan.bdprivate.extensions.quicklogin.c() { // from class: com.baidu.swan.bdprivate.api.c.4
            @Override // com.baidu.swan.bdprivate.extensions.quicklogin.c
            public void a(QuickLoginInfo quickLoginInfo) {
                if (quickLoginInfo == null) {
                    c.this.uG(str);
                } else {
                    c.this.a(str, quickLoginInfo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, QuickLoginInfo quickLoginInfo) {
        if (quickLoginInfo == null) {
            a(str, new com.baidu.swan.apps.api.c.b(1001));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("supportQuickLogin", quickLoginInfo.supportQuickLogin);
            jSONObject.put("encryptPhoneNum", quickLoginInfo.encryptPhoneNum);
            jSONObject.put("serviceAgreement", quickLoginInfo.serviceAgreement);
            jSONObject.put("hasHistory", quickLoginInfo.hasHistory);
            if (DEBUG) {
                Log.d("Api-QuickLogin", "query login info; data: " + jSONObject.toString());
            }
            a(str, new com.baidu.swan.apps.api.c.b(0, jSONObject));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            a(str, new com.baidu.swan.apps.api.c.b(1001));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(String str) {
        a(str, new com.baidu.swan.apps.api.c.b(10001, "internal error"));
    }
}
