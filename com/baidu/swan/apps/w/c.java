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
    com.baidu.swan.apps.core.d.e AI();

    void AL();

    void Cg();

    void Ch();

    FullScreenFloatView E(Activity activity);

    SwanAppPropertyWindow F(Activity activity);

    com.baidu.swan.apps.ae.b FE();

    com.baidu.swan.games.view.b FP();

    com.baidu.swan.games.view.b FQ();

    String Fc();

    com.baidu.swan.apps.core.d.d Fs();

    void Lh();

    void Li();

    SwanCoreVersion Lj();

    @DebugTrace
    com.baidu.swan.apps.b.c.a Lk();

    boolean Ll();

    com.baidu.swan.apps.ae.a.c Lm();

    String Ln();

    String Lo();

    String Lp();

    SwanAppActivity Lq();

    com.baidu.swan.apps.b.c.d Lr();

    @NonNull
    Pair<Integer, Integer> Ls();

    @NonNull
    Pair<Integer, Integer> Lt();

    void O(Intent intent);

    void a(int i, @NonNull String[] strArr, a.InterfaceC0147a interfaceC0147a);

    void a(com.baidu.swan.apps.m.a.a aVar);

    void a(com.baidu.swan.apps.m.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void a(String str, com.baidu.swan.apps.m.a.a aVar);

    void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void bj(Context context);

    void bk(Context context);

    void doRelease();

    com.baidu.swan.apps.b.c.e eH(String str);

    void exit();

    void f(SwanAppActivity swanAppActivity);

    @NonNull
    com.baidu.swan.apps.ae.a.d fM(String str);

    AbsoluteLayout fN(String str);

    void showLoadingView();
}
