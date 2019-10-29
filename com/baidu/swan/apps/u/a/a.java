package com.baidu.swan.apps.u.a;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.ubc.s;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.pms.b {
    @Override // com.baidu.swan.pms.b
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.pms.b
    public String JQ() {
        return com.baidu.swan.apps.u.a.Ju().BT();
    }

    @Override // com.baidu.swan.pms.b
    public String JR() {
        return com.baidu.swan.apps.u.a.Jn().bf(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String JS() {
        return com.baidu.swan.apps.u.a.Ju().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String JT() {
        return ac.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String JU() {
        return c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String JV() {
        return com.baidu.swan.apps.swancore.b.eR(0);
    }

    @Override // com.baidu.swan.pms.b
    public String JW() {
        ExtensionCore Hh = com.baidu.swan.apps.extcore.a.HR().Hh();
        if (Hh != null) {
            String str = Hh.aQF;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    @Override // com.baidu.swan.pms.b
    public String JX() {
        return com.baidu.swan.apps.swancore.b.eR(1);
    }

    @Override // com.baidu.swan.pms.b
    public String JY() {
        return "";
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager JZ() {
        return com.baidu.swan.apps.u.a.JF().Kd();
    }

    @Override // com.baidu.swan.pms.b
    public boolean A(String str, int i) {
        return com.baidu.swan.apps.u.a.JO().l(str, i);
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
}
