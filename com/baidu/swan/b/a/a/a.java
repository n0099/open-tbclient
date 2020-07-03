package com.baidu.swan.b.a.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.t;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.b.d.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static ExecutorService sExecutorService = Executors.newSingleThreadExecutor();

    public a() {
        super("appDownloadManager");
    }

    @Override // com.baidu.swan.b.d.a
    public com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.n.b bVar) {
        if (DEBUG) {
            Log.d("appManagerAction", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString("operation");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        String optString2 = optJSONObject != null ? optJSONObject.optString("packageName") : null;
        Bundle bundle = new Bundle();
        bundle.putString("operation", optString);
        bundle.putString("data", optJSONObject == null ? "" : optJSONObject.toString());
        bundle.putString("ubc_params", new com.baidu.swan.b.a.f.a().toJsonString());
        if (TextUtils.equals(optString, "installApp")) {
            a(bundle, optString2, bVar);
        } else {
            com.baidu.swan.apps.process.messaging.client.a apD = com.baidu.swan.apps.runtime.d.apI().apD();
            if (apD != null) {
                C0410a c0410a = new C0410a(optString2, optString, bVar);
                apD.b(bundle, com.baidu.swan.b.a.b.c.class, c0410a);
                apD.i(new b(c0410a));
            }
        }
        return null;
    }

    private void a(@NonNull Bundle bundle, @Nullable final String str, @NonNull final com.baidu.swan.apps.n.b bVar) {
        SwanAppActivity apG = com.baidu.swan.apps.runtime.d.apI().apG();
        if (apG == null) {
            bVar.onFail(1001, "");
            return;
        }
        if (DEBUG) {
            Log.d("appManagerAction", "InstallAppDelegation handleInstall");
        }
        DelegateUtils.callOnMainWithActivity(apG, PluginDelegateActivity.class, com.baidu.swan.b.a.c.b.class, bundle, new DelegateListener() { // from class: com.baidu.swan.b.a.a.a.1
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                if (a.DEBUG) {
                    Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",result:" + delegateResult.mResult);
                }
                String string = delegateResult.mResult.getString("packageName");
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, string)) {
                    if (com.baidu.swan.b.a.c.a.ab(AppRuntime.getAppContext(), str)) {
                        bVar.ah(new JSONObject());
                    } else {
                        bVar.onFail(31003, "apk install cancel");
                    }
                } else if (delegateResult.isOk()) {
                    a.a(delegateResult.mResult, bVar);
                } else {
                    bVar.onFail(31003, "apk install cancel");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull Bundle bundle, @NonNull com.baidu.swan.apps.n.b bVar) {
        String string = bundle.getString("functionType");
        if (string == null) {
            bVar.onFail(1001, "");
            return;
        }
        String string2 = bundle.getString("resultData", "");
        int i = bundle.getInt("resultStatus", 1001);
        if (DEBUG) {
            Log.d("appManagerAction", "handleResult:function = " + string + ",result = " + string2);
        }
        char c = 65535;
        switch (string.hashCode()) {
            case -1013362275:
                if (string.equals("onFail")) {
                    c = 1;
                    break;
                }
                break;
            case -530890460:
                if (string.equals("onSuccess")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                bVar.ah(t.parseString(string2));
                return;
            case 1:
                bVar.onFail(i, string2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(String str, String str2, int i) {
        com.baidu.swan.b.a.f.c.a(str, str2, "fail", String.valueOf(i), null);
    }

    /* renamed from: com.baidu.swan.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0410a extends com.baidu.swan.apps.process.a.b.c.c {
        private String cXs;
        private com.baidu.swan.apps.n.b cXt;
        private String mPackageName;

        C0410a(String str, String str2, com.baidu.swan.apps.n.b bVar) {
            this.mPackageName = str;
            this.cXs = str2;
            this.cXt = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.a.b.c.a
        public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
            Bundle result = bVar.getResult();
            if (this.cXt != null) {
                if (result != null) {
                    a.a(result, this.cXt);
                } else {
                    this.cXt.onFail(1001, "");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aob() {
            if (this.cXt != null) {
                this.cXt.onFail(31018, "download process is killed");
                a.h(this.mPackageName, this.cXs, 31018);
                this.cXt = null;
            }
        }

        @Override // com.baidu.swan.apps.process.a.b.c.a
        public boolean anE() {
            return true;
        }

        @Override // com.baidu.swan.apps.process.a.b.c.a
        public long getTimeoutMillis() {
            return 0L;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private WeakReference<C0410a> cXu;

        b(C0410a c0410a) {
            this.cXu = new WeakReference<>(c0410a);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.DEBUG) {
                Log.d("appManagerAction", "onConnectionDown");
            }
            if (this.cXu.get() != null) {
                this.cXu.get().aob();
            }
        }
    }
}
