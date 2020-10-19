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
/* loaded from: classes15.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.c cVar) {
        PMSAppInfo pMSAppInfo = null;
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.getBundleId());
        hashMap.put("category", String.valueOf(cVar.getCategory()));
        if (cVar.aXF() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.aWO().xF(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.aWO().c(com.baidu.swan.pms.model.f.class, cVar.getBundleId()) != null) {
                cVar.cu(pMSAppInfo.versionCode);
            } else {
                cVar.cu(0L);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.aXF()));
        if (cVar.aXG() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.aWO().xF(cVar.getBundleId());
            }
            if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                cVar.cv(pMSAppInfo.appSign);
            } else {
                cVar.cv(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.aXG()));
        if (cVar.aXH() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.aXH()));
        }
        String aXI = cVar.aXI();
        if (TextUtils.isEmpty(aXI)) {
            aXI = my(cVar.getCategory());
            cVar.xN(aXI);
        }
        if (TextUtils.isEmpty(aXI)) {
            aXI = "0";
        }
        hashMap.put("framework_ver", aXI);
        String aXJ = cVar.aXJ();
        if (TextUtils.isEmpty(aXJ)) {
            aXJ = mz(cVar.getCategory());
            cVar.xO(aXJ);
        }
        if (TextUtils.isEmpty(aXJ)) {
            aXJ = "0";
        }
        hashMap.put("extension_ver", aXJ);
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.aXP(), "-1")) {
            hashMap.put("scene", cVar.aXP());
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
        hashMap.put("pkg_ver", String.valueOf(fVar.aXO()));
        hashMap.put("expect_pkg_ver", String.valueOf(fVar.aXO()));
        hashMap.put("sub_id", fVar.aXM());
        if (TextUtils.isEmpty(fVar.aXI())) {
            fVar.xR(my(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.aXI())) {
            hashMap.put("framework_ver", fVar.aXI());
        }
        if (TextUtils.isEmpty(fVar.aXJ())) {
            fVar.xS(mz(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.aXJ())) {
            hashMap.put("extension_ver", fVar.aXJ());
        }
        if (fVar.aXH() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(fVar.aXH()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.aXK());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.aXL())) {
            dVar.xQ(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.aXL());
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
        if (!TextUtils.equals(bVar.aXP(), "-1")) {
            hashMap.put("scene", bVar.aXP());
            return hashMap;
        }
        return hashMap;
    }

    public static JSONObject b(com.baidu.swan.pms.c.d.b bVar) {
        if (bVar == null || bVar.aXE() == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("swan_core_ver", my(0));
            jSONObject2.put("swan_game_ver", my(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", mz(0));
            jSONObject3.put("game_ext_ver", mz(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.aXE()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.aXF());
                jSONObject4.put("app_sign", aVar.aXG());
                if (aVar instanceof e.b) {
                    e.b bVar2 = (e.b) aVar;
                    String[] aQM = bVar2.aQM();
                    if (aQM != null && aQM.length > 0) {
                        jSONObject4.put("path", new JSONArray((Collection) Arrays.asList(aQM)));
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    List<e.a> aXN = bVar2.aXN();
                    if (aXN != null && !aXN.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (e.a aVar2 : aXN) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("id", aVar2.aXM());
                            jSONObject6.put("type", aVar2.getType());
                            jSONArray2.put(jSONObject6);
                        }
                        jSONObject5.put("list", jSONArray2);
                        jSONObject5.put("ver", aXN.get(0).getVersion());
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

    private static String my(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aWI().atv();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aWI().att();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private static String mz(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aWI().atw();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aWI().atu();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }
}
