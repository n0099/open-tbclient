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
/* loaded from: classes3.dex */
public interface d extends e.b {
    FullScreenFloatView I(Activity activity);

    SwanAppPropertyWindow J(Activity activity);

    void YJ();

    @NonNull
    com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2);

    void a(com.baidu.swan.apps.event.a.d dVar, boolean z);

    void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void a(String str, com.baidu.swan.apps.event.a.a aVar);

    void abh();

    void abi();

    com.baidu.swan.apps.runtime.e agX();

    String ahG();

    com.baidu.swan.apps.core.d.e ahX();

    com.baidu.swan.games.view.d aiv();

    com.baidu.swan.games.view.d aiw();

    void ash();

    void asi();

    void asj();

    SwanCoreVersion ask();

    @DebugTrace
    com.baidu.swan.apps.adaptation.b.a asl();

    boolean asn();

    SwanAppConfigData aso();

    @NonNull
    com.baidu.swan.apps.storage.b.c asp();

    String asq();

    String asr();

    String ass();

    SwanAppActivity ast();

    com.baidu.swan.apps.adaptation.b.d asu();

    @NonNull
    Pair<Integer, Integer> asv();

    @NonNull
    Pair<Integer, Integer> asw();

    com.baidu.swan.games.q.a asx();

    boolean asz();

    void b(com.baidu.swan.apps.event.a.a aVar);

    void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2);

    void cb(Context context);

    void cc(Context context);

    void doRelease();

    void exit();

    void i(SwanAppActivity swanAppActivity);

    com.baidu.swan.apps.adaptation.b.e mn(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c os(String str);

    @NonNull
    com.baidu.swan.apps.runtime.config.c ot(String str);

    AbsoluteLayout ou(String str);

    void showLoadingView();

    void w(Intent intent);
}
