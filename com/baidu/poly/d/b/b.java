package com.baidu.poly.d.b;

import com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation;
import com.baidu.swan.apps.aa.a.c;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.sina.weibo.sdk.statistic.LogBuilder;
/* loaded from: classes2.dex */
public class b extends PluginBaseDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation
    public String getPluginPackageName() {
        return "com.baidu.wallet";
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        String string = this.mParams.getString(LegoListActivityConfig.PARAMS);
        this.mParams.getString(LogBuilder.KEY_CHANNEL);
        com.baidu.swan.apps.u.a.Df().a(getAgent(), string, new c() { // from class: com.baidu.poly.d.b.b.1
            @Override // com.baidu.swan.apps.aa.a.c
            public void h(int i, String str) {
                b.this.mResult.putInt("stateCode", i);
                b.this.mResult.putString("payDesc", str);
                b.this.finish();
            }
        });
        return false;
    }
}
