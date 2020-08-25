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
    private com.baidu.swan.games.f.a cdS;
    private String drn = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cdS = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cdS.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cdS.aNd().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.drn.equals(str)) {
                this.drn = str;
                cK(str, str2);
                com.baidu.swan.games.v.c.vM(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aNE = com.baidu.swan.games.j.a.aNC().aNE();
                if (aNE != null) {
                    aNE.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cK(String str, String str2) {
        if (this.cdS.aNb() != null) {
            this.cdS.aNb().dispatchEvent(new a().uW(str + "\n" + str2).uX("").aNk());
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String drn;
        private JSEvent dro = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String drp;

        public a uW(String str) {
            this.drn = str;
            return this;
        }

        public a uX(String str) {
            this.drp = str;
            return this;
        }

        public JSEvent aNk() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.drn);
                jSONObject.put("stack", this.drp);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.dro.data = jSONObject;
            }
            return this.dro;
        }
    }
}
