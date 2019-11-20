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
        if (bVar.abB() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.aaV().kT(bVar.getBundleId());
            if (pMSAppInfo != null) {
                bVar.gG(pMSAppInfo.versionCode);
            } else {
                bVar.gG(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(bVar.abB()));
        if (bVar.abC() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.aaV().kT(bVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                bVar.az(pMSAppInfo.bKY);
            } else {
                bVar.az(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(bVar.abC()));
        if (TextUtils.isEmpty(bVar.abD())) {
            bVar.la(gD(bVar.getCategory()));
        }
        if (!TextUtils.isEmpty(bVar.abD())) {
            hashMap.put("framework_ver", bVar.abD());
        }
        if (TextUtils.isEmpty(bVar.abE())) {
            bVar.lb(gE(bVar.getCategory()));
        }
        if (!TextUtils.isEmpty(bVar.abE())) {
            hashMap.put("extension_ver", bVar.abE());
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
        hashMap.put("pkg_ver", String.valueOf(dVar.abB()));
        hashMap.put("sub_id", dVar.abH());
        if (TextUtils.isEmpty(dVar.abD())) {
            dVar.le(gD(dVar.getCategory()));
        }
        if (!TextUtils.isEmpty(dVar.abD())) {
            hashMap.put("framework_ver", dVar.abD());
        }
        if (TextUtils.isEmpty(dVar.abE())) {
            dVar.lf(gE(dVar.getCategory()));
        }
        if (!TextUtils.isEmpty(dVar.abE())) {
            hashMap.put("extension_ver", dVar.abE());
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.b.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.abF());
        hashMap.put("category", String.valueOf(cVar.getCategory()));
        if (TextUtils.isEmpty(cVar.abG())) {
            cVar.ld(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", cVar.abG());
        return hashMap;
    }

    public static HashMap<String, String> a(f fVar) {
        if (fVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("category", String.valueOf(fVar.getCategory()));
        if (TextUtils.isEmpty(fVar.abD())) {
            fVar.lh(gD(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.abD())) {
            hashMap.put("framework_ver", fVar.abD());
        }
        if (TextUtils.isEmpty(fVar.abE())) {
            fVar.li(gE(fVar.getCategory()));
        }
        if (!TextUtils.isEmpty(fVar.abE())) {
            hashMap.put("extension_ver", fVar.abE());
            return hashMap;
        }
        return hashMap;
    }

    private static String gD(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.aaQ().JY();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.aaQ().JW();
        }
        return null;
    }

    private static String gE(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.aaQ().JZ();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.aaQ().JX();
        }
        return null;
    }
}
