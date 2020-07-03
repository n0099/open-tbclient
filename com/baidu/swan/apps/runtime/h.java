package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public interface h {
    public static final Set<String> cEI = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    int RF();

    SwanAppProcessInfo aoi();

    boolean aoj();

    boolean aok();

    SwanAppCores aol();

    com.baidu.swan.apps.process.messaging.client.a apD();

    e apE();

    void apF();

    SwanAppActivity apG();

    com.baidu.swan.apps.adaptation.a apK();

    void d(Bundle bundle, String str);

    void g(String str, Bundle bundle);

    String getAppId();

    void i(SwanAppActivity swanAppActivity);

    void i(i.a aVar);

    void j(SwanAppActivity swanAppActivity);

    void n(com.baidu.swan.apps.aq.e.b<i.a> bVar);

    void nA(String str);

    void o(com.baidu.swan.apps.aq.e.b<i.a> bVar);

    String v(String... strArr);
}
