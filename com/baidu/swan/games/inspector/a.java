package com.baidu.swan.games.inspector;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private String bBo;
    private String bBp;
    private boolean bBq;
    private boolean bBr;
    private boolean bBs;
    private boolean bBt;

    /* renamed from: com.baidu.swan.games.inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0246a {
        private String bBu;
        private boolean mEnabled;

        C0246a(boolean z, String str) {
            this.mEnabled = false;
            this.mEnabled = z;
            this.bBu = str;
        }

        public static C0246a Xl() {
            return new C0246a(false, "未启用真机调试");
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public String Xm() {
            return this.bBu;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.bBo = null;
        this.bBp = null;
        this.bBq = false;
        this.bBr = false;
        this.bBs = false;
        this.bBt = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.bBo = optJSONObject.optString("hostname", null);
            this.bBp = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.bBq = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        this.bBt = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        if (this.bBt) {
            this.bBo = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.bBo);
            this.bBp = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.bBp);
            this.bBq = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.bBq);
            this.bBr = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.bBr);
        }
        if (this.bBo != null && !this.bBo.trim().equals("")) {
            this.bBs = true;
        }
    }

    public C0246a Xg() {
        if (this.bBt || !Xh()) {
            return new C0246a(this.bBs, !this.bBs ? "未启用真机调试" : this.bBt ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return new C0246a(false, "线上包禁用真机调试");
    }

    public static C0246a a(a aVar) {
        return aVar == null ? C0246a.Xl() : aVar.Xg();
    }

    private boolean Xh() {
        return com.baidu.swan.apps.f.a.dQ(com.baidu.swan.apps.ae.b.Rk());
    }

    public boolean Xi() {
        return this.bBq;
    }

    public String Xj() {
        return this.bBo + (this.bBp != null ? ":" + this.bBp : "");
    }

    public boolean Xk() {
        return this.bBr;
    }
}
