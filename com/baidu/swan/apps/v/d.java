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
/* loaded from: classes7.dex */
public interface d extends e.b {
    FullScreenFloatView I(Activity activity);

    SwanAppPropertyWindow J(Activity activity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    void afh();

    void ahF();

    void ahG();

    com.baidu.swan.apps.runtime.e anu();

    com.baidu.swan.games.view.d aoS();

    com.baidu.swan.games.view.d aoT();

    String aod();

    com.baidu.swan.apps.core.d.e aou();

    void ayF();

    void ayG();

    void ayH();

    SwanCoreVersion ayI();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a ayJ();

    boolean ayK();

    SwanAppConfigData ayL();

    @NonNull
    com.baidu.swan.apps.storage.b.c ayM();

    String ayN();

    String ayO();

    String ayP();

    SwanAppActivity ayQ();

    com.baidu.swan.apps.adaptation.b.d ayR();

    @NonNull
    Pair<Integer, Integer> ayS();

    @NonNull
    Pair<Integer, Integer> ayT();

    com.baidu.swan.games.q.a ayU();

    boolean ayW();

    void b(com.baidu.swan.apps.event.a.a aVar);

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void ch(Context context);

    void ci(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e nB(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c pF(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c pG(String str);

    AbsoluteLayout pH(String str);

    void showLoadingView();

    void w(Intent intent);
}
