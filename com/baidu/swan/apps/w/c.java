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
    com.baidu.swan.apps.ae.b AI();

    com.baidu.swan.games.view.b AT();

    com.baidu.swan.games.view.b AU();

    String Ag();

    com.baidu.swan.apps.core.d.d Aw();

    FullScreenFloatView F(Activity activity);

    SwanAppPropertyWindow G(Activity activity);

    void Gm();

    void Gn();

    SwanCoreVersion Go();

    @DebugTrace
    com.baidu.swan.apps.b.c.a Gp();

    boolean Gq();

    com.baidu.swan.apps.ae.a.c Gr();

    String Gs();

    String Gt();

    String Gu();

    SwanAppActivity Gv();

    com.baidu.swan.apps.b.c.d Gw();

    @NonNull
    Pair<Integer, Integer> Gx();

    @NonNull
    Pair<Integer, Integer> Gy();

    void I(Intent intent);

    void a(int i, @NonNull String[] strArr, a.InterfaceC0120a interfaceC0120a);

    void a(com.baidu.swan.apps.m.a.a aVar);

    void a(com.baidu.swan.apps.m.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void a(String str, com.baidu.swan.apps.m.a.a aVar);

    void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void bh(Context context);

    void bi(Context context);

    void doRelease();

    com.baidu.swan.apps.b.c.e ea(String str);

    void exit();

    void f(SwanAppActivity swanAppActivity);

    @NonNull
    com.baidu.swan.apps.ae.a.d ff(String str);

    AbsoluteLayout fg(String str);

    void showLoadingView();

    com.baidu.swan.apps.core.d.e vN();

    void vQ();

    void xl();

    void xm();
}
