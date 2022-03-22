package c.a.n0.a.k1;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
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
public class e implements c.a.n0.a.p2.g1.c<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1214834474, "Lc/a/n0/a/k1/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1214834474, "Lc/a/n0/a/k1/e;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.p2.g1.c
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
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
            if (hybridUbcFlow == null || hybridUbcFlow.f29015f.isEmpty() || !a || L == null) {
                return;
            }
            HybridUbcFlow.SubmitStrategy i = hybridUbcFlow.i();
            String str = hybridUbcFlow.f29013d.contains("fe_route_start") ? "fe_route_start" : "na_first_receive_action";
            int i2 = 2;
            char c2 = 1;
            char c3 = 0;
            if (i == HybridUbcFlow.SubmitStrategy.ROUTE) {
                f2 = hybridUbcFlow.f("fe_first_render_start", str);
            } else if (i == HybridUbcFlow.SubmitStrategy.ROUTE_NA) {
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
            Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + Y + " appID: " + (!TextUtils.isEmpty(L.f6344b) ? L.f6344b : "") + " launchId ：" + (L.X() != null ? L.X().V() : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < 100; i3++) {
                sb.append("&");
            }
            Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
            long g2 = hybridUbcFlow.f29015f.get(0).g();
            Iterator<UbcFlowEvent> it = hybridUbcFlow.f29015f.iterator();
            long j = 0;
            long j2 = 0;
            while (it.hasNext()) {
                UbcFlowEvent next = it.next();
                String[] strArr = new String[i2];
                strArr[c3] = next.a;
                strArr[c2] = str;
                long f3 = hybridUbcFlow.f(strArr);
                boolean z = f3 < j;
                boolean z2 = f3 > f2;
                if (z) {
                    f3 = j;
                }
                if (z2) {
                    f3 = f2;
                }
                long j3 = f3 - j2;
                boolean z3 = z2;
                if (j3 < j) {
                    j3 = j;
                }
                long j4 = 100;
                int round = Math.round((float) ((f3 * j4) / f2));
                if (round > 100) {
                    round = 100;
                }
                int round2 = Math.round((float) ((j3 * j4) / f2));
                int i4 = round2 > 100 ? 100 : round2;
                StringBuilder sb2 = new StringBuilder();
                Iterator<UbcFlowEvent> it2 = it;
                sb2.append(String.format(Locale.getDefault(), "%5d ", Long.valueOf(j3)));
                sb2.append(z ? "<" : PreferencesUtil.LEFT_MOUNT);
                for (int i5 = 0; i5 < 100; i5++) {
                    if (i5 > round) {
                        sb2.append(".");
                    } else if (i5 > i4) {
                        sb2.append("=");
                    } else {
                        sb2.append("#");
                    }
                }
                sb2.append(z3 ? ">" : PreferencesUtil.RIGHT_MOUNT);
                c2 = 1;
                sb2.append(String.format(Locale.getDefault(), " %5d", Long.valueOf(f3)));
                sb2.append(String.format("  %s", next.f()));
                sb2.append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(next.g() - g2)));
                sb2.append(next.a);
                if (next.b()) {
                    sb2.append("(LocalRecord)");
                }
                Log.i("RouteReporter", sb2.toString());
                j2 = f3;
                it = it2;
                i2 = 2;
                c3 = 0;
                j = 0;
            }
            Log.i("RouteReporter", "Total  ： " + hybridUbcFlow.f29015f.size());
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
            Log.i("RouteReporter", "Report ： " + sb3.toString());
        }
    }
}
