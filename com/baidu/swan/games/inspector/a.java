package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private String bia;
    private String bib;
    private boolean bic;
    private boolean bie;
    private boolean bif;
    private boolean bih;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0200a {
        private String bii;
        private boolean mEnabled;

        C0200a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.bii = str;
        }

        public static C0200a Sq() {
            return new C0200a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String Sr() {
            return this.bii;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.bia = null;
        this.bib = null;
        this.bic = false;
        this.bie = false;
        this.bif = false;
        this.bih = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.bia = optJSONObject.optString("hostname", null);
            this.bib = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.bic = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.bih = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.bih) {
            this.bia = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.bia);
            this.bib = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.bib);
            this.bic = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.bic);
            this.bie = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.bie);
        }
        if (this.bia != null && !this.bia.trim().equals("")) {
            this.bif = true;
        }
    }

    public C0200a Sl() {
        if (this.bih || !Sm()) {
            return new C0200a(this.bif, !this.bif ? "未启用真机调试" : this.bih ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0200a(false, "线上包禁用真机调试");
    }

    public static C0200a a(a aVar) {
        return aVar == null ? C0200a.Sq() : aVar.Sl();
    }

    private boolean Sm() {
        return com.baidu.swan.apps.f.a.df(com.baidu.swan.apps.ae.b.Mo());
    }

    public boolean Sn() {
        return this.bic;
    }

    public String So() {
        return this.bia + (this.bib != null ? ":" + this.bib : "");
    }

    public boolean Sp() {
        return this.bie;
    }
}
