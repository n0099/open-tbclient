package com.baidu.swan.games.s;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.e;
import com.facebook.common.internal.i;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.schedulers.Schedulers;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.process.a.a.a implements com.baidu.swan.apps.process.messaging.service.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> dbi = i.O("event_puppet_unload_app", "event_puppet_offline");
    private static long dbj = TimeUnit.SECONDS.toMillis(10);
    private int dbk = SwanAppProcessInfo.UNKNOWN.index;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void A(@NonNull final Bundle bundle) {
        this.dbk = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
        final boolean checkProcessId = SwanAppProcessInfo.checkProcessId(this.dbk);
        if (DEBUG) {
            Log.i("SwanGameReloadDelegate", "execCall: target = " + this.dbk);
            Log.i("SwanGameReloadDelegate", "execCall: waitCallback = " + checkProcessId);
        }
        d.bR("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.games.s.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (checkProcessId) {
                    if (b.DEBUG) {
                        Log.i("SwanGameReloadDelegate", "execCall: addCallback CALLBACK_TERM = " + b.dbj);
                    }
                    e.anp().a(b.this, b.dbj);
                }
                com.baidu.swan.apps.env.c acw = com.baidu.swan.apps.env.e.acv().acw();
                if (acw != null) {
                    acw.i(Collections.singletonList(bundle.getString("appId")), true);
                }
                if (b.DEBUG) {
                    Log.i("SwanGameReloadDelegate", "execCall: addCallback purge finish = " + acw);
                }
                if (!checkProcessId) {
                    b.this.invoke();
                }
            }
        });
    }

    @Override // com.baidu.swan.apps.process.messaging.service.a
    public void b(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
        if (cVar.cud.index == this.dbk && dbi.contains(str)) {
            e.anp().a(this);
            if (DEBUG) {
                Log.i("SwanGameReloadDelegate", "onEvent: event = " + str);
            }
            invoke();
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.service.a
    public void agq() {
        if (DEBUG) {
            Log.i("SwanGameReloadDelegate", "timeout");
        }
        invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invoke() {
        String string = this.cth.getString(SuspensionBallEntity.KEY_SCHEME);
        if (DEBUG) {
            Log.i("SwanGameReloadDelegate", "invoke: scheme = " + string);
        }
        if (!TextUtils.isEmpty(string)) {
            SchemeRouter.invoke(AppRuntime.getAppContext(), string);
        }
    }
}
