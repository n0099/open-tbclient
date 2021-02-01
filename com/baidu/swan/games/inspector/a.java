package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private String ehA;
    private String ehB;
    private boolean ehC;
    private boolean ehD;
    private boolean ehE;
    private boolean ehF;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0515a {
        private String ehG;
        private boolean mEnabled;

        C0515a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.ehG = str;
        }

        public static C0515a aXi() {
            return new C0515a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aXj() {
            return this.ehG;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.ehA = null;
        this.ehB = null;
        this.ehC = false;
        this.ehD = false;
        this.ehE = false;
        this.ehF = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.ehA = optJSONObject.optString("hostname", null);
            this.ehB = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.ehC = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.ehF = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.ehF) {
            this.ehA = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.ehA);
            this.ehB = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.ehB);
            this.ehC = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.ehC);
            this.ehD = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.ehD);
        }
        if (this.ehA != null && !this.ehA.trim().equals("")) {
            this.ehE = true;
        }
    }

    public C0515a aXd() {
        if (this.ehF || !aXe()) {
            return new C0515a(this.ehE, !this.ehE ? "未启用真机调试" : this.ehF ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0515a(false, "线上包禁用真机调试");
    }

    public static C0515a a(a aVar) {
        return aVar == null ? C0515a.aXi() : aVar.aXd();
    }

    private boolean aXe() {
        return com.baidu.swan.apps.f.a.lA(e.aIM());
    }

    public boolean aXf() {
        return this.ehC;
    }

    public String aXg() {
        return this.ehA + (this.ehB != null ? ":" + this.ehB : "");
    }

    public boolean aXh() {
        return this.ehD;
    }
}
