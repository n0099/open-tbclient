package com.baidu.swan.apps.extcore.cores;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a avw;

    public static a Bo() {
        if (avw == null) {
            synchronized (a.class) {
                if (avw == null) {
                    avw = new a();
                }
            }
        }
        return avw;
    }

    public void a(@Nullable final com.baidu.swan.apps.extcore.c.a aVar, int i) {
        com.baidu.swan.apps.swancore.d.b.KW().a(new com.baidu.swan.apps.swancore.a.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1
            @Override // com.baidu.swan.apps.swancore.a.a
            public void uL() {
                com.baidu.swan.apps.extcore.a.Bj().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1.1
                    @Override // com.baidu.swan.apps.extcore.c.a
                    public void uL() {
                        if (aVar != null) {
                            aVar.uL();
                        }
                    }
                });
            }
        }, i);
    }

    public void Bp() {
        com.baidu.swan.apps.swancore.d.b.KW().a((com.baidu.swan.apps.swancore.a.a) null, 0);
        com.baidu.swan.apps.swancore.d.b.KW().a((com.baidu.swan.apps.swancore.a.a) null, 1);
        com.baidu.swan.apps.extcore.a.Bj().a((com.baidu.swan.apps.extcore.c.a) null);
    }

    public void B(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        com.baidu.swan.apps.swancore.b.B(i, i2);
        com.baidu.swan.apps.extcore.a.Bj().B(i, i2);
    }
}
