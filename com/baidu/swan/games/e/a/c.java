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
/* loaded from: classes11.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a bls;
    private String cmU = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.bls = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.bls.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.bls.anB().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.cmU.equals(str)) {
                this.cmU = str;
                bF(str, str2);
                com.baidu.swan.games.u.c.pz(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                g.a(v8ExceptionInfo);
                DuMixGameSurfaceView aod = com.baidu.swan.games.i.a.aob().aod();
                if (aod != null) {
                    aod.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void bF(String str, String str2) {
        if (this.bls.anz() != null) {
            this.bls.anz().dispatchEvent(new a().oJ(str + "\n" + str2).oK("").anI());
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String cmU;
        private JSEvent cmV = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String cmW;

        public a oJ(String str) {
            this.cmU = str;
            return this;
        }

        public a oK(String str) {
            this.cmW = str;
            return this;
        }

        public JSEvent anI() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.cmU);
                jSONObject.put("stack", this.cmW);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.cmV.data = jSONObject;
            }
            return this.cmV;
        }
    }
}
