package c.a.n0.a.w0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import c.a.n0.a.f.b.a.k;
import c.a.n0.a.f.b.a.n;
import c.a.n0.a.w0.e;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes.dex */
public interface d extends e.b {
    c.a.n0.a.f.e.d A(String str);

    View B(String str);

    String C();

    c.a.n0.a.t1.e D();

    void E(c.a.n0.a.v0.e.b bVar, c.a.n0.a.q0.b bVar2);

    k F();

    @NonNull
    c.a.n0.a.e2.f.d G();

    c.a.n0.a.x.g.f H();

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

    void d(c.a.n0.a.v0.e.b bVar, c.a.n0.a.q0.b bVar2);

    @NonNull
    c.a.n0.a.t1.n.g e(String str, SwanAppConfigData swanAppConfigData, String str2);

    void exit();

    @NonNull
    c.a.n0.a.t1.n.g f(String str);

    String g();

    SwanAppActivity getActivity();

    c.a.n0.a.f.e.c i();

    @NonNull
    c.a.n0.a.t1.n.g j(String str);

    boolean k();

    void l(SwanAppActivity swanAppActivity);

    void m(String str, c.a.n0.a.e0.d.b bVar);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    c.a.n0.a.f.e.a q();

    @NonNull
    Pair<Integer, Integer> r();

    void registerReceiver(Context context);

    SwanAppConfigData s();

    void t(Intent intent);

    void u(c.a.n0.a.e0.d.b bVar);

    void unregisterReceiver(Context context);

    void v();

    void w();

    @NonNull
    Pair<Integer, Integer> x();

    void y(c.a.n0.a.e0.d.e eVar, boolean z);

    String z();
}
