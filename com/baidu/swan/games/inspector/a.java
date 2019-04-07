package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private String bdf;
    private String bdg;
    private boolean bdh;
    private boolean bdi;
    private boolean bdj;
    private boolean bdk;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0193a {
        private String bdl;
        private boolean mEnabled;

        C0193a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.bdl = str;
        }

        public static C0193a Ov() {
            return new C0193a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String Ow() {
            return this.bdl;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.bdf = null;
        this.bdg = null;
        this.bdh = false;
        this.bdi = false;
        this.bdj = false;
        this.bdk = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.bdf = optJSONObject.optString("hostname", null);
            this.bdg = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.bdh = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.bdk = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.bdk) {
            this.bdf = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.bdf);
            this.bdg = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.bdg);
            this.bdh = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.bdh);
            this.bdi = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.bdi);
        }
        if (this.bdf != null && !this.bdf.trim().equals("")) {
            this.bdj = true;
        }
    }

    public C0193a Ot() {
        if (this.bdk || !Ou()) {
            return new C0193a(this.bdj, !this.bdj ? "未启用真机调试" : this.bdk ? "使用了 debug 面板配置" : "启用了真机调试");
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
