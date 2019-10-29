package com.baidu.swan.games.subpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {
    private static c bEA;
    private HashMap<String, a> bEB = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void Ym();

        void d(int i, long j, long j2);

        void dF(int i);
    }

    private c() {
    }

    public static c Yl() {
        if (bEA == null) {
            synchronized (c.class) {
                if (bEA == null) {
                    bEA = new c();
                }
            }
        }
        return bEA;
    }

    public void a(String str, a aVar) {
        com.baidu.swan.apps.ae.b QZ;
        if (aVar != null && !TextUtils.isEmpty(str) && (QZ = com.baidu.swan.apps.ae.b.QZ()) != null) {
            if (com.baidu.swan.games.subpackage.a.Yk().kF(str)) {
                aVar.Ym();
                return;
            }
            String hq = com.baidu.swan.games.subpackage.a.Yk().hq(str);
            if (TextUtils.isEmpty(hq)) {
                aVar.dF(2112);
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a Iy = QZ.Iy();
            if (Iy != null) {
                SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = new SwanGameSubPackageAPSInfo();
                String a2 = a(aVar);
                swanGameSubPackageAPSInfo.appId = QZ.id;
                swanGameSubPackageAPSInfo.awa = QZ.getVersion();
                swanGameSubPackageAPSInfo.key = hq;
                swanGameSubPackageAPSInfo.bEH = e.LD().Lm();
                swanGameSubPackageAPSInfo.bEI = com.baidu.swan.games.subpackage.a.Yk().G(str, 1);
                swanGameSubPackageAPSInfo.callbackKey = a2;
                swanGameSubPackageAPSInfo.bEK = com.baidu.swan.games.subpackage.a.Yk().G(str, 2);
                Iy.a(11, swanGameSubPackageAPSInfo);
                this.bEB.put(a2, aVar);
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
            if (swanGameSubPackageAPSInfo != null && (aVar = this.bEB.get(swanGameSubPackageAPSInfo.callbackKey)) != null) {
                com.baidu.swan.games.subpackage.a.Yk().w(swanGameSubPackageAPSInfo.bEI, true);
                aVar.Ym();
                this.bEB.remove(swanGameSubPackageAPSInfo.callbackKey);
            }
        }
    }

    public void x(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.bEB.get(swanGameSubPackageAPSInfo.callbackKey)) != null) {
                aVar.dF(swanGameSubPackageAPSInfo.resultCode);
                this.bEB.remove(swanGameSubPackageAPSInfo.callbackKey);
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
            if (!TextUtils.isEmpty(string) && (aVar = this.bEB.get(string)) != null) {
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
