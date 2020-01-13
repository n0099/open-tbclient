package com.baidu.swan.pms;

import com.baidu.searchbox.http.cookie.CookieManager;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public interface b {
    String SB();

    String SC();

    String SD();

    String SE();

    String SF();

    String SG();

    String SH();

    String SI();

    String SJ();

    CookieManager SK();

    String SL();

    void a(String str, String str2, String str3, int i, JSONObject jSONObject);

    String getProcessName();

    String getUUID();

    boolean isDebug();
}
