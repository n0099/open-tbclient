package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private boolean dtA;
    private boolean dtB;
    private boolean dtC;
    private String dtx;
    private String dty;
    private boolean dtz;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0494a {
        private String dtD;
        private boolean mEnabled;

        C0494a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.dtD = str;
        }

        public static C0494a aOk() {
            return new C0494a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aOl() {
            return this.dtD;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.dtx = null;
        this.dty = null;
        this.dtz = false;
        this.dtA = false;
        this.dtB = false;
        this.dtC = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.dtx = optJSONObject.optString("hostname", null);
            this.dty = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.dtz = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.dtC = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.dtC) {
            this.dtx = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.dtx);
            this.dty = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.dty);
            this.dtz = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.dtz);
            this.dtA = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.dtA);
        }
        if (this.dtx != null && !this.dtx.trim().equals("")) {
            this.dtB = true;
        }
    }

    public C0494a aOf() {
        if (this.dtC || !aOg()) {
            return new C0494a(this.dtB, !this.dtB ? "未启用真机调试" : this.dtC ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0494a(false, "线上包禁用真机调试");
    }

    public static C0494a a(a aVar) {
        return aVar == null ? C0494a.aOk() : aVar.aOf();
    }

    private boolean aOg() {
        return com.baidu.swan.apps.f.a.kl(e.azK());
    }

    public boolean aOh() {
        return this.dtz;
    }

    public String aOi() {
        return this.dtx + (this.dty != null ? ":" + this.dty : "");
    }

    public boolean aOj() {
        return this.dtA;
    }
}
