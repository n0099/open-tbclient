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
    private static volatile b ckZ;
    private a cla;

    /* loaded from: classes10.dex */
    public interface a {
        void a(a.C0365a c0365a, int i);

        void a(a.C0365a c0365a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0365a c0365a, String str);
    }

    private b() {
    }

    public static b afu() {
        if (ckZ == null) {
            synchronized (b.class) {
                if (ckZ == null) {
                    ckZ = new b();
                }
            }
        }
        return ckZ;
    }

    public void a(@NonNull final a.C0365a c0365a, @NonNull a aVar, boolean z) {
        this.cla = aVar;
        if (ak.aIC()) {
            a(c0365a);
        } else if (z) {
            this.cla.a(c0365a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ab.a.a(d.aCW().aCU(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ab.b
                public void jL(String str) {
                    b.this.a(c0365a);
                }

                @Override // com.baidu.swan.apps.ab.b
                public void Z(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.cla.a(c0365a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0365a c0365a) {
        String str;
        if (TextUtils.equals(c0365a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0365a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.t.a.asy().a(str, false, c0365a.ckX, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.cla.a(c0365a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.cla.a(c0365a, i);
            }
        });
    }
}
