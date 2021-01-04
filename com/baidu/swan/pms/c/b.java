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
        if (cVar.bgR() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.bgb().yN(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.bgb().d(com.baidu.swan.pms.model.f.class, cVar.getBundleId()) != null) {
                cVar.ds(pMSAppInfo.versionCode);
            } else {
                cVar.ds(0L);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.bgR()));
        if (cVar.bgS() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.bgb().yN(cVar.getBundleId());
            }
            if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                cVar.dt(pMSAppInfo.appSign);
            } else {
                cVar.dt(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.bgS()));
        if (cVar.bgT() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.bgT()));
        }
        String bgU = cVar.bgU();
        if (TextUtils.isEmpty(bgU)) {
            bgU = nw(cVar.getCategory());
            cVar.yV(bgU);
        }
        if (TextUtils.isEmpty(bgU)) {
            bgU = "0";
        }
        hashMap.put("framework_ver", bgU);
        String bgV = cVar.bgV();
        if (TextUtils.isEmpty(bgV)) {
            bgV = nx(cVar.getCategory());
            cVar.yW(bgV);
        }
        if (TextUtils.isEmpty(bgV)) {
            bgV = "0";
        }
        hashMap.put("extension_ver", bgV);
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.bhb(), "-1")) {
            hashMap.put("scene", cVar.bhb());
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
        hashMap.put("pkg_ver", String.valueOf(fVar.bha()));
        hashMap.put("expect_pkg_ver", String.valueOf(fVar.bha()));
        hashMap.put("sub_id", fVar.bgY());
        if (TextUtils.isEmpty(fVar.bgU())) {
            fVar.yZ(nw(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.bgU())) {
            hashMap.put("framework_ver", fVar.bgU());
        }
        if (TextUtils.isEmpty(fVar.bgV())) {
            fVar.za(nx(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.bgV())) {
            hashMap.put("extension_ver", fVar.bgV());
        }
        if (fVar.bgT() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(fVar.bgT()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.bgW());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.bgX())) {
            dVar.yY(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.bgX());
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
        if (!TextUtils.equals(bVar.bhb(), "-1")) {
            hashMap.put("scene", bVar.bhb());
            return hashMap;
        }
        return hashMap;
    }

    public static JSONObject b(com.baidu.swan.pms.c.d.b bVar) {
        if (bVar == null || bVar.bgQ() == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("swan_core_ver", nw(0));
            jSONObject2.put("swan_game_ver", nw(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", nx(0));
            jSONObject3.put("game_ext_ver", nx(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.bgQ()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.bgR());
                jSONObject4.put("app_sign", aVar.bgS());
                if (aVar instanceof e.b) {
                    e.b bVar2 = (e.b) aVar;
                    String[] aZX = bVar2.aZX();
                    if (aZX != null && aZX.length > 0) {
                        jSONObject4.put("path", new JSONArray((Collection) Arrays.asList(aZX)));
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    List<e.a> bgZ = bVar2.bgZ();
                    if (bgZ != null && !bgZ.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (e.a aVar2 : bgZ) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("id", aVar2.bgY());
                            jSONObject6.put("type", aVar2.getType());
                            jSONArray2.put(jSONObject6);
                        }
                        jSONObject5.put("list", jSONArray2);
                        jSONObject5.put("ver", bgZ.get(0).getVersion());
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

    private static String nw(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.bfV().aBG();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.bfV().aBE();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private static String nx(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.bfV().aBH();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.bfV().aBF();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }
}
