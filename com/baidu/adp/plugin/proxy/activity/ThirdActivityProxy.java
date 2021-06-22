package com.baidu.adp.plugin.proxy.activity;

import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import d.a.c.h.d;
/* loaded from: classes.dex */
public class ThirdActivityProxy extends ActivityProxy {
    @Override // com.baidu.adp.plugin.proxy.activity.ActivityProxy, d.a.c.h.f.a
    public boolean proxyStopService(Intent intent) {
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
        d.a c2 = stringExtra != null ? d.a().c(stringExtra) : null;
        if (c2 != null && c2.f42829a != null) {
            if (d.a().b() == 1) {
                d.a().e(stringExtra);
                c2.f42829a.stopSelf();
                return true;
            }
            c2.f42829a.onDestroy();
            d.a().e(stringExtra);
            return true;
        }
        BdLog.d("service stop error!" + intent.toString());
        return false;
    }
}
