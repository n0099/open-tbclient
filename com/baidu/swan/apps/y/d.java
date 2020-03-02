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
    com.baidu.swan.apps.core.d.e GC();

    void GF();

    void Iy();

    void Iz();

    void J(Intent intent);

    String NZ();

    FullScreenFloatView O(Activity activity);

    com.baidu.swan.apps.runtime.e OA();

    com.baidu.swan.games.view.d OO();

    com.baidu.swan.games.view.d OP();

    com.baidu.swan.apps.core.d.d Oo();

    SwanAppPropertyWindow P(Activity activity);

    String WA();

    String WB();

    String WC();

    SwanAppActivity WD();

    com.baidu.swan.apps.adaptation.b.d WE();

    @NonNull
    Pair<Integer, Integer> WF();

    @NonNull
    Pair<Integer, Integer> WG();

    com.baidu.swan.games.p.a WH();

    void Wt();

    void Wu();

    SwanCoreVersion Wv();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a Ww();

    boolean Wx();

    SwanAppConfigData Wy();

    @NonNull
    com.baidu.swan.apps.storage.b.c Wz();

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
