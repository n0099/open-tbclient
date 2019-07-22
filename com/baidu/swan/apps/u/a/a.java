package com.baidu.swan.apps.u.a;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.ubc.s;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.pms.b {
    @Override // com.baidu.swan.pms.b
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.pms.b
    public String ES() {
        return com.baidu.swan.apps.u.a.Ew().wV();
    }

    @Override // com.baidu.swan.pms.b
    public String ET() {
        return com.baidu.swan.apps.u.a.Ep().bd(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String EU() {
        return com.baidu.swan.apps.u.a.Ew().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String EV() {
        return ac.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String EW() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String EX() {
        return com.baidu.swan.apps.swancore.b.dV(0);
    }

    @Override // com.baidu.swan.pms.b
    public String EY() {
        ExtensionCore Cj = com.baidu.swan.apps.extcore.a.CT().Cj();
        if (Cj != null) {
            String str = Cj.awS;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    @Override // com.baidu.swan.pms.b
    public String EZ() {
        return com.baidu.swan.apps.swancore.b.dV(1);
    }

    @Override // com.baidu.swan.pms.b
    public String Fa() {
        return "";
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager Fb() {
        return com.baidu.swan.apps.u.a.EH().Ff();
    }

    @Override // com.baidu.swan.pms.b
    public boolean A(String str, int i) {
        return com.baidu.swan.apps.u.a.EQ().h(str, i);
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
            jSONObject2.put(UBC.CONTENT_KEY_VALUE, String.valueOf(i));
            if (jSONObject != null) {
                jSONObject2.put("ext", jSONObject);
            }
            s.onEvent("874", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
