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
    public static final Set<String> bPz = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    int Gz();

    SwanAppProcessInfo abk();

    boolean abl();

    boolean abm();

    SwanAppCores abn();

    com.baidu.swan.apps.process.messaging.client.a acB();

    e acC();

    void acD();

    SwanAppActivity acE();

    com.baidu.swan.apps.adaptation.a acH();

    void c(Bundle bundle, String str);

    void d(i.a aVar);

    void d(String str, Bundle bundle);

    void e(com.baidu.swan.apps.as.d.b<i.a> bVar);

    void f(com.baidu.swan.apps.as.d.b<i.a> bVar);

    String getAppId();

    void j(SwanAppActivity swanAppActivity);

    void k(SwanAppActivity swanAppActivity);

    void kK(String str);

    String v(String... strArr);
}
