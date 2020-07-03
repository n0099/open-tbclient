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
/* loaded from: classes11.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a bXp;
    private String dbv = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.bXp = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.bXp.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.bXp.aAJ().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.dbv.equals(str)) {
                this.dbv = str;
                cn(str, str2);
                com.baidu.swan.games.v.c.sy(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aBl = com.baidu.swan.games.j.a.aBj().aBl();
                if (aBl != null) {
                    aBl.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cn(String str, String str2) {
        if (this.bXp.aAH() != null) {
            this.bXp.aAH().dispatchEvent(new a().rG(str + "\n" + str2).rH("").aAQ());
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String dbv;
        private JSEvent dbw = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String dbx;

        public a rG(String str) {
            this.dbv = str;
            return this;
        }

        public a rH(String str) {
            this.dbx = str;
            return this;
        }

        public JSEvent aAQ() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.dbv);
                jSONObject.put("stack", this.dbx);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.dbw.data = jSONObject;
            }
            return this.dbw;
        }
    }
}
