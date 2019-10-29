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
    private com.baidu.swan.games.e.a aMq;
    private String bzN = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.aMq = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    public void onV8ExceptionCallBack(String str, String str2) {
        Log.e("V8Exception", this.aMq.MD() + "msg: " + str + " ,stack: " + str2);
        this.aMq.WD().jI(str);
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.bzN.equals(str)) {
            this.bzN = str;
            bd(str, str2);
            com.baidu.swan.games.r.c.kx(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
        }
    }

    private void bd(String str, String str2) {
        if (this.aMq.WB() != null) {
            this.aMq.WB().dispatchEvent(new a().jJ(str + "\n" + str2).jK("").WL());
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String bzN;
        private JSEvent bzO = new JSEvent(BdStatsConstant.StatsType.ERROR);
        private String bzP;

        public a jJ(String str) {
            this.bzN = str;
            return this;
        }

        public a jK(String str) {
            this.bzP = str;
            return this;
        }

        public JSEvent WL() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.bzN);
                jSONObject.put("stack", this.bzP);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.bzO.data = jSONObject;
            }
            return this.bzO;
        }
    }
}
