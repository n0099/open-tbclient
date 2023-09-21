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
import com.baidu.tieba.ak2;
import com.baidu.tieba.ap3;
import com.baidu.tieba.aw2;
import com.baidu.tieba.b63;
import com.baidu.tieba.bk2;
import com.baidu.tieba.d83;
import com.baidu.tieba.dj4;
import com.baidu.tieba.e82;
import com.baidu.tieba.e83;
import com.baidu.tieba.ew2;
import com.baidu.tieba.f73;
import com.baidu.tieba.f83;
import com.baidu.tieba.fb3;
import com.baidu.tieba.g82;
import com.baidu.tieba.gw2;
import com.baidu.tieba.h83;
import com.baidu.tieba.hn3;
import com.baidu.tieba.i32;
import com.baidu.tieba.icc;
import com.baidu.tieba.ih2;
import com.baidu.tieba.jcc;
import com.baidu.tieba.jr4;
import com.baidu.tieba.kh2;
import com.baidu.tieba.lk3;
import com.baidu.tieba.ng2;
import com.baidu.tieba.nk3;
import com.baidu.tieba.nu2;
import com.baidu.tieba.nw2;
import com.baidu.tieba.pl2;
import com.baidu.tieba.qr1;
import com.baidu.tieba.rcc;
import com.baidu.tieba.tl2;
import com.baidu.tieba.ucc;
import com.baidu.tieba.xv2;
import com.baidu.tieba.zm3;
import com.baidu.tieba.zp3;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = qr1.a;
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
        public class a implements zp3<Exception> {
            public final /* synthetic */ jcc a;

            public a(jcc jccVar) {
                this.a = jccVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.zp3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                jcc jccVar = this.a;
                jccVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.icc.f, com.baidu.tieba.ycc
        public void call(jcc jccVar) {
            if (a()) {
                jccVar.onCompleted();
            } else {
                tl2.d().c(new a(jccVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements ih2 {
            public final /* synthetic */ kh2 a;
            public final /* synthetic */ jcc b;

            public a(kh2 kh2Var, jcc jccVar) {
                this.a = kh2Var;
                this.b = jccVar;
            }

            @Override // com.baidu.tieba.ih2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.ih2
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
            if (!c && !nu2.w0().c()) {
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
                g82.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                g82.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.icc.f, com.baidu.tieba.ycc
        public void call(jcc jccVar) {
            nu2.G().c();
            if (a()) {
                jccVar.onCompleted();
            } else if (nu2.w0().c()) {
                b();
                jccVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    jccVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    jccVar.onCompleted();
                }
                e(jccVar);
            }
        }

        public final kh2 d(e eVar, boolean z) {
            kh2 kh2Var = new kh2();
            kh2Var.a = "by_click";
            int i = this.b.a;
            kh2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return kh2Var;
        }

        public final void e(jcc jccVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                jccVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                jccVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                jccVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !nu2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                jccVar.onCompleted();
            }
            g();
            kh2 d = d(this.b, z);
            nu2.w0().b(d, new a(d, jccVar));
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
    public class a implements jcc {
        public final /* synthetic */ f83 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.jcc
        public void onSubscribe(rcc rccVar) {
        }

        public a(f83 f83Var, Bundle bundle, int i, String str) {
            this.a = f83Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.jcc
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            fb3.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.jcc
        public void onError(Throwable th) {
            if (ap3.G() && (th instanceof T7CheckException)) {
                return;
            }
            fb3.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ f83 a;

        public b(SwanLauncher swanLauncher, f83 f83Var) {
            this.a = f83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d83 {
        public final /* synthetic */ f83 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, f83 f83Var, String str) {
            this.a = f83Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.d83
        public void a(String str, f83 f83Var) {
            if (f83Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && f83Var.E() && TextUtils.equals(this.b, f83Var.getAppId())) {
                h83.k().h(this);
                xv2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                h83.k().h(this);
                xv2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.d83
        public void timeout() {
            xv2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements jcc {
        public final /* synthetic */ zp3 a;

        public d(SwanLauncher swanLauncher, zp3 zp3Var) {
            this.a = zp3Var;
        }

        @Override // com.baidu.tieba.jcc
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            zp3 zp3Var = this.a;
            if (zp3Var != null) {
                zp3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.jcc
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            zp3 zp3Var = this.a;
            if (zp3Var != null) {
                zp3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.jcc
        public void onSubscribe(rcc rccVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + rccVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements icc.f {
        public boolean a;

        @Override // com.baidu.tieba.icc.f, com.baidu.tieba.ycc
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

    public void l(zp3<Exception> zp3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, zp3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        g82.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, f83 f83Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h83.k().c(new c(this, f83Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(gw2 gw2Var, Bundle bundle) {
        if (gw2Var != null && !TextUtils.isEmpty(gw2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", gw2Var.H());
            bundle2.putAll(gw2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull jcc jccVar, f... fVarArr) {
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
                    arrayList.add(icc.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                icc.a(arrayList).h(ucc.b()).d(ucc.b()).g(jccVar);
                return;
            } else {
                jccVar.onCompleted();
                return;
            }
        }
        jccVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        zm3 zm3Var = new zm3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        zm3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        zm3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        zm3Var.d(str2);
        aw2.f(AppRuntime.getAppContext(), zm3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", nu2.o().E());
        bundle.putInt("host_launch_type", hn3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        b63.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        f83 r = h83.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (bk2.b(string, string2)) {
            bundle.putLong("launch_interval", bk2.a());
            bk2.c();
            bk2.d(bundle);
            return;
        }
        bk2.e(string, string2);
        bk2.c();
        g82.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", e82.b(i32.a(string)));
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
        ak2.c(i2);
    }

    @UiThread
    public final void o(f83 f83Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (lk3.j()) {
            nk3.e();
        }
        SwanCoreVersion e2 = lk3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = pl2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = f73.I(ew2.f1(bundle));
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
            jSONObject2 = jr4.b(bundle.getString("mFrom"), null);
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
        e83.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(f83Var, bundle);
        Intent intent = new Intent(appContext, f83Var.O().activity);
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
            nu2.d0().a(bundle.getString("mAppId"), f83Var);
            d(bundle.getString("mAppId"), f83Var);
        }
        fb3.M().post(new b(this, f83Var));
    }

    public final int q(@NonNull f83 f83Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = dj4.i().u(f83Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (ng2.a.b()) {
                e2 = nw2.b(u, bundle);
            } else {
                e2 = nw2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                ng2.b(f83Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + f83Var.R());
        }
        return i2;
    }
}
