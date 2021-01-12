package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private String efs;
    private String eft;
    private boolean efu;
    private boolean efv;
    private boolean efw;
    private boolean efx;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0518a {
        private String efy;
        private boolean mEnabled;

        C0518a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.efy = str;
        }

        public static C0518a aWW() {
            return new C0518a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aWX() {
            return this.efy;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.efs = null;
        this.eft = null;
        this.efu = false;
        this.efv = false;
        this.efw = false;
        this.efx = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.efs = optJSONObject.optString("hostname", null);
            this.eft = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.efu = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.efx = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.efx) {
            this.efs = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.efs);
            this.eft = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.eft);
            this.efu = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.efu);
            this.efv = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.efv);
        }
        if (this.efs != null && !this.efs.trim().equals("")) {
            this.efw = true;
        }
    }

    public C0518a aWR() {
        if (this.efx || !aWS()) {
            return new C0518a(this.efw, !this.efw ? "未启用真机调试" : this.efx ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0518a(false, "线上包禁用真机调试");
    }

    public static C0518a a(a aVar) {
        return aVar == null ? C0518a.aWW() : aVar.aWR();
    }

    private boolean aWS() {
        return com.baidu.swan.apps.f.a.li(e.aIt());
    }

    public boolean aWT() {
        return this.efu;
    }

    public String aWU() {
        return this.efs + (this.eft != null ? ":" + this.eft : "");
    }

    public boolean aWV() {
        return this.efv;
    }
}
