package com.baidu.swan.apps.core.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.am;
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
    public interface InterfaceC0380a {
        void afF();

        void afG();

        void gR(int i);
    }

    public static void e(@NonNull List<e.b> list, @Nullable String str) {
        String[] aNs;
        if (!kX(h.aDf().getString("predownload_network_switch", "1"))) {
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
                if (bVar.aNs() == null) {
                    if (com.baidu.swan.apps.core.pms.d.a.lB(bVar.getBundleId())) {
                        arrayList.add(bVar);
                        hashMap.put(bVar.getBundleId(), null);
                    }
                } else {
                    Set set = (Set) hashMap.get(bVar.getBundleId());
                    if (set == null) {
                        set = new HashSet();
                    }
                    boolean z = false;
                    for (String str2 : bVar.aNs()) {
                        if (com.baidu.swan.apps.core.pms.d.a.bo(bVar.getBundleId(), str2) && !z) {
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
        e eVar = new e(arrayList, am.aFr());
        eVar.wO(str);
        eVar.wN("1");
        c.a(eVar, new d(new com.baidu.swan.apps.core.pms.a() { // from class: com.baidu.swan.apps.core.a.a.a.1
            @Override // com.baidu.swan.apps.core.pms.a
            public void a(@NonNull a.C0520a c0520a) {
                super.a(c0520a);
                kY(c0520a.dFj);
                com.baidu.swan.apps.core.pms.d.a.lC(c0520a.dFj);
            }

            @Override // com.baidu.swan.apps.core.pms.a
            public void a(@NonNull g gVar) {
                super.a(gVar);
                kY(gVar.appId);
            }

            @Override // com.baidu.swan.apps.core.pms.a
            public void afB() {
                afC();
            }

            private void afC() {
                for (String str3 : hashMap.keySet()) {
                    kY(str3);
                }
            }

            private void kY(@NonNull String str3) {
                if (hashMap.containsKey(str3)) {
                    Set<String> set2 = (Set) hashMap.get(str3);
                    if (set2 != null && !set2.isEmpty()) {
                        for (String str4 : set2) {
                            com.baidu.swan.apps.core.pms.d.a.bp(str3, str4);
                        }
                        return;
                    }
                    com.baidu.swan.apps.core.pms.d.a.lC(str3);
                }
            }
        }).hj("1".equals(str) ? 6 : 7));
    }

    public static void a(@NonNull List<b.a> list, @NonNull String str, @NonNull com.baidu.swan.apps.core.pms.a aVar) {
        if (!kX(h.aDf().getString("predownload_network_switch", "1"))) {
            aVar.hg(6);
            return;
        }
        List<b.a> h = com.baidu.swan.apps.core.pms.d.a.h(list);
        if (h.isEmpty()) {
            aVar.afB();
            return;
        }
        com.baidu.swan.pms.c.d.b bVar = new com.baidu.swan.pms.c.d.b((List<? extends b.a>) h, (com.baidu.swan.pms.utils.a) am.aFr());
        bVar.wN("1");
        bVar.wO(str);
        c.a(bVar, new d(aVar));
    }

    public static void a(boolean z, String str, final int i, InterfaceC0380a interfaceC0380a, final String str2, String str3) {
        if (DEBUG) {
            Log.d("SwanPreDownload", "AppId: " + str + ", scene: " + str2);
        }
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0380a != null) {
                interfaceC0380a.afF();
            }
        } else if (!kX(h.aDf().getString("predownload_network_switch", "1"))) {
            if (interfaceC0380a != null) {
                interfaceC0380a.gR(6);
            }
        } else if (!com.baidu.swan.apps.core.pms.d.a.lB(str)) {
            if (interfaceC0380a != null) {
                interfaceC0380a.gR(2);
            }
        } else {
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(str, TextUtils.equals("swangame", str3) ? 1 : 0);
            cVar.wN("1");
            cVar.wO(str2);
            if (!z) {
                cVar.cl(0L);
            }
            c.a(cVar, new com.baidu.swan.apps.core.pms.d.b(str, interfaceC0380a) { // from class: com.baidu.swan.apps.core.a.a.a.2
                @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
                public void afD() {
                    this.cks = str2;
                }

                @Override // com.baidu.swan.apps.core.pms.f
                protected int afE() {
                    return i;
                }

                @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
                public void bf(String str4, String str5) {
                    super.bf(str4, str5);
                    if (!TextUtils.isEmpty(str5) && TextUtils.equals(str4, "770") && this.ckr != null) {
                        this.ckr.add(new UbcFlowEvent(str5));
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
    public static boolean kX(String str) {
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
