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
/* loaded from: classes9.dex */
public class a extends aa {
    private c cPJ;
    private ExecutorService cPt;
    private int cPu;

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
        this.cPJ = c.bl(optParamsAsJo);
        if (this.cPJ == null || this.cPJ.isInvalid()) {
            if (DEBUG) {
                Log.e("WirelessDebugAction", "Wireless Debug params is invalid");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        a(context, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        final File apN = b.apN();
        if (apN.exists()) {
            apN.delete();
        }
        this.cPt = Executors.newFixedThreadPool(4);
        this.cPu = 0;
        if (this.cPJ.cPR == null || this.cPJ.cPR.length() <= 0) {
            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(context, a.this.cPJ.cPN, a.this.cPJ.Rd, apN, unitedSchemeEntity, callbackHandler);
                }
            }, "WirelessDebugAction");
            return;
        }
        int length = this.cPJ.cPR.length();
        for (int i = 0; i < length; i++) {
            final String ib = this.cPJ.ib(i);
            if (TextUtils.isEmpty(ib)) {
                int i2 = this.cPu + 1;
                this.cPu = i2;
                if (i2 >= length) {
                    com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Hosts are invalid");
                    ag(context, "404");
                }
            } else {
                final String ic = this.cPJ.ic(i);
                this.cPt.execute(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(context, ib, ic, apN, unitedSchemeEntity, callbackHandler);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b5, code lost:
        if (r0 >= r6.cPJ.cPR.length()) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = com.baidu.swan.a.c.a.bfE().getRequest().url(str).connectionTimeout(1500).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                f.streamToFile(executeSync.body().byteStream(), file);
                Intent a2 = com.baidu.swan.apps.u.c.c.a(context, apL());
                a2.putExtra("masterPreload", this.cPJ.cPP);
                a2.putExtra("slavePreload", this.cPJ.cPQ);
                a2.putExtra("extraWSUrl", str2);
                context.startActivity(a2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.cPt != null) {
                    this.cPt.shutdownNow();
                    this.cPt = null;
                }
                if (!ProcessUtils.isMainProcess()) {
                    if (DEBUG) {
                        Log.d("WirelessDebugAction", "Suicide for reload.");
                    }
                    d.apQ();
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
                if (this.cPJ.cPR != null) {
                    int i = this.cPu + 1;
                    this.cPu = i;
                }
                com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Host IPs are invalid");
                ag(context, "404");
                apM();
            }
        }
    }

    private c.a apL() {
        return (c.a) ((c.a) ((c.a) new c.a().pK(this.cPJ.mAppKey)).fW(false)).pR(this.cPJ.cPO);
    }

    private void ag(Context context, String str) {
        String string = h.aPH().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, "IPs are invalid ：" + str).aLS();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + getEncodeValue(string + "?" + str));
        }
    }

    private String getEncodeValue(String str) {
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

    private void apM() {
        b.a aMo = com.baidu.swan.apps.runtime.d.aMg().aMc().aMo();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(aMo);
        fVar.mFrom = com.baidu.swan.apps.statistic.h.kX(aMo.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "adb-debug";
        fVar.mValue = "download_fail";
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }
}
