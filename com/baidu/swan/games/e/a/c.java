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
/* loaded from: classes10.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a bgR;
    private String ciD = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.bgR = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.bgR.alk() + "msg: " + str + " ,stack: " + str2);
            this.bgR.ali().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.ciD.equals(str)) {
                this.ciD = str;
                bx(str, str2);
                com.baidu.swan.games.u.c.pl(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                g.a(v8ExceptionInfo);
                DuMixGameSurfaceView alL = com.baidu.swan.games.i.a.alJ().alL();
                if (alL != null) {
                    alL.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void bx(String str, String str2) {
        if (this.bgR.alg() != null) {
            this.bgR.alg().dispatchEvent(new a().ov(str + "\n" + str2).ow("").alq());
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String ciD;
        private JSEvent ciE = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String ciF;

        public a ov(String str) {
            this.ciD = str;
            return this;
        }

        public a ow(String str) {
            this.ciF = str;
            return this;
        }

        public JSEvent alq() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.ciD);
                jSONObject.put("stack", this.ciF);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.ciE.data = jSONObject;
            }
            return this.ciE;
        }
    }
}
