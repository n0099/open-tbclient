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
    private com.baidu.swan.games.e.a bld;
    private String cmH = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.bld = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.bld.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.bld.anw().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.cmH.equals(str)) {
                this.cmH = str;
                bG(str, str2);
                com.baidu.swan.games.u.c.pA(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                g.a(v8ExceptionInfo);
                DuMixGameSurfaceView anY = com.baidu.swan.games.i.a.anW().anY();
                if (anY != null) {
                    anY.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void bG(String str, String str2) {
        if (this.bld.anu() != null) {
            this.bld.anu().dispatchEvent(new a().oK(str + "\n" + str2).oL("").anD());
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String cmH;
        private JSEvent cmI = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String cmJ;

        public a oK(String str) {
            this.cmH = str;
            return this;
        }

        public a oL(String str) {
            this.cmJ = str;
            return this;
        }

        public JSEvent anD() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.cmH);
                jSONObject.put("stack", this.cmJ);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.cmI.data = jSONObject;
            }
            return this.cmI;
        }
    }
}
