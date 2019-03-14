package com.baidu.swan.games.e.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a arN;
    private String bbF = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.arN = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    public void onV8ExceptionCallBack(String str, String str2) {
        Log.e("V8Exception", this.arN.EV() + "msg: " + str + " ,stack: " + str2);
        this.arN.NX().im(str);
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.bbF.equals(str)) {
            this.bbF = str;
            aT(str, str2);
        }
    }

    private void aT(String str, String str2) {
        if (this.arN.NV() != null) {
            this.arN.NV().dispatchEvent(new a().in(str + "\n" + str2).io("").Oe());
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String bbF;
        private JSEvent bbG = new JSEvent("error");
        private String bbH;

        public a in(String str) {
            this.bbF = str;
            return this;
        }

        public a io(String str) {
            this.bbH = str;
            return this;
        }

        public JSEvent Oe() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.bbF);
                jSONObject.put("stack", this.bbH);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.bbG.data = jSONObject;
            }
            return this.bbG;
        }
    }
}
