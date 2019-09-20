package com.baidu.swan.games.e.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a asZ;
    private String bgV = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.asZ = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    public void onV8ExceptionCallBack(String str, String str2) {
        Log.e("V8Exception", this.asZ.HJ() + "msg: " + str + " ,stack: " + str2);
        this.asZ.RM().jf(str);
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.bgV.equals(str)) {
            this.bgV = str;
            aW(str, str2);
            com.baidu.swan.games.r.c.jV(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
        }
    }

    private void aW(String str, String str2) {
        if (this.asZ.RK() != null) {
            this.asZ.RK().dispatchEvent(new a().jg(str + "\n" + str2).jh("").RU());
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String bgV;
        private JSEvent bgW = new JSEvent("error");
        private String bgX;

        public a jg(String str) {
            this.bgV = str;
            return this;
        }

        public a jh(String str) {
            this.bgX = str;
            return this;
        }

        public JSEvent RU() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.bgV);
                jSONObject.put("stack", this.bgX);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.bgW.data = jSONObject;
            }
            return this.bgW;
        }
    }
}
