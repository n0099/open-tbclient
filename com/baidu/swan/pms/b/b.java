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
        hashMap.put("category", String.valueOf(bVar.Bx()));
        if (bVar.WK() == -1) {
            pMSAppInfo = com.baidu.swan.pms.database.a.We().kp(bVar.getBundleId());
            if (pMSAppInfo != null) {
                bVar.fL(pMSAppInfo.versionCode);
            } else {
                bVar.fL(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(bVar.WK()));
        if (bVar.WL() == -1) {
            if (pMSAppInfo == null) {
                pMSAppInfo = com.baidu.swan.pms.database.a.We().kp(bVar.getBundleId());
            }
            if (pMSAppInfo != null) {
                bVar.ah(pMSAppInfo.bsG);
            } else {
                bVar.ah(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(bVar.WL()));
        if (TextUtils.isEmpty(bVar.WM())) {
            bVar.kw(fI(bVar.Bx()));
        }
        if (!TextUtils.isEmpty(bVar.WM())) {
            hashMap.put("framework_ver", bVar.WM());
        }
        if (TextUtils.isEmpty(bVar.WN())) {
            bVar.kx(fJ(bVar.Bx()));
        }
        if (!TextUtils.isEmpty(bVar.WN())) {
            hashMap.put("extension_ver", bVar.WN());
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
        hashMap.put("category", String.valueOf(dVar.Bx()));
        hashMap.put("pkg_ver", String.valueOf(dVar.WK()));
        hashMap.put("sub_id", dVar.WQ());
        if (TextUtils.isEmpty(dVar.WM())) {
            dVar.kA(fI(dVar.Bx()));
        }
        if (!TextUtils.isEmpty(dVar.WM())) {
            hashMap.put("framework_ver", dVar.WM());
        }
        if (TextUtils.isEmpty(dVar.WN())) {
            dVar.kB(fJ(dVar.Bx()));
        }
        if (!TextUtils.isEmpty(dVar.WN())) {
            hashMap.put("extension_ver", dVar.WN());
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.b.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", cVar.WO());
        hashMap.put("category", String.valueOf(cVar.Bx()));
        if (TextUtils.isEmpty(cVar.WP())) {
            cVar.kz(String.valueOf(-1));
        }
        hashMap.put("plugin_ver", cVar.WP());
        return hashMap;
    }

    public static HashMap<String, String> a(f fVar) {
        if (fVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("category", String.valueOf(fVar.Bx()));
        if (TextUtils.isEmpty(fVar.WM())) {
            fVar.kD(fI(fVar.Bx()));
        }
        if (!TextUtils.isEmpty(fVar.WM())) {
            hashMap.put("framework_ver", fVar.WM());
        }
        if (TextUtils.isEmpty(fVar.WN())) {
            fVar.kE(fJ(fVar.Bx()));
        }
        if (!TextUtils.isEmpty(fVar.WN())) {
            hashMap.put("extension_ver", fVar.WN());
            return hashMap;
        }
        return hashMap;
    }

    private static String fI(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.VZ().EZ();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.VZ().EX();
        }
        return null;
    }

    private static String fJ(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.VZ().Fa();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.VZ().EY();
        }
        return null;
    }
}
