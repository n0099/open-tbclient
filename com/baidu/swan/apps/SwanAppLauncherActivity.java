package com.baidu.swan.apps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
    private FrameLayout aDT;
    private com.baidu.swan.apps.v.b.c aDU;
    private WeakReference<SwanAppLauncherActivity> aDV;

    @Override // android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z.R(this);
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onCreate");
        }
        AT();
        if (!n.Q(this)) {
            if (!H(getIntent())) {
                finish();
                return;
            }
            this.aDV = new WeakReference<>(this);
            com.baidu.swan.apps.extcore.cores.a.HX().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.1
                @Override // com.baidu.swan.apps.extcore.c.a
                public void AU() {
                    if (SwanAppLauncherActivity.DEBUG) {
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() SwanCoreVersion: " + com.baidu.swan.apps.swancore.b.eT(SwanAppLauncherActivity.this.aDU.aST));
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() ExtensionCoreVersion: " + com.baidu.swan.apps.extcore.a.HS().Hi());
                        if (com.baidu.swan.apps.swancore.b.SW()) {
                            com.baidu.swan.apps.swancore.c.a.Tb();
                        }
                    }
                    SwanAppLauncherActivity.this.aDU.aNK = com.baidu.swan.apps.swancore.b.eT(SwanAppLauncherActivity.this.aDU.aST);
                    SwanAppLauncherActivity.this.aDU.aNL = com.baidu.swan.apps.extcore.a.HS().Hi();
                    com.baidu.swan.apps.v.b.Km().a(SwanAppLauncherActivity.this);
                    if (!com.baidu.swan.apps.ac.a.a.d(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.aDU)) {
                        SwanAppLauncherActivity.this.setContentView(a.g.aiapps_launcher_activity);
                        SwanAppLauncherActivity.this.aDT = (FrameLayout) SwanAppLauncherActivity.this.findViewById(a.f.launch_loading_container);
                        SwanAppLauncherActivity.this.showLoadingView();
                        if (com.baidu.swan.apps.core.pms.a.dl(SwanAppLauncherActivity.this.aDU.aST)) {
                            com.baidu.swan.apps.v.c.b(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.aDU);
                        } else {
                            com.baidu.swan.apps.core.a.c.a(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.aDU);
                        }
                    }
                }
            }, this.aDU.aST);
            Bundle bundle2 = new Bundle();
            bundle2.putString("bundle_key_preload_preload_scene", "1");
            com.baidu.swan.apps.process.messaging.service.c.b(this, bundle2);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.aDU != null) {
            Bundle Kt = this.aDU.Kt();
            if (Kt != null && Kt.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - Kt.getLong("ext_launch_time", 0L));
                f fVar = new f();
                fVar.mFrom = e.eL(this.aDU.aST);
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.bpj = valueOf;
                fVar.d(this.aDU);
                fVar.aJ(e.hY(this.aDU.aSQ));
                e.onEvent(fVar);
                f fVar2 = new f();
                fVar2.mFrom = e.eL(this.aDU.aST);
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.bpj = valueOf;
                fVar2.d(this.aDU);
                fVar2.aJ(e.hY(this.aDU.aSQ));
                fVar2.h(TiebaInitialize.LogFields.REASON, "cancel");
                if (this.aDU.aST == 1) {
                    fVar2.h("errorList", com.baidu.swan.games.r.b.XY().XZ());
                }
                e.onEvent(fVar2);
                Kt.remove("launch_flag_for_statistic");
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
        super.onBackPressed();
    }

    public static void a(Context context, final com.baidu.swan.apps.v.b.b bVar, final String str) {
        if (!aG(context)) {
            long iu = com.baidu.swan.apps.swancore.b.iu(bVar.KO());
            long j = bVar.Hh() != null ? bVar.Hh().bpQ : 0L;
            if (DEBUG) {
                Log.d("SwanAppLauncherActivity", "SwanCoreVersion target string version: " + bVar.KO() + " target version: " + iu + " ,targetSwanVersion: " + j);
            }
            if (iu > j) {
                com.baidu.swan.apps.swancore.b.eQ(bVar.KP());
            }
            String be = com.baidu.swan.apps.u.a.Jo().be(context);
            final WeakReference weakReference = new WeakReference(context);
            bVar.ar("extra_data_uid_key", be);
            com.baidu.swan.apps.process.a.Og().b(new a.InterfaceC0194a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.2
                @Override // com.baidu.swan.apps.process.a.InterfaceC0194a
                public void onReady() {
                    Context context2 = (Context) weakReference.get();
                    if (context2 != null && !SwanAppLauncherActivity.aG(context2)) {
                        SwanAppLauncherActivity.a(context2, com.baidu.swan.apps.v.b.b.b(context2, bVar), bVar, str);
                    }
                }
            });
        }
    }

    private boolean H(Intent intent) {
        if (intent == null) {
            return false;
        }
        this.aDU = com.baidu.swan.apps.v.b.c.M(intent);
        return this.aDU != null;
    }

    public static boolean aG(Context context) {
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
        a.b gU = com.baidu.swan.apps.process.messaging.service.a.Ow().gU(bVar.getAppId());
        gU.gY(bVar.getAppId());
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onReady processId: " + gU.baZ + " ,client:" + gU.toString());
        }
        a(context, intent, gU.baZ, str);
        com.baidu.swan.apps.env.b HQ = d.HO().HQ();
        if (HQ != null && HQ.HN()) {
            HQ.fc(bVar.getAppId());
        }
        com.baidu.swan.apps.v.b.Km().Kn();
    }

    private static void a(Context context, Intent intent, SwanAppProcessInfo swanAppProcessInfo, String str) {
        Intent intent2 = new Intent(context, swanAppProcessInfo.activity);
        if (intent != null && intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        com.baidu.swan.apps.process.messaging.service.c.Q(intent2);
        if (!(context instanceof Activity)) {
            intent2.addFlags(268435456);
        }
        boolean NJ = com.baidu.swan.apps.performance.f.NJ();
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.performance.b.NB().d(str, "swan_launch_type", com.baidu.swan.apps.am.a.TV());
        com.baidu.swan.apps.performance.b.NB().u(str, "aiapp_launch_id", str).i(str, "aiapp_launch_ext_ab", NJ);
        Bundle bundleExtra = intent2.getBundleExtra("aiapps_extra_data");
        Bundle bundle = new Bundle();
        if (bundleExtra != null && !bundleExtra.isEmpty()) {
            bundle.putAll(bundleExtra);
        }
        if (!NJ) {
            bundle.putAll(com.baidu.swan.apps.performance.b.NB().NC().gF(str));
        }
        bundle.putBoolean("aiapp_launch_ext_ab", NJ);
        bundle.putLong("aiapp_launch_activity_timestamp", currentTimeMillis);
        intent2.putExtra("aiapps_extra_data", bundle);
        context.startActivity(intent2);
        com.baidu.swan.apps.performance.b.NB().a(str, swanAppProcessInfo);
        if (DEBUG) {
            Log.i("SwanAppLauncherActivity", "xpass -> startTargetSwanApp: intent.bundle.size=" + (intent2.getExtras() == null ? 0 : intent2.getExtras().size()));
        }
        com.baidu.swan.apps.v.c.a.fF(str).KY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.aDV.get(), this.aDT);
    }

    private void AL() {
        com.baidu.swan.apps.res.widget.loadingview.a.l(this.aDT);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        AL();
        com.baidu.swan.apps.v.b.Km().b(this);
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean AR() {
        finish();
        return false;
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean AS() {
        finish();
        return false;
    }

    private void AT() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.u.a.Jv().BT())) {
            StringBuilder sb = new StringBuilder("\n");
            sb.append("1.未实现 AbsSwanAppConfig#getBundleDecryptPublicKey() 接口函数").append("\n");
            sb.append("2.请认真阅读文档和接口注释").append("\n");
            sb.append("3.请到联系 百度 申请 解密使用的 公钥");
            throw new RuntimeException(sb.toString());
        }
    }
}
