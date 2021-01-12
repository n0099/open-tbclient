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
    private com.baidu.swan.games.f.a cMa;
    private String edl = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cMa = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cMa.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cMa.aVP().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.edl.equals(str)) {
                this.edl = str;
                da(str, str2);
                com.baidu.swan.games.v.c.wP(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aWq = com.baidu.swan.games.j.a.aWo().aWq();
                if (aWq != null) {
                    aWq.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void da(String str, String str2) {
        if (this.cMa.aVN() != null) {
            this.cMa.aVN().dispatchEvent(new a().vZ(str + "\n" + str2).wa("").aVW());
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String edl;
        private JSEvent edm = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String edn;

        public a vZ(String str) {
            this.edl = str;
            return this;
        }

        public a wa(String str) {
            this.edn = str;
            return this;
        }

        public JSEvent aVW() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.edl);
                jSONObject.put("stack", this.edn);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.edm.data = jSONObject;
            }
            return this.edm;
        }
    }
}
