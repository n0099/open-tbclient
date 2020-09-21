package com.baidu.swan.apps.adaptation.b.a;

import android.content.Context;
import com.baidu.swan.apps.adaptation.a.ba;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.adaptation.b.g;
import com.baidu.swan.apps.adlanding.e;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.d.a.i;
import com.baidu.swan.apps.view.SwanAppSimpleH5Widget;
import com.baidu.swan.games.c.h;
import com.baidu.swan.games.view.webview.GameWebViewManager;
/* loaded from: classes3.dex */
public class b implements ba {
    @Override // com.baidu.swan.apps.adaptation.a.ba
    public com.baidu.swan.apps.core.g.a h(Context context, int i) {
        return new com.baidu.swan.apps.core.g.b().i(context, i);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ba
    public com.baidu.swan.apps.adaptation.b.c bo(Context context) {
        return new SwanAppSlaveManager(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ba
    public com.baidu.swan.apps.adaptation.b.a bp(Context context) {
        return new com.baidu.swan.apps.core.c.d(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ba
    public com.baidu.swan.apps.adaptation.b.a bq(Context context) {
        return new h(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ba
    public f br(Context context) {
        return new SwanAppSimpleH5Widget(context);
    }

    public f bv(Context context) {
        return new e(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ba
    public f bs(Context context) {
        return new i(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ba
    public f bt(Context context) {
        return new com.baidu.swan.apps.d.a.b.a.b(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ba
    public g bu(Context context) {
        return new GameWebViewManager(context);
    }
}
