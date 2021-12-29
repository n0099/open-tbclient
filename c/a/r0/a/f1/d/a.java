package c.a.r0.a.f1.d;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.e0.d;
import c.a.r0.a.g1.f;
import c.a.r0.a.k;
import c.a.r0.a.u1.h;
import c.a.r0.a.y1.c.f.e;
import c.a.r0.a.z2.l;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.r;
import c.a.r0.a.z2.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppClearCacheErrorActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5953b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f5954c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.f1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0306a implements c.a.r0.a.y1.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Set f5955b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5956c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5957d;

        public C0306a(int i2, Set set, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), set, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f5955b = set;
            this.f5956c = str;
            this.f5957d = str2;
        }

        @Override // c.a.r0.a.y1.c.f.a
        public void a(String str, c.a.r0.a.y1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar.f9947f.index == this.a && this.f5955b.contains(str)) {
                e.k().h(this);
                a.i(this.f5956c, this.f5957d);
            }
        }

        @Override // c.a.r0.a.y1.c.f.a
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.i(this.f5956c, this.f5957d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                boolean unused = a.f5953b = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.r0.a.f1.d.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0307a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bundle f5958e;

            public RunnableC0307a(c cVar, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bundle};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5958e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a.j(this.f5958e.getString("arg_title"), this.f5958e.getString("arg_message"), this.f5958e.getInt("arg_match_target_down", SwanAppProcessInfo.UNKNOWN.index));
                }
            }
        }

        public c() {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                if (bundle != null) {
                    q0.e0(new RunnableC0307a(this, bundle));
                    return null;
                }
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-401433488, "Lc/a/r0/a/f1/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-401433488, "Lc/a/r0/a/f1/d/a;");
                return;
            }
        }
        a = k.a;
        f5953b = false;
        f5954c = TimeUnit.SECONDS.toMillis(1L);
    }

    public static String d(@NonNull Context context, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Long.valueOf(j2)})) == null) ? h(context, str) ? SwanAppErrorActivity.TYPE_NETWORK_ERROR : j2 == 2205 ? SwanAppErrorActivity.TYPE_DISK_LACK : j2 == 49 ? SwanAppErrorActivity.TYPE_MEMORY_LACK : SwanAppErrorActivity.TYPE_NORMAL : (String) invokeCommon.objValue;
    }

    public static void e(Context context, @NonNull c.a.r0.a.u2.a aVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65541, null, context, aVar, i2, str) == null) {
            f(context, aVar, i2, str, null);
        }
    }

    public static void f(Context context, @NonNull c.a.r0.a.u2.a aVar, int i2, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, aVar, Integer.valueOf(i2), str, bundle}) == null) {
            h.k(aVar);
            g(context, aVar, i2, str, false, bundle);
        }
    }

    public static void g(Context context, @NonNull c.a.r0.a.u2.a aVar, int i2, String str, boolean z, Bundle bundle) {
        File a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, aVar, Integer.valueOf(i2), str, Boolean.valueOf(z), bundle}) == null) || context == null) {
            return;
        }
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            d.k("LaunchError", "launch activity closed, ignore launch error");
            return;
        }
        SwanLauncher.p("LaunchError", "处理调起错误 errorCode=" + aVar);
        String i3 = c.a.r0.a.q2.b.i(f.U().M(), i2);
        long h2 = aVar.h();
        String r = aVar.r();
        boolean z2 = 1020 == h2 && !TextUtils.isEmpty(r);
        String a3 = z2 ? r : c.a.r0.q.k.i.f.b().a(h2);
        String format = String.format(context.getResources().getString(c.a.r0.a.h.aiapps_open_failed_detail_format), q0.D(), i3, String.valueOf(aVar.a()));
        if (!c.a.r0.a.c1.a.T().a(context, str, aVar)) {
            if (i2 == 0) {
                String d2 = d(context, str, h2);
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(c.a.r0.a.d2.d.J().r().V(), a3, format);
                forbiddenInfo.enableSlidingFlag = -1;
                c.a.r0.a.b3.b.c().n(aVar);
                l(context, d2, aVar, forbiddenInfo, bundle);
            } else if (i2 == 1) {
                m(context, str, a3, z2 ? r : c.a.r0.q.k.i.f.b().c(h2), format, (z ? SwanAppProcessInfo.current() : SwanAppProcessInfo.UNKNOWN).index);
            }
        }
        StringBuilder sb = new StringBuilder();
        String b2 = c.a.r0.a.z2.k.b(c.a.r0.a.z2.k.a(), "yyyy-MM-dd HH:mm:ss");
        if (!TextUtils.isEmpty(str)) {
            sb.append(b2);
            sb.append(": ");
            sb.append(str);
            sb.append("\r\n");
        }
        sb.append(b2);
        sb.append(": ");
        sb.append(format);
        sb.append("\r\n");
        r.c(sb.toString(), false);
        if (k.a) {
            String y = q0.y();
            if (TextUtils.isEmpty(y) || (a2 = l.a()) == null) {
                return;
            }
            File file = new File(a2.getPath(), "error_dialog_info.txt");
            c.a.r0.w.d.j(file);
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(format)) {
                sb2.append(format);
                sb2.append(StringUtils.LF);
            }
            sb2.append(y);
            sb2.append(StringUtils.LF);
            c.a.r0.w.d.N(sb2.toString(), file);
        }
    }

    public static boolean h(@NonNull Context context, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) ? (TextUtils.isEmpty(str) || SwanAppNetworkUtils.i(context) || c.a.r0.a.f1.h.a.d(str)) ? false : true : invokeLL.booleanValue;
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) || f5953b) {
            return;
        }
        BaseActivityDialog.e newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.C(str);
        newBuilder.y(new b());
        newBuilder.v(str2);
        newBuilder.z(c.a.r0.a.h.aiapps_confirm_text, null);
        newBuilder.D();
        f5953b = true;
    }

    public static void j(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65546, null, str, str2, i2) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            if (!ProcessUtils.isMainProcess()) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_title", str);
                bundle.putString("arg_message", str2);
                bundle.putInt("arg_match_target_down", i2);
                c.a.r0.a.y1.b.e.c(c.class, bundle);
                return;
            }
            if (a) {
                String str3 = "show normal err dialog, isShowing=" + f5953b;
            }
            if (!SwanAppProcessInfo.checkProcessId(i2)) {
                i(str, str2);
                return;
            }
            e.k().c(new C0306a(i2, Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline"), str, str2), f5954c);
        }
    }

    public static void k(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, str, str2) == null) {
            String format = String.format(context.getResources().getString(c.a.r0.a.h.swanapp_launch_err_toast_format), str, str2);
            if (a) {
                String str3 = "show normal err toast: " + format;
            }
            c.a.r0.a.c2.b.f.e g2 = c.a.r0.a.c2.b.f.e.g(AppRuntime.getAppContext(), format);
            g2.q(Integer.MAX_VALUE);
            g2.F();
        }
    }

    public static void l(Context context, String str, c.a.r0.a.u2.a aVar, ForbiddenInfo forbiddenInfo, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65548, null, context, str, aVar, forbiddenInfo, bundle) == null) {
            Intent intent = new Intent();
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            int g2 = c.a.r0.a.l1.a.g();
            int h2 = q0.O() ? 0 : c.a.r0.a.l1.a.h(context);
            intent.putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, str);
            intent.putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_CODE, String.valueOf(aVar.a()));
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_FORBIDDEN_INFO, forbiddenInfo);
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_MENU_NOTICE_COUNT, g2);
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_MENU_PRIVACY_COUNT, h2);
            PMSAppInfo f0 = c.a.r0.a.d2.d.J().r().V().f0();
            if (f0 != null) {
                c.a.r0.a.b3.b.c().n(aVar);
                intent.putExtra("webUrl", f0.webUrl);
                intent.putExtra(SwanAppErrorActivity.KEY_SWAN_WEB_PERMIT, f0.webPermit);
            }
            if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_DISK_LACK) && q0.G()) {
                intent.setComponent(new ComponentName(context, SwanAppClearCacheErrorActivity.class));
            } else {
                intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static void m(Context context, String str, String str2, String str3, String str4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, str, str2, str3, str4, Integer.valueOf(i2)}) == null) {
            if (h(context, str)) {
                if (z.a(context)) {
                    c.a.r0.a.c2.b.f.e.f(AppRuntime.getAppContext(), c.a.r0.a.h.aiapps_net_error).G();
                    return;
                }
                boolean z = a;
                j(str2, str4, i2);
            } else if (z.a(context)) {
                k(context, str3, str4);
            } else {
                boolean z2 = a;
                j(str2, str4, i2);
            }
        }
    }
}
