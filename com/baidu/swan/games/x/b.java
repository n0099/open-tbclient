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
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void b(com.baidu.smallgame.sdk.b.b bVar) {
        V8ExceptionInfo RF;
        if (bVar != null && (RF = bVar.RF()) != null) {
            String str = RF.exceptionMsg;
            String str2 = RF.exceptionTrace;
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                if (DEBUG) {
                    Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(com.baidu.swan.games.glsurface.a.b.aFp()), TimeUtils.logTimeOfDay(RF.exceptionTime)));
                }
                if (RF.exceptionTime < com.baidu.swan.games.glsurface.a.b.aFp()) {
                    a aVar = new a();
                    aVar.mType = "stuck";
                    aVar.mValue = "jserror";
                    aVar.mAppId = e.arx();
                    if (e.arv() != null && e.arv().Se() != null) {
                        b.a Se = e.arv().Se();
                        aVar.mSource = Se.ajg();
                        aVar.mFrom = h.ho(Se.getAppFrameType());
                    }
                    aVar.errMsg = str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2;
                    aVar.dmQ = d.aGy() ? 20 : 10;
                    aVar.dmY = com.baidu.swan.games.glsurface.a.b.aFo();
                    aVar.dmZ = System.currentTimeMillis() - RF.exceptionTime;
                    a(aVar);
                }
            }
        }
    }

    private static void a(final a aVar) {
        if (aVar != null) {
            com.baidu.swan.apps.process.messaging.client.a.apG().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.games.x.b.1
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
                    a.this.dmX = i;
                    h.a("976", a.this);
                }
            });
        }
    }
}
