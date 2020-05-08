package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.ubc.s;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.pms.b {
    @Override // com.baidu.swan.pms.b
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.pms.b
    public String acI() {
        return com.baidu.swan.apps.w.a.abZ().PS();
    }

    @Override // com.baidu.swan.pms.b
    public String acJ() {
        return com.baidu.swan.apps.w.a.abS().aS(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String getUUID() {
        return com.baidu.swan.uuid.b.di(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.pms.b
    public String acK() {
        return com.baidu.swan.apps.w.a.acy().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String acL() {
        return ai.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String acM() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String acN() {
        return com.baidu.swan.apps.swancore.b.gF(0);
    }

    @Override // com.baidu.swan.pms.b
    public String acO() {
        return com.baidu.swan.apps.extcore.b.eU(0);
    }

    @Override // com.baidu.swan.pms.b
    public String acP() {
        return com.baidu.swan.apps.swancore.b.gF(1);
    }

    @Override // com.baidu.swan.pms.b
    public String acQ() {
        return com.baidu.swan.apps.extcore.b.eU(1);
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager acR() {
        return com.baidu.swan.apps.w.a.acl().Qi();
    }

    @Override // com.baidu.swan.pms.b
    public String acS() {
        return com.baidu.swan.apps.w.a.abQ().OV();
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
            s.onEvent("874", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.swan.pms.b
    public String getProcessName() {
        return ProcessUtils.getCurProcessName();
    }
}
