package com.baidu.swan.apps.core.g;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.container.NgWebView;
/* loaded from: classes10.dex */
public class c extends SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.b<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void KB() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Ky() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String GA() {
        return "master";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a Hm() {
        return Gy();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.k.a aVar) {
        if (aVar != null && a.b.dD(0)) {
            if (DEBUG) {
                Log.d("SwanAppMasterManager", "pathList item: " + aVar.appPath);
            }
            this.bhR.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.ao("appjs", aVar.appPath));
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.k.d.Og().ct(true);
    }
}
