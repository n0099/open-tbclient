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
import com.baidu.tieba.a93;
import com.baidu.tieba.ao3;
import com.baidu.tieba.b42;
import com.baidu.tieba.bi2;
import com.baidu.tieba.cs4;
import com.baidu.tieba.di2;
import com.baidu.tieba.el3;
import com.baidu.tieba.eob;
import com.baidu.tieba.fob;
import com.baidu.tieba.gh2;
import com.baidu.tieba.gl3;
import com.baidu.tieba.gv2;
import com.baidu.tieba.gx2;
import com.baidu.tieba.im2;
import com.baidu.tieba.js1;
import com.baidu.tieba.mm2;
import com.baidu.tieba.nob;
import com.baidu.tieba.qob;
import com.baidu.tieba.qw2;
import com.baidu.tieba.sn3;
import com.baidu.tieba.sq3;
import com.baidu.tieba.tk2;
import com.baidu.tieba.tp3;
import com.baidu.tieba.tw2;
import com.baidu.tieba.u63;
import com.baidu.tieba.uk2;
import com.baidu.tieba.w83;
import com.baidu.tieba.wj4;
import com.baidu.tieba.x82;
import com.baidu.tieba.x83;
import com.baidu.tieba.xw2;
import com.baidu.tieba.y73;
import com.baidu.tieba.y83;
import com.baidu.tieba.yb3;
import com.baidu.tieba.z82;
import com.baidu.tieba.zw2;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = js1.a;
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
        public class a implements sq3<Exception> {
            public final /* synthetic */ fob a;

            public a(fob fobVar) {
                this.a = fobVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.sq3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                fob fobVar = this.a;
                fobVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.eob.f, com.baidu.tieba.uob
        public void call(fob fobVar) {
            if (a()) {
                fobVar.onCompleted();
            } else {
                mm2.d().c(new a(fobVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements bi2 {
            public final /* synthetic */ di2 a;
            public final /* synthetic */ fob b;

            public a(di2 di2Var, fob fobVar) {
                this.a = di2Var;
                this.b = fobVar;
            }

            @Override // com.baidu.tieba.bi2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.bi2
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
            if (!c && !gv2.w0().c()) {
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
                z82.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                z82.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.eob.f, com.baidu.tieba.uob
        public void call(fob fobVar) {
            gv2.G().c();
            if (a()) {
                fobVar.onCompleted();
            } else if (gv2.w0().c()) {
                b();
                fobVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    fobVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    fobVar.onCompleted();
                }
                e(fobVar);
            }
        }

        public final di2 d(e eVar, boolean z) {
            di2 di2Var = new di2();
            di2Var.a = "by_click";
            int i = this.b.a;
            di2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return di2Var;
        }

        public final void e(fob fobVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                fobVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                fobVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                fobVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !gv2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                fobVar.onCompleted();
            }
            g();
            di2 d = d(this.b, z);
            gv2.w0().b(d, new a(d, fobVar));
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
    public class a implements fob {
        public final /* synthetic */ y83 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.fob
        public void onSubscribe(nob nobVar) {
        }

        public a(y83 y83Var, Bundle bundle, int i, String str) {
            this.a = y83Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.fob
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            yb3.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.fob
        public void onError(Throwable th) {
            if (tp3.G() && (th instanceof T7CheckException)) {
                return;
            }
            yb3.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ y83 a;

        public b(SwanLauncher swanLauncher, y83 y83Var) {
            this.a = y83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w83 {
        public final /* synthetic */ y83 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, y83 y83Var, String str) {
            this.a = y83Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.w83
        public void a(String str, y83 y83Var) {
            if (y83Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && y83Var.E() && TextUtils.equals(this.b, y83Var.getAppId())) {
                a93.k().h(this);
                qw2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                a93.k().h(this);
                qw2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.w83
        public void timeout() {
            qw2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements fob {
        public final /* synthetic */ sq3 a;

        public d(SwanLauncher swanLauncher, sq3 sq3Var) {
            this.a = sq3Var;
        }

        @Override // com.baidu.tieba.fob
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            sq3 sq3Var = this.a;
            if (sq3Var != null) {
                sq3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.fob
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            sq3 sq3Var = this.a;
            if (sq3Var != null) {
                sq3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.fob
        public void onSubscribe(nob nobVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + nobVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements eob.f {
        public boolean a;

        @Override // com.baidu.tieba.eob.f, com.baidu.tieba.uob
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

    public void l(sq3<Exception> sq3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, sq3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        z82.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, y83 y83Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a93.k().c(new c(this, y83Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(zw2 zw2Var, Bundle bundle) {
        if (zw2Var != null && !TextUtils.isEmpty(zw2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", zw2Var.H());
            bundle2.putAll(zw2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull fob fobVar, f... fVarArr) {
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
                    arrayList.add(eob.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                eob.a(arrayList).h(qob.b()).d(qob.b()).g(fobVar);
                return;
            } else {
                fobVar.onCompleted();
                return;
            }
        }
        fobVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        sn3 sn3Var = new sn3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        sn3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        sn3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        sn3Var.d(str2);
        tw2.f(AppRuntime.getAppContext(), sn3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", gv2.o().E());
        bundle.putInt("host_launch_type", ao3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        u63.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        y83 r = a93.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (uk2.b(string, string2)) {
            bundle.putLong("launch_interval", uk2.a());
            uk2.c();
            uk2.d(bundle);
            return;
        }
        uk2.e(string, string2);
        uk2.c();
        z82.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", x82.b(b42.a(string)));
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
        tk2.c(i2);
    }

    @UiThread
    public final void o(y83 y83Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (el3.j()) {
            gl3.e();
        }
        SwanCoreVersion e2 = el3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = im2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = y73.I(xw2.f1(bundle));
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
            jSONObject2 = cs4.b(bundle.getString("mFrom"), null);
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
        x83.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(y83Var, bundle);
        Intent intent = new Intent(appContext, y83Var.O().activity);
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
            gv2.d0().a(bundle.getString("mAppId"), y83Var);
            d(bundle.getString("mAppId"), y83Var);
        }
        yb3.M().post(new b(this, y83Var));
    }

    public final int q(@NonNull y83 y83Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = wj4.i().u(y83Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (gh2.a.b()) {
                e2 = gx2.b(u, bundle);
            } else {
                e2 = gx2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                gh2.b(y83Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + y83Var.R());
        }
        return i2;
    }
}
