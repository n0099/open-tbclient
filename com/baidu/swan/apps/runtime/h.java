package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public interface h {
    public static final Set<String> dCo = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    String F(String... strArr);

    SwanAppProcessInfo aFB();

    boolean aFC();

    boolean aFD();

    SwanAppCores aFE();

    com.baidu.swan.apps.process.messaging.client.a aIi();

    e aIj();

    void aIk();

    SwanAppActivity aIl();

    com.baidu.swan.apps.adaptation.a aIp();

    int afr();

    void e(Bundle bundle, String str);

    void g(String str, Bundle bundle);

    String getAppId();

    void i(i.a aVar);

    void j(SwanAppActivity swanAppActivity);

    void k(SwanAppActivity swanAppActivity);

    void rg(String str);

    void v(com.baidu.swan.apps.ao.e.b<i.a> bVar);

    void w(com.baidu.swan.apps.ao.e.b<i.a> bVar);
}
