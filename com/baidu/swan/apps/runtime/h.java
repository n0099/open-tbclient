package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public interface h {
    public static final Set<String> cHv = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    int RU();

    SwanAppProcessInfo apS();

    boolean apT();

    boolean apU();

    SwanAppCores apV();

    com.baidu.swan.apps.process.messaging.client.a arm();

    e arn();

    void aro();

    SwanAppActivity arp();

    com.baidu.swan.apps.adaptation.a art();

    void d(Bundle bundle, String str);

    void g(String str, Bundle bundle);

    String getAppId();

    void i(i.a aVar);

    void j(SwanAppActivity swanAppActivity);

    void k(SwanAppActivity swanAppActivity);

    void o(com.baidu.swan.apps.aq.e.b<i.a> bVar);

    void oi(String str);

    void p(com.baidu.swan.apps.aq.e.b<i.a> bVar);

    String v(String... strArr);
}
