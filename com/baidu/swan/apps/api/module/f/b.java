package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.t.b.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile b bRf;
    private a bRg;

    /* loaded from: classes7.dex */
    public interface a {
        void a(a.C0308a c0308a, int i);

        void a(a.C0308a c0308a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0308a c0308a, String str);
    }

    private b() {
    }

    public static b VT() {
        if (bRf == null) {
            synchronized (b.class) {
                if (bRf == null) {
                    bRf = new b();
                }
            }
        }
        return bRf;
    }

    public void a(@NonNull final a.C0308a c0308a, @NonNull a aVar, boolean z) {
        this.bRg = aVar;
        if (al.axa()) {
            a(c0308a);
        } else if (z) {
            this.bRg.a(c0308a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ac.a.a(d.arr().arp(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ac.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ac.b
                public void hm(String str) {
                    b.this.a(c0308a);
                }

                @Override // com.baidu.swan.apps.ac.b
                public void O(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.bRg.a(c0308a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0308a c0308a) {
        String str;
        if (TextUtils.equals(c0308a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0308a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.t.a.ahB().a(str, false, c0308a.bRd, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.bRg.a(c0308a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.bRg.a(c0308a, i);
            }
        });
    }
}
