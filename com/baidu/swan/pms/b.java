package com.baidu.swan.pms;

import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.node.b.f;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public interface b {
    void a(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void a(com.baidu.swan.pms.node.a.a aVar);

    void a(f fVar);

    void a(String str, String str2, String str3, int i, JSONObject jSONObject);

    String apR();

    String apS();

    String apT();

    String apU();

    String apV();

    String apW();

    String apX();

    String apY();

    String apZ();

    String aqa();

    CookieManager aqb();

    String aqc();

    com.baidu.swan.pms.c.f aqd();

    void b(JSONArray jSONArray, String str, String str2);

    String getProcessName();

    String getUUID();

    boolean isDebug();
}
