package com.baidu.swan.pms;

import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.node.b.f;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public interface b {
    void a(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void a(com.baidu.swan.pms.node.a.a aVar);

    void a(f fVar);

    void a(String str, String str2, String str3, int i, JSONObject jSONObject);

    String axH();

    String axI();

    String axJ();

    String axK();

    String axL();

    String axM();

    String axN();

    String axO();

    String axP();

    String axQ();

    CookieManager axR();

    String axS();

    com.baidu.swan.pms.c.f axT();

    void b(JSONArray jSONArray, String str, String str2);

    String getProcessName();

    String getUUID();

    boolean isDebug();
}
