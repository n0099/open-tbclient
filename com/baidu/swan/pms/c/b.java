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
        if (cVar.auk() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.atv().qo(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.atv().c(f.class, cVar.getBundleId()) != null) {
                cVar.iK(pMSAppInfo.versionCode);
            } else {
                cVar.iK(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.auk()));
        if (cVar.aul() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.atv().qo(cVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                cVar.bl(pMSAppInfo.appSign);
            } else {
                cVar.bl(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.aul()));
        if (cVar.aum() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.aum()));
        }
        if (TextUtils.isEmpty(cVar.aun())) {
            cVar.qw(iF(cVar.getCategory()));
        }
        if (!TextUtils.isEmpty(cVar.aun())) {
            hashMap.put("framework_ver", cVar.aun());
        }
        if (TextUtils.isEmpty(cVar.auo())) {
            cVar.qx(iG(cVar.getCategory()));
        }
        if (!TextUtils.isEmpty(cVar.auo())) {
            hashMap.put("extension_ver", cVar.auo());
        }
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.aus(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, cVar.aus());
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
        hashMap.put("pkg_ver", String.valueOf(eVar.auk()));
        hashMap.put("expect_pkg_ver", String.valueOf(eVar.auk()));
        hashMap.put("sub_id", eVar.aur());
        if (TextUtils.isEmpty(eVar.aun())) {
            eVar.qA(iF(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.aun())) {
            hashMap.put("framework_ver", eVar.aun());
        }
        if (TextUtils.isEmpty(eVar.auo())) {
            eVar.qB(iG(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.auo())) {
            hashMap.put("extension_ver", eVar.auo());
        }
        if (eVar.aum() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(eVar.aum()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.aup());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.auq())) {
            dVar.qz(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.auq());
        return hashMap;
    }

    public static HashMap<String, String> a(g gVar) {
        if (gVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("category", String.valueOf(gVar.getCategory()));
        if (TextUtils.isEmpty(gVar.aun())) {
            gVar.qE(iF(gVar.getCategory()));
        }
        if (!TextUtils.isEmpty(gVar.aun())) {
            hashMap.put("framework_ver", gVar.aun());
        }
        if (TextUtils.isEmpty(gVar.auo())) {
            gVar.qF(iG(gVar.getCategory()));
        }
        if (!TextUtils.isEmpty(gVar.auo())) {
            hashMap.put("extension_ver", gVar.auo());
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
        if (!TextUtils.equals(bVar.aus(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, bVar.aus());
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
            jSONObject2.put("swan_core_ver", iF(0));
            jSONObject2.put("swan_game_ver", iF(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", iG(0));
            jSONObject3.put("game_ext_ver", iG(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.auj()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.auk());
                jSONObject4.put("app_sign", aVar.aul());
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("list", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String iF(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.d.atp().UY();
        }
        if (i == 0) {
            return com.baidu.swan.pms.d.atp().UW();
        }
        return null;
    }

    private static String iG(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.d.atp().UZ();
        }
        if (i == 0) {
            return com.baidu.swan.pms.d.atp().UX();
        }
        return null;
    }
}
