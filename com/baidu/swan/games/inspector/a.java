package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    private String ebi;
    private String ebj;
    private boolean ebk;
    private boolean ebl;
    private boolean ebm;
    private boolean ebn;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0542a {
        private String ebo;
        private boolean mEnabled;

        C0542a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.ebo = str;
        }

        public static C0542a aYv() {
            return new C0542a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aYw() {
            return this.ebo;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.ebi = null;
        this.ebj = null;
        this.ebk = false;
        this.ebl = false;
        this.ebm = false;
        this.ebn = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.ebi = optJSONObject.optString("hostname", null);
            this.ebj = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.ebk = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.ebn = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.ebn) {
            this.ebi = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.ebi);
            this.ebj = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.ebj);
            this.ebk = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.ebk);
            this.ebl = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.ebl);
        }
        if (this.ebi != null && !this.ebi.trim().equals("")) {
            this.ebm = true;
        }
    }

    public C0542a aYq() {
        if (this.ebn || !aYr()) {
            return new C0542a(this.ebm, !this.ebm ? "未启用真机调试" : this.ebn ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0542a(false, "线上包禁用真机调试");
    }

    public static C0542a a(a aVar) {
        return aVar == null ? C0542a.aYv() : aVar.aYq();
    }

    private boolean aYr() {
        return com.baidu.swan.apps.f.a.mA(e.aJW());
    }

    public boolean aYs() {
        return this.ebk;
    }

    public String aYt() {
        return this.ebi + (this.ebj != null ? ":" + this.ebj : "");
    }

    public boolean aYu() {
        return this.ebl;
    }
}
