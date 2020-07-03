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
    private ExecutorService bVX;
    private int bVY;
    private c bWo;

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
        this.bWo = c.aF(optParamsAsJo);
        if (this.bWo == null || this.bWo.isInvalid()) {
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
        final File Xz = b.Xz();
        if (Xz.exists()) {
            Xz.delete();
        }
        this.bVX = Executors.newFixedThreadPool(4);
        this.bVY = 0;
        if (this.bWo.bWw == null || this.bWo.bWw.length() <= 0) {
            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(context, a.this.bWo.bWs, a.this.bWo.OJ, Xz, unitedSchemeEntity, callbackHandler);
                }
            }, "WirelessDebugAction");
            return;
        }
        int length = this.bWo.bWw.length();
        for (int i = 0; i < length; i++) {
            final String eM = this.bWo.eM(i);
            if (TextUtils.isEmpty(eM)) {
                int i2 = this.bVY + 1;
                this.bVY = i2;
                if (i2 >= length) {
                    com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Hosts are invalid");
                    Q(context, "404");
                }
            } else {
                final String eN = this.bWo.eN(i);
                this.bVX.execute(new Runnable() { // from class: com.baidu.swan.apps.console.debugger.b.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(context, eM, eN, Xz, unitedSchemeEntity, callbackHandler);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b5, code lost:
        if (r0 >= r7.bWo.bWw.length()) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        try {
            Response executeSync = com.baidu.swan.c.c.a.aGD().getRequest().url(str).connectionTimeout(1500).build().executeSync();
            if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                g.streamToFile(executeSync.body().byteStream(), file);
                Intent a = com.baidu.swan.apps.v.b.c.a(context, Xx());
                a.putExtra("masterPreload", this.bWo.bWu);
                a.putExtra("slavePreload", this.bWo.bWv);
                a.putExtra("extraWSUrl", str2);
                context.startActivity(a);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                if (this.bVX != null) {
                    this.bVX.shutdownNow();
                    this.bVX = null;
                }
                if (!ProcessUtils.isMainProcess()) {
                    if (DEBUG) {
                        Log.d("WirelessDebugAction", "Suicide for reload.");
                    }
                    d.XC();
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
                if (this.bWo.bWw != null) {
                    int i = this.bVY + 1;
                    this.bVY = i;
                }
                com.baidu.swan.apps.console.c.e("WirelessDebugAction", "Host IPs are invalid");
                Q(context, "404");
                Xy();
            }
        }
    }

    private c.a Xx() {
        return (c.a) ((c.a) ((c.a) new c.a().le(this.bWo.mAppKey)).ee(false)).ll(this.bWo.bWt);
    }

    private void Q(Context context, String str) {
        String string = h.asV().getString("errorURL", "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.swan.apps.res.widget.b.d.a(context, "IPs are invalid ：" + str).showToast();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + dg(string + "?" + str));
        }
    }

    private String dg(String str) {
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

    private void Xy() {
        b.a apQ = com.baidu.swan.apps.runtime.d.apI().apE().apQ();
        f fVar = new f();
        fVar.b(apQ);
        fVar.mFrom = com.baidu.swan.apps.statistic.h.hf(apQ.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "adb-debug";
        fVar.mValue = "download_fail";
        com.baidu.swan.apps.statistic.h.onEvent(fVar);
    }
}
