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
import com.baidu.tieba.a42;
import com.baidu.tieba.ai2;
import com.baidu.tieba.bs4;
import com.baidu.tieba.ci2;
import com.baidu.tieba.dl3;
import com.baidu.tieba.fh2;
import com.baidu.tieba.fl3;
import com.baidu.tieba.fv2;
import com.baidu.tieba.fx2;
import com.baidu.tieba.gmb;
import com.baidu.tieba.hm2;
import com.baidu.tieba.hmb;
import com.baidu.tieba.is1;
import com.baidu.tieba.lm2;
import com.baidu.tieba.pmb;
import com.baidu.tieba.pw2;
import com.baidu.tieba.rn3;
import com.baidu.tieba.rq3;
import com.baidu.tieba.sk2;
import com.baidu.tieba.smb;
import com.baidu.tieba.sp3;
import com.baidu.tieba.sw2;
import com.baidu.tieba.t63;
import com.baidu.tieba.tk2;
import com.baidu.tieba.v83;
import com.baidu.tieba.vj4;
import com.baidu.tieba.w82;
import com.baidu.tieba.w83;
import com.baidu.tieba.ww2;
import com.baidu.tieba.x73;
import com.baidu.tieba.x83;
import com.baidu.tieba.xb3;
import com.baidu.tieba.y82;
import com.baidu.tieba.yw2;
import com.baidu.tieba.z83;
import com.baidu.tieba.zn3;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = is1.a;
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
        public class a implements rq3<Exception> {
            public final /* synthetic */ hmb a;

            public a(hmb hmbVar) {
                this.a = hmbVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.rq3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                hmb hmbVar = this.a;
                hmbVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.gmb.f, com.baidu.tieba.wmb
        public void call(hmb hmbVar) {
            if (a()) {
                hmbVar.onCompleted();
            } else {
                lm2.d().c(new a(hmbVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements ai2 {
            public final /* synthetic */ ci2 a;
            public final /* synthetic */ hmb b;

            public a(ci2 ci2Var, hmb hmbVar) {
                this.a = ci2Var;
                this.b = hmbVar;
            }

            @Override // com.baidu.tieba.ai2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.ai2
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
            if (!c && !fv2.w0().c()) {
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
                y82.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                y82.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.gmb.f, com.baidu.tieba.wmb
        public void call(hmb hmbVar) {
            fv2.G().c();
            if (a()) {
                hmbVar.onCompleted();
            } else if (fv2.w0().c()) {
                b();
                hmbVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    hmbVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    hmbVar.onCompleted();
                }
                e(hmbVar);
            }
        }

        public final ci2 d(e eVar, boolean z) {
            ci2 ci2Var = new ci2();
            ci2Var.a = "by_click";
            int i = this.b.a;
            ci2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return ci2Var;
        }

        public final void e(hmb hmbVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                hmbVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                hmbVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                hmbVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !fv2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                hmbVar.onCompleted();
            }
            g();
            ci2 d = d(this.b, z);
            fv2.w0().b(d, new a(d, hmbVar));
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
    public class a implements hmb {
        public final /* synthetic */ x83 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.hmb
        public void onSubscribe(pmb pmbVar) {
        }

        public a(x83 x83Var, Bundle bundle, int i, String str) {
            this.a = x83Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.hmb
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            xb3.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.hmb
        public void onError(Throwable th) {
            if (sp3.G() && (th instanceof T7CheckException)) {
                return;
            }
            xb3.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ x83 a;

        public b(SwanLauncher swanLauncher, x83 x83Var) {
            this.a = x83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements v83 {
        public final /* synthetic */ x83 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, x83 x83Var, String str) {
            this.a = x83Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.v83
        public void a(String str, x83 x83Var) {
            if (x83Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && x83Var.E() && TextUtils.equals(this.b, x83Var.getAppId())) {
                z83.k().h(this);
                pw2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                z83.k().h(this);
                pw2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.v83
        public void timeout() {
            pw2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements hmb {
        public final /* synthetic */ rq3 a;

        public d(SwanLauncher swanLauncher, rq3 rq3Var) {
            this.a = rq3Var;
        }

        @Override // com.baidu.tieba.hmb
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            rq3 rq3Var = this.a;
            if (rq3Var != null) {
                rq3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.hmb
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            rq3 rq3Var = this.a;
            if (rq3Var != null) {
                rq3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.hmb
        public void onSubscribe(pmb pmbVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + pmbVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements gmb.f {
        public boolean a;

        @Override // com.baidu.tieba.gmb.f, com.baidu.tieba.wmb
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

    public void l(rq3<Exception> rq3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, rq3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        y82.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, x83 x83Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        z83.k().c(new c(this, x83Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(yw2 yw2Var, Bundle bundle) {
        if (yw2Var != null && !TextUtils.isEmpty(yw2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", yw2Var.H());
            bundle2.putAll(yw2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull hmb hmbVar, f... fVarArr) {
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
                    arrayList.add(gmb.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                gmb.a(arrayList).h(smb.b()).d(smb.b()).g(hmbVar);
                return;
            } else {
                hmbVar.onCompleted();
                return;
            }
        }
        hmbVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        rn3 rn3Var = new rn3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        rn3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        rn3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        rn3Var.d(str2);
        sw2.f(AppRuntime.getAppContext(), rn3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", fv2.o().E());
        bundle.putInt("host_launch_type", zn3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        t63.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        x83 r = z83.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (tk2.b(string, string2)) {
            bundle.putLong("launch_interval", tk2.a());
            tk2.c();
            tk2.d(bundle);
            return;
        }
        tk2.e(string, string2);
        tk2.c();
        y82.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", w82.b(a42.a(string)));
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
        sk2.c(i2);
    }

    @UiThread
    public final void o(x83 x83Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (dl3.j()) {
            fl3.e();
        }
        SwanCoreVersion e2 = dl3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = hm2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = x73.I(ww2.f1(bundle));
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
            jSONObject2 = bs4.b(bundle.getString("mFrom"), null);
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
        w83.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(x83Var, bundle);
        Intent intent = new Intent(appContext, x83Var.O().activity);
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
            fv2.d0().a(bundle.getString("mAppId"), x83Var);
            d(bundle.getString("mAppId"), x83Var);
        }
        xb3.M().post(new b(this, x83Var));
    }

    public final int q(@NonNull x83 x83Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = vj4.i().u(x83Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (fh2.a.b()) {
                e2 = fx2.b(u, bundle);
            } else {
                e2 = fx2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                fh2.b(x83Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + x83Var.R());
        }
        return i2;
    }
}
