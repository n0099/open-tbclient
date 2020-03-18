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
/* loaded from: classes11.dex */
public interface d extends e.b {
    com.baidu.swan.apps.core.d.e GH();

    void GK();

    void IB();

    void IC();

    void J(Intent intent);

    FullScreenFloatView O(Activity activity);

    com.baidu.swan.apps.runtime.e OD();

    com.baidu.swan.games.view.d OR();

    com.baidu.swan.games.view.d OS();

    String Oc();

    com.baidu.swan.apps.core.d.d Or();

    SwanAppPropertyWindow P(Activity activity);

    boolean WA();

    SwanAppConfigData WB();

    @NonNull
    com.baidu.swan.apps.storage.b.c WC();

    String WD();

    String WE();

    String WF();

    SwanAppActivity WG();

    com.baidu.swan.apps.adaptation.b.d WH();

    @NonNull
    Pair<Integer, Integer> WI();

    @NonNull
    Pair<Integer, Integer> WJ();

    com.baidu.swan.games.p.a WK();

    void Ww();

    void Wx();

    SwanCoreVersion Wy();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a Wz();

    void a(int i, @NonNull String[] strArr, c.a aVar);

    void a(com.baidu.swan.apps.n.a.a aVar);

    void a(com.baidu.swan.apps.n.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void a(String str, com.baidu.swan.apps.n.a.a aVar);

    void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void cf(Context context);

    void cg(Context context);

    void doRelease();

    void exit();

    com.baidu.swan.apps.adaptation.b.e hu(String str);

    void i(SwanAppActivity swanAppActivity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c iR(String str);

    AbsoluteLayout iS(String str);

    void showLoadingView();
}
