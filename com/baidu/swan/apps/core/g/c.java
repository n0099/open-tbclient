package com.baidu.swan.apps.core.g;

import android.content.Context;
import com.baidu.swan.apps.core.container.SystemWebViewImpl;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.core.b implements com.baidu.swan.apps.b.c.b<SystemWebViewImpl> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void DQ() {
    }

    @Override // com.baidu.swan.apps.b.c.e
    public String Cu() {
        return "master";
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (com.baidu.swan.apps.console.a.d.Dl()) {
            str = com.baidu.swan.apps.console.a.d.Dm();
        }
        super.loadUrl(str);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a FZ() {
        return Cs();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.j.a aVar) {
    }
}
