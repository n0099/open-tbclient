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
import com.baidu.tieba.ah3;
import com.baidu.tieba.cd2;
import com.baidu.tieba.ch3;
import com.baidu.tieba.cr2;
import com.baidu.tieba.ct2;
import com.baidu.tieba.ei2;
import com.baidu.tieba.fo1;
import com.baidu.tieba.ii2;
import com.baidu.tieba.l1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.ms2;
import com.baidu.tieba.oj3;
import com.baidu.tieba.om3;
import com.baidu.tieba.pg2;
import com.baidu.tieba.pl3;
import com.baidu.tieba.ps2;
import com.baidu.tieba.q23;
import com.baidu.tieba.qg2;
import com.baidu.tieba.s43;
import com.baidu.tieba.sf4;
import com.baidu.tieba.t42;
import com.baidu.tieba.t43;
import com.baidu.tieba.ts2;
import com.baidu.tieba.u1b;
import com.baidu.tieba.u33;
import com.baidu.tieba.u43;
import com.baidu.tieba.u73;
import com.baidu.tieba.v42;
import com.baidu.tieba.vs2;
import com.baidu.tieba.w43;
import com.baidu.tieba.wj3;
import com.baidu.tieba.x1b;
import com.baidu.tieba.xd2;
import com.baidu.tieba.xz1;
import com.baidu.tieba.yn4;
import com.baidu.tieba.zd2;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class SwanLauncher {
    public static final boolean a = fo1.a;
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
        public class a implements om3<Exception> {
            public final /* synthetic */ m1b a;

            public a(m1b m1bVar) {
                this.a = m1bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.om3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                m1b m1bVar = this.a;
                m1bVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.l1b.f, com.baidu.tieba.b2b
        public void call(m1b m1bVar) {
            if (a()) {
                m1bVar.onCompleted();
            } else {
                ii2.d().c(new a(m1bVar), this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes3.dex */
        public class a implements xd2 {
            public final /* synthetic */ zd2 a;
            public final /* synthetic */ m1b b;

            public a(zd2 zd2Var, m1b m1bVar) {
                this.a = zd2Var;
                this.b = m1bVar;
            }

            @Override // com.baidu.tieba.xd2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.xd2
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
            if (!c && !cr2.w0().c()) {
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
                v42.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                v42.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.l1b.f, com.baidu.tieba.b2b
        public void call(m1b m1bVar) {
            cr2.G().c();
            if (a()) {
                m1bVar.onCompleted();
            } else if (cr2.w0().c()) {
                b();
                m1bVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    m1bVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    m1bVar.onCompleted();
                }
                e(m1bVar);
            }
        }

        public final zd2 d(e eVar, boolean z) {
            zd2 zd2Var = new zd2();
            zd2Var.a = "by_click";
            int i = this.b.a;
            zd2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return zd2Var;
        }

        public final void e(m1b m1bVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                m1bVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                m1bVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                m1bVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !cr2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                m1bVar.onCompleted();
            }
            g();
            zd2 d = d(this.b, z);
            cr2.w0().b(d, new a(d, m1bVar));
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
    public class a implements m1b {
        public final /* synthetic */ u43 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.m1b
        public void onSubscribe(u1b u1bVar) {
        }

        public a(u43 u43Var, Bundle bundle, int i, String str) {
            this.a = u43Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.m1b
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            u73.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.m1b
        public void onError(Throwable th) {
            if (pl3.G() && (th instanceof T7CheckException)) {
                return;
            }
            u73.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ u43 a;

        public b(SwanLauncher swanLauncher, u43 u43Var) {
            this.a = u43Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements s43 {
        public final /* synthetic */ u43 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, u43 u43Var, String str) {
            this.a = u43Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.s43
        public void a(String str, u43 u43Var) {
            if (u43Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && u43Var.E() && TextUtils.equals(this.b, u43Var.getAppId())) {
                w43.k().h(this);
                ms2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                w43.k().h(this);
                ms2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.s43
        public void timeout() {
            ms2.k(this.b);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements m1b {
        public final /* synthetic */ om3 a;

        public d(SwanLauncher swanLauncher, om3 om3Var) {
            this.a = om3Var;
        }

        @Override // com.baidu.tieba.m1b
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            om3 om3Var = this.a;
            if (om3Var != null) {
                om3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.m1b
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            om3 om3Var = this.a;
            if (om3Var != null) {
                om3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.m1b
        public void onSubscribe(u1b u1bVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + u1bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class f implements l1b.f {
        public boolean a;

        @Override // com.baidu.tieba.l1b.f, com.baidu.tieba.b2b
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

    public void l(om3<Exception> om3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, om3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        v42.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, u43 u43Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        w43.k().c(new c(this, u43Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(vs2 vs2Var, Bundle bundle) {
        if (vs2Var != null && !TextUtils.isEmpty(vs2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", vs2Var.H());
            bundle2.putAll(vs2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull m1b m1bVar, f... fVarArr) {
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
                    arrayList.add(l1b.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                l1b.a(arrayList).h(x1b.b()).d(x1b.b()).g(m1bVar);
                return;
            } else {
                m1bVar.onCompleted();
                return;
            }
        }
        m1bVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        oj3 oj3Var = new oj3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        oj3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        oj3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        oj3Var.d(str2);
        ps2.f(AppRuntime.getAppContext(), oj3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", cr2.o().E());
        bundle.putInt("host_launch_type", wj3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        q23.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        u43 r = w43.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (qg2.b(string, string2)) {
            bundle.putLong("launch_interval", qg2.a());
            qg2.c();
            qg2.d(bundle);
            return;
        }
        qg2.e(string, string2);
        qg2.c();
        v42.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", t42.b(xz1.a(string)));
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
        pg2.c(i2);
    }

    @UiThread
    public final void o(u43 u43Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (ah3.j()) {
            ch3.e();
        }
        SwanCoreVersion e2 = ah3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = ei2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = u33.I(ts2.f1(bundle));
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
            jSONObject2 = yn4.b(bundle.getString("mFrom"), null);
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
        t43.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(u43Var, bundle);
        Intent intent = new Intent(appContext, u43Var.O().activity);
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
            cr2.d0().a(bundle.getString("mAppId"), u43Var);
            d(bundle.getString("mAppId"), u43Var);
        }
        u73.M().post(new b(this, u43Var));
    }

    public final int q(@NonNull u43 u43Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = sf4.i().u(u43Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (cd2.a.b()) {
                e2 = ct2.b(u, bundle);
            } else {
                e2 = ct2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                cd2.b(u43Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + u43Var.R());
        }
        return i2;
    }
}
