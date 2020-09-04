package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.t.b.d;
/* loaded from: classes8.dex */
public class b {
    private static volatile b bWJ;
    private a bWK;

    /* loaded from: classes8.dex */
    public interface a {
        void a(a.C0353a c0353a, int i);

        void a(a.C0353a c0353a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0353a c0353a, String str);
    }

    private b() {
    }

    public static b abZ() {
        if (bWJ == null) {
            synchronized (b.class) {
                if (bWJ == null) {
                    bWJ = new b();
                }
            }
        }
        return bWJ;
    }

    public void a(@NonNull final a.C0353a c0353a, @NonNull a aVar, boolean z) {
        this.bWK = aVar;
        if (ak.aFj()) {
            a(c0353a);
        } else if (z) {
            this.bWK.a(c0353a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ab.a.a(d.azE().azC(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ab.b
                public void iG(String str) {
                    b.this.a(c0353a);
                }

                @Override // com.baidu.swan.apps.ab.b
                public void N(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.bWK.a(c0353a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0353a c0353a) {
        String str;
        if (TextUtils.equals(c0353a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0353a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.t.a.apb().a(str, false, c0353a.bWH, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.bWK.a(c0353a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.bWK.a(c0353a, i);
            }
        });
    }
}
