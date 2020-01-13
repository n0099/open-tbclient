package com.baidu.swan.apps.console.debugger.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.apps.x.b.c;
import com.baidu.swan.d.f;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends ab {
    private ExecutorService bfD;
    private int bfE;
    private c bfU;

    public a(j jVar) {
        super(jVar, "/swanAPI/wirelessdebuglaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0) {
            com.baidu.swan.apps.console.c.e("WirelessDebugAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.bfU = c.af(optParamsAsJo);
        if (this.bfU == null || this.bfU.isInvalid()) {
            if (DEBUG) {
                Log.e("WirelessDebugAction", "Wireless Debug params is invalid");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        f(context, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void f(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        final File JF = b.JF();
        if (JF.exists()) {
            JF.delete();
        }
        this.bfD = Executors.newFixedThreadPool(4);
        this.bfE = 0;
        if (this.bfU.bgc == null || this.bfU.bgc.length() <= 0) {
            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(context, a.this.bfU.bfY, a.this.bfU.uM, JF, unitedSchemeEntity, callbackHandler);
                }
            }, "WirelessDebugAction");
            return;
        }
        int length = this.bfU.bgc.length();
        for (int i = 0; i < length; i++) {
            final String dV = this.bfU.dV(i);
            if (TextUtils.isEmpty(dV)) {
                int i2 = this.bfE + 1;
                this.bfE = i2;
                if (i2 >= length) {
                    com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Hosts are invalid");
                    ai(context, "404");
                }
            } else {
                final String dW = this.bfU.dW(i);
                this.bfD.execute(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(context, dV, dW, JF, unitedSchemeEntity, callbackHandler);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b9, code lost:
        if (r0 >= r7.bfU.bgc.length()) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = HttpManager.getDefault(context.getApplicationContext()).getRequest().url(str).connectionTimeout(1500).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                f.streamToFile(executeSync.body().byteStream(), file);
                Intent a = com.baidu.swan.apps.x.b.c.a(context, JD());
                a.putExtra("masterPreload", this.bfU.bga);
                a.putExtra("slavePreload", this.bfU.bgb);
                a.putExtra("extraWSUrl", str2);
                context.startActivity(a);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.bfD != null) {
                    this.bfD.shutdownNow();
                    this.bfD = null;
                }
                if (!ProcessUtils.isMainProcess()) {
                    if (DEBUG) {
                        Log.d("WirelessDebugAction", "Suicide for reload.");
                    }
                    d.JI();
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
            synchronized (this) {
                if (this.bfU.bgc != null) {
                    int i = this.bfE + 1;
                    this.bfE = i;
                }
                com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Host IPs are invalid");
                ai(context, "404");
                JE();
            }
        }
    }

    private c.a JD() {
        return (c.a) ((c.a) ((c.a) new c.a().ij(this.bfU.mAppKey)).cF(false)).iq(this.bfU.bfZ);
    }

    private void ai(Context context, String str) {
        String string = h.adb().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, "IPs are invalid ：" + str).showToast();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + ca(string + "?" + str));
        }
    }

    private String ca(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (DEBUG) {
                Log.e("WirelessDebugAction", "url encode fail", e);
                return str;
            }
            return str;
        }
    }

    private void JE() {
        b.a aas = com.baidu.swan.apps.runtime.d.aam().aaj().aas();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(aas);
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(aas.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "adb-debug";
        fVar.mValue = "download_fail";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }
}
