package com.baidu.swan.apps.env.launch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.core.h.a;
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
/* loaded from: classes7.dex */
public final class SwanLauncher {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final a ciY = new c(0);
    private static final a ciZ = new c(1);
    private static final a cja = new a() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(final rx.c cVar) {
            com.baidu.swan.apps.t.a.aib().Ut();
            if (isChecked()) {
                cVar.onCompleted();
            } else if (com.baidu.swan.apps.t.a.ahV().UD()) {
                aeO();
                cVar.onCompleted();
            } else {
                com.baidu.swan.apps.t.a.ahV().a(new com.baidu.swan.apps.core.k.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.5.1
                    @Override // com.baidu.swan.apps.core.k.c
                    public void onSuccess() {
                        aeO();
                        cVar.onCompleted();
                    }

                    @Override // com.baidu.swan.apps.core.k.c
                    public void onFail() {
                        cVar.onError(new T7CheckException());
                    }

                    @Override // com.baidu.swan.apps.core.k.c
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
    /* loaded from: classes7.dex */
    public static class b {
        public static final SwanLauncher cjl = new SwanLauncher();
    }

    public static SwanLauncher aeL() {
        return b.cjl;
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
            v(bundle2);
        }
    }

    public void v(final Bundle bundle) {
        if (bundle != null) {
            bundle.putLong("launch_time", System.currentTimeMillis());
            bundle.putLong("box_cold_launch", com.baidu.swan.apps.t.a.ahv().TH());
            final String string = bundle.getString("mAppId");
            if (!TextUtils.isEmpty(string)) {
                com.baidu.swan.apps.console.c.i("SwanLauncher", "launch appId: " + string);
                bundle.putBoolean("console_switch", com.baidu.swan.apps.console.b.jd(com.baidu.swan.apps.e.a.iN(string)));
                x(bundle);
                if (!ProcessUtils.isMainProcess()) {
                    w(bundle);
                    return;
                }
                bundle.putLong("launch_time_on_main", System.currentTimeMillis());
                final com.baidu.swan.apps.process.messaging.service.c nT = com.baidu.swan.apps.process.messaging.service.e.aqf().nT(string);
                nT.nR(string);
                if (DEBUG) {
                    Log.d("SwanLauncher", "onReady processId: " + nT.cBq + " ,client:" + nT.toString());
                }
                final int y = y(bundle);
                if (y < 0) {
                    y = 0;
                }
                rx.c cVar = new rx.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.1
                    @Override // rx.c
                    public void onCompleted() {
                        SwanLauncher.this.a(nT, bundle, y);
                    }

                    @Override // rx.c
                    public void onError(Throwable th) {
                        SwanLauncher.this.a(th, y, string);
                    }

                    @Override // rx.c
                    public void onSubscribe(k kVar) {
                    }
                };
                a[] aVarArr = new a[2];
                aVarArr[0] = cja;
                aVarArr[1] = 1 == y ? ciZ : ciY;
                a(cVar, aVarArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(final com.baidu.swan.apps.process.messaging.service.c cVar, Bundle bundle, int i) {
        JSONObject jSONObject;
        boolean m;
        if (com.baidu.swan.apps.swancore.b.auZ()) {
            com.baidu.swan.apps.swancore.b.a.avf();
        }
        Parcelable hx = com.baidu.swan.apps.swancore.b.hx(i);
        bundle.putParcelable("swanCoreVersion", hx);
        Parcelable fA = com.baidu.swan.apps.extcore.b.fA(i);
        bundle.putParcelable("extensionCore", fA);
        if (DEBUG) {
            Log.d("SwanLauncher", "onUpdateFinished() SwanCoreVersion: " + hx);
            Log.d("SwanLauncher", "onUpdateFinished() ExtensionCoreVersion: " + fA);
        }
        Bundle d = com.baidu.swan.apps.ae.a.a.d(com.baidu.swan.apps.u.c.c.G(bundle));
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
            jSONObject = com.baidu.swan.d.c.a(bundle.getString("mFrom"), null, "pre_source");
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
        com.baidu.swan.apps.process.messaging.service.b.Q(bundle);
        d.Z(bundle);
        Context appContext = AppRuntime.getAppContext();
        PMSAppInfo uq = com.baidu.swan.pms.database.a.aKS().uq(cVar.mAppId);
        if (uq != null && !uq.aLf()) {
            if (a.C0347a.acG()) {
                m = com.baidu.swan.apps.u.e.a.a(uq, bundle);
            } else {
                m = com.baidu.swan.apps.u.e.a.m(uq);
            }
            if (m) {
                bundle.putParcelable("pms_db_info_onload", uq);
                com.baidu.swan.apps.core.h.a.a(cVar, bundle);
            }
        }
        Intent intent = new Intent(appContext, cVar.apS().activity);
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
                cVar.apZ();
            }
        });
    }

    private void b(final String str, final com.baidu.swan.apps.process.messaging.service.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.process.messaging.service.e.aqf().a(new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.3
                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void c(String str2, com.baidu.swan.apps.process.messaging.service.c cVar2) {
                    if (cVar2 == cVar) {
                        if ("event_puppet_fmp_launch_finish".equals(str2) && cVar2.apU() && TextUtils.equals(str, cVar2.getAppId())) {
                            com.baidu.swan.apps.process.messaging.service.e.aqf().a(this);
                            com.baidu.swan.apps.u.b.ln(str);
                        } else if ("event_puppet_unload_app".equals(str2) || "event_puppet_offline".equals(str2)) {
                            com.baidu.swan.apps.process.messaging.service.e.aqf().a(this);
                            com.baidu.swan.apps.u.b.lm(str);
                        }
                    }
                }

                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void aeN() {
                    com.baidu.swan.apps.u.b.lm(str);
                }
            }, TimeUnit.SECONDS.toMillis(10L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th, int i, String str) {
        boolean z = th instanceof T7CheckException;
        com.baidu.swan.apps.u.b.a.a(AppRuntime.getAppContext(), new com.baidu.swan.apps.an.a().bJ(z ? 15L : 9L).bK(z ? 42L : 25L).qk(z ? "Sailor安装失败" : "Swan core 更新出错"), i, str);
    }

    private void w(Bundle bundle) {
        Context appContext = AppRuntime.getAppContext();
        Intent intent = new Intent(appContext, SwanAppLauncherActivity.class);
        intent.addFlags(268435456);
        intent.putExtras(bundle);
        appContext.startActivity(intent);
    }

    public static String x(@NonNull Bundle bundle) {
        String string = bundle.getString("launch_id");
        if (TextUtils.isEmpty(string)) {
            String aeM = aeM();
            bundle.putString("launch_id", aeM);
            return aeM;
        }
        return string;
    }

    public static String aeM() {
        return UUID.randomUUID().toString();
    }

    private static int y(@NonNull Bundle bundle) {
        return Math.max(bundle.getInt("appFrameType", -1), -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class c extends a {
        final int cjm;

        c(int i) {
            super();
            this.cjm = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(final rx.c cVar) {
            if (isChecked()) {
                cVar.onCompleted();
            } else {
                com.baidu.swan.apps.extcore.cores.a.afe().a(new com.baidu.swan.apps.aq.e.b<Exception>() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: p */
                    public void H(Exception exc) {
                        if (exc == null) {
                            c.this.aeO();
                            cVar.onCompleted();
                            return;
                        }
                        cVar.onError(new Exception("SwanJsUpdater fail frame type = " + c.this.cjm, exc));
                    }
                }, this.cjm);
            }
        }
    }

    public void f(final com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        a(new rx.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.4
            @Override // rx.c
            public void onCompleted() {
                if (SwanLauncher.DEBUG) {
                    Log.i("SwanLauncher", "init onCompleted: ");
                }
                if (bVar != null) {
                    bVar.H(null);
                }
            }

            @Override // rx.c
            public void onError(Throwable th) {
                if (SwanLauncher.DEBUG) {
                    Log.i("SwanLauncher", "init onError: " + th);
                }
                if (bVar != null) {
                    bVar.H(new Exception("initEnv failed", th));
                }
            }

            @Override // rx.c
            public void onSubscribe(k kVar) {
                if (SwanLauncher.DEBUG) {
                    Log.i("SwanLauncher", "init onSubscribe: " + kVar);
                }
            }
        }, cja, ciY, ciZ);
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
            rx.b.l(arrayList).b(rx.a.b.a.dXQ()).a(rx.a.b.a.dXQ()).c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static abstract class a implements b.a {
        private boolean checked;

        private a() {
            this.checked = false;
        }

        protected void aeO() {
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
    /* loaded from: classes7.dex */
    public static class T7CheckException extends Exception {
        private T7CheckException() {
        }
    }
}
