package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.swan.pms.c.d.b;
import com.baidu.swan.pms.model.PMSAppInfo;
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
        if (cVar.aHU() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.aHb().tn(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.aHb().c(com.baidu.swan.pms.model.f.class, cVar.getBundleId()) != null) {
                cVar.ju(pMSAppInfo.versionCode);
            } else {
                cVar.ju(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.aHU()));
        if (cVar.aHV() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.aHb().tn(cVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                cVar.bO(pMSAppInfo.appSign);
            } else {
                cVar.bO(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.aHV()));
        if (cVar.aHW() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.aHW()));
        }
        String aHX = cVar.aHX();
        if (TextUtils.isEmpty(aHX)) {
            aHX = jp(cVar.getCategory());
            cVar.tv(aHX);
        }
        if (TextUtils.isEmpty(aHX)) {
            aHX = "0";
        }
        hashMap.put("framework_ver", aHX);
        String aHY = cVar.aHY();
        if (TextUtils.isEmpty(aHY)) {
            aHY = jq(cVar.getCategory());
            cVar.tw(aHY);
        }
        if (TextUtils.isEmpty(aHY)) {
            aHY = "0";
        }
        hashMap.put("extension_ver", aHY);
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.aIc(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, cVar.aIc());
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
        hashMap.put("pkg_ver", String.valueOf(eVar.aHU()));
        hashMap.put("expect_pkg_ver", String.valueOf(eVar.aHU()));
        hashMap.put("sub_id", eVar.aIb());
        if (TextUtils.isEmpty(eVar.aHX())) {
            eVar.tz(jp(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.aHX())) {
            hashMap.put("framework_ver", eVar.aHX());
        }
        if (TextUtils.isEmpty(eVar.aHY())) {
            eVar.tA(jq(eVar.getCategory()));
        }
        if (!TextUtils.isEmpty(eVar.aHY())) {
            hashMap.put("extension_ver", eVar.aHY());
        }
        if (eVar.aHW() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(eVar.aHW()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.aHZ());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.aIa())) {
            dVar.ty(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.aIa());
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
        if (!TextUtils.equals(bVar.aIc(), "-1")) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, bVar.aIc());
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
            jSONObject2.put("swan_core_ver", jp(0));
            jSONObject2.put("swan_game_ver", jp(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", jq(0));
            jSONObject3.put("game_ext_ver", jq(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.aHT()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.aHU());
                jSONObject4.put("app_sign", aVar.aHV());
                jSONArray.put(jSONObject4);
            }
            jSONObject.put("list", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String jp(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aGV().ahe();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aGV().ahc();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private static String jq(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.aGV().ahf();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.aGV().ahd();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }
}
