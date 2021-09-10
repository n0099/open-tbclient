package c.a.p0.a.a2;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.i;
import c.a.p0.a.j2.n;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class j extends d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile e p;
    public final c.a.p0.a.v1.c.e.a q;
    public SwanAppActivity r;
    public boolean s;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = j.t;
                Process.killProcess(Process.myPid());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(812602200, "Lc/a/p0/a/a2/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(812602200, "Lc/a/p0/a/a2/j;");
                return;
            }
        }
        t = c.a.p0.a.k.f7077a;
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new c.a.p0.a.v1.c.e.a(this);
        this.s = false;
    }

    public static String G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.equals(jSONObject.optString("token"), "swanubc")) {
                    return jSONObject.toString();
                }
            } catch (JSONException e2) {
                if (t) {
                    e2.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.a.a2.h
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? r().C() : invokeV.booleanValue;
    }

    public final boolean H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? h.g0.contains(str) : invokeL.booleanValue;
    }

    public final boolean I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? TextUtils.equals("update_tag_by_app_launch", str) : invokeL.booleanValue;
    }

    public final boolean J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals("update_tag_by_prefetch", str) : invokeL.booleanValue;
    }

    public final void K(@NonNull Bundle bundle, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, bundle, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = bundle.getLong("launch_time");
            long j3 = currentTimeMillis - j2;
            long millis = TimeUnit.SECONDS.toMillis(10L);
            boolean z2 = false;
            z2 = (bundle.getBoolean("should_ignore_launch_time", false) || j2 <= 1 || j3 > millis) ? true : true;
            if (z2) {
                bundle.putLong("launch_time", currentTimeMillis);
                j2 = currentTimeMillis;
            }
            long j4 = bundle.getLong("start_activity_time");
            if (z2 || j4 < 1) {
                j4 = j2;
            }
            long j5 = bundle.getLong("receive_launch_intent_time");
            long j6 = (z2 || j5 < 1) ? j4 : j5;
            HybridUbcFlow p = c.a.p0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("naStart");
            ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent.h(j2);
            p.C(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_last_start");
            ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent2.h(j2);
            p.C(ubcFlowEvent2);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("na_launch_activity");
            ubcFlowEvent3.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent3.h(j4);
            p.C(ubcFlowEvent3);
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("na_receive_intent");
            ubcFlowEvent4.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent4.h(j6);
            p.C(ubcFlowEvent4);
            p.A("process", String.valueOf(SwanAppProcessInfo.current()));
            p.A("reuse", z ? "1" : "0");
            long j7 = bundle.getLong("veloce_start_time", 0L);
            if (j7 > 0) {
                UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("na_veloce_start");
                ubcFlowEvent5.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                ubcFlowEvent5.h(j7);
                p.C(ubcFlowEvent5);
            }
            long j8 = bundle.getLong("t7_loading_start", -1L);
            int i2 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
            if (i2 > 0) {
                UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("na_t7_load_start");
                ubcFlowEvent6.h(j8);
                p.C(ubcFlowEvent6);
            }
            long j9 = bundle.getLong("t7_loading_end", -1L);
            if (i2 > 0) {
                UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("na_t7_load_end");
                ubcFlowEvent7.h(j9);
                p.C(ubcFlowEvent7);
            }
            Bundle bundle2 = bundle.getBundle("mExtraData");
            if (bundle2 != null) {
                String G = G(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
                if (!TextUtils.isEmpty(G)) {
                    p.A(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, G);
                }
                p.A("abtest", bundle2.getString("aiapp_abtest_info", ""));
                long j10 = bundle2.getLong("click_time", -1L);
                if (j10 > 0) {
                    HybridUbcFlow p2 = c.a.p0.a.r1.h.p("startup");
                    UbcFlowEvent ubcFlowEvent8 = new UbcFlowEvent("user_action");
                    ubcFlowEvent8.h(j10);
                    p2.C(ubcFlowEvent8);
                }
            }
            c.a.p0.a.r1.h.n();
            this.p.L().F1(j4);
            this.p.L().A0(j4);
            c.a.p0.a.r1.k.f.j().b(j2);
            c.a.p0.a.r1.r.a.f().d("updateLaunchInfo");
            n.d();
            long j11 = bundle.getLong("launch_flag_for_statistic");
            long j12 = bundle.getLong("page_display_flag_for_statistic");
            if (j11 < 1 || j12 < 1 || currentTimeMillis - j11 > millis || currentTimeMillis - j12 > millis) {
                bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
                bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
            }
        }
    }

    @Override // c.a.p0.a.a2.d
    public c.a.p0.n.i.g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new c.a.p0.a.h0.m.n.b(this) : (c.a.p0.n.i.g) invokeV.objValue;
    }

    @Override // c.a.p0.a.a2.d
    public c.a.p0.a.c2.f.g0.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new c.a.p0.a.c2.f.g0.b(this) : (c.a.p0.a.c2.f.g0.a) invokeV.objValue;
    }

    @Override // c.a.p0.a.a2.h
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p == null ? "" : this.p.getAppId() : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.a2.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? r().l() : invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0153 A[Catch: all -> 0x0193, TryCatch #0 {, blocks: (B:6:0x000b, B:10:0x0013, B:12:0x0059, B:13:0x0074, B:15:0x007a, B:18:0x0082, B:20:0x008f, B:22:0x0099, B:24:0x009f, B:26:0x00a5, B:27:0x00a8, B:31:0x00bb, B:33:0x00c1, B:34:0x00c5, B:36:0x00d7, B:39:0x00df, B:40:0x00e5, B:42:0x00f9, B:45:0x010f, B:46:0x011f, B:48:0x0123, B:53:0x012f, B:55:0x0147, B:60:0x0153, B:62:0x0164, B:65:0x016d, B:67:0x0177, B:68:0x0187), top: B:77:0x000b }] */
    @Override // c.a.p0.a.a2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m(Bundle bundle, String str) {
        long j2;
        long j3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean q0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bundle, str) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                if (bundle == null) {
                    return;
                }
                String string = bundle.getString("mAppId");
                c.a.p0.a.e0.d.h("SwanImpl", "updateSwanApp updateTag:" + str + ",old appId:" + getAppId() + ",new appId:" + string);
                String string2 = bundle.getString("launch_id");
                c.a.p0.a.r1.l.d.b(string2);
                HybridUbcFlow p = c.a.p0.a.r1.h.p("startup");
                boolean z4 = true;
                if (!p.K(string2)) {
                    c.a.p0.a.r1.h.r("startup");
                    p = c.a.p0.a.r1.h.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("resetFlow");
                    ubcFlowEvent.a(true);
                    p.C(ubcFlowEvent);
                    p.K(string2);
                }
                if (!J(str) && !I(str)) {
                    boolean H = H(str);
                    if (TextUtils.isEmpty(string) || (TextUtils.equals(string, getAppId()) && !c.a.p0.a.e0.f.e.e.d())) {
                        j2 = 0;
                        j3 = 0;
                        z = false;
                        z2 = false;
                    } else {
                        if (c.a.p0.a.e0.f.e.e.d()) {
                            c.a.p0.a.e0.f.e.e.e(str);
                        }
                        j2 = System.currentTimeMillis();
                        boolean z5 = !TextUtils.isEmpty(o(new String[0]));
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (z5) {
                            c.a.p0.a.j2.j.c(3);
                        }
                        this.p = new e(this, string);
                        z = z5;
                        j3 = currentTimeMillis2;
                        H = true;
                        z2 = true;
                    }
                    if (C()) {
                        if (H) {
                            SwanLauncher.g(bundle);
                            K(bundle, z);
                        }
                        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_start");
                        ubcFlowEvent2.h(currentTimeMillis);
                        ubcFlowEvent2.a(true);
                        p.C(ubcFlowEvent2);
                        if (j2 > 0) {
                            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_update_reset_start");
                            ubcFlowEvent3.h(j2);
                            ubcFlowEvent3.a(true);
                            p.C(ubcFlowEvent3);
                        }
                        long j4 = j3;
                        if (j4 > 0) {
                            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_update_reset_ok");
                            ubcFlowEvent4.h(j4);
                            ubcFlowEvent4.a(true);
                            p.C(ubcFlowEvent4);
                        }
                        e eVar = this.p;
                        if (!z2 && this.p.e()) {
                            z3 = false;
                            q0 = eVar.q0(bundle, str, z3);
                            this.p.v0(str);
                            UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("swan_app_update_end");
                            ubcFlowEvent5.a(true);
                            p.C(ubcFlowEvent5);
                            if (!q0 || !this.p.e()) {
                                z4 = false;
                            }
                            if (z4) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("app_update_tag", str);
                                w("event_on_app_updated", bundle2);
                            }
                        }
                        z3 = true;
                        q0 = eVar.q0(bundle, str, z3);
                        this.p.v0(str);
                        UbcFlowEvent ubcFlowEvent52 = new UbcFlowEvent("swan_app_update_end");
                        ubcFlowEvent52.a(true);
                        p.C(ubcFlowEvent52);
                        if (!q0) {
                        }
                        z4 = false;
                        if (z4) {
                        }
                    }
                    if (z2) {
                        c.a.p0.a.h0.u.g.N().H(z);
                    }
                    return;
                }
                if (!TextUtils.equals(string, getAppId())) {
                    o("flag_not_unregister");
                    this.p = new e(this, string);
                }
                this.p.w0(bundle);
                this.p.v0(str);
            }
        }
    }

    @Override // c.a.p0.a.a2.h
    public SwanAppCores n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? r().n() : (SwanAppCores) invokeV.objValue;
    }

    @Override // c.a.p0.a.a2.h
    public synchronized String o(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, strArr)) == null) {
            synchronized (this) {
                if (this.s) {
                    return "";
                }
                this.s = true;
                String str = "";
                if (this.p != null && this.p.C()) {
                    str = this.p.p0(strArr);
                    this.p = null;
                    A((i.a) new i.a("event_on_app_reseted").z("event_params_reset_flags", strArr));
                    if (strArr == null || !Sets.newHashSet(strArr).contains("flag_not_unregister")) {
                        c.a.p0.a.v1.c.a.e().h(new c.a.p0.a.v1.c.c(2));
                    }
                }
                this.s = false;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.a.a2.h
    @NonNull
    public e r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.p == null) {
                synchronized (this) {
                    if (this.p == null) {
                        this.p = new e(this, "");
                    }
                }
            }
            return this.p;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.a.p0.a.a2.h
    public void s(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, swanAppActivity) == null) {
            this.r = null;
        }
    }

    @Override // c.a.p0.a.a2.h
    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.p != null && this.p.C()) {
            this.p.t();
            o("flag_finish_activity", "flag_remove_task");
            q0.X(new a(this));
        }
    }

    @Override // c.a.p0.a.a2.h
    public void u(SwanAppActivity swanAppActivity) {
        SwanAppActivity swanAppActivity2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, swanAppActivity) == null) || swanAppActivity == null || (swanAppActivity2 = this.r) == swanAppActivity) {
            return;
        }
        if (swanAppActivity2 != null) {
            s(swanAppActivity2);
        }
        this.r = swanAppActivity;
    }

    @Override // c.a.p0.a.a2.h
    public SwanAppActivity x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.r : (SwanAppActivity) invokeV.objValue;
    }

    @Override // c.a.p0.a.a2.h
    @Nullable
    public c.a.p0.a.v1.c.e.a z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.q : (c.a.p0.a.v1.c.e.a) invokeV.objValue;
    }
}
