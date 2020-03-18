package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String coX;
    private String coY;
    private boolean coZ;
    private boolean cpa;
    private boolean cpb;
    private boolean cpc;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0337a {
        private String cpd;
        private boolean mEnabled;

        C0337a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.cpd = str;
        }

        public static C0337a aoG() {
            return new C0337a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aoH() {
            return this.cpd;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.coX = null;
        this.coY = null;
        this.coZ = false;
        this.cpa = false;
        this.cpb = false;
        this.cpc = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.coX = optJSONObject.optString("hostname", null);
            this.coY = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.coZ = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.cpc = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.cpc) {
            this.coX = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.coX);
            this.coY = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.coY);
            this.coZ = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.coZ);
            this.cpa = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.cpa);
        }
        if (this.coX != null && !this.coX.trim().equals("")) {
            this.cpb = true;
        }
    }

    public C0337a aoB() {
        if (this.cpc || !aoC()) {
            return new C0337a(this.cpb, !this.cpb ? "未启用真机调试" : this.cpc ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0337a(false, "线上包禁用真机调试");
    }

    public static C0337a a(a aVar) {
        return aVar == null ? C0337a.aoG() : aVar.aoB();
    }

    private boolean aoC() {
        return com.baidu.swan.apps.e.a.gg(e.acK());
    }

    public boolean aoD() {
        return this.coZ;
    }

    public String aoE() {
        return this.coX + (this.coY != null ? ":" + this.coY : "");
    }

    public boolean aoF() {
        return this.cpa;
    }
}
