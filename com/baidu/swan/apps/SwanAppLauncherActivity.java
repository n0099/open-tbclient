package com.baidu.swan.apps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.env.d;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.a;
import com.baidu.swan.apps.process.messaging.service.a;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.b;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class SwanAppLauncherActivity extends Activity implements b.a {
    private static final boolean DEBUG = b.DEBUG;
    private FrameLayout akr;
    private com.baidu.swan.apps.v.b.c aks;
    private WeakReference<SwanAppLauncherActivity> akt;

    @Override // android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z.S(this);
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onCreate");
        }
        vU();
        if (!n.R(this)) {
            if (!B(getIntent())) {
                finish();
                return;
            }
            this.akt = new WeakReference<>(this);
            com.baidu.swan.apps.extcore.cores.a.CY().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.1
                @Override // com.baidu.swan.apps.extcore.c.a
                public void vV() {
                    if (SwanAppLauncherActivity.DEBUG) {
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() SwanCoreVersion: " + com.baidu.swan.apps.swancore.b.dX(SwanAppLauncherActivity.this.aks.azz));
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() ExtensionCoreVersion: " + com.baidu.swan.apps.extcore.a.CT().Cj());
                        if (com.baidu.swan.apps.swancore.b.Oa()) {
                            com.baidu.swan.apps.swancore.c.a.Of();
                        }
                    }
                    SwanAppLauncherActivity.this.aks.aun = com.baidu.swan.apps.swancore.b.dX(SwanAppLauncherActivity.this.aks.azz);
                    SwanAppLauncherActivity.this.aks.auo = com.baidu.swan.apps.extcore.a.CT().Cj();
                    com.baidu.swan.apps.v.b.Fn().a(SwanAppLauncherActivity.this);
                    if (!com.baidu.swan.apps.ac.a.a.d(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.aks)) {
                        SwanAppLauncherActivity.this.setContentView(a.g.aiapps_launcher_activity);
                        SwanAppLauncherActivity.this.akr = (FrameLayout) SwanAppLauncherActivity.this.findViewById(a.f.launch_loading_container);
                        SwanAppLauncherActivity.this.showLoadingView();
                        if (com.baidu.swan.apps.core.pms.a.co(SwanAppLauncherActivity.this.aks.azz)) {
                            com.baidu.swan.apps.v.c.b(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.aks);
                        } else {
                            com.baidu.swan.apps.core.a.c.a(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.aks);
                        }
                    }
                }
            }, this.aks.azz);
            Bundle bundle2 = new Bundle();
            bundle2.putString("bundle_key_preload_preload_scene", "1");
            com.baidu.swan.apps.process.messaging.service.c.b(this, bundle2);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.aks != null) {
            Bundle Fu = this.aks.Fu();
            if (Fu != null && Fu.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - Fu.getLong("ext_launch_time", 0L));
                f fVar = new f();
                fVar.mFrom = e.dP(this.aks.azz);
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.aVZ = valueOf;
                fVar.d(this.aks);
                fVar.ak(e.ht(this.aks.azw));
                e.onEvent(fVar);
                f fVar2 = new f();
                fVar2.mFrom = e.dP(this.aks.azz);
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.aVZ = valueOf;
                fVar2.d(this.aks);
                fVar2.ak(e.ht(this.aks.azw));
                fVar2.k("reason", "cancel");
                if (this.aks.azz == 1) {
                    fVar2.k("errorList", com.baidu.swan.games.r.b.Tf().Tg());
                }
                e.onEvent(fVar2);
                Fu.remove("launch_flag_for_statistic");
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
        super.onBackPressed();
    }

    public static void a(Context context, final com.baidu.swan.apps.v.b.b bVar, final String str) {
        if (!aC(context)) {
            long hO = com.baidu.swan.apps.swancore.b.hO(bVar.FP());
            long j = bVar.Ci() != null ? bVar.Ci().aWG : 0L;
            if (DEBUG) {
                Log.d("SwanAppLauncherActivity", "SwanCoreVersion target string version: " + bVar.FP() + " target version: " + hO + " ,targetSwanVersion: " + j);
            }
            if (hO > j) {
                com.baidu.swan.apps.swancore.b.dU(bVar.FQ());
            }
            String bc = com.baidu.swan.apps.u.a.Ep().bc(context);
            final WeakReference weakReference = new WeakReference(context);
            bVar.aj("extra_data_uid_key", bc);
            com.baidu.swan.apps.process.a.Jh().b(new a.InterfaceC0153a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.2
                @Override // com.baidu.swan.apps.process.a.InterfaceC0153a
                public void onReady() {
                    Context context2 = (Context) weakReference.get();
                    if (context2 != null && !SwanAppLauncherActivity.aC(context2)) {
                        SwanAppLauncherActivity.a(context2, com.baidu.swan.apps.v.b.b.b(context2, bVar), bVar, str);
                    }
                }
            });
        }
    }

    private boolean B(Intent intent) {
        if (intent == null) {
            return false;
        }
        this.aks = com.baidu.swan.apps.v.b.c.G(intent);
        return this.aks != null;
    }

    public static boolean aC(Context context) {
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "isLauncherActivityClosed context is LauncherActivity: " + (context instanceof SwanAppLauncherActivity));
        }
        if (context instanceof SwanAppLauncherActivity) {
            SwanAppLauncherActivity swanAppLauncherActivity = (SwanAppLauncherActivity) context;
            return swanAppLauncherActivity.isFinishing() || swanAppLauncherActivity.isDestroyed();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, Intent intent, com.baidu.swan.apps.v.b.b bVar, String str) {
        a.b gn = com.baidu.swan.apps.process.messaging.service.a.Jx().gn(bVar.getAppId());
        gn.gr(bVar.getAppId());
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onReady processId: " + gn.aHF + " ,client:" + gn.toString());
        }
        a(context, intent, gn.aHF, str);
        com.baidu.swan.apps.env.b CR = d.CP().CR();
        if (CR != null && CR.CO()) {
            CR.et(bVar.getAppId());
        }
        com.baidu.swan.apps.v.b.Fn().Fo();
    }

    private static void a(Context context, Intent intent, SwanAppProcessInfo swanAppProcessInfo, String str) {
        Intent intent2 = new Intent(context, swanAppProcessInfo.activity);
        if (intent != null && intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        com.baidu.swan.apps.process.messaging.service.c.K(intent2);
        if (!(context instanceof Activity)) {
            intent2.addFlags(268435456);
        }
        boolean IK = com.baidu.swan.apps.performance.f.IK();
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.performance.b.IC().d(str, "swan_launch_type", com.baidu.swan.apps.am.a.Pd());
        com.baidu.swan.apps.performance.b.IC().q(str, "aiapp_launch_id", str).f(str, "aiapp_launch_ext_ab", IK);
        Bundle bundleExtra = intent2.getBundleExtra("aiapps_extra_data");
        Bundle bundle = new Bundle();
        if (bundleExtra != null && !bundleExtra.isEmpty()) {
            bundle.putAll(bundleExtra);
        }
        if (!IK) {
            bundle.putAll(com.baidu.swan.apps.performance.b.IC().ID().fY(str));
        }
        bundle.putBoolean("aiapp_launch_ext_ab", IK);
        bundle.putLong("aiapp_launch_activity_timestamp", currentTimeMillis);
        intent2.putExtra("aiapps_extra_data", bundle);
        context.startActivity(intent2);
        com.baidu.swan.apps.performance.b.IC().a(str, swanAppProcessInfo);
        if (DEBUG) {
            Log.i("SwanAppLauncherActivity", "xpass -> startTargetSwanApp: intent.bundle.size=" + (intent2.getExtras() == null ? 0 : intent2.getExtras().size()));
        }
        com.baidu.swan.apps.v.c.a.eW(str).FZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.akt.get(), this.akr);
    }

    private void vM() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.akr);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        vM();
        com.baidu.swan.apps.v.b.Fn().b(this);
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean vS() {
        finish();
        return false;
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean vT() {
        finish();
        return false;
    }

    private void vU() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.u.a.Ew().wU())) {
            StringBuilder sb = new StringBuilder("\n");
            sb.append("1.未实现 AbsSwanAppConfig#getBundleDecryptPublicKey() 接口函数").append("\n");
            sb.append("2.请认真阅读文档和接口注释").append("\n");
            sb.append("3.请到联系 百度 申请 解密使用的 公钥");
            throw new RuntimeException(sb.toString());
        }
    }
}
