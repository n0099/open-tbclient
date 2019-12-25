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
/* loaded from: classes9.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.c cVar) {
        PMSAppInfo pMSAppInfo = null;
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.getBundleId());
        hashMap.put("category", String.valueOf(cVar.getCategory()));
        if (cVar.arB() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.aqM().pW(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.aqM().c(f.class, cVar.getBundleId()) != null) {
                cVar.it(pMSAppInfo.versionCode);
            } else {
                cVar.it(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.arB()));
        if (cVar.arC() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.aqM().pW(cVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                cVar.be(pMSAppInfo.appSign);
            } else {
                cVar.be(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.arC()));
        if (cVar.arD() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.arD()));
        }
        if (TextUtils.isEmpty(cVar.arE())) {
            cVar.qe(io(cVar.getCategory()));
        }
        if (!TextUtils.isEmpty(cVar.arE())) {
            hashMap.put("framework_ver", cVar.arE());
        }
        if (TextUtils.isEmpty(cVar.arF())) {
            cVar.qf(ip(cVar.getCategory()));
        }
        if (!TextUtils.isEmpty(cVar.arF())) {
            hashMap.put("extension_ver", cVar.arF());
        }
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.arJ(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, cVar.arJ());
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
        hashMap.put("pkg_ver", String.valueOf(eVar.arB()));
        hashMap.put("expect_pkg_ver", String.valueOf(eVar.arB()));
        hashMap.put("sub_id", eVar.arI());
        if (TextUtils.isEmpty(eVar.arE())) {
            eVar.qi(io(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.arE())) {
            hashMap.put("framework_ver", eVar.arE());
        }
        if (TextUtils.isEmpty(eVar.arF())) {
            eVar.qj(ip(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.arF())) {
            hashMap.put("extension_ver", eVar.arF());
        }
        if (eVar.arD() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(eVar.arD()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.arG());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.arH())) {
            dVar.qh(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.arH());
        return hashMap;
    }

    public static HashMap<String, String> a(g gVar) {
        if (gVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("category", String.valueOf(gVar.getCategory()));
        if (TextUtils.isEmpty(gVar.arE())) {
            gVar.qm(io(gVar.getCategory()));
        }
        if (!TextUtils.isEmpty(gVar.arE())) {
            hashMap.put("framework_ver", gVar.arE());
        }
        if (TextUtils.isEmpty(gVar.arF())) {
            gVar.qn(ip(gVar.getCategory()));
        }
        if (!TextUtils.isEmpty(gVar.arF())) {
            hashMap.put("extension_ver", gVar.arF());
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
        if (!TextUtils.equals(bVar.arJ(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, bVar.arJ());
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
            for (b.a aVar : bVar.arA()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.arB());
                jSONObject4.put("app_sign", aVar.arC());
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
            return com.baidu.swan.pms.d.aqG().Sm();
        }
        if (i == 0) {
            return com.baidu.swan.pms.d.aqG().Sk();
        }
        return null;
    }

    private static String ip(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.d.aqG().Sn();
        }
        if (i == 0) {
            return com.baidu.swan.pms.d.aqG().Sl();
        }
        return null;
    }
}
