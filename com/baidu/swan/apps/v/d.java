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
/* loaded from: classes7.dex */
public interface d extends e.b {
    FullScreenFloatView H(Activity activity);

    SwanAppPropertyWindow I(Activity activity);

    void Sf();

    void Uw();

    void Ux();

    @NonNull
    com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2);

    void a(com.baidu.swan.apps.event.a.a aVar);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    String aaL();

    com.baidu.swan.apps.runtime.e aad();

    com.baidu.swan.games.view.d abA();

    com.baidu.swan.apps.core.d.e aba();

    com.baidu.swan.games.view.d abz();

    void ajQ();

    void ajR();

    void ajS();

    SwanCoreVersion ajT();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a ajU();

    boolean ajV();

    SwanAppConfigData ajW();

    @NonNull
    com.baidu.swan.apps.storage.b.c ajX();

    String ajY();

    String ajZ();

    String aka();

    SwanAppActivity akb();

    com.baidu.swan.apps.adaptation.b.d akc();

    @NonNull
    Pair<Integer, Integer> akd();

    @NonNull
    Pair<Integer, Integer> ake();

    com.baidu.swan.games.q.a akf();

    boolean akh();

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void bW(Context context);

    void bX(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e kq(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c lZ(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c ma(String str);

    AbsoluteLayout mb(String str);

    void showLoadingView();

    void u(Intent intent);
}
