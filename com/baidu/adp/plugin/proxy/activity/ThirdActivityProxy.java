package com.baidu.adp.plugin.proxy.activity;

import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.g;
/* loaded from: classes.dex */
public class ThirdActivityProxy extends ActivityProxy {
    @Override // com.baidu.adp.plugin.proxy.activity.ActivityProxy, com.baidu.adp.plugin.a.a
    public boolean proxyStopService(Intent intent) {
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
        g.a aVar = null;
        if (stringExtra != null) {
            aVar = g.gW().aX(stringExtra);
        }
        if (aVar == null || aVar.tx == null) {
            BdLog.d("service stop error!" + intent.toString());
            return false;
        } else if (g.gW().gX() == 1) {
            g.gW().aY(stringExtra);
            aVar.tx.stopSelf();
            return true;
        } else {
            aVar.tx.onDestroy();
            g.gW().aY(stringExtra);
            return true;
        }
    }
}
