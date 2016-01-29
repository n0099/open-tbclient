package com.baidu.adp.plugin.proxy.activity;

import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.g;
/* loaded from: classes.dex */
public class ThirdActivityProxy extends ActivityProxy {
    @Override // com.baidu.adp.plugin.proxy.activity.ActivityProxy, com.baidu.adp.plugin.a.a
    public boolean proxyStopService(Intent intent) {
        String stringExtra = intent.getStringExtra("intent_extra_service");
        g.a aVar = null;
        if (stringExtra != null) {
            aVar = g.kU().bg(stringExtra);
        }
        if (aVar == null || aVar.Da == null) {
            BdLog.d("service stop error!" + intent.toString());
            return false;
        } else if (g.kU().kV() == 1) {
            g.kU().bh(stringExtra);
            aVar.Da.stopSelf();
            return true;
        } else {
            aVar.Da.onDestroy();
            g.kU().bh(stringExtra);
            return true;
        }
    }
}
