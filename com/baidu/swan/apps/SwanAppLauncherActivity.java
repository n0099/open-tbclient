package com.baidu.swan.apps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.a;
import com.baidu.swan.apps.process.messaging.service.a;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.b;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class SwanAppLauncherActivity extends Activity implements b.a {
    private static final boolean DEBUG = b.DEBUG;
    private FrameLayout ajB;
    private com.baidu.swan.apps.v.b.c ajC;
    private WeakReference<SwanAppLauncherActivity> ajD;

    @Override // android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.O(this);
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onCreate");
        }
        uJ();
        if (!m.N(this)) {
            if (!C(getIntent())) {
                finish();
                return;
            }
            this.ajD = new WeakReference<>(this);
            com.baidu.swan.apps.extcore.cores.a.Bm().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.1
                @Override // com.baidu.swan.apps.extcore.c.a
                public void uK() {
                    if (SwanAppLauncherActivity.DEBUG) {
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() SwanCoreVersion: " + com.baidu.swan.apps.swancore.b.dJ(SwanAppLauncherActivity.this.ajC.ayb));
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() ExtensionCoreVersion: " + com.baidu.swan.apps.extcore.a.Bh().As());
                        if (com.baidu.swan.apps.swancore.b.KM()) {
                            com.baidu.swan.apps.swancore.c.a.KR();
                        }
                    }
                    SwanAppLauncherActivity.this.ajC.atv = com.baidu.swan.apps.swancore.b.dJ(SwanAppLauncherActivity.this.ajC.ayb);
                    SwanAppLauncherActivity.this.ajC.atw = com.baidu.swan.apps.extcore.a.Bh().As();
                    com.baidu.swan.apps.v.b.Dv().a(SwanAppLauncherActivity.this);
                    if (!com.baidu.swan.apps.ac.a.a.d(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.ajC)) {
                        SwanAppLauncherActivity.this.setContentView(a.g.aiapps_launcher_activity);
                        SwanAppLauncherActivity.this.ajB = (FrameLayout) SwanAppLauncherActivity.this.findViewById(a.f.launch_loading_container);
                        SwanAppLauncherActivity.this.showLoadingView();
                        if (SwanAppLauncherActivity.this.ajC.ayb != 0 || !com.baidu.swan.apps.core.pms.a.vp()) {
                            com.baidu.swan.apps.core.a.c.a(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.ajC);
                        } else {
                            com.baidu.swan.apps.v.c.b(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.ajC);
                        }
                    }
                }
            }, this.ajC.ayb);
            Bundle bundle2 = new Bundle();
            bundle2.putString("bundle_key_preload_preload_scene", "1");
            com.baidu.swan.apps.process.messaging.service.c.c(this, bundle2);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.ajC != null) {
            Bundle DA = this.ajC.DA();
            if (DA != null && DA.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - DA.getLong("ext_launch_time", 0L));
                f fVar = new f();
                fVar.mFrom = com.baidu.swan.apps.statistic.c.dB(this.ajC.ayb);
                fVar.mType = "launch";
                fVar.mValue = "cancel";
                fVar.aSA = valueOf;
                fVar.d(this.ajC);
                com.baidu.swan.apps.statistic.c.onEvent(fVar);
                f fVar2 = new f();
                fVar2.mFrom = com.baidu.swan.apps.statistic.c.dB(this.ajC.ayb);
                fVar2.mType = "launch";
                fVar2.mValue = "realcancel";
                fVar2.aSA = valueOf;
                fVar2.d(this.ajC);
                com.baidu.swan.apps.statistic.c.onEvent(fVar2);
                DA.remove("launch_flag_for_statistic");
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
        super.onBackPressed();
    }

    public static void a(Context context, final com.baidu.swan.apps.v.b.b bVar, final String str) {
        if (!bi(context)) {
            long hh = com.baidu.swan.apps.swancore.b.hh(bVar.aya);
            long j = bVar.atv != null ? bVar.atv.aTh : 0L;
            if (DEBUG) {
                Log.d("SwanAppLauncherActivity", "SwanCoreVersion target string version: " + bVar.aya + " target version: " + hh + " ,targetSwanVersion: " + j);
            }
            if (hh > j) {
                com.baidu.swan.apps.swancore.b.dG(bVar.ayb);
            }
            String bI = com.baidu.swan.apps.u.a.CB().bI(context);
            final WeakReference weakReference = new WeakReference(context);
            bVar.al("extra_data_uid_key", bI);
            com.baidu.swan.apps.process.a.Gi().b(new a.InterfaceC0151a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.2
                @Override // com.baidu.swan.apps.process.a.InterfaceC0151a
                public void onReady() {
                    Context context2 = (Context) weakReference.get();
                    if (context2 != null && !SwanAppLauncherActivity.bi(context2)) {
                        SwanAppLauncherActivity.a(context2, com.baidu.swan.apps.v.b.b.b(context2, bVar), bVar, str);
                    }
                }
            });
        }
    }

    private boolean C(Intent intent) {
        if (intent == null) {
            return false;
        }
        this.ajC = com.baidu.swan.apps.v.b.c.H(intent);
        return this.ajC != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean bi(Context context) {
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
        a.b fQ = com.baidu.swan.apps.process.messaging.service.a.Gu().fQ(bVar.mAppId);
        fQ.fU(bVar.mAppId);
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onReady processId: " + fQ.aFe + " ,client:" + fQ.toString());
        }
        a(context, intent, fQ.aFe, str);
        com.baidu.swan.apps.env.c Be = e.Bd().Be();
        if (Be != null && Be.AY()) {
            Be.eA(bVar.mAppId);
        }
        com.baidu.swan.apps.v.b.Dv().Dw();
    }

    private static void a(Context context, Intent intent, SwanAppProcessInfo swanAppProcessInfo, String str) {
        Intent intent2 = new Intent(context, swanAppProcessInfo.activity);
        if (intent != null && intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        com.baidu.swan.apps.process.messaging.service.c.L(intent2);
        if (!(context instanceof Activity)) {
            intent2.addFlags(268435456);
        }
        boolean FP = com.baidu.swan.apps.performance.f.FP();
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.performance.b.FH().q(str, "aiapp_launch_id", str).f(str, "aiapp_launch_ext_ab", FP);
        Bundle bundleExtra = intent2.getBundleExtra("aiapps_extra_data");
        Bundle bundle = new Bundle();
        if (bundleExtra != null && !bundleExtra.isEmpty()) {
            bundle.putAll(bundleExtra);
        }
        if (!FP) {
            bundle.putAll(com.baidu.swan.apps.performance.b.FH().FI().fF(str));
        }
        bundle.putBoolean("aiapp_launch_ext_ab", FP);
        bundle.putLong("aiapp_launch_activity_timestamp", currentTimeMillis);
        intent2.putExtra("aiapps_extra_data", bundle);
        context.startActivity(intent2);
        com.baidu.swan.apps.performance.b.FH().a(str, swanAppProcessInfo);
        if (DEBUG) {
            Log.i("SwanAppLauncherActivity", "xpass -> startTargetSwanApp: intent.bundle.size=" + (intent2.getExtras() == null ? 0 : intent2.getExtras().size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.ajD.get(), this.ajB);
    }

    private void uB() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.ajB);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        uB();
        com.baidu.swan.apps.v.b.Dv().b(this);
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean uH() {
        finish();
        return false;
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean uI() {
        finish();
        return false;
    }

    private void uJ() {
        String vE = com.baidu.swan.apps.u.a.CI().vE();
        if (TextUtils.isEmpty(vE) || TextUtils.equals(vE.trim(), "null")) {
            StringBuilder sb = new StringBuilder("\n");
            sb.append("1.未实现 AbsSwanAppConfig#getBundleDecryptPublicKey() 接口函数").append("\n");
            sb.append("2.请认真阅读文档和接口注释").append("\n");
            sb.append("3.请到联系 百度 申请 解密使用的 公钥");
            throw new RuntimeException(sb.toString());
        }
    }
}
