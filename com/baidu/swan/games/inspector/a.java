package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private String ckt;
    private String cku;
    private boolean ckv;
    private boolean ckw;
    private boolean ckx;
    private boolean cky;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0325a {
        private String ckz;
        private boolean mEnabled;

        C0325a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.ckz = str;
        }

        public static C0325a alV() {
            return new C0325a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String alW() {
            return this.ckz;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.ckt = null;
        this.cku = null;
        this.ckv = false;
        this.ckw = false;
        this.ckx = false;
        this.cky = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.ckt = optJSONObject.optString("hostname", null);
            this.cku = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.ckv = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.cky = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.cky) {
            this.ckt = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.ckt);
            this.cku = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.cku);
            this.ckv = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.ckv);
            this.ckw = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.ckw);
        }
        if (this.ckt != null && !this.ckt.trim().equals("")) {
            this.ckx = true;
        }
    }

    public C0325a alQ() {
        if (this.cky || !alR()) {
            return new C0325a(this.ckx, !this.ckx ? "未启用真机调试" : this.cky ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0325a(false, "线上包禁用真机调试");
    }

    public static C0325a a(a aVar) {
        return aVar == null ? C0325a.alV() : aVar.alQ();
    }

    private boolean alR() {
        return com.baidu.swan.apps.e.a.fP(e.ZU());
    }

    public boolean alS() {
        return this.ckv;
    }

    public String alT() {
        return this.ckt + (this.cku != null ? ":" + this.cku : "");
    }

    public boolean alU() {
        return this.ckw;
    }
}
