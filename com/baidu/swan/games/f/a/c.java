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
/* loaded from: classes3.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cfX;
    private String dtv = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cfX = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cfX.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cfX.aNO().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.dtv.equals(str)) {
                this.dtv = str;
                cK(str, str2);
                com.baidu.swan.games.v.c.wg(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView aOp = com.baidu.swan.games.j.a.aOn().aOp();
                if (aOp != null) {
                    aOp.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void cK(String str, String str2) {
        if (this.cfX.aNM() != null) {
            this.cfX.aNM().dispatchEvent(new a().vq(str + "\n" + str2).vr("").aNV());
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String dtv;
        private JSEvent dtw = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String dtx;

        public a vq(String str) {
            this.dtv = str;
            return this;
        }

        public a vr(String str) {
            this.dtx = str;
            return this;
        }

        public JSEvent aNV() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.dtv);
                jSONObject.put("stack", this.dtx);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.dtw.data = jSONObject;
            }
            return this.dtw;
        }
    }
}
