package com.baidu.swan.apps.y;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.y.e;
/* loaded from: classes9.dex */
public interface d extends e.b {
    com.baidu.swan.apps.core.d.e DP();

    void DS();

    void FL();

    void FM();

    void J(Intent intent);

    com.baidu.swan.apps.core.d.d LC();

    com.baidu.swan.apps.runtime.e LO();

    String Ln();

    FullScreenFloatView M(Activity activity);

    com.baidu.swan.games.view.d Mc();

    com.baidu.swan.games.view.d Md();

    SwanAppPropertyWindow N(Activity activity);

    void TG();

    void TH();

    SwanCoreVersion TI();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a TJ();

    boolean TK();

    SwanAppConfigData TL();

    @NonNull
    com.baidu.swan.apps.storage.b.c TM();

    String TN();

    String TO();

    String TP();

    SwanAppActivity TQ();

    com.baidu.swan.apps.adaptation.b.d TR();

    @NonNull
    Pair<Integer, Integer> TS();

    @NonNull
    Pair<Integer, Integer> TT();

    com.baidu.swan.games.p.a TU();

    void a(int i, @NonNull String[] strArr, c.a aVar);

    void a(com.baidu.swan.apps.n.a.a aVar);

    void a(com.baidu.swan.apps.n.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void a(String str, com.baidu.swan.apps.n.a.a aVar);

    void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void cc(Context context);

    void cd(Context context);

    void doRelease();

    void exit();

    com.baidu.swan.apps.adaptation.b.e hd(String str);

    void i(SwanAppActivity swanAppActivity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c iA(String str);

    AbsoluteLayout iB(String str);

    void showLoadingView();
}
