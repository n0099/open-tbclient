package com.baidu.swan.games.e.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a aLY;
    private String byW = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.aLY = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    public void onV8ExceptionCallBack(String str, String str2) {
        Log.e("V8Exception", this.aLY.ME() + "msg: " + str + " ,stack: " + str2);
        this.aLY.WB().jI(str);
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.byW.equals(str)) {
            this.byW = str;
            bd(str, str2);
            com.baidu.swan.games.r.c.kx(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
        }
    }

    private void bd(String str, String str2) {
        if (this.aLY.Wz() != null) {
            this.aLY.Wz().dispatchEvent(new a().jJ(str + "\n" + str2).jK("").WJ());
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String byW;
        private JSEvent byX = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String byY;

        public a jJ(String str) {
            this.byW = str;
            return this;
        }

        public a jK(String str) {
            this.byY = str;
            return this;
        }

        public JSEvent WJ() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.byW);
                jSONObject.put("stack", this.byY);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.byX.data = jSONObject;
            }
            return this.byX;
        }
    }
}
