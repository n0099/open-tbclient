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
    private com.baidu.swan.games.e.a arR;
    private String bbI = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.arR = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    public void onV8ExceptionCallBack(String str, String str2) {
        Log.e("V8Exception", this.arR.ET() + "msg: " + str + " ,stack: " + str2);
        this.arR.NV().in(str);
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.bbI.equals(str)) {
            this.bbI = str;
            aT(str, str2);
        }
    }

    private void aT(String str, String str2) {
        if (this.arR.NT() != null) {
            this.arR.NT().dispatchEvent(new a().io(str + "\n" + str2).ip("").Oc());
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String bbI;
        private JSEvent bbJ = new JSEvent("error");
        private String bbK;

        public a io(String str) {
            this.bbI = str;
            return this;
        }

        public a ip(String str) {
            this.bbK = str;
            return this;
        }

        public JSEvent Oc() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.bbI);
                jSONObject.put("stack", this.bbK);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.bbJ.data = jSONObject;
            }
            return this.bbJ;
        }
    }
}
