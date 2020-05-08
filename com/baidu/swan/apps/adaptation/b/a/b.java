package com.baidu.swan.apps.adaptation.b.a;

import android.content.Context;
import com.baidu.swan.apps.adaptation.a.am;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.adaptation.b.g;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingWebViewWidget;
import com.baidu.swan.apps.c.a.i;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.view.SwanAppSimpleH5Widget;
import com.baidu.swan.games.b.h;
import com.baidu.swan.games.view.webview.GameWebViewManager;
/* loaded from: classes11.dex */
public class b implements am {
    @Override // com.baidu.swan.apps.adaptation.a.am
    public com.baidu.swan.apps.core.g.a h(Context context, int i) {
        return new com.baidu.swan.apps.core.g.b().i(context, i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.am
    public com.baidu.swan.apps.adaptation.b.c aV(Context context) {
        return new SwanAppSlaveManager(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.am
    public com.baidu.swan.apps.adaptation.b.a aW(Context context) {
        return new com.baidu.swan.apps.core.c.d(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.am
    public com.baidu.swan.apps.adaptation.b.a aX(Context context) {
        return new h(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.am
    public f aY(Context context) {
        return new SwanAppSimpleH5Widget(context);
    }

    public f bc(Context context) {
        return new SwanAppAdLandingWebViewWidget(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.am
    public f aZ(Context context) {
        return new i(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.am
    public f ba(Context context) {
        return new com.baidu.swan.apps.c.a.b.a.b(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.am
    public g bb(Context context) {
        return new GameWebViewManager(context);
    }
}
