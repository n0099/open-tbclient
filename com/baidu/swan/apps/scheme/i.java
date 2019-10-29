package com.baidu.swan.apps.scheme;

import com.baidu.swan.apps.extcore.debug.action.DebugSetCtsConfigAction;
import com.baidu.swan.apps.scheme.actions.m;
import com.baidu.swan.apps.scheme.actions.v;
/* loaded from: classes2.dex */
public class i extends j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.scheme.j
    protected void RK() {
        this.blA.clear();
        a(new m(this));
        a(new com.baidu.swan.apps.console.a.a(this));
        a(new v(this));
        a(new com.baidu.swan.apps.scheme.actions.g(this));
        if (DEBUG) {
            a(new com.baidu.swan.apps.scheme.actions.e(this));
            a(new com.baidu.swan.games.h.a.a(this));
            a(new com.baidu.swan.games.c.d(this));
            a(new com.baidu.swan.apps.extcore.debug.action.a(this));
            a(new com.baidu.swan.apps.extcore.debug.action.d(this));
            a(new com.baidu.swan.apps.extcore.debug.action.b(this));
            a(new com.baidu.swan.apps.extcore.debug.action.c(this));
            a(new DebugSetCtsConfigAction(this));
        }
    }
}
