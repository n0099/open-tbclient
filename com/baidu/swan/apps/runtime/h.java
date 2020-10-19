package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public interface h {
    public static final Set<String> deG = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    SwanAppProcessInfo aBh();

    boolean aBi();

    boolean aBj();

    SwanAppCores aBk();

    com.baidu.swan.apps.process.messaging.client.a aCR();

    e aCS();

    void aCT();

    SwanAppActivity aCU();

    com.baidu.swan.apps.adaptation.a aCY();

    int abk();

    void e(Bundle bundle, String str);

    void f(String str, Bundle bundle);

    String getAppId();

    void i(i.a aVar);

    void j(SwanAppActivity swanAppActivity);

    void k(SwanAppActivity swanAppActivity);

    void rm(String str);

    void v(com.baidu.swan.apps.ap.e.b<i.a> bVar);

    void w(com.baidu.swan.apps.ap.e.b<i.a> bVar);

    String x(String... strArr);
}
