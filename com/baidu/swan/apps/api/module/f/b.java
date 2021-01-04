package com.baidu.swan.apps.api.module.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.t.b.d;
/* loaded from: classes9.dex */
public class b {
    private static volatile b cJv;
    private a cJw;

    /* loaded from: classes9.dex */
    public interface a {
        void a(a.C0393a c0393a, int i);

        void a(a.C0393a c0393a, com.baidu.swan.apps.scheme.actions.f.b bVar);

        void a(a.C0393a c0393a, String str);
    }

    private b() {
    }

    public static b any() {
        if (cJv == null) {
            synchronized (b.class) {
                if (cJv == null) {
                    cJv = new b();
                }
            }
        }
        return cJv;
    }

    public void a(@NonNull final a.C0393a c0393a, @NonNull a aVar, boolean z) {
        this.cJw = aVar;
        if (ak.aRL()) {
            a(c0393a);
        } else if (z) {
            this.cJw.a(c0393a, "GetLocation does not supported when app is invisible");
        } else {
            com.baidu.swan.apps.ab.a.a(d.aMg().aMe(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.api.module.f.b.1
                @Override // com.baidu.swan.apps.ab.b
                public void kN(String str) {
                    b.this.a(c0393a);
                }

                @Override // com.baidu.swan.apps.ab.b
                public void ah(int i, String str) {
                    c.e("GetLocationHelper", str);
                    b.this.cJw.a(c0393a, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.C0393a c0393a) {
        String str;
        if (TextUtils.equals(c0393a.mType, "gcj02")) {
            str = "gcj02";
        } else if (TextUtils.equals(c0393a.mType, "bd09ll")) {
            str = "bd09ll";
        } else {
            str = CoordinateType.WGS84;
        }
        com.baidu.swan.apps.t.a.aAJ().a(str, false, c0393a.cJt, new d.a() { // from class: com.baidu.swan.apps.api.module.f.b.2
            @Override // com.baidu.swan.apps.t.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar) {
                b.this.cJw.a(c0393a, bVar);
            }

            @Override // com.baidu.swan.apps.t.b.d.a
            public void onFailed(int i) {
                b.this.cJw.a(c0393a, i);
            }
        });
    }
}
