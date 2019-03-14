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
        hashMap.put("category", String.valueOf(aVar.Sk()));
        if (aVar.Sf() == -1) {
            aVar2 = com.baidu.swan.pms.database.a.RA().ji(aVar.getBundleId());
            if (aVar2 != null) {
                aVar.fi(aVar2.versionCode);
            } else {
                aVar.fi(0);
            }
        }
        hashMap.put("pkg_ver", String.valueOf(aVar.Sf()));
        if (aVar.Sg() == -1) {
            if (aVar2 == null) {
                aVar2 = com.baidu.swan.pms.database.a.RA().ji(aVar.getBundleId());
            }
            if (aVar2 != null) {
                aVar.U(aVar2.blM);
            } else {
                aVar.U(0L);
            }
        }
        hashMap.put("app_sign", String.valueOf(aVar.Sg()));
        if (TextUtils.isEmpty(aVar.Sh())) {
            aVar.jq(ff(aVar.Sk()));
        }
        if (!TextUtils.isEmpty(aVar.Sh())) {
            hashMap.put("framework_ver", aVar.Sh());
        }
        if (TextUtils.isEmpty(aVar.Si())) {
            aVar.jp(com.baidu.swan.pms.e.Rw().Dk());
        }
        hashMap.put("sdk_ver", aVar.Si());
        if (TextUtils.isEmpty(aVar.Sj())) {
            aVar.jr(fg(aVar.Sk()));
        }
        if (!TextUtils.isEmpty(aVar.Sj())) {
            hashMap.put("extension_ver", aVar.Sj());
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
        hashMap.put("category", String.valueOf(bVar.Sk()));
        hashMap.put("pkg_ver", String.valueOf(bVar.Sf()));
        hashMap.put("sub_id", bVar.Sl());
        if (TextUtils.isEmpty(bVar.Si())) {
            bVar.jw(com.baidu.swan.pms.e.Rw().Dk());
        }
        hashMap.put("sdk_ver", bVar.Si());
        if (TextUtils.isEmpty(bVar.Sh())) {
            bVar.jv(ff(bVar.Sk()));
        }
        if (!TextUtils.isEmpty(bVar.Sh())) {
            hashMap.put("framework_ver", bVar.Sh());
        }
        if (TextUtils.isEmpty(bVar.Sj())) {
            bVar.jx(fg(bVar.Sk()));
        }
        if (!TextUtils.isEmpty(bVar.Sj())) {
            hashMap.put("extension_ver", bVar.Sj());
            return hashMap;
        }
        return hashMap;
    }

    public static HashMap<String, String> a(com.baidu.swan.pms.b.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(dVar.Si())) {
            dVar.jy(com.baidu.swan.pms.e.Rw().Dk());
        }
        hashMap.put("sdk_ver", dVar.Si());
        hashMap.put("category", String.valueOf(dVar.Sk()));
        if (TextUtils.isEmpty(dVar.Sh())) {
            dVar.jz(ff(dVar.Sk()));
        }
        if (!TextUtils.isEmpty(dVar.Sh())) {
            hashMap.put("framework_ver", dVar.Sh());
        }
        if (TextUtils.isEmpty(dVar.Sj())) {
            dVar.jA(fg(dVar.Sk()));
        }
        if (!TextUtils.isEmpty(dVar.Sj())) {
            hashMap.put("extension_ver", dVar.Sj());
            return hashMap;
        }
        return hashMap;
    }

    private static String ff(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.Rw().Dn();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.Rw().Dl();
        }
        return null;
    }

    private static String fg(int i) {
        if (i == 1) {
            return com.baidu.swan.pms.e.Rw().Do();
        }
        if (i == 0) {
            return com.baidu.swan.pms.e.Rw().Dm();
        }
        return null;
    }
}
