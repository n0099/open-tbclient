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
/* loaded from: classes9.dex */
public interface d extends e.b {
    FullScreenFloatView H(Activity activity);

    SwanAppPropertyWindow I(Activity activity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    void aDf();

    void aDg();

    void aDh();

    SwanCoreVersion aDi();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a aDj();

    boolean aDk();

    SwanAppConfigData aDl();

    @NonNull
    com.baidu.swan.apps.storage.b.c aDm();

    String aDn();

    String aDo();

    String aDp();

    SwanAppActivity aDq();

    com.baidu.swan.apps.adaptation.b.d aDr();

    @NonNull
    Pair<Integer, Integer> aDs();

    @NonNull
    Pair<Integer, Integer> aDt();

    com.baidu.swan.games.q.a aDu();

    boolean aDw();

    void ajv();

    void alX();

    void alY();

    com.baidu.swan.apps.runtime.e arO();

    String asD();

    com.baidu.swan.apps.core.d.e asU();

    com.baidu.swan.games.view.d ats();

    com.baidu.swan.games.view.d att();

    void b(com.baidu.swan.apps.event.a.a aVar);

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void cV(Context context);

    void cW(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e ob(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c qf(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c qg(String str);

    AbsoluteLayout qh(String str);

    void showLoadingView();

    void w(Intent intent);
}
