package c.a.s0.a.g1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import c.a.s0.a.g1.e;
import c.a.s0.a.p.b.a.k;
import c.a.s0.a.p.b.a.n;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes.dex */
public interface d extends e.b {
    c.a.s0.a.p.e.d A(String str);

    View B(String str);

    String C();

    c.a.s0.a.d2.e D();

    void E(c.a.s0.a.f1.e.b bVar, c.a.s0.a.a1.b bVar2);

    k F();

    @NonNull
    c.a.s0.a.o2.f.d G();

    c.a.s0.a.h0.g.f H();

    void I();

    SwanAppPropertyWindow J(Activity activity);

    void K(String str);

    n L();

    SwanCoreVersion M();

    boolean N();

    void O();

    n P();

    void a();

    String b();

    void c();

    void d(c.a.s0.a.f1.e.b bVar, c.a.s0.a.a1.b bVar2);

    @NonNull
    c.a.s0.a.d2.n.g e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    c.a.s0.a.d2.n.g f(String str);

    String g();

    SwanAppActivity getActivity();

    c.a.s0.a.p.e.c i();

    @NonNull
    c.a.s0.a.d2.n.g j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, c.a.s0.a.o0.d.b bVar);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    c.a.s0.a.p.e.a q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(c.a.s0.a.o0.d.b bVar);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(c.a.s0.a.o0.d.e eVar, boolean z);

    String z();
}
