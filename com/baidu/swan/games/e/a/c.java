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
    private com.baidu.swan.games.e.a blf;
    private String cmJ = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.blf = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.blf.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.blf.any().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.cmJ.equals(str)) {
                this.cmJ = str;
                bG(str, str2);
                com.baidu.swan.games.u.c.pA(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                g.a(v8ExceptionInfo);
                DuMixGameSurfaceView aoa = com.baidu.swan.games.i.a.anY().aoa();
                if (aoa != null) {
                    aoa.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void bG(String str, String str2) {
        if (this.blf.anw() != null) {
            this.blf.anw().dispatchEvent(new a().oK(str + "\n" + str2).oL("").anF());
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String cmJ;
        private JSEvent cmK = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String cmL;

        public a oK(String str) {
            this.cmJ = str;
            return this;
        }

        public a oL(String str) {
            this.cmL = str;
            return this;
        }

        public JSEvent anF() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.cmJ);
                jSONObject.put("stack", this.cmL);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.cmK.data = jSONObject;
            }
            return this.cmK;
        }
    }
}
