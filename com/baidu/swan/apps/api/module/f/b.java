package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.w.b.f;
/* loaded from: classes11.dex */
public class b {
    private static volatile b beM;
    private a beN;

    /* loaded from: classes11.dex */
    public interface a {
        void a(a.C0218a c0218a, int i);

        void a(a.C0218a c0218a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0218a c0218a, String str);
    }

    private b() {
    }

    public static b JU() {
        if (beM == null) {
            synchronized (b.class) {
                if (beM == null) {
                    beM = new b();
                }
            }
        }
        return beM;
    }

    public void a(@NonNull final a.C0218a c0218a, @NonNull a aVar, boolean z) {
        this.beN = aVar;
        if (ai.ahh()) {
            a(c0218a);
        } else if (z) {
            this.beN.a(c0218a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.af.a.a(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.af.b
                public void fC(String str) {
                    b.this.a(c0218a);
                }

                @Override // com.baidu.swan.apps.af.b
                public void v(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.beN.a(c0218a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0218a c0218a) {
        String str;
        if (TextUtils.equals(c0218a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0218a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.w.a.Us().a(str, false, c0218a.beK, new f.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.w.b.f.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.beN.a(c0218a, bVar);
            }

            @Override // com.baidu.swan.apps.w.b.f.a
            public void onFailed(int i) {
                b.this.beN.a(c0218a, i);
            }
        });
    }
}
