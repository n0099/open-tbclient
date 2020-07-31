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
    private com.baidu.swan.games.f.a bYi;
    private String dhe = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.bYi = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.bYi.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.bYi.aEo().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.dhe.equals(str)) {
                this.dhe = str;
                cq(str, str2);
                com.baidu.swan.games.v.c.tw(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aEQ = com.baidu.swan.games.j.a.aEO().aEQ();
                if (aEQ != null) {
                    aEQ.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cq(String str, String str2) {
        if (this.bYi.aEm() != null) {
            this.bYi.aEm().dispatchEvent(new a().sF(str + "\n" + str2).sG("").aEv());
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String dhe;
        private JSEvent dhf = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String dhg;

        public a sF(String str) {
            this.dhe = str;
            return this;
        }

        public a sG(String str) {
            this.dhg = str;
            return this;
        }

        public JSEvent aEv() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.dhe);
                jSONObject.put("stack", this.dhg);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.dhf.data = jSONObject;
            }
            return this.dhf;
        }
    }
}
