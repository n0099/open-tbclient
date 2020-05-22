package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.u.b.d;
/* loaded from: classes11.dex */
public class b {
    private static volatile b bLA;
    private a bLB;

    /* loaded from: classes11.dex */
    public interface a {
        void a(a.C0303a c0303a, int i);

        void a(a.C0303a c0303a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0303a c0303a, String str);
    }

    private b() {
    }

    public static b Uh() {
        if (bLA == null) {
            synchronized (b.class) {
                if (bLA == null) {
                    bLA = new b();
                }
            }
        }
        return bLA;
    }

    public void a(@NonNull final a.C0303a c0303a, @NonNull a aVar, boolean z) {
        this.bLB = aVar;
        if (aj.atO()) {
            a(c0303a);
        } else if (z) {
            this.bLB.a(c0303a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ad.a.a(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ad.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ad.b
                public void gY(String str) {
                    b.this.a(c0303a);
                }

                @Override // com.baidu.swan.apps.ad.b
                public void M(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.bLB.a(c0303a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0303a c0303a) {
        String str;
        if (TextUtils.equals(c0303a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0303a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.u.a.afj().a(str, false, c0303a.bLy, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.u.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.bLB.a(c0303a, bVar);
            }

            @Override // com.baidu.swan.apps.u.b.d.a
            public void onFailed(int i) {
                b.this.bLB.a(c0303a, i);
            }
        });
    }
}
