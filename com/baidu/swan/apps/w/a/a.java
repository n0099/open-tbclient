package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.ubc.s;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.pms.b {
    @Override // com.baidu.swan.pms.b
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.pms.b
    public String Sf() {
        return com.baidu.swan.apps.w.a.Rw().Fr();
    }

    @Override // com.baidu.swan.pms.b
    public String Sg() {
        return com.baidu.swan.apps.w.a.Rp().bn(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String getUUID() {
        return com.baidu.swan.uuid.b.dD(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.pms.b
    public String Sh() {
        return com.baidu.swan.apps.w.a.RV().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String Si() {
        return ai.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String Sj() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String Sk() {
        return com.baidu.swan.apps.swancore.b.gg(0);
    }

    @Override // com.baidu.swan.pms.b
    public String Sl() {
        return com.baidu.swan.apps.extcore.b.ey(0);
    }

    @Override // com.baidu.swan.pms.b
    public String Sm() {
        return com.baidu.swan.apps.swancore.b.gg(1);
    }

    @Override // com.baidu.swan.pms.b
    public String Sn() {
        return com.baidu.swan.apps.extcore.b.ey(1);
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager So() {
        return com.baidu.swan.apps.w.a.RI().FH();
    }

    @Override // com.baidu.swan.pms.b
    public String Sp() {
        return com.baidu.swan.apps.w.a.Rn().Er();
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
