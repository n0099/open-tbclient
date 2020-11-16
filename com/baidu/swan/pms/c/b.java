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
        if (cVar.bbr() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.baA().yh(cVar.getBundleId());
            if (pMSAppInfo != null && com.baidu.swan.pms.database.a.baA().c(com.baidu.swan.pms.model.f.class, cVar.getBundleId()) != null) {
                cVar.cS(pMSAppInfo.versionCode);
            } else {
                cVar.cS(0L);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(cVar.bbr()));
        if (cVar.bbs() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.baA().yh(cVar.getBundleId());
            }
            if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                cVar.cT(pMSAppInfo.appSign);
            } else {
                cVar.cT(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(cVar.bbs()));
        if (cVar.bbt() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(cVar.bbt()));
        }
        String bbu = cVar.bbu();
        if (TextUtils.isEmpty(bbu)) {
            bbu = mP(cVar.getCategory());
            cVar.yp(bbu);
        }
        if (TextUtils.isEmpty(bbu)) {
            bbu = "0";
        }
        hashMap.put("framework_ver", bbu);
        String bbv = cVar.bbv();
        if (TextUtils.isEmpty(bbv)) {
            bbv = mQ(cVar.getCategory());
            cVar.yq(bbv);
        }
        if (TextUtils.isEmpty(bbv)) {
            bbv = "0";
        }
        hashMap.put("extension_ver", bbv);
        if (!TextUtils.isEmpty(cVar.getPath())) {
            hashMap.put("path", cVar.getPath());
        }
        if (!TextUtils.equals(cVar.getFrom(), "-1")) {
            hashMap.put("from", cVar.getFrom());
        }
        if (!TextUtils.equals(cVar.bbB(), "-1")) {
            hashMap.put("scene", cVar.bbB());
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
        hashMap.put("pkg_ver", String.valueOf(fVar.bbA()));
        hashMap.put("expect_pkg_ver", String.valueOf(fVar.bbA()));
        hashMap.put("sub_id", fVar.bby());
        if (TextUtils.isEmpty(fVar.bbu())) {
            fVar.yt(mP(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.bbu())) {
            hashMap.put("framework_ver", fVar.bbu());
        }
        if (TextUtils.isEmpty(fVar.bbv())) {
            fVar.yu(mQ(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.bbv())) {
            hashMap.put("extension_ver", fVar.bbv());
        }
        if (fVar.bbt() != -1) {
            hashMap.put("expect_pkg_ver", String.valueOf(fVar.bbt()));
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.c.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.bbw());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        if (TextUtils.isEmpty(dVar.bbx())) {
            dVar.ys(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", dVar.bbx());
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
        if (!TextUtils.equals(bVar.bbB(), "-1")) {
            hashMap.put("scene", bVar.bbB());
            return hashMap;
        }
        return hashMap;
    }

    public static JSONObject b(com.baidu.swan.pms.c.d.b bVar) {
        if (bVar == null || bVar.bbq() == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("swan_core_ver", mP(0));
            jSONObject2.put("swan_game_ver", mP(1));
            jSONObject.put("framework", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("swan_ext_ver", mQ(0));
            jSONObject3.put("game_ext_ver", mQ(1));
            jSONObject.put(ETAG.KEY_EXTENSION, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : bVar.bbq()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("bundle_id", aVar.getBundleId());
                if (aVar.getCategory() != -1) {
                    jSONObject4.put("category", aVar.getCategory());
                }
                jSONObject4.put("pkg_ver", aVar.bbr());
                jSONObject4.put("app_sign", aVar.bbs());
                if (aVar instanceof e.b) {
                    e.b bVar2 = (e.b) aVar;
                    String[] aUy = bVar2.aUy();
                    if (aUy != null && aUy.length > 0) {
                        jSONObject4.put("path", new JSONArray((Collection) Arrays.asList(aUy)));
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    List<e.a> bbz = bVar2.bbz();
                    if (bbz != null && !bbz.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (e.a aVar2 : bbz) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("id", aVar2.bby());
                            jSONObject6.put("type", aVar2.getType());
                            jSONArray2.put(jSONObject6);
                        }
                        jSONObject5.put("list", jSONArray2);
                        jSONObject5.put("ver", bbz.get(0).getVersion());
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

    private static String mP(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.bau().axh();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.bau().axf();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private static String mQ(int i) {
        String str = null;
        if (i == 1) {
            str = com.baidu.swan.pms.d.bau().axi();
        } else if (i == 0) {
            str = com.baidu.swan.pms.d.bau().axg();
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }
}
