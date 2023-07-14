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
import com.baidu.tieba.al3;
import com.baidu.tieba.b2c;
import com.baidu.tieba.ch2;
import com.baidu.tieba.cl3;
import com.baidu.tieba.cv2;
import com.baidu.tieba.cx2;
import com.baidu.tieba.e2c;
import com.baidu.tieba.em2;
import com.baidu.tieba.fs1;
import com.baidu.tieba.im2;
import com.baidu.tieba.mw2;
import com.baidu.tieba.on3;
import com.baidu.tieba.oq3;
import com.baidu.tieba.pk2;
import com.baidu.tieba.pp3;
import com.baidu.tieba.pw2;
import com.baidu.tieba.q63;
import com.baidu.tieba.qk2;
import com.baidu.tieba.s1c;
import com.baidu.tieba.s83;
import com.baidu.tieba.sj4;
import com.baidu.tieba.t1c;
import com.baidu.tieba.t82;
import com.baidu.tieba.t83;
import com.baidu.tieba.tw2;
import com.baidu.tieba.u73;
import com.baidu.tieba.u83;
import com.baidu.tieba.ub3;
import com.baidu.tieba.v82;
import com.baidu.tieba.vw2;
import com.baidu.tieba.w83;
import com.baidu.tieba.wn3;
import com.baidu.tieba.x32;
import com.baidu.tieba.xh2;
import com.baidu.tieba.yr4;
import com.baidu.tieba.zh2;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = fs1.a;
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
        public class a implements oq3<Exception> {
            public final /* synthetic */ t1c a;

            public a(t1c t1cVar) {
                this.a = t1cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                t1c t1cVar = this.a;
                t1cVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.s1c.f, com.baidu.tieba.i2c
        public void call(t1c t1cVar) {
            if (a()) {
                t1cVar.onCompleted();
            } else {
                im2.d().c(new a(t1cVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements xh2 {
            public final /* synthetic */ zh2 a;
            public final /* synthetic */ t1c b;

            public a(zh2 zh2Var, t1c t1cVar) {
                this.a = zh2Var;
                this.b = t1cVar;
            }

            @Override // com.baidu.tieba.xh2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.xh2
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
            if (!c && !cv2.w0().c()) {
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
                v82.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                v82.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.s1c.f, com.baidu.tieba.i2c
        public void call(t1c t1cVar) {
            cv2.G().c();
            if (a()) {
                t1cVar.onCompleted();
            } else if (cv2.w0().c()) {
                b();
                t1cVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    t1cVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    t1cVar.onCompleted();
                }
                e(t1cVar);
            }
        }

        public final zh2 d(e eVar, boolean z) {
            zh2 zh2Var = new zh2();
            zh2Var.a = "by_click";
            int i = this.b.a;
            zh2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return zh2Var;
        }

        public final void e(t1c t1cVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                t1cVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                t1cVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                t1cVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !cv2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                t1cVar.onCompleted();
            }
            g();
            zh2 d = d(this.b, z);
            cv2.w0().b(d, new a(d, t1cVar));
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
    public class a implements t1c {
        public final /* synthetic */ u83 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.t1c
        public void onSubscribe(b2c b2cVar) {
        }

        public a(u83 u83Var, Bundle bundle, int i, String str) {
            this.a = u83Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.t1c
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            ub3.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.t1c
        public void onError(Throwable th) {
            if (pp3.G() && (th instanceof T7CheckException)) {
                return;
            }
            ub3.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ u83 a;

        public b(SwanLauncher swanLauncher, u83 u83Var) {
            this.a = u83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements s83 {
        public final /* synthetic */ u83 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, u83 u83Var, String str) {
            this.a = u83Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.s83
        public void a(String str, u83 u83Var) {
            if (u83Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && u83Var.E() && TextUtils.equals(this.b, u83Var.getAppId())) {
                w83.k().h(this);
                mw2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                w83.k().h(this);
                mw2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.s83
        public void timeout() {
            mw2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements t1c {
        public final /* synthetic */ oq3 a;

        public d(SwanLauncher swanLauncher, oq3 oq3Var) {
            this.a = oq3Var;
        }

        @Override // com.baidu.tieba.t1c
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            oq3 oq3Var = this.a;
            if (oq3Var != null) {
                oq3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.t1c
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            oq3 oq3Var = this.a;
            if (oq3Var != null) {
                oq3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.t1c
        public void onSubscribe(b2c b2cVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + b2cVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements s1c.f {
        public boolean a;

        @Override // com.baidu.tieba.s1c.f, com.baidu.tieba.i2c
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

    public void l(oq3<Exception> oq3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, oq3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        v82.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, u83 u83Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        w83.k().c(new c(this, u83Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(vw2 vw2Var, Bundle bundle) {
        if (vw2Var != null && !TextUtils.isEmpty(vw2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", vw2Var.H());
            bundle2.putAll(vw2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull t1c t1cVar, f... fVarArr) {
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
                    arrayList.add(s1c.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                s1c.a(arrayList).h(e2c.b()).d(e2c.b()).g(t1cVar);
                return;
            } else {
                t1cVar.onCompleted();
                return;
            }
        }
        t1cVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        on3 on3Var = new on3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        on3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        on3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        on3Var.d(str2);
        pw2.f(AppRuntime.getAppContext(), on3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", cv2.o().E());
        bundle.putInt("host_launch_type", wn3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        q63.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        u83 r = w83.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (qk2.b(string, string2)) {
            bundle.putLong("launch_interval", qk2.a());
            qk2.c();
            qk2.d(bundle);
            return;
        }
        qk2.e(string, string2);
        qk2.c();
        v82.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", t82.b(x32.a(string)));
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
        pk2.c(i2);
    }

    @UiThread
    public final void o(u83 u83Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (al3.j()) {
            cl3.e();
        }
        SwanCoreVersion e2 = al3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = em2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = u73.I(tw2.f1(bundle));
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
            jSONObject2 = yr4.b(bundle.getString("mFrom"), null);
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
        t83.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(u83Var, bundle);
        Intent intent = new Intent(appContext, u83Var.O().activity);
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
            cv2.d0().a(bundle.getString("mAppId"), u83Var);
            d(bundle.getString("mAppId"), u83Var);
        }
        ub3.M().post(new b(this, u83Var));
    }

    public final int q(@NonNull u83 u83Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = sj4.i().u(u83Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (ch2.a.b()) {
                e2 = cx2.b(u, bundle);
            } else {
                e2 = cx2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                ch2.b(u83Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + u83Var.R());
        }
        return i2;
    }
}
