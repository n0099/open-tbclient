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
import com.baidu.tieba.ai3;
import com.baidu.tieba.al3;
import com.baidu.tieba.bf2;
import com.baidu.tieba.bk3;
import com.baidu.tieba.br2;
import com.baidu.tieba.c13;
import com.baidu.tieba.cf2;
import com.baidu.tieba.coc;
import com.baidu.tieba.doc;
import com.baidu.tieba.e33;
import com.baidu.tieba.ee4;
import com.baidu.tieba.f32;
import com.baidu.tieba.f33;
import com.baidu.tieba.fr2;
import com.baidu.tieba.g23;
import com.baidu.tieba.g33;
import com.baidu.tieba.g63;
import com.baidu.tieba.h32;
import com.baidu.tieba.hr2;
import com.baidu.tieba.i33;
import com.baidu.tieba.ii3;
import com.baidu.tieba.jc2;
import com.baidu.tieba.jm4;
import com.baidu.tieba.ky1;
import com.baidu.tieba.lc2;
import com.baidu.tieba.loc;
import com.baidu.tieba.mf3;
import com.baidu.tieba.ob2;
import com.baidu.tieba.of3;
import com.baidu.tieba.ooc;
import com.baidu.tieba.op2;
import com.baidu.tieba.or2;
import com.baidu.tieba.qg2;
import com.baidu.tieba.sm1;
import com.baidu.tieba.ug2;
import com.baidu.tieba.yq2;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static final boolean a = sm1.a;
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
        public class a implements al3<Exception> {
            public final /* synthetic */ doc a;

            public a(doc docVar) {
                this.a = docVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.al3
            /* renamed from: b */
            public void a(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.a.onCompleted();
                    return;
                }
                doc docVar = this.a;
                docVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.b, exc));
            }
        }

        public h(int i) {
            super(null);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: c */
        public void call(doc docVar) {
            if (a()) {
                docVar.onCompleted();
            } else {
                ug2.d().c(new a(docVar), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static boolean c;
        public final e b;

        /* loaded from: classes4.dex */
        public class a implements jc2 {
            public final /* synthetic */ lc2 a;
            public final /* synthetic */ doc b;

            public a(lc2 lc2Var, doc docVar) {
                this.a = lc2Var;
                this.b = docVar;
            }

            @Override // com.baidu.tieba.jc2
            public void onFail() {
                if (this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.jc2
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
            if (!c && !op2.w0().c()) {
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
                h32.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void h() {
            Bundle bundle = this.b.c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                h32.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: d */
        public void call(doc docVar) {
            op2.G().c();
            if (a()) {
                docVar.onCompleted();
            } else if (op2.w0().c()) {
                b();
                docVar.onCompleted();
            } else {
                e eVar = this.b;
                if (eVar.b != 1) {
                    docVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    docVar.onCompleted();
                }
                f(docVar);
            }
        }

        public final lc2 e(e eVar, boolean z) {
            lc2 lc2Var = new lc2();
            lc2Var.a = "by_click";
            int i = this.b.a;
            lc2Var.b = z;
            Bundle bundle = eVar.c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return lc2Var;
        }

        public final void f(doc docVar) {
            Bundle bundle = this.b.c;
            if (bundle == null) {
                docVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                docVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                docVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !op2.A().a()) {
                z = false;
            }
            if (!z) {
                b();
                docVar.onCompleted();
            }
            h();
            lc2 e = e(this.b, z);
            op2.w0().b(e, new a(e, docVar));
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
    public class a implements doc {
        public final /* synthetic */ g33 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.baidu.tieba.doc
        public void onSubscribe(loc locVar) {
        }

        public a(g33 g33Var, Bundle bundle, int i, String str) {
            this.a = g33Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.doc
        public void onCompleted() {
            SwanLauncher.this.o(this.a, this.b, this.c);
            g63.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.doc
        public void onError(Throwable th) {
            if (bk3.G() && (th instanceof T7CheckException)) {
                return;
            }
            g63.K().p("event_launch_swan");
            SwanLauncher.this.k(th, this.c, this.d, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ g33 a;

        public b(SwanLauncher swanLauncher, g33 g33Var) {
            this.a = g33Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements e33 {
        public final /* synthetic */ g33 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, g33 g33Var, String str) {
            this.a = g33Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.e33
        public void a(String str, g33 g33Var) {
            if (g33Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && g33Var.E() && TextUtils.equals(this.b, g33Var.getAppId())) {
                i33.k().h(this);
                yq2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                i33.k().h(this);
                yq2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.e33
        public void timeout() {
            yq2.k(this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements doc {
        public final /* synthetic */ al3 a;

        public d(SwanLauncher swanLauncher, al3 al3Var) {
            this.a = al3Var;
        }

        @Override // com.baidu.tieba.doc
        public void onCompleted() {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
            al3 al3Var = this.a;
            if (al3Var != null) {
                al3Var.a(null);
            }
        }

        @Override // com.baidu.tieba.doc
        public void onError(Throwable th) {
            SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
            al3 al3Var = this.a;
            if (al3Var != null) {
                al3Var.a(new Exception("initEnv failed", th));
            }
        }

        @Override // com.baidu.tieba.doc
        public void onSubscribe(loc locVar) {
            if (SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + locVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements coc.f {
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

    public void l(al3<Exception> al3Var) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, al3Var), new i(aVar.a()), b, c);
    }

    public static void p(String str, String str2) {
        h32.j(str, "SwanLaunch", str2, false);
    }

    public final void d(String str, g33 g33Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i33.k().c(new c(this, g33Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public void n(hr2 hr2Var, Bundle bundle) {
        if (hr2Var != null && !TextUtils.isEmpty(hr2Var.I())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", hr2Var.I());
            bundle2.putAll(hr2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    public final void e(@NonNull doc docVar, f... fVarArr) {
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
                    arrayList.add(coc.b(fVar));
                }
            }
            if (a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                coc.a(arrayList).h(ooc.b()).d(ooc.b()).g(docVar);
                return;
            } else {
                docVar.onCompleted();
                return;
            }
        }
        docVar.onCompleted();
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        boolean z = th instanceof T7CheckException;
        p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
        ai3 ai3Var = new ai3();
        if (z) {
            j = 15;
        } else {
            j = 9;
        }
        ai3Var.k(j);
        if (z) {
            j2 = 42;
        } else {
            j2 = 25;
        }
        ai3Var.i(j2);
        if (z) {
            str2 = "Sailor安装失败";
        } else {
            str2 = "Swan core 更新出错";
        }
        ai3Var.d(str2);
        br2.f(AppRuntime.getAppContext(), ai3Var, i2, str, bundle);
    }

    public void m(Bundle bundle) {
        f fVar;
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", op2.o().E());
        bundle.putInt("host_launch_type", ii3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        c13.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        g33 r = i33.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (cf2.b(string, string2)) {
            bundle.putLong("launch_interval", cf2.a());
            cf2.c();
            cf2.d(bundle);
            return;
        }
        cf2.e(string, string2);
        cf2.c();
        h32.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", f32.b(ky1.a(string)));
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
        bf2.c(i2);
    }

    @UiThread
    public final void o(g33 g33Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (mf3.j()) {
            of3.e();
        }
        SwanCoreVersion e2 = mf3.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = qg2.c(i2);
        bundle.putParcelable("extensionCore", c2);
        p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
        Bundle I = g23.I(fr2.g1(bundle));
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
            jSONObject2 = jm4.b(bundle.getString("mFrom"), null);
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
        f33.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int q = q(g33Var, bundle);
        Intent intent = new Intent(appContext, g33Var.O().activity);
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
            op2.d0().a(bundle.getString("mAppId"), g33Var);
            d(bundle.getString("mAppId"), g33Var);
        }
        g63.M().post(new b(this, g33Var));
    }

    public final int q(@NonNull g33 g33Var, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo u = ee4.i().u(g33Var.c);
        if (u != null && !u.isMaxAgeExpires()) {
            if (ob2.a.b()) {
                e2 = or2.b(u, bundle);
            } else {
                e2 = or2.e(u);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", u);
                ob2.b(g33Var, bundle);
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
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + g33Var.R());
        }
        return i2;
    }
}
