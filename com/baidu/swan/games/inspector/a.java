package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String coM;
    private String coN;
    private boolean coO;
    private boolean coP;
    private boolean coQ;
    private boolean coR;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0337a {
        private String coS;
        private boolean mEnabled;

        C0337a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.coS = str;
        }

        public static C0337a aoD() {
            return new C0337a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aoE() {
            return this.coS;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.coM = null;
        this.coN = null;
        this.coO = false;
        this.coP = false;
        this.coQ = false;
        this.coR = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.coM = optJSONObject.optString("hostname", null);
            this.coN = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.coO = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.coR = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.coR) {
            this.coM = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.coM);
            this.coN = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.coN);
            this.coO = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.coO);
            this.coP = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.coP);
        }
        if (this.coM != null && !this.coM.trim().equals("")) {
            this.coQ = true;
        }
    }

    public C0337a aoy() {
        if (this.coR || !aoz()) {
            return new C0337a(this.coQ, !this.coQ ? "未启用真机调试" : this.coR ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0337a(false, "线上包禁用真机调试");
    }

    public static C0337a a(a aVar) {
        return aVar == null ? C0337a.aoD() : aVar.aoy();
    }

    private boolean aoz() {
        return com.baidu.swan.apps.e.a.gh(e.acH());
    }

    public boolean aoA() {
        return this.coO;
    }

    public String aoB() {
        return this.coM + (this.coN != null ? ":" + this.coN : "");
    }

    public boolean aoC() {
        return this.coP;
    }
}
