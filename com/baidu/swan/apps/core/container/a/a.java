package com.baidu.swan.apps.core.container.a;

import android.util.Log;
import com.baidu.swan.apps.b.c.i;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public class a implements i {
    private static final boolean DEBUG = c.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0102a {
        public static final a apA = new a();
    }

    private a() {
    }

    public static a xT() {
        return C0102a.apA;
    }

    @Override // com.baidu.swan.apps.b.c.i
    public void a(b bVar) {
        if (DEBUG) {
            Log.d("SysWebViewInitHelper", "addInitListener");
        }
        if (bVar != null) {
            bVar.xU();
        }
    }

    @Override // com.baidu.swan.apps.b.c.i
    public void b(b bVar) {
        if (DEBUG) {
            Log.d("SysWebViewInitHelper", "removeInitListener");
        }
    }
}
