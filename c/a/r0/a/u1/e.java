package c.a.r0.a.u1;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.a.r0.a.k;
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
import java.util.Locale;
/* loaded from: classes.dex */
public class e implements c.a.r0.a.z2.g1.c<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f9339e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(438015664, "Lc/a/r0/a/u1/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(438015664, "Lc/a/r0/a/u1/e;");
                return;
            }
        }
        f9339e = k.a;
    }

    public e() {
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
    @Override // c.a.r0.a.z2.g1.c
    /* renamed from: a */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
            b(hybridUbcFlow);
        }
    }

    @SuppressLint({"SwanDebugLog", "LogConditional"})
    public void b(HybridUbcFlow hybridUbcFlow) {
        long f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
            if (hybridUbcFlow == null || hybridUbcFlow.f38987f.isEmpty() || !f9339e || L == null) {
                return;
            }
            HybridUbcFlow.SubmitStrategy i2 = hybridUbcFlow.i();
            String str = hybridUbcFlow.f38985d.contains("fe_route_start") ? "fe_route_start" : "na_first_receive_action";
            int i3 = 2;
            char c2 = 1;
            char c3 = 0;
            if (i2 == HybridUbcFlow.SubmitStrategy.ROUTE) {
                f2 = hybridUbcFlow.f("fe_first_render_start", str);
            } else if (i2 == HybridUbcFlow.SubmitStrategy.ROUTE_NA) {
                f2 = hybridUbcFlow.f("na_push_page_end", str);
            } else {
                f2 = hybridUbcFlow.f("web_widget_first_screen_finish", str);
            }
            if (f2 < 1) {
                f2 = 1;
            }
            String Y = L.Y();
            if (TextUtils.isEmpty(Y)) {
                Y = "";
            }
            String str2 = "\n\n  小程序路由性能报告: " + Y + " appID: " + (!TextUtils.isEmpty(L.f5537f) ? L.f5537f : "") + " launchId ：" + (L.X() != null ? L.X().V() : "") + " speedLog\n";
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < 100; i4++) {
                sb.append("&");
            }
            String.format("Delta [%s]  Cost Src  Total Action", sb.toString());
            long g2 = hybridUbcFlow.f38987f.get(0).g();
            long j2 = 0;
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.f38987f) {
                String[] strArr = new String[i3];
                strArr[c3] = ubcFlowEvent.a;
                strArr[c2] = str;
                long f3 = hybridUbcFlow.f(strArr);
                boolean z = f3 < 0;
                boolean z2 = f3 > f2;
                if (z) {
                    f3 = 0;
                }
                if (z2) {
                    f3 = f2;
                }
                long j3 = f3 - j2;
                long j4 = j3 < 0 ? 0L : j3;
                long j5 = 100;
                int round = Math.round((float) ((f3 * j5) / f2));
                if (round > 100) {
                    round = 100;
                }
                int round2 = Math.round((float) ((j5 * j4) / f2));
                int i5 = round2 > 100 ? 100 : round2;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(String.format(Locale.getDefault(), "%5d ", Long.valueOf(j4)));
                sb2.append(z ? "<" : PreferencesUtil.LEFT_MOUNT);
                for (int i6 = 0; i6 < 100; i6++) {
                    if (i6 > round) {
                        sb2.append(".");
                    } else if (i6 > i5) {
                        sb2.append("=");
                    } else {
                        sb2.append("#");
                    }
                }
                sb2.append(z2 ? ">" : PreferencesUtil.RIGHT_MOUNT);
                sb2.append(String.format(Locale.getDefault(), " %5d", Long.valueOf(f3)));
                sb2.append(String.format("  %s", ubcFlowEvent.f()));
                sb2.append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.g() - g2)));
                sb2.append(ubcFlowEvent.a);
                if (ubcFlowEvent.b()) {
                    sb2.append("(LocalRecord)");
                }
                sb2.toString();
                j2 = f3;
                i3 = 2;
                c2 = 1;
                c3 = 0;
            }
            String str3 = "Total  ： " + hybridUbcFlow.f38987f.size();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n\n小程序路由总时长：========> " + f2);
            String optString = hybridUbcFlow.m().optString("type");
            String h2 = hybridUbcFlow.h("sub_state");
            String h3 = hybridUbcFlow.h("preload");
            String h4 = hybridUbcFlow.h("web_widget_state");
            StringBuilder sb4 = new StringBuilder();
            sb4.append("\nsub_state :");
            sb4.append(TextUtils.equals(h2, "0") ? "无需下载分包" : "需要下载分包");
            sb3.append(sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\npreload :");
            sb5.append(TextUtils.equals(h3, "0") ? "未完成" : "已完成");
            sb3.append(sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("\nhasWebViewWidget :");
            sb6.append(TextUtils.equals(h4, "0") ? "无webview组件" : "有webview组件");
            sb3.append(sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("\ntype ：");
            sb7.append(TextUtils.isEmpty(optString) ? "" : optString);
            sb3.append(sb7.toString());
            String str4 = "Report ： " + sb3.toString();
        }
    }
}
