package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private String biA;
    private String biB;
    private boolean biC;
    private boolean biD;
    private boolean biE;
    private boolean biF;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0214a {
        private String biG;
        private boolean mEnabled;

        C0214a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.biG = str;
        }

        public static C0214a Su() {
            return new C0214a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String Sv() {
            return this.biG;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.biA = null;
        this.biB = null;
        this.biC = false;
        this.biD = false;
        this.biE = false;
        this.biF = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.biA = optJSONObject.optString("hostname", null);
            this.biB = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.biC = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.biF = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.biF) {
            this.biA = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.biA);
            this.biB = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.biB);
            this.biC = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.biC);
            this.biD = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.biD);
        }
        if (this.biA != null && !this.biA.trim().equals("")) {
            this.biE = true;
        }
    }

    public C0214a Sp() {
        if (this.biF || !Sq()) {
            return new C0214a(this.biE, !this.biE ? "未启用真机调试" : this.biF ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0214a(false, "线上包禁用真机调试");
    }

    public static C0214a a(a aVar) {
        return aVar == null ? C0214a.Su() : aVar.Sp();
    }

    private boolean Sq() {
        return com.baidu.swan.apps.f.a.dh(com.baidu.swan.apps.ae.b.Ms());
    }

    public boolean Sr() {
        return this.biC;
    }

    public String Ss() {
        return this.biA + (this.biB != null ? ":" + this.biB : "");
    }

    public boolean St() {
        return this.biD;
    }
}
