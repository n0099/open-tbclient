package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private String bdb;
    private String bdc;
    private boolean bdd;
    private boolean bde;
    private boolean bdf;
    private boolean bdg;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0164a {
        private String bdh;
        private boolean mEnabled;

        C0164a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.bdh = str;
        }

        public static C0164a Ox() {
            return new C0164a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String Oy() {
            return this.bdh;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.bdb = null;
        this.bdc = null;
        this.bdd = false;
        this.bde = false;
        this.bdf = false;
        this.bdg = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.bdb = optJSONObject.optString("hostname", null);
            this.bdc = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.bdd = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.bdg = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.bdg) {
            this.bdb = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.bdb);
            this.bdc = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.bdc);
            this.bdd = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.bdd);
            this.bde = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.bde);
        }
        if (this.bdb != null && !this.bdb.trim().equals("")) {
            this.bdf = true;
        }
    }

    public C0164a Ov() {
        if (this.bdg || !Ow()) {
            return new C0164a(this.bdf, !this.bdf ? "未启用真机调试" : this.bdg ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0164a(false, "线上包禁用真机调试");
    }

    public static C0164a a(a aVar) {
        return aVar == null ? C0164a.Ox() : aVar.Ov();
    }

    private boolean Ow() {
        return com.baidu.swan.apps.f.a.dm(com.baidu.swan.apps.ae.b.Ji());
    }
}
