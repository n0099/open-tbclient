package com.baidu.swan.games.x;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.v.d;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void b(com.baidu.smallgame.sdk.b.b bVar) {
        V8ExceptionInfo acP;
        if (bVar != null && (acP = bVar.acP()) != null) {
            String str = acP.exceptionMsg;
            String str2 = acP.exceptionTrace;
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                if (DEBUG) {
                    Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(com.baidu.swan.games.glsurface.a.b.aTs()), TimeUtils.logTimeOfDay(acP.exceptionTime)));
                }
                if (acP.exceptionTime < com.baidu.swan.games.glsurface.a.b.aTs()) {
                    a aVar = new a();
                    aVar.mType = "stuck";
                    aVar.mValue = "jserror";
                    aVar.mAppId = e.aEW();
                    if (e.aEU() != null && e.aEU().ado() != null) {
                        b.a ado = e.aEU().ado();
                        aVar.mSource = ado.awd();
                        aVar.mFrom = h.ko(ado.getAppFrameType());
                    }
                    aVar.errMsg = str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2;
                    aVar.dTy = d.aUD() ? 20 : 10;
                    aVar.dTG = com.baidu.swan.games.glsurface.a.b.aTr();
                    aVar.dTH = System.currentTimeMillis() - acP.exceptionTime;
                    a(aVar);
                }
            }
        }
    }

    private static void a(final a aVar) {
        if (aVar != null) {
            com.baidu.swan.apps.process.messaging.client.a.aCO().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.games.x.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    int i = -1;
                    if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
                        i = -2;
                    } else if (bVar.getResult() != null) {
                        i = bVar.getResult().getInt("net_quality");
                    }
                    if (b.DEBUG) {
                        Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                    }
                    a.this.dTF = i;
                    h.a("976", a.this);
                }
            });
        }
    }
}
