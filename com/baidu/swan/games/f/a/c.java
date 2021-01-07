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
/* loaded from: classes9.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cQM;
    private String ehY = "";

    public c(com.baidu.swan.games.f.a aVar) {
        this.cQM = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
            String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
            Log.e("V8Exception", this.cQM.getLogTag() + "msg: " + str + " ,stack: " + str2);
            this.cQM.aZJ().error(str);
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.ehY.equals(str)) {
                this.ehY = str;
                db(str, str2);
                com.baidu.swan.games.v.c.ya(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
                i.a(v8ExceptionInfo);
                DuMixGameSurfaceView bak = com.baidu.swan.games.j.a.bai().bak();
                if (bak != null) {
                    bak.d(v8ExceptionInfo);
                }
            }
        }
    }

    private void db(String str, String str2) {
        if (this.cQM.aZH() != null) {
            this.cQM.aZH().dispatchEvent(new a().xk(str + "\n" + str2).xl("").aZQ());
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String ehY;
        private JSEvent ehZ = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String eia;

        public a xk(String str) {
            this.ehY = str;
            return this;
        }

        public a xl(String str) {
            this.eia = str;
            return this;
        }

        public JSEvent aZQ() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.ehY);
                jSONObject.put("stack", this.eia);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.ehZ.data = jSONObject;
            }
            return this.ehZ;
        }
    }
}
