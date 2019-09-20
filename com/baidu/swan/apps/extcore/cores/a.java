package com.baidu.swan.apps.extcore.cores;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a awW;

    public static a Dc() {
        if (awW == null) {
            synchronized (a.class) {
                if (awW == null) {
                    awW = new a();
                }
            }
        }
        return awW;
    }

    public void a(@Nullable final com.baidu.swan.apps.extcore.c.a aVar, int i) {
        com.baidu.swan.apps.swancore.d.b.Om().a(new com.baidu.swan.apps.swancore.a.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1
            @Override // com.baidu.swan.apps.swancore.a.a
            public void vZ() {
                com.baidu.swan.apps.extcore.a.CX().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1.1
                    @Override // com.baidu.swan.apps.extcore.c.a
                    public void vZ() {
                        if (aVar != null) {
                            aVar.vZ();
                        }
                    }
                });
            }
        }, i);
    }

    public void Dd() {
        com.baidu.swan.apps.swancore.d.b.Om().a((com.baidu.swan.apps.swancore.a.a) null, 0);
        com.baidu.swan.apps.swancore.d.b.Om().a((com.baidu.swan.apps.swancore.a.a) null, 1);
        com.baidu.swan.apps.extcore.a.CX().a((com.baidu.swan.apps.extcore.c.a) null);
    }

    public void C(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        com.baidu.swan.apps.swancore.b.C(i, i2);
        com.baidu.swan.apps.extcore.a.CX().C(i, i2);
    }
}
