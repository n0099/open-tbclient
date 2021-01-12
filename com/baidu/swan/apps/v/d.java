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
    FullScreenFloatView H(Activity activity);

    SwanAppPropertyWindow I(Activity activity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    void afC();

    void aie();

    void aif();

    com.baidu.swan.apps.runtime.e anU();

    String aoI();

    com.baidu.swan.apps.core.d.e aoZ();

    com.baidu.swan.games.view.d apy();

    com.baidu.swan.games.view.d apz();

    @NonNull
    Pair<Integer, Integer> azA();

    com.baidu.swan.games.q.a azB();

    boolean azD();

    void azm();

    void azn();

    void azo();

    SwanCoreVersion azp();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a azq();

    boolean azr();

    SwanAppConfigData azs();

    @NonNull
    com.baidu.swan.apps.storage.b.c azt();

    String azu();

    String azv();

    String azw();

    SwanAppActivity azx();

    com.baidu.swan.apps.adaptation.b.d azy();

    @NonNull
    Pair<Integer, Integer> azz();

    void b(com.baidu.swan.apps.event.a.a aVar);

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void cU(Context context);

    void cV(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e mQ(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c oU(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c oV(String str);

    AbsoluteLayout oW(String str);

    void showLoadingView();

    void w(Intent intent);
}
