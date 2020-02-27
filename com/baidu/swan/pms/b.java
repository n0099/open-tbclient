package com.baidu.swan.pms;

import com.baidu.searchbox.http.cookie.CookieManager;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public interface b {
    String UP();

    String UQ();

    String UR();

    String US();

    String UT();

    String UU();

    String UV();

    String UW();

    String UX();

    CookieManager UY();

    String UZ();

    void a(String str, String str2, String str3, int i, JSONObject jSONObject);

    String getProcessName();

    String getUUID();

    boolean isDebug();
}
