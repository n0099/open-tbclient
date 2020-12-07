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
/* loaded from: classes25.dex */
public interface d extends e.b {
    FullScreenFloatView I(Activity activity);

    SwanAppPropertyWindow J(Activity activity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    void aBO();

    void aBP();

    void aBQ();

    SwanCoreVersion aBR();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a aBS();

    boolean aBT();

    SwanAppConfigData aBU();

    @NonNull
    com.baidu.swan.apps.storage.b.c aBV();

    String aBW();

    String aBX();

    String aBY();

    SwanAppActivity aBZ();

    com.baidu.swan.apps.adaptation.b.d aCa();

    @NonNull
    Pair<Integer, Integer> aCb();

    @NonNull
    Pair<Integer, Integer> aCc();

    com.baidu.swan.games.q.a aCd();

    boolean aCf();

    void aip();

    void akN();

    void akO();

    com.baidu.swan.apps.runtime.e aqC();

    com.baidu.swan.apps.core.d.e arC();

    String arl();

    com.baidu.swan.games.view.d asa();

    com.baidu.swan.games.view.d asb();

    void b(com.baidu.swan.apps.event.a.a aVar);

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void cN(Context context);

    void cO(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e oj(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c qm(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c qn(String str);

    AbsoluteLayout qo(String str);

    void showLoadingView();

    void w(Intent intent);
}
