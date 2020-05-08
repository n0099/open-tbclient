package com.baidu.swan.apps.framework;

import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes11.dex */
public class e {
    public static c a(SwanAppActivity swanAppActivity, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null || !eVar.available()) {
            return null;
        }
        switch (eVar.Ol()) {
            case 0:
                return new com.baidu.swan.apps.framework.a.a(swanAppActivity, eVar.id);
            case 1:
                return new com.baidu.swan.games.i.b(swanAppActivity, eVar.id);
            default:
                return null;
        }
    }
}
