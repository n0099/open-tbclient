package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Bundle mParams = new Bundle();

    public void c(final com.baidu.swan.apps.a.a aVar) {
        SwanAppActivity aIl = com.baidu.swan.apps.runtime.d.aIn().aIl();
        final ViewGroup viewGroup = null;
        if (aIl != null && !aIl.isFinishing()) {
            viewGroup = (ViewGroup) aIl.findViewById(16908290);
            com.baidu.swan.apps.res.widget.loadingview.a.a(aIl, viewGroup, aIl.getResources().getString(b.g.swanapp_login_loading));
        }
        f.a(new com.baidu.swan.bdprivate.extensions.quicklogin.c() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.a.1
            @Override // com.baidu.swan.bdprivate.extensions.quicklogin.c
            public void a(QuickLoginInfo quickLoginInfo) {
                if (viewGroup != null) {
                    viewGroup.post(new Runnable() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.res.widget.loadingview.a.I(viewGroup);
                        }
                    });
                }
                if (a.this.b(quickLoginInfo)) {
                    a.this.mParams.putParcelable("quick_login_info", quickLoginInfo);
                }
                String ayC = com.baidu.swan.apps.runtime.d.aIn().aIj().aIv().ayC();
                String appId = com.baidu.swan.apps.runtime.d.aIn().getAppId();
                a.this.mParams.putString("app_name", com.baidu.swan.apps.runtime.d.aIn().aIj().getName());
                a.this.mParams.putString("appid", appId);
                a.this.mParams.putString("launch_from", ayC);
                if (a.DEBUG) {
                    Log.d("LoginAndGetMobile", "onQueryResult: mParams: " + a.this.mParams.toString());
                }
                d.g("show", OneKeyLoginSdkCall.k, null, ayC, appId);
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
        SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
        if (azx != null) {
            Intent intent = new Intent(azx, LoginAndGetMobileActivity.class);
            intent.putExtras(this.mParams);
            azx.startActivity(intent);
            azx.overridePendingTransition(b.a.login_get_mobile_act_enter, 0);
            c.g(aVar);
        }
    }

    private void f(final com.baidu.swan.apps.a.a aVar) {
        DelegateUtils.callOnMainWithActivity(com.baidu.swan.apps.v.f.azN().azx(), PluginDelegateActivity.class, b.class, this.mParams, new DelegateListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.a.2
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
