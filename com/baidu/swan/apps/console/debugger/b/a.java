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
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.u.c.c;
import com.baidu.swan.c.f;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends aa {
    private ExecutorService ceD;
    private int ceE;
    private c ceU;

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
        this.ceU = c.aR(optParamsAsJo);
        if (this.ceU == null || this.ceU.isInvalid()) {
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
        final File aeV = b.aeV();
        if (aeV.exists()) {
            aeV.delete();
        }
        this.ceD = Executors.newFixedThreadPool(4);
        this.ceE = 0;
        if (this.ceU.cfc == null || this.ceU.cfc.length() <= 0) {
            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(context, a.this.ceU.ceY, a.this.ceU.PM, aeV, unitedSchemeEntity, callbackHandler);
                }
            }, "WirelessDebugAction");
            return;
        }
        int length = this.ceU.cfc.length();
        for (int i = 0; i < length; i++) {
            final String gV = this.ceU.gV(i);
            if (TextUtils.isEmpty(gV)) {
                int i2 = this.ceE + 1;
                this.ceE = i2;
                if (i2 >= length) {
                    com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Hosts are invalid");
                    W(context, "404");
                }
            } else {
                final String gW = this.ceU.gW(i);
                this.ceD.execute(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(context, gV, gW, aeV, unitedSchemeEntity, callbackHandler);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b5, code lost:
        if (r0 >= r7.ceU.cfc.length()) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = com.baidu.swan.a.c.a.aTI().getRequest().url(str).connectionTimeout(1500).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                f.streamToFile(executeSync.body().byteStream(), file);
                Intent a = com.baidu.swan.apps.u.c.c.a(context, aeT());
                a.putExtra("masterPreload", this.ceU.cfa);
                a.putExtra("slavePreload", this.ceU.cfb);
                a.putExtra("extraWSUrl", str2);
                context.startActivity(a);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.ceD != null) {
                    this.ceD.shutdownNow();
                    this.ceD = null;
                }
                if (!ProcessUtils.isMainProcess()) {
                    if (DEBUG) {
                        Log.d("WirelessDebugAction", "Suicide for reload.");
                    }
                    d.aeY();
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
                if (this.ceU.cfc != null) {
                    int i = this.ceE + 1;
                    this.ceE = i;
                }
                com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Host IPs are invalid");
                W(context, "404");
                aeU();
            }
        }
    }

    private c.a aeT() {
        return (c.a) ((c.a) ((c.a) new c.a().nV(this.ceU.mAppKey)).eD(false)).oc(this.ceU.ceZ);
    }

    private void W(Context context, String str) {
        String string = h.aDP().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, "IPs are invalid ：" + str).showToast();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + dt(string + "?" + str));
        }
    }

    private String dt(String str) {
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

    private void aeU() {
        b.a aAv = com.baidu.swan.apps.runtime.d.aAn().aAj().aAv();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(aAv);
        fVar.mFrom = com.baidu.swan.apps.statistic.h.jG(aAv.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "adb-debug";
        fVar.mValue = "download_fail";
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }
}
