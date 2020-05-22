package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String cYR;
    private String cYS;
    private boolean cYT;
    private boolean cYU;
    private boolean cYV;
    private boolean cYW;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0427a {
        private String cYX;
        private boolean mEnabled;

        C0427a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.cYX = str;
        }

        public static C0427a aAI() {
            return new C0427a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aAJ() {
            return this.cYX;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.cYR = null;
        this.cYS = null;
        this.cYT = false;
        this.cYU = false;
        this.cYV = false;
        this.cYW = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.cYR = optJSONObject.optString("hostname", null);
            this.cYS = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.cYT = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.cYW = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.cYW) {
            this.cYR = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.cYR);
            this.cYS = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.cYS);
            this.cYT = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.cYT);
            this.cYU = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.cYU);
        }
        if (this.cYR != null && !this.cYR.trim().equals("")) {
            this.cYV = true;
        }
    }

    public C0427a aAD() {
        if (this.cYW || !aAE()) {
            return new C0427a(this.cYV, !this.cYV ? "未启用真机调试" : this.cYW ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0427a(false, "线上包禁用真机调试");
    }

    public static C0427a a(a aVar) {
        return aVar == null ? C0427a.aAI() : aVar.aAD();
    }

    private boolean aAE() {
        return com.baidu.swan.apps.e.a.it(e.aoH());
    }

    public boolean aAF() {
        return this.cYT;
    }

    public String aAG() {
        return this.cYR + (this.cYS != null ? ":" + this.cYS : "");
    }

    public boolean aAH() {
        return this.cYU;
    }
}
