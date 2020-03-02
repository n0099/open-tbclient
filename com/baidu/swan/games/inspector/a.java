package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String coL;
    private String coM;
    private boolean coN;
    private boolean coO;
    private boolean coP;
    private boolean coQ;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0337a {
        private String coR;
        private boolean mEnabled;

        C0337a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.coR = str;
        }

        public static C0337a aoD() {
            return new C0337a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aoE() {
            return this.coR;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.coL = null;
        this.coM = null;
        this.coN = false;
        this.coO = false;
        this.coP = false;
        this.coQ = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.coL = optJSONObject.optString("hostname", null);
            this.coM = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.coN = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.coQ = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.coQ) {
            this.coL = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.coL);
            this.coM = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.coM);
            this.coN = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.coN);
            this.coO = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.coO);
        }
        if (this.coL != null && !this.coL.trim().equals("")) {
            this.coP = true;
        }
    }

    public C0337a aoy() {
        if (this.coQ || !aoz()) {
            return new C0337a(this.coP, !this.coP ? "未启用真机调试" : this.coQ ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0337a(false, "线上包禁用真机调试");
    }

    public static C0337a a(a aVar) {
        return aVar == null ? C0337a.aoD() : aVar.aoy();
    }

    private boolean aoz() {
        return com.baidu.swan.apps.e.a.gh(e.acH());
    }

    public boolean aoA() {
        return this.coN;
    }

    public String aoB() {
        return this.coL + (this.coM != null ? ":" + this.coM : "");
    }

    public boolean aoC() {
        return this.coO;
    }
}
