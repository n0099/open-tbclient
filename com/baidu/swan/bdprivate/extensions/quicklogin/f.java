package com.baidu.swan.bdprivate.extensions.quicklogin;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.bdprivate.a.v;
/* loaded from: classes8.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(c cVar) {
        if (ProcessUtils.isMainProcess()) {
            b(cVar);
        } else {
            c(cVar);
        }
    }

    public static void b(final c cVar) {
        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new OneKeyLoginCallback() { // from class: com.baidu.swan.bdprivate.extensions.quicklogin.f.1
            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void available(OneKeyLoginResult oneKeyLoginResult) {
                if (oneKeyLoginResult == null) {
                    c.this.a(null);
                    return;
                }
                boolean z = oneKeyLoginResult.enable;
                String str = oneKeyLoginResult.operator;
                String str2 = oneKeyLoginResult.encryptPhoneNum;
                boolean z2 = oneKeyLoginResult.hasHistory;
                a aVar = new a();
                aVar.hL(z);
                aVar.uo(str);
                aVar.un(str2);
                aVar.hM(z2);
                char c = 65535;
                switch (str.hashCode()) {
                    case 2154:
                        if (str.equals("CM")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2161:
                        if (str.equals("CT")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2162:
                        if (str.equals("CU")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        aVar.kz(12);
                        break;
                    case 1:
                        aVar.kz(13);
                        break;
                    case 2:
                        aVar.kz(14);
                        break;
                }
                c.this.a(QuickLoginInfo.a(aVar));
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
                super.unAvailable(oneKeyLoginResult);
                c.this.a(null);
            }
        });
    }

    public static void c(final c cVar) {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs == null) {
            cVar.a(null);
            return;
        }
        com.baidu.swan.apps.process.messaging.client.a aIi = aIs.aIi();
        if (aIi == null) {
            cVar.a(null);
        } else {
            aIi.b(null, b.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.bdprivate.extensions.quicklogin.f.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    Bundle result = bVar.getResult();
                    if (result == null) {
                        c.this.a(null);
                        return;
                    }
                    result.setClassLoader(QuickLoginInfo.class.getClassLoader());
                    QuickLoginInfo quickLoginInfo = (QuickLoginInfo) result.getParcelable("quick_login_info_result");
                    if (quickLoginInfo == null) {
                        c.this.a(null);
                    } else {
                        c.this.a(quickLoginInfo);
                    }
                }
            });
        }
    }

    public static void a(Activity activity, int i, e eVar) {
        if (ProcessUtils.isMainProcess()) {
            b(activity, i, eVar);
        } else {
            c(activity, i, eVar);
        }
    }

    public static void b(final Activity activity, int i, final e eVar) {
        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new OneKeyLoginCallback() { // from class: com.baidu.swan.bdprivate.extensions.quicklogin.f.3
            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void available(OneKeyLoginResult oneKeyLoginResult) {
                v.aPb().a(activity, oneKeyLoginResult.sign, eVar);
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
                eVar.onResult(-1);
            }
        });
    }

    public static void c(Activity activity, int i, final e eVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("quick_login_mode", i);
        DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, d.class, bundle, new DelegateListener() { // from class: com.baidu.swan.bdprivate.extensions.quicklogin.f.4
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                Bundle bundle2 = delegateResult.mResult;
                if (e.this != null) {
                    e.this.onResult(u.a(bundle2, "quick_login", -1));
                }
            }
        });
    }
}
