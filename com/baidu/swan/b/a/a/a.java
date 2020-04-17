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
import com.baidu.swan.apps.as.s;
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
    public com.baidu.swan.apps.api.b.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
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
            com.baidu.swan.apps.process.messaging.client.a akG = com.baidu.swan.apps.runtime.d.akK().akG();
            if (akG != null) {
                C0342a c0342a = new C0342a(optString2, optString, bVar);
                akG.a(bundle, com.baidu.swan.b.a.b.c.class, c0342a);
                akG.i(new b(c0342a));
            }
        }
        return null;
    }

    private void a(@NonNull Bundle bundle, @Nullable final String str, @NonNull final com.baidu.swan.apps.p.b bVar) {
        SwanAppActivity akJ = com.baidu.swan.apps.runtime.d.akK().akJ();
        if (akJ == null) {
            bVar.onFail(1001, "");
            return;
        }
        if (DEBUG) {
            Log.d("appManagerAction", "InstallAppDelegation handleInstall");
        }
        DelegateUtils.callOnMainWithActivity(akJ, PluginDelegateActivity.class, com.baidu.swan.b.a.c.b.class, bundle, new DelegateListener() { // from class: com.baidu.swan.b.a.a.a.1
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                if (a.DEBUG) {
                    Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",result:" + delegateResult.mResult);
                }
                String string = delegateResult.mResult.getString("packageName");
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, string)) {
                    if (com.baidu.swan.b.a.c.a.an(AppRuntime.getAppContext(), str)) {
                        bVar.V(new JSONObject());
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
    public static void a(@NonNull Bundle bundle, @NonNull com.baidu.swan.apps.p.b bVar) {
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
                bVar.V(s.parseString(string2));
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
    private static class C0342a extends com.baidu.swan.apps.process.a.b.c.c {
        private String cIr;
        private com.baidu.swan.apps.p.b cIs;
        private String mPackageName;

        C0342a(String str, String str2, com.baidu.swan.apps.p.b bVar) {
            this.mPackageName = str;
            this.cIr = str2;
            this.cIs = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.a.b.c.a
        public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
            Bundle result = bVar.getResult();
            if (this.cIs != null) {
                if (result != null) {
                    a.a(result, this.cIs);
                } else {
                    this.cIs.onFail(1001, "");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aji() {
            if (this.cIs != null) {
                this.cIs.onFail(31018, "download process is killed");
                a.h(this.mPackageName, this.cIr, 31018);
                this.cIs = null;
            }
        }

        @Override // com.baidu.swan.apps.process.a.b.c.a
        public boolean aiS() {
            return true;
        }

        @Override // com.baidu.swan.apps.process.a.b.c.a
        public long getTimeoutMillis() {
            return 0L;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private WeakReference<C0342a> cIt;

        b(C0342a c0342a) {
            this.cIt = new WeakReference<>(c0342a);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.DEBUG) {
                Log.d("appManagerAction", "onConnectionDown");
            }
            if (this.cIt.get() != null) {
                this.cIt.get().aji();
            }
        }
    }
}
