package com.baidu.swan.games.subpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {
    private static c bfl;
    private HashMap<String, a> bfm = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void Ph();

        void cG(int i);

        void d(int i, long j, long j2);
    }

    private c() {
    }

    public static c Pg() {
        if (bfl == null) {
            synchronized (c.class) {
                if (bfl == null) {
                    bfl = new c();
                }
            }
        }
        return bfl;
    }

    public void a(String str, a aVar) {
        com.baidu.swan.apps.ae.b IX;
        if (aVar != null && !TextUtils.isEmpty(str) && (IX = com.baidu.swan.apps.ae.b.IX()) != null) {
            if (com.baidu.swan.games.subpackage.a.Pf().gg(str)) {
                aVar.Ph();
                return;
            }
            String gi = com.baidu.swan.games.subpackage.a.Pf().gi(str);
            if (TextUtils.isEmpty(gi)) {
                aVar.cG(2112);
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a BR = IX.BR();
            if (BR != null) {
                SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = new SwanGameSubPackageAPSInfo();
                String a2 = a(aVar);
                swanGameSubPackageAPSInfo.appId = IX.id;
                swanGameSubPackageAPSInfo.appVersion = IX.getVersion();
                swanGameSubPackageAPSInfo.key = gi;
                swanGameSubPackageAPSInfo.bfs = e.Ec().DL();
                swanGameSubPackageAPSInfo.bft = com.baidu.swan.games.subpackage.a.Pf().L(str, 1);
                swanGameSubPackageAPSInfo.bfv = a2;
                swanGameSubPackageAPSInfo.bfw = com.baidu.swan.games.subpackage.a.Pf().L(str, 2);
                BR.a(11, swanGameSubPackageAPSInfo);
                this.bfm.put(a2, aVar);
                return;
            }
            aVar.cG(2113);
        }
    }

    public void v(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.bfm.get(swanGameSubPackageAPSInfo.bfv)) != null) {
                com.baidu.swan.games.subpackage.a.Pf().D(swanGameSubPackageAPSInfo.bft, true);
                aVar.Ph();
                this.bfm.remove(swanGameSubPackageAPSInfo.bfv);
            }
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.bfm.get(swanGameSubPackageAPSInfo.bfv)) != null) {
                aVar.cG(swanGameSubPackageAPSInfo.resultCode);
                this.bfm.remove(swanGameSubPackageAPSInfo.bfv);
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
            if (!TextUtils.isEmpty(string) && (aVar = this.bfm.get(string)) != null) {
                if (j2 == -1 && j != 0) {
                    aVar.d(0, j, j2);
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    aVar.cG(0);
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
