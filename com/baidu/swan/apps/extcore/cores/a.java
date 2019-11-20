package com.baidu.swan.apps.extcore.cores;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a aPT;

    public static a HX() {
        if (aPT == null) {
            synchronized (a.class) {
                if (aPT == null) {
                    aPT = new a();
                }
            }
        }
        return aPT;
    }

    public void a(@Nullable final com.baidu.swan.apps.extcore.c.a aVar, int i) {
        com.baidu.swan.apps.swancore.d.b.Te().a(new com.baidu.swan.apps.swancore.a.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1
            @Override // com.baidu.swan.apps.swancore.a.a
            public void AU() {
                com.baidu.swan.apps.extcore.a.HS().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.extcore.cores.a.1.1
                    @Override // com.baidu.swan.apps.extcore.c.a
                    public void AU() {
                        if (aVar != null) {
                            aVar.AU();
                        }
                    }
                });
            }
        }, i);
    }

    public void HY() {
        com.baidu.swan.apps.swancore.d.b.Te().a((com.baidu.swan.apps.swancore.a.a) null, 0);
        com.baidu.swan.apps.swancore.d.b.Te().a((com.baidu.swan.apps.swancore.a.a) null, 1);
        com.baidu.swan.apps.extcore.a.HS().a((com.baidu.swan.apps.extcore.c.a) null);
    }

    public void G(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        com.baidu.swan.apps.swancore.b.G(i, i2);
        com.baidu.swan.apps.extcore.a.HS().G(i, i2);
    }
}
