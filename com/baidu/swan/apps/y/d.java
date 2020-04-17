package com.baidu.swan.apps.y;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.y.e;
/* loaded from: classes11.dex */
public interface d extends e.b {
    void I(Intent intent);

    FullScreenFloatView K(Activity activity);

    SwanAppPropertyWindow L(Activity activity);

    com.baidu.swan.apps.core.d.e Ou();

    void Ox();

    void Qn();

    void Qo();

    String VQ();

    com.baidu.swan.games.view.d WG();

    com.baidu.swan.games.view.d WH();

    com.baidu.swan.apps.core.d.d Wf();

    com.baidu.swan.apps.runtime.e Wr();

    void a(int i, @NonNull String[] strArr, c.a aVar);

    void a(com.baidu.swan.apps.n.a.a aVar);

    void a(com.baidu.swan.apps.n.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void a(String str, com.baidu.swan.apps.n.a.a aVar);

    void ael();

    void aem();

    SwanCoreVersion aen();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a aeo();

    boolean aep();

    SwanAppConfigData aeq();

    @NonNull
    com.baidu.swan.apps.storage.b.c aer();

    String aes();

    String aet();

    String aeu();

    SwanAppActivity aev();

    com.baidu.swan.apps.adaptation.b.d aew();

    @NonNull
    Pair<Integer, Integer> aex();

    @NonNull
    Pair<Integer, Integer> aey();

    com.baidu.swan.games.p.a aez();

    void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void bT(Context context);

    void bU(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e iI(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c ke(String str);

    AbsoluteLayout kf(String str);

    void showLoadingView();
}
