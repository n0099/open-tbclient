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
import com.baidu.tieba.a32;
import com.baidu.tieba.ah2;
import com.baidu.tieba.br4;
import com.baidu.tieba.ch2;
import com.baidu.tieba.dk3;
import com.baidu.tieba.e1c;
import com.baidu.tieba.fg2;
import com.baidu.tieba.fk3;
import com.baidu.tieba.fu2;
import com.baidu.tieba.fw2;
import com.baidu.tieba.h1c;
import com.baidu.tieba.hl2;
import com.baidu.tieba.ir1;
import com.baidu.tieba.ll2;
import com.baidu.tieba.pv2;
import com.baidu.tieba.rm3;
import com.baidu.tieba.rp3;
import com.baidu.tieba.sj2;
import com.baidu.tieba.so3;
import com.baidu.tieba.sv2;
import com.baidu.tieba.t53;
import com.baidu.tieba.tj2;
import com.baidu.tieba.v0c;
import com.baidu.tieba.v73;
import com.baidu.tieba.vi4;
import com.baidu.tieba.w0c;
import com.baidu.tieba.w72;
import com.baidu.tieba.w73;
import com.baidu.tieba.wv2;
import com.baidu.tieba.x63;
import com.baidu.tieba.x73;
import com.baidu.tieba.xa3;
import com.baidu.tieba.y72;
import com.baidu.tieba.yv2;
import com.baidu.tieba.z73;
import com.baidu.tieba.zm3;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = ir1.a;
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
        public class a implements rp3<Exception> {
            public final /* synthetic */ w0c a;

            public a(w0c w0cVar) {
                this.a = w0cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.rp3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                w0c w0cVar = this.a;
                w0cVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.v0c.f, com.baidu.tieba.l1c
        public void call(w0c w0cVar) {
            if (a()) {
                w0cVar.onCompleted();
            } else {
                ll2.d().c(new a(w0cVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements ah2 {
            public final /* synthetic */ ch2 a;
            public final /* synthetic */ w0c b;

            public a(ch2 ch2Var, w0c w0cVar) {
                this.a = ch2Var;
                this.b = w0cVar;
            }

            @Override // com.baidu.tieba.ah2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.ah2
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
            if (!c && !fu2.w0().c()) {
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
                y72.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                y72.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.v0c.f, com.baidu.tieba.l1c
        public void call(w0c w0cVar) {
            fu2.G().c();
            if (a()) {
                w0cVar.onCompleted();
            } else if (fu2.w0().c()) {
                b();
                w0cVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    w0cVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    w0cVar.onCompleted();
                }
                e(w0cVar);
            }
        }

        public final ch2 d(e eVar, boolean z) {
            ch2 ch2Var = new ch2();
            ch2Var.a = "by_click";
            int i = this.b.a;
            ch2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return ch2Var;
        }

        public final void e(w0c w0cVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                w0cVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                w0cVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                w0cVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !fu2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                w0cVar.onCompleted();
            }
            g();
            ch2 d = d(this.b, z);
            fu2.w0().b(d, new a(d, w0cVar));
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
    public class a implements w0c {
        public final /* synthetic */ x73 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.w0c
        public void onSubscribe(e1c e1cVar) {
        }

        public a(x73 x73Var, Bundle bundle, int i, String str) {
            this.a = x73Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.w0c
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            xa3.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.w0c
        public void onError(Throwable th) {
            if (so3.G() && (th instanceof T7CheckException)) {
                return;
            }
            xa3.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ x73 a;

        public b(SwanLauncher swanLauncher, x73 x73Var) {
            this.a = x73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements v73 {
        public final /* synthetic */ x73 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, x73 x73Var, String str) {
            this.a = x73Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.v73
        public void a(String str, x73 x73Var) {
            if (x73Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && x73Var.E() && TextUtils.equals(this.b, x73Var.getAppId())) {
                z73.k().h(this);
                pv2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                z73.k().h(this);
                pv2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.v73
        public void timeout() {
            pv2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements w0c {
        public final /* synthetic */ rp3 a;

        public d(SwanLauncher swanLauncher, rp3 rp3Var) {
            this.a = rp3Var;
        }

        @Override // com.baidu.tieba.w0c
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            rp3 rp3Var = this.a;
            if (rp3Var != null) {
                rp3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.w0c
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            rp3 rp3Var = this.a;
            if (rp3Var != null) {
                rp3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.w0c
        public void onSubscribe(e1c e1cVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + e1cVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements v0c.f {
        public boolean a;

        @Override // com.baidu.tieba.v0c.f, com.baidu.tieba.l1c
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

    public void l(rp3<Exception> rp3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, rp3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        y72.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, x73 x73Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        z73.k().c(new c(this, x73Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(yv2 yv2Var, Bundle bundle) {
        if (yv2Var != null && !TextUtils.isEmpty(yv2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", yv2Var.H());
            bundle2.putAll(yv2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull w0c w0cVar, f... fVarArr) {
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
                    arrayList.add(v0c.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                v0c.a(arrayList).h(h1c.b()).d(h1c.b()).g(w0cVar);
                return;
            } else {
                w0cVar.onCompleted();
                return;
            }
        }
        w0cVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        rm3 rm3Var = new rm3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        rm3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        rm3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        rm3Var.d(str2);
        sv2.f(AppRuntime.getAppContext(), rm3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", fu2.o().E());
        bundle.putInt("host_launch_type", zm3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        t53.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        x73 r = z73.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (tj2.b(string, string2)) {
            bundle.putLong("launch_interval", tj2.a());
            tj2.c();
            tj2.d(bundle);
            return;
        }
        tj2.e(string, string2);
        tj2.c();
        y72.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", w72.b(a32.a(string)));
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
        sj2.c(i2);
    }

    @UiThread
    public final void o(x73 x73Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (dk3.j()) {
            fk3.e();
        }
        SwanCoreVersion e2 = dk3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = hl2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = x63.I(wv2.f1(bundle));
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
            jSONObject2 = br4.b(bundle.getString("mFrom"), null);
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
        w73.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(x73Var, bundle);
        Intent intent = new Intent(appContext, x73Var.O().activity);
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
            fu2.d0().a(bundle.getString("mAppId"), x73Var);
            d(bundle.getString("mAppId"), x73Var);
        }
        xa3.M().post(new b(this, x73Var));
    }

    public final int q(@NonNull x73 x73Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = vi4.i().u(x73Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (fg2.a.b()) {
                e2 = fw2.b(u, bundle);
            } else {
                e2 = fw2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                fg2.b(x73Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + x73Var.R());
        }
        return i2;
    }
}
