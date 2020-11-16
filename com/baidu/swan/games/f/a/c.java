package com.baidu.swan.games.f.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.statistic.i;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cEX;
    private String dSd = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cEX = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cEX.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cEX.aUj().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.dSd.equals(str)) {
                this.dSd = str;
                cV(str, str2);
                com.baidu.swan.games.v.c.xu(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aUK = com.baidu.swan.games.j.a.aUI().aUK();
                if (aUK != null) {
                    aUK.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cV(String str, String str2) {
        if (this.cEX.aUh() != null) {
            this.cEX.aUh().dispatchEvent(new a().wE(str + "\n" + str2).wF("").aUq());
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String dSd;
        private JSEvent dSe = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String dSf;

        public a wE(String str) {
            this.dSd = str;
            return this;
        }

        public a wF(String str) {
            this.dSf = str;
            return this;
        }

        public JSEvent aUq() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.dSd);
                jSONObject.put("stack", this.dSf);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.dSe.data = jSONObject;
            }
            return this.dSe;
        }
    }
}
