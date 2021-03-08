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
/* loaded from: classes3.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.c cVar) {
        PMSAppInfo pMSAppInfo = null;
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.getBundleId());
        hashMap.put("category", String.valueOf(cVar.getCategory()));
        if (cVar.bdn() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.bcx().yc(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.bcx().d(com.baidu.swan.pms.model.f.class, cVar.getBundleId()) != null) {
                cVar.dy(pMSAppInfo.versionCode);
            } else {
                cVar.dy(0L);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.bdn()));
        if (cVar.bdo() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.bcx().yc(cVar.getBundleId());
            }
            if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                cVar.dz(pMSAppInfo.appSign);
            } else {
                cVar.dz(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.bdo()));
        if (cVar.bdp() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.bdp()));
        }
        String bdq = cVar.bdq();
        if (TextUtils.isEmpty(bdq)) {
            bdq = lU(cVar.getCategory());
            cVar.yk(bdq);
        }
        if (TextUtils.isEmpty(bdq)) {
            bdq = "0";
        }
        hashMap.put("framework_ver", bdq);
        String bdr = cVar.bdr();
        if (TextUtils.isEmpty(bdr)) {
            bdr = lV(cVar.getCategory());
            cVar.yl(bdr);
        }
        if (TextUtils.isEmpty(bdr)) {
            bdr = "0";
        }
        hashMap.put("extension_ver", bdr);
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.bdx(), "-1")) {
            hashMap.put("scene", cVar.bdx());
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
        hashMap.put("pkg_ver", String.valueOf(fVar.bdw()));
        hashMap.put("expect_pkg_ver", String.valueOf(fVar.bdw()));
        hashMap.put("sub_id", fVar.bdu());
        if (TextUtils.isEmpty(fVar.bdq())) {
            fVar.yo(lU(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.bdq())) {
            hashMap.put("framework_ver", fVar.bdq());
        }
        if (TextUtils.isEmpty(fVar.bdr())) {
            fVar.yp(lV(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.bdr())) {
            hashMap.put("extension_ver", fVar.bdr());
        }
        if (fVar.bdp() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(fVar.bdp()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.bds());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.bdt())) {
            dVar.yn(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.bdt());
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
        if (!TextUtils.equals(bVar.bdx(), "-1")) {
            hashMap.put("scene", bVar.bdx());
            return hashMap;
        }
        return hashMap;
    }

    public static JSONObject b(com.baidu.swan.pms.c.d.b bVar) {
        if (bVar == null || bVar.bdm() == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("swan_core_ver", lU(0));
            jSONObject2.put("swan_game_ver", lU(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", lV(0));
            jSONObject3.put("game_ext_ver", lV(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.bdm()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.bdn());
                jSONObject4.put("app_sign", aVar.bdo());
                if (aVar instanceof e.b) {
                    e.b bVar2 = (e.b) aVar;
                    String[] aWt = bVar2.aWt();
                    if (aWt != null && aWt.length > 0) {
                        jSONObject4.put("path", new JSONArray((Collection) Arrays.asList(aWt)));
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    List<e.a> bdv = bVar2.bdv();
                    if (bdv != null && !bdv.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (e.a aVar2 : bdv) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("id", aVar2.bdu());
                            jSONObject6.put("type", aVar2.getType());
                            jSONArray2.put(jSONObject6);
                        }
                        jSONObject5.put("list", jSONArray2);
                        jSONObject5.put("ver", bdv.get(0).getVersion());
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

    private static String lU(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.bcr().ayo();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.bcr().aym();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private static String lV(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.bcr().ayp();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.bcr().ayn();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }
}
