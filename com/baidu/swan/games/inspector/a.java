package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private String bdg;
    private String bdh;
    private boolean bdi;
    private boolean bdj;
    private boolean bdk;
    private boolean bdl;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0193a {
        private String bdm;
        private boolean mEnabled;

        C0193a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.bdm = str;
        }

        public static C0193a Ov() {
            return new C0193a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String Ow() {
            return this.bdm;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.bdg = null;
        this.bdh = null;
        this.bdi = false;
        this.bdj = false;
        this.bdk = false;
        this.bdl = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.bdg = optJSONObject.optString("hostname", null);
            this.bdh = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.bdi = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.bdl = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.bdl) {
            this.bdg = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.bdg);
            this.bdh = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.bdh);
            this.bdi = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.bdi);
            this.bdj = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.bdj);
        }
        if (this.bdg != null && !this.bdg.trim().equals("")) {
            this.bdk = true;
        }
    }

    public C0193a Ot() {
        if (this.bdl || !Ou()) {
            return new C0193a(this.bdk, !this.bdk ? "未启用真机调试" : this.bdl ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0193a(false, "线上包禁用真机调试");
    }

    public static C0193a a(a aVar) {
        return aVar == null ? C0193a.Ov() : aVar.Ot();
    }

    private boolean Ou() {
        return com.baidu.swan.apps.f.a.m14do(com.baidu.swan.apps.ae.b.Jg());
    }
}
