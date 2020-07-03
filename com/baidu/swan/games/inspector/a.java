package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String ddF;
    private String ddG;
    private boolean ddH;
    private boolean ddI;
    private boolean ddJ;
    private boolean ddK;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0433a {
        private String ddL;
        private boolean mEnabled;

        C0433a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.ddL = str;
        }

        public static C0433a aBO() {
            return new C0433a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aBP() {
            return this.ddL;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.ddF = null;
        this.ddG = null;
        this.ddH = false;
        this.ddI = false;
        this.ddJ = false;
        this.ddK = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.ddF = optJSONObject.optString("hostname", null);
            this.ddG = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.ddH = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.ddK = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.ddK) {
            this.ddF = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.ddF);
            this.ddG = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.ddG);
            this.ddH = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.ddH);
            this.ddI = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.ddI);
        }
        if (this.ddF != null && !this.ddF.trim().equals("")) {
            this.ddJ = true;
        }
    }

    public C0433a aBJ() {
        if (this.ddK || !aBK()) {
            return new C0433a(this.ddJ, !this.ddJ ? "未启用真机调试" : this.ddK ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0433a(false, "线上包禁用真机调试");
    }

    public static C0433a a(a aVar) {
        return aVar == null ? C0433a.aBO() : aVar.aBJ();
    }

    private boolean aBK() {
        return com.baidu.swan.apps.e.a.iB(e.apO());
    }

    public boolean aBL() {
        return this.ddH;
    }

    public String aBM() {
        return this.ddF + (this.ddG != null ? ":" + this.ddG : "");
    }

    public boolean aBN() {
        return this.ddI;
    }
}
