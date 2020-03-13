package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.games.u.d;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void b(com.baidu.smallgame.sdk.b.b bVar) {
        V8ExceptionInfo Gg;
        if (bVar != null && (Gg = bVar.Gg()) != null) {
            String str = Gg.exceptionMsg;
            String str2 = Gg.exceptionTrace;
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                if (DEBUG) {
                    Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(com.baidu.swan.games.glsurface.a.b.aox()), TimeUtils.logTimeOfDay(Gg.exceptionTime)));
                }
                if (Gg.exceptionTime < com.baidu.swan.games.glsurface.a.b.aox()) {
                    a aVar = new a();
                    aVar.mType = "stuck";
                    aVar.mValue = "jserror";
                    aVar.mAppId = e.acH();
                    if (e.acF() != null && e.acF().GE() != null) {
                        b.a GE = e.acF().GE();
                        aVar.mSource = GE.VJ();
                        aVar.mFrom = f.gs(GE.getAppFrameType());
                    }
                    aVar.errMsg = str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str2;
                    aVar.csn = d.apF() ? 20 : 10;
                    aVar.csu = com.baidu.swan.games.glsurface.a.b.aow();
                    aVar.csv = System.currentTimeMillis() - Gg.exceptionTime;
                    a(aVar);
                }
            }
        }
    }

    private static void a(final a aVar) {
        if (aVar != null) {
            com.baidu.swan.apps.process.messaging.client.a.aaV().a(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.games.w.b.1
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
                    a.this.cst = i;
                    f.a("976", a.this);
                }
            });
        }
    }
}
