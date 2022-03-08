package c.a.p0.a.t1;

import android.os.Bundle;
import c.a.p0.a.t1.i;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public interface h {
    public static final Set<String> o0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(i.a aVar);

    c.a.p0.a.v1.f.f0.a B();

    boolean D();

    void F();

    String getAppId();

    int l();

    void m(Bundle bundle, String str);

    SwanAppCores n();

    String o(String... strArr);

    void p(c.a.p0.a.p2.g1.c<i.a> cVar);

    void q(String str);

    e r();

    void s(SwanAppActivity swanAppActivity);

    void t();

    void u(SwanAppActivity swanAppActivity);

    void v(c.a.p0.a.p2.g1.c<i.a> cVar);

    void w(String str, Bundle bundle);

    SwanAppActivity x();

    c.a.p0.a.f.a y();

    c.a.p0.a.o1.c.e.a z();
}
