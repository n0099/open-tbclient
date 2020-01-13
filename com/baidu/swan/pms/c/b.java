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
/* loaded from: classes10.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.c cVar) {
        PMSAppInfo pMSAppInfo = null;
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.getBundleId());
        hashMap.put("category", String.valueOf(cVar.getCategory()));
        if (cVar.arU() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.arf().pZ(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.arf().c(f.class, cVar.getBundleId()) != null) {
                cVar.it(pMSAppInfo.versionCode);
            } else {
                cVar.it(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.arU()));
        if (cVar.arV() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.arf().pZ(cVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                cVar.bh(pMSAppInfo.appSign);
            } else {
                cVar.bh(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.arV()));
        if (cVar.arW() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.arW()));
        }
        if (TextUtils.isEmpty(cVar.arX())) {
            cVar.qh(io(cVar.getCategory()));
        }
        if (!TextUtils.isEmpty(cVar.arX())) {
            hashMap.put("framework_ver", cVar.arX());
        }
        if (TextUtils.isEmpty(cVar.arY())) {
            cVar.qi(ip(cVar.getCategory()));
        }
        if (!TextUtils.isEmpty(cVar.arY())) {
            hashMap.put("extension_ver", cVar.arY());
        }
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.asc(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, cVar.asc());
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
        hashMap.put("pkg_ver", String.valueOf(eVar.arU()));
        hashMap.put("expect_pkg_ver", String.valueOf(eVar.arU()));
        hashMap.put("sub_id", eVar.asb());
        if (TextUtils.isEmpty(eVar.arX())) {
            eVar.ql(io(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.arX())) {
            hashMap.put("framework_ver", eVar.arX());
        }
        if (TextUtils.isEmpty(eVar.arY())) {
            eVar.qm(ip(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.arY())) {
            hashMap.put("extension_ver", eVar.arY());
        }
        if (eVar.arW() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(eVar.arW()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.arZ());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.asa())) {
            dVar.qk(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.asa());
        return hashMap;
    }

    public static HashMap<String, String> a(g gVar) {
        if (gVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("category", String.valueOf(gVar.getCategory()));
        if (TextUtils.isEmpty(gVar.arX())) {
            gVar.qp(io(gVar.getCategory()));
        }
        if (!TextUtils.isEmpty(gVar.arX())) {
            hashMap.put("framework_ver", gVar.arX());
        }
        if (TextUtils.isEmpty(gVar.arY())) {
            gVar.qq(ip(gVar.getCategory()));
        }
        if (!TextUtils.isEmpty(gVar.arY())) {
            hashMap.put("extension_ver", gVar.arY());
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
        if (!TextUtils.equals(bVar.asc(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, bVar.asc());
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
            jSONObject2.put("swan_core_ver", io(0));
            jSONObject2.put("swan_game_ver", io(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", ip(0));
            jSONObject3.put("game_ext_ver", ip(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.arT()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.arU());
                jSONObject4.put("app_sign", aVar.arV());
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("list", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String io(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.d.aqZ().SI();
        }
        if (i == 0) {
            return com.baidu.swan.pms.d.aqZ().SG();
        }
        return null;
    }

    private static String ip(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.d.aqZ().SJ();
        }
        if (i == 0) {
            return com.baidu.swan.pms.d.aqZ().SH();
        }
        return null;
    }
}
