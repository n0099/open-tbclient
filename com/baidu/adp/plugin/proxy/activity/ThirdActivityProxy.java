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
            aVar = d.io().bc(stringExtra);
        }
        if (aVar == null || aVar.AF == null) {
            BdLog.d("service stop error!" + intent.toString());
            return false;
        } else if (d.io().ip() == 1) {
            d.io().bd(stringExtra);
            aVar.AF.stopSelf();
            return true;
        } else {
            aVar.AF.onDestroy();
            d.io().bd(stringExtra);
            return true;
        }
    }
}
