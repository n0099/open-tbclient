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

    String avh();

    String avi();

    String avj();

    String avk();

    String avl();

    String avm();

    String avn();

    String avo();

    String avp();

    String avq();

    CookieManager avr();

    String avs();

    com.baidu.swan.pms.c.f avt();

    void b(JSONArray jSONArray, String str, String str2);

    String getProcessName();

    String getUUID();

    boolean isDebug();
}
