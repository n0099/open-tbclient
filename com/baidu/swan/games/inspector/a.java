package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private String dHD;
    private String dHE;
    private boolean dHF;
    private boolean dHG;
    private boolean dHH;
    private boolean dHI;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0506a {
        private String dHJ;
        private boolean mEnabled;

        C0506a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.dHJ = str;
        }

        public static C0506a aRE() {
            return new C0506a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aRF() {
            return this.dHJ;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.dHD = null;
        this.dHE = null;
        this.dHF = false;
        this.dHG = false;
        this.dHH = false;
        this.dHI = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.dHD = optJSONObject.optString("hostname", null);
            this.dHE = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.dHF = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.dHI = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.dHI) {
            this.dHD = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.dHD);
            this.dHE = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.dHE);
            this.dHF = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.dHF);
            this.dHG = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.dHG);
        }
        if (this.dHD != null && !this.dHD.trim().equals("")) {
            this.dHH = true;
        }
    }

    public C0506a aRz() {
        if (this.dHI || !aRA()) {
            return new C0506a(this.dHH, !this.dHH ? "未启用真机调试" : this.dHI ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0506a(false, "线上包禁用真机调试");
    }

    public static C0506a a(a aVar) {
        return aVar == null ? C0506a.aRE() : aVar.aRz();
    }

    private boolean aRA() {
        return com.baidu.swan.apps.f.a.lr(e.aDc());
    }

    public boolean aRB() {
        return this.dHF;
    }

    public String aRC() {
        return this.dHD + (this.dHE != null ? ":" + this.dHE : "");
    }

    public boolean aRD() {
        return this.dHG;
    }
}
