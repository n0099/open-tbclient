package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.t.b.d;
/* loaded from: classes25.dex */
public class b {
    private static volatile b cEF;
    private a cEG;

    /* loaded from: classes25.dex */
    public interface a {
        void a(a.C0401a c0401a, int i);

        void a(a.C0401a c0401a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0401a c0401a, String str);
    }

    private b() {
    }

    public static b amo() {
        if (cEF == null) {
            synchronized (b.class) {
                if (cEF == null) {
                    cEF = new b();
                }
            }
        }
        return cEF;
    }

    public void a(@NonNull final a.C0401a c0401a, @NonNull a aVar, boolean z) {
        this.cEG = aVar;
        if (ak.aPu()) {
            a(c0401a);
        } else if (z) {
            this.cEG.a(c0401a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ab.a.a(d.aJQ().aJO(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ab.b
                public void kU(String str) {
                    b.this.a(c0401a);
                }

                @Override // com.baidu.swan.apps.ab.b
                public void af(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.cEG.a(c0401a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0401a c0401a) {
        String str;
        if (TextUtils.equals(c0401a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0401a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.t.a.azs().a(str, false, c0401a.cED, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.cEG.a(c0401a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.cEG.a(c0401a, i);
            }
        });
    }
}
