package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.swan.pms.c.d.b;
import com.baidu.swan.pms.c.d.e;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.webkit.internal.ETAG;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.c cVar) {
        PMSAppInfo pMSAppInfo = null;
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.getBundleId());
        hashMap.put("category", String.valueOf(cVar.getCategory()));
        if (cVar.aLL() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.aKS().uq(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.aKS().c(com.baidu.swan.pms.model.f.class, cVar.getBundleId()) != null) {
                cVar.jN(pMSAppInfo.versionCode);
            } else {
                cVar.jN(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.aLL()));
        if (cVar.aLM() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.aKS().uq(cVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                cVar.ce(pMSAppInfo.appSign);
            } else {
                cVar.ce(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.aLM()));
        if (cVar.aLN() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.aLN()));
        }
        String aLO = cVar.aLO();
        if (TextUtils.isEmpty(aLO)) {
            aLO = jI(cVar.getCategory());
            cVar.uy(aLO);
        }
        if (TextUtils.isEmpty(aLO)) {
            aLO = "0";
        }
        hashMap.put("framework_ver", aLO);
        String aLP = cVar.aLP();
        if (TextUtils.isEmpty(aLP)) {
            aLP = jJ(cVar.getCategory());
            cVar.uz(aLP);
        }
        if (TextUtils.isEmpty(aLP)) {
            aLP = "0";
        }
        hashMap.put("extension_ver", aLP);
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.aLU(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, cVar.aLU());
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.f fVar) {
        if (fVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", fVar.getBundleId());
        hashMap.put("category", String.valueOf(fVar.getCategory()));
        hashMap.put("pkg_ver", String.valueOf(fVar.aLL()));
        hashMap.put("expect_pkg_ver", String.valueOf(fVar.aLL()));
        hashMap.put("sub_id", fVar.aLS());
        if (TextUtils.isEmpty(fVar.aLO())) {
            fVar.uC(jI(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.aLO())) {
            hashMap.put("framework_ver", fVar.aLO());
        }
        if (TextUtils.isEmpty(fVar.aLP())) {
            fVar.uD(jJ(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.aLP())) {
            hashMap.put("extension_ver", fVar.aLP());
        }
        if (fVar.aLN() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(fVar.aLN()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.aLQ());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.aLR())) {
            dVar.uB(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.aLR());
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
        if (!TextUtils.equals(bVar.aLU(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, bVar.aLU());
            return hashMap;
        }
        return hashMap;
    }

    public static JSONObject b(com.baidu.swan.pms.c.d.b bVar) {
        if (bVar == null || bVar.aLK() == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("swan_core_ver", jI(0));
            jSONObject2.put("swan_game_ver", jI(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", jJ(0));
            jSONObject3.put("game_ext_ver", jJ(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.aLK()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.aLL());
                jSONObject4.put("app_sign", aVar.aLM());
                if (aVar instanceof e.b) {
                    e.b bVar2 = (e.b) aVar;
                    String[] aEE = bVar2.aEE();
                    if (aEE != null && aEE.length > 0) {
                        jSONObject4.put("path", new JSONArray((Collection) Arrays.asList(aEE)));
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    List<e.a> aLT = bVar2.aLT();
                    if (aLT != null && !aLT.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (e.a aVar2 : aLT) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("id", aVar2.aLS());
                            jSONObject6.put("type", aVar2.getType());
                            jSONArray2.put(jSONObject6);
                        }
                        jSONObject5.put("list", jSONArray2);
                        jSONObject5.put("ver", aLT.get(0).getVersion());
                    }
                    jSONObject4.put("sub_info", jSONObject5);
                }
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("list", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String jI(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aKM().ait();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aKM().air();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private static String jJ(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aKM().aiu();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aKM().ais();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }
}
