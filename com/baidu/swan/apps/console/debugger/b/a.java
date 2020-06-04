package com.baidu.swan.apps.console.debugger.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.v.b.c;
import com.baidu.swan.e.g;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends aa {
    private c bRA;
    private ExecutorService bRj;
    private int bRk;

    public a(j jVar) {
        super(jVar, "/swanAPI/wirelessdebuglaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null || optParamsAsJo.length() <= 0) {
            com.baidu.swan.apps.console.c.e("WirelessDebugAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.bRA = c.ay(optParamsAsJo);
        if (this.bRA == null || this.bRA.isInvalid()) {
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
        final File Wt = b.Wt();
        if (Wt.exists()) {
            Wt.delete();
        }
        this.bRj = Executors.newFixedThreadPool(4);
        this.bRk = 0;
        if (this.bRA.bRI == null || this.bRA.bRI.length() <= 0) {
            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(context, a.this.bRA.bRE, a.this.bRA.Oh, Wt, unitedSchemeEntity, callbackHandler);
                }
            }, "WirelessDebugAction");
            return;
        }
        int length = this.bRA.bRI.length();
        for (int i = 0; i < length; i++) {
            final String eB = this.bRA.eB(i);
            if (TextUtils.isEmpty(eB)) {
                int i2 = this.bRk + 1;
                this.bRk = i2;
                if (i2 >= length) {
                    com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Hosts are invalid");
                    Q(context, "404");
                }
            } else {
                final String eC = this.bRA.eC(i);
                this.bRj.execute(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(context, eB, eC, Wt, unitedSchemeEntity, callbackHandler);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b5, code lost:
        if (r0 >= r7.bRA.bRI.length()) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = com.baidu.swan.c.c.a.aFx().getRequest().url(str).connectionTimeout(1500).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                g.streamToFile(executeSync.body().byteStream(), file);
                Intent a = com.baidu.swan.apps.v.b.c.a(context, Wr());
                a.putExtra("masterPreload", this.bRA.bRG);
                a.putExtra("slavePreload", this.bRA.bRH);
                a.putExtra("extraWSUrl", str2);
                context.startActivity(a);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.bRj != null) {
                    this.bRj.shutdownNow();
                    this.bRj = null;
                }
                if (!ProcessUtils.isMainProcess()) {
                    if (DEBUG) {
                        Log.d("WirelessDebugAction", "Suicide for reload.");
                    }
                    d.Ww();
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
                if (this.bRA.bRI != null) {
                    int i = this.bRk + 1;
                    this.bRk = i;
                }
                com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Host IPs are invalid");
                Q(context, "404");
                Ws();
            }
        }
    }

    private c.a Wr() {
        return (c.a) ((c.a) ((c.a) new c.a().kW(this.bRA.mAppKey)).dZ(false)).ld(this.bRA.bRF);
    }

    private void Q(Context context, String str) {
        String string = h.arO().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, "IPs are invalid ：" + str).showToast();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + de(string + "?" + str));
        }
    }

    private String de(String str) {
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

    private void Ws() {
        b.a aoJ = com.baidu.swan.apps.runtime.d.aoB().aox().aoJ();
        f fVar = new f();
        fVar.b(aoJ);
        fVar.mFrom = com.baidu.swan.apps.statistic.h.gU(aoJ.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "adb-debug";
        fVar.mValue = "download_fail";
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }
}
