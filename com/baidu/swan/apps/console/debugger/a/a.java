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
import com.baidu.swan.apps.c.a.f;
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
/* loaded from: classes7.dex */
public class a extends aa {
    private static Set<String> bWQ;
    private static Set<String> bWR = new HashSet();
    private c bWN;
    private ExecutorService bWO;
    private int bWP;
    private c.a bWS;

    public a(j jVar) {
        super(jVar, "/swanAPI/debuggerlaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        boolean equals = TextUtils.equals(h.auW().getString("enableSwitch", "1"), "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0 || !equals) {
            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.bWN = c.aH(optParamsAsJo);
        if (this.bWN == null) {
            if (DEBUG) {
                Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!XO()) {
            Q(context, "404");
            return false;
        } else {
            if (f.bOu.Vu() || XN().contains(com.baidu.swan.apps.t.a.aho().be(context)) || bWR.contains(bH(context))) {
                f(context, unitedSchemeEntity, callbackHandler);
            } else {
                com.baidu.swan.apps.a.b.a(this.bWN.appKey, new e.a() { // from class: com.baidu.swan.apps.console.debugger.a.a.1
                    @Override // com.baidu.swan.apps.adaptation.a.e.a
                    public void m(Exception exc) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.Q(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
                    }

                    @Override // com.baidu.swan.apps.adaptation.a.e.a
                    public void dn(boolean z) {
                        if (z) {
                            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Success");
                            a.bWR.add(a.this.bH(context));
                            a.this.f(context, unitedSchemeEntity, callbackHandler);
                            return;
                        }
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Fail : Not developer");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.Q(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
                    }
                });
            }
            return true;
        }
    }

    private Set<String> XN() {
        if (bWQ == null) {
            bWQ = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(h.auW().getString("authWlist", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    bWQ.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return bWQ;
    }

    private boolean XO() {
        return (this.bWN.bWW == null || this.bWN.bWW.length() <= 0 || TextUtils.isEmpty(this.bWN.bWX)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bH(Context context) {
        return com.baidu.swan.apps.t.a.aho().be(context) + this.bWN.appKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        int i = 0;
        d.a(XP());
        final File Yf = d.e.Yf();
        if (Yf.exists()) {
            Yf.delete();
        }
        this.bWO = Executors.newFixedThreadPool(4);
        this.bWP = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bWN.bWW.length()) {
                final String eN = this.bWN.eN(i2);
                if (TextUtils.isEmpty(eN)) {
                    int i3 = this.bWP + 1;
                    this.bWP = i3;
                    if (i3 >= this.bWN.bWW.length()) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                        Q(context, "404");
                    }
                } else {
                    this.bWO.execute(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.a.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(context, eN, Yf, unitedSchemeEntity, callbackHandler);
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
        c.a XP = XP();
        d.XX();
        d.XR().ji("downloadstart");
        try {
            Response executeSync = com.baidu.swan.b.c.a.aKu().getRequest().url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                com.baidu.swan.d.f.streamToFile(executeSync.body().byteStream(), file);
                Intent a = com.baidu.swan.apps.u.c.c.a(context, XP);
                a.putExtra("remoteDebugUrl", str);
                context.startActivity(a);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.bWO != null) {
                    this.bWO.shutdownNow();
                    this.bWO = null;
                }
                d.b(XP);
                d.XR().ji("downloadsuccess");
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
            int i = this.bWP + 1;
            this.bWP = i;
            if (i >= this.bWN.bWW.length()) {
                com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                Q(context, "404");
                d.XR().ji("downloadfail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Context context, String str) {
        String string = h.auW().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, jh(str)).showToast();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + df(string + "?" + str));
        }
    }

    private c.a XP() {
        if (this.bWS == null) {
            this.bWS = (c.a) ((c.a) ((c.a) ((c.a) new c.a().lE(this.bWN.appKey)).em(false)).lJ(this.bWN.page)).lL("1");
        }
        return this.bWS;
    }

    private String jh(String str) {
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

    private String df(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
