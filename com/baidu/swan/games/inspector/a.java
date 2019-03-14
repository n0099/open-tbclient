package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private String bdc;
    private String bdd;
    private boolean bde;
    private boolean bdf;
    private boolean bdg;
    private boolean bdh;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0193a {
        private String bdi;
        private boolean mEnabled;

        C0193a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.bdi = str;
        }

        public static C0193a Ox() {
            return new C0193a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String Oy() {
            return this.bdi;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.bdc = null;
        this.bdd = null;
        this.bde = false;
        this.bdf = false;
        this.bdg = false;
        this.bdh = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.bdc = optJSONObject.optString("hostname", null);
            this.bdd = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.bde = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.bdh = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.bdh) {
            this.bdc = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.bdc);
            this.bdd = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.bdd);
            this.bde = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.bde);
            this.bdf = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.bdf);
        }
        if (this.bdc != null && !this.bdc.trim().equals("")) {
            this.bdg = true;
        }
    }

    public C0193a Ov() {
        if (this.bdh || !Ow()) {
            return new C0193a(this.bdg, !this.bdg ? "未启用真机调试" : this.bdh ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0193a(false, "线上包禁用真机调试");
    }

    public static C0193a a(a aVar) {
        return aVar == null ? C0193a.Ox() : aVar.Ov();
    }

    private boolean Ow() {
        return com.baidu.swan.apps.f.a.dm(com.baidu.swan.apps.ae.b.Ji());
    }
}
