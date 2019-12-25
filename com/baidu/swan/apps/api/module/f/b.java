package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.w.b.f;
/* loaded from: classes9.dex */
public class b {
    private static volatile b aZt;
    private a aZu;

    /* loaded from: classes9.dex */
    public interface a {
        void a(a.C0206a c0206a, int i);

        void a(a.C0206a c0206a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0206a c0206a, String str);
    }

    private b() {
    }

    public static b He() {
        if (aZt == null) {
            synchronized (b.class) {
                if (aZt == null) {
                    aZt = new b();
                }
            }
        }
        return aZt;
    }

    public void a(@NonNull final a.C0206a c0206a, @NonNull a aVar, boolean z) {
        this.aZu = aVar;
        if (ai.aev()) {
            a(c0206a);
        } else if (z) {
            this.aZu.a(c0206a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.af.a.a(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.af.b
                public void fl(String str) {
                    b.this.a(c0206a);
                }

                @Override // com.baidu.swan.apps.af.b
                public void q(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.aZu.a(c0206a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0206a c0206a) {
        String str;
        if (TextUtils.equals(c0206a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0206a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.w.a.RD().a(str, false, c0206a.aZr, new f.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.w.b.f.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.aZu.a(c0206a, bVar);
            }

            @Override // com.baidu.swan.apps.w.b.f.a
            public void onFailed(int i) {
                b.this.aZu.a(c0206a, i);
            }
        });
    }
}
