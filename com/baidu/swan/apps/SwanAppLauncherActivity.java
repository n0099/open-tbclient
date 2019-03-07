package com.baidu.swan.apps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
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
    private static final boolean DEBUG = c.DEBUG;
    private FrameLayout ajv;
    private com.baidu.swan.apps.v.b.c ajw;
    private WeakReference<SwanAppLauncherActivity> ajx;

    @Override // android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.O(this);
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onCreate");
        }
        uK();
        if (!m.N(this)) {
            if (!C(getIntent())) {
                finish();
                return;
            }
            this.ajx = new WeakReference<>(this);
            com.baidu.swan.apps.extcore.cores.a.Bo().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.1
                @Override // com.baidu.swan.apps.extcore.c.a
                public void uL() {
                    if (SwanAppLauncherActivity.DEBUG) {
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() SwanCoreVersion: " + com.baidu.swan.apps.swancore.b.dK(SwanAppLauncherActivity.this.ajw.axW));
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() ExtensionCoreVersion: " + com.baidu.swan.apps.extcore.a.Bj().At());
                        if (com.baidu.swan.apps.swancore.b.KO()) {
                            com.baidu.swan.apps.swancore.c.a.KT();
                        }
                    }
                    SwanAppLauncherActivity.this.ajw.atp = com.baidu.swan.apps.swancore.b.dK(SwanAppLauncherActivity.this.ajw.axW);
                    SwanAppLauncherActivity.this.ajw.atq = com.baidu.swan.apps.extcore.a.Bj().At();
                    com.baidu.swan.apps.v.b.Dx().a(SwanAppLauncherActivity.this);
                    if (!com.baidu.swan.apps.ac.a.a.d(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.ajw)) {
                        SwanAppLauncherActivity.this.setContentView(b.g.aiapps_launcher_activity);
                        SwanAppLauncherActivity.this.ajv = (FrameLayout) SwanAppLauncherActivity.this.findViewById(b.f.launch_loading_container);
                        SwanAppLauncherActivity.this.showLoadingView();
                        if (SwanAppLauncherActivity.this.ajw.axW != 0 || !com.baidu.swan.apps.core.pms.a.vq()) {
                            com.baidu.swan.apps.core.a.c.a(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.ajw);
                        } else {
                            com.baidu.swan.apps.v.c.b(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.ajw);
                        }
                    }
                }
            }, this.ajw.axW);
            Bundle bundle2 = new Bundle();
            bundle2.putString("bundle_key_preload_preload_scene", "1");
            com.baidu.swan.apps.process.messaging.service.c.c(this, bundle2);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.ajw != null) {
            Bundle DC = this.ajw.DC();
            if (DC != null && DC.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - DC.getLong("ext_launch_time", 0L));
                f fVar = new f();
                fVar.mFrom = com.baidu.swan.apps.statistic.c.dC(this.ajw.axW);
                fVar.mType = "launch";
                fVar.mValue = "cancel";
                fVar.aSv = valueOf;
                fVar.d(this.ajw);
                com.baidu.swan.apps.statistic.c.onEvent(fVar);
                f fVar2 = new f();
                fVar2.mFrom = com.baidu.swan.apps.statistic.c.dC(this.ajw.axW);
                fVar2.mType = "launch";
                fVar2.mValue = "realcancel";
                fVar2.aSv = valueOf;
                fVar2.d(this.ajw);
                com.baidu.swan.apps.statistic.c.onEvent(fVar2);
                DC.remove("launch_flag_for_statistic");
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
        super.onBackPressed();
    }

    public static void a(Context context, final com.baidu.swan.apps.v.b.b bVar, final String str) {
        if (!bi(context)) {
            long hg = com.baidu.swan.apps.swancore.b.hg(bVar.axV);
            long j = bVar.atp != null ? bVar.atp.aTc : 0L;
            if (DEBUG) {
                Log.d("SwanAppLauncherActivity", "SwanCoreVersion target string version: " + bVar.axV + " target version: " + hg + " ,targetSwanVersion: " + j);
            }
            if (hg > j) {
                com.baidu.swan.apps.swancore.b.dH(bVar.axW);
            }
            String bI = com.baidu.swan.apps.u.a.CD().bI(context);
            final WeakReference weakReference = new WeakReference(context);
            bVar.al("extra_data_uid_key", bI);
            com.baidu.swan.apps.process.a.Gk().b(new a.InterfaceC0122a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.2
                @Override // com.baidu.swan.apps.process.a.InterfaceC0122a
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
        this.ajw = com.baidu.swan.apps.v.b.c.H(intent);
        return this.ajw != null;
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
        a.b fP = com.baidu.swan.apps.process.messaging.service.a.Gw().fP(bVar.mAppId);
        fP.fT(bVar.mAppId);
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onReady processId: " + fP.aEZ + " ,client:" + fP.toString());
        }
        a(context, intent, fP.aEZ, str);
        com.baidu.swan.apps.env.c Bg = e.Bf().Bg();
        if (Bg != null && Bg.Ba()) {
            Bg.ez(bVar.mAppId);
        }
        com.baidu.swan.apps.v.b.Dx().Dy();
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
        boolean FR = com.baidu.swan.apps.performance.f.FR();
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.performance.b.FJ().q(str, "aiapp_launch_id", str).f(str, "aiapp_launch_ext_ab", FR);
        Bundle bundleExtra = intent2.getBundleExtra("aiapps_extra_data");
        Bundle bundle = new Bundle();
        if (bundleExtra != null && !bundleExtra.isEmpty()) {
            bundle.putAll(bundleExtra);
        }
        if (!FR) {
            bundle.putAll(com.baidu.swan.apps.performance.b.FJ().FK().fE(str));
        }
        bundle.putBoolean("aiapp_launch_ext_ab", FR);
        bundle.putLong("aiapp_launch_activity_timestamp", currentTimeMillis);
        intent2.putExtra("aiapps_extra_data", bundle);
        context.startActivity(intent2);
        com.baidu.swan.apps.performance.b.FJ().a(str, swanAppProcessInfo);
        if (DEBUG) {
            Log.i("SwanAppLauncherActivity", "xpass -> startTargetSwanApp: intent.bundle.size=" + (intent2.getExtras() == null ? 0 : intent2.getExtras().size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.ajx.get(), this.ajv);
    }

    private void uC() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.ajv);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        uC();
        com.baidu.swan.apps.v.b.Dx().b(this);
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean uI() {
        finish();
        return false;
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean uJ() {
        finish();
        return false;
    }

    private void uK() {
        String vF = com.baidu.swan.apps.u.a.CK().vF();
        if (TextUtils.isEmpty(vF) || TextUtils.equals(vF.trim(), "null")) {
            StringBuilder sb = new StringBuilder("\n");
            sb.append("1.未实现 AbsSwanAppConfig#getBundleDecryptPublicKey() 接口函数").append("\n");
            sb.append("2.请认真阅读文档和接口注释").append("\n");
            sb.append("3.请到联系 百度 申请 解密使用的 公钥");
            throw new RuntimeException(sb.toString());
        }
    }
}
