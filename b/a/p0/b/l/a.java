package b.a.p0.b.l;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.v2.q0;
import b.a.p0.b.l.l;
import b.a.p0.b.m.a;
import b.a.p0.b.n.b;
import b.a.p0.b.q.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9328a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.b.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0484a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.m.a f9329a;

        public C0484a(b.a.p0.a.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9329a = aVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) || this.f9329a == null) {
                return;
            }
            if (!delegateResult.isOk()) {
                this.f9329a.onResult(-1);
                return;
            }
            this.f9329a.onResult(delegateResult.mResult.getInt("result_code", -1));
        }
    }

    /* loaded from: classes.dex */
    public static class b extends b.a.p0.a.v1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.c f9330c;

        public b(b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9330c = cVar;
        }

        @Override // b.a.p0.a.v1.a.b.c.b, b.a.p0.a.v1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v1.a.b.c.b, b.a.p0.a.v1.a.b.c.c, b.a.p0.a.v1.a.b.c.a
        public void onEvent(@NonNull b.a.p0.a.v1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                boolean unused = a.f9328a;
                String str = null;
                if (bVar.a() != null) {
                    if (a.f9328a) {
                        String str2 = "get openBduss : result " + bVar.a();
                    }
                    str = bVar.a().getString("result");
                } else {
                    boolean unused2 = a.f9328a;
                }
                this.f9330c.a(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends b.a.p0.a.v1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f9331c;

        public c(b.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9331c = bVar;
        }

        @Override // b.a.p0.a.v1.a.b.c.b, b.a.p0.a.v1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 30000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v1.a.b.c.b, b.a.p0.a.v1.a.b.c.c, b.a.p0.a.v1.a.b.c.a
        public void onEvent(@NonNull b.a.p0.a.v1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                boolean unused = a.f9328a;
                Bundle bundle = null;
                if (bVar.a() != null) {
                    if (a.f9328a) {
                        String str = "get stoken : result " + bVar.a();
                    }
                    bundle = bVar.a().getBundle("key_result_stokent");
                } else {
                    boolean unused2 = a.f9328a;
                }
                this.f9331c.onCallback(bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f9332a;

        public d(b.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9332a = bVar;
        }

        @Override // b.a.p0.b.l.l.a
        public void a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
                this.f9332a.onCallback(null);
            }
        }

        @Override // b.a.p0.b.l.l.a
        public void b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                if (lVar.f9345a != 0 || lVar.f9346b == null) {
                    this.f9332a.onCallback(null);
                }
                Bundle bundle = new Bundle();
                for (Map.Entry<String, String> entry : lVar.f9346b.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        bundle.putString(key, entry.getValue());
                    }
                }
                this.f9332a.onCallback(bundle);
            }
        }

        @Override // b.a.p0.b.l.l.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // b.a.p0.b.l.l.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n.a.b f9333a;

        public e(b.a.p0.a.n.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9333a = bVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                String string = delegateResult.mResult.getString("address_info");
                if (TextUtils.isEmpty(string)) {
                    if (b.a.p0.a.k.f6397a) {
                        delegateResult.mResult.getString("errorMsg");
                    }
                    this.f9333a.a(0);
                    return;
                }
                boolean z = b.a.p0.a.k.f6397a;
                this.f9333a.b(b.a.p0.a.v2.w.d(string));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f9334a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f9335b;

        public f(Bundle bundle, b.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9334a = bundle;
            this.f9335b = bVar;
        }

        @Override // b.a.p0.b.l.b0
        public void a(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zVar) == null) {
                if (a.f9328a) {
                    String str = "callbackkey=" + zVar.f9361a;
                }
                this.f9334a.putString("callbackKey", zVar.f9361a);
                b.a.p0.a.v2.e1.b bVar = this.f9335b;
                if (bVar != null) {
                    bVar.onCallback(this.f9334a);
                }
            }
        }

        @Override // b.a.p0.b.l.b0
        public void onFailure(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (a.f9328a) {
                    String str2 = "onFailure=" + str;
                }
                this.f9334a.putString("failMsg", str);
                b.a.p0.a.v2.e1.b bVar = this.f9335b;
                if (bVar != null) {
                    bVar.onCallback(this.f9334a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f9336a;

        public g(b.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9336a = bVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                Bundle bundle = delegateResult.mResult;
                b.a.p0.a.v2.e1.b bVar = this.f9336a;
                if (bVar != null) {
                    bVar.onCallback(b.a.p0.a.v2.v.d(bundle, "result"));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f9337e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9338f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9339g;

        public h(Activity activity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9337e = activity;
            this.f9338f = str;
            this.f9339g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.P(this.f9337e, this.f9338f, this.f9339g);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f9340e;

        public i(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9340e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                a.N(this.f9340e, true, null, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1036901870, "Lb/a/p0/b/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1036901870, "Lb/a/p0/b/l/a;");
                return;
            }
        }
        f9328a = b.a.p0.a.k.f6397a;
    }

    public static a0 A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return v.a().d(context);
            }
            return null;
        }
        return (a0) invokeL.objValue;
    }

    public static a0 B(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, b.a.p0.b.l.i.class, null);
            if (callOnMainWithContentProvider.isOk()) {
                a0 a0Var = new a0();
                a0Var.f9341a = callOnMainWithContentProvider.mResult.getString("NICK_NAME", "");
                a0Var.f9342b = callOnMainWithContentProvider.mResult.getString("AVATAR_URL", "");
                return a0Var;
            }
            return null;
        }
        return (a0) invokeL.objValue;
    }

    public static b0 C(b.a.p0.a.v2.e1.b<Bundle> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) ? new f(new Bundle(), bVar) : (b0) invokeL.objValue;
    }

    public static String D(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? v.a().e(context) : (String) invokeL.objValue;
    }

    public static void E(Activity activity, JSONObject jSONObject) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, activity, jSONObject) == null) || (c2 = b.a.p0.a.e2.c.d.c(jSONObject)) == null || activity == null) {
            return;
        }
        int optInt = c2.optInt("errno", 10001);
        String optString = c2.optString("tipmsg");
        if (optInt == 401 || optInt == 400701) {
            JSONObject optJSONObject = c2.optJSONObject("tipoption");
            String optString2 = optJSONObject != null ? optJSONObject.optString("title") : null;
            if (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString)) {
                return;
            }
            q0.b0(new h(activity, optString2, optString));
        }
    }

    public static boolean F(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return v.a().h(context);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean G(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return F(context);
            }
            return H(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean H(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, j.class, null);
            return callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false);
        }
        return invokeL.booleanValue;
    }

    public static void I(Activity activity, String str, b.a.p0.a.v2.e1.b<Bundle> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, activity, str, bVar) == null) {
            v.a().m(activity, "baidu_mini_programs_" + str, i(activity), C(bVar));
        }
    }

    public static void J(Activity activity, boolean z, String str, b.a.p0.a.v2.e1.b<Bundle> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{activity, Boolean.valueOf(z), str, bVar}) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isRealName", z);
            bundle.putString("swanAppId", str);
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, b.a.p0.b.l.b.class, bundle, new g(bVar));
        }
    }

    public static void K(Activity activity, String str, String str2, b.a.p0.a.v2.e1.b<Bundle> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65547, null, activity, str, str2, bVar) == null) {
            boolean equals = TextUtils.equals(str, "1");
            if (!ProcessUtils.isMainProcess()) {
                J(activity, equals, str2, bVar);
            } else if (equals) {
                I(activity, str2, bVar);
            } else {
                L(activity, str2, bVar);
            }
        }
    }

    public static void L(Activity activity, String str, b.a.p0.a.v2.e1.b<Bundle> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, activity, str, bVar) == null) {
            v.a().f(activity, "baidu_mini_programs_" + str, i(activity), C(bVar));
        }
    }

    public static void M(Context context, Bundle bundle, b.a.p0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, bundle, aVar) == null) {
            if (!ProcessUtils.isMainProcess()) {
                aVar.onResult(-1);
            } else {
                v.a().c(context, bundle, aVar);
            }
        }
    }

    public static void N(Activity activity, boolean z, Bundle bundle, b.a.p0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{activity, Boolean.valueOf(z), bundle, aVar}) == null) {
            if (ProcessUtils.isMainProcess()) {
                M(activity, bundle, aVar);
            } else {
                O(activity, z, bundle, aVar);
            }
        }
    }

    public static void O(Activity activity, boolean z, Bundle bundle, b.a.p0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{activity, Boolean.valueOf(z), bundle, aVar}) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("key_login_force", z);
            bundle2.putBundle("key_login_params", bundle);
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, k.class, bundle2, new C0484a(aVar));
        }
    }

    public static void P(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, activity, str, str2) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(activity);
            aVar.V(str);
            aVar.x(str2);
            aVar.n(new b.a.p0.a.w2.h.a());
            aVar.m(true);
            aVar.P(activity.getString(b.a.p0.b.h.aiapps_login_immediately), new i(activity));
            aVar.C(activity.getString(b.a.p0.b.h.aiapps_login_refuse), null);
            aVar.X();
        }
    }

    public static void Q(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, context, gVar, str) == null) {
            v.a().k(context, gVar, str);
        }
    }

    public static void c(b.a.p0.a.m.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, null, cVar) == null) || cVar == null) {
            return;
        }
        v.a().i(cVar);
    }

    public static void d(Context context, a.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65557, null, context, dVar) == null) && ProcessUtils.isMainProcess()) {
            v.a().j(context, dVar);
        }
    }

    public static void e(Activity activity, b.a.p0.a.n.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, activity, bVar) == null) {
            DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, b.a.p0.b.m.a.class, new e(bVar));
        }
    }

    public static void f(Context context, a.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65559, null, context, dVar) == null) && ProcessUtils.isMainProcess()) {
            v.a().g(context, dVar);
        }
    }

    public static a0 g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return A(context);
            }
            return B(context);
        }
        return (a0) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                String bduss = v.a().getBduss(context);
                return TextUtils.isEmpty(bduss) ? "" : bduss;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return h(context);
            }
            return j(context);
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, b.a.p0.b.l.c.class, null);
            return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) ? !ProcessUtils.isMainProcess() ? "" : v.a().l(context) : (String) invokeL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return k(context);
            }
            return m(context);
        }
        return (String) invokeL.objValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, b.a.p0.b.l.d.class, null);
            return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
        }
        return (String) invokeL.objValue;
    }

    public static void n(String str, ArrayList<String> arrayList, b.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65567, null, str, arrayList, cVar) == null) && ProcessUtils.isMainProcess()) {
            v.a().o(str, arrayList, cVar);
        }
    }

    public static void o(Context context, String str, ArrayList<String> arrayList, b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65568, null, context, str, arrayList, cVar) == null) {
            if (ProcessUtils.isMainProcess()) {
                n(str, arrayList, cVar);
            } else {
                p(context, str, arrayList, cVar);
            }
        }
    }

    public static void p(Context context, String str, ArrayList<String> arrayList, b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65569, null, context, str, arrayList, cVar) == null) {
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 == null) {
                cVar.a(null);
                return;
            }
            b.a.p0.a.v1.c.e.a z = i2.z();
            if (z == null) {
                cVar.a(null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_result_client_id", str);
            bundle.putStringArrayList("key_param_tpl_list", arrayList);
            z.L(bundle, b.a.p0.b.l.e.class, new b(cVar));
        }
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) ? !ProcessUtils.isMainProcess() ? "" : v.a().a(context) : (String) invokeL.objValue;
    }

    public static String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return q(context);
            }
            return s(context);
        }
        return (String) invokeL.objValue;
    }

    public static String s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, b.a.p0.b.l.f.class, null);
            return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
        }
        return (String) invokeL.objValue;
    }

    public static void t(Context context, b.a.p0.a.v2.e1.b<Bundle> bVar, @Nullable String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65573, null, context, bVar, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                u(context, bVar, strArr);
            } else {
                w(bVar, strArr);
            }
        }
    }

    public static void u(Context context, b.a.p0.a.v2.e1.b<Bundle> bVar, @Nullable String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65574, null, context, bVar, strArr) == null) {
            if (ProcessUtils.isMainProcess()) {
                String h2 = h(context);
                if (TextUtils.isEmpty(h2)) {
                    bVar.onCallback(null);
                    return;
                } else {
                    v(new d(bVar), h2, strArr == null ? Collections.emptyList() : Arrays.asList(strArr));
                    return;
                }
            }
            throw new IllegalStateException("must call in MainProcess");
        }
    }

    public static void v(l.a aVar, String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65575, null, aVar, str, list) == null) {
            v.a().p(aVar, str, list);
        }
    }

    public static void w(b.a.p0.a.v2.e1.b<Bundle> bVar, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65576, null, bVar, strArr) == null) {
            if (strArr != null && strArr.length >= 1) {
                b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
                if (i2 == null) {
                    bVar.onCallback(null);
                    return;
                }
                b.a.p0.a.v1.c.e.a z = i2.z();
                if (z == null) {
                    bVar.onCallback(null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("key_param_tpl_list", strArr);
                z.L(bundle, b.a.p0.b.l.g.class, new c(bVar));
                return;
            }
            bVar.onCallback(null);
        }
    }

    public static String x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) ? !ProcessUtils.isMainProcess() ? "" : v.a().b(context) : (String) invokeL.objValue;
    }

    public static String y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return x(context);
            }
            return z(context);
        }
        return (String) invokeL.objValue;
    }

    public static String z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) {
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, b.a.p0.b.l.h.class, null);
            return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
        }
        return (String) invokeL.objValue;
    }
}
