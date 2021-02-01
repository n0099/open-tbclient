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
/* loaded from: classes9.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cOo;
    private String efs = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cOo = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cOo.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cOo.aWb().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.efs.equals(str)) {
                this.efs = str;
                cU(str, str2);
                com.baidu.swan.games.v.c.xi(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aWC = com.baidu.swan.games.j.a.aWA().aWC();
                if (aWC != null) {
                    aWC.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cU(String str, String str2) {
        if (this.cOo.aVZ() != null) {
            this.cOo.aVZ().dispatchEvent(new a().ws(str + "\n" + str2).wt("").aWi());
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String efs;
        private JSEvent eft = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String efu;

        public a ws(String str) {
            this.efs = str;
            return this;
        }

        public a wt(String str) {
            this.efu = str;
            return this;
        }

        public JSEvent aWi() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.efs);
                jSONObject.put("stack", this.efu);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.eft.data = jSONObject;
            }
            return this.eft;
        }
    }
}
