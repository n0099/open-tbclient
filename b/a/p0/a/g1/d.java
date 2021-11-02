package b.a.p0.a.g1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import b.a.p0.a.g1.e;
import b.a.p0.a.p.b.a.k;
import b.a.p0.a.p.b.a.n;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes.dex */
public interface d extends e.b {
    b.a.p0.a.p.e.d A(String str);

    AbsoluteLayout B(String str);

    String C();

    b.a.p0.a.a2.e D();

    void E(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2);

    k F();

    @NonNull
    b.a.p0.a.k2.f.d G();

    b.a.p0.a.h0.g.f H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    n K();

    SwanCoreVersion L();

    boolean M();

    void N();

    n O();

    String a();

    void b();

    void c(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2);

    @NonNull
    b.a.p0.a.a2.n.g d(String str, SwanAppConfigData swanAppConfigData, String str2);

    @NonNull
    b.a.p0.a.a2.n.g e(String str);

    void exit();

    String f();

    SwanAppActivity getActivity();

    b.a.p0.a.p.e.c h();

    @NonNull
    b.a.p0.a.a2.n.g i(String str);

    boolean j();

    void k(SwanAppActivity swanAppActivity);

    void l(String str, b.a.p0.a.o0.d.a aVar);

    FullScreenFloatView m(Activity activity);

    void n();

    void o();

    @DebugTrace
    b.a.p0.a.p.e.a p();

    @NonNull
    Pair<Integer, Integer> q();

    SwanAppConfigData r();

    void registerReceiver(Context context);

    void s(Intent intent);

    void t();

    void u(b.a.p0.a.o0.d.a aVar);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(b.a.p0.a.o0.d.d dVar, boolean z);

    String z();
}
