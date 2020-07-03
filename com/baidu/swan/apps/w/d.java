package com.baidu.swan.apps.w;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ad.c;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.e;
/* loaded from: classes11.dex */
public interface d extends e.b {
    FullScreenFloatView I(Activity activity);

    SwanAppPropertyWindow J(Activity activity);

    void RQ();

    void TW();

    void TX();

    String ZH();

    com.baidu.swan.apps.core.d.d ZW();

    void a(int i, @NonNull String[] strArr, c.a aVar);

    void a(com.baidu.swan.apps.event.a.a aVar);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    com.baidu.swan.apps.runtime.e aai();

    com.baidu.swan.games.view.d aax();

    com.baidu.swan.games.view.d aay();

    void aiA();

    void aiB();

    void aiC();

    SwanCoreVersion aiD();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a aiE();

    boolean aiF();

    SwanAppConfigData aiG();

    @NonNull
    com.baidu.swan.apps.storage.b.c aiH();

    String aiI();

    String aiJ();

    String aiK();

    SwanAppActivity aiL();

    com.baidu.swan.apps.adaptation.b.d aiM();

    @NonNull
    Pair<Integer, Integer> aiN();

    @NonNull
    Pair<Integer, Integer> aiO();

    com.baidu.swan.games.q.a aiP();

    boolean aiR();

    void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2);

    void bT(Context context);

    void bU(Context context);

    void doRelease();

    void exit();

    void h(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e jW(String str);

    AbsoluteLayout lA(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c ly(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c lz(String str);

    void showLoadingView();

    void u(Intent intent);
}
