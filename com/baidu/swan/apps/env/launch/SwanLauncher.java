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
import d.b.h0.a.e0.r.a;
import d.b.h0.a.k;
import h.b;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class SwanLauncher {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11873a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static final f f11874b = new h(0);

    /* renamed from: c  reason: collision with root package name */
    public static final f f11875c = new h(1);

    /* renamed from: d  reason: collision with root package name */
    public static final f f11876d = new e();

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
        public final /* synthetic */ d.b.h0.a.n1.c.f.c f11877e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f11878f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f11879g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f11880h;

        public a(d.b.h0.a.n1.c.f.c cVar, Bundle bundle, int i, String str) {
            this.f11877e = cVar;
            this.f11878f = bundle;
            this.f11879g = i;
            this.f11880h = str;
        }

        @Override // h.c
        public void onCompleted() {
            SwanLauncher.this.o(this.f11877e, this.f11878f, this.f11879g);
        }

        @Override // h.c
        public void onError(Throwable th) {
            SwanLauncher.this.k(th, this.f11879g, this.f11880h, this.f11878f);
        }

        @Override // h.c
        public void onSubscribe(h.k kVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.n1.c.f.c f11881e;

        public b(SwanLauncher swanLauncher, d.b.h0.a.n1.c.f.c cVar) {
            this.f11881e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11881e.U();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.h0.a.n1.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.n1.c.f.c f11882a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11883b;

        public c(SwanLauncher swanLauncher, d.b.h0.a.n1.c.f.c cVar, String str) {
            this.f11882a = cVar;
            this.f11883b = str;
        }

        @Override // d.b.h0.a.n1.c.f.a
        public void a(String str, d.b.h0.a.n1.c.f.c cVar) {
            if (cVar != this.f11882a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && cVar.x() && TextUtils.equals(this.f11883b, cVar.getAppId())) {
                d.b.h0.a.n1.c.f.e.j().g(this);
                d.b.h0.a.y0.b.l(this.f11883b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                d.b.h0.a.n1.c.f.e.j().g(this);
                d.b.h0.a.y0.b.k(this.f11883b);
            }
        }

        @Override // d.b.h0.a.n1.c.f.a
        public void timeout() {
            d.b.h0.a.y0.b.k(this.f11883b);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements h.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f11884e;

        public d(SwanLauncher swanLauncher, d.b.h0.a.i2.u0.b bVar) {
            this.f11884e = bVar;
        }

        @Override // h.c
        public void onCompleted() {
            d.b.h0.a.c0.c.h("SwanLauncher", "init onCompleted");
            d.b.h0.a.i2.u0.b bVar = this.f11884e;
            if (bVar != null) {
                bVar.onCallback(null);
            }
        }

        @Override // h.c
        public void onError(Throwable th) {
            d.b.h0.a.c0.c.i("SwanLauncher", "initEnv onError: ", th);
            d.b.h0.a.i2.u0.b bVar = this.f11884e;
            if (bVar != null) {
                bVar.onCallback(new Exception("initEnv failed", th));
            }
        }

        @Override // h.c
        public void onSubscribe(h.k kVar) {
            if (SwanLauncher.f11873a) {
                Log.i("SwanLauncher", "init onSubscribe: " + kVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends f {

        /* loaded from: classes2.dex */
        public class a implements d.b.h0.a.e0.u.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h.c f11885a;

            public a(h.c cVar) {
                this.f11885a = cVar;
            }

            @Override // d.b.h0.a.e0.u.c
            public void onFail() {
                this.f11885a.onError(new T7CheckException(null));
            }

            @Override // d.b.h0.a.e0.u.c
            public void onSuccess() {
                e.this.b();
                this.f11885a.onCompleted();
            }
        }

        public e() {
            super(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: c */
        public void call(h.c cVar) {
            d.b.h0.a.w0.a.u().a();
            if (a()) {
                cVar.onCompleted();
            } else if (d.b.h0.a.w0.a.b0().c()) {
                b();
                cVar.onCompleted();
            } else {
                d.b.h0.a.w0.a.b0().d(false, new a(cVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public static final SwanLauncher f11888a = new SwanLauncher(null);
    }

    /* loaded from: classes2.dex */
    public static class h extends f {

        /* renamed from: f  reason: collision with root package name */
        public final int f11889f;

        /* loaded from: classes2.dex */
        public class a implements d.b.h0.a.i2.u0.b<Exception> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.c f11890e;

            public a(h.c cVar) {
                this.f11890e = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.f11890e.onCompleted();
                    return;
                }
                h.c cVar = this.f11890e;
                cVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.f11889f, exc));
            }
        }

        public h(int i) {
            super(null);
            this.f11889f = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: c */
        public void call(h.c cVar) {
            if (a()) {
                cVar.onCompleted();
            } else {
                d.b.h0.a.l0.f.a.d().c(new a(cVar), this.f11889f);
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
        return g.f11888a;
    }

    public final void d(String str, d.b.h0.a.n1.c.f.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.h0.a.n1.c.f.e.j().b(new c(this, cVar, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public final void e(@NonNull h.c cVar, f... fVarArr) {
        if (f11873a) {
            Log.i("SwanLauncher", "checkEnv: checkers=" + fVarArr);
        }
        if (fVarArr != null && fVarArr.length >= 1) {
            ArrayList arrayList = null;
            for (f fVar : fVarArr) {
                if (f11873a) {
                    Log.i("SwanLauncher", "checkEnv: checker=" + fVar);
                }
                if (fVar != null && !fVar.a()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(h.b.b(fVar));
                }
            }
            if (f11873a) {
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

    public final void k(Throwable th, int i, String str, Bundle bundle) {
        boolean z = th instanceof T7CheckException;
        d.b.h0.a.c0.c.h("SwanLauncher", "isT7Error = " + z);
        d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
        aVar.j(z ? 15L : 9L);
        aVar.h(z ? 42L : 25L);
        aVar.c(z ? "Sailor安装失败" : "Swan core 更新出错");
        d.b.h0.a.y0.d.a.e(AppRuntime.getAppContext(), aVar, i, str, bundle);
    }

    public void l(d.b.h0.a.i2.u0.b<Exception> bVar) {
        e(new d(this, bVar), f11876d, f11874b, f11875c);
    }

    public void m(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", d.b.h0.a.w0.a.l().w());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        int i = i(bundle);
        if (i < 0) {
            i = 0;
        }
        d.b.h0.a.n1.c.f.c q = d.b.h0.a.n1.c.f.e.j().q(string);
        q.E(string);
        if (d.b.h0.a.j1.m.c.f() && q.A()) {
            q.G();
            if (f11873a) {
                Log.d("SwanLauncher", "prevent series launch this swan app, time interval = " + d.b.h0.a.j1.m.c.a());
                return;
            }
            return;
        }
        if (f11873a) {
            boolean B = q.B();
            Log.d("SwanPreProcess", "app is cold boot = " + B);
        }
        d.b.h0.a.c0.c.g("SwanLauncher", "launch appId: " + string);
        bundle.putLong("launch_interval", q.g());
        bundle.putBoolean("console_switch", d.b.h0.a.c0.b.b(d.b.h0.a.u.a.a(string)));
        g(bundle);
        bundle.putLong("launch_time_on_main", System.currentTimeMillis());
        if (f11873a) {
            Log.d("SwanLauncher", "onReady processId: " + q.f46112f + " ,client:" + q.toString());
        }
        a aVar = new a(q, bundle, i, string);
        f[] fVarArr = new f[2];
        fVarArr[0] = f11876d;
        fVarArr[1] = 1 == i ? f11875c : f11874b;
        e(aVar, fVarArr);
        q.G();
    }

    public void n(d.b.h0.a.y0.e.e eVar, Bundle bundle) {
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
    public final void o(d.b.h0.a.n1.c.f.c cVar, Bundle bundle, int i) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (d.b.h0.a.b2.b.i()) {
            d.b.h0.a.b2.d.a.e();
        }
        SwanCoreVersion d2 = d.b.h0.a.b2.b.d(i);
        bundle.putParcelable("swanCoreVersion", d2);
        ExtensionCore b2 = d.b.h0.a.l0.b.b(i);
        bundle.putParcelable("extensionCore", b2);
        if (f11873a) {
            Log.d("SwanLauncher", "onUpdateFinished() SwanCoreVersion: " + d2);
            Log.d("SwanLauncher", "onUpdateFinished() ExtensionCoreVersion: " + b2);
        }
        Bundle D = d.b.h0.a.m1.a.a.D(d.b.h0.a.y0.e.c.V0(bundle));
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
            jSONObject2 = d.b.h0.p.c.b(bundle.getString("mFrom"), null, "pre_source");
        } else {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e2) {
                jSONObject = new JSONObject();
                if (f11873a) {
                    e2.printStackTrace();
                }
            }
            jSONObject2 = jSONObject;
        }
        bundle2.putString(UBCCloudControlProcessor.UBC_KEY, jSONObject2.toString());
        if (!d.b.h0.a.j1.m.c.c()) {
            d.b.h0.a.n1.c.f.b.h(bundle);
        }
        d.b.h0.g.i0.f.d.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        p(cVar, bundle);
        Intent intent = new Intent(appContext, cVar.y().activity);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtras(bundle);
        intent.putExtra("start_activity_time", System.currentTimeMillis());
        try {
            appContext.startActivity(intent);
        } catch (Exception e3) {
            if (f11873a) {
                e3.printStackTrace();
            }
        }
        if (i == 0) {
            d(bundle.getString("mAppId"), cVar);
        }
        d.b.h0.a.r1.d.g().post(new b(this, cVar));
    }

    public final void p(@NonNull d.b.h0.a.n1.c.f.c cVar, @NonNull Bundle bundle) {
        boolean e2;
        if (d.b.h0.a.j1.m.c.d() && !cVar.B()) {
            if (f11873a) {
                Log.d("SwanPreProcess", "sendAppLaunch, preAppLaunch ab = true, launch mode is not cold boot");
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo r = d.b.h0.l.i.a.h().r(cVar.f46113g);
        if (r != null && !r.l()) {
            if (a.C0712a.b()) {
                e2 = d.b.h0.a.y0.h.a.b(r, bundle);
            } else {
                e2 = d.b.h0.a.y0.h.a.e(r);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", r);
                d.b.h0.a.e0.r.a.b(cVar, bundle);
            }
        }
        if (f11873a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPreProcess", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + cVar.B());
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class f implements b.f {

        /* renamed from: e  reason: collision with root package name */
        public boolean f11887e;

        public f() {
            this.f11887e = false;
        }

        public boolean a() {
            return this.f11887e;
        }

        public void b() {
            this.f11887e = true;
        }

        @NonNull
        public String toString() {
            return super.toString() + " checked=" + this.f11887e;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public SwanLauncher() {
    }
}
