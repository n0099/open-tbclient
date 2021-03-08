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
    private static volatile b cIF;
    private a cIG;

    /* loaded from: classes8.dex */
    public interface a {
        void a(a.C0379a c0379a, int i);

        void a(a.C0379a c0379a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0379a c0379a, String str);
    }

    private b() {
    }

    public static b akg() {
        if (cIF == null) {
            synchronized (b.class) {
                if (cIF == null) {
                    cIF = new b();
                }
            }
        }
        return cIF;
    }

    public void a(@NonNull final a.C0379a c0379a, @NonNull a aVar, boolean z) {
        this.cIG = aVar;
        if (ak.aOo()) {
            a(c0379a);
        } else if (z) {
            this.cIG.a(c0379a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ab.a.a(d.aIJ().aIH(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ab.b
                public void kb(String str) {
                    b.this.a(c0379a);
                }

                @Override // com.baidu.swan.apps.ab.b
                public void am(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.cIG.a(c0379a, str);
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
        com.baidu.swan.apps.t.a.axr().a(str, false, c0379a.cID, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.cIG.a(c0379a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.cIG.a(c0379a, i);
            }
        });
    }
}
