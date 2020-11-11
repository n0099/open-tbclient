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
        if (cVar.bbY() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.bbh().ym(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.bbh().c(com.baidu.swan.pms.model.f.class, cVar.getBundleId()) != null) {
                cVar.cS(pMSAppInfo.versionCode);
            } else {
                cVar.cS(0L);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.bbY()));
        if (cVar.bbZ() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.bbh().ym(cVar.getBundleId());
            }
            if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                cVar.cT(pMSAppInfo.appSign);
            } else {
                cVar.cT(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.bbZ()));
        if (cVar.bca() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.bca()));
        }
        String bcb = cVar.bcb();
        if (TextUtils.isEmpty(bcb)) {
            bcb = mT(cVar.getCategory());
            cVar.yu(bcb);
        }
        if (TextUtils.isEmpty(bcb)) {
            bcb = "0";
        }
        hashMap.put("framework_ver", bcb);
        String bcc = cVar.bcc();
        if (TextUtils.isEmpty(bcc)) {
            bcc = mU(cVar.getCategory());
            cVar.yv(bcc);
        }
        if (TextUtils.isEmpty(bcc)) {
            bcc = "0";
        }
        hashMap.put("extension_ver", bcc);
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.bci(), "-1")) {
            hashMap.put("scene", cVar.bci());
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
        hashMap.put("pkg_ver", String.valueOf(fVar.bch()));
        hashMap.put("expect_pkg_ver", String.valueOf(fVar.bch()));
        hashMap.put("sub_id", fVar.bcf());
        if (TextUtils.isEmpty(fVar.bcb())) {
            fVar.yy(mT(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.bcb())) {
            hashMap.put("framework_ver", fVar.bcb());
        }
        if (TextUtils.isEmpty(fVar.bcc())) {
            fVar.yz(mU(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.bcc())) {
            hashMap.put("extension_ver", fVar.bcc());
        }
        if (fVar.bca() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(fVar.bca()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.bcd());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.bce())) {
            dVar.yx(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.bce());
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
        if (!TextUtils.equals(bVar.bci(), "-1")) {
            hashMap.put("scene", bVar.bci());
            return hashMap;
        }
        return hashMap;
    }

    public static JSONObject b(com.baidu.swan.pms.c.d.b bVar) {
        if (bVar == null || bVar.bbX() == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("swan_core_ver", mT(0));
            jSONObject2.put("swan_game_ver", mT(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", mU(0));
            jSONObject3.put("game_ext_ver", mU(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.bbX()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.bbY());
                jSONObject4.put("app_sign", aVar.bbZ());
                if (aVar instanceof e.b) {
                    e.b bVar2 = (e.b) aVar;
                    String[] aVg = bVar2.aVg();
                    if (aVg != null && aVg.length > 0) {
                        jSONObject4.put("path", new JSONArray((Collection) Arrays.asList(aVg)));
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    List<e.a> bcg = bVar2.bcg();
                    if (bcg != null && !bcg.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (e.a aVar2 : bcg) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("id", aVar2.bcf());
                            jSONObject6.put("type", aVar2.getType());
                            jSONArray2.put(jSONObject6);
                        }
                        jSONObject5.put("list", jSONArray2);
                        jSONObject5.put("ver", bcg.get(0).getVersion());
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

    private static String mT(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.bbb().axP();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.bbb().axN();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private static String mU(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.bbb().axQ();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.bbb().axO();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }
}
