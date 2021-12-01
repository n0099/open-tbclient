package c.a.p0.a.g1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import c.a.p0.a.g1.e;
import c.a.p0.a.p.b.a.k;
import c.a.p0.a.p.b.a.n;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes.dex */
public interface d extends e.b {
    c.a.p0.a.p.e.d A(String str);

    View B(String str);

    String C();

    c.a.p0.a.d2.e D();

    void E(c.a.p0.a.f1.e.b bVar, c.a.p0.a.a1.b bVar2);

    k F();

    @NonNull
    c.a.p0.a.o2.f.d G();

    c.a.p0.a.h0.g.f H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    n L();

    SwanCoreVersion M();

    boolean N();

    void O();

    n P();

    String a();

    void b();

    void c(c.a.p0.a.f1.e.b bVar, c.a.p0.a.a1.b bVar2);

    @NonNull
    c.a.p0.a.d2.n.g d(String str, SwanAppConfigData swanAppConfigData, String str2);

    @NonNull
    c.a.p0.a.d2.n.g e(String str);

    void exit();

    String f();

    SwanAppActivity getActivity();

    c.a.p0.a.p.e.c h();

    @NonNull
    c.a.p0.a.d2.n.g i(String str);

    boolean j();

    void k(SwanAppActivity swanAppActivity);

    void l(String str, c.a.p0.a.o0.d.b bVar);

    FullScreenFloatView m(Activity activity);

    void n();

    void o();

    @DebugTrace
    c.a.p0.a.p.e.a p();

    @NonNull
    Pair<Integer, Integer> q();

    SwanAppConfigData r();

    void registerReceiver(Context context);

    void s(Intent intent);

    void t();

    void u(c.a.p0.a.o0.d.b bVar);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(c.a.p0.a.o0.d.e eVar, boolean z);

    String z();
}
