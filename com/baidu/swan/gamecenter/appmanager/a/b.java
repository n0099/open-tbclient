package com.baidu.swan.gamecenter.appmanager.a;

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
import com.baidu.swan.apps.ap.v;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.baidu.swan.gamecenter.c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static ExecutorService sExecutorService = Executors.newSingleThreadExecutor();

    public b() {
        super("appDownloadManager");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (DEBUG) {
            Log.d("appManagerAction", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString("operation");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        String optString2 = optJSONObject != null ? optJSONObject.optString("packageName") : null;
        Bundle bundle = new Bundle();
        bundle.putString("operation", optString);
        bundle.putString("data", optJSONObject == null ? "" : optJSONObject.toString());
        bundle.putString("ubc_params", new com.baidu.swan.gamecenter.appmanager.d.a().toJsonString());
        if (TextUtils.equals(optString, "installApp")) {
            a(bundle, optString2, bVar);
        } else {
            com.baidu.swan.apps.process.messaging.client.a aCR = com.baidu.swan.apps.runtime.d.aCW().aCR();
            if (aCR != null) {
                a aVar = new a(optString2, optString, bVar);
                aCR.b(bundle, com.baidu.swan.gamecenter.appmanager.download.d.class, aVar);
                aCR.f(new RunnableC0497b(aVar));
            }
        }
        return null;
    }

    private void a(@NonNull Bundle bundle, @Nullable final String str, @NonNull final com.baidu.swan.apps.o.b bVar) {
        SwanAppActivity aCU = com.baidu.swan.apps.runtime.d.aCW().aCU();
        if (aCU == null) {
            bVar.onFail(1001, "");
            return;
        }
        if (DEBUG) {
            Log.d("appManagerAction", "InstallAppDelegation handleInstall");
        }
        DelegateUtils.callOnMainWithActivity(aCU, PluginDelegateActivity.class, com.baidu.swan.gamecenter.appmanager.install.b.class, bundle, new DelegateListener() { // from class: com.baidu.swan.gamecenter.appmanager.a.b.1
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                if (b.DEBUG) {
                    Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",result:" + delegateResult.mResult);
                }
                String string = delegateResult.mResult.getString("packageName");
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, string)) {
                    if (com.baidu.swan.gamecenter.appmanager.install.a.al(AppRuntime.getAppContext(), str)) {
                        bVar.av(new JSONObject());
                    } else {
                        bVar.onFail(31003, "apk install cancel");
                    }
                } else if (delegateResult.isOk()) {
                    b.a(delegateResult.mResult, bVar);
                } else {
                    bVar.onFail(31003, "apk install cancel");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull Bundle bundle, @NonNull com.baidu.swan.apps.o.b bVar) {
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
                bVar.av(v.parseString(string2));
                return;
            case 1:
                bVar.onFail(i, string2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(String str, String str2, int i) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(str, str2, "fail", String.valueOf(i), null);
    }

    /* loaded from: classes6.dex */
    private static class a extends com.baidu.swan.apps.process.a.b.c.c {
        private String dBr;
        private com.baidu.swan.apps.o.b dBs;
        private String mPackageName;

        a(String str, String str2, com.baidu.swan.apps.o.b bVar) {
            this.mPackageName = str;
            this.dBr = str2;
            this.dBs = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.a.b.c.a
        public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
            Bundle result = bVar.getResult();
            if (this.dBs != null) {
                if (result != null) {
                    b.a(result, this.dBs);
                } else {
                    this.dBs.onFail(1001, "");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aAZ() {
            if (this.dBs != null) {
                this.dBs.onFail(31018, "download process is killed");
                b.i(this.mPackageName, this.dBr, 31018);
                this.dBs = null;
            }
        }

        @Override // com.baidu.swan.apps.process.a.b.c.a
        public boolean aAE() {
            return true;
        }

        @Override // com.baidu.swan.apps.process.a.b.c.a
        public long getTimeoutMillis() {
            return 0L;
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class RunnableC0497b implements Runnable {
        private WeakReference<a> dBt;

        RunnableC0497b(a aVar) {
            this.dBt = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.DEBUG) {
                Log.d("appManagerAction", "onConnectionDown");
            }
            if (this.dBt.get() != null) {
                this.dBt.get().aAZ();
            }
        }
    }
}
