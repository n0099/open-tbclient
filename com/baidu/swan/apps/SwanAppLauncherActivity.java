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
    private FrameLayout akP;
    private com.baidu.swan.apps.v.b.c akQ;
    private WeakReference<SwanAppLauncherActivity> akR;

    @Override // android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z.S(this);
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onCreate");
        }
        vY();
        if (!n.R(this)) {
            if (!B(getIntent())) {
                finish();
                return;
            }
            this.akR = new WeakReference<>(this);
            com.baidu.swan.apps.extcore.cores.a.Dc().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.1
                @Override // com.baidu.swan.apps.extcore.c.a
                public void vZ() {
                    if (SwanAppLauncherActivity.DEBUG) {
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() SwanCoreVersion: " + com.baidu.swan.apps.swancore.b.dY(SwanAppLauncherActivity.this.akQ.azX));
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() ExtensionCoreVersion: " + com.baidu.swan.apps.extcore.a.CX().Cn());
                        if (com.baidu.swan.apps.swancore.b.Oe()) {
                            com.baidu.swan.apps.swancore.c.a.Oj();
                        }
                    }
                    SwanAppLauncherActivity.this.akQ.auL = com.baidu.swan.apps.swancore.b.dY(SwanAppLauncherActivity.this.akQ.azX);
                    SwanAppLauncherActivity.this.akQ.auM = com.baidu.swan.apps.extcore.a.CX().Cn();
                    com.baidu.swan.apps.v.b.Fr().a(SwanAppLauncherActivity.this);
                    if (!com.baidu.swan.apps.ac.a.a.d(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.akQ)) {
                        SwanAppLauncherActivity.this.setContentView(a.g.aiapps_launcher_activity);
                        SwanAppLauncherActivity.this.akP = (FrameLayout) SwanAppLauncherActivity.this.findViewById(a.f.launch_loading_container);
                        SwanAppLauncherActivity.this.showLoadingView();
                        if (com.baidu.swan.apps.core.pms.a.cp(SwanAppLauncherActivity.this.akQ.azX)) {
                            com.baidu.swan.apps.v.c.b(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.akQ);
                        } else {
                            com.baidu.swan.apps.core.a.c.a(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.akQ);
                        }
                    }
                }
            }, this.akQ.azX);
            Bundle bundle2 = new Bundle();
            bundle2.putString("bundle_key_preload_preload_scene", "1");
            com.baidu.swan.apps.process.messaging.service.c.b(this, bundle2);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.akQ != null) {
            Bundle Fy = this.akQ.Fy();
            if (Fy != null && Fy.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - Fy.getLong("ext_launch_time", 0L));
                f fVar = new f();
                fVar.mFrom = e.dQ(this.akQ.azX);
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.aWx = valueOf;
                fVar.d(this.akQ);
                fVar.ak(e.hv(this.akQ.azU));
                e.onEvent(fVar);
                f fVar2 = new f();
                fVar2.mFrom = e.dQ(this.akQ.azX);
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.aWx = valueOf;
                fVar2.d(this.akQ);
                fVar2.ak(e.hv(this.akQ.azU));
                fVar2.k("reason", "cancel");
                if (this.akQ.azX == 1) {
                    fVar2.k("errorList", com.baidu.swan.games.r.b.Tj().Tk());
                }
                e.onEvent(fVar2);
                Fy.remove("launch_flag_for_statistic");
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
        super.onBackPressed();
    }

    public static void a(Context context, final com.baidu.swan.apps.v.b.b bVar, final String str) {
        if (!aC(context)) {
            long hQ = com.baidu.swan.apps.swancore.b.hQ(bVar.FT());
            long j = bVar.Cm() != null ? bVar.Cm().aXe : 0L;
            if (DEBUG) {
                Log.d("SwanAppLauncherActivity", "SwanCoreVersion target string version: " + bVar.FT() + " target version: " + hQ + " ,targetSwanVersion: " + j);
            }
            if (hQ > j) {
                com.baidu.swan.apps.swancore.b.dV(bVar.FU());
            }
            String bc = com.baidu.swan.apps.u.a.Et().bc(context);
            final WeakReference weakReference = new WeakReference(context);
            bVar.aj("extra_data_uid_key", bc);
            com.baidu.swan.apps.process.a.Jl().b(new a.InterfaceC0167a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.2
                @Override // com.baidu.swan.apps.process.a.InterfaceC0167a
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
        this.akQ = com.baidu.swan.apps.v.b.c.G(intent);
        return this.akQ != null;
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
        a.b gp = com.baidu.swan.apps.process.messaging.service.a.JB().gp(bVar.getAppId());
        gp.gu(bVar.getAppId());
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onReady processId: " + gp.aId + " ,client:" + gp.toString());
        }
        a(context, intent, gp.aId, str);
        com.baidu.swan.apps.env.b CV = d.CT().CV();
        if (CV != null && CV.CS()) {
            CV.ev(bVar.getAppId());
        }
        com.baidu.swan.apps.v.b.Fr().Fs();
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
        boolean IO = com.baidu.swan.apps.performance.f.IO();
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.performance.b.IG().d(str, "swan_launch_type", com.baidu.swan.apps.am.a.Ph());
        com.baidu.swan.apps.performance.b.IG().q(str, "aiapp_launch_id", str).f(str, "aiapp_launch_ext_ab", IO);
        Bundle bundleExtra = intent2.getBundleExtra("aiapps_extra_data");
        Bundle bundle = new Bundle();
        if (bundleExtra != null && !bundleExtra.isEmpty()) {
            bundle.putAll(bundleExtra);
        }
        if (!IO) {
            bundle.putAll(com.baidu.swan.apps.performance.b.IG().IH().ga(str));
        }
        bundle.putBoolean("aiapp_launch_ext_ab", IO);
        bundle.putLong("aiapp_launch_activity_timestamp", currentTimeMillis);
        intent2.putExtra("aiapps_extra_data", bundle);
        context.startActivity(intent2);
        com.baidu.swan.apps.performance.b.IG().a(str, swanAppProcessInfo);
        if (DEBUG) {
            Log.i("SwanAppLauncherActivity", "xpass -> startTargetSwanApp: intent.bundle.size=" + (intent2.getExtras() == null ? 0 : intent2.getExtras().size()));
        }
        com.baidu.swan.apps.v.c.a.eY(str).Gd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.akR.get(), this.akP);
    }

    private void vQ() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.akP);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        vQ();
        com.baidu.swan.apps.v.b.Fr().b(this);
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean vW() {
        finish();
        return false;
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean vX() {
        finish();
        return false;
    }

    private void vY() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.u.a.EA().wY())) {
            StringBuilder sb = new StringBuilder("\n");
            sb.append("1.未实现 AbsSwanAppConfig#getBundleDecryptPublicKey() 接口函数").append("\n");
            sb.append("2.请认真阅读文档和接口注释").append("\n");
            sb.append("3.请到联系 百度 申请 解密使用的 公钥");
            throw new RuntimeException(sb.toString());
        }
    }
}
