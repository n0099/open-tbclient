package com.baidu.swan.apps.core.g;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.container.NgWebView;
/* loaded from: classes9.dex */
public class c extends SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.b<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final String cWn;

    public c(Context context) {
        super(context);
        this.cWn = com.baidu.swan.apps.core.g.a.a.next();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void aqT() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aqQ() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String amt() {
        return this.cWn;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a anh() {
        return amr();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.turbo.a aVar) {
        if (aVar != null && a.b.hG(0)) {
            if (DEBUG) {
                Log.d("SwanAppMasterManager", "pathList item: " + aVar.appPath);
            }
            this.cSq.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.by("appjs", aVar.appPath));
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.avA().fA(true);
    }
}
