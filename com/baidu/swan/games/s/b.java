package com.baidu.swan.games.s;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.e;
import com.facebook.common.internal.i;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.schedulers.Schedulers;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.process.a.a.a implements com.baidu.swan.apps.process.messaging.service.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> dYe = i.N("event_puppet_unload_app", "event_puppet_offline");
    private static long dYf = TimeUnit.SECONDS.toMillis(10);
    private int dYg = SwanAppProcessInfo.UNKNOWN.index;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull final Bundle bundle) {
        this.dYg = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
        final boolean checkProcessId = SwanAppProcessInfo.checkProcessId(this.dYg);
        if (DEBUG) {
            Log.i("SwanGameReloadDelegate", "execCall: target = " + this.dYg);
            Log.i("SwanGameReloadDelegate", "execCall: waitCallback = " + checkProcessId);
        }
        d.cd("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.games.s.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (checkProcessId) {
                    if (b.DEBUG) {
                        Log.i("SwanGameReloadDelegate", "execCall: addCallback CALLBACK_TERM = " + b.dYf);
                    }
                    e.aFS().a(b.this, b.dYf);
                }
                com.baidu.swan.apps.env.c atj = com.baidu.swan.apps.env.e.ati().atj();
                if (atj != null) {
                    atj.b(Collections.singletonList(bundle.getString("appId")), true, com.baidu.swan.apps.env.c.c.atN().iv(6).atO());
                }
                if (b.DEBUG) {
                    Log.i("SwanGameReloadDelegate", "execCall: addCallback purge finish = " + atj);
                }
                if (!checkProcessId) {
                    b.this.invoke();
                }
            }
        });
    }

    @Override // com.baidu.swan.apps.process.messaging.service.a
    public void c(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
        if (cVar.dmc.index == this.dYg && dYe.contains(str)) {
            e.aFS().a(this);
            if (DEBUG) {
                Log.i("SwanGameReloadDelegate", "onEvent: event = " + str);
            }
            invoke();
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.service.a
    public void atn() {
        if (DEBUG) {
            Log.i("SwanGameReloadDelegate", "timeout");
        }
        invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invoke() {
        String string = this.dlg.getString("scheme");
        if (DEBUG) {
            Log.i("SwanGameReloadDelegate", "invoke: scheme = " + string);
        }
        if (!TextUtils.isEmpty(string)) {
            SchemeRouter.invoke(AppRuntime.getAppContext(), string);
        }
    }
}
