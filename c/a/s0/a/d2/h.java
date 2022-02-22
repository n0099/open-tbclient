package c.a.s0.a.d2;

import android.os.Bundle;
import c.a.s0.a.d2.i;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public interface h {
    public static final Set<String> o0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(i.a aVar);

    c.a.s0.a.f2.f.f0.a B();

    boolean D();

    void F();

    String getAppId();

    int l();

    void m(Bundle bundle, String str);

    SwanAppCores n();

    String o(String... strArr);

    void p(c.a.s0.a.z2.g1.c<i.a> cVar);

    void q(String str);

    e r();

    void s(SwanAppActivity swanAppActivity);

    void t();

    void u(SwanAppActivity swanAppActivity);

    void v(c.a.s0.a.z2.g1.c<i.a> cVar);

    void w(String str, Bundle bundle);

    SwanAppActivity x();

    c.a.s0.a.p.a y();

    c.a.s0.a.y1.c.e.a z();
}
