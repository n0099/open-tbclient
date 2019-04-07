package com.baidu.swan.games.subpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {
    private static c bfp;
    private HashMap<String, a> bfq = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void Pf();

        void cF(int i);

        void d(int i, long j, long j2);
    }

    private c() {
    }

    public static c Pe() {
        if (bfp == null) {
            synchronized (c.class) {
                if (bfp == null) {
                    bfp = new c();
                }
            }
        }
        return bfp;
    }

    public void a(String str, a aVar) {
        com.baidu.swan.apps.ae.b IV;
        if (aVar != null && !TextUtils.isEmpty(str) && (IV = com.baidu.swan.apps.ae.b.IV()) != null) {
            if (com.baidu.swan.games.subpackage.a.Pd().gh(str)) {
                aVar.Pf();
                return;
            }
            String gj = com.baidu.swan.games.subpackage.a.Pd().gj(str);
            if (TextUtils.isEmpty(gj)) {
                aVar.cF(2112);
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a BP = IV.BP();
            if (BP != null) {
                SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = new SwanGameSubPackageAPSInfo();
                String a2 = a(aVar);
                swanGameSubPackageAPSInfo.appId = IV.id;
                swanGameSubPackageAPSInfo.appVersion = IV.getVersion();
                swanGameSubPackageAPSInfo.key = gj;
                swanGameSubPackageAPSInfo.bfw = e.Ea().DJ();
                swanGameSubPackageAPSInfo.bfx = com.baidu.swan.games.subpackage.a.Pd().L(str, 1);
                swanGameSubPackageAPSInfo.bfz = a2;
                swanGameSubPackageAPSInfo.bfA = com.baidu.swan.games.subpackage.a.Pd().L(str, 2);
                BP.a(11, swanGameSubPackageAPSInfo);
                this.bfq.put(a2, aVar);
                return;
            }
            aVar.cF(2113);
        }
    }

    public void v(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.bfq.get(swanGameSubPackageAPSInfo.bfz)) != null) {
                com.baidu.swan.games.subpackage.a.Pd().D(swanGameSubPackageAPSInfo.bfx, true);
                aVar.Pf();
                this.bfq.remove(swanGameSubPackageAPSInfo.bfz);
            }
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.bfq.get(swanGameSubPackageAPSInfo.bfz)) != null) {
                aVar.cF(swanGameSubPackageAPSInfo.resultCode);
                this.bfq.remove(swanGameSubPackageAPSInfo.bfz);
            }
        }
    }

    public void y(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            long j = bundle.getLong("aigames_sub_package_bytes_read_key");
            long j2 = bundle.getLong("aigames_sub_package_content_length_key");
            String string = bundle.getString("aigames_sub_package_callback_key");
            if (!TextUtils.isEmpty(string) && (aVar = this.bfq.get(string)) != null) {
                if (j2 == -1 && j != 0) {
                    aVar.d(0, j, j2);
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    aVar.cF(0);
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
