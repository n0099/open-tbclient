package com.baidu.swan.games.subpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {
    private static c bkB;
    private HashMap<String, a> bkC = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void Sy();

        void cI(int i);

        void d(int i, long j, long j2);
    }

    private c() {
    }

    public static c Sx() {
        if (bkB == null) {
            synchronized (c.class) {
                if (bkB == null) {
                    bkB = new c();
                }
            }
        }
        return bkB;
    }

    public void a(String str, a aVar) {
        com.baidu.swan.apps.ae.b Lq;
        if (aVar != null && !TextUtils.isEmpty(str) && (Lq = com.baidu.swan.apps.ae.b.Lq()) != null) {
            if (com.baidu.swan.games.subpackage.a.Sw().jT(str)) {
                aVar.Sy();
                return;
            }
            String gD = com.baidu.swan.games.subpackage.a.Sw().gD(str);
            if (TextUtils.isEmpty(gD)) {
                aVar.cI(2112);
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a CR = Lq.CR();
            if (CR != null) {
                SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = new SwanGameSubPackageAPSInfo();
                String a2 = a(aVar);
                swanGameSubPackageAPSInfo.appId = Lq.id;
                swanGameSubPackageAPSInfo.appVersion = Lq.getVersion();
                swanGameSubPackageAPSInfo.key = gD;
                swanGameSubPackageAPSInfo.bkI = e.FV().FE();
                swanGameSubPackageAPSInfo.bkJ = com.baidu.swan.games.subpackage.a.Sw().G(str, 1);
                swanGameSubPackageAPSInfo.bkL = a2;
                swanGameSubPackageAPSInfo.bkM = com.baidu.swan.games.subpackage.a.Sw().G(str, 2);
                CR.a(11, swanGameSubPackageAPSInfo);
                this.bkC.put(a2, aVar);
                return;
            }
            aVar.cI(2113);
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.bkC.get(swanGameSubPackageAPSInfo.bkL)) != null) {
                com.baidu.swan.games.subpackage.a.Sw().s(swanGameSubPackageAPSInfo.bkJ, true);
                aVar.Sy();
                this.bkC.remove(swanGameSubPackageAPSInfo.bkL);
            }
        }
    }

    public void x(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.bkC.get(swanGameSubPackageAPSInfo.bkL)) != null) {
                aVar.cI(swanGameSubPackageAPSInfo.resultCode);
                this.bkC.remove(swanGameSubPackageAPSInfo.bkL);
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
            if (!TextUtils.isEmpty(string) && (aVar = this.bkC.get(string)) != null) {
                if (j2 == -1 && j != 0) {
                    aVar.d(0, j, j2);
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    aVar.cI(2114);
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
