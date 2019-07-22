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
    com.baidu.swan.apps.ae.b AE();

    com.baidu.swan.games.view.b AP();

    com.baidu.swan.games.view.b AQ();

    String Ac();

    com.baidu.swan.apps.core.d.d As();

    FullScreenFloatView F(Activity activity);

    SwanAppPropertyWindow G(Activity activity);

    void Gi();

    void Gj();

    SwanCoreVersion Gk();

    @DebugTrace
    com.baidu.swan.apps.b.c.a Gl();

    boolean Gm();

    com.baidu.swan.apps.ae.a.c Gn();

    String Go();

    String Gp();

    String Gq();

    SwanAppActivity Gr();

    com.baidu.swan.apps.b.c.d Gs();

    @NonNull
    Pair<Integer, Integer> Gt();

    @NonNull
    Pair<Integer, Integer> Gu();

    void I(Intent intent);

    void a(int i, @NonNull String[] strArr, a.InterfaceC0106a interfaceC0106a);

    void a(com.baidu.swan.apps.m.a.a aVar);

    void a(com.baidu.swan.apps.m.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void a(String str, com.baidu.swan.apps.m.a.a aVar);

    void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2);

    void bh(Context context);

    void bi(Context context);

    com.baidu.swan.apps.b.c.e dY(String str);

    void doRelease();

    void exit();

    void f(SwanAppActivity swanAppActivity);

    @NonNull
    com.baidu.swan.apps.ae.a.d fd(String str);

    AbsoluteLayout fe(String str);

    void showLoadingView();

    com.baidu.swan.apps.core.d.e vJ();

    void vM();

    void xh();

    void xi();
}
