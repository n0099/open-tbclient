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
    private com.baidu.swan.games.f.a cAO;
    private String dNT = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cAO = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cAO.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cAO.aSr().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.dNT.equals(str)) {
                this.dNT = str;
                cW(str, str2);
                com.baidu.swan.games.v.c.xl(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aSS = com.baidu.swan.games.j.a.aSQ().aSS();
                if (aSS != null) {
                    aSS.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cW(String str, String str2) {
        if (this.cAO.aSp() != null) {
            this.cAO.aSp().dispatchEvent(new a().wv(str + "\n" + str2).ww("").aSy());
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String dNT;
        private JSEvent dNU = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String dNV;

        public a wv(String str) {
            this.dNT = str;
            return this;
        }

        public a ww(String str) {
            this.dNV = str;
            return this;
        }

        public JSEvent aSy() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.dNT);
                jSONObject.put("stack", this.dNV);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.dNU.data = jSONObject;
            }
            return this.dNU;
        }
    }
}
