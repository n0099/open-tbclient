package com.baidu.swan.pms;

import com.baidu.searchbox.http.cookie.CookieManager;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface b {
    String Sf();

    String Sg();

    String Sh();

    String Si();

    String Sj();

    String Sk();

    String Sl();

    String Sm();

    String Sn();

    CookieManager So();

    String Sp();

    void a(String str, String str2, String str3, int i, JSONObject jSONObject);

    String getProcessName();

    String getUUID();

    boolean isDebug();
}
