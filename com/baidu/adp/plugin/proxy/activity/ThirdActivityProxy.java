package com.baidu.adp.plugin.proxy.activity;

import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.d;
/* loaded from: classes.dex */
public class ThirdActivityProxy extends ActivityProxy {
    @Override // com.baidu.adp.plugin.proxy.activity.ActivityProxy, com.baidu.adp.plugin.a.a
    public boolean proxyStopService(Intent intent) {
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
        d.a aVar = null;
        if (stringExtra != null) {
            aVar = d.nk().ce(stringExtra);
        }
        if (aVar == null || aVar.Qf == null) {
            BdLog.d("service stop error!" + intent.toString());
            return false;
        } else if (d.nk().nl() == 1) {
            d.nk().cf(stringExtra);
            aVar.Qf.stopSelf();
            return true;
        } else {
            aVar.Qf.onDestroy();
            d.nk().cf(stringExtra);
            return true;
        }
    }
}
