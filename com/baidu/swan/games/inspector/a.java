package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private String ejb;
    private String ejc;
    private boolean ejd;
    private boolean eje;
    private boolean ejf;
    private boolean ejg;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0521a {
        private String ejh;
        private boolean mEnabled;

        C0521a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.ejh = str;
        }

        public static C0521a aXl() {
            return new C0521a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aXm() {
            return this.ejh;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.ejb = null;
        this.ejc = null;
        this.ejd = false;
        this.eje = false;
        this.ejf = false;
        this.ejg = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.ejb = optJSONObject.optString("hostname", null);
            this.ejc = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.ejd = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.ejg = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.ejg) {
            this.ejb = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.ejb);
            this.ejc = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.ejc);
            this.ejd = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.ejd);
            this.eje = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.eje);
        }
        if (this.ejb != null && !this.ejb.trim().equals("")) {
            this.ejf = true;
        }
    }

    public C0521a aXg() {
        if (this.ejg || !aXh()) {
            return new C0521a(this.ejf, !this.ejf ? "未启用真机调试" : this.ejg ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0521a(false, "线上包禁用真机调试");
    }

    public static C0521a a(a aVar) {
        return aVar == null ? C0521a.aXl() : aVar.aXg();
    }

    private boolean aXh() {
        return com.baidu.swan.apps.f.a.lH(e.aIP());
    }

    public boolean aXi() {
        return this.ejd;
    }

    public String aXj() {
        return this.ejb + (this.ejc != null ? ":" + this.ejc : "");
    }

    public boolean aXk() {
        return this.eje;
    }
}
