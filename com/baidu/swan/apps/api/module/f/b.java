package com.baidu.swan.apps.api.module.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.t.b.d;
/* loaded from: classes9.dex */
public class b {
    private static volatile b cHf;
    private a cHg;

    /* loaded from: classes9.dex */
    public interface a {
        void a(a.C0373a c0373a, int i);

        void a(a.C0373a c0373a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0373a c0373a, String str);
    }

    private b() {
    }

    public static b akd() {
        if (cHf == null) {
            synchronized (b.class) {
                if (cHf == null) {
                    cHf = new b();
                }
            }
        }
        return cHf;
    }

    public void a(@NonNull final a.C0373a c0373a, @NonNull a aVar, boolean z) {
        this.cHg = aVar;
        if (ak.aOl()) {
            a(c0373a);
        } else if (z) {
            this.cHg.a(c0373a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ab.a.a(d.aIG().aIE(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ab.b
                public void jU(String str) {
                    b.this.a(c0373a);
                }

                @Override // com.baidu.swan.apps.ab.b
                public void am(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.cHg.a(c0373a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0373a c0373a) {
        String str;
        if (TextUtils.equals(c0373a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0373a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.t.a.axo().a(str, false, c0373a.cHd, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.cHg.a(c0373a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.cHg.a(c0373a, i);
            }
        });
    }
}
