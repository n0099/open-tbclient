package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private String dtB;
    private String dtC;
    private boolean dtD;
    private boolean dtE;
    private boolean dtF;
    private boolean dtG;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0494a {
        private String dtH;
        private boolean mEnabled;

        C0494a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.dtH = str;
        }

        public static C0494a aOk() {
            return new C0494a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aOl() {
            return this.dtH;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.dtB = null;
        this.dtC = null;
        this.dtD = false;
        this.dtE = false;
        this.dtF = false;
        this.dtG = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.dtB = optJSONObject.optString("hostname", null);
            this.dtC = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.dtD = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.dtG = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.dtG) {
            this.dtB = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.dtB);
            this.dtC = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.dtC);
            this.dtD = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.dtD);
            this.dtE = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.dtE);
        }
        if (this.dtB != null && !this.dtB.trim().equals("")) {
            this.dtF = true;
        }
    }

    public C0494a aOf() {
        if (this.dtG || !aOg()) {
            return new C0494a(this.dtF, !this.dtF ? "未启用真机调试" : this.dtG ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0494a(false, "线上包禁用真机调试");
    }

    public static C0494a a(a aVar) {
        return aVar == null ? C0494a.aOk() : aVar.aOf();
    }

    private boolean aOg() {
        return com.baidu.swan.apps.f.a.km(e.azK());
    }

    public boolean aOh() {
        return this.dtD;
    }

    public String aOi() {
        return this.dtB + (this.dtC != null ? ":" + this.dtC : "");
    }

    public boolean aOj() {
        return this.dtE;
    }
}
