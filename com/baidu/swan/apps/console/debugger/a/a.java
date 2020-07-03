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
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.v.b.c;
import com.baidu.swan.e.g;
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
/* loaded from: classes11.dex */
public class a extends aa {
    private static Set<String> bVZ;
    private static Set<String> bWa = new HashSet();
    private c bVW;
    private ExecutorService bVX;
    private int bVY;
    private c.a bWb;

    public a(j jVar) {
        super(jVar, "/swanAPI/debuggerlaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        boolean equals = TextUtils.equals(h.asV().getString("enableSwitch", "1"), "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0 || !equals) {
            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.bVW = c.aE(optParamsAsJo);
        if (this.bVW == null) {
            if (DEBUG) {
                Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!Xi()) {
            Q(context, "404");
            return false;
        } else {
            if (f.bNE.UP() || Xh().contains(com.baidu.swan.apps.u.a.agc().bc(context)) || bWa.contains(bE(context))) {
                f(context, unitedSchemeEntity, callbackHandler);
            } else {
                com.baidu.swan.apps.a.b.a(this.bVW.appKey, new e.a() { // from class: com.baidu.swan.apps.console.debugger.a.a.1
                    @Override // com.baidu.swan.apps.adaptation.a.e.a
                    public void m(Exception exc) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.Q(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
                    }

                    @Override // com.baidu.swan.apps.adaptation.a.e.a
                    public void dk(boolean z) {
                        if (z) {
                            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Success");
                            a.bWa.add(a.this.bE(context));
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

    private Set<String> Xh() {
        if (bVZ == null) {
            bVZ = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(h.asV().getString("authWlist", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    bVZ.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return bVZ;
    }

    private boolean Xi() {
        return (this.bVW.bWf == null || this.bVW.bWf.length() <= 0 || TextUtils.isEmpty(this.bVW.bWg)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bE(Context context) {
        return com.baidu.swan.apps.u.a.agc().bc(context) + this.bVW.appKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        int i = 0;
        d.a(Xj());
        final File Xz = e.C0377e.Xz();
        if (Xz.exists()) {
            Xz.delete();
        }
        this.bVX = Executors.newFixedThreadPool(4);
        this.bVY = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bVW.bWf.length()) {
                final String eL = this.bVW.eL(i2);
                if (TextUtils.isEmpty(eL)) {
                    int i3 = this.bVY + 1;
                    this.bVY = i3;
                    if (i3 >= this.bVW.bWf.length()) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                        Q(context, "404");
                    }
                } else {
                    this.bVX.execute(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.a.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(context, eL, Xz, unitedSchemeEntity, callbackHandler);
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
        c.a Xj = Xj();
        d.Xr();
        d.Xl().iY("downloadstart");
        try {
            Response executeSync = com.baidu.swan.c.c.a.aGD().getRequest().url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                g.streamToFile(executeSync.body().byteStream(), file);
                Intent a = com.baidu.swan.apps.v.b.c.a(context, Xj);
                a.putExtra("remoteDebugUrl", str);
                context.startActivity(a);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.bVX != null) {
                    this.bVX.shutdownNow();
                    this.bVX = null;
                }
                d.b(Xj);
                d.Xl().iY("downloadsuccess");
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
            int i = this.bVY + 1;
            this.bVY = i;
            if (i >= this.bVW.bWf.length()) {
                com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                Q(context, "404");
                d.Xl().iY("downloadfail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Context context, String str) {
        String string = h.asV().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, iX(str)).showToast();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + dg(string + "?" + str));
        }
    }

    private c.a Xj() {
        if (this.bWb == null) {
            this.bWb = (c.a) ((c.a) ((c.a) ((c.a) new c.a().le(this.bVW.appKey)).ee(false)).lj(this.bVW.page)).ll("1");
        }
        return this.bWb;
    }

    private String iX(String str) {
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

    private String dg(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
