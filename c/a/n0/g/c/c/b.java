package c.a.n0.g.c.c;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.k;
import c.a.n0.a.v2.w;
import com.alipay.sdk.util.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallPluginDelegateActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c.a.n0.g.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f10569c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f10570d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10571a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10572b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.u0.b f10573c;

        public a(b bVar, String str, String str2, c.a.n0.a.u0.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10571a = str;
            this.f10572b = str2;
            this.f10573c = bVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                if (b.f10569c) {
                    String str = "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",packageName：" + this.f10571a + ",result:" + delegateResult.mResult;
                }
                String string = delegateResult.mResult.getString("packageName");
                if (!TextUtils.isEmpty(this.f10571a) && !TextUtils.equals(this.f10571a, string)) {
                    if (c.a.n0.g.c.e.a.h(AppRuntime.getAppContext(), this.f10571a)) {
                        if (!TextUtils.isEmpty(this.f10572b)) {
                            c.a.n0.g.c.i.c.a(this.f10571a, this.f10572b, "success", "", null);
                        }
                        this.f10573c.a(new JSONObject());
                        return;
                    }
                    if (!TextUtils.isEmpty(this.f10572b)) {
                        c.a.n0.g.c.i.c.a(this.f10571a, this.f10572b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "", null);
                    }
                    this.f10573c.onFail(31003, "apk install cancel");
                } else if (!delegateResult.isOk()) {
                    if (!TextUtils.isEmpty(this.f10572b)) {
                        c.a.n0.g.c.i.c.a(this.f10571a, this.f10572b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "", null);
                    }
                    this.f10573c.onFail(31003, "apk install cancel");
                } else {
                    c.a.n0.g.c.a.n().t(this.f10571a);
                    b.g(delegateResult.mResult, this.f10573c);
                }
            }
        }
    }

    /* renamed from: c.a.n0.g.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0533b extends c.a.n0.a.v1.a.b.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f10574c;

        /* renamed from: d  reason: collision with root package name */
        public String f10575d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.n0.a.u0.b f10576e;

        public C0533b(String str, String str2, c.a.n0.a.u0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10575d = str;
            this.f10574c = str2;
            this.f10576e = bVar;
        }

        @Override // c.a.n0.a.v1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // c.a.n0.a.v1.a.b.c.a
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void e() {
            c.a.n0.a.u0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f10576e) == null) {
                return;
            }
            bVar.onFail(31018, "download process is killed");
            b.e(this.f10575d, this.f10574c, 31018);
            this.f10576e = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v1.a.b.c.c, c.a.n0.a.v1.a.b.c.a
        public void onEvent(@NonNull c.a.n0.a.v1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
                Bundle a2 = bVar.a();
                c.a.n0.a.u0.b bVar2 = this.f10576e;
                if (bVar2 == null) {
                    return;
                }
                if (a2 != null) {
                    b.g(a2, bVar2);
                } else {
                    bVar2.onFail(1001, "");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<C0533b> f10577e;

        public c(C0533b c0533b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0533b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10577e = new WeakReference<>(c0533b);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = b.f10569c;
                if (this.f10577e.get() != null) {
                    this.f10577e.get().e();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(642708704, "Lc/a/n0/g/c/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(642708704, "Lc/a/n0/g/c/c/b;");
                return;
            }
        }
        f10569c = k.f6803a;
        f10570d = Executors.newSingleThreadExecutor();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("appDownloadManager");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void e(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, null, str, str2, i2) == null) {
            c.a.n0.g.c.i.c.a(str, str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(i2), null);
        }
    }

    public static void g(@NonNull Bundle bundle, @NonNull c.a.n0.a.u0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, bundle, bVar) == null) {
            String string = bundle.getString("functionType");
            if (string == null) {
                bVar.onFail(1001, "");
                return;
            }
            String string2 = bundle.getString("resultData", "");
            int i2 = bundle.getInt(i.f35879a, 1001);
            if (f10569c) {
                String str = "handleResult:function = " + string + ",result = " + string2;
            }
            char c2 = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -1013362275) {
                if (hashCode == -530890460 && string.equals("onSuccess")) {
                    c2 = 0;
                }
            } else if (string.equals("onFail")) {
                c2 = 1;
            }
            if (c2 == 0) {
                bVar.a(w.d(string2));
            } else if (c2 != 1) {
            } else {
                bVar.onFail(i2, string2);
            }
        }
    }

    @Override // c.a.n0.g.f.a
    public c.a.n0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull c.a.n0.a.u0.b bVar) {
        InterceptResult invokeLL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (f10569c) {
                String str3 = "handle: " + jSONObject;
            }
            String optString = jSONObject.optString(AppDownloadNetworkStateReceiver.KEY_OPERATION);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                str = optJSONObject.optString("packageName");
                str2 = optJSONObject.optString("installSource");
            } else {
                str = null;
                str2 = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, optString);
            bundle.putString("data", optJSONObject == null ? "" : optJSONObject.toString());
            bundle.putString("ubc_params", new c.a.n0.g.c.i.a().a());
            if (TextUtils.equals(optString, "installApp")) {
                if (!TextUtils.isEmpty(str2)) {
                    c.a.n0.g.c.i.c.a(str, str2, "start", "", null);
                }
                f(bundle, str, str2, bVar);
                return null;
            }
            c.a.n0.a.v1.c.e.a z = c.a.n0.a.a2.d.g().z();
            if (z != null) {
                C0533b c0533b = new C0533b(str, optString, bVar);
                z.L(bundle, c.a.n0.g.c.d.e.class, c0533b);
                z.J(new c(c0533b));
            }
            return null;
        }
        return (c.a.n0.a.u.h.b) invokeLL.objValue;
    }

    public final void f(@NonNull Bundle bundle, @Nullable String str, String str2, @NonNull c.a.n0.a.u0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, str, str2, bVar) == null) {
            SwanAppActivity x = c.a.n0.a.a2.d.g().x();
            if (x == null) {
                bVar.onFail(1001, "");
            } else if (c.a.n0.g.c.e.a.h(AppRuntime.getAppContext(), str)) {
                bVar.a(new JSONObject());
            } else {
                boolean z = f10569c;
                DelegateUtils.callOnMainWithActivity(x, InstallPluginDelegateActivity.class, c.a.n0.g.c.e.b.class, bundle, new a(this, str, str2, bVar));
            }
        }
    }
}
