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
import com.baidu.tieba.an3;
import com.baidu.tieba.aq3;
import com.baidu.tieba.bk2;
import com.baidu.tieba.bp3;
import com.baidu.tieba.bw2;
import com.baidu.tieba.c63;
import com.baidu.tieba.cbc;
import com.baidu.tieba.ck2;
import com.baidu.tieba.e83;
import com.baidu.tieba.ej4;
import com.baidu.tieba.f82;
import com.baidu.tieba.f83;
import com.baidu.tieba.fw2;
import com.baidu.tieba.g73;
import com.baidu.tieba.g83;
import com.baidu.tieba.gb3;
import com.baidu.tieba.h82;
import com.baidu.tieba.hw2;
import com.baidu.tieba.i83;
import com.baidu.tieba.in3;
import com.baidu.tieba.j32;
import com.baidu.tieba.jh2;
import com.baidu.tieba.kr4;
import com.baidu.tieba.lh2;
import com.baidu.tieba.mk3;
import com.baidu.tieba.og2;
import com.baidu.tieba.ok3;
import com.baidu.tieba.ou2;
import com.baidu.tieba.ow2;
import com.baidu.tieba.qac;
import com.baidu.tieba.ql2;
import com.baidu.tieba.rac;
import com.baidu.tieba.rr1;
import com.baidu.tieba.ul2;
import com.baidu.tieba.yv2;
import com.baidu.tieba.zac;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = rr1.a;
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
        public class a implements aq3<Exception> {
            public final /* synthetic */ rac a;

            public a(rac racVar) {
                this.a = racVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aq3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                rac racVar = this.a;
                racVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.qac.f, com.baidu.tieba.gbc
        public void call(rac racVar) {
            if (a()) {
                racVar.onCompleted();
            } else {
                ul2.d().c(new a(racVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements jh2 {
            public final /* synthetic */ lh2 a;
            public final /* synthetic */ rac b;

            public a(lh2 lh2Var, rac racVar) {
                this.a = lh2Var;
                this.b = racVar;
            }

            @Override // com.baidu.tieba.jh2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.jh2
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
            if (!c && !ou2.w0().c()) {
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
                h82.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                h82.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.qac.f, com.baidu.tieba.gbc
        public void call(rac racVar) {
            ou2.G().c();
            if (a()) {
                racVar.onCompleted();
            } else if (ou2.w0().c()) {
                b();
                racVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    racVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    racVar.onCompleted();
                }
                e(racVar);
            }
        }

        public final lh2 d(e eVar, boolean z) {
            lh2 lh2Var = new lh2();
            lh2Var.a = "by_click";
            int i = this.b.a;
            lh2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return lh2Var;
        }

        public final void e(rac racVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                racVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                racVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                racVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !ou2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                racVar.onCompleted();
            }
            g();
            lh2 d = d(this.b, z);
            ou2.w0().b(d, new a(d, racVar));
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
    public class a implements rac {
        public final /* synthetic */ g83 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.rac
        public void onSubscribe(zac zacVar) {
        }

        public a(g83 g83Var, Bundle bundle, int i, String str) {
            this.a = g83Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.rac
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            gb3.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.rac
        public void onError(Throwable th) {
            if (bp3.G() && (th instanceof T7CheckException)) {
                return;
            }
            gb3.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ g83 a;

        public b(SwanLauncher swanLauncher, g83 g83Var) {
            this.a = g83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements e83 {
        public final /* synthetic */ g83 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, g83 g83Var, String str) {
            this.a = g83Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.e83
        public void a(String str, g83 g83Var) {
            if (g83Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && g83Var.E() && TextUtils.equals(this.b, g83Var.getAppId())) {
                i83.k().h(this);
                yv2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                i83.k().h(this);
                yv2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.e83
        public void timeout() {
            yv2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements rac {
        public final /* synthetic */ aq3 a;

        public d(SwanLauncher swanLauncher, aq3 aq3Var) {
            this.a = aq3Var;
        }

        @Override // com.baidu.tieba.rac
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            aq3 aq3Var = this.a;
            if (aq3Var != null) {
                aq3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.rac
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            aq3 aq3Var = this.a;
            if (aq3Var != null) {
                aq3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.rac
        public void onSubscribe(zac zacVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + zacVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements qac.f {
        public boolean a;

        @Override // com.baidu.tieba.qac.f, com.baidu.tieba.gbc
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

    public void l(aq3<Exception> aq3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, aq3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        h82.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, g83 g83Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i83.k().c(new c(this, g83Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(hw2 hw2Var, Bundle bundle) {
        if (hw2Var != null && !TextUtils.isEmpty(hw2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", hw2Var.H());
            bundle2.putAll(hw2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull rac racVar, f... fVarArr) {
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
                    arrayList.add(qac.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                qac.a(arrayList).h(cbc.b()).d(cbc.b()).g(racVar);
                return;
            } else {
                racVar.onCompleted();
                return;
            }
        }
        racVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        an3 an3Var = new an3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        an3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        an3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        an3Var.d(str2);
        bw2.f(AppRuntime.getAppContext(), an3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", ou2.o().E());
        bundle.putInt("host_launch_type", in3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        c63.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        g83 r = i83.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (ck2.b(string, string2)) {
            bundle.putLong("launch_interval", ck2.a());
            ck2.c();
            ck2.d(bundle);
            return;
        }
        ck2.e(string, string2);
        ck2.c();
        h82.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", f82.b(j32.a(string)));
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
        bk2.c(i2);
    }

    @UiThread
    public final void o(g83 g83Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (mk3.j()) {
            ok3.e();
        }
        SwanCoreVersion e2 = mk3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = ql2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = g73.I(fw2.f1(bundle));
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
            jSONObject2 = kr4.b(bundle.getString("mFrom"), null);
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
        f83.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(g83Var, bundle);
        Intent intent = new Intent(appContext, g83Var.O().activity);
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
            ou2.d0().a(bundle.getString("mAppId"), g83Var);
            d(bundle.getString("mAppId"), g83Var);
        }
        gb3.M().post(new b(this, g83Var));
    }

    public final int q(@NonNull g83 g83Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = ej4.i().u(g83Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (og2.a.b()) {
                e2 = ow2.b(u, bundle);
            } else {
                e2 = ow2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                og2.b(g83Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + g83Var.R());
        }
        return i2;
    }
}
