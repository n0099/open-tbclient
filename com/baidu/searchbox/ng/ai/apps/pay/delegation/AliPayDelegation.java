package com.baidu.searchbox.ng.ai.apps.pay.delegation;

import android.os.Bundle;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation;
/* loaded from: classes2.dex */
public class AliPayDelegation extends PluginBaseDelegation {
    private static final String BUNDLE_ORDER_INFO_KEY = "order_info";
    private static final boolean DEBUG = false;
    public static final String PACKAGE_NAME = "com.baidu.wallet";
    public static final String RESULT_CODE = "status_code";
    public static final String RESULT_DATA = "params";
    private static final String TAG = "AliPayDelegation";

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation
    public String getPluginPackageName() {
        return "com.baidu.wallet";
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (!this.mParams.isEmpty()) {
            AiAppsRuntime.getPaymentRuntime().aliPay(getAgent(), this.mParams.getString(BUNDLE_ORDER_INFO_KEY), new AliPayCallback() { // from class: com.baidu.searchbox.ng.ai.apps.pay.delegation.AliPayDelegation.1
                @Override // com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback
                public void onAliPayResult(int i, String str) {
                    AliPayDelegation.this.mResult.putInt("status_code", i);
                    AliPayDelegation.this.mResult.putString("params", str);
                    AliPayDelegation.this.finish();
                }
            });
            return false;
        }
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
    }

    public static Bundle createExecParams(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_ORDER_INFO_KEY, str);
        bundle.putBoolean(PluginDelegateActivity.ENABLE_FALLBACK_FINISH_KEY, false);
        return bundle;
    }
}
