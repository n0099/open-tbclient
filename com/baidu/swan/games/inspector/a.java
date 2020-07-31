package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private String djp;
    private String djq;
    private boolean djr;
    private boolean djs;
    private boolean djt;
    private boolean dju;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0446a {
        private String djv;
        private boolean mEnabled;

        C0446a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.djv = str;
        }

        public static C0446a aFv() {
            return new C0446a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aFw() {
            return this.djv;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.djp = null;
        this.djq = null;
        this.djr = false;
        this.djs = false;
        this.djt = false;
        this.dju = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.djp = optJSONObject.optString("hostname", null);
            this.djq = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.djr = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.dju = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.dju) {
            this.djp = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.djp);
            this.djq = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.djq);
            this.djr = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.djr);
            this.djs = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.djs);
        }
        if (this.djp != null && !this.djp.trim().equals("")) {
            this.djt = true;
        }
    }

    public C0446a aFq() {
        if (this.dju || !aFr()) {
            return new C0446a(this.djt, !this.djt ? "未启用真机调试" : this.dju ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0446a(false, "线上包禁用真机调试");
    }

    public static C0446a a(a aVar) {
        return aVar == null ? C0446a.aFv() : aVar.aFq();
    }

    private boolean aFr() {
        return com.baidu.swan.apps.e.a.iL(e.arx());
    }

    public boolean aFs() {
        return this.djr;
    }

    public String aFt() {
        return this.djp + (this.djq != null ? ":" + this.djq : "");
    }

    public boolean aFu() {
        return this.djs;
    }
}
