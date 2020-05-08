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
    FullScreenFloatView K(Activity activity);

    SwanAppPropertyWindow L(Activity activity);

    com.baidu.swan.apps.core.d.e Ot();

    void Ow();

    void Qm();

    void Qn();

    String VP();

    com.baidu.swan.games.view.d WF();

    com.baidu.swan.games.view.d WG();

    com.baidu.swan.apps.core.d.d We();

    com.baidu.swan.apps.runtime.e Wq();

    void a(int i, @NonNull String[] strArr, c.a aVar);

    void a(com.baidu.swan.apps.n.a.a aVar);

    void a(com.baidu.swan.apps.n.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void a(String str, com.baidu.swan.apps.n.a.a aVar);

    void aek();

    void ael();

    SwanCoreVersion aem();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a aen();

    boolean aeo();

    SwanAppConfigData aep();

    @NonNull
    com.baidu.swan.apps.storage.b.c aeq();

    String aer();

    String aes();

    String aet();

    SwanAppActivity aeu();

    com.baidu.swan.apps.adaptation.b.d aev();

    @NonNull
    Pair<Integer, Integer> aew();

    @NonNull
    Pair<Integer, Integer> aex();

    com.baidu.swan.games.p.a aey();

    void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void bH(Context context);

    void bI(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e iI(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c ke(String str);

    AbsoluteLayout kf(String str);

    void showLoadingView();

    void v(Intent intent);
}
