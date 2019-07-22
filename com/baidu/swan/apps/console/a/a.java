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
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.apps.u.b.c;
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
public class a extends z {
    private static Set<String> anI;
    private static Set<String> anJ = new HashSet();
    private c anF;
    private ExecutorService anG;
    private int anH;

    public a(j jVar) {
        super(jVar, "/swan/debuggerlaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        boolean equals = TextUtils.equals(f.NX().getString("enableSwitch", "1"), "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0 || !equals) {
            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.anF = c.t(optParamsAsJo);
        if (this.anF == null) {
            Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!yj()) {
            Q(context, "404");
            return false;
        } else {
            if (yi().contains(com.baidu.swan.apps.u.a.Ep().bc(context)) || anJ.contains(aP(context))) {
                a(context, unitedSchemeEntity, callbackHandler);
            } else {
                com.baidu.swan.apps.u.a.Ep().a(this.anF.appKey, new c.a() { // from class: com.baidu.swan.apps.console.a.a.1
                    @Override // com.baidu.swan.apps.u.b.c.a
                    public void k(Exception exc) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.Q(context, "401");
                    }

                    @Override // com.baidu.swan.apps.u.b.c.a
                    public void aX(boolean z) {
                        if (z) {
                            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Success");
                            a.anJ.add(a.this.aP(context));
                            a.this.a(context, unitedSchemeEntity, callbackHandler);
                            return;
                        }
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Fail : Not developer");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.Q(context, "401");
                    }
                });
            }
            return true;
        }
    }

    private Set<String> yi() {
        if (anI == null) {
            anI = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(f.NX().getString("authWlist", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    anI.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return anI;
    }

    private boolean yj() {
        return (this.anF.anN == null || this.anF.anN.length() <= 0 || TextUtils.isEmpty(this.anF.anO)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aP(Context context) {
        return com.baidu.swan.apps.u.a.Ep().bc(context) + this.anF.appKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        int i = 0;
        final File Ee = e.C0146e.Ee();
        if (Ee.exists()) {
            Ee.delete();
        }
        this.anG = Executors.newFixedThreadPool(4);
        this.anH = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.anF.anN.length()) {
                final String bR = this.anF.bR(i2);
                if (TextUtils.isEmpty(bR)) {
                    int i3 = this.anH + 1;
                    this.anH = i3;
                    if (i3 >= this.anF.anN.length()) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                        Q(context, "404");
                    }
                } else {
                    this.anG.execute(new Runnable() { // from class: com.baidu.swan.apps.console.a.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(context, bR, Ee, unitedSchemeEntity, callbackHandler);
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
                com.baidu.swan.c.e.d(executeSync.body().byteStream(), file);
                com.baidu.swan.apps.v.b.c cVar = new com.baidu.swan.apps.v.b.c();
                cVar.mAppId = this.anF.appId;
                cVar.azt = false;
                cVar.azx = "1";
                Intent c = com.baidu.swan.apps.v.b.c.c(context, cVar);
                c.putExtra("remoteDebugUrl", str);
                context.startActivity(c);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.anG != null) {
                    this.anG.shutdownNow();
                    this.anG = null;
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
            int i = this.anH + 1;
            this.anH = i;
            if (i >= this.anF.anN.length()) {
                com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                Q(context, "404");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Context context, String str) {
        String string = f.NX().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, dr(str)).LQ();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + ds(string + "?" + str));
        }
    }

    private String dr(String str) {
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

    private String ds(String str) {
        try {
            return URLEncoder.encode(str, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
