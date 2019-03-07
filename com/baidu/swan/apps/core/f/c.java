package com.baidu.swan.apps.core.f;

import android.content.Context;
import com.baidu.swan.apps.core.container.SystemWebViewImpl;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.core.b implements com.baidu.swan.apps.b.c.b<SystemWebViewImpl> {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    public c(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void xu() {
    }

    @Override // com.baidu.swan.apps.b.c.e
    public String we() {
        return "master";
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (com.baidu.swan.apps.console.a.d.wP()) {
            str = com.baidu.swan.apps.console.a.d.wQ();
        }
        super.loadUrl(str);
    }

    @Override // com.baidu.swan.apps.core.f.a
    public com.baidu.swan.apps.core.container.a zs() {
        return wc();
    }
}
