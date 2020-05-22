package com.baidu.swan.impl.map.a.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ad.c;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
/* loaded from: classes12.dex */
public class d {

    /* loaded from: classes12.dex */
    public interface a {
        void onFail();

        void onSuccess();
    }

    public static void a(Context context, final a aVar) {
        if (!(context instanceof Activity)) {
            aVar.onFail();
            return;
        }
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF != null) {
            aoF.aoR().b((Activity) context, "mapp_location", new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.impl.map.a.b.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<b.d> hVar) {
                    if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        d.a(a.this);
                    } else {
                        a.this.onFail();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final a aVar) {
        if (aj.atO()) {
            aVar.onSuccess();
        } else {
            com.baidu.swan.apps.w.f.ahV().a(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new c.a() { // from class: com.baidu.swan.impl.map.a.b.d.2
                @Override // com.baidu.swan.apps.ad.c.a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    if (i != 0) {
                        a.this.onFail();
                        return;
                    }
                    for (int i2 : iArr) {
                        if (i2 == -1) {
                            a.this.onFail();
                            return;
                        }
                    }
                    a.this.onSuccess();
                }
            });
        }
    }
}
