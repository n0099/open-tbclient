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
import com.alibaba.fastjson.asm.Label;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.h0.p.a;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import h.b;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class SwanLauncher {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10828a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final f f10829b = new h(0);

    /* renamed from: c  reason: collision with root package name */
    public static final f f10830c = new h(1);

    /* loaded from: classes3.dex */
    public static class T7CheckException extends Exception {
        public T7CheckException() {
        }

        public /* synthetic */ T7CheckException(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements h.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v1.c.f.c f10831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f10832f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f10833g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10834h;

        public a(d.a.l0.a.v1.c.f.c cVar, Bundle bundle, int i2, String str) {
            this.f10831e = cVar;
            this.f10832f = bundle;
            this.f10833g = i2;
            this.f10834h = str;
        }

        @Override // h.c
        public void onCompleted() {
            SwanLauncher.this.o(this.f10831e, this.f10832f, this.f10833g);
            d.a.l0.a.a2.d.g().q("event_launch_swan");
        }

        @Override // h.c
        public void onError(Throwable th) {
            if (q0.G() && (th instanceof T7CheckException)) {
                return;
            }
            d.a.l0.a.a2.d.g().q("event_launch_swan");
            SwanLauncher.this.k(th, this.f10833g, this.f10834h, this.f10832f);
        }

        @Override // h.c
        public void onSubscribe(h.k kVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v1.c.f.c f10836e;

        public b(SwanLauncher swanLauncher, d.a.l0.a.v1.c.f.c cVar) {
            this.f10836e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10836e.Z();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.v1.c.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v1.c.f.c f10837a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10838b;

        public c(SwanLauncher swanLauncher, d.a.l0.a.v1.c.f.c cVar, String str) {
            this.f10837a = cVar;
            this.f10838b = str;
        }

        @Override // d.a.l0.a.v1.c.f.a
        public void a(String str, d.a.l0.a.v1.c.f.c cVar) {
            if (cVar != this.f10837a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && cVar.C() && TextUtils.equals(this.f10838b, cVar.getAppId())) {
                d.a.l0.a.v1.c.f.e.k().h(this);
                d.a.l0.a.f1.b.l(this.f10838b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                d.a.l0.a.v1.c.f.e.k().h(this);
                d.a.l0.a.f1.b.k(this.f10838b);
            }
        }

        @Override // d.a.l0.a.v1.c.f.a
        public void timeout() {
            d.a.l0.a.f1.b.k(this.f10838b);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements h.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f10839e;

        public d(SwanLauncher swanLauncher, d.a.l0.a.v2.e1.b bVar) {
            this.f10839e = bVar;
        }

        @Override // h.c
        public void onCompleted() {
            d.a.l0.a.e0.d.h("SwanLauncher", "init onCompleted");
            d.a.l0.a.v2.e1.b bVar = this.f10839e;
            if (bVar != null) {
                bVar.onCallback(null);
            }
        }

        @Override // h.c
        public void onError(Throwable th) {
            d.a.l0.a.e0.d.i("SwanLauncher", "initEnv onError: ", th);
            d.a.l0.a.v2.e1.b bVar = this.f10839e;
            if (bVar != null) {
                bVar.onCallback(new Exception("initEnv failed", th));
            }
        }

        @Override // h.c
        public void onSubscribe(h.k kVar) {
            if (SwanLauncher.f10828a) {
                Log.i("SwanLauncher", "init onSubscribe: " + kVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public int f10840a;

        /* renamed from: b  reason: collision with root package name */
        public int f10841b;

        /* renamed from: c  reason: collision with root package name */
        public Bundle f10842c;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public e f10843a = new e(null);

            public e a() {
                return this.f10843a;
            }

            public a b(int i2) {
                this.f10843a.f10840a = i2;
                return this;
            }

            public a c(Bundle bundle) {
                this.f10843a.f10842c = bundle;
                return this;
            }

            public a d(int i2) {
                this.f10843a.f10841b = i2;
                return this;
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        public e() {
            this.f10840a = -1;
            this.f10841b = -1;
        }
    }

    /* loaded from: classes3.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public static final SwanLauncher f10845a = new SwanLauncher(null);
    }

    /* loaded from: classes3.dex */
    public static class h extends f {

        /* renamed from: f  reason: collision with root package name */
        public final int f10846f;

        /* loaded from: classes3.dex */
        public class a implements d.a.l0.a.v2.e1.b<Exception> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.c f10847e;

            public a(h.c cVar) {
                this.f10847e = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                if (exc == null) {
                    h.this.b();
                    this.f10847e.onCompleted();
                    return;
                }
                h.c cVar = this.f10847e;
                cVar.onError(new Exception("SwanJsUpdater fail frame type = " + h.this.f10846f, exc));
            }
        }

        public h(int i2) {
            super(null);
            this.f10846f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: c */
        public void call(h.c cVar) {
            if (a()) {
                cVar.onCompleted();
            } else {
                d.a.l0.a.p0.e.a.d().c(new a(cVar), this.f10846f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends f {

        /* renamed from: f  reason: collision with root package name */
        public final e f10849f;

        /* loaded from: classes3.dex */
        public class a implements d.a.l0.a.h0.s.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.h0.s.e f10850a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h.c f10851b;

            public a(d.a.l0.a.h0.s.e eVar, h.c cVar) {
                this.f10850a = eVar;
                this.f10851b = cVar;
            }

            @Override // d.a.l0.a.h0.s.c
            public void onFail() {
                if (this.f10850a.f46248b) {
                    this.f10851b.onError(new T7CheckException(null));
                }
            }

            @Override // d.a.l0.a.h0.s.c
            public void onSuccess() {
                i.this.g();
                if (this.f10850a.f46248b) {
                    i.this.b();
                    this.f10851b.onCompleted();
                }
            }
        }

        public i(@NonNull e eVar) {
            super(null);
            this.f10849f = eVar;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public boolean a() {
            return super.a() || d.a.l0.a.c1.a.n0().c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: d */
        public void call(h.c cVar) {
            d.a.l0.a.c1.a.C().c();
            if (a()) {
                cVar.onCompleted();
            } else if (d.a.l0.a.c1.a.n0().c()) {
                b();
                cVar.onCompleted();
            } else {
                e eVar = this.f10849f;
                if (eVar.f10841b != 1) {
                    cVar.onError(new T7CheckException(null));
                    return;
                }
                if (eVar.f10840a == 0 && !BdZeusUtil.isZeusSupported()) {
                    b();
                    cVar.onCompleted();
                }
                f(cVar);
            }
        }

        public final d.a.l0.a.h0.s.e e(e eVar, boolean z) {
            d.a.l0.a.h0.s.e eVar2 = new d.a.l0.a.h0.s.e();
            eVar2.f46247a = "by_click";
            int i2 = this.f10849f.f10840a;
            eVar2.f46248b = z;
            Bundle bundle = eVar.f10842c;
            if (bundle != null) {
                bundle.getString("mFrom", "unknown");
            }
            return eVar2;
        }

        public final void f(h.c cVar) {
            Bundle bundle = this.f10849f.f10842c;
            if (bundle == null) {
                cVar.onError(new T7CheckException(null));
                return;
            }
            String string = bundle.getString("launchScheme");
            if (TextUtils.isEmpty(string)) {
                cVar.onError(new T7CheckException(null));
                return;
            }
            Uri build = Uri.parse(string).buildUpon().build();
            if (build == null) {
                cVar.onError(new T7CheckException(null));
                return;
            }
            boolean z = true;
            if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.f10849f.f10840a != 1 && !d.a.l0.a.c1.a.w().g()) {
                z = false;
            }
            if (!z) {
                b();
                cVar.onCompleted();
            }
            h();
            d.a.l0.a.h0.s.e e2 = e(this.f10849f, z);
            d.a.l0.a.c1.a.n0().b(e2, new a(e2, cVar));
        }

        public final void g() {
            Bundle bundle = this.f10849f.f10842c;
            if (bundle != null) {
                bundle.putLong("t7_loading_end", System.currentTimeMillis());
                d.a.l0.a.e0.d.h("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void h() {
            Bundle bundle = this.f10849f.f10842c;
            if (bundle != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                d.a.l0.a.e0.d.h("SwanLauncher", "swanSailor loadingStart");
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
        return g.f10845a;
    }

    public final void d(String str, d.a.l0.a.v1.c.f.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.l0.a.v1.c.f.e.k().c(new c(this, cVar, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public final void e(@NonNull h.c cVar, f... fVarArr) {
        if (f10828a) {
            Log.i("SwanLauncher", "checkEnv: checkers=" + fVarArr);
        }
        if (fVarArr != null && fVarArr.length >= 1) {
            ArrayList arrayList = null;
            for (f fVar : fVarArr) {
                if (f10828a) {
                    Log.i("SwanLauncher", "checkEnv: checker=" + fVar);
                }
                if (fVar != null && !fVar.a()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(h.b.b(fVar));
                }
            }
            if (f10828a) {
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
        d.a.l0.a.e0.d.h("SwanLauncher", "isT7Error = " + z);
        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
        aVar.j(z ? 15L : 9L);
        aVar.h(z ? 42L : 25L);
        aVar.c(z ? "Sailor安装失败" : "Swan core 更新出错");
        d.a.l0.a.f1.d.a.e(AppRuntime.getAppContext(), aVar, i2, str, bundle);
    }

    public void l(d.a.l0.a.v2.e1.b<Exception> bVar) {
        e.a aVar = new e.a();
        aVar.b(-1);
        aVar.d(0);
        e(new d(this, bVar), new i(aVar.a()), f10829b, f10830c);
    }

    public void m(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", d.a.l0.a.c1.a.n().B());
        bundle.putInt("host_launch_type", d.a.l0.a.t2.a.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        d.a.l0.a.r1.r.b.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        d.a.l0.a.v1.c.f.c r = d.a.l0.a.v1.c.f.e.k().r(string);
        r.I(string);
        String string2 = bundle.getString("mPage");
        if (d.a.l0.a.n0.i.b.b(string, string2)) {
            bundle.putLong("launch_interval", d.a.l0.a.n0.i.b.a());
            d.a.l0.a.n0.i.b.c();
            d.a.l0.a.n0.i.b.d(bundle);
            return;
        }
        d.a.l0.a.n0.i.b.e(string, string2);
        d.a.l0.a.n0.i.b.c();
        if (f10828a) {
            boolean F = r.F();
            Log.d("SwanPerformance", "app is cold boot = " + F);
        }
        d.a.l0.a.e0.d.g("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", d.a.l0.a.e0.b.b(d.a.l0.a.v.a.a(string)));
        g(bundle);
        bundle.putLong("launch_time_on_main", System.currentTimeMillis());
        bundle.putInt("main_pid", Process.myPid());
        if (f10828a) {
            Log.d("SwanLauncher", "onReady processId: " + r.f49005f + " ,client:" + r.toString());
        }
        e.a aVar = new e.a();
        aVar.b(i2);
        aVar.d(1);
        aVar.c(bundle);
        i iVar = new i(aVar.a());
        a aVar2 = new a(r, bundle, i2, string);
        f[] fVarArr = new f[2];
        fVarArr[0] = iVar;
        fVarArr[1] = 1 == i2 ? f10830c : f10829b;
        e(aVar2, fVarArr);
        d.a.l0.a.n0.i.a.c(i2);
    }

    public void n(d.a.l0.a.f1.e.e eVar, Bundle bundle) {
        if (eVar == null || TextUtils.isEmpty(eVar.H())) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("mAppId", eVar.H());
        bundle2.putAll(eVar.C());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        m(bundle2);
    }

    @UiThread
    public final void o(d.a.l0.a.v1.c.f.c cVar, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (d.a.l0.a.m2.b.j()) {
            d.a.l0.a.m2.d.a.e();
        }
        SwanCoreVersion e2 = d.a.l0.a.m2.b.e(i2);
        bundle.putParcelable("swanCoreVersion", e2);
        ExtensionCore c2 = d.a.l0.a.p0.b.c(i2);
        bundle.putParcelable("extensionCore", c2);
        if (f10828a) {
            Log.d("SwanLauncher", "onUpdateFinished() SwanCoreVersion: " + e2);
            Log.d("SwanLauncher", "onUpdateFinished() ExtensionCoreVersion: " + c2);
        }
        Bundle H = d.a.l0.a.u1.a.a.H(d.a.l0.a.f1.e.c.c1(bundle));
        if (H != null) {
            bundle.putAll(H);
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
            jSONObject2 = d.a.l0.t.c.b(bundle.getString("mFrom"), null);
        } else {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e3) {
                jSONObject = new JSONObject();
                if (f10828a) {
                    e3.printStackTrace();
                }
            }
            jSONObject2 = jSONObject;
        }
        bundle2.putString(UBCCloudControlProcessor.UBC_KEY, jSONObject2.toString());
        d.a.l0.a.v1.c.f.b.j(bundle);
        Context appContext = AppRuntime.getAppContext();
        int p = p(cVar, bundle);
        Intent intent = new Intent(appContext, cVar.k().activity);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtras(bundle);
        intent.putExtra("start_activity_time", System.currentTimeMillis());
        intent.putExtra("preAppReadyState", p);
        try {
            appContext.startActivity(intent);
        } catch (Exception e4) {
            if (f10828a) {
                e4.printStackTrace();
            }
        }
        if (i2 == 0) {
            d.a.l0.a.c1.a.W().a(bundle.getString("mAppId"), cVar);
            d(bundle.getString("mAppId"), cVar);
        }
        d.a.l0.a.a2.d.i().post(new b(this, cVar));
    }

    public final int p(@NonNull d.a.l0.a.v1.c.f.c cVar, @NonNull Bundle bundle) {
        int i2;
        boolean e2;
        long currentTimeMillis = System.currentTimeMillis();
        PMSAppInfo s = d.a.l0.n.g.a.h().s(cVar.f49006g);
        if (s != null && !s.m()) {
            if (a.C0750a.b()) {
                e2 = d.a.l0.a.f1.h.a.b(s, bundle);
            } else {
                e2 = d.a.l0.a.f1.h.a.e(s);
            }
            if (e2) {
                bundle.putParcelable("pms_db_info_onload", s);
                d.a.l0.a.h0.p.a.b(cVar, bundle);
                i2 = 5;
            } else {
                i2 = 4;
            }
        } else if (s == null) {
            i2 = 2;
        } else {
            i2 = s.m() ? 3 : 0;
        }
        if (f10828a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + cVar.F());
        }
        return i2;
    }

    /* loaded from: classes3.dex */
    public static abstract class f implements b.f {

        /* renamed from: e  reason: collision with root package name */
        public boolean f10844e;

        public f() {
            this.f10844e = false;
        }

        public boolean a() {
            return this.f10844e;
        }

        public void b() {
            this.f10844e = true;
        }

        @NonNull
        public String toString() {
            return super.toString() + " checked=" + this.f10844e;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public SwanLauncher() {
    }
}
