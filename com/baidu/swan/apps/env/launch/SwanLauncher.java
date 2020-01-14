package com.baidu.swan.apps.env.launch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.x.b.e;
import com.baidu.swan.games.utils.so.d;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import rx.b;
import rx.k;
/* loaded from: classes10.dex */
public final class SwanLauncher {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final a bpU = new c(0);
    private static final a bpV = new c(1);
    private static final a bpW = new a() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(final rx.c cVar) {
            com.baidu.swan.apps.w.a.Sy().Ge();
            if (isChecked()) {
                cVar.onCompleted();
            } else if (com.baidu.swan.apps.w.a.Ss().Gn()) {
                Pr();
                cVar.onCompleted();
            } else {
                com.baidu.swan.apps.w.a.Ss().a(new com.baidu.swan.apps.core.j.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.4.1
                    @Override // com.baidu.swan.apps.core.j.c
                    public void onSuccess() {
                        Pr();
                        cVar.onCompleted();
                    }

                    @Override // com.baidu.swan.apps.core.j.c
                    public void onFail() {
                        cVar.onError(new T7CheckException());
                    }

                    @Override // com.baidu.swan.apps.core.j.c
                    public void onProgress(long j, long j2) {
                        if (SwanLauncher.DEBUG) {
                            Log.i("SwanLauncher", "安装Sailor中：sum:" + j2 + ", current:" + j);
                        }
                    }
                });
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        public static final SwanLauncher bqe = new SwanLauncher();
    }

    public static SwanLauncher Pq() {
        return b.bqe;
    }

    private SwanLauncher() {
    }

    public void a(e eVar, Bundle bundle) {
        if (eVar != null && !TextUtils.isEmpty(eVar.getAppId())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", eVar.getAppId());
            bundle2.putAll(eVar.toBundle());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            s(bundle2);
        }
    }

    public void s(final Bundle bundle) {
        if (bundle != null) {
            bundle.putLong("launch_time", System.currentTimeMillis());
            final String string = bundle.getString("mAppId");
            if (!TextUtils.isEmpty(string)) {
                bundle.putBoolean("console_switch", com.baidu.swan.apps.console.b.gi(com.baidu.swan.apps.e.a.fT(string)));
                u(bundle);
                if (!ProcessUtils.isMainProcess()) {
                    t(bundle);
                    return;
                }
                bundle.putLong("launch_time_on_main", System.currentTimeMillis());
                final com.baidu.swan.apps.process.messaging.service.c ki = com.baidu.swan.apps.process.messaging.service.e.Ze().ki(string);
                ki.kg(string);
                if (DEBUG) {
                    Log.d("SwanLauncher", "onReady processId: " + ki.bFt + " ,client:" + ki.toString());
                }
                final int v = v(bundle);
                if (v < 0) {
                    v = 0;
                }
                rx.c cVar = new rx.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.1
                    @Override // rx.c
                    public void onCompleted() {
                        SwanLauncher.this.a(ki, bundle, v);
                    }

                    @Override // rx.c
                    public void onError(Throwable th) {
                        SwanLauncher.this.a(th, v, string);
                    }

                    @Override // rx.c
                    public void onSubscribe(k kVar) {
                    }
                };
                a[] aVarArr = new a[2];
                aVarArr[0] = bpW;
                aVarArr[1] = 1 == v ? bpV : bpU;
                a(cVar, aVarArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.swan.apps.process.messaging.service.c cVar, Bundle bundle, int i) {
        JSONObject jSONObject;
        if (DEBUG) {
            Log.d("SwanLauncher", "onUpdateFinished() SwanCoreVersion: " + com.baidu.swan.apps.swancore.b.gj(i));
            Log.d("SwanLauncher", "onUpdateFinished() ExtensionCoreVersion: " + com.baidu.swan.apps.extcore.b.ey(i));
        }
        if (com.baidu.swan.apps.swancore.b.ade()) {
            com.baidu.swan.apps.swancore.c.a.adk();
        }
        bundle.putParcelable("swanCoreVersion", com.baidu.swan.apps.swancore.b.gj(i));
        bundle.putParcelable("extensionCore", com.baidu.swan.apps.extcore.b.ey(i));
        Bundle d = com.baidu.swan.apps.ah.a.a.d(com.baidu.swan.apps.x.b.c.C(bundle));
        if (d != null) {
            bundle.putAll(d);
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 == null) {
            bundle2 = new Bundle();
            bundle.putBundle("mExtraData", bundle2);
        }
        bundle2.putLong("launch_flag_for_statistic", System.currentTimeMillis());
        bundle2.putLong("page_display_flag_for_statistic", System.currentTimeMillis());
        String string = bundle2.getString("ubc");
        if (TextUtils.isEmpty(string)) {
            jSONObject = com.baidu.swan.d.b.a(bundle.getString("mFrom"), null, "pre_source");
        } else {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e) {
                jSONObject = new JSONObject();
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        bundle2.putString("ubc", jSONObject.toString());
        com.baidu.swan.apps.process.messaging.service.b.J(bundle);
        d.S(bundle);
        Context appContext = AppRuntime.getAppContext();
        Intent intent = new Intent(appContext, cVar.YR().activity);
        intent.addFlags(268435456);
        intent.putExtras(bundle);
        intent.putExtra("start_activity_time", System.currentTimeMillis());
        appContext.startActivity(intent);
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.2
            @Override // java.lang.Runnable
            public void run() {
                cVar.YY();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th, int i, String str) {
        boolean z = th instanceof T7CheckException;
        com.baidu.swan.apps.x.a.a.a(AppRuntime.getAppContext(), new com.baidu.swan.apps.ap.a().aE(z ? 15L : 9L).aF(z ? 42L : 25L).mj(z ? "Sailor安装失败" : "Swan core 更新出错"), i, str);
    }

    private void t(Bundle bundle) {
        Context appContext = AppRuntime.getAppContext();
        Intent intent = new Intent(appContext, SwanAppLauncherActivity.class);
        intent.addFlags(268435456);
        intent.putExtras(bundle);
        appContext.startActivity(intent);
    }

    public static String u(@NonNull Bundle bundle) {
        String string = bundle.getString("launch_id");
        if (TextUtils.isEmpty(string)) {
            String uuid = UUID.randomUUID().toString();
            bundle.putString("launch_id", uuid);
            return uuid;
        }
        return string;
    }

    private static int v(@NonNull Bundle bundle) {
        int i = bundle.getInt("appFrameType", -1);
        if (i > -1) {
            return i;
        }
        return -1;
    }

    /* loaded from: classes10.dex */
    private static class c extends a {
        final int bqf;

        c(int i) {
            super();
            this.bqf = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(final rx.c cVar) {
            if (isChecked()) {
                cVar.onCompleted();
            } else {
                com.baidu.swan.apps.extcore.cores.a.PB().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.c.1
                    @Override // com.baidu.swan.apps.extcore.c.a
                    public void Ps() {
                        c.this.Pr();
                        cVar.onCompleted();
                    }
                }, this.bqf);
            }
        }
    }

    public void initEnv() {
        a(new rx.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.3
            @Override // rx.c
            public void onCompleted() {
                if (SwanLauncher.DEBUG) {
                    Log.i("SwanLauncher", "init onCompleted: ");
                }
            }

            @Override // rx.c
            public void onError(Throwable th) {
                if (SwanLauncher.DEBUG) {
                    Log.i("SwanLauncher", "init onError: " + th);
                }
            }

            @Override // rx.c
            public void onSubscribe(k kVar) {
                if (SwanLauncher.DEBUG) {
                    Log.i("SwanLauncher", "init onSubscribe: " + kVar);
                }
            }
        }, bpW, bpU, bpV);
    }

    private void a(@NonNull rx.c cVar, a... aVarArr) {
        if (DEBUG) {
            Log.i("SwanLauncher", "checkEnv: checkers=" + aVarArr);
        }
        if (aVarArr == null || aVarArr.length < 1) {
            cVar.onCompleted();
            return;
        }
        ArrayList arrayList = null;
        for (a aVar : aVarArr) {
            if (DEBUG) {
                Log.i("SwanLauncher", "checkEnv: checker=" + aVar);
            }
            if (aVar != null && !aVar.isChecked()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(rx.b.a(aVar));
            }
        }
        if (DEBUG) {
            Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
        }
        if (arrayList == null || arrayList.isEmpty()) {
            cVar.onCompleted();
        } else {
            rx.b.k(arrayList).b(rx.a.b.a.dMO()).a(rx.a.b.a.dMO()).c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static abstract class a implements b.a {
        private boolean checked;

        private a() {
            this.checked = false;
        }

        protected void Pr() {
            this.checked = true;
        }

        public boolean isChecked() {
            return this.checked;
        }

        @NonNull
        public String toString() {
            return super.toString() + " checked=" + this.checked;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class T7CheckException extends Exception {
        private T7CheckException() {
        }
    }
}
