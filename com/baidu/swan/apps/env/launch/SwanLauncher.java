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
import com.baidu.tieba.a92;
import com.baidu.tieba.a93;
import com.baidu.tieba.ax2;
import com.baidu.tieba.b83;
import com.baidu.tieba.b93;
import com.baidu.tieba.bc3;
import com.baidu.tieba.c92;
import com.baidu.tieba.cx2;
import com.baidu.tieba.d93;
import com.baidu.tieba.do3;
import com.baidu.tieba.e42;
import com.baidu.tieba.ei2;
import com.baidu.tieba.etb;
import com.baidu.tieba.fs4;
import com.baidu.tieba.gi2;
import com.baidu.tieba.hl3;
import com.baidu.tieba.htb;
import com.baidu.tieba.jh2;
import com.baidu.tieba.jl3;
import com.baidu.tieba.jv2;
import com.baidu.tieba.jx2;
import com.baidu.tieba.lm2;
import com.baidu.tieba.ms1;
import com.baidu.tieba.pm2;
import com.baidu.tieba.tw2;
import com.baidu.tieba.vn3;
import com.baidu.tieba.vq3;
import com.baidu.tieba.vsb;
import com.baidu.tieba.wk2;
import com.baidu.tieba.wp3;
import com.baidu.tieba.wsb;
import com.baidu.tieba.ww2;
import com.baidu.tieba.x63;
import com.baidu.tieba.xk2;
import com.baidu.tieba.z83;
import com.baidu.tieba.zj4;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = ms1.a;
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
        public class a implements vq3<Exception> {
            public final /* synthetic */ wsb a;

            public a(wsb wsbVar) {
                this.a = wsbVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.vq3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                wsb wsbVar = this.a;
                wsbVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.vsb.f, com.baidu.tieba.ltb
        public void call(wsb wsbVar) {
            if (a()) {
                wsbVar.onCompleted();
            } else {
                pm2.d().c(new a(wsbVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements ei2 {
            public final /* synthetic */ gi2 a;
            public final /* synthetic */ wsb b;

            public a(gi2 gi2Var, wsb wsbVar) {
                this.a = gi2Var;
                this.b = wsbVar;
            }

            @Override // com.baidu.tieba.ei2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.ei2
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
            if (!c && !jv2.w0().c()) {
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
                c92.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                c92.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.vsb.f, com.baidu.tieba.ltb
        public void call(wsb wsbVar) {
            jv2.G().c();
            if (a()) {
                wsbVar.onCompleted();
            } else if (jv2.w0().c()) {
                b();
                wsbVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    wsbVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    wsbVar.onCompleted();
                }
                e(wsbVar);
            }
        }

        public final gi2 d(e eVar, boolean z) {
            gi2 gi2Var = new gi2();
            gi2Var.a = "by_click";
            int i = this.b.a;
            gi2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return gi2Var;
        }

        public final void e(wsb wsbVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                wsbVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                wsbVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                wsbVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !jv2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                wsbVar.onCompleted();
            }
            g();
            gi2 d = d(this.b, z);
            jv2.w0().b(d, new a(d, wsbVar));
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
    public class a implements wsb {
        public final /* synthetic */ b93 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.wsb
        public void onSubscribe(etb etbVar) {
        }

        public a(b93 b93Var, Bundle bundle, int i, String str) {
            this.a = b93Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.wsb
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            bc3.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.wsb
        public void onError(Throwable th) {
            if (wp3.G() && (th instanceof T7CheckException)) {
                return;
            }
            bc3.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ b93 a;

        public b(SwanLauncher swanLauncher, b93 b93Var) {
            this.a = b93Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements z83 {
        public final /* synthetic */ b93 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, b93 b93Var, String str) {
            this.a = b93Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.z83
        public void a(String str, b93 b93Var) {
            if (b93Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && b93Var.E() && TextUtils.equals(this.b, b93Var.getAppId())) {
                d93.k().h(this);
                tw2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                d93.k().h(this);
                tw2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.z83
        public void timeout() {
            tw2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements wsb {
        public final /* synthetic */ vq3 a;

        public d(SwanLauncher swanLauncher, vq3 vq3Var) {
            this.a = vq3Var;
        }

        @Override // com.baidu.tieba.wsb
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            vq3 vq3Var = this.a;
            if (vq3Var != null) {
                vq3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.wsb
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            vq3 vq3Var = this.a;
            if (vq3Var != null) {
                vq3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.wsb
        public void onSubscribe(etb etbVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + etbVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements vsb.f {
        public boolean a;

        @Override // com.baidu.tieba.vsb.f, com.baidu.tieba.ltb
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

    public void l(vq3<Exception> vq3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, vq3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        c92.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, b93 b93Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d93.k().c(new c(this, b93Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(cx2 cx2Var, Bundle bundle) {
        if (cx2Var != null && !TextUtils.isEmpty(cx2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", cx2Var.H());
            bundle2.putAll(cx2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull wsb wsbVar, f... fVarArr) {
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
                    arrayList.add(vsb.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                vsb.a(arrayList).h(htb.b()).d(htb.b()).g(wsbVar);
                return;
            } else {
                wsbVar.onCompleted();
                return;
            }
        }
        wsbVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        vn3 vn3Var = new vn3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        vn3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        vn3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        vn3Var.d(str2);
        ww2.f(AppRuntime.getAppContext(), vn3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", jv2.o().E());
        bundle.putInt("host_launch_type", do3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        x63.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        b93 r = d93.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (xk2.b(string, string2)) {
            bundle.putLong("launch_interval", xk2.a());
            xk2.c();
            xk2.d(bundle);
            return;
        }
        xk2.e(string, string2);
        xk2.c();
        c92.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", a92.b(e42.a(string)));
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
        wk2.c(i2);
    }

    @UiThread
    public final void o(b93 b93Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (hl3.j()) {
            jl3.e();
        }
        SwanCoreVersion e2 = hl3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = lm2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = b83.I(ax2.f1(bundle));
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
            jSONObject2 = fs4.b(bundle.getString("mFrom"), null);
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
        a93.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(b93Var, bundle);
        Intent intent = new Intent(appContext, b93Var.O().activity);
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
            jv2.d0().a(bundle.getString("mAppId"), b93Var);
            d(bundle.getString("mAppId"), b93Var);
        }
        bc3.M().post(new b(this, b93Var));
    }

    public final int q(@NonNull b93 b93Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = zj4.i().u(b93Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (jh2.a.b()) {
                e2 = jx2.b(u, bundle);
            } else {
                e2 = jx2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                jh2.b(b93Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + b93Var.R());
        }
        return i2;
    }
}
