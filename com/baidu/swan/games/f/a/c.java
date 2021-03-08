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
/* loaded from: classes8.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cPO;
    private String egU = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cPO = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cPO.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cPO.aWe().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.egU.equals(str)) {
                this.egU = str;
                cU(str, str2);
                com.baidu.swan.games.v.c.xp(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aWF = com.baidu.swan.games.j.a.aWD().aWF();
                if (aWF != null) {
                    aWF.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cU(String str, String str2) {
        if (this.cPO.aWc() != null) {
            this.cPO.aWc().dispatchEvent(new a().wz(str + "\n" + str2).wA("").aWl());
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String egU;
        private JSEvent egV = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String egW;

        public a wz(String str) {
            this.egU = str;
            return this;
        }

        public a wA(String str) {
            this.egW = str;
            return this;
        }

        public JSEvent aWl() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.egU);
                jSONObject.put("stack", this.egW);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.egV.data = jSONObject;
            }
            return this.egV;
        }
    }
}
