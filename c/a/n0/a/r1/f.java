package c.a.n0.a.r1;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.a.n0.a.k;
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
public class f implements c.a.n0.a.v2.e1.b<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8069e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1221299152, "Lc/a/n0/a/r1/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1221299152, "Lc/a/n0/a/r1/f;");
                return;
            }
        }
        f8069e = k.f6803a;
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
    @Override // c.a.n0.a.v2.e1.b
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
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            c.a.n0.a.a2.e i2 = c.a.n0.a.a2.e.i();
            if (hybridUbcFlow == null || hybridUbcFlow.f45942f.isEmpty()) {
                return;
            }
            long e2 = hybridUbcFlow.e("slave_first_rendered", "master_dispatch_start");
            c.a.n0.a.q2.d.f7856g.d(Long.valueOf(e2));
            c.a.n0.a.q2.d.f7851b.d(Long.valueOf(hybridUbcFlow.e("slave_first_rendered", "naStart")));
            String str = "aps_start_download";
            String str2 = "aps_end_req";
            c.a.n0.a.q2.d.f7852c.d(Long.valueOf(hybridUbcFlow.e("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart")));
            if ((f8069e || c.a.n0.a.u1.a.a.d("aiapps_startup_reporter", false)) && i2 != null) {
                long e3 = hybridUbcFlow.e("na_first_meaningful_paint", "naStart");
                if (e3 < 1) {
                    e3 = hybridUbcFlow.e("na_first_paint", "naStart");
                }
                if (e3 < 1) {
                    e3 = 1;
                }
                int i3 = c.a.n0.a.u1.a.a.t().getInt("aiapps_startup_reporter_resolution", 100);
                String O = i2.O();
                if (TextUtils.isEmpty(O)) {
                    O = "";
                }
                r0 = "\n\n  小程序启动性能报告: " + O + " appID: " + (!TextUtils.isEmpty(i2.f4284f) ? i2.f4284f : "") + " speedLog\n";
                StringBuilder sb = new StringBuilder();
                for (int i4 = 0; i4 < i3; i4++) {
                    sb.append("&");
                }
                boolean z = true;
                String.format(" Cost [%s] Delta Src  Total Action", sb.toString());
                long g2 = hybridUbcFlow.f45942f.get(0).g();
                Iterator<UbcFlowEvent> it = hybridUbcFlow.f45942f.iterator();
                long j2 = 0;
                while (it.hasNext()) {
                    UbcFlowEvent next = it.next();
                    if (!next.b() || c.a.n0.a.u1.a.a.d("aiapps_startup_reporter_local_report", z)) {
                        String[] strArr = new String[2];
                        strArr[0] = next.f45952a;
                        strArr[z ? 1 : 0] = "naStart";
                        long e4 = hybridUbcFlow.e(strArr);
                        boolean z2 = e4 < 0;
                        boolean z3 = e4 > e3;
                        if (z2) {
                            e4 = 0;
                        }
                        if (z3) {
                            e4 = e3;
                        }
                        long j3 = e4 - j2;
                        if (j3 < 0) {
                            j3 = 0;
                        }
                        long j4 = i3;
                        String str3 = str;
                        String str4 = str2;
                        int round = Math.round((float) ((e4 * j4) / e3));
                        if (round > i3) {
                            round = i3;
                        }
                        int round2 = Math.round((float) ((j4 * j3) / e3));
                        if (round2 > i3) {
                            round2 = i3;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        Iterator<UbcFlowEvent> it2 = it;
                        long j5 = e3;
                        sb2.append(String.format(Locale.getDefault(), " %5d ", Long.valueOf(e4)));
                        sb2.append(z2 ? "<" : PreferencesUtil.LEFT_MOUNT);
                        for (int i5 = 0; i5 < i3; i5++) {
                            if (i5 > round) {
                                sb2.append(".");
                            } else if (i5 > round2) {
                                sb2.append("=");
                            } else {
                                sb2.append("#");
                            }
                        }
                        sb2.append(z3 ? ">" : PreferencesUtil.RIGHT_MOUNT);
                        sb2.append(String.format(Locale.getDefault(), "%5d", Long.valueOf(j3)));
                        sb2.append(String.format("  %s", next.f()));
                        sb2.append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(next.g() - g2)));
                        sb2.append(next.f45952a);
                        if (next.b()) {
                            sb2.append("(LocalRecord)");
                        }
                        sb2.toString();
                        j2 = e4;
                        it = it2;
                        str = str3;
                        str2 = str4;
                        e3 = j5;
                        z = true;
                    }
                }
                String str5 = str;
                String str6 = str2;
                long j6 = e3;
                String str7 = "Total  ： " + hybridUbcFlow.f45942f.size();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\n========APS下载完成:" + hybridUbcFlow.e("aps_end_download", "naStart"));
                sb3.append("\n========解压包时长:" + hybridUbcFlow.e("package_end_unzip", "first_anim_start", "aps_end_download"));
                sb3.append("\n========第一次setData的调用:" + hybridUbcFlow.e("slave_first_loaded", "slave_js_parsed"));
                sb3.append("\n========master第一次和slave通信:" + hybridUbcFlow.e("slave_first_loaded", "master_first_init_data"));
                sb3.append("\n========slave第一次收到数据:" + hybridUbcFlow.e("slave_first_recieve_data", "master_first_init_data"));
                sb3.append("\n========slave第一次渲染完成:" + hybridUbcFlow.e("slave_first_rendered", "slave_first_recieve_data"));
                sb3.append("\n========第一次动画时长:" + hybridUbcFlow.e("first_anim_end", "first_anim_start"));
                sb3.append("\n========第二次动画时长:" + hybridUbcFlow.e("second_anim_end", "second_anim_start"));
                sb3.append("\n\n核心指标--------");
                sb3.append("\n========aps接口时长:" + hybridUbcFlow.e(str6, "aps_start_req", "naStart"));
                sb3.append("\n========aps纯下载时长:" + hybridUbcFlow.e("aps_end_download", str5, str6, "aps_start_req", "naStart"));
                sb3.append("\n========");
                sb3.append("\n========准备启动时长:" + hybridUbcFlow.e("na_launch_activity", "naStart"));
                sb3.append("\n========准备查库时长:" + hybridUbcFlow.e("na_query_db", "naStart"));
                sb3.append("\n========Activity调起时长:" + hybridUbcFlow.e("frame_start_create", "na_launch_activity"));
                sb3.append("\n========");
                sb3.append("\n========预加载等待时长:" + hybridUbcFlow.e("na_pre_load_ok", "na_pre_load_check"));
                sb3.append("\n========主线程阻塞时长:" + hybridUbcFlow.e("na_post_to_main_end", "na_post_to_main_start"));
                sb3.append("\n========本地小程序包加载及渲染总时长:" + hybridUbcFlow.e("slave_first_rendered", "first_anim_start"));
                sb3.append("\n\n启动线性跟踪分段指标简报--------");
                sb3.append("\n========取包（网络开销，从小程序入口，到APS及前置接口等网络交互完成）:" + hybridUbcFlow.e("first_anim_start", "naStart"));
                sb3.append("\n========安装（IO开销，从下载完成，到小程序包解压安装作业完成）:" + hybridUbcFlow.e("package_end_unzip", "first_anim_start"));
                sb3.append("\n========下载-安装（IO开销，从下载开始，到小程序包解压安装作业完成）:" + hybridUbcFlow.e("package_end_unzip", str5));
                sb3.append("\n========小程序框架启动总时长（NA开销，从开始，到 NA 准备完成）:" + hybridUbcFlow.e("master_dispatch_start", "naStart"));
                sb3.append("\n========小程序业务渲染总时长（H5开销，从 NA 准备完成，到页面渲染）:" + e2);
                int optInt = hybridUbcFlow.k().optInt("type", -1);
                String g3 = hybridUbcFlow.g("preload_scene");
                String g4 = hybridUbcFlow.g("app_package_version");
                if (TextUtils.isEmpty(g3)) {
                    g3 = "-1";
                }
                String g5 = hybridUbcFlow.g("package_type");
                String str8 = TextUtils.isEmpty(g5) ? "-1" : g5;
                sb3.append("\n\n小程序启动总时长：========> " + j6 + " LaunchDiff=" + hybridUbcFlow.e("naStart", "user_action"));
                sb3.append(hybridUbcFlow.f45940d.contains("package_start_unzip") ^ true ? "(热启动)" : "(冷启动)");
                sb3.append("  relaunchType:" + optInt);
                sb3.append("  preloadType:" + g3);
                sb3.append(" packageType:" + str8);
                if (!TextUtils.isEmpty(g4)) {
                    sb3.append(" packageVersion:" + g4);
                }
                String str9 = "Report ： " + sb3.toString();
            }
        }
    }
}
