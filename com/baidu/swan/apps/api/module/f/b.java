package com.baidu.swan.apps.api.module.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.t.b.d;
/* loaded from: classes8.dex */
public class b {
    private static volatile b cEJ;
    private a cEK;

    /* loaded from: classes8.dex */
    public interface a {
        void a(a.C0376a c0376a, int i);

        void a(a.C0376a c0376a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0376a c0376a, String str);
    }

    private b() {
    }

    public static b ajF() {
        if (cEJ == null) {
            synchronized (b.class) {
                if (cEJ == null) {
                    cEJ = new b();
                }
            }
        }
        return cEJ;
    }

    public void a(@NonNull final a.C0376a c0376a, @NonNull a aVar, boolean z) {
        this.cEK = aVar;
        if (ak.aNS()) {
            a(c0376a);
        } else if (z) {
            this.cEK.a(c0376a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ab.a.a(d.aIn().aIl(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ab.b
                public void jC(String str) {
                    b.this.a(c0376a);
                }

                @Override // com.baidu.swan.apps.ab.b
                public void ai(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.cEK.a(c0376a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0376a c0376a) {
        String str;
        if (TextUtils.equals(c0376a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0376a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.t.a.awQ().a(str, false, c0376a.cEH, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.cEK.a(c0376a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.cEK.a(c0376a, i);
            }
        });
    }
}
