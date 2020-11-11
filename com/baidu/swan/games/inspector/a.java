package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private String dVS;
    private String dVT;
    private boolean dVU;
    private boolean dVV;
    private boolean dVW;
    private boolean dVX;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0532a {
        private String dVY;
        private boolean mEnabled;

        C0532a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.dVY = str;
        }

        public static C0532a aVY() {
            return new C0532a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aVZ() {
            return this.dVY;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.dVS = null;
        this.dVT = null;
        this.dVU = false;
        this.dVV = false;
        this.dVW = false;
        this.dVX = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.dVS = optJSONObject.optString("hostname", null);
            this.dVT = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.dVU = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.dVX = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.dVX) {
            this.dVS = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.dVS);
            this.dVT = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.dVT);
            this.dVU = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.dVU);
            this.dVV = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.dVV);
        }
        if (this.dVS != null && !this.dVS.trim().equals("")) {
            this.dVW = true;
        }
    }

    public C0532a aVT() {
        if (this.dVX || !aVU()) {
            return new C0532a(this.dVW, !this.dVW ? "未启用真机调试" : this.dVX ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0532a(false, "线上包禁用真机调试");
    }

    public static C0532a a(a aVar) {
        return aVar == null ? C0532a.aVY() : aVar.aVT();
    }

    private boolean aVU() {
        return com.baidu.swan.apps.f.a.lZ(e.aHw());
    }

    public boolean aVV() {
        return this.dVU;
    }

    public String aVW() {
        return this.dVS + (this.dVT != null ? ":" + this.dVT : "");
    }

    public boolean aVX() {
        return this.dVV;
    }
}
