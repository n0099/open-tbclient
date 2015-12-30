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
            aVar = g.kK().bg(stringExtra);
        }
        if (aVar == null || aVar.CQ == null) {
            BdLog.d("service stop error!" + intent.toString());
            return false;
        } else if (g.kK().kL() == 1) {
            g.kK().bh(stringExtra);
            aVar.CQ.stopSelf();
            return true;
        } else {
            aVar.CQ.onDestroy();
            g.kK().bh(stringExtra);
            return true;
        }
    }
}
