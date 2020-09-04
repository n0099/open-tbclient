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
    private com.baidu.swan.games.f.a cdW;
    private String drr = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cdW = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cdW.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cdW.aNd().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.drr.equals(str)) {
                this.drr = str;
                cK(str, str2);
                com.baidu.swan.games.v.c.vN(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aNE = com.baidu.swan.games.j.a.aNC().aNE();
                if (aNE != null) {
                    aNE.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cK(String str, String str2) {
        if (this.cdW.aNb() != null) {
            this.cdW.aNb().dispatchEvent(new a().uX(str + "\n" + str2).uY("").aNk());
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String drr;
        private JSEvent drt = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String dru;

        public a uX(String str) {
            this.drr = str;
            return this;
        }

        public a uY(String str) {
            this.dru = str;
            return this;
        }

        public JSEvent aNk() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.drr);
                jSONObject.put("stack", this.dru);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.drt.data = jSONObject;
            }
            return this.drt;
        }
    }
}
