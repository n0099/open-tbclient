package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.swan.pms.PMSConstants;
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
/* loaded from: classes14.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.c cVar) {
        PMSAppInfo pMSAppInfo = null;
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.getBundleId());
        hashMap.put("category", String.valueOf(cVar.getCategory()));
        if (cVar.aUk() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.aTt().wA(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.aTt().c(com.baidu.swan.pms.model.f.class, cVar.getBundleId()) != null) {
                cVar.cl(pMSAppInfo.versionCode);
            } else {
                cVar.cl(0L);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.aUk()));
        if (cVar.aUl() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.aTt().wA(cVar.getBundleId());
            }
            if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                cVar.cm(pMSAppInfo.appSign);
            } else {
                cVar.cm(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.aUl()));
        if (cVar.aUm() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.aUm()));
        }
        String aUn = cVar.aUn();
        if (TextUtils.isEmpty(aUn)) {
            aUn = lQ(cVar.getCategory());
            cVar.wI(aUn);
        }
        if (TextUtils.isEmpty(aUn)) {
            aUn = "0";
        }
        hashMap.put("framework_ver", aUn);
        String aUo = cVar.aUo();
        if (TextUtils.isEmpty(aUo)) {
            aUo = lR(cVar.getCategory());
            cVar.wJ(aUo);
        }
        if (TextUtils.isEmpty(aUo)) {
            aUo = "0";
        }
        hashMap.put("extension_ver", aUo);
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.aUu(), "-1")) {
            hashMap.put("scene", cVar.aUu());
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
        hashMap.put("pkg_ver", String.valueOf(fVar.aUt()));
        hashMap.put("expect_pkg_ver", String.valueOf(fVar.aUt()));
        hashMap.put("sub_id", fVar.aUr());
        if (TextUtils.isEmpty(fVar.aUn())) {
            fVar.wM(lQ(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.aUn())) {
            hashMap.put("framework_ver", fVar.aUn());
        }
        if (TextUtils.isEmpty(fVar.aUo())) {
            fVar.wN(lR(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.aUo())) {
            hashMap.put("extension_ver", fVar.aUo());
        }
        if (fVar.aUm() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(fVar.aUm()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.aUp());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.aUq())) {
            dVar.wL(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.aUq());
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
        if (!TextUtils.equals(bVar.aUu(), "-1")) {
            hashMap.put("scene", bVar.aUu());
            return hashMap;
        }
        return hashMap;
    }

    public static JSONObject b(com.baidu.swan.pms.c.d.b bVar) {
        if (bVar == null || bVar.aUj() == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("swan_core_ver", lQ(0));
            jSONObject2.put("swan_game_ver", lQ(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", lR(0));
            jSONObject3.put("game_ext_ver", lR(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.aUj()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.aUk());
                jSONObject4.put("app_sign", aVar.aUl());
                if (aVar instanceof e.b) {
                    e.b bVar2 = (e.b) aVar;
                    String[] aNs = bVar2.aNs();
                    if (aNs != null && aNs.length > 0) {
                        jSONObject4.put("path", new JSONArray((Collection) Arrays.asList(aNs)));
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    List<e.a> aUs = bVar2.aUs();
                    if (aUs != null && !aUs.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (e.a aVar2 : aUs) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("id", aVar2.aUr());
                            jSONObject6.put("type", aVar2.getType());
                            jSONArray2.put(jSONObject6);
                        }
                        jSONObject5.put("list", jSONArray2);
                        jSONObject5.put("ver", aUs.get(0).getVersion());
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

    private static String lQ(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aTn().apZ();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aTn().apX();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private static String lR(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aTn().aqa();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aTn().apY();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }
}
