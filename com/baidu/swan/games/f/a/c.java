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
    private com.baidu.swan.games.f.a bSB;
    private String cWJ = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.bSB = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.bSB.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.bSB.azD().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.cWJ.equals(str)) {
                this.cWJ = str;
                cl(str, str2);
                com.baidu.swan.games.v.c.sp(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aAf = com.baidu.swan.games.j.a.aAd().aAf();
                if (aAf != null) {
                    aAf.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cl(String str, String str2) {
        if (this.bSB.azB() != null) {
            this.bSB.azB().dispatchEvent(new a().ry(str + "\n" + str2).rz("").azK());
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String cWJ;
        private JSEvent cWK = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String cWL;

        public a ry(String str) {
            this.cWJ = str;
            return this;
        }

        public a rz(String str) {
            this.cWL = str;
            return this;
        }

        public JSEvent azK() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.cWJ);
                jSONObject.put("stack", this.cWL);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.cWK.data = jSONObject;
            }
            return this.cWK;
        }
    }
}
