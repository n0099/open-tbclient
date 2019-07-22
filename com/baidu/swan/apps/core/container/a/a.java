package com.baidu.swan.apps.core.container.a;

import android.util.Log;
import com.baidu.swan.apps.b.c.i;
/* loaded from: classes2.dex */
public class a implements i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.container.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0129a {
        public static final a aqv = new a();
    }

    private a() {
    }

    public static a zr() {
        return C0129a.aqv;
    }

    @Override // com.baidu.swan.apps.b.c.i
    public void a(b bVar) {
        if (DEBUG) {
            Log.d("SysWebViewInitHelper", "addInitListener");
        }
        if (bVar != null) {
            bVar.zs();
        }
    }

    @Override // com.baidu.swan.apps.b.c.i
    public void b(b bVar) {
        if (DEBUG) {
            Log.d("SysWebViewInitHelper", "removeInitListener");
        }
    }
}
