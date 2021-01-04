package com.baidu.swan.apps.env.launch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.core.h.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.e;
import com.baidu.swan.games.utils.so.d;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import rx.b;
import rx.k;
/* loaded from: classes9.dex */
public final class SwanLauncher {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final a dci = new c(0);
    private static final a dcj = new c(1);
    private static final a dck = new a() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(final rx.c cVar) {
            com.baidu.swan.apps.t.a.aBk().alU();
            if (isChecked()) {
                cVar.onCompleted();
            } else if (com.baidu.swan.apps.t.a.aBe().ame()) {
                axg();
                cVar.onCompleted();
            } else {
                com.baidu.swan.apps.t.a.aBe().a(false, new com.baidu.swan.apps.core.k.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.5.1
                    @Override // com.baidu.swan.apps.core.k.c
                    public void onSuccess() {
                        axg();
                        cVar.onCompleted();
                    }

                    @Override // com.baidu.swan.apps.core.k.c
                    public void onFail() {
                        cVar.onError(new T7CheckException());
                    }
                });
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        public static final SwanLauncher dct = new SwanLauncher();
    }

    public static SwanLauncher axd() {
        return b.dct;
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
            t(bundle2);
        }
    }

    public void t(final Bundle bundle) {
        if (bundle != null) {
            bundle.putLong("launch_time", System.currentTimeMillis());
            bundle.putLong("box_cold_launch", com.baidu.swan.apps.t.a.aAD().ale());
            final String string = bundle.getString("mAppId");
            if (!TextUtils.isEmpty(string)) {
                if (!ProcessUtils.isMainProcess()) {
                    u(bundle);
                    return;
                }
                final int w = w(bundle);
                if (w < 0) {
                    w = 0;
                }
                final com.baidu.swan.apps.process.messaging.service.c rY = com.baidu.swan.apps.process.messaging.service.e.aJL().rY(string);
                rY.rW(string);
                if (com.baidu.swan.apps.performance.b.c.aHU() && rY.aJC()) {
                    rY.aJB();
                    if (DEBUG) {
                        Log.d("SwanLauncher", "prevent series launch this swan app, time interval = " + com.baidu.swan.apps.performance.b.c.aHV());
                        return;
                    }
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanPreProcess", "app is cold boot = " + rY.aJA());
                }
                com.baidu.swan.apps.console.c.i("SwanLauncher", "launch appId: " + string);
                bundle.putLong("launch_interval", rY.aJD());
                bundle.putBoolean("console_switch", com.baidu.swan.apps.console.b.mL(com.baidu.swan.apps.f.a.mv(string)));
                v(bundle);
                bundle.putLong("launch_time_on_main", System.currentTimeMillis());
                if (DEBUG) {
                    Log.d("SwanLauncher", "onReady processId: " + rY.dwt + " ,client:" + rY.toString());
                }
                rx.c cVar = new rx.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.1
                    @Override // rx.c
                    public void onCompleted() {
                        SwanLauncher.this.a(rY, bundle, w);
                    }

                    @Override // rx.c
                    public void onError(Throwable th) {
                        SwanLauncher.this.a(th, w, string, bundle);
                    }

                    @Override // rx.c
                    public void onSubscribe(k kVar) {
                    }
                };
                a[] aVarArr = new a[2];
                aVarArr[0] = dck;
                aVarArr[1] = 1 == w ? dcj : dci;
                a(cVar, aVarArr);
                rY.aJB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(final com.baidu.swan.apps.process.messaging.service.c cVar, Bundle bundle, int i) {
        JSONObject jSONObject;
        if (com.baidu.swan.apps.swancore.b.aPK()) {
            com.baidu.swan.apps.swancore.b.a.aPQ();
        }
        SwanCoreVersion lg = com.baidu.swan.apps.swancore.b.lg(i);
        bundle.putParcelable("swanCoreVersion", lg);
        ExtensionCore iN = com.baidu.swan.apps.extcore.b.iN(i);
        bundle.putParcelable("extensionCore", iN);
        if (DEBUG) {
            Log.d("SwanLauncher", "onUpdateFinished() SwanCoreVersion: " + lg);
            Log.d("SwanLauncher", "onUpdateFinished() ExtensionCoreVersion: " + iN);
        }
        Bundle d = com.baidu.swan.apps.ad.a.a.d(com.baidu.swan.apps.u.c.c.E(bundle));
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
            jSONObject = com.baidu.swan.c.c.a(bundle.getString("mFrom"), null, "pre_source");
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
        if (!com.baidu.swan.apps.performance.b.c.akF()) {
            com.baidu.swan.apps.process.messaging.service.b.O(bundle);
        }
        d.Y(bundle);
        Context appContext = AppRuntime.getAppContext();
        b(cVar, bundle);
        Intent intent = new Intent(appContext, cVar.aJu().activity);
        intent.addFlags(268435456);
        intent.putExtras(bundle);
        intent.putExtra("start_activity_time", System.currentTimeMillis());
        try {
            appContext.startActivity(intent);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        if (i == 0) {
            b(bundle.getString("mAppId"), cVar);
        }
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.2
            @Override // java.lang.Runnable
            public void run() {
                cVar.aJF();
            }
        });
    }

    private void b(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull Bundle bundle) {
        boolean m;
        if (com.baidu.swan.apps.performance.b.c.aHT() && !cVar.aJA()) {
            if (DEBUG) {
                Log.d("SwanPreProcess", "sendAppLaunch, preAppLaunch ab = true, launch mode is not cold boot");
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo yN = com.baidu.swan.pms.database.a.bgb().yN(cVar.mAppId);
        if (yN != null && !yN.bgl()) {
            if (a.C0428a.auM()) {
                m = com.baidu.swan.apps.u.f.a.a(yN, bundle);
            } else {
                m = com.baidu.swan.apps.u.f.a.m(yN);
            }
            if (m) {
                bundle.putParcelable("pms_db_info_onload", yN);
                com.baidu.swan.apps.core.h.a.a(cVar, bundle);
            }
        }
        if (DEBUG) {
            Log.d("SwanPreProcess", "sendAppLaunch cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms, is cold boot = " + cVar.aJA());
        }
    }

    private void b(final String str, final com.baidu.swan.apps.process.messaging.service.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.process.messaging.service.e.aJL().a(new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.3
                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void c(String str2, com.baidu.swan.apps.process.messaging.service.c cVar2) {
                    if (cVar2 == cVar) {
                        if ("event_puppet_fmp_launch_finish".equals(str2) && cVar2.aJw() && TextUtils.equals(str, cVar2.getAppId())) {
                            com.baidu.swan.apps.process.messaging.service.e.aJL().a(this);
                            com.baidu.swan.apps.u.b.pt(str);
                        } else if ("event_puppet_unload_app".equals(str2) || "event_puppet_offline".equals(str2)) {
                            com.baidu.swan.apps.process.messaging.service.e.aJL().a(this);
                            com.baidu.swan.apps.u.b.ps(str);
                        }
                    }
                }

                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void axf() {
                    com.baidu.swan.apps.u.b.ps(str);
                }
            }, TimeUnit.SECONDS.toMillis(10L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th, int i, String str, Bundle bundle) {
        boolean z = th instanceof T7CheckException;
        com.baidu.swan.apps.console.c.bs("SwanLauncher", "isT7Error = " + z);
        com.baidu.swan.apps.u.b.a.a(AppRuntime.getAppContext(), new com.baidu.swan.apps.al.a().cV(z ? 15L : 9L).cW(z ? 42L : 25L).ux(z ? "Sailor安装失败" : "Swan core 更新出错"), i, str, bundle);
    }

    private void u(Bundle bundle) {
        Context appContext = AppRuntime.getAppContext();
        Intent intent = new Intent(appContext, SwanAppLauncherActivity.class);
        intent.addFlags(268435456);
        intent.putExtras(bundle);
        appContext.startActivity(intent);
    }

    public static String v(@NonNull Bundle bundle) {
        String string = bundle.getString("launch_id");
        if (TextUtils.isEmpty(string)) {
            String axe = axe();
            bundle.putString("launch_id", axe);
            return axe;
        }
        return string;
    }

    public static String axe() {
        return UUID.randomUUID().toString();
    }

    private static int w(@NonNull Bundle bundle) {
        return Math.max(bundle.getInt("appFrameType", -1), -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class c extends a {
        final int dcv;

        c(int i) {
            super();
            this.dcv = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(final rx.c cVar) {
            if (isChecked()) {
                cVar.onCompleted();
            } else {
                com.baidu.swan.apps.extcore.cores.a.axU().a(new com.baidu.swan.apps.ao.e.b<Exception>() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: q */
                    public void L(Exception exc) {
                        if (exc == null) {
                            c.this.axg();
                            cVar.onCompleted();
                            return;
                        }
                        cVar.onError(new Exception("SwanJsUpdater fail frame type = " + c.this.dcv, exc));
                    }
                }, this.dcv);
            }
        }
    }

    public void g(final com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        a(new rx.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.4
            @Override // rx.c
            public void onCompleted() {
                com.baidu.swan.apps.console.c.bs("SwanLauncher", "init onCompleted");
                if (bVar != null) {
                    bVar.L(null);
                }
            }

            @Override // rx.c
            public void onError(Throwable th) {
                com.baidu.swan.apps.console.c.g("SwanLauncher", "initEnv onError: ", th);
                if (bVar != null) {
                    bVar.L(new Exception("initEnv failed", th));
                }
            }

            @Override // rx.c
            public void onSubscribe(k kVar) {
                if (SwanLauncher.DEBUG) {
                    Log.i("SwanLauncher", "init onSubscribe: " + kVar);
                }
            }
        }, dck, dci, dcj);
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
            rx.b.l(arrayList).b(rx.a.b.a.eNI()).a(rx.a.b.a.eNI()).c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static abstract class a implements b.a {
        private boolean checked;

        private a() {
            this.checked = false;
        }

        protected void axg() {
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
    /* loaded from: classes9.dex */
    public static class T7CheckException extends Exception {
        private T7CheckException() {
        }
    }
}
