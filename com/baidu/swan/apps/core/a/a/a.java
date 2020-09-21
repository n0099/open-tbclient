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
/* loaded from: classes3.dex */
public final class a implements b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0375a {
        void agp();

        void agq();

        void ha(int i);
    }

    public static void e(@NonNull List<e.b> list, @Nullable String str) {
        String[] aOd;
        if (!lr(h.aDP().getString("predownload_network_switch", "1"))) {
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
                if (bVar.aOd() == null) {
                    if (com.baidu.swan.apps.core.pms.d.a.lV(bVar.getBundleId())) {
                        arrayList.add(bVar);
                        hashMap.put(bVar.getBundleId(), null);
                    }
                } else {
                    Set set = (Set) hashMap.get(bVar.getBundleId());
                    if (set == null) {
                        set = new HashSet();
                    }
                    boolean z = false;
                    for (String str2 : bVar.aOd()) {
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
        e eVar = new e(arrayList, am.aGb());
        eVar.xi(str);
        eVar.xh("1");
        c.a(eVar, new d(new com.baidu.swan.apps.core.pms.a() { // from class: com.baidu.swan.apps.core.a.a.a.1
            @Override // com.baidu.swan.apps.core.pms.a
            public void a(@NonNull a.C0515a c0515a) {
                super.a(c0515a);
                ls(c0515a.dHr);
                com.baidu.swan.apps.core.pms.d.a.lW(c0515a.dHr);
            }

            @Override // com.baidu.swan.apps.core.pms.a
            public void a(@NonNull g gVar) {
                super.a(gVar);
                ls(gVar.appId);
            }

            @Override // com.baidu.swan.apps.core.pms.a
            public void agl() {
                agm();
            }

            private void agm() {
                for (String str3 : hashMap.keySet()) {
                    ls(str3);
                }
            }

            private void ls(@NonNull String str3) {
                if (hashMap.containsKey(str3)) {
                    Set<String> set2 = (Set) hashMap.get(str3);
                    if (set2 != null && !set2.isEmpty()) {
                        for (String str4 : set2) {
                            com.baidu.swan.apps.core.pms.d.a.bp(str3, str4);
                        }
                        return;
                    }
                    com.baidu.swan.apps.core.pms.d.a.lW(str3);
                }
            }
        }).hs("1".equals(str) ? 6 : 7));
    }

    public static void a(@NonNull List<b.a> list, @NonNull String str, @NonNull com.baidu.swan.apps.core.pms.a aVar) {
        if (!lr(h.aDP().getString("predownload_network_switch", "1"))) {
            aVar.hp(6);
            return;
        }
        List<b.a> h = com.baidu.swan.apps.core.pms.d.a.h(list);
        if (h.isEmpty()) {
            aVar.agl();
            return;
        }
        com.baidu.swan.pms.c.d.b bVar = new com.baidu.swan.pms.c.d.b((List<? extends b.a>) h, (com.baidu.swan.pms.utils.a) am.aGb());
        bVar.xh("1");
        bVar.xi(str);
        c.a(bVar, new d(aVar));
    }

    public static void a(boolean z, String str, final int i, InterfaceC0375a interfaceC0375a, final String str2, String str3) {
        if (DEBUG) {
            Log.d("SwanPreDownload", "AppId: " + str + ", scene: " + str2);
        }
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0375a != null) {
                interfaceC0375a.agp();
            }
        } else if (!lr(h.aDP().getString("predownload_network_switch", "1"))) {
            if (interfaceC0375a != null) {
                interfaceC0375a.ha(6);
            }
        } else if (!com.baidu.swan.apps.core.pms.d.a.lV(str)) {
            if (interfaceC0375a != null) {
                interfaceC0375a.ha(2);
            }
        } else {
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(str, TextUtils.equals("swangame", str3) ? 1 : 0);
            cVar.xh("1");
            cVar.xi(str2);
            if (!z) {
                cVar.cm(0L);
            }
            c.a(cVar, new com.baidu.swan.apps.core.pms.d.b(str, interfaceC0375a) { // from class: com.baidu.swan.apps.core.a.a.a.2
                @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
                public void agn() {
                    this.cmy = str2;
                }

                @Override // com.baidu.swan.apps.core.pms.f
                protected int ago() {
                    return i;
                }

                @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
                public void bf(String str4, String str5) {
                    super.bf(str4, str5);
                    if (!TextUtils.isEmpty(str5) && TextUtils.equals(str4, "770") && this.cmx != null) {
                        this.cmx.add(new UbcFlowEvent(str5));
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
    public static boolean lr(String str) {
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
