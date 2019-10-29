package com.baidu.swan.pms.b;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.swan.pms.b.d.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.pms.b.d.b bVar) {
        PMSAppInfo pMSAppInfo = null;
        if (bVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", bVar.getBundleId());
        hashMap.put("category", String.valueOf(bVar.getCategory()));
        if (bVar.abD() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.aaX().kT(bVar.getBundleId());
            if (pMSAppInfo != null) {
                bVar.gH(pMSAppInfo.versionCode);
            } else {
                bVar.gH(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(bVar.abD()));
        if (bVar.abE() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.aaX().kT(bVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                bVar.aA(pMSAppInfo.bLP);
            } else {
                bVar.aA(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(bVar.abE()));
        if (TextUtils.isEmpty(bVar.abF())) {
            bVar.la(gE(bVar.getCategory()));
        }
        if (!TextUtils.isEmpty(bVar.abF())) {
            hashMap.put("framework_ver", bVar.abF());
        }
        if (TextUtils.isEmpty(bVar.abG())) {
            bVar.lb(gF(bVar.getCategory()));
        }
        if (!TextUtils.isEmpty(bVar.abG())) {
            hashMap.put("extension_ver", bVar.abG());
        }
        if (!TextUtils.isEmpty(bVar.getPath())) {
            hashMap.put("path", bVar.getPath());
        }
        if (!TextUtils.equals(bVar.getFrom(), LivenessStat.TYPE_STRING_DEFAULT)) {
            hashMap.put("from", bVar.getFrom());
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.b.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", dVar.getBundleId());
        hashMap.put("category", String.valueOf(dVar.getCategory()));
        hashMap.put("pkg_ver", String.valueOf(dVar.abD()));
        hashMap.put("sub_id", dVar.abJ());
        if (TextUtils.isEmpty(dVar.abF())) {
            dVar.le(gE(dVar.getCategory()));
        }
        if (!TextUtils.isEmpty(dVar.abF())) {
            hashMap.put("framework_ver", dVar.abF());
        }
        if (TextUtils.isEmpty(dVar.abG())) {
            dVar.lf(gF(dVar.getCategory()));
        }
        if (!TextUtils.isEmpty(dVar.abG())) {
            hashMap.put("extension_ver", dVar.abG());
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.b.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.abH());
        hashMap.put("category", String.valueOf(cVar.getCategory()));
        if (TextUtils.isEmpty(cVar.abI())) {
            cVar.ld(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", cVar.abI());
        return hashMap;
    }

    public static HashMap<String, String> a(f fVar) {
        if (fVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("category", String.valueOf(fVar.getCategory()));
        if (TextUtils.isEmpty(fVar.abF())) {
            fVar.lh(gE(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.abF())) {
            hashMap.put("framework_ver", fVar.abF());
        }
        if (TextUtils.isEmpty(fVar.abG())) {
            fVar.li(gF(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.abG())) {
            hashMap.put("extension_ver", fVar.abG());
            return hashMap;
        }
        return hashMap;
    }

    private static String gE(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.aaS().JX();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.aaS().JV();
        }
        return null;
    }

    private static String gF(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.aaS().JY();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.aaS().JW();
        }
        return null;
    }
}
