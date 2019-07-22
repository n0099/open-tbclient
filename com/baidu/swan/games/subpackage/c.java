package com.baidu.swan.games.subpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {
    private static c blo;
    private HashMap<String, a> blp = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void Tr();

        void cJ(int i);

        void d(int i, long j, long j2);
    }

    private c() {
    }

    public static c Tq() {
        if (blo == null) {
            synchronized (c.class) {
                if (blo == null) {
                    blo = new c();
                }
            }
        }
        return blo;
    }

    public void a(String str, a aVar) {
        com.baidu.swan.apps.ae.b Md;
        if (aVar != null && !TextUtils.isEmpty(str) && (Md = com.baidu.swan.apps.ae.b.Md()) != null) {
            if (com.baidu.swan.games.subpackage.a.Tp().kb(str)) {
                aVar.Tr();
                return;
            }
            String gK = com.baidu.swan.games.subpackage.a.Tp().gK(str);
            if (TextUtils.isEmpty(gK)) {
                aVar.cJ(2112);
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a DA = Md.DA();
            if (DA != null) {
                SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = new SwanGameSubPackageAPSInfo();
                String a2 = a(aVar);
                swanGameSubPackageAPSInfo.appId = Md.id;
                swanGameSubPackageAPSInfo.appVersion = Md.getVersion();
                swanGameSubPackageAPSInfo.key = gK;
                swanGameSubPackageAPSInfo.blv = e.GF().Go();
                swanGameSubPackageAPSInfo.blw = com.baidu.swan.games.subpackage.a.Tp().G(str, 1);
                swanGameSubPackageAPSInfo.bly = a2;
                swanGameSubPackageAPSInfo.blz = com.baidu.swan.games.subpackage.a.Tp().G(str, 2);
                DA.a(11, swanGameSubPackageAPSInfo);
                this.blp.put(a2, aVar);
                return;
            }
            aVar.cJ(2113);
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.blp.get(swanGameSubPackageAPSInfo.bly)) != null) {
                com.baidu.swan.games.subpackage.a.Tp().t(swanGameSubPackageAPSInfo.blw, true);
                aVar.Tr();
                this.blp.remove(swanGameSubPackageAPSInfo.bly);
            }
        }
    }

    public void x(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.blp.get(swanGameSubPackageAPSInfo.bly)) != null) {
                aVar.cJ(swanGameSubPackageAPSInfo.resultCode);
                this.blp.remove(swanGameSubPackageAPSInfo.bly);
            }
        }
    }

    public void z(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            long j = bundle.getLong("aigames_sub_package_bytes_read_key");
            long j2 = bundle.getLong("aigames_sub_package_content_length_key");
            String string = bundle.getString("aigames_sub_package_callback_key");
            if (!TextUtils.isEmpty(string) && (aVar = this.blp.get(string)) != null) {
                if (j2 == -1 && j != 0) {
                    aVar.d(0, j, j2);
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    aVar.cJ(2114);
                } else {
                    int floor = (int) Math.floor((100 * j) / j2);
                    if (floor != 100) {
                        aVar.d(floor, j, j2);
                    }
                }
            }
        }
    }

    private String a(a aVar) {
        return aVar != null ? aVar.toString() : "";
    }
}
