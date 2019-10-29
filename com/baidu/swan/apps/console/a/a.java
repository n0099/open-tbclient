package com.baidu.swan.apps.console.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TbEnum;
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
    private static Set<String> aHx;
    private static Set<String> aHy = new HashSet();
    private c aHu;
    private ExecutorService aHv;
    private int aHw;

    public a(j jVar) {
        super(jVar, "/swan/debuggerlaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        boolean equals = TextUtils.equals(f.SR().getString("enableSwitch", "1"), "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0 || !equals) {
            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.aHu = c.R(optParamsAsJo);
        if (this.aHu == null) {
            Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!Di()) {
            P(context, "404");
            return false;
        } else {
            if (Dh().contains(com.baidu.swan.apps.u.a.Jn().be(context)) || aHy.contains(aR(context))) {
                a(context, unitedSchemeEntity, callbackHandler);
            } else {
                com.baidu.swan.apps.u.a.Jn().a(this.aHu.appKey, new c.a() { // from class: com.baidu.swan.apps.console.a.a.1
                    @Override // com.baidu.swan.apps.u.b.c.a
                    public void k(Exception exc) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.P(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
                    }

                    @Override // com.baidu.swan.apps.u.b.c.a
                    public void bp(boolean z) {
                        if (z) {
                            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Success");
                            a.aHy.add(a.this.aR(context));
                            a.this.a(context, unitedSchemeEntity, callbackHandler);
                            return;
                        }
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Fail : Not developer");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.P(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
                    }
                });
            }
            return true;
        }
    }

    private Set<String> Dh() {
        if (aHx == null) {
            aHx = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(f.SR().getString("authWlist", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    aHx.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return aHx;
    }

    private boolean Di() {
        return (this.aHu.aHC == null || this.aHu.aHC.length() <= 0 || TextUtils.isEmpty(this.aHu.aHD)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aR(Context context) {
        return com.baidu.swan.apps.u.a.Jn().be(context) + this.aHu.appKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        int i = 0;
        final File Jc = e.C0192e.Jc();
        if (Jc.exists()) {
            Jc.delete();
        }
        this.aHv = Executors.newFixedThreadPool(4);
        this.aHw = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aHu.aHC.length()) {
                final String cO = this.aHu.cO(i2);
                if (TextUtils.isEmpty(cO)) {
                    int i3 = this.aHw + 1;
                    this.aHw = i3;
                    if (i3 >= this.aHu.aHC.length()) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                        P(context, "404");
                    }
                } else {
                    this.aHv.execute(new Runnable() { // from class: com.baidu.swan.apps.console.a.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(context, cO, Jc, unitedSchemeEntity, callbackHandler);
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
                cVar.mAppId = this.aHu.appId;
                cVar.aTf = false;
                cVar.aTj = "1";
                Intent c = com.baidu.swan.apps.v.b.c.c(context, cVar);
                c.putExtra("remoteDebugUrl", str);
                context.startActivity(c);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.aHv != null) {
                    this.aHv.shutdownNow();
                    this.aHv = null;
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
            int i = this.aHw + 1;
            this.aHw = i;
            if (i >= this.aHu.aHC.length()) {
                com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                P(context, "404");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Context context, String str) {
        String string = f.SR().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, ec(str)).QN();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + ed(string + "?" + str));
        }
    }

    private String ec(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 51509:
                if (str.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND)) {
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

    private String ed(String str) {
        try {
            return URLEncoder.encode(str, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
