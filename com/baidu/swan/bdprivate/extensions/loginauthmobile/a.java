package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ViewGroup;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.swan.bdprivate.extensions.quicklogin.f;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Bundle mParams = new Bundle();

    public void c(final com.baidu.swan.apps.a.a aVar) {
        SwanAppActivity aGG = com.baidu.swan.apps.runtime.d.aGI().aGG();
        final ViewGroup viewGroup = null;
        if (aGG != null && !aGG.isFinishing()) {
            viewGroup = (ViewGroup) aGG.findViewById(16908290);
            com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(aGG, viewGroup, aGG.getResources().getString(b.g.swanapp_login_loading));
        }
        f.a(new com.baidu.swan.bdprivate.extensions.quicklogin.c() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.a.1
            @Override // com.baidu.swan.bdprivate.extensions.quicklogin.c
            public void a(QuickLoginInfo quickLoginInfo) {
                if (viewGroup != null) {
                    viewGroup.post(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(viewGroup);
                        }
                    });
                }
                if (a.this.b(quickLoginInfo)) {
                    a.this.mParams.putParcelable("quick_login_info", quickLoginInfo);
                }
                String axV = com.baidu.swan.apps.runtime.d.aGI().aGE().aGQ().axV();
                String appId = com.baidu.swan.apps.runtime.d.aGI().getAppId();
                a.this.mParams.putString("app_name", com.baidu.swan.apps.runtime.d.aGI().aGE().getName());
                a.this.mParams.putString("appid", appId);
                a.this.mParams.putString("launch_from", axV);
                if (a.DEBUG) {
                    Log.d("LoginAndGetMobile", "onQueryResult: mParams: " + a.this.mParams.toString());
                }
                d.g("show", OneKeyLoginSdkCall.k, null, axV, appId);
                a.this.d(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(QuickLoginInfo quickLoginInfo) {
        return quickLoginInfo != null && quickLoginInfo.supportQuickLogin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.a.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            e(aVar);
        } else {
            f(aVar);
        }
    }

    private void e(com.baidu.swan.apps.a.a aVar) {
        SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
        if (ayQ != null) {
            Intent intent = new Intent(ayQ, LoginAndGetMobileActivity.class);
            intent.putExtras(this.mParams);
            ayQ.startActivity(intent);
            ayQ.overridePendingTransition(b.a.login_get_mobile_act_enter, 0);
            c.g(aVar);
        }
    }

    private void f(final com.baidu.swan.apps.a.a aVar) {
        DelegateUtils.callOnMainWithActivity(com.baidu.swan.apps.v.f.azg().ayQ(), PluginDelegateActivity.class, b.class, this.mParams, new DelegateListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.a.2
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                if (delegateResult.isOk()) {
                    aVar.onResult(delegateResult.mResult.getInt("loginStatusCode"));
                    return;
                }
                aVar.onResult(-2);
            }
        });
    }
}
