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
    private FrameLayout ajP;
    private com.baidu.swan.apps.v.b.c ajQ;
    private WeakReference<SwanAppLauncherActivity> ajR;

    @Override // android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z.P(this);
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onCreate");
        }
        vt();
        if (!n.O(this)) {
            if (!B(getIntent())) {
                finish();
                return;
            }
            this.ajR = new WeakReference<>(this);
            com.baidu.swan.apps.extcore.cores.a.Cp().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.1
                @Override // com.baidu.swan.apps.extcore.c.a
                public void vu() {
                    if (SwanAppLauncherActivity.DEBUG) {
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() SwanCoreVersion: " + com.baidu.swan.apps.swancore.b.dU(SwanAppLauncherActivity.this.ajQ.ayS));
                        Log.d("SwanAppLauncherActivity", "onUpdateFinished() ExtensionCoreVersion: " + com.baidu.swan.apps.extcore.a.Ck().BB());
                        if (com.baidu.swan.apps.swancore.b.Nl()) {
                            com.baidu.swan.apps.swancore.c.a.Nq();
                        }
                    }
                    SwanAppLauncherActivity.this.ajQ.atK = com.baidu.swan.apps.swancore.b.dU(SwanAppLauncherActivity.this.ajQ.ayS);
                    SwanAppLauncherActivity.this.ajQ.atL = com.baidu.swan.apps.extcore.a.Ck().BB();
                    com.baidu.swan.apps.v.b.ED().a(SwanAppLauncherActivity.this);
                    if (!com.baidu.swan.apps.ac.a.a.d(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.ajQ)) {
                        SwanAppLauncherActivity.this.setContentView(a.g.aiapps_launcher_activity);
                        SwanAppLauncherActivity.this.ajP = (FrameLayout) SwanAppLauncherActivity.this.findViewById(a.f.launch_loading_container);
                        SwanAppLauncherActivity.this.showLoadingView();
                        if (com.baidu.swan.apps.core.pms.a.co(SwanAppLauncherActivity.this.ajQ.ayS)) {
                            com.baidu.swan.apps.v.c.b(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.ajQ);
                        } else {
                            com.baidu.swan.apps.core.a.c.a(SwanAppLauncherActivity.this, SwanAppLauncherActivity.this.ajQ);
                        }
                    }
                }
            }, this.ajQ.ayS);
            Bundle bundle2 = new Bundle();
            bundle2.putString("bundle_key_preload_preload_scene", "1");
            com.baidu.swan.apps.process.messaging.service.c.b(this, bundle2);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.ajQ != null) {
            Bundle EK = this.ajQ.EK();
            if (EK != null && EK.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - EK.getLong("ext_launch_time", 0L));
                f fVar = new f();
                fVar.mFrom = e.dM(this.ajQ.ayS);
                fVar.mType = "launch";
                fVar.mValue = "cancel";
                fVar.aVp = valueOf;
                fVar.d(this.ajQ);
                fVar.ak(e.hm(this.ajQ.ayP));
                e.onEvent(fVar);
                f fVar2 = new f();
                fVar2.mFrom = e.dM(this.ajQ.ayS);
                fVar2.mType = "launch";
                fVar2.mValue = "realcancel";
                fVar2.aVp = valueOf;
                fVar2.d(this.ajQ);
                fVar2.ak(e.hm(this.ajQ.ayP));
                fVar2.k("reason", "cancel");
                if (this.ajQ.ayS == 1) {
                    fVar2.k("errorList", com.baidu.swan.games.r.b.Sm().Sn());
                }
                e.onEvent(fVar2);
                EK.remove("launch_flag_for_statistic");
                com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("cancel"));
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
        super.onBackPressed();
    }

    public static void a(Context context, final com.baidu.swan.apps.v.b.b bVar, final String str) {
        if (!aC(context)) {
            long hH = com.baidu.swan.apps.swancore.b.hH(bVar.Ff());
            long j = bVar.BA() != null ? bVar.BA().aVW : 0L;
            if (DEBUG) {
                Log.d("SwanAppLauncherActivity", "SwanCoreVersion target string version: " + bVar.Ff() + " target version: " + hH + " ,targetSwanVersion: " + j);
            }
            if (hH > j) {
                com.baidu.swan.apps.swancore.b.dR(bVar.Fg());
            }
            String bc = com.baidu.swan.apps.u.a.DG().bc(context);
            final WeakReference weakReference = new WeakReference(context);
            bVar.aj("extra_data_uid_key", bc);
            com.baidu.swan.apps.process.a.Iu().b(new a.InterfaceC0156a() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.2
                @Override // com.baidu.swan.apps.process.a.InterfaceC0156a
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
        this.ajQ = com.baidu.swan.apps.v.b.c.G(intent);
        return this.ajQ != null;
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
        a.b gh = com.baidu.swan.apps.process.messaging.service.a.IK().gh(bVar.getAppId());
        gh.gl(bVar.getAppId());
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", "onReady processId: " + gh.aGX + " ,client:" + gh.toString());
        }
        a(context, intent, gh.aGX, str);
        com.baidu.swan.apps.env.b Ci = d.Cg().Ci();
        if (Ci != null && Ci.Cf()) {
            Ci.eo(bVar.getAppId());
        }
        com.baidu.swan.apps.v.b.ED().EE();
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
        boolean HX = com.baidu.swan.apps.performance.f.HX();
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.performance.b.HP().d(str, "swan_launch_type", com.baidu.swan.apps.am.a.Oo());
        com.baidu.swan.apps.performance.b.HP().q(str, "aiapp_launch_id", str).f(str, "aiapp_launch_ext_ab", HX);
        Bundle bundleExtra = intent2.getBundleExtra("aiapps_extra_data");
        Bundle bundle = new Bundle();
        if (bundleExtra != null && !bundleExtra.isEmpty()) {
            bundle.putAll(bundleExtra);
        }
        if (!HX) {
            bundle.putAll(com.baidu.swan.apps.performance.b.HP().HQ().fT(str));
        }
        bundle.putBoolean("aiapp_launch_ext_ab", HX);
        bundle.putLong("aiapp_launch_activity_timestamp", currentTimeMillis);
        intent2.putExtra("aiapps_extra_data", bundle);
        context.startActivity(intent2);
        com.baidu.swan.apps.performance.b.HP().a(str, swanAppProcessInfo);
        if (DEBUG) {
            Log.i("SwanAppLauncherActivity", "xpass -> startTargetSwanApp: intent.bundle.size=" + (intent2.getExtras() == null ? 0 : intent2.getExtras().size()));
        }
        com.baidu.swan.apps.v.c.a.eR(str).Fp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.ajR.get(), this.ajP);
    }

    private void vl() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.ajP);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        vl();
        com.baidu.swan.apps.v.b.ED().b(this);
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean vr() {
        finish();
        return false;
    }

    @Override // com.baidu.swan.apps.v.b.a
    public boolean vs() {
        finish();
        return false;
    }

    private void vt() {
        if (TextUtils.isEmpty(com.baidu.swan.apps.u.a.DN().wt())) {
            StringBuilder sb = new StringBuilder("\n");
            sb.append("1.未实现 AbsSwanAppConfig#getBundleDecryptPublicKey() 接口函数").append("\n");
            sb.append("2.请认真阅读文档和接口注释").append("\n");
            sb.append("3.请到联系 百度 申请 解密使用的 公钥");
            throw new RuntimeException(sb.toString());
        }
    }
}
