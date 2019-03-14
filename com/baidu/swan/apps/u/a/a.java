package com.baidu.swan.apps.u.a;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.ubc.q;
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
    public String Dg() {
        return com.baidu.swan.apps.u.a.CK().vG();
    }

    @Override // com.baidu.swan.pms.b
    public String Dh() {
        return com.baidu.swan.apps.u.a.CD().bJ(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String Di() {
        return com.baidu.swan.apps.u.a.CK().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String Dj() {
        return aa.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String Dk() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String Dl() {
        return com.baidu.swan.apps.swancore.b.dI(0);
    }

    @Override // com.baidu.swan.pms.b
    public String Dm() {
        ExtensionCore At = com.baidu.swan.apps.extcore.a.Bj().At();
        if (At != null) {
            String str = At.avM;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    @Override // com.baidu.swan.pms.b
    public String Dn() {
        return com.baidu.swan.apps.swancore.b.dI(1);
    }

    @Override // com.baidu.swan.pms.b
    public String Do() {
        return "";
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager Dp() {
        return com.baidu.swan.apps.u.a.CV().Dt();
    }

    @Override // com.baidu.swan.pms.b
    public boolean D(String str, int i) {
        return com.baidu.swan.apps.u.a.De().h(str, i);
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
            q.onEvent("874", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
