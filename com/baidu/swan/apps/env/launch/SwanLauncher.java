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
import com.baidu.tieba.am1;
import com.baidu.tieba.cg2;
import com.baidu.tieba.f6c;
import com.baidu.tieba.g6c;
import com.baidu.tieba.gq2;
import com.baidu.tieba.ih3;
import com.baidu.tieba.ik3;
import com.baidu.tieba.je2;
import com.baidu.tieba.jj3;
import com.baidu.tieba.jq2;
import com.baidu.tieba.k03;
import com.baidu.tieba.ke2;
import com.baidu.tieba.m23;
import com.baidu.tieba.md4;
import com.baidu.tieba.n22;
import com.baidu.tieba.n23;
import com.baidu.tieba.nq2;
import com.baidu.tieba.o13;
import com.baidu.tieba.o23;
import com.baidu.tieba.o53;
import com.baidu.tieba.o6c;
import com.baidu.tieba.p22;
import com.baidu.tieba.pq2;
import com.baidu.tieba.q23;
import com.baidu.tieba.qh3;
import com.baidu.tieba.r6c;
import com.baidu.tieba.rb2;
import com.baidu.tieba.rl4;
import com.baidu.tieba.sx1;
import com.baidu.tieba.tb2;
import com.baidu.tieba.ue3;
import com.baidu.tieba.wa2;
import com.baidu.tieba.we3;
import com.baidu.tieba.wo2;
import com.baidu.tieba.wq2;
import com.baidu.tieba.yf2;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = am1.a;
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
        public class a implements ik3<Exception> {
            public final /* synthetic */ g6c a;

            public a(g6c g6cVar) {
                this.a = g6cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                g6c g6cVar = this.a;
                g6cVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: c */
        public void call(g6c g6cVar) {
            if (a()) {
                g6cVar.onCompleted();
            } else {
                cg2.d().c(new a(g6cVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements rb2 {
            public final /* synthetic */ tb2 a;
            public final /* synthetic */ g6c b;

            public a(tb2 tb2Var, g6c g6cVar) {
                this.a = tb2Var;
                this.b = g6cVar;
            }

            @Override // com.baidu.tieba.rb2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.rb2
            public void onSuccess() {
                i.this.g();
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
            if (!c && !wo2.w0().c()) {
                return false;
            }
            return true;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public void b() {
            c = true;
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_end", System.currentTimeMillis());
                p22.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void h() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                p22.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: d */
        public void call(g6c g6cVar) {
            wo2.G().c();
            if (a()) {
                g6cVar.onCompleted();
            } else if (wo2.w0().c()) {
                b();
                g6cVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    g6cVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    g6cVar.onCompleted();
                }
                f(g6cVar);
            }
        }

        public final tb2 e(e eVar, boolean z) {
            tb2 tb2Var = new tb2();
            tb2Var.a = "by_click";
            int i = this.b.a;
            tb2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return tb2Var;
        }

        public final void f(g6c g6cVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                g6cVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                g6cVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                g6cVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !wo2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                g6cVar.onCompleted();
            }
            h();
            tb2 e = e(this.b, z);
            wo2.w0().b(e, new a(e, g6cVar));
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
    public class a implements g6c {
        public final /* synthetic */ o23 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.g6c
        public void onSubscribe(o6c o6cVar) {
        }

        public a(o23 o23Var, Bundle bundle, int i, String str) {
            this.a = o23Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.g6c
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            o53.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.g6c
        public void onError(Throwable th) {
            if (jj3.G() && (th instanceof T7CheckException)) {
                return;
            }
            o53.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ o23 a;

        public b(SwanLauncher swanLauncher, o23 o23Var) {
            this.a = o23Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements m23 {
        public final /* synthetic */ o23 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, o23 o23Var, String str) {
            this.a = o23Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.m23
        public void a(String str, o23 o23Var) {
            if (o23Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && o23Var.E() && TextUtils.equals(this.b, o23Var.getAppId())) {
                q23.k().h(this);
                gq2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                q23.k().h(this);
                gq2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.m23
        public void timeout() {
            gq2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements g6c {
        public final /* synthetic */ ik3 a;

        public d(SwanLauncher swanLauncher, ik3 ik3Var) {
            this.a = ik3Var;
        }

        @Override // com.baidu.tieba.g6c
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            ik3 ik3Var = this.a;
            if (ik3Var != null) {
                ik3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.g6c
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            ik3 ik3Var = this.a;
            if (ik3Var != null) {
                ik3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.g6c
        public void onSubscribe(o6c o6cVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + o6cVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements f6c.f {
        public boolean a;

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

    public void l(ik3<Exception> ik3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, ik3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        p22.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, o23 o23Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q23.k().c(new c(this, o23Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(pq2 pq2Var, Bundle bundle) {
        if (pq2Var != null && !TextUtils.isEmpty(pq2Var.I())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", pq2Var.I());
            bundle2.putAll(pq2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull g6c g6cVar, f... fVarArr) {
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
                    arrayList.add(f6c.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                f6c.a(arrayList).h(r6c.b()).d(r6c.b()).g(g6cVar);
                return;
            } else {
                g6cVar.onCompleted();
                return;
            }
        }
        g6cVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        ih3 ih3Var = new ih3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        ih3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        ih3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        ih3Var.d(str2);
        jq2.f(AppRuntime.getAppContext(), ih3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", wo2.o().E());
        bundle.putInt("host_launch_type", qh3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        k03.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        o23 r = q23.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (ke2.b(string, string2)) {
            bundle.putLong("launch_interval", ke2.a());
            ke2.c();
            ke2.d(bundle);
            return;
        }
        ke2.e(string, string2);
        ke2.c();
        p22.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", n22.b(sx1.a(string)));
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
        je2.c(i2);
    }

    @UiThread
    public final void o(o23 o23Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (ue3.j()) {
            we3.e();
        }
        SwanCoreVersion e2 = ue3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = yf2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = o13.I(nq2.g1(bundle));
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
            jSONObject2 = rl4.b(bundle.getString("mFrom"), null);
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
        n23.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(o23Var, bundle);
        Intent intent = new Intent(appContext, o23Var.O().activity);
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
            wo2.d0().a(bundle.getString("mAppId"), o23Var);
            d(bundle.getString("mAppId"), o23Var);
        }
        o53.M().post(new b(this, o23Var));
    }

    public final int q(@NonNull o23 o23Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = md4.i().u(o23Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (wa2.a.b()) {
                e2 = wq2.b(u, bundle);
            } else {
                e2 = wq2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                wa2.b(o23Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + o23Var.R());
        }
        return i2;
    }
}
