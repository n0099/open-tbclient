package com.baidu.swan.pms;

import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.node.b.f;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface b {
    void a(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z);

    void a(com.baidu.swan.pms.node.a.a aVar);

    void a(f fVar);

    void a(String str, String str2, String str3, int i, JSONObject jSONObject);

    String awZ();

    String axa();

    String axb();

    String axc();

    String axd();

    String axe();

    String axf();

    String axg();

    String axh();

    String axi();

    CookieManager axj();

    String axk();

    com.baidu.swan.pms.c.f axl();

    void b(JSONArray jSONArray, String str, String str2);

    String getProcessName();

    String getUUID();

    boolean isDebug();
}
