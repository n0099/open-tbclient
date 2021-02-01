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
/* loaded from: classes9.dex */
public interface d extends e.b {
    FullScreenFloatView B(Activity activity);

    SwanAppPropertyWindow C(Activity activity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    boolean aAb();

    void aga();

    void aiC();

    void aiD();

    com.baidu.swan.apps.runtime.e aos();

    com.baidu.swan.games.view.d apW();

    com.baidu.swan.games.view.d apX();

    String apg();

    com.baidu.swan.apps.core.d.e apy();

    void azK();

    void azL();

    void azM();

    SwanCoreVersion azN();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a azO();

    boolean azP();

    SwanAppConfigData azQ();

    @NonNull
    com.baidu.swan.apps.storage.b.c azR();

    String azS();

    String azT();

    String azU();

    SwanAppActivity azV();

    com.baidu.swan.apps.adaptation.b.d azW();

    @NonNull
    Pair<Integer, Integer> azX();

    @NonNull
    Pair<Integer, Integer> azY();

    com.baidu.swan.games.q.a azZ();

    void b(com.baidu.swan.apps.event.a.a aVar);

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void cT(Context context);

    void cU(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e ni(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c pm(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c pn(String str);

    AbsoluteLayout po(String str);

    void showLoadingView();

    void w(Intent intent);
}
