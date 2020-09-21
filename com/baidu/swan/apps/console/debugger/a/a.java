package com.baidu.swan.apps.console.debugger.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.adaptation.a.e;
import com.baidu.swan.apps.d.a.f;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.u.c.c;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends aa {
    private static Set<String> ceF;
    private static Set<String> ceG = new HashSet();
    private c ceC;
    private ExecutorService ceD;
    private int ceE;
    private c.a ceH;

    public a(j jVar) {
        super(jVar, "/swanAPI/debuggerlaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        boolean equals = TextUtils.equals(h.aDP().getString("enableSwitch", "1"), "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0 || !equals) {
            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.ceC = c.aQ(optParamsAsJo);
        if (this.ceC == null) {
            if (DEBUG) {
                Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!aeE()) {
            W(context, "404");
            return false;
        } else {
            if (f.bVX.acj() || aeD().contains(com.baidu.swan.apps.t.a.apz().bj(context)) || ceG.contains(bN(context))) {
                f(context, unitedSchemeEntity, callbackHandler);
            } else {
                com.baidu.swan.apps.a.b.a(this.ceC.appKey, new e.a() { // from class: com.baidu.swan.apps.console.debugger.a.a.1
                    @Override // com.baidu.swan.apps.adaptation.a.e.a
                    public void m(Exception exc) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.W(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
                    }

                    @Override // com.baidu.swan.apps.adaptation.a.e.a
                    public void du(boolean z) {
                        if (z) {
                            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Success");
                            a.ceG.add(a.this.bN(context));
                            a.this.f(context, unitedSchemeEntity, callbackHandler);
                            return;
                        }
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Fail : Not developer");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.W(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
                    }
                });
            }
            return true;
        }
    }

    private Set<String> aeD() {
        if (ceF == null) {
            ceF = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(h.aDP().getString("authWlist", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    ceF.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return ceF;
    }

    private boolean aeE() {
        return (this.ceC.ceL == null || this.ceC.ceL.length() <= 0 || TextUtils.isEmpty(this.ceC.ceM)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bN(Context context) {
        return com.baidu.swan.apps.t.a.apz().bj(context) + this.ceC.appKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        int i = 0;
        d.a(aeF());
        final File aeV = d.e.aeV();
        if (aeV.exists()) {
            aeV.delete();
        }
        this.ceD = Executors.newFixedThreadPool(4);
        this.ceE = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ceC.ceL.length()) {
                final String gU = this.ceC.gU(i2);
                if (TextUtils.isEmpty(gU)) {
                    int i3 = this.ceE + 1;
                    this.ceE = i3;
                    if (i3 >= this.ceC.ceL.length()) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                        W(context, "404");
                    }
                } else {
                    this.ceD.execute(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.a.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(context, gU, aeV, unitedSchemeEntity, callbackHandler);
                        }
                    });
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [296=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        c.a aeF = aeF();
        d.aeN();
        d.aeH().lc("downloadstart");
        try {
            Response executeSync = com.baidu.swan.a.c.a.aTI().getRequest().url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                com.baidu.swan.c.f.streamToFile(executeSync.body().byteStream(), file);
                Intent a = com.baidu.swan.apps.u.c.c.a(context, aeF);
                a.putExtra("remoteDebugUrl", str);
                context.startActivity(a);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.ceD != null) {
                    this.ceD.shutdownNow();
                    this.ceD = null;
                }
                d.b(aeF);
                d.aeH().lc("downloadsuccess");
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
            int i = this.ceE + 1;
            this.ceE = i;
            if (i >= this.ceC.ceL.length()) {
                com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                W(context, "404");
                d.aeH().lc("downloadfail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Context context, String str) {
        String string = h.aDP().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, lb(str)).showToast();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + dt(string + "?" + str));
        }
    }

    private c.a aeF() {
        if (this.ceH == null) {
            this.ceH = (c.a) ((c.a) ((c.a) ((c.a) new c.a().nV(this.ceC.appKey)).eD(false)).oa(this.ceC.page)).oc("1");
        }
        return this.ceH;
    }

    private String lb(String str) {
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

    private String dt(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
