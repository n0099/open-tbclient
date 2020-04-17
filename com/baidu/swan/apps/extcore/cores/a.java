package com.baidu.swan.apps.extcore.cores;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bSZ;

    public static a ZJ() {
        if (bSZ == null) {
            synchronized (a.class) {
                if (bSZ == null) {
                    bSZ = new a();
                }
            }
        }
        return bSZ;
    }

    public void a(@Nullable final com.baidu.swan.apps.extcore.c.a aVar, final int i) {
        com.baidu.swan.apps.swancore.d.b.anL().a(new com.baidu.swan.apps.swancore.a.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1
            @Override // com.baidu.swan.apps.swancore.a.a
            public void ZA() {
                com.baidu.swan.apps.extcore.b.a(i, new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1.1
                    @Override // com.baidu.swan.apps.extcore.c.a
                    public void ZA() {
                        if (aVar != null) {
                            aVar.ZA();
                        }
                    }
                });
            }
        }, i);
    }

    public void ZK() {
        com.baidu.swan.apps.swancore.d.b.anL().a((com.baidu.swan.apps.swancore.a.a) null, 0);
        com.baidu.swan.apps.swancore.d.b.anL().a((com.baidu.swan.apps.swancore.a.a) null, 1);
        com.baidu.swan.apps.extcore.b.a(0, (com.baidu.swan.apps.extcore.c.a) null);
        com.baidu.swan.apps.extcore.b.a(1, (com.baidu.swan.apps.extcore.c.a) null);
    }

    public void ac(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        com.baidu.swan.apps.swancore.b.ac(i, i2);
        com.baidu.swan.apps.extcore.b.ac(i, i2);
    }
}
