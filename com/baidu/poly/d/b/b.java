package com.baidu.poly.d.b;

import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback;
import com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation;
/* loaded from: classes2.dex */
public class b extends PluginBaseDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation
    public String getPluginPackageName() {
        return "com.baidu.wallet";
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        String string = this.mParams.getString("params");
        this.mParams.getString("channel");
        AiAppsRuntime.getPolymerPayRuntime().doBaiduWalletPolymerPay(getAgent(), string, new PolymerPayCallback() { // from class: com.baidu.poly.d.b.b.1
            @Override // com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback
            public void onPolymerPayResult(int i, String str) {
                b.this.mResult.putInt("stateCode", i);
                b.this.mResult.putString("payDesc", str);
                b.this.finish();
            }
        });
        return false;
    }
}
