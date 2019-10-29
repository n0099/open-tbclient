package com.baidu.swan.apps.extcore.cores;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a aQl;

    public static a HW() {
        if (aQl == null) {
            synchronized (a.class) {
                if (aQl == null) {
                    aQl = new a();
                }
            }
        }
        return aQl;
    }

    public void a(@Nullable final com.baidu.swan.apps.extcore.c.a aVar, int i) {
        com.baidu.swan.apps.swancore.d.b.Tc().a(new com.baidu.swan.apps.swancore.a.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1
            @Override // com.baidu.swan.apps.swancore.a.a
            public void AT() {
                com.baidu.swan.apps.extcore.a.HR().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1.1
                    @Override // com.baidu.swan.apps.extcore.c.a
                    public void AT() {
                        if (aVar != null) {
                            aVar.AT();
                        }
                    }
                });
            }
        }, i);
    }

    public void HX() {
        com.baidu.swan.apps.swancore.d.b.Tc().a((com.baidu.swan.apps.swancore.a.a) null, 0);
        com.baidu.swan.apps.swancore.d.b.Tc().a((com.baidu.swan.apps.swancore.a.a) null, 1);
        com.baidu.swan.apps.extcore.a.HR().a((com.baidu.swan.apps.extcore.c.a) null);
    }

    public void I(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        com.baidu.swan.apps.swancore.b.I(i, i2);
        com.baidu.swan.apps.extcore.a.HR().I(i, i2);
    }
}
