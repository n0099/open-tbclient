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
    private com.baidu.swan.games.f.a cso;
    private String dFw = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cso = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cso.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cso.aQx().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.dFw.equals(str)) {
                this.dFw = str;
                cP(str, str2);
                com.baidu.swan.games.v.c.wS(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aQY = com.baidu.swan.games.j.a.aQW().aQY();
                if (aQY != null) {
                    aQY.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cP(String str, String str2) {
        if (this.cso.aQv() != null) {
            this.cso.aQv().dispatchEvent(new a().wc(str + "\n" + str2).wd("").aQE());
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String dFw;
        private JSEvent dFx = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String dFy;

        public a wc(String str) {
            this.dFw = str;
            return this;
        }

        public a wd(String str) {
            this.dFy = str;
            return this;
        }

        public JSEvent aQE() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.dFw);
                jSONObject.put("stack", this.dFy);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.dFx.data = jSONObject;
            }
            return this.dFx;
        }
    }
}
