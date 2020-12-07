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
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void b(com.baidu.smallgame.sdk.b.b bVar) {
        V8ExceptionInfo ahP;
        if (bVar != null && (ahP = bVar.ahP()) != null) {
            String str = ahP.exceptionMsg;
            String str2 = ahP.exceptionTrace;
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                if (DEBUG) {
                    Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(com.baidu.swan.games.glsurface.a.b.aYp()), TimeUtils.logTimeOfDay(ahP.exceptionTime)));
                }
                if (ahP.exceptionTime < com.baidu.swan.games.glsurface.a.b.aYp()) {
                    a aVar = new a();
                    aVar.mType = "stuck";
                    aVar.mValue = "jserror";
                    aVar.mAppId = e.aJW();
                    if (e.aJU() != null && e.aJU().aio() != null) {
                        b.a aio = e.aJU().aio();
                        aVar.mSource = aio.aBe();
                        aVar.mFrom = h.kS(aio.getAppFrameType());
                    }
                    aVar.errMsg = str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2;
                    aVar.eeH = d.aZA() ? 20 : 10;
                    aVar.eeP = com.baidu.swan.games.glsurface.a.b.aYo();
                    aVar.eeQ = System.currentTimeMillis() - ahP.exceptionTime;
                    a(aVar);
                }
            }
        }
    }

    private static void a(final a aVar) {
        if (aVar != null) {
            com.baidu.swan.apps.process.messaging.client.a.aHO().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.games.x.b.1
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
                    a.this.eeO = i;
                    h.a("976", a.this);
                }
            });
        }
    }
}
