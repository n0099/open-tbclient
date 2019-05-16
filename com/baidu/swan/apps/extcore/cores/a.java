package com.baidu.swan.apps.extcore.cores;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a avT;

    public static a Cp() {
        if (avT == null) {
            synchronized (a.class) {
                if (avT == null) {
                    avT = new a();
                }
            }
        }
        return avT;
    }

    public void a(@Nullable final com.baidu.swan.apps.extcore.c.a aVar, int i) {
        com.baidu.swan.apps.swancore.d.b.Nt().a(new com.baidu.swan.apps.swancore.a.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1
            @Override // com.baidu.swan.apps.swancore.a.a
            public void vu() {
                com.baidu.swan.apps.extcore.a.Ck().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1.1
                    @Override // com.baidu.swan.apps.extcore.c.a
                    public void vu() {
                        if (aVar != null) {
                            aVar.vu();
                        }
                    }
                });
            }
        }, i);
    }

    public void Cq() {
        com.baidu.swan.apps.swancore.d.b.Nt().a((com.baidu.swan.apps.swancore.a.a) null, 0);
        com.baidu.swan.apps.swancore.d.b.Nt().a((com.baidu.swan.apps.swancore.a.a) null, 1);
        com.baidu.swan.apps.extcore.a.Ck().a((com.baidu.swan.apps.extcore.c.a) null);
    }

    public void z(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        com.baidu.swan.apps.swancore.b.z(i, i2);
        com.baidu.swan.apps.extcore.a.Ck().z(i, i2);
    }
}
