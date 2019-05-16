package com.baidu.swan.apps.core.container.a;

import android.util.Log;
import com.baidu.swan.apps.b.c.i;
/* loaded from: classes2.dex */
public class a implements i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0132a {
        public static final a apS = new a();
    }

    private a() {
    }

    public static a yK() {
        return C0132a.apS;
    }

    @Override // com.baidu.swan.apps.b.c.i
    public void a(b bVar) {
        if (DEBUG) {
            Log.d("SysWebViewInitHelper", "addInitListener");
        }
        if (bVar != null) {
            bVar.yL();
        }
    }

    @Override // com.baidu.swan.apps.b.c.i
    public void b(b bVar) {
        if (DEBUG) {
            Log.d("SysWebViewInitHelper", "removeInitListener");
        }
    }
}
