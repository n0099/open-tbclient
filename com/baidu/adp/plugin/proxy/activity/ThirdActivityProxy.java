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
            aVar = g.hS().aZ(stringExtra);
        }
        if (aVar == null || aVar.wo == null) {
            BdLog.d("service stop error!" + intent.toString());
            return false;
        } else if (g.hS().hT() == 1) {
            g.hS().ba(stringExtra);
            aVar.wo.stopSelf();
            return true;
        } else {
            aVar.wo.onDestroy();
            g.hS().ba(stringExtra);
            return true;
        }
    }
}
