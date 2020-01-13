package com.baidu.swan.apps.api.module.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.w.b.f;
/* loaded from: classes10.dex */
public class b {
    private static volatile b bal;
    private a bam;

    /* loaded from: classes10.dex */
    public interface a {
        void a(a.C0208a c0208a, int i);

        void a(a.C0208a c0208a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0208a c0208a, String str);
    }

    private b() {
    }

    public static b HA() {
        if (bal == null) {
            synchronized (b.class) {
                if (bal == null) {
                    bal = new b();
                }
            }
        }
        return bal;
    }

    public void a(@NonNull final a.C0208a c0208a, @NonNull a aVar, boolean z) {
        this.bam = aVar;
        if (ai.aeO()) {
            a(c0208a);
        } else if (z) {
            this.bam.a(c0208a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.af.a.a(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.af.b
                public void fo(String str) {
                    b.this.a(c0208a);
                }

                @Override // com.baidu.swan.apps.af.b
                public void t(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.bam.a(c0208a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0208a c0208a) {
        String str;
        if (TextUtils.equals(c0208a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0208a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.w.a.RZ().a(str, false, c0208a.baj, new f.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.w.b.f.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.bam.a(c0208a, bVar);
            }

            @Override // com.baidu.swan.apps.w.b.f.a
            public void onFailed(int i) {
                b.this.bam.a(c0208a, i);
            }
        });
    }
}
