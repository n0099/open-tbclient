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
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ai2;
import com.baidu.tieba.an3;
import com.baidu.tieba.au2;
import com.baidu.tieba.b43;
import com.baidu.tieba.bi2;
import com.baidu.tieba.d63;
import com.baidu.tieba.dh4;
import com.baidu.tieba.e62;
import com.baidu.tieba.e63;
import com.baidu.tieba.eu2;
import com.baidu.tieba.f53;
import com.baidu.tieba.f63;
import com.baidu.tieba.f7b;
import com.baidu.tieba.f93;
import com.baidu.tieba.g62;
import com.baidu.tieba.g7b;
import com.baidu.tieba.gu2;
import com.baidu.tieba.h63;
import com.baidu.tieba.hl3;
import com.baidu.tieba.i12;
import com.baidu.tieba.if2;
import com.baidu.tieba.jp4;
import com.baidu.tieba.kf2;
import com.baidu.tieba.li3;
import com.baidu.tieba.ne2;
import com.baidu.tieba.ni3;
import com.baidu.tieba.ns2;
import com.baidu.tieba.nu2;
import com.baidu.tieba.o7b;
import com.baidu.tieba.pj2;
import com.baidu.tieba.qp1;
import com.baidu.tieba.r7b;
import com.baidu.tieba.tj2;
import com.baidu.tieba.xt2;
import com.baidu.tieba.zk3;
import com.baidu.tieba.zn3;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = qp1.a;
    public static final f b = new h(0);
    public static final f c = new h(1);

    /* loaded from: classes4.dex */
    public static class g {
        public static final SwanLauncher a = new SwanLauncher(null);
    }

    /* loaded from: classes4.dex */
    public static final class e {
        public int a;
        public int b;
        public Bundle c;

        /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class h extends f {
        public final int b;

        /* loaded from: classes4.dex */
        public class a implements zn3<Exception> {
            public final /* synthetic */ g7b a;

            public a(g7b g7bVar) {
                this.a = g7bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.zn3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                g7b g7bVar = this.a;
                g7bVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.f7b.f, com.baidu.tieba.v7b
        public void call(g7b g7bVar) {
            if (a()) {
                g7bVar.onCompleted();
            } else {
                tj2.d().c(new a(g7bVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements if2 {
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ g7b b;

            public a(kf2 kf2Var, g7b g7bVar) {
                this.a = kf2Var;
                this.b = g7bVar;
            }

            @Override // com.baidu.tieba.if2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.if2
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
            if (!c && !ns2.w0().c()) {
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
                g62.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                g62.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.f7b.f, com.baidu.tieba.v7b
        public void call(g7b g7bVar) {
            ns2.G().c();
            if (a()) {
                g7bVar.onCompleted();
            } else if (ns2.w0().c()) {
                b();
                g7bVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    g7bVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    g7bVar.onCompleted();
                }
                e(g7bVar);
            }
        }

        public final kf2 d(e eVar, boolean z) {
            kf2 kf2Var = new kf2();
            kf2Var.a = "by_click";
            int i = this.b.a;
            kf2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return kf2Var;
        }

        public final void e(g7b g7bVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                g7bVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                g7bVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                g7bVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !ns2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                g7bVar.onCompleted();
            }
            g();
            kf2 d = d(this.b, z);
            ns2.w0().b(d, new a(d, g7bVar));
        }
    }

    /* loaded from: classes4.dex */
    public static class T7CheckException extends Exception {
        public T7CheckException() {
        }

        public /* synthetic */ T7CheckException(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class a implements g7b {
        public final /* synthetic */ f63 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.g7b
        public void onSubscribe(o7b o7bVar) {
        }

        public a(f63 f63Var, Bundle bundle, int i, String str) {
            this.a = f63Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.g7b
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            f93.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.g7b
        public void onError(Throwable th) {
            if (an3.G() && (th instanceof T7CheckException)) {
                return;
            }
            f93.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ f63 a;

        public b(SwanLauncher swanLauncher, f63 f63Var) {
            this.a = f63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d63 {
        public final /* synthetic */ f63 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, f63 f63Var, String str) {
            this.a = f63Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.d63
        public void a(String str, f63 f63Var) {
            if (f63Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && f63Var.E() && TextUtils.equals(this.b, f63Var.getAppId())) {
                h63.k().h(this);
                xt2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                h63.k().h(this);
                xt2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.d63
        public void timeout() {
            xt2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements g7b {
        public final /* synthetic */ zn3 a;

        public d(SwanLauncher swanLauncher, zn3 zn3Var) {
            this.a = zn3Var;
        }

        @Override // com.baidu.tieba.g7b
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            zn3 zn3Var = this.a;
            if (zn3Var != null) {
                zn3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.g7b
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            zn3 zn3Var = this.a;
            if (zn3Var != null) {
                zn3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.g7b
        public void onSubscribe(o7b o7bVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + o7bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements f7b.f {
        public boolean a;

        @Override // com.baidu.tieba.f7b.f, com.baidu.tieba.v7b
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

    public void l(zn3<Exception> zn3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, zn3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        g62.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, f63 f63Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h63.k().c(new c(this, f63Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(gu2 gu2Var, Bundle bundle) {
        if (gu2Var != null && !TextUtils.isEmpty(gu2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", gu2Var.H());
            bundle2.putAll(gu2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull g7b g7bVar, f... fVarArr) {
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
                    arrayList.add(f7b.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                f7b.a(arrayList).h(r7b.b()).d(r7b.b()).g(g7bVar);
                return;
            } else {
                g7bVar.onCompleted();
                return;
            }
        }
        g7bVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        zk3 zk3Var = new zk3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        zk3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        zk3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        zk3Var.d(str2);
        au2.f(AppRuntime.getAppContext(), zk3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", ns2.o().E());
        bundle.putInt("host_launch_type", hl3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        b43.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        f63 r = h63.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (bi2.b(string, string2)) {
            bundle.putLong("launch_interval", bi2.a());
            bi2.c();
            bi2.d(bundle);
            return;
        }
        bi2.e(string, string2);
        bi2.c();
        g62.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", e62.b(i12.a(string)));
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
        ai2.c(i2);
    }

    @UiThread
    public final void o(f63 f63Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (li3.j()) {
            ni3.e();
        }
        SwanCoreVersion e2 = li3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = pj2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = f53.I(eu2.f1(bundle));
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
        String string = bundle2.getString("ubc");
        if (TextUtils.isEmpty(string)) {
            jSONObject2 = jp4.b(bundle.getString("mFrom"), null);
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
        bundle2.putString("ubc", jSONObject2.toString());
        e63.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(f63Var, bundle);
        Intent intent = new Intent(appContext, f63Var.O().activity);
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
            ns2.d0().a(bundle.getString("mAppId"), f63Var);
            d(bundle.getString("mAppId"), f63Var);
        }
        f93.M().post(new b(this, f63Var));
    }

    public final int q(@NonNull f63 f63Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = dh4.i().u(f63Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (ne2.a.b()) {
                e2 = nu2.b(u, bundle);
            } else {
                e2 = nu2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                ne2.b(f63Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + f63Var.R());
        }
        return i2;
    }
}
