package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public interface h {
    public static final Set<String> dEs = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    String F(String... strArr);

    SwanAppProcessInfo aFW();

    boolean aFX();

    boolean aFY();

    SwanAppCores aFZ();

    com.baidu.swan.apps.process.messaging.client.a aIB();

    e aIC();

    void aID();

    SwanAppActivity aIE();

    com.baidu.swan.apps.adaptation.a aII();

    void e(Bundle bundle, String str);

    void g(String str, Bundle bundle);

    String getAppId();

    int getFrameType();

    void i(i.a aVar);

    void j(SwanAppActivity swanAppActivity);

    void k(SwanAppActivity swanAppActivity);

    void rz(String str);

    void v(com.baidu.swan.apps.ao.e.b<i.a> bVar);

    void w(com.baidu.swan.apps.ao.e.b<i.a> bVar);
}
