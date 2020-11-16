package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private String dUk;
    private String dUl;
    private boolean dUm;
    private boolean dUn;
    private boolean dUo;
    private boolean dUp;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0530a {
        private String dUq;
        private boolean mEnabled;

        C0530a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.dUq = str;
        }

        public static C0530a aVq() {
            return new C0530a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aVr() {
            return this.dUq;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.dUk = null;
        this.dUl = null;
        this.dUm = false;
        this.dUn = false;
        this.dUo = false;
        this.dUp = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.dUk = optJSONObject.optString("hostname", null);
            this.dUl = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.dUm = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.dUp = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.dUp) {
            this.dUk = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.dUk);
            this.dUl = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.dUl);
            this.dUm = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.dUm);
            this.dUn = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.dUn);
        }
        if (this.dUk != null && !this.dUk.trim().equals("")) {
            this.dUo = true;
        }
    }

    public C0530a aVl() {
        if (this.dUp || !aVm()) {
            return new C0530a(this.dUo, !this.dUo ? "未启用真机调试" : this.dUp ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0530a(false, "线上包禁用真机调试");
    }

    public static C0530a a(a aVar) {
        return aVar == null ? C0530a.aVq() : aVar.aVl();
    }

    private boolean aVm() {
        return com.baidu.swan.apps.f.a.lT(e.aGO());
    }

    public boolean aVn() {
        return this.dUm;
    }

    public String aVo() {
        return this.dUk + (this.dUl != null ? ":" + this.dUl : "");
    }

    public boolean aVp() {
        return this.dUn;
    }
}
