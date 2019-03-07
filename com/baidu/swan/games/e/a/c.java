package com.baidu.swan.games.e.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private com.baidu.swan.games.e.a arM;
    private String bbE = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.arM = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    public void onV8ExceptionCallBack(String str, String str2) {
        Log.e("V8Exception", this.arM.EV() + "msg: " + str + " ,stack: " + str2);
        this.arM.NX().im(str);
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.bbE.equals(str)) {
            this.bbE = str;
            aT(str, str2);
        }
    }

    private void aT(String str, String str2) {
        if (this.arM.NV() != null) {
            this.arM.NV().dispatchEvent(new a().in(str + "\n" + str2).io("").Oe());
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
        private String bbE;
        private JSEvent bbF = new JSEvent("error");
        private String bbG;

        public a in(String str) {
            this.bbE = str;
            return this;
        }

        public a io(String str) {
            this.bbG = str;
            return this;
        }

        public JSEvent Oe() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.bbE);
                jSONObject.put("stack", this.bbG);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.bbF.data = jSONObject;
            }
            return this.bbF;
        }
    }
}
