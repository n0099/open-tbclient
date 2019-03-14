package com.baidu.swan.apps.core.f;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.core.f.d;
/* loaded from: classes2.dex */
public class e implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d arR;
    private String arS;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void loadUrl(String str) {
        if (this.arR == null) {
            this.arR = new d(com.baidu.swan.apps.core.i.c.Ab().Aj(), "runtime/index.js");
            this.arS = str;
        } else if (DEBUG) {
            Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
        }
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void a(final com.baidu.swan.apps.core.c cVar) {
        if (this.arR != null) {
            this.arR.a(new d.b() { // from class: com.baidu.swan.apps.core.f.e.1
            });
        }
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void destroy() {
        if (this.arR != null) {
            this.arR.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void v(Activity activity) {
        this.arR.v(activity);
    }

    @Override // com.baidu.swan.apps.core.f.a
    public com.baidu.swan.apps.core.container.a zs() {
        return this.arR.getV8Engine();
    }
}
