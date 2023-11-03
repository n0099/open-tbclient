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
import com.baidu.tieba.af2;
import com.baidu.tieba.ak3;
import com.baidu.tieba.ar2;
import com.baidu.tieba.b13;
import com.baidu.tieba.bf2;
import com.baidu.tieba.d33;
import com.baidu.tieba.de4;
import com.baidu.tieba.e32;
import com.baidu.tieba.e33;
import com.baidu.tieba.er2;
import com.baidu.tieba.f23;
import com.baidu.tieba.f33;
import com.baidu.tieba.f63;
import com.baidu.tieba.g32;
import com.baidu.tieba.gjc;
import com.baidu.tieba.gr2;
import com.baidu.tieba.h33;
import com.baidu.tieba.hi3;
import com.baidu.tieba.hjc;
import com.baidu.tieba.ic2;
import com.baidu.tieba.im4;
import com.baidu.tieba.jy1;
import com.baidu.tieba.kc2;
import com.baidu.tieba.lf3;
import com.baidu.tieba.nb2;
import com.baidu.tieba.nf3;
import com.baidu.tieba.np2;
import com.baidu.tieba.nr2;
import com.baidu.tieba.pg2;
import com.baidu.tieba.pjc;
import com.baidu.tieba.rm1;
import com.baidu.tieba.sjc;
import com.baidu.tieba.tg2;
import com.baidu.tieba.xq2;
import com.baidu.tieba.zh3;
import com.baidu.tieba.zk3;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = rm1.a;
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
        public class a implements zk3<Exception> {
            public final /* synthetic */ hjc a;

            public a(hjc hjcVar) {
                this.a = hjcVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.zk3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                hjc hjcVar = this.a;
                hjcVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wjc
        /* renamed from: c */
        public void call(hjc hjcVar) {
            if (a()) {
                hjcVar.onCompleted();
            } else {
                tg2.d().c(new a(hjcVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements ic2 {
            public final /* synthetic */ kc2 a;
            public final /* synthetic */ hjc b;

            public a(kc2 kc2Var, hjc hjcVar) {
                this.a = kc2Var;
                this.b = hjcVar;
            }

            @Override // com.baidu.tieba.ic2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.ic2
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
            if (!c && !np2.w0().c()) {
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
                g32.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void h() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                g32.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wjc
        /* renamed from: d */
        public void call(hjc hjcVar) {
            np2.G().c();
            if (a()) {
                hjcVar.onCompleted();
            } else if (np2.w0().c()) {
                b();
                hjcVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    hjcVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    hjcVar.onCompleted();
                }
                f(hjcVar);
            }
        }

        public final kc2 e(e eVar, boolean z) {
            kc2 kc2Var = new kc2();
            kc2Var.a = "by_click";
            int i = this.b.a;
            kc2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return kc2Var;
        }

        public final void f(hjc hjcVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                hjcVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                hjcVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                hjcVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !np2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                hjcVar.onCompleted();
            }
            h();
            kc2 e = e(this.b, z);
            np2.w0().b(e, new a(e, hjcVar));
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
    public class a implements hjc {
        public final /* synthetic */ f33 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.hjc
        public void onSubscribe(pjc pjcVar) {
        }

        public a(f33 f33Var, Bundle bundle, int i, String str) {
            this.a = f33Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.hjc
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            f63.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.hjc
        public void onError(Throwable th) {
            if (ak3.G() && (th instanceof T7CheckException)) {
                return;
            }
            f63.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ f33 a;

        public b(SwanLauncher swanLauncher, f33 f33Var) {
            this.a = f33Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d33 {
        public final /* synthetic */ f33 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, f33 f33Var, String str) {
            this.a = f33Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.d33
        public void a(String str, f33 f33Var) {
            if (f33Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && f33Var.E() && TextUtils.equals(this.b, f33Var.getAppId())) {
                h33.k().h(this);
                xq2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                h33.k().h(this);
                xq2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.d33
        public void timeout() {
            xq2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements hjc {
        public final /* synthetic */ zk3 a;

        public d(SwanLauncher swanLauncher, zk3 zk3Var) {
            this.a = zk3Var;
        }

        @Override // com.baidu.tieba.hjc
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            zk3 zk3Var = this.a;
            if (zk3Var != null) {
                zk3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.hjc
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            zk3 zk3Var = this.a;
            if (zk3Var != null) {
                zk3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.hjc
        public void onSubscribe(pjc pjcVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + pjcVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements gjc.f {
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

    public void l(zk3<Exception> zk3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, zk3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        g32.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, f33 f33Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h33.k().c(new c(this, f33Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(gr2 gr2Var, Bundle bundle) {
        if (gr2Var != null && !TextUtils.isEmpty(gr2Var.I())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", gr2Var.I());
            bundle2.putAll(gr2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull hjc hjcVar, f... fVarArr) {
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
                    arrayList.add(gjc.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                gjc.a(arrayList).h(sjc.b()).d(sjc.b()).g(hjcVar);
                return;
            } else {
                hjcVar.onCompleted();
                return;
            }
        }
        hjcVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        zh3 zh3Var = new zh3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        zh3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        zh3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        zh3Var.d(str2);
        ar2.f(AppRuntime.getAppContext(), zh3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", np2.o().E());
        bundle.putInt("host_launch_type", hi3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        b13.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        f33 r = h33.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (bf2.b(string, string2)) {
            bundle.putLong("launch_interval", bf2.a());
            bf2.c();
            bf2.d(bundle);
            return;
        }
        bf2.e(string, string2);
        bf2.c();
        g32.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", e32.b(jy1.a(string)));
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
        af2.c(i2);
    }

    @UiThread
    public final void o(f33 f33Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (lf3.j()) {
            nf3.e();
        }
        SwanCoreVersion e2 = lf3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = pg2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = f23.I(er2.g1(bundle));
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
            jSONObject2 = im4.b(bundle.getString("mFrom"), null);
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
        e33.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(f33Var, bundle);
        Intent intent = new Intent(appContext, f33Var.O().activity);
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
            np2.d0().a(bundle.getString("mAppId"), f33Var);
            d(bundle.getString("mAppId"), f33Var);
        }
        f63.M().post(new b(this, f33Var));
    }

    public final int q(@NonNull f33 f33Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = de4.i().u(f33Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (nb2.a.b()) {
                e2 = nr2.b(u, bundle);
            } else {
                e2 = nr2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                nb2.b(f33Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + f33Var.R());
        }
        return i2;
    }
}
