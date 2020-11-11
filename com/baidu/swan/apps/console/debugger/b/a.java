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
/* loaded from: classes10.dex */
public class a extends aa {
    private c cFE;
    private ExecutorService cFn;
    private int cFo;

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
        this.cFE = c.bh(optParamsAsJo);
        if (this.cFE == null || this.cFE.isInvalid()) {
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
        final File ama = b.ama();
        if (ama.exists()) {
            ama.delete();
        }
        this.cFn = Executors.newFixedThreadPool(4);
        this.cFo = 0;
        if (this.cFE.cFM == null || this.cFE.cFM.length() <= 0) {
            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(context, a.this.cFE.cFI, a.this.cFE.Qf, ama, unitedSchemeEntity, callbackHandler);
                }
            }, "WirelessDebugAction");
            return;
        }
        int length = this.cFE.cFM.length();
        for (int i = 0; i < length; i++) {
            final String hN = this.cFE.hN(i);
            if (TextUtils.isEmpty(hN)) {
                int i2 = this.cFo + 1;
                this.cFo = i2;
                if (i2 >= length) {
                    com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Hosts are invalid");
                    aa(context, "404");
                }
            } else {
                final String hO = this.cFE.hO(i);
                this.cFn.execute(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(context, hN, hO, ama, unitedSchemeEntity, callbackHandler);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b5, code lost:
        if (r0 >= r7.cFE.cFM.length()) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = com.baidu.swan.a.c.a.baK().getRequest().url(str).connectionTimeout(1500).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                f.streamToFile(executeSync.body().byteStream(), file);
                Intent a2 = com.baidu.swan.apps.u.c.c.a(context, alY());
                a2.putExtra("masterPreload", this.cFE.cFK);
                a2.putExtra("slavePreload", this.cFE.cFL);
                a2.putExtra("extraWSUrl", str2);
                context.startActivity(a2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.cFn != null) {
                    this.cFn.shutdownNow();
                    this.cFn = null;
                }
                if (!ProcessUtils.isMainProcess()) {
                    if (DEBUG) {
                        Log.d("WirelessDebugAction", "Suicide for reload.");
                    }
                    d.amd();
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
                if (this.cFE.cFM != null) {
                    int i = this.cFo + 1;
                    this.cFo = i;
                }
                com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Host IPs are invalid");
                aa(context, "404");
                alZ();
            }
        }
    }

    private c.a alY() {
        return (c.a) ((c.a) ((c.a) new c.a().pq(this.cFE.mAppKey)).fv(false)).px(this.cFE.cFJ);
    }

    private void aa(Context context, String str) {
        String string = h.aKS().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, "IPs are invalid ：" + str).showToast();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + dy(string + "?" + str));
        }
    }

    private String dy(String str) {
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

    private void alZ() {
        b.a aHy = com.baidu.swan.apps.runtime.d.aHq().aHm().aHy();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(aHy);
        fVar.mFrom = com.baidu.swan.apps.statistic.h.ky(aHy.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "adb-debug";
        fVar.mValue = "download_fail";
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }
}
