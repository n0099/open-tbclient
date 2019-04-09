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
    private com.baidu.swan.games.e.a arS;
    private String bbJ = "";

    public c(com.baidu.swan.games.e.a aVar) {
        this.arS = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    public void onV8ExceptionCallBack(String str, String str2) {
        Log.e("V8Exception", this.arS.ET() + "msg: " + str + " ,stack: " + str2);
        this.arS.NV().in(str);
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !this.bbJ.equals(str)) {
            this.bbJ = str;
            aT(str, str2);
        }
    }

    private void aT(String str, String str2) {
        if (this.arS.NT() != null) {
            this.arS.NT().dispatchEvent(new a().io(str + "\n" + str2).ip("").Oc());
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private String bbJ;
        private JSEvent bbK = new JSEvent("error");
        private String bbL;

        public a io(String str) {
            this.bbJ = str;
            return this;
        }

        public a ip(String str) {
            this.bbL = str;
            return this;
        }

        public JSEvent Oc() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.bbJ);
                jSONObject.put("stack", this.bbL);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("V8Exception", Log.getStackTraceString(e));
                }
            }
            if (jSONObject.length() > 0) {
                this.bbK.data = jSONObject;
            }
            return this.bbK;
        }
    }
}
