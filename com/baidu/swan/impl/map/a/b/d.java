package com.baidu.swan.impl.map.a.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ab.c;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
/* loaded from: classes24.dex */
public class d {

    /* loaded from: classes24.dex */
    public interface a {
        void onFail();

        void onSuccess();
    }

    public static void a(Context context, final a aVar) {
        if (!(context instanceof Activity)) {
            aVar.onFail();
            return;
        }
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null) {
            aGM.aGY().b((Activity) context, "mapp_location", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.impl.map.a.b.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
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
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        if (ak.aMo() && aGN != null) {
            aVar.onSuccess();
        } else {
            aGN.aGG().a(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new c.a() { // from class: com.baidu.swan.impl.map.a.b.d.2
                @Override // com.baidu.swan.apps.ab.c.a
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
