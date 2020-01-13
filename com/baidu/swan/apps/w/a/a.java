package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.ubc.s;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.pms.b {
    @Override // com.baidu.swan.pms.b
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.pms.b
    public String SB() {
        return com.baidu.swan.apps.w.a.RS().FN();
    }

    @Override // com.baidu.swan.pms.b
    public String SC() {
        return com.baidu.swan.apps.w.a.RL().bn(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String getUUID() {
        return com.baidu.swan.uuid.b.dD(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.pms.b
    public String SD() {
        return com.baidu.swan.apps.w.a.Sr().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String SE() {
        return ai.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String SF() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String SG() {
        return com.baidu.swan.apps.swancore.b.gh(0);
    }

    @Override // com.baidu.swan.pms.b
    public String SH() {
        return com.baidu.swan.apps.extcore.b.ez(0);
    }

    @Override // com.baidu.swan.pms.b
    public String SI() {
        return com.baidu.swan.apps.swancore.b.gh(1);
    }

    @Override // com.baidu.swan.pms.b
    public String SJ() {
        return com.baidu.swan.apps.extcore.b.ez(1);
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager SK() {
        return com.baidu.swan.apps.w.a.Se().Gd();
    }

    @Override // com.baidu.swan.pms.b
    public String SL() {
        return com.baidu.swan.apps.w.a.RJ().EN();
    }

    @Override // com.baidu.swan.pms.b
    public void a(String str, String str2, String str3, int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("from", str);
            jSONObject2.put("type", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("page", str3);
            }
            jSONObject2.put("value", String.valueOf(i));
            if (jSONObject != null) {
                jSONObject2.put("ext", jSONObject);
            }
            s.k("874", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.swan.pms.b
    public String getProcessName() {
        return ProcessUtils.getCurProcessName();
    }
}
