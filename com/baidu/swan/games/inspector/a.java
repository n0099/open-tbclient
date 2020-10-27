package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private String dQa;
    private String dQb;
    private boolean dQc;
    private boolean dQd;
    private boolean dQe;
    private boolean dQf;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0520a {
        private String dQg;
        private boolean mEnabled;

        C0520a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.dQg = str;
        }

        public static C0520a aTy() {
            return new C0520a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aTz() {
            return this.dQg;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.dQa = null;
        this.dQb = null;
        this.dQc = false;
        this.dQd = false;
        this.dQe = false;
        this.dQf = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.dQa = optJSONObject.optString("hostname", null);
            this.dQb = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.dQc = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.dQf = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.dQf) {
            this.dQa = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.dQa);
            this.dQb = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.dQb);
            this.dQc = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.dQc);
            this.dQd = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.dQd);
        }
        if (this.dQa != null && !this.dQa.trim().equals("")) {
            this.dQe = true;
        }
    }

    public C0520a aTt() {
        if (this.dQf || !aTu()) {
            return new C0520a(this.dQe, !this.dQe ? "未启用真机调试" : this.dQf ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0520a(false, "线上包禁用真机调试");
    }

    public static C0520a a(a aVar) {
        return aVar == null ? C0520a.aTy() : aVar.aTt();
    }

    private boolean aTu() {
        return com.baidu.swan.apps.f.a.lK(e.aEW());
    }

    public boolean aTv() {
        return this.dQc;
    }

    public String aTw() {
        return this.dQa + (this.dQb != null ? ":" + this.dQb : "");
    }

    public boolean aTx() {
        return this.dQd;
    }
}
