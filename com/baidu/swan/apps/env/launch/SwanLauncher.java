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
import com.baidu.tieba.a83;
import com.baidu.tieba.aj4;
import com.baidu.tieba.b82;
import com.baidu.tieba.b83;
import com.baidu.tieba.bw2;
import com.baidu.tieba.c73;
import com.baidu.tieba.c83;
import com.baidu.tieba.cb3;
import com.baidu.tieba.d82;
import com.baidu.tieba.dw2;
import com.baidu.tieba.e83;
import com.baidu.tieba.en3;
import com.baidu.tieba.f32;
import com.baidu.tieba.fh2;
import com.baidu.tieba.gr4;
import com.baidu.tieba.hh2;
import com.baidu.tieba.ik3;
import com.baidu.tieba.kg2;
import com.baidu.tieba.kk3;
import com.baidu.tieba.ku2;
import com.baidu.tieba.kw2;
import com.baidu.tieba.ml2;
import com.baidu.tieba.n7c;
import com.baidu.tieba.nr1;
import com.baidu.tieba.o7c;
import com.baidu.tieba.ql2;
import com.baidu.tieba.uv2;
import com.baidu.tieba.w7c;
import com.baidu.tieba.wm3;
import com.baidu.tieba.wp3;
import com.baidu.tieba.xj2;
import com.baidu.tieba.xo3;
import com.baidu.tieba.xv2;
import com.baidu.tieba.y53;
import com.baidu.tieba.yj2;
import com.baidu.tieba.z7c;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = nr1.a;
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
        public class a implements wp3<Exception> {
            public final /* synthetic */ o7c a;

            public a(o7c o7cVar) {
                this.a = o7cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.wp3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                o7c o7cVar = this.a;
                o7cVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.n7c.f, com.baidu.tieba.d8c
        public void call(o7c o7cVar) {
            if (a()) {
                o7cVar.onCompleted();
            } else {
                ql2.d().c(new a(o7cVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements fh2 {
            public final /* synthetic */ hh2 a;
            public final /* synthetic */ o7c b;

            public a(hh2 hh2Var, o7c o7cVar) {
                this.a = hh2Var;
                this.b = o7cVar;
            }

            @Override // com.baidu.tieba.fh2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.fh2
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
            if (!c && !ku2.w0().c()) {
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
                d82.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                d82.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.n7c.f, com.baidu.tieba.d8c
        public void call(o7c o7cVar) {
            ku2.G().c();
            if (a()) {
                o7cVar.onCompleted();
            } else if (ku2.w0().c()) {
                b();
                o7cVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    o7cVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    o7cVar.onCompleted();
                }
                e(o7cVar);
            }
        }

        public final hh2 d(e eVar, boolean z) {
            hh2 hh2Var = new hh2();
            hh2Var.a = "by_click";
            int i = this.b.a;
            hh2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return hh2Var;
        }

        public final void e(o7c o7cVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                o7cVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                o7cVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                o7cVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !ku2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                o7cVar.onCompleted();
            }
            g();
            hh2 d = d(this.b, z);
            ku2.w0().b(d, new a(d, o7cVar));
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
    public class a implements o7c {
        public final /* synthetic */ c83 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.o7c
        public void onSubscribe(w7c w7cVar) {
        }

        public a(c83 c83Var, Bundle bundle, int i, String str) {
            this.a = c83Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            cb3.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            if (xo3.G() && (th instanceof T7CheckException)) {
                return;
            }
            cb3.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ c83 a;

        public b(SwanLauncher swanLauncher, c83 c83Var) {
            this.a = c83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a83 {
        public final /* synthetic */ c83 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, c83 c83Var, String str) {
            this.a = c83Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.a83
        public void a(String str, c83 c83Var) {
            if (c83Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && c83Var.E() && TextUtils.equals(this.b, c83Var.getAppId())) {
                e83.k().h(this);
                uv2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                e83.k().h(this);
                uv2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.a83
        public void timeout() {
            uv2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements o7c {
        public final /* synthetic */ wp3 a;

        public d(SwanLauncher swanLauncher, wp3 wp3Var) {
            this.a = wp3Var;
        }

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            wp3 wp3Var = this.a;
            if (wp3Var != null) {
                wp3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            wp3 wp3Var = this.a;
            if (wp3Var != null) {
                wp3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onSubscribe(w7c w7cVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + w7cVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements n7c.f {
        public boolean a;

        @Override // com.baidu.tieba.n7c.f, com.baidu.tieba.d8c
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

    public void l(wp3<Exception> wp3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, wp3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        d82.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, c83 c83Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e83.k().c(new c(this, c83Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(dw2 dw2Var, Bundle bundle) {
        if (dw2Var != null && !TextUtils.isEmpty(dw2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", dw2Var.H());
            bundle2.putAll(dw2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull o7c o7cVar, f... fVarArr) {
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
                    arrayList.add(n7c.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                n7c.a(arrayList).h(z7c.b()).d(z7c.b()).g(o7cVar);
                return;
            } else {
                o7cVar.onCompleted();
                return;
            }
        }
        o7cVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        wm3 wm3Var = new wm3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        wm3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        wm3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        wm3Var.d(str2);
        xv2.f(AppRuntime.getAppContext(), wm3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", ku2.o().E());
        bundle.putInt("host_launch_type", en3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        y53.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        c83 r = e83.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (yj2.b(string, string2)) {
            bundle.putLong("launch_interval", yj2.a());
            yj2.c();
            yj2.d(bundle);
            return;
        }
        yj2.e(string, string2);
        yj2.c();
        d82.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", b82.b(f32.a(string)));
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
        xj2.c(i2);
    }

    @UiThread
    public final void o(c83 c83Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (ik3.j()) {
            kk3.e();
        }
        SwanCoreVersion e2 = ik3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = ml2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = c73.I(bw2.f1(bundle));
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
            jSONObject2 = gr4.b(bundle.getString("mFrom"), null);
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
        b83.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(c83Var, bundle);
        Intent intent = new Intent(appContext, c83Var.O().activity);
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
            ku2.d0().a(bundle.getString("mAppId"), c83Var);
            d(bundle.getString("mAppId"), c83Var);
        }
        cb3.M().post(new b(this, c83Var));
    }

    public final int q(@NonNull c83 c83Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = aj4.i().u(c83Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (kg2.a.b()) {
                e2 = kw2.b(u, bundle);
            } else {
                e2 = kw2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                kg2.b(c83Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + c83Var.R());
        }
        return i2;
    }
}
