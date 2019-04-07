package com.baidu.swan.pms.b;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.pms.b.d.a aVar) {
        com.baidu.swan.pms.model.a aVar2 = null;
        if (aVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", aVar.getBundleId());
        hashMap.put("category", String.valueOf(aVar.Si()));
        if (aVar.Sd() == -1) {
            aVar2 = com.baidu.swan.pms.database.a.Ry().jj(aVar.getBundleId());
            if (aVar2 != null) {
                aVar.fh(aVar2.versionCode);
            } else {
                aVar.fh(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(aVar.Sd()));
        if (aVar.Se() == -1) {
            if (aVar2 == null) {
                aVar2 = com.baidu.swan.pms.database.a.Ry().jj(aVar.getBundleId());
            }
            if (aVar2 != null) {
                aVar.U(aVar2.blP);
            } else {
                aVar.U(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(aVar.Se()));
        if (TextUtils.isEmpty(aVar.Sf())) {
            aVar.jr(fe(aVar.Si()));
        }
        if (!TextUtils.isEmpty(aVar.Sf())) {
            hashMap.put("framework_ver", aVar.Sf());
        }
        if (TextUtils.isEmpty(aVar.Sg())) {
            aVar.jq(com.baidu.swan.pms.e.Ru().Di());
        }
        hashMap.put("sdk_ver", aVar.Sg());
        if (TextUtils.isEmpty(aVar.Sh())) {
            aVar.js(ff(aVar.Si()));
        }
        if (!TextUtils.isEmpty(aVar.Sh())) {
            hashMap.put("extension_ver", aVar.Sh());
        }
        if (!TextUtils.isEmpty(aVar.getPath())) {
            hashMap.put("path", aVar.getPath());
        }
        if (!TextUtils.equals(aVar.getFrom(), LivenessStat.TYPE_STRING_DEFAULT)) {
            hashMap.put("from", aVar.getFrom());
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.b.d.b bVar) {
        if (bVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bundle_id", bVar.getBundleId());
        hashMap.put("category", String.valueOf(bVar.Si()));
        hashMap.put("pkg_ver", String.valueOf(bVar.Sd()));
        hashMap.put("sub_id", bVar.Sj());
        if (TextUtils.isEmpty(bVar.Sg())) {
            bVar.jx(com.baidu.swan.pms.e.Ru().Di());
        }
        hashMap.put("sdk_ver", bVar.Sg());
        if (TextUtils.isEmpty(bVar.Sf())) {
            bVar.jw(fe(bVar.Si()));
        }
        if (!TextUtils.isEmpty(bVar.Sf())) {
            hashMap.put("framework_ver", bVar.Sf());
        }
        if (TextUtils.isEmpty(bVar.Sh())) {
            bVar.jy(ff(bVar.Si()));
        }
        if (!TextUtils.isEmpty(bVar.Sh())) {
            hashMap.put("extension_ver", bVar.Sh());
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.b.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(dVar.Sg())) {
            dVar.jz(com.baidu.swan.pms.e.Ru().Di());
        }
        hashMap.put("sdk_ver", dVar.Sg());
        hashMap.put("category", String.valueOf(dVar.Si()));
        if (TextUtils.isEmpty(dVar.Sf())) {
            dVar.jA(fe(dVar.Si()));
        }
        if (!TextUtils.isEmpty(dVar.Sf())) {
            hashMap.put("framework_ver", dVar.Sf());
        }
        if (TextUtils.isEmpty(dVar.Sh())) {
            dVar.jB(ff(dVar.Si()));
        }
        if (!TextUtils.isEmpty(dVar.Sh())) {
            hashMap.put("extension_ver", dVar.Sh());
            return hashMap;
        }
        return hashMap;
    }

    private static String fe(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.Ru().Dl();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.Ru().Dj();
        }
        return null;
    }

    private static String ff(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.Ru().Dm();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.Ru().Dk();
        }
        return null;
    }
}
