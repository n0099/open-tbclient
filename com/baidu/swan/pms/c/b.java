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
/* loaded from: classes6.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.c cVar) {
        PMSAppInfo pMSAppInfo = null;
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.getBundleId());
        hashMap.put("category", String.valueOf(cVar.getCategory()));
        if (cVar.bcY() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.bci().xC(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.bci().d(com.baidu.swan.pms.model.f.class, cVar.getBundleId()) != null) {
                cVar.ds(pMSAppInfo.versionCode);
            } else {
                cVar.ds(0L);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.bcY()));
        if (cVar.bcZ() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.bci().xC(cVar.getBundleId());
            }
            if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                cVar.dt(pMSAppInfo.appSign);
            } else {
                cVar.dt(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.bcZ()));
        if (cVar.bda() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.bda()));
        }
        String bdb = cVar.bdb();
        if (TextUtils.isEmpty(bdb)) {
            bdb = lQ(cVar.getCategory());
            cVar.xK(bdb);
        }
        if (TextUtils.isEmpty(bdb)) {
            bdb = "0";
        }
        hashMap.put("framework_ver", bdb);
        String bdc = cVar.bdc();
        if (TextUtils.isEmpty(bdc)) {
            bdc = lR(cVar.getCategory());
            cVar.xL(bdc);
        }
        if (TextUtils.isEmpty(bdc)) {
            bdc = "0";
        }
        hashMap.put("extension_ver", bdc);
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.bdi(), "-1")) {
            hashMap.put("scene", cVar.bdi());
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
        hashMap.put("pkg_ver", String.valueOf(fVar.bdh()));
        hashMap.put("expect_pkg_ver", String.valueOf(fVar.bdh()));
        hashMap.put("sub_id", fVar.bdf());
        if (TextUtils.isEmpty(fVar.bdb())) {
            fVar.xO(lQ(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.bdb())) {
            hashMap.put("framework_ver", fVar.bdb());
        }
        if (TextUtils.isEmpty(fVar.bdc())) {
            fVar.xP(lR(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.bdc())) {
            hashMap.put("extension_ver", fVar.bdc());
        }
        if (fVar.bda() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(fVar.bda()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.bdd());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.bde())) {
            dVar.xN(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.bde());
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
        if (!TextUtils.equals(bVar.bdi(), "-1")) {
            hashMap.put("scene", bVar.bdi());
            return hashMap;
        }
        return hashMap;
    }

    public static JSONObject b(com.baidu.swan.pms.c.d.b bVar) {
        if (bVar == null || bVar.bcX() == null) {
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
            for (b.a aVar : bVar.bcX()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.bcY());
                jSONObject4.put("app_sign", aVar.bcZ());
                if (aVar instanceof e.b) {
                    e.b bVar2 = (e.b) aVar;
                    String[] aWe = bVar2.aWe();
                    if (aWe != null && aWe.length > 0) {
                        jSONObject4.put("path", new JSONArray((Collection) Arrays.asList(aWe)));
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    List<e.a> bdg = bVar2.bdg();
                    if (bdg != null && !bdg.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (e.a aVar2 : bdg) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("id", aVar2.bdf());
                            jSONObject6.put("type", aVar2.getType());
                            jSONArray2.put(jSONObject6);
                        }
                        jSONObject5.put("list", jSONArray2);
                        jSONObject5.put("ver", bdg.get(0).getVersion());
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
            str = com.baidu.swan.pms.d.bcc().axN();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.bcc().axL();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private static String lR(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.bcc().axO();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.bcc().axM();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }
}
