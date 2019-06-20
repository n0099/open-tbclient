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
    private com.baidu.swan.games.e.a arY;
    private String bfK = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.arY = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    public void onV8ExceptionCallBack(String str, String str2) {
        Log.e("V8Exception", this.arY.GU() + "msg: " + str + " ,stack: " + str2);
        this.arY.QP().iV(str);
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.bfK.equals(str)) {
            this.bfK = str;
            aW(str, str2);
            com.baidu.swan.games.r.c.jL(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2);
        }
    }

    private void aW(String str, String str2) {
        if (this.arY.QN() != null) {
            this.arY.QN().dispatchEvent(new a().iW(str + "\n" + str2).iX("").QX());
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String bfK;
        private JSEvent bfL = new JSEvent("error");
        private String bfM;

        public a iW(String str) {
            this.bfK = str;
            return this;
        }

        public a iX(String str) {
            this.bfM = str;
            return this;
        }

        public JSEvent QX() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.bfK);
                jSONObject.put("stack", this.bfM);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.bfL.data = jSONObject;
            }
            return this.bfL;
        }
    }
}
