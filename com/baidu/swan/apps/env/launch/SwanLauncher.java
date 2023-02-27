package com.baidu.swan.apps.env.launch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.cna;
import com.baidu.tieba.du2;
import com.baidu.tieba.fl3;
import com.baidu.tieba.fo3;
import com.baidu.tieba.gi2;
import com.baidu.tieba.gn3;
import com.baidu.tieba.gu2;
import com.baidu.tieba.h43;
import com.baidu.tieba.hi2;
import com.baidu.tieba.j63;
import com.baidu.tieba.jh4;
import com.baidu.tieba.k62;
import com.baidu.tieba.k63;
import com.baidu.tieba.ku2;
import com.baidu.tieba.l53;
import com.baidu.tieba.l63;
import com.baidu.tieba.l93;
import com.baidu.tieba.m62;
import com.baidu.tieba.mu2;
import com.baidu.tieba.n63;
import com.baidu.tieba.nl3;
import com.baidu.tieba.o12;
import com.baidu.tieba.of2;
import com.baidu.tieba.pp4;
import com.baidu.tieba.qf2;
import com.baidu.tieba.qma;
import com.baidu.tieba.ri3;
import com.baidu.tieba.rma;
import com.baidu.tieba.te2;
import com.baidu.tieba.ti3;
import com.baidu.tieba.ts2;
import com.baidu.tieba.tu2;
import com.baidu.tieba.vj2;
import com.baidu.tieba.wp1;
import com.baidu.tieba.zj2;
import com.baidu.tieba.zma;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class SwanLauncher {
    public static final boolean a = wp1.a;
    public static final f b = new h(0);
    public static final f c = new h(1);

    /* loaded from: classes3.dex */
    public static class g {
        public static final SwanLauncher a = new SwanLauncher(null);
    }

    /* loaded from: classes3.dex */
    public static final class e {
        public int a;
        public int b;
        public Bundle c;

        /* loaded from: classes3.dex */
        public static class a {
            public e a = new e(null);

            public e a() {
                return this.a;
            }

            public a b(int i) {
                this.a.a = i;
                return this;
            }

            public a c(Bundle bundle) {
                this.a.c = bundle;
                return this;
            }

            public a d(int i) {
                this.a.b = i;
                return this;
            }
        }

        public e() {
            this.a = -1;
            this.b = -1;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends f {
        public final int b;

        /* loaded from: classes3.dex */
        public class a implements fo3<Exception> {
            public final /* synthetic */ rma a;

            public a(rma rmaVar) {
                this.a = rmaVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.fo3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                rma rmaVar = this.a;
                rmaVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.qma.f, com.baidu.tieba.gna
        public void call(rma rmaVar) {
            if (a()) {
                rmaVar.onCompleted();
            } else {
                zj2.d().c(new a(rmaVar), this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes3.dex */
        public class a implements of2 {
            public final /* synthetic */ qf2 a;
            public final /* synthetic */ rma b;

            public a(qf2 qf2Var, rma rmaVar) {
                this.a = qf2Var;
                this.b = rmaVar;
            }

            @Override // com.baidu.tieba.of2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.of2
            public void onSuccess() {
                i.this.f();
                if (this.a.b) {
                    i.this.b();
                    this.b.onCompleted();
                }
            }
        }

        public i(@NonNull e eVar) {
            super(null);
            this.b = eVar;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public boolean a() {
            if (!c && !ts2.w0().c()) {
                return false;
            }
            return true;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public void b() {
            c = true;
        }

        public final void f() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_end", System.currentTimeMillis());
                m62.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                m62.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.qma.f, com.baidu.tieba.gna
        public void call(rma rmaVar) {
            ts2.G().c();
            if (a()) {
                rmaVar.onCompleted();
            } else if (ts2.w0().c()) {
                b();
                rmaVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    rmaVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    rmaVar.onCompleted();
                }
                e(rmaVar);
            }
        }

        public final qf2 d(e eVar, boolean z) {
            qf2 qf2Var = new qf2();
            qf2Var.a = "by_click";
            int i = this.b.a;
            qf2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return qf2Var;
        }

        public final void e(rma rmaVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                rmaVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                rmaVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                rmaVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !ts2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                rmaVar.onCompleted();
            }
            g();
            qf2 d = d(this.b, z);
            ts2.w0().b(d, new a(d, rmaVar));
        }
    }

    /* loaded from: classes3.dex */
    public static class T7CheckException extends Exception {
        public T7CheckException() {
        }

        public /* synthetic */ T7CheckException(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements rma {
        public final /* synthetic */ l63 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.rma
        public void onSubscribe(zma zmaVar) {
        }

        public a(l63 l63Var, Bundle bundle, int i, String str) {
            this.a = l63Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.rma
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            l93.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.rma
        public void onError(Throwable th) {
            if (gn3.G() && (th instanceof T7CheckException)) {
                return;
            }
            l93.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ l63 a;

        public b(SwanLauncher swanLauncher, l63 l63Var) {
            this.a = l63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j63 {
        public final /* synthetic */ l63 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, l63 l63Var, String str) {
            this.a = l63Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.j63
        public void a(String str, l63 l63Var) {
            if (l63Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && l63Var.E() && TextUtils.equals(this.b, l63Var.getAppId())) {
                n63.k().h(this);
                du2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                n63.k().h(this);
                du2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.j63
        public void timeout() {
            du2.k(this.b);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements rma {
        public final /* synthetic */ fo3 a;

        public d(SwanLauncher swanLauncher, fo3 fo3Var) {
            this.a = fo3Var;
        }

        @Override // com.baidu.tieba.rma
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            fo3 fo3Var = this.a;
            if (fo3Var != null) {
                fo3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.rma
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            fo3 fo3Var = this.a;
            if (fo3Var != null) {
                fo3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.rma
        public void onSubscribe(zma zmaVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + zmaVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class f implements qma.f {
        public boolean a;

        @Override // com.baidu.tieba.qma.f, com.baidu.tieba.gna
        public abstract /* synthetic */ void call(T t);

        public f() {
            this.a = false;
        }

        public boolean a() {
            return this.a;
        }

        public void b() {
            this.a = true;
        }

        @NonNull
        public String toString() {
            return super.toString() + " checked=" + this.a;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public SwanLauncher() {
    }

    public static String h() {
        return UUID.randomUUID().toString();
    }

    public static SwanLauncher j() {
        return g.a;
    }

    public /* synthetic */ SwanLauncher(a aVar) {
        this();
    }

    public static String g(@NonNull Bundle bundle) {
        String string = bundle.getString("launch_id");
        if (TextUtils.isEmpty(string)) {
            String h2 = h();
            bundle.putString("launch_id", h2);
            return h2;
        }
        return string;
    }

    public static int i(@NonNull Bundle bundle) {
        return Math.max(bundle.getInt("appFrameType", -1), -1);
    }

    public final void f(Bundle bundle) {
        Context appContext = AppRuntime.getAppContext();
        Intent intent = new Intent(appContext, SwanAppLauncherActivity.class);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtras(bundle);
        appContext.startActivity(intent);
    }

    public void l(fo3<Exception> fo3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, fo3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        m62.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, l63 l63Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n63.k().c(new c(this, l63Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(mu2 mu2Var, Bundle bundle) {
        if (mu2Var != null && !TextUtils.isEmpty(mu2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", mu2Var.H());
            bundle2.putAll(mu2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull rma rmaVar, f... fVarArr) {
        if (a) {
            Log.i("SwanLauncher", "checkEnv: checkers=" + fVarArr);
        }
        if (fVarArr != null && fVarArr.length >= 1) {
            ArrayList arrayList = null;
            for (f fVar : fVarArr) {
                if (a) {
                    Log.i("SwanLauncher", "checkEnv: checker=" + fVar);
                }
                if (fVar != null && !fVar.a()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(qma.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                qma.a(arrayList).h(cna.b()).d(cna.b()).g(rmaVar);
                return;
            } else {
                rmaVar.onCompleted();
                return;
            }
        }
        rmaVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        fl3 fl3Var = new fl3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        fl3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        fl3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        fl3Var.d(str2);
        gu2.f(AppRuntime.getAppContext(), fl3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", ts2.o().E());
        bundle.putInt("host_launch_type", nl3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        h43.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        l63 r = n63.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (hi2.b(string, string2)) {
            bundle.putLong("launch_interval", hi2.a());
            hi2.c();
            hi2.d(bundle);
            return;
        }
        hi2.e(string, string2);
        hi2.c();
        m62.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", k62.b(o12.a(string)));
        String g2 = g(bundle);
        bundle.putLong("launch_time_on_main", System.currentTimeMillis());
        bundle.putInt("main_pid", Process.myPid());
        p("SwanLauncher", "启动小程序 appId=" + string + " launchId=" + g2 + " isColdBoot=" + r.R() + " processId=" + r.b + " client=" + r.toString());
        e.a aVar = new e.a();
        aVar.b(i2);
        aVar.d(1);
        aVar.c(bundle);
        i iVar = new i(aVar.a());
        a aVar2 = new a(r, bundle, i2, string);
        f[] fVarArr = new f[2];
        fVarArr[0] = iVar;
        if (1 == i2) {
            fVar = c;
        } else {
            fVar = b;
        }
        fVarArr[1] = fVar;
        e(aVar2, fVarArr);
        gi2.c(i2);
    }

    @UiThread
    public final void o(l63 l63Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (ri3.j()) {
            ti3.e();
        }
        SwanCoreVersion e2 = ri3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = vj2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = l53.I(ku2.f1(bundle));
        if (I != null) {
            bundle.putAll(I);
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 == null) {
            bundle2 = new Bundle();
            bundle.putBundle("mExtraData", bundle2);
        }
        bundle2.putLong("launch_flag_for_statistic", System.currentTimeMillis());
        bundle2.putLong("page_display_flag_for_statistic", System.currentTimeMillis());
        String string = bundle2.getString(UBCCloudControlProcessor.UBC_KEY);
        if (TextUtils.isEmpty(string)) {
            jSONObject2 = pp4.b(bundle.getString("mFrom"), null);
        } else {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e3) {
                jSONObject = new JSONObject();
                if (a) {
                    e3.printStackTrace();
                }
            }
            jSONObject2 = jSONObject;
        }
        bundle2.putString(UBCCloudControlProcessor.UBC_KEY, jSONObject2.toString());
        k63.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(l63Var, bundle);
        Intent intent = new Intent(appContext, l63Var.O().activity);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtras(bundle);
        intent.putExtra("start_activity_time", System.currentTimeMillis());
        intent.putExtra("preAppReadyState", q);
        try {
            appContext.startActivity(intent);
        } catch (Exception e4) {
            p("SwanLauncher", "#launchSwanActivity startActivity error " + Log.getStackTraceString(e4));
        }
        if (i2 == 0) {
            ts2.d0().a(bundle.getString("mAppId"), l63Var);
            d(bundle.getString("mAppId"), l63Var);
        }
        l93.M().post(new b(this, l63Var));
    }

    public final int q(@NonNull l63 l63Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = jh4.i().u(l63Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (te2.a.b()) {
                e2 = tu2.b(u, bundle);
            } else {
                e2 = tu2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                te2.b(l63Var, bundle);
                i2 = 5;
            } else {
                i2 = 4;
            }
        } else if (u == null) {
            i2 = 2;
        } else if (u.isMaxAgeExpires()) {
            i2 = 3;
        } else {
            i2 = 0;
        }
        if (a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + l63Var.R());
        }
        return i2;
    }
}
