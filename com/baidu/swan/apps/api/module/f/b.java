package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.t.b.d;
/* loaded from: classes3.dex */
public class b {
    private static volatile b bYK;
    private a bYL;

    /* loaded from: classes3.dex */
    public interface a {
        void a(a.C0348a c0348a, int i);

        void a(a.C0348a c0348a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0348a c0348a, String str);
    }

    private b() {
    }

    public static b acI() {
        if (bYK == null) {
            synchronized (b.class) {
                if (bYK == null) {
                    bYK = new b();
                }
            }
        }
        return bYK;
    }

    public void a(@NonNull final a.C0348a c0348a, @NonNull a aVar, boolean z) {
        this.bYL = aVar;
        if (ak.aFT()) {
            a(c0348a);
        } else if (z) {
            this.bYL.a(c0348a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ab.a.a(d.aAn().aAl(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ab.b
                public void iZ(String str) {
                    b.this.a(c0348a);
                }

                @Override // com.baidu.swan.apps.ab.b
                public void O(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.bYL.a(c0348a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0348a c0348a) {
        String str;
        if (TextUtils.equals(c0348a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0348a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.t.a.apM().a(str, false, c0348a.bYI, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.bYL.a(c0348a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.bYL.a(c0348a, i);
            }
        });
    }
}
