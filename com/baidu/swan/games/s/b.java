package com.baidu.swan.games.s;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.process.a.a.a implements com.baidu.swan.apps.process.messaging.service.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> ehG = i.R("event_puppet_unload_app", "event_puppet_offline");
    private static long ehH = TimeUnit.SECONDS.toMillis(10);
    private int ehI = SwanAppProcessInfo.UNKNOWN.index;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull final Bundle bundle) {
        this.ehI = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
        final boolean checkProcessId = SwanAppProcessInfo.checkProcessId(this.ehI);
        if (DEBUG) {
            Log.i("SwanGameReloadDelegate", "execCall: target = " + this.ehI);
            Log.i("SwanGameReloadDelegate", "execCall: waitCallback = " + checkProcessId);
        }
        d.bX("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.games.s.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (checkProcessId) {
                    if (b.DEBUG) {
                        Log.i("SwanGameReloadDelegate", "execCall: addCallback CALLBACK_TERM = " + b.ehH);
                    }
                    e.aFS().a(b.this, b.ehH);
                }
                com.baidu.swan.apps.env.c ati = com.baidu.swan.apps.env.e.ath().ati();
                if (ati != null) {
                    ati.b(Collections.singletonList(bundle.getString("appId")), true, com.baidu.swan.apps.env.c.c.atM().he(6).atN());
                }
                if (b.DEBUG) {
                    Log.i("SwanGameReloadDelegate", "execCall: addCallback purge finish = " + ati);
                }
                if (!checkProcessId) {
                    b.this.invoke();
                }
            }
        });
    }

    @Override // com.baidu.swan.apps.process.messaging.service.a
    public void c(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
        if (cVar.drF.index == this.ehI && ehG.contains(str)) {
            e.aFS().a(this);
            if (DEBUG) {
                Log.i("SwanGameReloadDelegate", "onEvent: event = " + str);
            }
            invoke();
        }
    }

    @Override // com.baidu.swan.apps.process.messaging.service.a
    public void atm() {
        if (DEBUG) {
            Log.i("SwanGameReloadDelegate", "timeout");
        }
        invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invoke() {
        String string = this.dqI.getString("scheme");
        if (DEBUG) {
            Log.i("SwanGameReloadDelegate", "invoke: scheme = " + string);
        }
        if (!TextUtils.isEmpty(string)) {
            SchemeRouter.invoke(AppRuntime.getAppContext(), string);
        }
    }
}
