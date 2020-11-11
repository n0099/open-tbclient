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
/* loaded from: classes10.dex */
public interface d extends e.b {
    FullScreenFloatView J(Activity activity);

    SwanAppPropertyWindow K(Activity activity);

    @NonNull
    com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    void afP();

    void ain();

    void aio();

    String aoL();

    com.baidu.swan.apps.runtime.e aoc();

    com.baidu.swan.games.view.d apB();

    com.baidu.swan.games.view.d apC();

    com.baidu.swan.apps.core.d.e apc();

    @NonNull
    Pair<Integer, Integer> azA();

    @NonNull
    Pair<Integer, Integer> azB();

    com.baidu.swan.games.q.a azC();

    boolean azE();

    void azn();

    void azo();

    void azp();

    SwanCoreVersion azq();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a azr();

    boolean azs();

    SwanAppConfigData azt();

    @NonNull
    com.baidu.swan.apps.storage.b.c azu();

    String azv();

    String azw();

    String azx();

    SwanAppActivity azy();

    com.baidu.swan.apps.adaptation.b.d azz();

    void b(com.baidu.swan.apps.event.a.a aVar);

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void ch(Context context);

    void ci(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e nH(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c pL(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c pM(String str);

    AbsoluteLayout pN(String str);

    void showLoadingView();

    void w(Intent intent);
}
