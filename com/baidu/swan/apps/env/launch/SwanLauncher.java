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
import com.baidu.tieba.ao4;
import com.baidu.tieba.be2;
import com.baidu.tieba.ch3;
import com.baidu.tieba.ed2;
import com.baidu.tieba.eh3;
import com.baidu.tieba.er2;
import com.baidu.tieba.et2;
import com.baidu.tieba.gi2;
import com.baidu.tieba.h5b;
import com.baidu.tieba.ho1;
import com.baidu.tieba.i5b;
import com.baidu.tieba.ki2;
import com.baidu.tieba.os2;
import com.baidu.tieba.q5b;
import com.baidu.tieba.qj3;
import com.baidu.tieba.qm3;
import com.baidu.tieba.rg2;
import com.baidu.tieba.rl3;
import com.baidu.tieba.rs2;
import com.baidu.tieba.s23;
import com.baidu.tieba.sg2;
import com.baidu.tieba.t5b;
import com.baidu.tieba.u43;
import com.baidu.tieba.uf4;
import com.baidu.tieba.v42;
import com.baidu.tieba.v43;
import com.baidu.tieba.vs2;
import com.baidu.tieba.w33;
import com.baidu.tieba.w43;
import com.baidu.tieba.w73;
import com.baidu.tieba.x42;
import com.baidu.tieba.xs2;
import com.baidu.tieba.y43;
import com.baidu.tieba.yj3;
import com.baidu.tieba.zd2;
import com.baidu.tieba.zz1;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class SwanLauncher {
    public static final boolean a = ho1.a;
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
        public class a implements qm3<Exception> {
            public final /* synthetic */ i5b a;

            public a(i5b i5bVar) {
                this.a = i5bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.qm3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                i5b i5bVar = this.a;
                i5bVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.h5b.f, com.baidu.tieba.x5b
        public void call(i5b i5bVar) {
            if (a()) {
                i5bVar.onCompleted();
            } else {
                ki2.d().c(new a(i5bVar), this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes3.dex */
        public class a implements zd2 {
            public final /* synthetic */ be2 a;
            public final /* synthetic */ i5b b;

            public a(be2 be2Var, i5b i5bVar) {
                this.a = be2Var;
                this.b = i5bVar;
            }

            @Override // com.baidu.tieba.zd2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.zd2
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
            if (!c && !er2.w0().c()) {
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
                x42.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                x42.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.h5b.f, com.baidu.tieba.x5b
        public void call(i5b i5bVar) {
            er2.G().c();
            if (a()) {
                i5bVar.onCompleted();
            } else if (er2.w0().c()) {
                b();
                i5bVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    i5bVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    i5bVar.onCompleted();
                }
                e(i5bVar);
            }
        }

        public final be2 d(e eVar, boolean z) {
            be2 be2Var = new be2();
            be2Var.a = "by_click";
            int i = this.b.a;
            be2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return be2Var;
        }

        public final void e(i5b i5bVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                i5bVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                i5bVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                i5bVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !er2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                i5bVar.onCompleted();
            }
            g();
            be2 d = d(this.b, z);
            er2.w0().b(d, new a(d, i5bVar));
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
    public class a implements i5b {
        public final /* synthetic */ w43 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.i5b
        public void onSubscribe(q5b q5bVar) {
        }

        public a(w43 w43Var, Bundle bundle, int i, String str) {
            this.a = w43Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.i5b
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            w73.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.i5b
        public void onError(Throwable th) {
            if (rl3.G() && (th instanceof T7CheckException)) {
                return;
            }
            w73.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ w43 a;

        public b(SwanLauncher swanLauncher, w43 w43Var) {
            this.a = w43Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements u43 {
        public final /* synthetic */ w43 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, w43 w43Var, String str) {
            this.a = w43Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.u43
        public void a(String str, w43 w43Var) {
            if (w43Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && w43Var.E() && TextUtils.equals(this.b, w43Var.getAppId())) {
                y43.k().h(this);
                os2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                y43.k().h(this);
                os2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.u43
        public void timeout() {
            os2.k(this.b);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements i5b {
        public final /* synthetic */ qm3 a;

        public d(SwanLauncher swanLauncher, qm3 qm3Var) {
            this.a = qm3Var;
        }

        @Override // com.baidu.tieba.i5b
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            qm3 qm3Var = this.a;
            if (qm3Var != null) {
                qm3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.i5b
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            qm3 qm3Var = this.a;
            if (qm3Var != null) {
                qm3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.i5b
        public void onSubscribe(q5b q5bVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + q5bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class f implements h5b.f {
        public boolean a;

        @Override // com.baidu.tieba.h5b.f, com.baidu.tieba.x5b
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

    public void l(qm3<Exception> qm3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, qm3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        x42.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, w43 w43Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        y43.k().c(new c(this, w43Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(xs2 xs2Var, Bundle bundle) {
        if (xs2Var != null && !TextUtils.isEmpty(xs2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", xs2Var.H());
            bundle2.putAll(xs2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull i5b i5bVar, f... fVarArr) {
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
                    arrayList.add(h5b.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                h5b.a(arrayList).h(t5b.b()).d(t5b.b()).g(i5bVar);
                return;
            } else {
                i5bVar.onCompleted();
                return;
            }
        }
        i5bVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        qj3 qj3Var = new qj3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        qj3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        qj3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        qj3Var.d(str2);
        rs2.f(AppRuntime.getAppContext(), qj3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", er2.o().E());
        bundle.putInt("host_launch_type", yj3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        s23.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        w43 r = y43.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (sg2.b(string, string2)) {
            bundle.putLong("launch_interval", sg2.a());
            sg2.c();
            sg2.d(bundle);
            return;
        }
        sg2.e(string, string2);
        sg2.c();
        x42.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", v42.b(zz1.a(string)));
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
        rg2.c(i2);
    }

    @UiThread
    public final void o(w43 w43Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (ch3.j()) {
            eh3.e();
        }
        SwanCoreVersion e2 = ch3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = gi2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = w33.I(vs2.f1(bundle));
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
            jSONObject2 = ao4.b(bundle.getString("mFrom"), null);
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
        v43.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(w43Var, bundle);
        Intent intent = new Intent(appContext, w43Var.O().activity);
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
            er2.d0().a(bundle.getString("mAppId"), w43Var);
            d(bundle.getString("mAppId"), w43Var);
        }
        w73.M().post(new b(this, w43Var));
    }

    public final int q(@NonNull w43 w43Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = uf4.i().u(w43Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (ed2.a.b()) {
                e2 = et2.b(u, bundle);
            } else {
                e2 = et2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                ed2.b(w43Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + w43Var.R());
        }
        return i2;
    }
}
