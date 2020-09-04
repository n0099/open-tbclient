package com.baidu.swan.apps.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.e;
/* loaded from: classes8.dex */
public interface d extends e.b {
    FullScreenFloatView H(Activity activity);

    SwanAppPropertyWindow I(Activity activity);

    void Ya();

    @NonNull
    com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    void aay();

    void aaz();

    String agW();

    com.baidu.swan.apps.runtime.e agn();

    com.baidu.swan.games.view.d ahL();

    com.baidu.swan.games.view.d ahM();

    com.baidu.swan.apps.core.d.e ahn();

    SwanCoreVersion arA();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a arB();

    boolean arC();

    SwanAppConfigData arD();

    @NonNull
    com.baidu.swan.apps.storage.b.c arE();

    String arF();

    String arG();

    String arH();

    SwanAppActivity arI();

    com.baidu.swan.apps.adaptation.b.d arJ();

    @NonNull
    Pair<Integer, Integer> arK();

    @NonNull
    Pair<Integer, Integer> arL();

    com.baidu.swan.games.q.a arM();

    boolean arO();

    void arx();

    void ary();

    void arz();

    void b(com.baidu.swan.apps.event.a.a aVar);

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void cc(Context context);

    void cd(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e lU(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c nX(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c nY(String str);

    AbsoluteLayout nZ(String str);

    void showLoadingView();

    void w(Intent intent);
}
