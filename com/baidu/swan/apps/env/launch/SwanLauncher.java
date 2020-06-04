package com.baidu.swan.apps.env.launch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.core.h.a;
import com.baidu.swan.apps.v.b.e;
import com.baidu.swan.games.utils.so.d;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import rx.b;
import rx.k;
/* loaded from: classes11.dex */
public final class SwanLauncher {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final a ccv = new c(0);
    private static final a ccw = new c(1);
    private static final a ccx = new a() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(final rx.c cVar) {
            com.baidu.swan.apps.u.a.afI().SN();
            if (isChecked()) {
                cVar.onCompleted();
            } else if (com.baidu.swan.apps.u.a.afC().SW()) {
                acz();
                cVar.onCompleted();
            } else {
                com.baidu.swan.apps.u.a.afC().a(new com.baidu.swan.apps.core.k.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.4.1
                    @Override // com.baidu.swan.apps.core.k.c
                    public void onSuccess() {
                        acz();
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
    /* loaded from: classes11.dex */
    public static class b {
        public static final SwanLauncher ccG = new SwanLauncher();
    }

    public static SwanLauncher acy() {
        return b.ccG;
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
            final String string = bundle.getString("mAppId");
            if (!TextUtils.isEmpty(string)) {
                bundle.putBoolean("console_switch", com.baidu.swan.apps.console.b.iL(com.baidu.swan.apps.e.a.iv(string)));
                x(bundle);
                if (!ProcessUtils.isMainProcess()) {
                    w(bundle);
                    return;
                }
                bundle.putLong("launch_time_on_main", System.currentTimeMillis());
                final com.baidu.swan.apps.process.messaging.service.c ne = com.baidu.swan.apps.process.messaging.service.e.anp().ne(string);
                ne.nc(string);
                if (DEBUG) {
                    Log.d("SwanLauncher", "onReady processId: " + ne.cud + " ,client:" + ne.toString());
                }
                final int y = y(bundle);
                if (y < 0) {
                    y = 0;
                }
                rx.c cVar = new rx.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.1
                    @Override // rx.c
                    public void onCompleted() {
                        SwanLauncher.this.a(ne, bundle, y);
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
                aVarArr[0] = ccx;
                aVarArr[1] = 1 == y ? ccw : ccv;
                a(cVar, aVarArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(final com.baidu.swan.apps.process.messaging.service.c cVar, Bundle bundle, int i) {
        JSONObject jSONObject;
        PMSAppInfo tf;
        if (DEBUG) {
            Log.d("SwanLauncher", "onUpdateFinished() SwanCoreVersion: " + com.baidu.swan.apps.swancore.b.hd(i));
            Log.d("SwanLauncher", "onUpdateFinished() ExtensionCoreVersion: " + com.baidu.swan.apps.extcore.b.fg(i));
        }
        if (com.baidu.swan.apps.swancore.b.arR()) {
            com.baidu.swan.apps.swancore.b.a.arX();
        }
        bundle.putParcelable("swanCoreVersion", com.baidu.swan.apps.swancore.b.hd(i));
        bundle.putParcelable("extensionCore", com.baidu.swan.apps.extcore.b.fg(i));
        Bundle d = com.baidu.swan.apps.af.a.a.d(com.baidu.swan.apps.v.b.c.F(bundle));
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
            jSONObject = com.baidu.swan.e.c.a(bundle.getString("mFrom"), null, "pre_source");
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
        com.baidu.swan.apps.process.messaging.service.b.P(bundle);
        d.Y(bundle);
        Context appContext = AppRuntime.getAppContext();
        if (a.C0339a.aay() && (tf = com.baidu.swan.pms.database.a.aFV().tf(cVar.mAppId)) != null && !tf.aGi() && com.baidu.swan.apps.v.d.a.j(tf)) {
            bundle.putParcelable("pms_db_info_onload", tf);
            com.baidu.swan.apps.core.h.a.a(cVar, bundle);
        }
        Intent intent = new Intent(appContext, cVar.anc().activity);
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
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.2
            @Override // java.lang.Runnable
            public void run() {
                cVar.anj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th, int i, String str) {
        boolean z = th instanceof T7CheckException;
        com.baidu.swan.apps.v.a.a.a(AppRuntime.getAppContext(), new com.baidu.swan.apps.an.a().bw(z ? 15L : 9L).bx(z ? 42L : 25L).pr(z ? "Sailor安装失败" : "Swan core 更新出错"), i, str);
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
            String uuid = UUID.randomUUID().toString();
            bundle.putString("launch_id", uuid);
            return uuid;
        }
        return string;
    }

    private static int y(@NonNull Bundle bundle) {
        return Math.max(bundle.getInt("appFrameType", -1), -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c extends a {
        final int ccH;

        c(int i) {
            super();
            this.ccH = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(final rx.c cVar) {
            if (isChecked()) {
                cVar.onCompleted();
            } else {
                com.baidu.swan.apps.extcore.cores.a.acI().a(new com.baidu.swan.apps.aq.e.b<Exception>() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: p */
                    public void H(Exception exc) {
                        if (exc == null) {
                            c.this.acz();
                            cVar.onCompleted();
                            return;
                        }
                        cVar.onError(new Exception("SwanJsUpdater fail frame type = " + c.this.ccH, exc));
                    }
                }, this.ccH);
            }
        }
    }

    public void e(final com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        a(new rx.c() { // from class: com.baidu.swan.apps.env.launch.SwanLauncher.3
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
        }, ccx, ccv, ccw);
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
            rx.b.l(arrayList).b(rx.a.b.a.dPJ()).a(rx.a.b.a.dPJ()).c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static abstract class a implements b.a {
        private boolean checked;

        private a() {
            this.checked = false;
        }

        protected void acz() {
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
    /* loaded from: classes11.dex */
    public static class T7CheckException extends Exception {
        private T7CheckException() {
        }
    }
}
