package b.a.p0.a.u1;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes.dex */
public class f implements b.a.p0.a.z2.g1.c<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8978e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile long f8979a;

        /* renamed from: b.a.p0.a.u1.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0445a {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static a f8980a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1482731640, "Lb/a/p0/a/u1/f$a$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1482731640, "Lb/a/p0/a/u1/f$a$a;");
                        return;
                    }
                }
                f8980a = new a();
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C0445a.f8980a : (a) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1336601330, "Lb/a/p0/a/u1/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1336601330, "Lb/a/p0/a/u1/f;");
                return;
            }
        }
        f8978e = k.f6863a;
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.z2.g1.c
    /* renamed from: a */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
            b(hybridUbcFlow);
        }
    }

    @SuppressLint({"SwanDebugLog", "LogConditional"})
    public void b(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) || hybridUbcFlow == null || hybridUbcFlow.f44670f.isEmpty()) {
            return;
        }
        String str = "master_dispatch_start";
        long f2 = hybridUbcFlow.f("slave_first_rendered", "master_dispatch_start");
        b.a.p0.a.u2.d.f9133g.update((b.a.p0.a.u2.c<Long>) Long.valueOf(f2));
        b.a.p0.a.u2.d.f9128b.update((b.a.p0.a.u2.c<Long>) Long.valueOf(hybridUbcFlow.f("slave_first_rendered", "naStart")));
        b.a.p0.a.u2.d.f9129c.update((b.a.p0.a.u2.c<Long>) Long.valueOf(hybridUbcFlow.f("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart")));
        long f3 = hybridUbcFlow.f("na_first_meaningful_paint", "naStart");
        if (f3 < 1) {
            f3 = hybridUbcFlow.f("na_first_paint", "naStart");
        }
        long j = f3 >= 1 ? f3 : 1L;
        a.a().f8979a = j;
        b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
        if (a0 == null) {
            return;
        }
        if (f8978e || b.a.p0.a.x1.a.a.d("aiapps_startup_reporter", false)) {
            int i2 = b.a.p0.a.x1.a.a.u().getInt("aiapps_startup_reporter_resolution", 100);
            String Y = a0.Y();
            if (TextUtils.isEmpty(Y)) {
                Y = "";
            }
            r0 = "\n\n  小程序启动性能报告: " + Y + " appID: " + (!TextUtils.isEmpty(a0.f4474f) ? a0.f4474f : "") + " speedLog\n";
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append("&");
            }
            boolean z = true;
            String.format(" Cost [%s] Delta Src  Total Action", sb.toString());
            long g2 = hybridUbcFlow.f44670f.get(0).g();
            Iterator<UbcFlowEvent> it = hybridUbcFlow.f44670f.iterator();
            long j2 = 0;
            while (it.hasNext()) {
                UbcFlowEvent next = it.next();
                if (!next.b() || b.a.p0.a.x1.a.a.d("aiapps_startup_reporter_local_report", z)) {
                    String[] strArr = new String[2];
                    strArr[0] = next.f44679a;
                    strArr[z ? 1 : 0] = "naStart";
                    long f4 = hybridUbcFlow.f(strArr);
                    boolean z2 = f4 < 0;
                    boolean z3 = f4 > j;
                    if (z2) {
                        f4 = 0;
                    }
                    if (z3) {
                        f4 = j;
                    }
                    long j3 = f4 - j2;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    long j4 = i2;
                    String str2 = str;
                    Iterator<UbcFlowEvent> it2 = it;
                    int round = Math.round((float) ((f4 * j4) / j));
                    if (round > i2) {
                        round = i2;
                    }
                    int round2 = Math.round((float) ((j4 * j3) / j));
                    if (round2 > i2) {
                        round2 = i2;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    long j5 = j;
                    sb2.append(String.format(Locale.getDefault(), " %5d ", Long.valueOf(f4)));
                    sb2.append(z2 ? "<" : PreferencesUtil.LEFT_MOUNT);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if (i4 > round) {
                            sb2.append(".");
                        } else if (i4 > round2) {
                            sb2.append("=");
                        } else {
                            sb2.append("#");
                        }
                    }
                    sb2.append(z3 ? ">" : PreferencesUtil.RIGHT_MOUNT);
                    sb2.append(String.format(Locale.getDefault(), "%5d", Long.valueOf(j3)));
                    sb2.append(String.format("  %s", next.f()));
                    sb2.append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(next.g() - g2)));
                    sb2.append(next.f44679a);
                    if (next.b()) {
                        sb2.append("(LocalRecord)");
                    }
                    sb2.toString();
                    j2 = f4;
                    j = j5;
                    str = str2;
                    it = it2;
                    z = true;
                }
            }
            String str3 = str;
            long j6 = j;
            String str4 = "Total  ： " + hybridUbcFlow.f44670f.size();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n========APS下载完成:" + hybridUbcFlow.f("aps_end_download", "naStart"));
            sb3.append("\n========解压包时长:" + hybridUbcFlow.f("package_end_unzip", "first_anim_start", "aps_end_download"));
            sb3.append("\n========第一次setData的调用:" + hybridUbcFlow.f("slave_first_loaded", "slave_js_parsed"));
            sb3.append("\n========master第一次和slave通信:" + hybridUbcFlow.f("slave_first_loaded", "master_first_init_data"));
            sb3.append("\n========slave第一次收到数据:" + hybridUbcFlow.f("slave_first_recieve_data", "master_first_init_data"));
            sb3.append("\n========slave第一次渲染完成:" + hybridUbcFlow.f("slave_first_rendered", "slave_first_recieve_data"));
            sb3.append("\n========第一次动画时长:" + hybridUbcFlow.f("first_anim_end", "first_anim_start"));
            sb3.append("\n========第二次动画时长:" + hybridUbcFlow.f("second_anim_end", "second_anim_start"));
            sb3.append("\n\n核心指标--------");
            sb3.append("\n========aps接口时长:" + hybridUbcFlow.f("aps_end_req", "aps_start_req", "naStart"));
            sb3.append("\n========aps纯下载时长:" + hybridUbcFlow.f("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart"));
            sb3.append("\n========");
            sb3.append("\n========准备启动时长:" + hybridUbcFlow.f("na_launch_activity", "naStart"));
            sb3.append("\n========准备查库时长:" + hybridUbcFlow.f("na_query_db", "naStart"));
            sb3.append("\n========Activity调起时长:" + hybridUbcFlow.f("frame_start_create", "na_launch_activity"));
            sb3.append("\n========");
            sb3.append("\n========预加载等待时长:" + hybridUbcFlow.f("na_pre_load_ok", "na_pre_load_check"));
            sb3.append("\n========主线程阻塞时长:" + hybridUbcFlow.f("na_post_to_main_end", "na_post_to_main_start"));
            sb3.append("\n========本地小程序包加载及渲染总时长:" + hybridUbcFlow.f("slave_first_rendered", "first_anim_start"));
            sb3.append("\n\n启动线性跟踪分段指标简报--------");
            sb3.append("\n========取包（网络开销，从小程序入口，到APS及前置接口等网络交互完成）:" + hybridUbcFlow.f("first_anim_start", "naStart"));
            sb3.append("\n========安装（IO开销，从下载完成，到小程序包解压安装作业完成）:" + hybridUbcFlow.f("package_end_unzip", "first_anim_start"));
            sb3.append("\n========下载-安装（IO开销，从下载开始，到小程序包解压安装作业完成）:" + hybridUbcFlow.f("package_end_unzip", "aps_start_download"));
            sb3.append("\n========小程序框架启动总时长（NA开销，从开始，到 NA 准备完成）:" + hybridUbcFlow.f(str3, "naStart"));
            sb3.append("\n========AppReady派发时长:" + hybridUbcFlow.f("fe_master_dispatch_start", str3));
            sb3.append("\n========小程序业务渲染总时长（H5开销，从 NA 准备完成，到页面渲染）:" + f2);
            int optInt = hybridUbcFlow.m().optInt("type", -1);
            String h2 = hybridUbcFlow.h("preload_scene");
            String h3 = hybridUbcFlow.h("app_package_version");
            if (TextUtils.isEmpty(h2)) {
                h2 = "-1";
            }
            String h4 = hybridUbcFlow.h("package_type");
            String str5 = TextUtils.isEmpty(h4) ? "-1" : h4;
            String h5 = hybridUbcFlow.h("preload");
            sb3.append("\n\n小程序启动总时长：========> " + j6 + " LaunchDiff=" + hybridUbcFlow.f("naStart", "user_action"));
            sb3.append(hybridUbcFlow.f44668d.contains("package_start_unzip") ^ true ? "(热启动)" : "(冷启动)");
            sb3.append("  relaunchType:" + optInt);
            sb3.append("  preloadType:" + h2);
            sb3.append(" packageType:" + str5);
            sb3.append(" preload:" + h5);
            if (!TextUtils.isEmpty(h3)) {
                sb3.append(" packageVersion:" + h3);
            }
            String str6 = "Report ： " + sb3.toString();
        }
    }
}
