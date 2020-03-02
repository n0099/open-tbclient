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
    public String UR() {
        return com.baidu.swan.apps.w.a.Ui().Ie();
    }

    @Override // com.baidu.swan.pms.b
    public String US() {
        return com.baidu.swan.apps.w.a.Ub().br(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String getUUID() {
        return com.baidu.swan.uuid.b.dH(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.pms.b
    public String UT() {
        return com.baidu.swan.apps.w.a.UH().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String UU() {
        return ai.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String UV() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String UW() {
        return com.baidu.swan.apps.swancore.b.gy(0);
    }

    @Override // com.baidu.swan.pms.b
    public String UX() {
        return com.baidu.swan.apps.extcore.b.eP(0);
    }

    @Override // com.baidu.swan.pms.b
    public String UY() {
        return com.baidu.swan.apps.swancore.b.gy(1);
    }

    @Override // com.baidu.swan.pms.b
    public String UZ() {
        return com.baidu.swan.apps.extcore.b.eP(1);
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager Va() {
        return com.baidu.swan.apps.w.a.Uu().Iu();
    }

    @Override // com.baidu.swan.pms.b
    public String Vb() {
        return com.baidu.swan.apps.w.a.TZ().He();
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
