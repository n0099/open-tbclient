package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.swan.pms.c.d.b;
import com.baidu.swan.pms.c.d.g;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
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
        if (cVar.aCy() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.aBI().rA(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.aBI().c(f.class, cVar.getBundleId()) != null) {
                cVar.iR(pMSAppInfo.versionCode);
            } else {
                cVar.iR(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.aCy()));
        if (cVar.aCz() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.aBI().rA(cVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                cVar.bQ(pMSAppInfo.appSign);
            } else {
                cVar.bQ(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.aCz()));
        if (cVar.aCA() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.aCA()));
        }
        if (TextUtils.isEmpty(cVar.aCB())) {
            cVar.rI(iM(cVar.getCategory()));
        }
        if (!TextUtils.isEmpty(cVar.aCB())) {
            hashMap.put("framework_ver", cVar.aCB());
        }
        if (TextUtils.isEmpty(cVar.aCC())) {
            cVar.rJ(iN(cVar.getCategory()));
        }
        if (!TextUtils.isEmpty(cVar.aCC())) {
            hashMap.put("extension_ver", cVar.aCC());
        }
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.aCG(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, cVar.aCG());
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
        hashMap.put("pkg_ver", String.valueOf(eVar.aCy()));
        hashMap.put("expect_pkg_ver", String.valueOf(eVar.aCy()));
        hashMap.put("sub_id", eVar.aCF());
        if (TextUtils.isEmpty(eVar.aCB())) {
            eVar.rM(iM(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.aCB())) {
            hashMap.put("framework_ver", eVar.aCB());
        }
        if (TextUtils.isEmpty(eVar.aCC())) {
            eVar.rN(iN(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.aCC())) {
            hashMap.put("extension_ver", eVar.aCC());
        }
        if (eVar.aCA() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(eVar.aCA()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.aCD());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.aCE())) {
            dVar.rL(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.aCE());
        return hashMap;
    }

    public static HashMap<String, String> a(g gVar) {
        if (gVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("category", String.valueOf(gVar.getCategory()));
        if (TextUtils.isEmpty(gVar.aCB())) {
            gVar.rQ(iM(gVar.getCategory()));
        }
        if (!TextUtils.isEmpty(gVar.aCB())) {
            hashMap.put("framework_ver", gVar.aCB());
        }
        if (TextUtils.isEmpty(gVar.aCC())) {
            gVar.rR(iN(gVar.getCategory()));
        }
        if (!TextUtils.isEmpty(gVar.aCC())) {
            hashMap.put("extension_ver", gVar.aCC());
            return hashMap;
        }
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
        if (!TextUtils.equals(bVar.aCG(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, bVar.aCG());
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
            jSONObject2.put("swan_core_ver", iM(0));
            jSONObject2.put("swan_game_ver", iM(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", iN(0));
            jSONObject3.put("game_ext_ver", iN(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.aCx()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.aCy());
                jSONObject4.put("app_sign", aVar.aCz());
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("list", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String iM(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.d.aBC().acP();
        }
        if (i == 0) {
            return com.baidu.swan.pms.d.aBC().acN();
        }
        return null;
    }

    private static String iN(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.d.aBC().acQ();
        }
        if (i == 0) {
            return com.baidu.swan.pms.d.aBC().acO();
        }
        return null;
    }
}
