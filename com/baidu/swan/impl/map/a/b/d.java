package com.baidu.swan.impl.map.a.b;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.ac;
/* loaded from: classes5.dex */
public class d {

    /* loaded from: classes5.dex */
    public interface a {
        void onFail();

        void onSuccess();
    }

    public static void a(Context context, final a aVar) {
        if (!(context instanceof Activity)) {
            aVar.onFail();
            return;
        }
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            Mh.Ml().a((Activity) context, "mapp_location", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.impl.map.a.b.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    if (bool.booleanValue()) {
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
        if (ac.PO()) {
            aVar.onSuccess();
        } else {
            com.baidu.swan.apps.w.e.GJ().a(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new a.InterfaceC0120a() { // from class: com.baidu.swan.impl.map.a.b.d.2
                @Override // com.baidu.swan.apps.ab.a.InterfaceC0120a
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
