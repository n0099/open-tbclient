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
/* loaded from: classes10.dex */
public interface d extends e.b {
    FullScreenFloatView J(Activity activity);

    SwanAppPropertyWindow K(Activity activity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    void adp();

    void afN();

    void afO();

    com.baidu.swan.apps.runtime.e alC();

    com.baidu.swan.apps.core.d.e amC();

    String aml();

    com.baidu.swan.games.view.d ana();

    com.baidu.swan.games.view.d anb();

    void awN();

    void awO();

    void awP();

    SwanCoreVersion awQ();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a awR();

    boolean awS();

    SwanAppConfigData awT();

    @NonNull
    com.baidu.swan.apps.storage.b.c awU();

    String awV();

    String awW();

    String awX();

    SwanAppActivity awY();

    com.baidu.swan.apps.adaptation.b.d awZ();

    @NonNull
    Pair<Integer, Integer> axa();

    @NonNull
    Pair<Integer, Integer> axb();

    com.baidu.swan.games.q.a axc();

    boolean axe();

    void b(com.baidu.swan.apps.event.a.a aVar);

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void ch(Context context);

    void ci(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e ns(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c px(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c py(String str);

    AbsoluteLayout pz(String str);

    void showLoadingView();

    void w(Intent intent);
}
