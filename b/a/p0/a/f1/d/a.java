package b.a.p0.a.f1.d;

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
import b.a.p0.a.e0.d;
import b.a.p0.a.g1.f;
import b.a.p0.a.k;
import b.a.p0.a.r1.h;
import b.a.p0.a.v1.c.f.e;
import b.a.p0.a.v2.l;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.r;
import b.a.p0.a.v2.z;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5038a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5039b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f5040c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.f1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0178a implements b.a.p0.a.v1.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f5041a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Set f5042b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5043c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5044d;

        public C0178a(int i2, Set set, String str, String str2) {
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
            this.f5041a = i2;
            this.f5042b = set;
            this.f5043c = str;
            this.f5044d = str2;
        }

        @Override // b.a.p0.a.v1.c.f.a
        public void a(String str, b.a.p0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar.f8519f.index == this.f5041a && this.f5042b.contains(str)) {
                e.k().h(this);
                a.h(this.f5043c, this.f5044d);
            }
        }

        @Override // b.a.p0.a.v1.c.f.a
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.h(this.f5043c, this.f5044d);
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
                boolean unused = a.f5039b = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b.a.p0.a.f1.d.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0179a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bundle f5045e;

            public RunnableC0179a(c cVar, Bundle bundle) {
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
                this.f5045e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a.i(this.f5045e.getString("arg_title"), this.f5045e.getString("arg_message"), this.f5045e.getInt("arg_match_target_down", SwanAppProcessInfo.UNKNOWN.index));
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
                    q0.b0(new RunnableC0179a(this, bundle));
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-149064749, "Lb/a/p0/a/f1/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-149064749, "Lb/a/p0/a/f1/d/a;");
                return;
            }
        }
        f5038a = k.f6397a;
        f5039b = false;
        f5040c = TimeUnit.SECONDS.toMillis(1L);
    }

    public static void d(Context context, @NonNull b.a.p0.a.q2.a aVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, aVar, i2, str) == null) {
            e(context, aVar, i2, str, null);
        }
    }

    public static void e(Context context, @NonNull b.a.p0.a.q2.a aVar, int i2, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, aVar, Integer.valueOf(i2), str, bundle}) == null) {
            h.k(aVar);
            f(context, aVar, i2, str, false, bundle);
        }
    }

    public static void f(Context context, @NonNull b.a.p0.a.q2.a aVar, int i2, String str, boolean z, Bundle bundle) {
        File a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, aVar, Integer.valueOf(i2), str, Boolean.valueOf(z), bundle}) == null) || context == null) {
            return;
        }
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            d.h("LaunchError", "launch activity closed, ignore launch error");
            return;
        }
        d.h("LaunchError", "handleLaunchError errCode: " + aVar.toString());
        String i3 = b.a.p0.a.m2.b.i(f.T().L(), i2);
        long g2 = aVar.g();
        String q = aVar.q();
        boolean z2 = 1020 == g2 && !TextUtils.isEmpty(q);
        String a3 = z2 ? q : b.a.p0.n.j.i.f.b().a(g2);
        String format = String.format(context.getResources().getString(b.a.p0.a.h.aiapps_open_failed_detail_format), q0.D(), i3, String.valueOf(aVar.a()));
        if (!b.a.p0.a.c1.a.O().a(context, str, aVar)) {
            if (i2 == 0) {
                String str2 = g(context, str) ? SwanAppErrorActivity.TYPE_NETWORK_ERROR : SwanAppErrorActivity.TYPE_NORMAL;
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(b.a.p0.a.a2.d.g().r().K(), a3, format);
                forbiddenInfo.enableSlidingFlag = -1;
                k(context, str2, bundle, forbiddenInfo);
            } else if (i2 == 1) {
                l(context, str, a3, z2 ? q : b.a.p0.n.j.i.f.b().c(g2), format, (z ? SwanAppProcessInfo.current() : SwanAppProcessInfo.UNKNOWN).index);
            }
        }
        StringBuilder sb = new StringBuilder();
        String b2 = b.a.p0.a.v2.k.b(b.a.p0.a.v2.k.a(), "yyyy-MM-dd HH:mm:ss");
        if (!TextUtils.isEmpty(str)) {
            sb.append(b2);
            sb.append(": ");
            sb.append(str);
            sb.append(Part.CRLF);
        }
        sb.append(b2);
        sb.append(": ");
        sb.append(format);
        sb.append(Part.CRLF);
        r.c(sb.toString(), false);
        if (k.f6397a) {
            String y = q0.y();
            if (TextUtils.isEmpty(y) || (a2 = l.a()) == null) {
                return;
            }
            File file = new File(a2.getPath(), "error_dialog_info.txt");
            b.a.p0.t.d.i(file);
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(format)) {
                sb2.append(format);
                sb2.append(StringUtils.LF);
            }
            sb2.append(y);
            sb2.append(StringUtils.LF);
            b.a.p0.t.d.M(sb2.toString(), file);
        }
    }

    public static boolean g(@NonNull Context context, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? (TextUtils.isEmpty(str) || SwanAppNetworkUtils.i(context) || b.a.p0.a.f1.h.a.d(str)) ? false : true : invokeLL.booleanValue;
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) || f5039b) {
            return;
        }
        BaseActivityDialog.e newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.C(str);
        newBuilder.y(new b());
        newBuilder.v(str2);
        newBuilder.z(b.a.p0.a.h.aiapps_confirm_text, null);
        newBuilder.D();
        f5039b = true;
    }

    public static void i(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65545, null, str, str2, i2) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            if (!ProcessUtils.isMainProcess()) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_title", str);
                bundle.putString("arg_message", str2);
                bundle.putInt("arg_match_target_down", i2);
                b.a.p0.a.v1.b.d.b(c.class, bundle);
                return;
            }
            if (f5038a) {
                String str3 = "show normal err dialog, isShowing=" + f5039b;
            }
            if (!SwanAppProcessInfo.checkProcessId(i2)) {
                h(str, str2);
                return;
            }
            e.k().c(new C0178a(i2, Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline"), str, str2), f5040c);
        }
    }

    public static void j(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, context, str, str2) == null) {
            String format = String.format(context.getResources().getString(b.a.p0.a.h.swanapp_launch_err_toast_format), str, str2);
            if (f5038a) {
                String str3 = "show normal err toast: " + format;
            }
            b.a.p0.a.z1.b.f.e g2 = b.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), format);
            g2.p(Integer.MAX_VALUE);
            g2.E();
        }
    }

    public static void k(Context context, String str, Bundle bundle, ForbiddenInfo forbiddenInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65547, null, context, str, bundle, forbiddenInfo) == null) {
            Intent intent = new Intent();
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            int g2 = b.a.p0.a.k1.a.g();
            int h2 = b.a.p0.a.k1.a.h(context);
            intent.putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, str);
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_FORBIDDEN_INFO, forbiddenInfo);
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_MENU_NOTICE_COUNT, g2);
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_MENU_PRIVACY_COUNT, h2);
            intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static void l(Context context, String str, String str2, String str3, String str4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, str, str2, str3, str4, Integer.valueOf(i2)}) == null) {
            if (g(context, str)) {
                if (z.a(context)) {
                    b.a.p0.a.z1.b.f.e.f(AppRuntime.getAppContext(), b.a.p0.a.h.aiapps_net_error).F();
                    return;
                }
                boolean z = f5038a;
                i(str2, str4, i2);
            } else if (z.a(context)) {
                j(context, str3, str4);
            } else {
                boolean z2 = f5038a;
                i(str2, str4, i2);
            }
        }
    }
}
