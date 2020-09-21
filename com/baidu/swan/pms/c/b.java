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
/* loaded from: classes24.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.c cVar) {
        PMSAppInfo pMSAppInfo = null;
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.getBundleId());
        hashMap.put("category", String.valueOf(cVar.getCategory()));
        if (cVar.aUW() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.aUf().wT(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.aUf().c(com.baidu.swan.pms.model.f.class, cVar.getBundleId()) != null) {
                cVar.cm(pMSAppInfo.versionCode);
            } else {
                cVar.cm(0L);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.aUW()));
        if (cVar.aUX() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.aUf().wT(cVar.getBundleId());
            }
            if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                cVar.cn(pMSAppInfo.appSign);
            } else {
                cVar.cn(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.aUX()));
        if (cVar.aUY() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.aUY()));
        }
        String aUZ = cVar.aUZ();
        if (TextUtils.isEmpty(aUZ)) {
            aUZ = mb(cVar.getCategory());
            cVar.xb(aUZ);
        }
        if (TextUtils.isEmpty(aUZ)) {
            aUZ = "0";
        }
        hashMap.put("framework_ver", aUZ);
        String aVa = cVar.aVa();
        if (TextUtils.isEmpty(aVa)) {
            aVa = mc(cVar.getCategory());
            cVar.xc(aVa);
        }
        if (TextUtils.isEmpty(aVa)) {
            aVa = "0";
        }
        hashMap.put("extension_ver", aVa);
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.aVg(), "-1")) {
            hashMap.put("scene", cVar.aVg());
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
        hashMap.put("pkg_ver", String.valueOf(fVar.aVf()));
        hashMap.put("expect_pkg_ver", String.valueOf(fVar.aVf()));
        hashMap.put("sub_id", fVar.aVd());
        if (TextUtils.isEmpty(fVar.aUZ())) {
            fVar.xf(mb(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.aUZ())) {
            hashMap.put("framework_ver", fVar.aUZ());
        }
        if (TextUtils.isEmpty(fVar.aVa())) {
            fVar.xg(mc(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.aVa())) {
            hashMap.put("extension_ver", fVar.aVa());
        }
        if (fVar.aUY() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(fVar.aUY()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.aVb());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.aVc())) {
            dVar.xe(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.aVc());
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
        if (!TextUtils.equals(bVar.aVg(), "-1")) {
            hashMap.put("scene", bVar.aVg());
            return hashMap;
        }
        return hashMap;
    }

    public static JSONObject b(com.baidu.swan.pms.c.d.b bVar) {
        if (bVar == null || bVar.aUV() == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("swan_core_ver", mb(0));
            jSONObject2.put("swan_game_ver", mb(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", mc(0));
            jSONObject3.put("game_ext_ver", mc(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.aUV()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.aUW());
                jSONObject4.put("app_sign", aVar.aUX());
                if (aVar instanceof e.b) {
                    e.b bVar2 = (e.b) aVar;
                    String[] aOd = bVar2.aOd();
                    if (aOd != null && aOd.length > 0) {
                        jSONObject4.put("path", new JSONArray((Collection) Arrays.asList(aOd)));
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    List<e.a> aVe = bVar2.aVe();
                    if (aVe != null && !aVe.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (e.a aVar2 : aVe) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("id", aVar2.aVd());
                            jSONObject6.put("type", aVar2.getType());
                            jSONArray2.put(jSONObject6);
                        }
                        jSONObject5.put("list", jSONArray2);
                        jSONObject5.put("ver", aVe.get(0).getVersion());
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

    private static String mb(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aTZ().aqJ();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aTZ().aqH();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private static String mc(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aTZ().aqK();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aTZ().aqI();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }
}
