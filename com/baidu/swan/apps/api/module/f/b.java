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
    private static volatile b bDe;
    private a bDf;

    /* loaded from: classes11.dex */
    public interface a {
        void a(a.C0269a c0269a, int i);

        void a(a.C0269a c0269a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0269a c0269a, String str);
    }

    private b() {
    }

    public static b RG() {
        if (bDe == null) {
            synchronized (b.class) {
                if (bDe == null) {
                    bDe = new b();
                }
            }
        }
        return bDe;
    }

    public void a(@NonNull final a.C0269a c0269a, @NonNull a aVar, boolean z) {
        this.bDf = aVar;
        if (ai.apo()) {
            a(c0269a);
        } else if (z) {
            this.bDf.a(c0269a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.af.a.a(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.af.b
                public void gQ(String str) {
                    b.this.a(c0269a);
                }

                @Override // com.baidu.swan.apps.af.b
                public void M(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.bDf.a(c0269a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0269a c0269a) {
        String str;
        if (TextUtils.equals(c0269a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0269a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.w.a.acg().a(str, false, c0269a.bDc, new f.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.w.b.f.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.bDf.a(c0269a, bVar);
            }

            @Override // com.baidu.swan.apps.w.b.f.a
            public void onFailed(int i) {
                b.this.bDf.a(c0269a, i);
            }
        });
    }
}
