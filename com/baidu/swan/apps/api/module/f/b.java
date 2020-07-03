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
    private static volatile b bQo;
    private a bQp;

    /* loaded from: classes11.dex */
    public interface a {
        void a(a.C0309a c0309a, int i);

        void a(a.C0309a c0309a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0309a c0309a, String str);
    }

    private b() {
    }

    public static b Vn() {
        if (bQo == null) {
            synchronized (b.class) {
                if (bQo == null) {
                    bQo = new b();
                }
            }
        }
        return bQo;
    }

    public void a(@NonNull final a.C0309a c0309a, @NonNull a aVar, boolean z) {
        this.bQp = aVar;
        if (aj.auU()) {
            a(c0309a);
        } else if (z) {
            this.bQp.a(c0309a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ad.a.a(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ad.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ad.b
                public void hg(String str) {
                    b.this.a(c0309a);
                }

                @Override // com.baidu.swan.apps.ad.b
                public void O(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.bQp.a(c0309a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0309a c0309a) {
        String str;
        if (TextUtils.equals(c0309a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0309a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.u.a.agp().a(str, false, c0309a.bQm, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.u.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.bQp.a(c0309a, bVar);
            }

            @Override // com.baidu.swan.apps.u.b.d.a
            public void onFailed(int i) {
                b.this.bQp.a(c0309a, i);
            }
        });
    }
}
