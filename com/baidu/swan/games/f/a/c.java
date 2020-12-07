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
/* loaded from: classes25.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cLR;
    private String dZb = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cLR = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cLR.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cLR.aXo().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.dZb.equals(str)) {
                this.dZb = str;
                dc(str, str2);
                com.baidu.swan.games.v.c.yb(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aXP = com.baidu.swan.games.j.a.aXN().aXP();
                if (aXP != null) {
                    aXP.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void dc(String str, String str2) {
        if (this.cLR.aXm() != null) {
            this.cLR.aXm().dispatchEvent(new a().xl(str + "\n" + str2).xm("").aXv());
        }
    }

    /* loaded from: classes25.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String dZb;
        private JSEvent dZc = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String dZd;

        public a xl(String str) {
            this.dZb = str;
            return this;
        }

        public a xm(String str) {
            this.dZd = str;
            return this;
        }

        public JSEvent aXv() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.dZb);
                jSONObject.put("stack", this.dZd);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.dZc.data = jSONObject;
            }
            return this.dZc;
        }
    }
}
