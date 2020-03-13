package com.baidu.swan.apps.extcore.cores;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a buH;

    public static a RR() {
        if (buH == null) {
            synchronized (a.class) {
                if (buH == null) {
                    buH = new a();
                }
            }
        }
        return buH;
    }

    public void a(@Nullable final com.baidu.swan.apps.extcore.c.a aVar, final int i) {
        com.baidu.swan.apps.swancore.d.b.afD().a(new com.baidu.swan.apps.swancore.a.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1
            @Override // com.baidu.swan.apps.swancore.a.a
            public void RI() {
                com.baidu.swan.apps.extcore.b.a(i, new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1.1
                    @Override // com.baidu.swan.apps.extcore.c.a
                    public void RI() {
                        if (aVar != null) {
                            aVar.RI();
                        }
                    }
                });
            }
        }, i);
    }

    public void RS() {
        com.baidu.swan.apps.swancore.d.b.afD().a((com.baidu.swan.apps.swancore.a.a) null, 0);
        com.baidu.swan.apps.swancore.d.b.afD().a((com.baidu.swan.apps.swancore.a.a) null, 1);
        com.baidu.swan.apps.extcore.b.a(0, (com.baidu.swan.apps.extcore.c.a) null);
        com.baidu.swan.apps.extcore.b.a(1, (com.baidu.swan.apps.extcore.c.a) null);
    }

    public void Z(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        com.baidu.swan.apps.swancore.b.Z(i, i2);
        com.baidu.swan.apps.extcore.b.Z(i, i2);
    }
}
