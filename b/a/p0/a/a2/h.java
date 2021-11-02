package b.a.p0.a.a2;

import android.os.Bundle;
import b.a.p0.a.a2.i;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public interface h {
    public static final Set<String> g0 = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    void A(i.a aVar);

    b.a.p0.a.c2.f.g0.a B();

    boolean C();

    String getAppId();

    int l();

    void m(Bundle bundle, String str);

    SwanAppCores n();

    String o(String... strArr);

    void p(b.a.p0.a.v2.e1.b<i.a> bVar);

    void q(String str);

    e r();

    void s(SwanAppActivity swanAppActivity);

    void t();

    void u(SwanAppActivity swanAppActivity);

    void v(b.a.p0.a.v2.e1.b<i.a> bVar);

    void w(String str, Bundle bundle);

    SwanAppActivity x();

    b.a.p0.a.p.a y();

    b.a.p0.a.v1.c.e.a z();
}
