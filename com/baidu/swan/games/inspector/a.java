package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private String dvC;
    private String dvD;
    private boolean dvE;
    private boolean dvF;
    private boolean dvG;
    private boolean dvH;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0489a {
        private String dvI;
        private boolean mEnabled;

        C0489a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.dvI = str;
        }

        public static C0489a aOV() {
            return new C0489a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aOW() {
            return this.dvI;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.dvC = null;
        this.dvD = null;
        this.dvE = false;
        this.dvF = false;
        this.dvG = false;
        this.dvH = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.dvC = optJSONObject.optString("hostname", null);
            this.dvD = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.dvE = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.dvH = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.dvH) {
            this.dvC = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.dvC);
            this.dvD = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.dvD);
            this.dvE = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.dvE);
            this.dvF = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.dvF);
        }
        if (this.dvC != null && !this.dvC.trim().equals("")) {
            this.dvG = true;
        }
    }

    public C0489a aOQ() {
        if (this.dvH || !aOR()) {
            return new C0489a(this.dvG, !this.dvG ? "未启用真机调试" : this.dvH ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0489a(false, "线上包禁用真机调试");
    }

    public static C0489a a(a aVar) {
        return aVar == null ? C0489a.aOV() : aVar.aOQ();
    }

    private boolean aOR() {
        return com.baidu.swan.apps.f.a.kF(e.aAt());
    }

    public boolean aOS() {
        return this.dvE;
    }

    public String aOT() {
        return this.dvC + (this.dvD != null ? ":" + this.dvD : "");
    }

    public boolean aOU() {
        return this.dvF;
    }
}
