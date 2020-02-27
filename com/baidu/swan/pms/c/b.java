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
        if (cVar.aui() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.att().qo(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.att().c(f.class, cVar.getBundleId()) != null) {
                cVar.iK(pMSAppInfo.versionCode);
            } else {
                cVar.iK(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.aui()));
        if (cVar.auj() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.att().qo(cVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                cVar.bl(pMSAppInfo.appSign);
            } else {
                cVar.bl(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.auj()));
        if (cVar.auk() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.auk()));
        }
        if (TextUtils.isEmpty(cVar.aul())) {
            cVar.qw(iF(cVar.getCategory()));
        }
        if (!TextUtils.isEmpty(cVar.aul())) {
            hashMap.put("framework_ver", cVar.aul());
        }
        if (TextUtils.isEmpty(cVar.aum())) {
            cVar.qx(iG(cVar.getCategory()));
        }
        if (!TextUtils.isEmpty(cVar.aum())) {
            hashMap.put("extension_ver", cVar.aum());
        }
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.auq(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, cVar.auq());
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
        hashMap.put("pkg_ver", String.valueOf(eVar.aui()));
        hashMap.put("expect_pkg_ver", String.valueOf(eVar.aui()));
        hashMap.put("sub_id", eVar.aup());
        if (TextUtils.isEmpty(eVar.aul())) {
            eVar.qA(iF(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.aul())) {
            hashMap.put("framework_ver", eVar.aul());
        }
        if (TextUtils.isEmpty(eVar.aum())) {
            eVar.qB(iG(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.aum())) {
            hashMap.put("extension_ver", eVar.aum());
        }
        if (eVar.auk() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(eVar.auk()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.aun());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.auo())) {
            dVar.qz(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.auo());
        return hashMap;
    }

    public static HashMap<String, String> a(g gVar) {
        if (gVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("category", String.valueOf(gVar.getCategory()));
        if (TextUtils.isEmpty(gVar.aul())) {
            gVar.qE(iF(gVar.getCategory()));
        }
        if (!TextUtils.isEmpty(gVar.aul())) {
            hashMap.put("framework_ver", gVar.aul());
        }
        if (TextUtils.isEmpty(gVar.aum())) {
            gVar.qF(iG(gVar.getCategory()));
        }
        if (!TextUtils.isEmpty(gVar.aum())) {
            hashMap.put("extension_ver", gVar.aum());
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
        if (!TextUtils.equals(bVar.auq(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, bVar.auq());
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
            for (b.a aVar : bVar.auh()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.aui());
                jSONObject4.put("app_sign", aVar.auj());
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
            return com.baidu.swan.pms.d.atn().UW();
        }
        if (i == 0) {
            return com.baidu.swan.pms.d.atn().UU();
        }
        return null;
    }

    private static String iG(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.d.atn().UX();
        }
        if (i == 0) {
            return com.baidu.swan.pms.d.atn().UV();
        }
        return null;
    }
}
