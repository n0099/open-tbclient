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
        hashMap.put("category", String.valueOf(bVar.BB()));
        if (bVar.WO() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.Wi().kr(bVar.getBundleId());
            if (pMSAppInfo != null) {
                bVar.fM(pMSAppInfo.versionCode);
            } else {
                bVar.fM(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(bVar.WO()));
        if (bVar.WP() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.Wi().kr(bVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                bVar.ah(pMSAppInfo.bte);
            } else {
                bVar.ah(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(bVar.WP()));
        if (TextUtils.isEmpty(bVar.WQ())) {
            bVar.ky(fJ(bVar.BB()));
        }
        if (!TextUtils.isEmpty(bVar.WQ())) {
            hashMap.put("framework_ver", bVar.WQ());
        }
        if (TextUtils.isEmpty(bVar.WR())) {
            bVar.kz(fK(bVar.BB()));
        }
        if (!TextUtils.isEmpty(bVar.WR())) {
            hashMap.put("extension_ver", bVar.WR());
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
        hashMap.put("category", String.valueOf(dVar.BB()));
        hashMap.put("pkg_ver", String.valueOf(dVar.WO()));
        hashMap.put("sub_id", dVar.WU());
        if (TextUtils.isEmpty(dVar.WQ())) {
            dVar.kC(fJ(dVar.BB()));
        }
        if (!TextUtils.isEmpty(dVar.WQ())) {
            hashMap.put("framework_ver", dVar.WQ());
        }
        if (TextUtils.isEmpty(dVar.WR())) {
            dVar.kD(fK(dVar.BB()));
        }
        if (!TextUtils.isEmpty(dVar.WR())) {
            hashMap.put("extension_ver", dVar.WR());
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.b.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.WS());
        hashMap.put("category", String.valueOf(cVar.BB()));
        if (TextUtils.isEmpty(cVar.WT())) {
            cVar.kB(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", cVar.WT());
        return hashMap;
    }

    public static HashMap<String, String> a(f fVar) {
        if (fVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("category", String.valueOf(fVar.BB()));
        if (TextUtils.isEmpty(fVar.WQ())) {
            fVar.kF(fJ(fVar.BB()));
        }
        if (!TextUtils.isEmpty(fVar.WQ())) {
            hashMap.put("framework_ver", fVar.WQ());
        }
        if (TextUtils.isEmpty(fVar.WR())) {
            fVar.kG(fK(fVar.BB()));
        }
        if (!TextUtils.isEmpty(fVar.WR())) {
            hashMap.put("extension_ver", fVar.WR());
            return hashMap;
        }
        return hashMap;
    }

    private static String fJ(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.Wd().Fd();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.Wd().Fb();
        }
        return null;
    }

    private static String fK(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.Wd().Fe();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.Wd().Fc();
        }
        return null;
    }
}
