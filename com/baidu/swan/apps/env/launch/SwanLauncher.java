package com.baidu.swan.apps.env.launch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.alibaba.fastjson.asm.Label;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.a.e0.r.a;
import d.a.h0.a.k;
import h.b;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class SwanLauncher {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11708a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static final f f11709b = new h(0);

    /* renamed from: c  reason: collision with root package name */
    public static final f f11710c = new h(1);

    /* renamed from: d  reason: collision with root package name */
    public static final f f11711d = new e();

    /* loaded from: classes2.dex */
    public static class T7CheckException extends Exception {
        public T7CheckException() {
        }

        public /* synthetic */ T7CheckException(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class a implements h.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.n1.c.f.c f11712e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f11713f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f11714g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f11715h;

        public a(d.a.h0.a.n1.c.f.c cVar, Bundle bundle, int i2, String str) {
            this.f11712e = cVar;
            this.f11713f = bundle;
            this.f11714g = i2;
            this.f11715h = str;
        }

        @Override // h.c
        public void onCompleted() {
            SwanLauncher.this.o(this.f11712e, this.f11713f, this.f11714g);
        }

        @Override // h.c
        public void onError(Throwable th) {
            SwanLauncher.this.k(th, this.f11714g, this.f11715h, this.f11713f);
        }

        @Override // h.c
        public void onSubscribe(h.k kVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.n1.c.f.c f11717e;

        public b(SwanLauncher swanLauncher, d.a.h0.a.n1.c.f.c cVar) {
            this.f11717e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11717e.U();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.h0.a.n1.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.n1.c.f.c f11718a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11719b;

        public c(SwanLauncher swanLauncher, d.a.h0.a.n1.c.f.c cVar, String str) {
            this.f11718a = cVar;
            this.f11719b = str;
        }

        @Override // d.a.h0.a.n1.c.f.a
        public void a(String str, d.a.h0.a.n1.c.f.c cVar) {
            if (cVar != this.f11718a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && cVar.z() && TextUtils.equals(this.f11719b, cVar.getAppId())) {
                d.a.h0.a.n1.c.f.e.j().g(this);
                d.a.h0.a.y0.b.l(this.f11719b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                d.a.h0.a.n1.c.f.e.j().g(this);
                d.a.h0.a.y0.b.k(this.f11719b);
            }
        }

        @Override // d.a.h0.a.n1.c.f.a
        public void timeout() {
            d.a.h0.a.y0.b.k(this.f11719b);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements h.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f11720e;

        public d(SwanLauncher swanLauncher, d.a.h0.a.i2.u0.b bVar) {
            this.f11720e = bVar;
        }

        @Override // h.c
        public void onCompleted() {
            d.a.h0.a.c0.c.h("SwanLauncher", "init onCompleted");
            d.a.h0.a.i2.u0.b bVar = this.f11720e;
            if (bVar != null) {
                bVar.onCallback(null);
            }
        }

        @Override // h.c
        public void onError(Throwable th) {
            d.a.h0.a.c0.c.i("SwanLauncher", "initEnv onError: ", th);
            d.a.h0.a.i2.u0.b bVar = this.f11720e;
            if (bVar != null) {
                bVar.onCallback(new Exception("initEnv failed", th));
            }
        }

        @Override // h.c
        public void onSubscribe(h.k kVar) {
            if (SwanLauncher.f11708a) {
                Log.i("SwanLauncher", "init onSubscribe: " + kVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends f {

        /* loaded from: classes2.dex */
        public class a implements d.a.h0.a.e0.u.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h.c f11721a;

            public a(h.c cVar) {
                this.f11721a = cVar;
            }

            @Override // d.a.h0.a.e0.u.c
            public void onFail() {
                this.f11721a.onError(new T7CheckException(null));
            }

            @Override // d.a.h0.a.e0.u.c
            public void onSuccess() {
                e.this.b();
                this.f11721a.onCompleted();
            }
        }

        public e() {
            super(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: c */
        public void call(h.c cVar) {
            d.a.h0.a.w0.a.u().c();
            if (a()) {
                cVar.onCompleted();
            } else if (d.a.h0.a.w0.a.b0().b()) {
                b();
                cVar.onCompleted();
            } else {
                d.a.h0.a.w0.a.b0().d(false, new a(cVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public static final SwanLauncher f11724a = new SwanLauncher(null);
    }

    /* loaded from: classes2.dex */
    public static class h extends f {

        /* renamed from: f  reason: collision with root package name */
        public final int f11725f;

        /* loaded from: classes2.dex */
        public class a implements d.a.h0.a.i2.u0.b<Exception> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.c f11726e;

            public a(h.c cVar) {
                this.f11726e = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.f11726e.onCompleted();
                    return;
                }
                h.c cVar = this.f11726e;
                cVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.f11725f, exc));
            }
        }

        public h(int i2) {
            super(null);
            this.f11725f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: c */
        public void call(h.c cVar) {
            if (a()) {
                cVar.onCompleted();
            } else {
                d.a.h0.a.l0.f.a.d().c(new a(cVar), this.f11725f);
            }
        }
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

    public static String h() {
        return UUID.randomUUID().toString();
    }

    public static int i(@NonNull Bundle bundle) {
        return Math.max(bundle.getInt("appFrameType", -1), -1);
    }

    public static SwanLauncher j() {
        return g.f11724a;
    }

    public final void d(String str, d.a.h0.a.n1.c.f.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.h0.a.n1.c.f.e.j().b(new c(this, cVar, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public final void e(@NonNull h.c cVar, f... fVarArr) {
        if (f11708a) {
            Log.i("SwanLauncher", "checkEnv: checkers=" + fVarArr);
        }
        if (fVarArr != null && fVarArr.length >= 1) {
            ArrayList arrayList = null;
            for (f fVar : fVarArr) {
                if (f11708a) {
                    Log.i("SwanLauncher", "checkEnv: checker=" + fVar);
                }
                if (fVar != null && !fVar.a()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(h.b.b(fVar));
                }
            }
            if (f11708a) {
                Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                h.b.a(arrayList).h(h.l.b.a.b()).d(h.l.b.a.b()).g(cVar);
                return;
            } else {
                cVar.onCompleted();
                return;
            }
        }
        cVar.onCompleted();
    }

    public final void f(Bundle bundle) {
        Context appContext = AppRuntime.getAppContext();
        Intent intent = new Intent(appContext, SwanAppLauncherActivity.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtras(bundle);
        appContext.startActivity(intent);
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        boolean z = th instanceof T7CheckException;
        d.a.h0.a.c0.c.h("SwanLauncher", "isT7Error = " + z);
        d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
        aVar.j(z ? 15L : 9L);
        aVar.h(z ? 42L : 25L);
        aVar.c(z ? "Sailor安装失败" : "Swan core 更新出错");
        d.a.h0.a.y0.d.a.e(AppRuntime.getAppContext(), aVar, i2, str, bundle);
    }

    public void l(d.a.h0.a.i2.u0.b<Exception> bVar) {
        e(new d(this, bVar), f11711d, f11709b, f11710c);
    }

    public void m(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", d.a.h0.a.w0.a.l().I());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        d.a.h0.a.n1.c.f.c q = d.a.h0.a.n1.c.f.e.j().q(string);
        q.E(string);
        if (d.a.h0.a.j1.m.c.f() && q.A()) {
            q.G();
            if (f11708a) {
                Log.d("SwanLauncher", "prevent series launch this swan app, time interval = " + d.a.h0.a.j1.m.c.a());
                return;
            }
            return;
        }
        if (f11708a) {
            boolean B = q.B();
            Log.d("SwanPreProcess", "app is cold boot = " + B);
        }
        d.a.h0.a.c0.c.g("SwanLauncher", "launch appId: " + string);
        bundle.putLong("launch_interval", q.g());
        bundle.putBoolean("console_switch", d.a.h0.a.c0.b.b(d.a.h0.a.u.a.a(string)));
        g(bundle);
        bundle.putLong("launch_time_on_main", System.currentTimeMillis());
        if (f11708a) {
            Log.d("SwanLauncher", "onReady processId: " + q.f43457f + " ,client:" + q.toString());
        }
        a aVar = new a(q, bundle, i2, string);
        f[] fVarArr = new f[2];
        fVarArr[0] = f11711d;
        fVarArr[1] = 1 == i2 ? f11710c : f11709b;
        e(aVar, fVarArr);
        q.G();
    }

    public void n(d.a.h0.a.y0.e.e eVar, Bundle bundle) {
        if (eVar == null || TextUtils.isEmpty(eVar.G())) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("mAppId", eVar.G());
        bundle2.putAll(eVar.A());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        m(bundle2);
    }

    @UiThread
    public final void o(d.a.h0.a.n1.c.f.c cVar, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (d.a.h0.a.b2.b.i()) {
            d.a.h0.a.b2.d.a.e();
        }
        SwanCoreVersion d2 = d.a.h0.a.b2.b.d(i2);
        bundle.putParcelable("swanCoreVersion", d2);
        ExtensionCore b2 = d.a.h0.a.l0.b.b(i2);
        bundle.putParcelable("extensionCore", b2);
        if (f11708a) {
            Log.d("SwanLauncher", "onUpdateFinished() SwanCoreVersion: " + d2);
            Log.d("SwanLauncher", "onUpdateFinished() ExtensionCoreVersion: " + b2);
        }
        Bundle D = d.a.h0.a.m1.a.a.D(d.a.h0.a.y0.e.c.V0(bundle));
        if (D != null) {
            bundle.putAll(D);
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
            jSONObject2 = d.a.h0.p.c.b(bundle.getString("mFrom"), null, "pre_source");
        } else {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e2) {
                jSONObject = new JSONObject();
                if (f11708a) {
                    e2.printStackTrace();
                }
            }
            jSONObject2 = jSONObject;
        }
        bundle2.putString(UBCCloudControlProcessor.UBC_KEY, jSONObject2.toString());
        if (!d.a.h0.a.j1.m.c.c()) {
            d.a.h0.a.n1.c.f.b.h(bundle);
        }
        d.a.h0.g.i0.f.d.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        p(cVar, bundle);
        Intent intent = new Intent(appContext, cVar.h().activity);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtras(bundle);
        intent.putExtra("start_activity_time", System.currentTimeMillis());
        try {
            appContext.startActivity(intent);
        } catch (Exception e3) {
            if (f11708a) {
                e3.printStackTrace();
            }
        }
        if (i2 == 0) {
            d(bundle.getString("mAppId"), cVar);
        }
        d.a.h0.a.r1.d.g().post(new b(this, cVar));
    }

    public final void p(@NonNull d.a.h0.a.n1.c.f.c cVar, @NonNull Bundle bundle) {
        boolean e2;
        if (d.a.h0.a.j1.m.c.d() && !cVar.B()) {
            if (f11708a) {
                Log.d("SwanPreProcess", "sendAppLaunch, preAppLaunch ab = true, launch mode is not cold boot");
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo r = d.a.h0.l.i.a.h().r(cVar.f43458g);
        if (r != null && !r.l()) {
            if (a.C0651a.b()) {
                e2 = d.a.h0.a.y0.h.a.b(r, bundle);
            } else {
                e2 = d.a.h0.a.y0.h.a.e(r);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", r);
                d.a.h0.a.e0.r.a.b(cVar, bundle);
            }
        }
        if (f11708a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPreProcess", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + cVar.B());
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class f implements b.f {

        /* renamed from: e  reason: collision with root package name */
        public boolean f11723e;

        public f() {
            this.f11723e = false;
        }

        public boolean a() {
            return this.f11723e;
        }

        public void b() {
            this.f11723e = true;
        }

        @NonNull
        public String toString() {
            return super.toString() + " checked=" + this.f11723e;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public SwanLauncher() {
    }
}
