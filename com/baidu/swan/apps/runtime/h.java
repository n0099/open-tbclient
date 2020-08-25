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
    public static final Set<String> cQu = new HashSet(Arrays.asList("update_tag_by_activity_on_create", "update_tag_by_activity_on_new_intent", "update_tag_by_activity_on_relaunch", "update_tag_by_remote_debug"));

    int XP();

    SwanAppProcessInfo axP();

    boolean axQ();

    boolean axR();

    SwanAppCores axS();

    e azA();

    void azB();

    SwanAppActivity azC();

    com.baidu.swan.apps.adaptation.a azG();

    com.baidu.swan.apps.process.messaging.client.a azz();

    void e(Bundle bundle, String str);

    void f(String str, Bundle bundle);

    String getAppId();

    void i(i.a aVar);

    void j(SwanAppActivity swanAppActivity);

    void k(SwanAppActivity swanAppActivity);

    void qg(String str);

    void v(com.baidu.swan.apps.ap.e.b<i.a> bVar);

    String w(String... strArr);

    void w(com.baidu.swan.apps.ap.e.b<i.a> bVar);
}
