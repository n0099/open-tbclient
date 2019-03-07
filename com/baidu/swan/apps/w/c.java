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

    void DF();

    void DG();

    SwanCoreVersion DH();

    @DebugTrace
    com.baidu.swan.apps.b.c.a DI();

    boolean DJ();

    com.baidu.swan.apps.ae.a.c DK();

    String DL();

    String DM();

    String DN();

    SwanAppActivity DO();

    com.baidu.swan.apps.b.c.d DP();

    @NonNull
    Pair<Integer, Integer> DQ();

    @NonNull
    Pair<Integer, Integer> DR();

    void J(Intent intent);

    void a(int i, @NonNull String[] strArr, a.InterfaceC0078a interfaceC0078a);

    void a(com.baidu.swan.apps.m.a.a aVar);

    void a(com.baidu.swan.apps.m.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void a(String str, com.baidu.swan.apps.m.a.a aVar);

    void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void bL(Context context);

    void bM(Context context);

    void doRelease();

    @NonNull
    com.baidu.swan.apps.ae.a.d eN(String str);

    AbsoluteLayout eO(String str);

    com.baidu.swan.apps.b.c.e ee(String str);

    void exit();

    void f(SwanAppActivity swanAppActivity);

    void showLoadingView();

    void uC();

    com.baidu.swan.apps.core.c.e uz();

    void vQ();

    void vR();

    String yB();

    com.baidu.swan.apps.core.c.d yP();

    com.baidu.swan.apps.ae.b zb();

    com.baidu.swan.games.view.b zk();
}
