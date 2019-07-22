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
    private com.baidu.swan.games.e.a asB;
    private String bgx = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.asB = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    public void onV8ExceptionCallBack(String str, String str2) {
        Log.e("V8Exception", this.asB.HF() + "msg: " + str + " ,stack: " + str2);
        this.asB.RI().jd(str);
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.bgx.equals(str)) {
            this.bgx = str;
            aW(str, str2);
            com.baidu.swan.games.r.c.jT(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
        }
    }

    private void aW(String str, String str2) {
        if (this.asB.RG() != null) {
            this.asB.RG().dispatchEvent(new a().je(str + "\n" + str2).jf("").RQ());
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String bgx;
        private JSEvent bgy = new JSEvent("error");
        private String bgz;

        public a je(String str) {
            this.bgx = str;
            return this;
        }

        public a jf(String str) {
            this.bgz = str;
            return this;
        }

        public JSEvent RQ() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.bgx);
                jSONObject.put("stack", this.bgz);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.bgy.data = jSONObject;
            }
            return this.bgy;
        }
    }
}
