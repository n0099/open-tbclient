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
    private static volatile b czx;
    private a czy;

    /* loaded from: classes10.dex */
    public interface a {
        void a(a.C0391a c0391a, int i);

        void a(a.C0391a c0391a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0391a c0391a, String str);
    }

    private b() {
    }

    public static b ajO() {
        if (czx == null) {
            synchronized (b.class) {
                if (czx == null) {
                    czx = new b();
                }
            }
        }
        return czx;
    }

    public void a(@NonNull final a.C0391a c0391a, @NonNull a aVar, boolean z) {
        this.czy = aVar;
        if (ak.aMW()) {
            a(c0391a);
        } else if (z) {
            this.czy.a(c0391a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ab.a.a(d.aHq().aHo(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ab.b
                public void kt(String str) {
                    b.this.a(c0391a);
                }

                @Override // com.baidu.swan.apps.ab.b
                public void af(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.czy.a(c0391a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0391a c0391a) {
        String str;
        if (TextUtils.equals(c0391a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0391a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.t.a.awS().a(str, false, c0391a.czv, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.czy.a(c0391a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.czy.a(c0391a, i);
            }
        });
    }
}
