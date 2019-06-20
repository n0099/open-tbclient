package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private String bhn;
    private String bho;
    private boolean bhp;
    private boolean bhq;
    private boolean bhr;
    private boolean bhs;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0203a {
        private String bht;
        private boolean mEnabled;

        C0203a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.bht = str;
        }

        public static C0203a Rx() {
            return new C0203a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String Ry() {
            return this.bht;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.bhn = null;
        this.bho = null;
        this.bhp = false;
        this.bhq = false;
        this.bhr = false;
        this.bhs = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.bhn = optJSONObject.optString("hostname", null);
            this.bho = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.bhp = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.bhs = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.bhs) {
            this.bhn = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.bhn);
            this.bho = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.bho);
            this.bhp = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.bhp);
            this.bhq = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.bhq);
        }
        if (this.bhn != null && !this.bhn.trim().equals("")) {
            this.bhr = true;
        }
    }

    public C0203a Rs() {
        if (this.bhs || !Rt()) {
            return new C0203a(this.bhr, !this.bhr ? "未启用真机调试" : this.bhs ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0203a(false, "线上包禁用真机调试");
    }

    public static C0203a a(a aVar) {
        return aVar == null ? C0203a.Rx() : aVar.Rs();
    }

    private boolean Rt() {
        return com.baidu.swan.apps.f.a.da(com.baidu.swan.apps.ae.b.LB());
    }

    public boolean Ru() {
        return this.bhp;
    }

    public String Rv() {
        return this.bhn + (this.bho != null ? ":" + this.bho : "");
    }

    public boolean Rw() {
        return this.bhq;
    }
}
