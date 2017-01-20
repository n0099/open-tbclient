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
            aVar = g.hQ().aY(stringExtra);
        }
        if (aVar == null || aVar.wf == null) {
            BdLog.d("service stop error!" + intent.toString());
            return false;
        } else if (g.hQ().hR() == 1) {
            g.hQ().aZ(stringExtra);
            aVar.wf.stopSelf();
            return true;
        } else {
            aVar.wf.onDestroy();
            g.hQ().aZ(stringExtra);
            return true;
        }
    }
}
