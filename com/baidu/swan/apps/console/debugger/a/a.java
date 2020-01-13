package com.baidu.swan.apps.console.debugger.a;

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
import com.baidu.swan.apps.adaptation.a.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.x.b.c;
import com.baidu.swan.d.f;
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
public class a extends ab {
    private static Set<String> bfF;
    private static Set<String> bfG = new HashSet();
    private c bfC;
    private ExecutorService bfD;
    private int bfE;
    private c.a bfH;

    public a(j jVar) {
        super(jVar, "/swanAPI/debuggerlaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        boolean equals = TextUtils.equals(h.adb().getString("enableSwitch", "1"), "1");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0 || !equals) {
            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.bfC = c.ae(optParamsAsJo);
        if (this.bfC == null) {
            if (DEBUG) {
                Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!Jo()) {
            ai(context, "404");
            return false;
        } else {
            if (com.baidu.swan.apps.c.a.e.aYc.GY() || Jn().contains(com.baidu.swan.apps.w.a.RL().bm(context)) || bfG.contains(bO(context))) {
                f(context, unitedSchemeEntity, callbackHandler);
            } else {
                com.baidu.swan.apps.a.b.a(this.bfC.appKey, new e.a() { // from class: com.baidu.swan.apps.console.debugger.a.a.1
                    @Override // com.baidu.swan.apps.adaptation.a.e.a
                    public void j(Exception exc) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.ai(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
                    }

                    @Override // com.baidu.swan.apps.adaptation.a.e.a
                    public void bN(boolean z) {
                        if (z) {
                            com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Success");
                            a.bfG.add(a.this.bO(context));
                            a.this.f(context, unitedSchemeEntity, callbackHandler);
                            return;
                        }
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "Authentication Fail : Not developer");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401);
                        a.this.ai(context, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
                    }
                });
            }
            return true;
        }
    }

    private Set<String> Jn() {
        if (bfF == null) {
            bfF = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(h.adb().getString("authWlist", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    bfF.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                }
            }
        }
        return bfF;
    }

    private boolean Jo() {
        return (this.bfC.bfL == null || this.bfC.bfL.length() <= 0 || TextUtils.isEmpty(this.bfC.bfM)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bO(Context context) {
        return com.baidu.swan.apps.w.a.RL().bm(context) + this.bfC.appKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        int i = 0;
        d.a(Jp());
        final File JF = e.C0292e.JF();
        if (JF.exists()) {
            JF.delete();
        }
        this.bfD = Executors.newFixedThreadPool(4);
        this.bfE = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bfC.bfL.length()) {
                final String dU = this.bfC.dU(i2);
                if (TextUtils.isEmpty(dU)) {
                    int i3 = this.bfE + 1;
                    this.bfE = i3;
                    if (i3 >= this.bfC.bfL.length()) {
                        com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                        ai(context, "404");
                    }
                } else {
                    this.bfD.execute(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.a.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(context, dU, JF, unitedSchemeEntity, callbackHandler);
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
        c.a Jp = Jp();
        d.Jx();
        d.Jr().gn("downloadstart");
        try {
            Response executeSync = HttpManager.getDefault(context.getApplicationContext()).getRequest().url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                f.streamToFile(executeSync.body().byteStream(), file);
                Intent a = com.baidu.swan.apps.x.b.c.a(context, Jp);
                a.putExtra("remoteDebugUrl", str);
                context.startActivity(a);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.bfD != null) {
                    this.bfD.shutdownNow();
                    this.bfD = null;
                }
                d.b(Jp);
                d.Jr().gn("downloadsuccess");
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
            int i = this.bfE + 1;
            this.bfE = i;
            if (i >= this.bfC.bfL.length()) {
                com.baidu.swan.apps.console.c.e("DebuggerLaunchAction", "IPs are invalid");
                ai(context, "404");
                d.Jr().gn("downloadfail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(Context context, String str) {
        String string = h.adb().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, gm(str)).showToast();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + ca(string + "?" + str));
        }
    }

    private c.a Jp() {
        if (this.bfH == null) {
            this.bfH = (c.a) ((c.a) ((c.a) ((c.a) new c.a().ij(this.bfC.appKey)).cF(false)).io(this.bfC.page)).iq("1");
        }
        return this.bfH;
    }

    private String gm(String str) {
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

    private String ca(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
