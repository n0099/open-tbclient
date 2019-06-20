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
        hashMap.put("category", String.valueOf(bVar.AP()));
        if (bVar.VR() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.Vl().kh(bVar.getBundleId());
            if (pMSAppInfo != null) {
                bVar.fH(pMSAppInfo.versionCode);
            } else {
                bVar.fH(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(bVar.VR()));
        if (bVar.VS() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.Vl().kh(bVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                bVar.ag(pMSAppInfo.brS);
            } else {
                bVar.ag(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(bVar.VS()));
        if (TextUtils.isEmpty(bVar.VT())) {
            bVar.ko(fE(bVar.AP()));
        }
        if (!TextUtils.isEmpty(bVar.VT())) {
            hashMap.put("framework_ver", bVar.VT());
        }
        if (TextUtils.isEmpty(bVar.VU())) {
            bVar.kp(fF(bVar.AP()));
        }
        if (!TextUtils.isEmpty(bVar.VU())) {
            hashMap.put("extension_ver", bVar.VU());
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
        hashMap.put("category", String.valueOf(dVar.AP()));
        hashMap.put("pkg_ver", String.valueOf(dVar.VR()));
        hashMap.put("sub_id", dVar.VX());
        if (TextUtils.isEmpty(dVar.VT())) {
            dVar.ks(fE(dVar.AP()));
        }
        if (!TextUtils.isEmpty(dVar.VT())) {
            hashMap.put("framework_ver", dVar.VT());
        }
        if (TextUtils.isEmpty(dVar.VU())) {
            dVar.kt(fF(dVar.AP()));
        }
        if (!TextUtils.isEmpty(dVar.VU())) {
            hashMap.put("extension_ver", dVar.VU());
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.b.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.VV());
        hashMap.put("category", String.valueOf(cVar.AP()));
        if (TextUtils.isEmpty(cVar.VW())) {
            cVar.kr(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", cVar.VW());
        return hashMap;
    }

    public static HashMap<String, String> a(f fVar) {
        if (fVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("category", String.valueOf(fVar.AP()));
        if (TextUtils.isEmpty(fVar.VT())) {
            fVar.kv(fE(fVar.AP()));
        }
        if (!TextUtils.isEmpty(fVar.VT())) {
            hashMap.put("framework_ver", fVar.VT());
        }
        if (TextUtils.isEmpty(fVar.VU())) {
            fVar.kw(fF(fVar.AP()));
        }
        if (!TextUtils.isEmpty(fVar.VU())) {
            hashMap.put("extension_ver", fVar.VU());
            return hashMap;
        }
        return hashMap;
    }

    private static String fE(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.Vg().Eq();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.Vg().Eo();
        }
        return null;
    }

    private static String fF(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.Vg().Er();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.Vg().Ep();
        }
        return null;
    }
}
