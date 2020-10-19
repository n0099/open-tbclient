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

    void abv();

    void adT();

    void adU();

    com.baidu.swan.apps.runtime.e ajI();

    com.baidu.swan.apps.core.d.e akI();

    String akr();

    com.baidu.swan.games.view.d alg();

    com.baidu.swan.games.view.d alh();

    void auT();

    void auU();

    void auV();

    SwanCoreVersion auW();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a auX();

    boolean auY();

    SwanAppConfigData auZ();

    @NonNull
    com.baidu.swan.apps.storage.b.c ava();

    String avb();

    String avc();

    String avd();

    SwanAppActivity ave();

    com.baidu.swan.apps.adaptation.b.d avf();

    @NonNull
    Pair<Integer, Integer> avg();

    @NonNull
    Pair<Integer, Integer> avh();

    com.baidu.swan.games.q.a avi();

    boolean avk();

    void b(com.baidu.swan.apps.event.a.a aVar);

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void ch(Context context);

    void ci(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e mZ(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c pe(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c pf(String str);

    AbsoluteLayout pg(String str);

    void showLoadingView();

    void w(Intent intent);
}
