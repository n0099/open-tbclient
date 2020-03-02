package com.baidu.swan.apps.core.a.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.pms.c.d.c;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0243a {
        void Nd();

        void Ne();

        void eq(int i);
    }

    public static void a(String str, final int i, InterfaceC0243a interfaceC0243a, final String str2, String str3) {
        if (DEBUG) {
            Log.d("SwanPreDownload", "AppId: " + str + ", scene: " + str2);
        }
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0243a != null) {
                interfaceC0243a.Nd();
            }
        } else if (!gO(h.afr().getString("predownload_network_switch", "1"))) {
            if (interfaceC0243a != null) {
                interfaceC0243a.eq(6);
            }
        } else {
            c cVar = new c(str, TextUtils.equals("swangame", str3) ? 1 : 0);
            cVar.qC("1");
            cVar.qD(str2);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.b.a(str, interfaceC0243a) { // from class: com.baidu.swan.apps.core.a.a.a.1
                @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
                public void Nb() {
                    this.bqe = str2;
                }

                @Override // com.baidu.swan.apps.core.pms.f
                protected int Nc() {
                    return i;
                }

                @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
                public void aw(String str4, String str5) {
                    super.aw(str4, str5);
                    if (!TextUtils.isEmpty(str5) && TextUtils.equals(str4, "770") && this.bqd != null) {
                        this.bqd.add(new UbcFlowEvent(str5));
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
    public static boolean gO(String str) {
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
