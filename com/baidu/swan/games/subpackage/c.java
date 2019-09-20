package com.baidu.swan.games.subpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {
    private static c blM;
    private HashMap<String, a> blN = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void Tv();

        void cK(int i);

        void d(int i, long j, long j2);
    }

    private c() {
    }

    public static c Tu() {
        if (blM == null) {
            synchronized (c.class) {
                if (blM == null) {
                    blM = new c();
                }
            }
        }
        return blM;
    }

    public void a(String str, a aVar) {
        com.baidu.swan.apps.ae.b Mh;
        if (aVar != null && !TextUtils.isEmpty(str) && (Mh = com.baidu.swan.apps.ae.b.Mh()) != null) {
            if (com.baidu.swan.games.subpackage.a.Tt().kd(str)) {
                aVar.Tv();
                return;
            }
            String gM = com.baidu.swan.games.subpackage.a.Tt().gM(str);
            if (TextUtils.isEmpty(gM)) {
                aVar.cK(2112);
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a DE = Mh.DE();
            if (DE != null) {
                SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = new SwanGameSubPackageAPSInfo();
                String a2 = a(aVar);
                swanGameSubPackageAPSInfo.appId = Mh.id;
                swanGameSubPackageAPSInfo.appVersion = Mh.getVersion();
                swanGameSubPackageAPSInfo.key = gM;
                swanGameSubPackageAPSInfo.blT = e.GJ().Gs();
                swanGameSubPackageAPSInfo.blU = com.baidu.swan.games.subpackage.a.Tt().G(str, 1);
                swanGameSubPackageAPSInfo.blW = a2;
                swanGameSubPackageAPSInfo.blX = com.baidu.swan.games.subpackage.a.Tt().G(str, 2);
                DE.a(11, swanGameSubPackageAPSInfo);
                this.blN.put(a2, aVar);
                return;
            }
            aVar.cK(2113);
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.blN.get(swanGameSubPackageAPSInfo.blW)) != null) {
                com.baidu.swan.games.subpackage.a.Tt().t(swanGameSubPackageAPSInfo.blU, true);
                aVar.Tv();
                this.blN.remove(swanGameSubPackageAPSInfo.blW);
            }
        }
    }

    public void x(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo = (SwanGameSubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (swanGameSubPackageAPSInfo != null && (aVar = this.blN.get(swanGameSubPackageAPSInfo.blW)) != null) {
                aVar.cK(swanGameSubPackageAPSInfo.resultCode);
                this.blN.remove(swanGameSubPackageAPSInfo.blW);
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
            if (!TextUtils.isEmpty(string) && (aVar = this.blN.get(string)) != null) {
                if (j2 == -1 && j != 0) {
                    aVar.d(0, j, j2);
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    aVar.cK(2114);
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
