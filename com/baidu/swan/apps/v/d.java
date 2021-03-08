package com.baidu.swan.apps.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.e;
/* loaded from: classes8.dex */
public interface d extends e.b {
    FullScreenFloatView B(Activity activity);

    SwanAppPropertyWindow C(Activity activity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    @NonNull
    Pair<Integer, Integer> aAa();

    @NonNull
    Pair<Integer, Integer> aAb();

    com.baidu.swan.games.q.a aAc();

    boolean aAe();

    void agd();

    void aiF();

    void aiG();

    com.baidu.swan.apps.runtime.e aov();

    com.baidu.swan.apps.core.d.e apB();

    com.baidu.swan.games.view.d apZ();

    String apk();

    com.baidu.swan.games.view.d aqa();

    void azN();

    void azO();

    void azP();

    SwanCoreVersion azQ();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a azR();

    boolean azS();

    SwanAppConfigData azT();

    @NonNull
    com.baidu.swan.apps.storage.b.c azU();

    String azV();

    String azW();

    String azX();

    SwanAppActivity azY();

    com.baidu.swan.apps.adaptation.b.d azZ();

    void b(com.baidu.swan.apps.event.a.a aVar);

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void cS(Context context);

    void cT(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e np(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c pt(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c pu(String str);

    AbsoluteLayout pv(String str);

    void showLoadingView();

    void w(Intent intent);
}
