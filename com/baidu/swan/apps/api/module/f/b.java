package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.t.b.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile b cxN;
    private a cxO;

    /* loaded from: classes7.dex */
    public interface a {
        void a(a.C0389a c0389a, int i);

        void a(a.C0389a c0389a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0389a c0389a, String str);
    }

    private b() {
    }

    public static b ajg() {
        if (cxN == null) {
            synchronized (b.class) {
                if (cxN == null) {
                    cxN = new b();
                }
            }
        }
        return cxN;
    }

    public void a(@NonNull final a.C0389a c0389a, @NonNull a aVar, boolean z) {
        this.cxO = aVar;
        if (ak.aMo()) {
            a(c0389a);
        } else if (z) {
            this.cxO.a(c0389a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ab.a.a(d.aGI().aGG(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ab.b
                public void kn(String str) {
                    b.this.a(c0389a);
                }

                @Override // com.baidu.swan.apps.ab.b
                public void af(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.cxO.a(c0389a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0389a c0389a) {
        String str;
        if (TextUtils.equals(c0389a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0389a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.t.a.awk().a(str, false, c0389a.cxL, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.cxO.a(c0389a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.cxO.a(c0389a, i);
            }
        });
    }
}
