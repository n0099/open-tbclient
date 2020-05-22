package com.baidu.swan.pms.node.d;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.f.e;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b dnm;

    public static b aHm() {
        if (dnm == null) {
            synchronized (b.class) {
                if (dnm == null) {
                    dnm = new b();
                }
            }
        }
        return dnm;
    }

    public void b(JSONArray jSONArray, g gVar, g gVar2) {
        if (jSONArray != null && jSONArray.length() != 0) {
            a aVar = new a();
            a aVar2 = new a();
            e eVar = new e();
            e eVar2 = new e();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("type");
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        if (!TextUtils.isEmpty(jSONObject2.getString(SharedPrefConfig.VERSION_NAME))) {
                            char c = 65535;
                            switch (string.hashCode()) {
                                case -612557761:
                                    if (string.equals(ETAG.KEY_EXTENSION)) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 714512640:
                                    if (string.equals("bbasp_core")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 714618195:
                                    if (string.equals("bbasp_game")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    com.baidu.swan.pms.model.d dVar = (com.baidu.swan.pms.model.d) com.baidu.swan.pms.f.d.a(jSONObject2, new com.baidu.swan.pms.model.d());
                                    if (dVar != null) {
                                        a(dVar, eVar);
                                        aVar.dnl = dVar;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 1:
                                    com.baidu.swan.pms.model.d dVar2 = (com.baidu.swan.pms.model.d) com.baidu.swan.pms.f.d.a(jSONObject2, new com.baidu.swan.pms.model.d());
                                    if (dVar2 != null) {
                                        a(dVar2, eVar2);
                                        aVar2.dnk = dVar2;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 2:
                                    com.baidu.swan.pms.model.b bVar = (com.baidu.swan.pms.model.b) com.baidu.swan.pms.f.d.a(jSONObject2, new com.baidu.swan.pms.model.b());
                                    if (bVar != null) {
                                        a(bVar, eVar);
                                        aVar.dmz = bVar;
                                        break;
                                    } else {
                                        continue;
                                    }
                                default:
                                    continue;
                            }
                        }
                    }
                } catch (JSONException e) {
                }
            }
            if (gVar != null) {
                if (eVar.aHn() == 0) {
                    gVar.ZL();
                } else {
                    gVar.a(eVar);
                    com.baidu.swan.pms.c.a.a.a(aVar, gVar);
                }
            }
            if (gVar2 != null) {
                if (eVar2.aHn() == 0) {
                    gVar2.ZL();
                    return;
                }
                gVar2.a(eVar2);
                com.baidu.swan.pms.c.a.a.a(aVar2, gVar2);
            }
        }
    }

    protected void a(com.baidu.swan.pms.model.e eVar, e eVar2) {
        if (eVar != null) {
            eVar2.a(eVar, PMSPkgStatus.WAIT);
        }
    }
}
