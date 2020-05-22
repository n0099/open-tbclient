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

    void QK();

    void SQ();

    void SR();

    String YB();

    com.baidu.swan.apps.core.d.d YQ();

    com.baidu.swan.apps.runtime.e Zc();

    com.baidu.swan.games.view.d Zr();

    com.baidu.swan.games.view.d Zs();

    void a(int i, @NonNull String[] strArr, c.a aVar);

    void a(com.baidu.swan.apps.event.a.a aVar);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    SwanAppConfigData ahA();

    @NonNull
    com.baidu.swan.apps.storage.b.c ahB();

    String ahC();

    String ahD();

    String ahE();

    SwanAppActivity ahF();

    com.baidu.swan.apps.adaptation.b.d ahG();

    @NonNull
    Pair<Integer, Integer> ahH();

    @NonNull
    Pair<Integer, Integer> ahI();

    com.baidu.swan.games.q.a ahJ();

    boolean ahL();

    void ahu();

    void ahv();

    void ahw();

    SwanCoreVersion ahx();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a ahy();

    boolean ahz();

    void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2);

    void bS(Context context);

    void bT(Context context);

    void doRelease();

    void exit();

    void h(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e jO(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c lq(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c lr(String str);

    AbsoluteLayout ls(String str);

    void showLoadingView();

    void u(Intent intent);
}
