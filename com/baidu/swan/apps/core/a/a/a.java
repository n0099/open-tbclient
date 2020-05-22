package com.baidu.swan.apps.core.a.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.d;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.pms.c;
import com.baidu.swan.pms.c.d.b;
import java.util.List;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0331a {
        void Xy();

        void Xz();

        void eE(int i);
    }

    public static void a(@NonNull List<b.a> list, @NonNull String str, @NonNull com.baidu.swan.apps.core.pms.a aVar) {
        if (!jc(h.arO().getString("predownload_network_switch", "1"))) {
            aVar.eT(6);
            return;
        }
        List<b.a> f = com.baidu.swan.apps.core.pms.d.a.f(list);
        if (f.isEmpty()) {
            aVar.ZL();
            return;
        }
        com.baidu.swan.pms.c.d.b bVar = new com.baidu.swan.pms.c.d.b(f);
        bVar.tt("1");
        bVar.tu(str);
        c.a(bVar, new d(aVar));
    }

    public static void a(String str, final int i, InterfaceC0331a interfaceC0331a, final String str2, String str3) {
        if (DEBUG) {
            Log.d("SwanPreDownload", "AppId: " + str + ", scene: " + str2);
        }
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0331a != null) {
                interfaceC0331a.Xy();
            }
        } else if (!jc(h.arO().getString("predownload_network_switch", "1"))) {
            if (interfaceC0331a != null) {
                interfaceC0331a.eE(6);
            }
        } else if (!com.baidu.swan.apps.core.pms.d.a.jx(str)) {
            if (interfaceC0331a != null) {
                interfaceC0331a.eE(2);
            }
        } else {
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(str, TextUtils.equals("swangame", str3) ? 1 : 0);
            cVar.tt("1");
            cVar.tu(str2);
            c.a(cVar, new com.baidu.swan.apps.core.pms.d.b(str, interfaceC0331a) { // from class: com.baidu.swan.apps.core.a.a.a.1
                @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
                public void Xw() {
                    this.bXJ = str2;
                }

                @Override // com.baidu.swan.apps.core.pms.f
                protected int Xx() {
                    return i;
                }

                @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
                public void aU(String str4, String str5) {
                    super.aU(str4, str5);
                    if (!TextUtils.isEmpty(str5) && TextUtils.equals(str4, "770") && this.bXI != null) {
                        this.bXI.add(new UbcFlowEvent(str5));
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
    public static boolean jc(String str) {
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
