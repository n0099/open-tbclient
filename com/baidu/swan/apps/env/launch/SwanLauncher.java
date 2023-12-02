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
import com.baidu.tieba.boc;
import com.baidu.tieba.br2;
import com.baidu.tieba.coc;
import com.baidu.tieba.di3;
import com.baidu.tieba.dl3;
import com.baidu.tieba.ef2;
import com.baidu.tieba.ek3;
import com.baidu.tieba.er2;
import com.baidu.tieba.f13;
import com.baidu.tieba.ff2;
import com.baidu.tieba.h33;
import com.baidu.tieba.he4;
import com.baidu.tieba.i32;
import com.baidu.tieba.i33;
import com.baidu.tieba.ir2;
import com.baidu.tieba.j23;
import com.baidu.tieba.j33;
import com.baidu.tieba.j63;
import com.baidu.tieba.k32;
import com.baidu.tieba.koc;
import com.baidu.tieba.kr2;
import com.baidu.tieba.l33;
import com.baidu.tieba.li3;
import com.baidu.tieba.mc2;
import com.baidu.tieba.mm4;
import com.baidu.tieba.noc;
import com.baidu.tieba.ny1;
import com.baidu.tieba.oc2;
import com.baidu.tieba.pf3;
import com.baidu.tieba.rb2;
import com.baidu.tieba.rf3;
import com.baidu.tieba.rp2;
import com.baidu.tieba.rr2;
import com.baidu.tieba.tg2;
import com.baidu.tieba.vm1;
import com.baidu.tieba.xg2;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = vm1.a;
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
        public class a implements dl3<Exception> {
            public final /* synthetic */ coc a;

            public a(coc cocVar) {
                this.a = cocVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                coc cocVar = this.a;
                cocVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: c */
        public void call(coc cocVar) {
            if (a()) {
                cocVar.onCompleted();
            } else {
                xg2.d().c(new a(cocVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements mc2 {
            public final /* synthetic */ oc2 a;
            public final /* synthetic */ coc b;

            public a(oc2 oc2Var, coc cocVar) {
                this.a = oc2Var;
                this.b = cocVar;
            }

            @Override // com.baidu.tieba.mc2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.mc2
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
            if (!c && !rp2.w0().c()) {
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
                k32.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void h() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                k32.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: d */
        public void call(coc cocVar) {
            rp2.G().c();
            if (a()) {
                cocVar.onCompleted();
            } else if (rp2.w0().c()) {
                b();
                cocVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    cocVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    cocVar.onCompleted();
                }
                f(cocVar);
            }
        }

        public final oc2 e(e eVar, boolean z) {
            oc2 oc2Var = new oc2();
            oc2Var.a = "by_click";
            int i = this.b.a;
            oc2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return oc2Var;
        }

        public final void f(coc cocVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                cocVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                cocVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                cocVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !rp2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                cocVar.onCompleted();
            }
            h();
            oc2 e = e(this.b, z);
            rp2.w0().b(e, new a(e, cocVar));
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
    public class a implements coc {
        public final /* synthetic */ j33 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.coc
        public void onSubscribe(koc kocVar) {
        }

        public a(j33 j33Var, Bundle bundle, int i, String str) {
            this.a = j33Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.coc
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            j63.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.coc
        public void onError(Throwable th) {
            if (ek3.G() && (th instanceof T7CheckException)) {
                return;
            }
            j63.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ j33 a;

        public b(SwanLauncher swanLauncher, j33 j33Var) {
            this.a = j33Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements h33 {
        public final /* synthetic */ j33 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, j33 j33Var, String str) {
            this.a = j33Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.h33
        public void a(String str, j33 j33Var) {
            if (j33Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && j33Var.E() && TextUtils.equals(this.b, j33Var.getAppId())) {
                l33.k().h(this);
                br2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                l33.k().h(this);
                br2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.h33
        public void timeout() {
            br2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements coc {
        public final /* synthetic */ dl3 a;

        public d(SwanLauncher swanLauncher, dl3 dl3Var) {
            this.a = dl3Var;
        }

        @Override // com.baidu.tieba.coc
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            dl3 dl3Var = this.a;
            if (dl3Var != null) {
                dl3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.coc
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            dl3 dl3Var = this.a;
            if (dl3Var != null) {
                dl3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.coc
        public void onSubscribe(koc kocVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + kocVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements boc.f {
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

    public void l(dl3<Exception> dl3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, dl3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        k32.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, j33 j33Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        l33.k().c(new c(this, j33Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(kr2 kr2Var, Bundle bundle) {
        if (kr2Var != null && !TextUtils.isEmpty(kr2Var.I())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", kr2Var.I());
            bundle2.putAll(kr2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull coc cocVar, f... fVarArr) {
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
                    arrayList.add(boc.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                boc.a(arrayList).h(noc.b()).d(noc.b()).g(cocVar);
                return;
            } else {
                cocVar.onCompleted();
                return;
            }
        }
        cocVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        di3 di3Var = new di3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        di3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        di3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        di3Var.d(str2);
        er2.f(AppRuntime.getAppContext(), di3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", rp2.o().E());
        bundle.putInt("host_launch_type", li3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        f13.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        j33 r = l33.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (ff2.b(string, string2)) {
            bundle.putLong("launch_interval", ff2.a());
            ff2.c();
            ff2.d(bundle);
            return;
        }
        ff2.e(string, string2);
        ff2.c();
        k32.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", i32.b(ny1.a(string)));
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
        ef2.c(i2);
    }

    @UiThread
    public final void o(j33 j33Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (pf3.j()) {
            rf3.e();
        }
        SwanCoreVersion e2 = pf3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = tg2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = j23.I(ir2.g1(bundle));
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
            jSONObject2 = mm4.b(bundle.getString("mFrom"), null);
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
        i33.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(j33Var, bundle);
        Intent intent = new Intent(appContext, j33Var.O().activity);
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
            rp2.d0().a(bundle.getString("mAppId"), j33Var);
            d(bundle.getString("mAppId"), j33Var);
        }
        j63.M().post(new b(this, j33Var));
    }

    public final int q(@NonNull j33 j33Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = he4.i().u(j33Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (rb2.a.b()) {
                e2 = rr2.b(u, bundle);
            } else {
                e2 = rr2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                rb2.b(j33Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + j33Var.R());
        }
        return i2;
    }
}
