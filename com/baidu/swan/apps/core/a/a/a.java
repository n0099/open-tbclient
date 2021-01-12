package com.baidu.swan.apps.core.a.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.am;
import com.baidu.swan.apps.core.pms.d;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.pms.c;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.c.d.b;
import com.baidu.swan.pms.c.d.e;
import com.baidu.swan.pms.model.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes8.dex */
public final class a implements b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0403a {
        void anm();

        void ann();

        void gA(int i);
    }

    public static void f(@NonNull List<e.b> list, @Nullable String str) {
        String[] aWe;
        if (!lU(h.aLO().getString("predownload_network_switch", "1"))) {
            if (DEBUG) {
                Log.e("SwanPreDownload", "pre download net invalid");
                return;
            }
            return;
        }
        final HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (e.b bVar : list) {
            if (bVar != null) {
                if (bVar.aWe() == null) {
                    if (com.baidu.swan.apps.core.pms.d.a.my(bVar.getBundleId())) {
                        arrayList.add(bVar);
                        hashMap.put(bVar.getBundleId(), null);
                    }
                } else {
                    Set set = (Set) hashMap.get(bVar.getBundleId());
                    if (set == null) {
                        set = new HashSet();
                    }
                    boolean z = false;
                    for (String str2 : bVar.aWe()) {
                        if (com.baidu.swan.apps.core.pms.d.a.bE(bVar.getBundleId(), str2) && !z) {
                            arrayList.add(bVar);
                            z = true;
                        }
                        set.add(str2);
                    }
                    hashMap.put(bVar.getBundleId(), set);
                }
            }
        }
        if (arrayList.isEmpty()) {
            if (DEBUG) {
                Log.i("SwanPreDownload", "preDownload list empty");
                return;
            }
            return;
        }
        e eVar = new e(arrayList, am.aOb());
        eVar.xR(str);
        eVar.xQ("1");
        c.a(eVar, new d(new com.baidu.swan.apps.core.pms.a() { // from class: com.baidu.swan.apps.core.a.a.a.1
            @Override // com.baidu.swan.apps.core.pms.a
            public void a(@NonNull a.C0542a c0542a) {
                super.a(c0542a);
                lV(c0542a.erV);
                com.baidu.swan.apps.core.pms.d.a.mz(c0542a.erV);
            }

            @Override // com.baidu.swan.apps.core.pms.a
            public void a(@NonNull g gVar) {
                super.a(gVar);
                lV(gVar.appId);
            }

            @Override // com.baidu.swan.apps.core.pms.a
            public void ani() {
                anj();
            }

            private void anj() {
                for (String str3 : hashMap.keySet()) {
                    lV(str3);
                }
            }

            private void lV(@NonNull String str3) {
                if (hashMap.containsKey(str3)) {
                    Set<String> set2 = (Set) hashMap.get(str3);
                    if (set2 != null && !set2.isEmpty()) {
                        for (String str4 : set2) {
                            com.baidu.swan.apps.core.pms.d.a.bF(str3, str4);
                        }
                        return;
                    }
                    com.baidu.swan.apps.core.pms.d.a.mz(str3);
                }
            }
        }).gT("1".equals(str) ? 6 : 7));
    }

    public static void a(@NonNull List<b.a> list, @NonNull String str, @NonNull com.baidu.swan.apps.core.pms.a aVar) {
        if (!lU(h.aLO().getString("predownload_network_switch", "1"))) {
            aVar.gQ(6);
            return;
        }
        List<b.a> h = com.baidu.swan.apps.core.pms.d.a.h(list);
        if (h.isEmpty()) {
            aVar.ani();
            return;
        }
        com.baidu.swan.pms.c.d.b bVar = new com.baidu.swan.pms.c.d.b((List<? extends b.a>) h, (com.baidu.swan.pms.utils.a) am.aOb());
        bVar.xQ("1");
        bVar.xR(str);
        c.a(bVar, new d(aVar));
    }

    public static void a(boolean z, String str, final int i, InterfaceC0403a interfaceC0403a, final String str2, String str3) {
        if (DEBUG) {
            Log.d("SwanPreDownload", "AppId: " + str + ", scene: " + str2);
        }
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0403a != null) {
                interfaceC0403a.anm();
            }
        } else if (!lU(h.aLO().getString("predownload_network_switch", "1"))) {
            if (interfaceC0403a != null) {
                interfaceC0403a.gA(6);
            }
        } else if (!com.baidu.swan.apps.core.pms.d.a.my(str)) {
            if (interfaceC0403a != null) {
                interfaceC0403a.gA(2);
            }
        } else {
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(str, TextUtils.equals("swangame", str3) ? 1 : 0);
            cVar.xQ("1");
            cVar.xR(str2);
            if (!z) {
                cVar.ds(0L);
            }
            c.a(cVar, new com.baidu.swan.apps.core.pms.d.b(str, interfaceC0403a) { // from class: com.baidu.swan.apps.core.a.a.a.2
                @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
                public void ank() {
                    this.cSy = str2;
                }

                @Override // com.baidu.swan.apps.core.pms.f
                protected int anl() {
                    return i;
                }

                @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
                public void bv(String str4, String str5) {
                    super.bv(str4, str5);
                    if (!TextUtils.isEmpty(str5) && TextUtils.equals(str4, "770") && this.cSx != null) {
                        this.cSx.add(new UbcFlowEvent(str5));
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
    public static boolean lU(String str) {
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
