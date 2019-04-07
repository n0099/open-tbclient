package com.baidu.swan.apps.w;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.d;
/* loaded from: classes2.dex */
public interface c extends d.b {
    FullScreenFloatView C(Activity activity);

    SwanAppPropertyWindow D(Activity activity);

    void DD();

    void DE();

    SwanCoreVersion DF();

    @DebugTrace
    com.baidu.swan.apps.b.c.a DG();

    boolean DH();

    com.baidu.swan.apps.ae.a.c DI();

    String DJ();

    String DK();

    String DL();

    SwanAppActivity DM();

    com.baidu.swan.apps.b.c.d DN();

    @NonNull
    Pair<Integer, Integer> DO();

    @NonNull
    Pair<Integer, Integer> DP();

    void J(Intent intent);

    void a(int i, @NonNull String[] strArr, a.InterfaceC0108a interfaceC0108a);

    void a(com.baidu.swan.apps.m.a.a aVar);

    void a(com.baidu.swan.apps.m.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void a(String str, com.baidu.swan.apps.m.a.a aVar);

    void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void bL(Context context);

    void bM(Context context);

    void doRelease();

    @NonNull
    com.baidu.swan.apps.ae.a.d eO(String str);

    AbsoluteLayout eP(String str);

    com.baidu.swan.apps.b.c.e eg(String str);

    void exit();

    void f(SwanAppActivity swanAppActivity);

    void showLoadingView();

    void uB();

    com.baidu.swan.apps.core.c.e uy();

    void vP();

    void vQ();

    String yA();

    com.baidu.swan.apps.core.c.d yO();

    com.baidu.swan.apps.ae.b za();

    com.baidu.swan.games.view.b zj();
}
