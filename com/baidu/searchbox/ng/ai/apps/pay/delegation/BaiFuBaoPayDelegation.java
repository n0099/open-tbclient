package com.baidu.searchbox.ng.ai.apps.pay.delegation;

import android.os.Bundle;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.pay.callback.BaiduPayCallback;
import com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation;
/* loaded from: classes2.dex */
public class BaiFuBaoPayDelegation extends PluginBaseDelegation {
    private static final String BUNDLE_ACTION_KEY = "action_key";
    private static final String BUNDLE_ORDER_INFO_KEY = "order_info";
    private static final boolean DEBUG = false;
    public static final String PACKAGE_NAME = "com.baidu.wallet";
    public static final String RESULT_CODE = "status_code";
    public static final String RESULT_DATA = "params";
    private static final String TAG = "BaiFuBaoPayDelegation";

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation
    public String getPluginPackageName() {
        return "com.baidu.wallet";
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (!this.mParams.isEmpty()) {
            AiAppsRuntime.getPaymentRuntime().baiduPay(getAgent(), this.mParams.getString(BUNDLE_ORDER_INFO_KEY), new BaiduPayCallback() { // from class: com.baidu.searchbox.ng.ai.apps.pay.delegation.BaiFuBaoPayDelegation.1
                @Override // com.baidu.searchbox.ng.ai.apps.pay.callback.BaiduPayCallback
                public void onBaiduPayResult(int i, String str) {
                    BaiFuBaoPayDelegation.this.mResult.putInt("status_code", i);
                    BaiFuBaoPayDelegation.this.mResult.putString("params", str);
                    BaiFuBaoPayDelegation.this.finish();
                }
            });
        }
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
    }

    public static Bundle createExecParams(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_ORDER_INFO_KEY, str);
        return bundle;
    }
}
