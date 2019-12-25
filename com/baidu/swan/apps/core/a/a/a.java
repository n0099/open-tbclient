package com.baidu.swan.apps.core.a.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.pms.c.d.c;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0231a {
        void Kq();

        void Kr();

        void dZ(int i);
    }

    public static void a(String str, final int i, InterfaceC0231a interfaceC0231a, final String str2, String str3) {
        if (DEBUG) {
            Log.d("SwanPreDownload", "AppId: " + str + ", scene: " + str2);
        }
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0231a != null) {
                interfaceC0231a.Kq();
            }
        } else if (!gw(h.acE().getString("predownload_network_switch", "1"))) {
            if (interfaceC0231a != null) {
                interfaceC0231a.dZ(6);
            }
        } else {
            c cVar = new c(str, TextUtils.equals("swangame", str3) ? 1 : 0);
            cVar.qk("1");
            cVar.ql(str2);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.b.a(str, interfaceC0231a) { // from class: com.baidu.swan.apps.core.a.a.a.1
                @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
                public void Ko() {
                    this.ble = str2;
                }

                @Override // com.baidu.swan.apps.core.pms.f
                protected int Kp() {
                    return i;
                }

                @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
                public void al(String str4, String str5) {
                    super.al(str4, str5);
                    if (!TextUtils.isEmpty(str5) && TextUtils.equals(str4, "770") && this.bld != null) {
                        this.bld.add(new UbcFlowEvent(str5));
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (com.baidu.swan.apps.network.SwanAppNetworkUtils.isWifiNetworkConnected(com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()) != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean gw(String str) {
        boolean z = true;
        if (!TextUtils.equals(str, "0")) {
            if (!TextUtils.equals(str, "1")) {
                if (TextUtils.equals(str, "2")) {
                    z = false;
                }
                z = false;
            }
        }
        if (DEBUG) {
            Log.d("SwanPreDownload", "SwanPredownload: current net suits for net config = " + z);
        }
        return z;
    }
}
