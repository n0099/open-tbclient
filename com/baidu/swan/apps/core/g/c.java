package com.baidu.swan.apps.core.g;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.container.NgWebView;
/* loaded from: classes8.dex */
public class c extends SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.b<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cjv;

    public c(Context context) {
        super(context);
        this.cjv = com.baidu.swan.apps.core.g.a.a.next();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void afs() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afp() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aaU() {
        return this.cjv;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a abI() {
        return aaS();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.turbo.a aVar) {
        if (aVar != null && a.b.gr(0)) {
            if (DEBUG) {
                Log.d("SwanAppMasterManager", "pathList item: " + aVar.appPath);
            }
            this.cfx.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.bh("appjs", aVar.appPath));
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.ajS().ei(true);
    }
}
