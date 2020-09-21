package com.baidu.swan.pms.node.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.utils.f;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private static volatile b dJe;

    public static b aVv() {
        if (dJe == null) {
            synchronized (b.class) {
                if (dJe == null) {
                    dJe = new b();
                }
            }
        }
        return dJe;
    }

    public void b(JSONArray jSONArray, g gVar, g gVar2, g gVar3) {
        c cVar;
        if (DEBUG) {
            Log.i("SoBundleId", "updateConfig: soCallback=" + gVar3);
        }
        if (jSONArray != null && jSONArray.length() != 0) {
            a aVar = new a();
            a aVar2 = new a();
            f fVar = new f();
            f fVar2 = new f();
            if (gVar3 == null) {
                cVar = null;
            } else {
                cVar = gVar3.mM("so");
            }
            if (DEBUG) {
                Log.i("SoBundleId", "updateConfig: soNodeHandler=" + cVar);
            }
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
                                case 3676:
                                    if (string.equals("so")) {
                                        c = 3;
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
                                    com.baidu.swan.pms.model.d dVar = (com.baidu.swan.pms.model.d) com.baidu.swan.pms.utils.e.a(jSONObject2, new com.baidu.swan.pms.model.d());
                                    if (dVar != null) {
                                        a(dVar, fVar);
                                        aVar.dJc = dVar;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 1:
                                    com.baidu.swan.pms.model.d dVar2 = (com.baidu.swan.pms.model.d) com.baidu.swan.pms.utils.e.a(jSONObject2, new com.baidu.swan.pms.model.d());
                                    if (dVar2 != null) {
                                        a(dVar2, fVar2);
                                        aVar2.dJb = dVar2;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 2:
                                    com.baidu.swan.pms.model.b bVar = (com.baidu.swan.pms.model.b) com.baidu.swan.pms.utils.e.a(jSONObject2, new com.baidu.swan.pms.model.b());
                                    if (bVar != null) {
                                        a(bVar, fVar);
                                        aVar.dIp = bVar;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 3:
                                    if (DEBUG) {
                                        Log.i("SoBundleId", "updateConfig: case so= " + jSONObject2 + " soNodeHandler=" + cVar);
                                    }
                                    if (cVar != null) {
                                        cVar.parseData(jSONObject2);
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
                    if (DEBUG) {
                        Log.i("SoBundleId", "updateConfig: end parse by catch=" + e);
                    }
                }
            }
            if (DEBUG) {
                Log.i("SoBundleId", "updateConfig: end parse soNodeHandler=" + cVar);
            }
            if (gVar != null) {
                if (fVar.aVw() == 0) {
                    gVar.agl();
                } else {
                    gVar.a(fVar);
                    com.baidu.swan.pms.c.a.a.a(aVar, gVar);
                }
            }
            if (DEBUG) {
                Log.i("SoBundleId", "updateConfig: handle core end");
            }
            if (gVar2 != null) {
                if (fVar2.aVw() == 0) {
                    gVar2.agl();
                } else {
                    gVar2.a(fVar2);
                    com.baidu.swan.pms.c.a.a.a(aVar2, gVar2);
                }
            }
            if (DEBUG) {
                Log.i("SoBundleId", "updateConfig: handle game end");
            }
            if (cVar != null) {
                cVar.amD();
            }
            if (DEBUG) {
                Log.i("SoBundleId", "updateConfig: handle so end");
            }
        }
    }

    public static void a(com.baidu.swan.pms.model.e eVar, f fVar) {
        if (eVar != null) {
            fVar.a(eVar, PMSPkgStatus.WAIT);
        }
    }
}
