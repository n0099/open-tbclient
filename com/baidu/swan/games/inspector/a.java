package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private String coK;
    private String coL;
    private boolean coM;
    private boolean coN;
    private boolean coO;
    private boolean coP;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0337a {
        private String coQ;
        private boolean mEnabled;

        C0337a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.coQ = str;
        }

        public static C0337a aoB() {
            return new C0337a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String aoC() {
            return this.coQ;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.coK = null;
        this.coL = null;
        this.coM = false;
        this.coN = false;
        this.coO = false;
        this.coP = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.coK = optJSONObject.optString("hostname", null);
            this.coL = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.coM = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.coP = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.coP) {
            this.coK = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.coK);
            this.coL = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.coL);
            this.coM = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.coM);
            this.coN = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.coN);
        }
        if (this.coK != null && !this.coK.trim().equals("")) {
            this.coO = true;
        }
    }

    public C0337a aow() {
        if (this.coP || !aox()) {
            return new C0337a(this.coO, !this.coO ? "未启用真机调试" : this.coP ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0337a(false, "线上包禁用真机调试");
    }

    public static C0337a a(a aVar) {
        return aVar == null ? C0337a.aoB() : aVar.aow();
    }

    private boolean aox() {
        return com.baidu.swan.apps.e.a.gh(e.acF());
    }

    public boolean aoy() {
        return this.coM;
    }

    public String aoz() {
        return this.coK + (this.coL != null ? ":" + this.coL : "");
    }

    public boolean aoA() {
        return this.coN;
    }
}
