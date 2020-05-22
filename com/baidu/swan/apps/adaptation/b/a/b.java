package com.baidu.swan.apps.adaptation.b.a;

import android.content.Context;
import com.baidu.swan.apps.adaptation.a.as;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.adaptation.b.g;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingWebViewWidget;
import com.baidu.swan.apps.c.a.i;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.view.SwanAppSimpleH5Widget;
import com.baidu.swan.games.c.h;
import com.baidu.swan.games.view.webview.GameWebViewManager;
/* loaded from: classes11.dex */
public class b implements as {
    @Override // com.baidu.swan.apps.adaptation.a.as
    public com.baidu.swan.apps.core.g.a h(Context context, int i) {
        return new com.baidu.swan.apps.core.g.b().i(context, i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.as
    public com.baidu.swan.apps.adaptation.b.c bf(Context context) {
        return new SwanAppSlaveManager(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.as
    public com.baidu.swan.apps.adaptation.b.a bg(Context context) {
        return new com.baidu.swan.apps.core.c.d(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.as
    public com.baidu.swan.apps.adaptation.b.a bh(Context context) {
        return new h(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.as
    public f bi(Context context) {
        return new SwanAppSimpleH5Widget(context);
    }

    public f bm(Context context) {
        return new SwanAppAdLandingWebViewWidget(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.as
    public f bj(Context context) {
        return new i(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.as
    public f bk(Context context) {
        return new com.baidu.swan.apps.c.a.b.a.b(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.as
    public g bl(Context context) {
        return new GameWebViewManager(context);
    }
}
