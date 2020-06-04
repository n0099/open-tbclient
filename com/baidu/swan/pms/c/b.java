package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.swan.pms.c.d.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.c cVar) {
        PMSAppInfo pMSAppInfo = null;
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.getBundleId());
        hashMap.put("category", String.valueOf(cVar.getCategory()));
        if (cVar.aGO() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.aFV().tf(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.aFV().c(com.baidu.swan.pms.model.f.class, cVar.getBundleId()) != null) {
                cVar.jj(pMSAppInfo.versionCode);
            } else {
                cVar.jj(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.aGO()));
        if (cVar.aGP() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.aFV().tf(cVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                cVar.bO(pMSAppInfo.appSign);
            } else {
                cVar.bO(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.aGP()));
        if (cVar.aGQ() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.aGQ()));
        }
        String aGR = cVar.aGR();
        if (TextUtils.isEmpty(aGR)) {
            aGR = je(cVar.getCategory());
            cVar.tn(aGR);
        }
        if (TextUtils.isEmpty(aGR)) {
            aGR = "0";
        }
        hashMap.put("framework_ver", aGR);
        String aGS = cVar.aGS();
        if (TextUtils.isEmpty(aGS)) {
            aGS = jf(cVar.getCategory());
            cVar.to(aGS);
        }
        if (TextUtils.isEmpty(aGS)) {
            aGS = "0";
        }
        hashMap.put("extension_ver", aGS);
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.aGW(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, cVar.aGW());
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.e eVar) {
        if (eVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", eVar.getBundleId());
        hashMap.put("category", String.valueOf(eVar.getCategory()));
        hashMap.put("pkg_ver", String.valueOf(eVar.aGO()));
        hashMap.put("expect_pkg_ver", String.valueOf(eVar.aGO()));
        hashMap.put("sub_id", eVar.aGV());
        if (TextUtils.isEmpty(eVar.aGR())) {
            eVar.tr(je(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.aGR())) {
            hashMap.put("framework_ver", eVar.aGR());
        }
        if (TextUtils.isEmpty(eVar.aGS())) {
            eVar.ts(jf(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.aGS())) {
            hashMap.put("extension_ver", eVar.aGS());
        }
        if (eVar.aGQ() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(eVar.aGQ()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.aGT());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.aGU())) {
            dVar.tq(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.aGU());
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.b bVar) {
        if (bVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.equals(bVar.getFrom(), "-1")) {
            hashMap.put("from", bVar.getFrom());
        }
        if (!TextUtils.equals(bVar.aGW(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, bVar.aGW());
            return hashMap;
        }
        return hashMap;
    }

    public static JSONObject b(com.baidu.swan.pms.c.d.b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("swan_core_ver", je(0));
            jSONObject2.put("swan_game_ver", je(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", jf(0));
            jSONObject3.put("game_ext_ver", jf(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.aGN()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.aGO());
                jSONObject4.put("app_sign", aVar.aGP());
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("list", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String je(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aFP().afY();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aFP().afW();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private static String jf(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aFP().afZ();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aFP().afX();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }
}
