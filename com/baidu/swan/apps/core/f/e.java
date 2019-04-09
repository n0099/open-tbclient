package com.baidu.swan.apps.core.f;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.core.f.d;
/* loaded from: classes2.dex */
public class e implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d arW;
    private String arX;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void loadUrl(String str) {
        if (this.arW == null) {
            this.arW = new d(com.baidu.swan.apps.core.i.c.Aa().Ai(), "runtime/index.js");
            this.arX = str;
        } else if (DEBUG) {
            Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
        }
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void a(final com.baidu.swan.apps.core.c cVar) {
        if (this.arW != null) {
            this.arW.a(new d.b() { // from class: com.baidu.swan.apps.core.f.e.1
            });
        }
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void destroy() {
        if (this.arW != null) {
            this.arW.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void v(Activity activity) {
        this.arW.v(activity);
    }

    @Override // com.baidu.swan.apps.core.f.a
    public com.baidu.swan.apps.core.container.a zr() {
        return this.arW.getV8Engine();
    }
}
