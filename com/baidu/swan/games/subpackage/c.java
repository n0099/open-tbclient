package com.baidu.swan.games.subpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {
    private static c bDJ;
    private HashMap<String, a> bDK = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void Yk();

        void d(int i, long j, long j2);

        void dF(int i);
    }

    private c() {
    }

    public static c Yj() {
        if (bDJ == null) {
            synchronized (c.class) {
                if (bDJ == null) {
                    bDJ = new c();
                }
            }
        }
        return bDJ;
    }

    public void a(String str, a aVar) {
        com.baidu.swan.apps.ae.b Ra;
        if (aVar != null && !TextUtils.isEmpty(str) && (Ra = com.baidu.swan.apps.ae.b.Ra()) != null) {
            if (com.baidu.swan.games.subpackage.a.Yi().kF(str)) {
                aVar.Yk();
                return;
            }
            String hq = com.baidu.swan.games.subpackage.a.Yi().hq(str);
            if (TextUtils.isEmpty(hq)) {
                aVar.dF(2112);
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a Iz = Ra.Iz();
            if (Iz != null) {
                SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = new SwanGameSubPackageAPSInfo();
                String a2 = a(aVar);
                swanGameSubPackageAPSInfo.appId = Ra.id;
                swanGameSubPackageAPSInfo.avI = Ra.getVersion();
                swanGameSubPackageAPSInfo.key = hq;
                swanGameSubPackageAPSInfo.bDQ = e.LE().Ln();
                swanGameSubPackageAPSInfo.bDR = com.baidu.swan.games.subpackage.a.Yi().G(str, 1);
                swanGameSubPackageAPSInfo.callbackKey = a2;
                swanGameSubPackageAPSInfo.bDT = com.baidu.swan.games.subpackage.a.Yi().G(str, 2);
                Iz.a(11, swanGameSubPackageAPSInfo);
                this.bDK.put(a2, aVar);
                return;
            }
            aVar.dF(2113);
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.bDK.get(swanGameSubPackageAPSInfo.callbackKey)) != null) {
                com.baidu.swan.games.subpackage.a.Yi().w(swanGameSubPackageAPSInfo.bDR, true);
                aVar.Yk();
                this.bDK.remove(swanGameSubPackageAPSInfo.callbackKey);
            }
        }
    }

    public void x(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.bDK.get(swanGameSubPackageAPSInfo.callbackKey)) != null) {
                aVar.dF(swanGameSubPackageAPSInfo.resultCode);
                this.bDK.remove(swanGameSubPackageAPSInfo.callbackKey);
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
            if (!TextUtils.isEmpty(string) && (aVar = this.bDK.get(string)) != null) {
                if (j2 == -1 && j != 0) {
                    aVar.d(0, j, j2);
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    aVar.dF(2114);
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
