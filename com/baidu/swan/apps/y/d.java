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
/* loaded from: classes10.dex */
public interface d extends e.b {
    com.baidu.swan.apps.core.d.e El();

    void Eo();

    void Gh();

    void Gi();

    void J(Intent intent);

    String LJ();

    com.baidu.swan.apps.core.d.d LY();

    com.baidu.swan.apps.runtime.e Mk();

    com.baidu.swan.games.view.d My();

    com.baidu.swan.games.view.d Mz();

    FullScreenFloatView N(Activity activity);

    SwanAppPropertyWindow O(Activity activity);

    void Ud();

    void Ue();

    SwanCoreVersion Uf();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a Ug();

    boolean Uh();

    SwanAppConfigData Ui();

    @NonNull
    com.baidu.swan.apps.storage.b.c Uj();

    String Uk();

    String Ul();

    String Um();

    SwanAppActivity Un();

    com.baidu.swan.apps.adaptation.b.d Uo();

    @NonNull
    Pair<Integer, Integer> Up();

    @NonNull
    Pair<Integer, Integer> Uq();

    com.baidu.swan.games.p.a Ur();

    void a(int i, @NonNull String[] strArr, c.a aVar);

    void a(com.baidu.swan.apps.n.a.a aVar);

    void a(com.baidu.swan.apps.n.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void a(String str, com.baidu.swan.apps.n.a.a aVar);

    void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2);

    void cc(Context context);

    void cd(Context context);

    void doRelease();

    void exit();

    com.baidu.swan.apps.adaptation.b.e hg(String str);

    void i(SwanAppActivity swanAppActivity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c iD(String str);

    AbsoluteLayout iE(String str);

    void showLoadingView();
}
