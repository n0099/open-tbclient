package com.baidu.swan.apps.console.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.apps.u.b.c;
import com.baidu.swan.c.e;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends y {
    private static Set<String> amO;
    private static Set<String> amP = new HashSet();
    private c amL;
    private ExecutorService amM;
    private int amN;

    public a(j jVar) {
        super(jVar, "/swan/debuggerlaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        boolean equals = TextUtils.equals(f.KL().getString("enableSwitch", "1"), "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0 || !equals) {
            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.amL = c.y(optParamsAsJo);
        if (this.amL == null) {
            Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!wN()) {
            ae(context, "404");
            return false;
        } else {
            if (wM().contains(com.baidu.swan.apps.u.a.CD().bI(context)) || amP.contains(bw(context))) {
                a(context, unitedSchemeEntity, callbackHandler);
            } else {
                com.baidu.swan.apps.u.a.CD().a(this.amL.appKey, new c.a() { // from class: com.baidu.swan.apps.console.a.a.1
                    @Override // com.baidu.swan.apps.u.b.c.a
                    public void k(Exception exc) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.ae(context, "401");
                    }

                    @Override // com.baidu.swan.apps.u.b.c.a
                    public void aS(boolean z) {
                        if (z) {
                            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Success");
                            a.amP.add(a.this.bw(context));
                            a.this.a(context, unitedSchemeEntity, callbackHandler);
                            return;
                        }
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Fail : Not developer");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.ae(context, "401");
                    }
                });
            }
            return true;
        }
    }

    private Set<String> wM() {
        if (amO == null) {
            amO = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(f.KL().getString("authWlist", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    amO.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return amO;
    }

    private boolean wN() {
        return (this.amL.amT == null || this.amL.amT.length() <= 0 || TextUtils.isEmpty(this.amL.amU)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bw(Context context) {
        return com.baidu.swan.apps.u.a.CD().bI(context) + this.amL.appKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        int i = 0;
        final File Cv = c.e.Cv();
        if (Cv.exists()) {
            Cv.delete();
        }
        this.amM = Executors.newFixedThreadPool(4);
        this.amN = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.amL.amT.length()) {
                final String bS = this.amL.bS(i2);
                if (TextUtils.isEmpty(bS)) {
                    int i3 = this.amN + 1;
                    this.amN = i3;
                    if (i3 >= this.amL.amT.length()) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                        ae(context, "404");
                    }
                } else {
                    this.amM.execute(new Runnable() { // from class: com.baidu.swan.apps.console.a.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(context, bS, Cv, unitedSchemeEntity, callbackHandler);
                        }
                    });
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [283=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = HttpManager.getDefault(context.getApplicationContext()).getRequest().url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                e.d(executeSync.body().byteStream(), file);
                com.baidu.swan.apps.v.b.c cVar = new com.baidu.swan.apps.v.b.c();
                cVar.mAppId = this.amL.appId;
                cVar.axS = false;
                cVar.axT = "1";
                Intent c = com.baidu.swan.apps.v.b.c.c(context, cVar);
                c.putExtra("remoteDebugUrl", str);
                context.startActivity(c);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.amM != null) {
                    this.amM.shutdownNow();
                    this.amM = null;
                }
            }
            if (executeSync != null) {
                if (0 != 0) {
                    executeSync.close();
                } else {
                    executeSync.close();
                }
            }
        } catch (IOException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            int i = this.amN + 1;
            this.amN = i;
            if (i >= this.amL.amT.length()) {
                com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                ae(context, "404");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Context context, String str) {
        String string = f.KL().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, dy(str)).IK();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + dz(string + "?" + str));
        }
    }

    private String dy(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 51509:
                if (str.equals("401")) {
                    c = 0;
                    break;
                }
                break;
            case 51512:
                if (str.equals("404")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "authorization fail " + str;
            case 1:
                return "IPs are invalid " + str;
            default:
                return "";
        }
    }

    private String dz(String str) {
        try {
            return URLEncoder.encode(str, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
