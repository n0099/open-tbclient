package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String cNU;
    private String cNV;
    private boolean cNW;
    private boolean cNX;
    private boolean cNY;
    private boolean cNZ;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0367a {
        private String cOa;
        private boolean mEnabled;

        C0367a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.cOa = str;
        }

        public static C0367a awT() {
            return new C0367a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String awU() {
            return this.cOa;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.cNU = null;
        this.cNV = null;
        this.cNW = false;
        this.cNX = false;
        this.cNY = false;
        this.cNZ = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.cNU = optJSONObject.optString("hostname", null);
            this.cNV = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.cNW = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.cNZ = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.cNZ) {
            this.cNU = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.cNU);
            this.cNV = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.cNV);
            this.cNW = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.cNW);
            this.cNX = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.cNX);
        }
        if (this.cNU != null && !this.cNU.trim().equals("")) {
            this.cNY = true;
        }
    }

    public C0367a awO() {
        if (this.cNZ || !awP()) {
            return new C0367a(this.cNY, !this.cNY ? "未启用真机调试" : this.cNZ ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0367a(false, "线上包禁用真机调试");
    }

    public static C0367a a(a aVar) {
        return aVar == null ? C0367a.awT() : aVar.awO();
    }

    private boolean awP() {
        return com.baidu.swan.apps.e.a.hu(e.akP());
    }

    public boolean awQ() {
        return this.cNW;
    }

    public String awR() {
        return this.cNU + (this.cNV != null ? ":" + this.cNV : "");
    }

    public boolean awS() {
        return this.cNX;
    }
}
