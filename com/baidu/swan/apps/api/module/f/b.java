package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.t.b.d;
/* loaded from: classes10.dex */
public class b {
    private static volatile b ctC;
    private a ctD;

    /* loaded from: classes10.dex */
    public interface a {
        void a(a.C0379a c0379a, int i);

        void a(a.C0379a c0379a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0379a c0379a, String str);
    }

    private b() {
    }

    public static b aho() {
        if (ctC == null) {
            synchronized (b.class) {
                if (ctC == null) {
                    ctC = new b();
                }
            }
        }
        return ctC;
    }

    public void a(@NonNull final a.C0379a c0379a, @NonNull a aVar, boolean z) {
        this.ctD = aVar;
        if (ak.aKw()) {
            a(c0379a);
        } else if (z) {
            this.ctD.a(c0379a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ab.a.a(d.aEQ().aEO(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ab.b
                public void ke(String str) {
                    b.this.a(c0379a);
                }

                @Override // com.baidu.swan.apps.ab.b
                public void ab(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.ctD.a(c0379a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0379a c0379a) {
        String str;
        if (TextUtils.equals(c0379a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0379a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.t.a.aus().a(str, false, c0379a.ctA, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.ctD.a(c0379a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.ctD.a(c0379a, i);
            }
        });
    }
}
