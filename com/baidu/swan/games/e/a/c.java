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
    private com.baidu.swan.games.e.a bJA;
    private String cLQ = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.bJA = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.bJA.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.bJA.avO().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.cLQ.equals(str)) {
                this.cLQ = str;
                bQ(str, str2);
                com.baidu.swan.games.u.c.qM(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                g.a(v8ExceptionInfo);
                DuMixGameSurfaceView awq = com.baidu.swan.games.i.a.awo().awq();
                if (awq != null) {
                    awq.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void bQ(String str, String str2) {
        if (this.bJA.avM() != null) {
            this.bJA.avM().dispatchEvent(new a().pW(str + "\n" + str2).pX("").avV());
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String cLQ;
        private JSEvent cLR = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String cLS;

        public a pW(String str) {
            this.cLQ = str;
            return this;
        }

        public a pX(String str) {
            this.cLS = str;
            return this;
        }

        public JSEvent avV() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.cLQ);
                jSONObject.put("stack", this.cLS);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.cLR.data = jSONObject;
            }
            return this.cLR;
        }
    }
}
