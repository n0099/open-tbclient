package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private boolean bAA;
    private boolean bAB;
    private boolean bAC;
    private String bAx;
    private String bAy;
    private boolean bAz;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0241a {
        private String bAD;
        private boolean mEnabled;

        C0241a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.bAD = str;
        }

        public static C0241a Xj() {
            return new C0241a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String Xk() {
            return this.bAD;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.bAx = null;
        this.bAy = null;
        this.bAz = false;
        this.bAA = false;
        this.bAB = false;
        this.bAC = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.bAx = optJSONObject.optString("hostname", null);
            this.bAy = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.bAz = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.bAC = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.bAC) {
            this.bAx = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.bAx);
            this.bAy = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.bAy);
            this.bAz = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.bAz);
            this.bAA = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.bAA);
        }
        if (this.bAx != null && !this.bAx.trim().equals("")) {
            this.bAB = true;
        }
    }

    public C0241a Xe() {
        if (this.bAC || !Xf()) {
            return new C0241a(this.bAB, !this.bAB ? "未启用真机调试" : this.bAC ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0241a(false, "线上包禁用真机调试");
    }

    public static C0241a a(a aVar) {
        return aVar == null ? C0241a.Xj() : aVar.Xe();
    }

    private boolean Xf() {
        return com.baidu.swan.apps.f.a.dQ(com.baidu.swan.apps.ae.b.Rm());
    }

    public boolean Xg() {
        return this.bAz;
    }

    public String Xh() {
        return this.bAx + (this.bAy != null ? ":" + this.bAy : "");
    }

    public boolean Xi() {
        return this.bAA;
    }
}
