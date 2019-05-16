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
    com.baidu.swan.games.view.b Ai();

    com.baidu.swan.games.view.b Aj();

    FullScreenFloatView C(Activity activity);

    SwanAppPropertyWindow D(Activity activity);

    SwanCoreVersion FA();

    @DebugTrace
    com.baidu.swan.apps.b.c.a FB();

    boolean FC();

    com.baidu.swan.apps.ae.a.c FD();

    String FE();

    String FF();

    String FG();

    SwanAppActivity FH();

    com.baidu.swan.apps.b.c.d FI();

    @NonNull
    Pair<Integer, Integer> FJ();

    @NonNull
    Pair<Integer, Integer> FK();

    void Fy();

    void Fz();

    void I(Intent intent);

    void a(int i, @NonNull String[] strArr, a.InterfaceC0109a interfaceC0109a);

    void a(com.baidu.swan.apps.m.a.a aVar);

    void a(com.baidu.swan.apps.m.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void a(String str, com.baidu.swan.apps.m.a.a aVar);

    void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void bh(Context context);

    void bi(Context context);

    com.baidu.swan.apps.b.c.e dU(String str);

    void doRelease();

    @NonNull
    com.baidu.swan.apps.ae.a.d eZ(String str);

    void exit();

    void f(SwanAppActivity swanAppActivity);

    AbsoluteLayout fa(String str);

    void showLoadingView();

    com.baidu.swan.apps.core.d.e vi();

    void vl();

    void wG();

    void wH();

    com.baidu.swan.apps.core.d.d zL();

    com.baidu.swan.apps.ae.b zX();

    String zv();
}
