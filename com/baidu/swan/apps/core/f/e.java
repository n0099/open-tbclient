package com.baidu.swan.apps.core.f;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.core.f.d;
/* loaded from: classes2.dex */
public class e implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d arV;
    private String arW;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void loadUrl(String str) {
        if (this.arV == null) {
            this.arV = new d(com.baidu.swan.apps.core.i.c.Aa().Ai(), "runtime/index.js");
            this.arW = str;
        } else if (DEBUG) {
            Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
        }
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void a(final com.baidu.swan.apps.core.c cVar) {
        if (this.arV != null) {
            this.arV.a(new d.b() { // from class: com.baidu.swan.apps.core.f.e.1
            });
        }
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void destroy() {
        if (this.arV != null) {
            this.arV.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.f.a
    public void v(Activity activity) {
        this.arV.v(activity);
    }

    @Override // com.baidu.swan.apps.core.f.a
    public com.baidu.swan.apps.core.container.a zr() {
        return this.arV.getV8Engine();
    }
}
