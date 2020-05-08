package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String cNZ;
    private String cOa;
    private boolean cOb;
    private boolean cOc;
    private boolean cOd;
    private boolean cOe;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0388a {
        private String cOf;
        private boolean mEnabled;

        C0388a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.cOf = str;
        }

        public static C0388a awT() {
            return new C0388a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String awU() {
            return this.cOf;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.cNZ = null;
        this.cOa = null;
        this.cOb = false;
        this.cOc = false;
        this.cOd = false;
        this.cOe = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.cNZ = optJSONObject.optString("hostname", null);
            this.cOa = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.cOb = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.cOe = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.cOe) {
            this.cNZ = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.cNZ);
            this.cOa = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.cOa);
            this.cOb = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.cOb);
            this.cOc = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.cOc);
        }
        if (this.cNZ != null && !this.cNZ.trim().equals("")) {
            this.cOd = true;
        }
    }

    public C0388a awO() {
        if (this.cOe || !awP()) {
            return new C0388a(this.cOd, !this.cOd ? "未启用真机调试" : this.cOe ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0388a(false, "线上包禁用真机调试");
    }

    public static C0388a a(a aVar) {
        return aVar == null ? C0388a.awT() : aVar.awO();
    }

    private boolean awP() {
        return com.baidu.swan.apps.e.a.hu(e.akO());
    }

    public boolean awQ() {
        return this.cOb;
    }

    public String awR() {
        return this.cNZ + (this.cOa != null ? ":" + this.cOa : "");
    }

    public boolean awS() {
        return this.cOc;
    }
}
