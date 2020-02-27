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
    com.baidu.swan.apps.core.d.e GA();

    void GD();

    void Iw();

    void Ix();

    void J(Intent intent);

    String NX();

    FullScreenFloatView O(Activity activity);

    com.baidu.swan.games.view.d OM();

    com.baidu.swan.games.view.d ON();

    com.baidu.swan.apps.core.d.d Om();

    com.baidu.swan.apps.runtime.e Oy();

    SwanAppPropertyWindow P(Activity activity);

    String WA();

    SwanAppActivity WB();

    com.baidu.swan.apps.adaptation.b.d WC();

    @NonNull
    Pair<Integer, Integer> WD();

    @NonNull
    Pair<Integer, Integer> WE();

    com.baidu.swan.games.p.a WF();

    void Wr();

    void Ws();

    SwanCoreVersion Wt();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a Wu();

    boolean Wv();

    SwanAppConfigData Ww();

    @NonNull
    com.baidu.swan.apps.storage.b.c Wx();

    String Wy();

    String Wz();

    void a(int i, @NonNull String[] strArr, c.a aVar);

    void a(com.baidu.swan.apps.n.a.a aVar);

    void a(com.baidu.swan.apps.n.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void a(String str, com.baidu.swan.apps.n.a.a aVar);

    void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void cg(Context context);

    void ch(Context context);

    void doRelease();

    void exit();

    com.baidu.swan.apps.adaptation.b.e hv(String str);

    void i(SwanAppActivity swanAppActivity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c iS(String str);

    AbsoluteLayout iT(String str);

    void showLoadingView();
}
