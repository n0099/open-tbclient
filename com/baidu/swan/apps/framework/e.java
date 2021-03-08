package com.baidu.swan.apps.framework;

import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes8.dex */
public class e {
    public static c a(SwanAppActivity swanAppActivity, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null || !eVar.available()) {
            return null;
        }
        switch (eVar.getFrameType()) {
            case 0:
                return new com.baidu.swan.apps.framework.a.a(swanAppActivity, eVar.id);
            case 1:
                return new com.baidu.swan.games.j.b(swanAppActivity, eVar.id);
            default:
                return null;
        }
    }
}
