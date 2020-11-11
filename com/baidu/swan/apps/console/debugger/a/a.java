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
/* loaded from: classes10.dex */
public class a extends aa {
    private static Set<String> cFp;
    private static Set<String> cFq = new HashSet();
    private c cFm;
    private ExecutorService cFn;
    private int cFo;
    private c.a cFr;

    public a(j jVar) {
        super(jVar, "/swanAPI/debuggerlaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        boolean equals = TextUtils.equals(h.aKS().getString("enableSwitch", "1"), "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0 || !equals) {
            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.cFm = c.bg(optParamsAsJo);
        if (this.cFm == null) {
            if (DEBUG) {
                Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!alJ()) {
            aa(context, "404");
            return false;
        } else {
            if (f.cwK.ajp() || alI().contains(com.baidu.swan.apps.t.a.awF().bp(context)) || cFq.contains(bT(context))) {
                f(context, unitedSchemeEntity, callbackHandler);
            } else {
                com.baidu.swan.apps.a.b.a(this.cFm.appKey, new e.a() { // from class: com.baidu.swan.apps.console.debugger.a.a.1
                    @Override // com.baidu.swan.apps.adaptation.a.e.a
                    public void m(Exception exc) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.aa(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
                    }

                    @Override // com.baidu.swan.apps.adaptation.a.e.a
                    public void em(boolean z) {
                        if (z) {
                            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Success");
                            a.cFq.add(a.this.bT(context));
                            a.this.f(context, unitedSchemeEntity, callbackHandler);
                            return;
                        }
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Fail : Not developer");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.aa(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
                    }
                });
            }
            return true;
        }
    }

    private Set<String> alI() {
        if (cFp == null) {
            cFp = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(h.aKS().getString("authWlist", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    cFp.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return cFp;
    }

    private boolean alJ() {
        return (this.cFm.cFv == null || this.cFm.cFv.length() <= 0 || TextUtils.isEmpty(this.cFm.cFw)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bT(Context context) {
        return com.baidu.swan.apps.t.a.awF().bp(context) + this.cFm.appKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        int i = 0;
        d.a(alK());
        final File ama = d.e.ama();
        if (ama.exists()) {
            ama.delete();
        }
        this.cFn = Executors.newFixedThreadPool(4);
        this.cFo = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cFm.cFv.length()) {
                final String hM = this.cFm.hM(i2);
                if (TextUtils.isEmpty(hM)) {
                    int i3 = this.cFo + 1;
                    this.cFo = i3;
                    if (i3 >= this.cFm.cFv.length()) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                        aa(context, "404");
                    }
                } else {
                    this.cFn.execute(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.a.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(context, hM, ama, unitedSchemeEntity, callbackHandler);
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
        c.a alK = alK();
        d.alS();
        d.alM().mw("downloadstart");
        try {
            Response executeSync = com.baidu.swan.a.c.a.baK().getRequest().url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                com.baidu.swan.c.f.streamToFile(executeSync.body().byteStream(), file);
                Intent a2 = com.baidu.swan.apps.u.c.c.a(context, alK);
                a2.putExtra("remoteDebugUrl", str);
                context.startActivity(a2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.cFn != null) {
                    this.cFn.shutdownNow();
                    this.cFn = null;
                }
                d.b(alK);
                d.alM().mw("downloadsuccess");
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
            int i = this.cFo + 1;
            this.cFo = i;
            if (i >= this.cFm.cFv.length()) {
                com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                aa(context, "404");
                d.alM().mw("downloadfail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(Context context, String str) {
        String string = h.aKS().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, mv(str)).showToast();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + dy(string + "?" + str));
        }
    }

    private c.a alK() {
        if (this.cFr == null) {
            this.cFr = (c.a) ((c.a) ((c.a) ((c.a) new c.a().pq(this.cFm.appKey)).fv(false)).pv(this.cFm.page)).px("1");
        }
        return this.cFr;
    }

    private String mv(String str) {
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

    private String dy(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
