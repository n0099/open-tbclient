package c.a.n0.a.g1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import c.a.n0.a.g1.e;
import c.a.n0.a.p.b.a.k;
import c.a.n0.a.p.b.a.n;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes.dex */
public interface d extends e.b {
    String A();

    c.a.n0.a.p.e.d B(String str);

    AbsoluteLayout C(String str);

    String D();

    void E(Context context);

    c.a.n0.a.a2.e F();

    void G(c.a.n0.a.f1.e.b bVar, c.a.n0.a.a1.b bVar2);

    k H();

    @NonNull
    c.a.n0.a.k2.f.d I();

    c.a.n0.a.h0.g.f J();

    void K();

    SwanAppPropertyWindow L(Activity activity);

    n M();

    SwanCoreVersion N();

    boolean O();

    void P();

    n Q();

    String a();

    void b();

    void c(c.a.n0.a.f1.e.b bVar, c.a.n0.a.a1.b bVar2);

    @NonNull
    c.a.n0.a.a2.n.g d(String str, SwanAppConfigData swanAppConfigData, String str2);

    @NonNull
    c.a.n0.a.a2.n.g e(String str);

    void exit();

    String f();

    SwanAppActivity getActivity();

    c.a.n0.a.p.e.c h();

    @NonNull
    c.a.n0.a.a2.n.g i(String str);

    boolean j();

    void k(Context context);

    void l(SwanAppActivity swanAppActivity);

    void m(String str, c.a.n0.a.o0.d.a aVar);

    FullScreenFloatView n(Activity activity);

    void o();

    void p();

    @DebugTrace
    c.a.n0.a.p.e.a q();

    @NonNull
    Pair<Integer, Integer> r();

    SwanAppConfigData s();

    void t(Intent intent);

    void u();

    void v(c.a.n0.a.o0.d.a aVar);

    void w();

    void x();

    @NonNull
    Pair<Integer, Integer> y();

    void z(c.a.n0.a.o0.d.d dVar, boolean z);
}
