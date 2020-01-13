package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private String ckG;
    private String ckH;
    private boolean ckI;
    private boolean ckJ;
    private boolean ckK;
    private boolean ckL;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0327a {
        private String ckM;
        private boolean mEnabled;

        C0327a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.ckM = str;
        }

        public static C0327a amo() {
            return new C0327a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String amp() {
            return this.ckM;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.ckG = null;
        this.ckH = null;
        this.ckI = false;
        this.ckJ = false;
        this.ckK = false;
        this.ckL = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.ckG = optJSONObject.optString("hostname", null);
            this.ckH = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.ckI = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.ckL = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.ckL) {
            this.ckG = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.ckG);
            this.ckH = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.ckH);
            this.ckI = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.ckI);
            this.ckJ = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.ckJ);
        }
        if (this.ckG != null && !this.ckG.trim().equals("")) {
            this.ckK = true;
        }
    }

    public C0327a amj() {
        if (this.ckL || !amk()) {
            return new C0327a(this.ckK, !this.ckK ? "未启用真机调试" : this.ckL ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0327a(false, "线上包禁用真机调试");
    }

    public static C0327a a(a aVar) {
        return aVar == null ? C0327a.amo() : aVar.amj();
    }

    private boolean amk() {
        return com.baidu.swan.apps.e.a.fS(e.aar());
    }

    public boolean aml() {
        return this.ckI;
    }

    public String amm() {
        return this.ckG + (this.ckH != null ? ":" + this.ckH : "");
    }

    public boolean amn() {
        return this.ckJ;
    }
}
