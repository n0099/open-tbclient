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
    private static volatile b bCZ;
    private a bDa;

    /* loaded from: classes11.dex */
    public interface a {
        void a(a.C0248a c0248a, int i);

        void a(a.C0248a c0248a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0248a c0248a, String str);
    }

    private b() {
    }

    public static b RH() {
        if (bCZ == null) {
            synchronized (b.class) {
                if (bCZ == null) {
                    bCZ = new b();
                }
            }
        }
        return bCZ;
    }

    public void a(@NonNull final a.C0248a c0248a, @NonNull a aVar, boolean z) {
        this.bDa = aVar;
        if (ai.app()) {
            a(c0248a);
        } else if (z) {
            this.bDa.a(c0248a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.af.a.a(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.af.b
                public void gQ(String str) {
                    b.this.a(c0248a);
                }

                @Override // com.baidu.swan.apps.af.b
                public void M(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.bDa.a(c0248a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0248a c0248a) {
        String str;
        if (TextUtils.equals(c0248a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0248a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.w.a.ach().a(str, false, c0248a.bCX, new f.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.w.b.f.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.bDa.a(c0248a, bVar);
            }

            @Override // com.baidu.swan.apps.w.b.f.a
            public void onFailed(int i) {
                b.this.bDa.a(c0248a, i);
            }
        });
    }
}
