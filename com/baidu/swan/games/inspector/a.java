package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private String ekf;
    private String ekg;
    private boolean ekh;
    private boolean eki;
    private boolean ekj;
    private boolean ekk;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0535a {
        private String ekl;
        private boolean mEnabled;

        C0535a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.ekl = str;
        }

        public static C0535a baP() {
            return new C0535a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String baQ() {
            return this.ekl;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.ekf = null;
        this.ekg = null;
        this.ekh = false;
        this.eki = false;
        this.ekj = false;
        this.ekk = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.ekf = optJSONObject.optString("hostname", null);
            this.ekg = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.ekh = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.ekk = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.ekk) {
            this.ekf = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.ekf);
            this.ekg = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.ekg);
            this.ekh = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.ekh);
            this.eki = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.eki);
        }
        if (this.ekf != null && !this.ekf.trim().equals("")) {
            this.ekj = true;
        }
    }

    public C0535a baK() {
        if (this.ekk || !baL()) {
            return new C0535a(this.ekj, !this.ekj ? "未启用真机调试" : this.ekk ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0535a(false, "线上包禁用真机调试");
    }

    public static C0535a a(a aVar) {
        return aVar == null ? C0535a.baP() : aVar.baK();
    }

    private boolean baL() {
        return com.baidu.swan.apps.f.a.mt(e.aMm());
    }

    public boolean baM() {
        return this.ekh;
    }

    public String baN() {
        return this.ekf + (this.ekg != null ? ":" + this.ekg : "");
    }

    public boolean baO() {
        return this.eki;
    }
}
