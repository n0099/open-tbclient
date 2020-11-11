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
/* loaded from: classes10.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cGH;
    private String dTL = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cGH = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cGH.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cGH.aUR().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.dTL.equals(str)) {
                this.dTL = str;
                cW(str, str2);
                com.baidu.swan.games.v.c.xz(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aVs = com.baidu.swan.games.j.a.aVq().aVs();
                if (aVs != null) {
                    aVs.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cW(String str, String str2) {
        if (this.cGH.aUP() != null) {
            this.cGH.aUP().dispatchEvent(new a().wJ(str + "\n" + str2).wK("").aUY());
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String dTL;
        private JSEvent dTM = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String dTN;

        public a wJ(String str) {
            this.dTL = str;
            return this;
        }

        public a wK(String str) {
            this.dTN = str;
            return this;
        }

        public JSEvent aUY() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.dTL);
                jSONObject.put("stack", this.dTN);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.dTM.data = jSONObject;
            }
            return this.dTM;
        }
    }
}
