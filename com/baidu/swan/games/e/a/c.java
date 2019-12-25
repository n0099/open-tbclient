package com.baidu.swan.games.e.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.statistic.g;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a bgb;
    private String ciq = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.bgb = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.bgb.akR() + "msg: " + str + " ,stack: " + str2);
            this.bgb.akP().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.ciq.equals(str)) {
                this.ciq = str;
                bw(str, str2);
                com.baidu.swan.games.u.c.pi(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                g.a(v8ExceptionInfo);
                DuMixGameSurfaceView als = com.baidu.swan.games.i.a.alq().als();
                if (als != null) {
                    als.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void bw(String str, String str2) {
        if (this.bgb.akN() != null) {
            this.bgb.akN().dispatchEvent(new a().os(str + "\n" + str2).ot("").akX());
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String ciq;
        private JSEvent cir = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String cis;

        public a os(String str) {
            this.ciq = str;
            return this;
        }

        public a ot(String str) {
            this.cis = str;
            return this;
        }

        public JSEvent akX() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.ciq);
                jSONObject.put("stack", this.cis);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.cir.data = jSONObject;
            }
            return this.cir;
        }
    }
}
