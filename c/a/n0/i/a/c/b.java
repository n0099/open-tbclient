package c.a.n0.i.a.c;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.p2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.SwanAppActivity;
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
/* loaded from: classes2.dex */
public class b extends c.a.n0.i.d.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8495c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f8496d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8497b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.k0.b f8498c;

        public a(b bVar, String str, String str2, c.a.n0.a.k0.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f8497b = str2;
            this.f8498c = bVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                if (b.f8495c) {
                    Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",packageName：" + this.a + ",result:" + delegateResult.mResult);
                }
                String string = delegateResult.mResult.getString("packageName");
                if (!TextUtils.isEmpty(this.a) && !TextUtils.equals(this.a, string)) {
                    if (c.a.n0.i.a.e.a.h(AppRuntime.getAppContext(), this.a)) {
                        if (!TextUtils.isEmpty(this.f8497b)) {
                            c.a.n0.i.a.i.c.a(this.a, this.f8497b, "success", "", null);
                        }
                        this.f8498c.a(new JSONObject());
                        return;
                    }
                    if (!TextUtils.isEmpty(this.f8497b)) {
                        c.a.n0.i.a.i.c.a(this.a, this.f8497b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "", null);
                    }
                    this.f8498c.onFail(31003, "apk install cancel");
                } else if (!delegateResult.isOk()) {
                    if (!TextUtils.isEmpty(this.f8497b)) {
                        c.a.n0.i.a.i.c.a(this.a, this.f8497b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "", null);
                    }
                    this.f8498c.onFail(31003, "apk install cancel");
                } else {
                    c.a.n0.i.a.a.n().t(this.a);
                    b.g(delegateResult.mResult, this.f8498c);
                }
            }
        }
    }

    /* renamed from: c.a.n0.i.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0674b extends c.a.n0.a.o1.a.b.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f8499c;

        /* renamed from: d  reason: collision with root package name */
        public String f8500d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.n0.a.k0.b f8501e;

        public C0674b(String str, String str2, c.a.n0.a.k0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8500d = str;
            this.f8499c = str2;
            this.f8501e = bVar;
        }

        @Override // c.a.n0.a.o1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // c.a.n0.a.o1.a.b.c.a
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void e() {
            c.a.n0.a.k0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f8501e) == null) {
                return;
            }
            bVar.onFail(31018, "download process is killed");
            b.e(this.f8500d, this.f8499c, 31018);
            this.f8501e = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.o1.a.b.c.c, c.a.n0.a.o1.a.b.c.a
        public void onEvent(@NonNull c.a.n0.a.o1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
                Bundle a = bVar.a();
                c.a.n0.a.k0.b bVar2 = this.f8501e;
                if (bVar2 == null) {
                    return;
                }
                if (a != null) {
                    b.g(a, bVar2);
                } else {
                    bVar2.onFail(1001, "");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<C0674b> a;

        public c(C0674b c0674b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0674b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(c0674b);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (b.f8495c) {
                    Log.d("appManagerAction", "onConnectionDown");
                }
                if (this.a.get() != null) {
                    this.a.get().e();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-223896224, "Lc/a/n0/i/a/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-223896224, "Lc/a/n0/i/a/c/b;");
                return;
            }
        }
        f8495c = c.a.n0.a.a.a;
        f8496d = Executors.newSingleThreadExecutor();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("appDownloadManager");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void e(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65541, null, str, str2, i) == null) {
            c.a.n0.i.a.i.c.a(str, str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(i), null);
        }
    }

    public static void g(@NonNull Bundle bundle, @NonNull c.a.n0.a.k0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, bundle, bVar) == null) {
            String string = bundle.getString("functionType");
            if (string == null) {
                bVar.onFail(1001, "");
                return;
            }
            String string2 = bundle.getString("resultData", "");
            int i = bundle.getInt("resultStatus", 1001);
            if (f8495c) {
                Log.d("appManagerAction", "handleResult:function = " + string + ",result = " + string2);
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
                bVar.onFail(i, string2);
            }
        }
    }

    @Override // c.a.n0.i.d.a
    public c.a.n0.a.k.h.b a(@NonNull JSONObject jSONObject, @NonNull c.a.n0.a.k0.b bVar) {
        InterceptResult invokeLL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (f8495c) {
                Log.d("appManagerAction", "handle: " + jSONObject);
            }
            String optString = jSONObject.optString("operation");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                str = optJSONObject.optString("packageName");
                str2 = optJSONObject.optString("installSource");
            } else {
                str = null;
                str2 = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("operation", optString);
            bundle.putString("data", optJSONObject == null ? "" : optJSONObject.toString());
            bundle.putString("ubc_params", new c.a.n0.i.a.i.a().a());
            if (TextUtils.equals(optString, "installApp")) {
                if (!TextUtils.isEmpty(str2)) {
                    c.a.n0.i.a.i.c.a(str, str2, "start", "", null);
                }
                f(bundle, str, str2, bVar);
                return null;
            }
            c.a.n0.a.o1.c.e.a z = c.a.n0.a.t1.d.J().z();
            if (z != null) {
                C0674b c0674b = new C0674b(str, optString, bVar);
                z.W(bundle, c.a.n0.i.a.d.e.class, c0674b);
                z.U(new c(c0674b));
            }
            return null;
        }
        return (c.a.n0.a.k.h.b) invokeLL.objValue;
    }

    public final void f(@NonNull Bundle bundle, @Nullable String str, String str2, @NonNull c.a.n0.a.k0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, str, str2, bVar) == null) {
            SwanAppActivity x = c.a.n0.a.t1.d.J().x();
            if (x == null) {
                bVar.onFail(1001, "");
            } else if (c.a.n0.i.a.e.a.h(AppRuntime.getAppContext(), str)) {
                bVar.a(new JSONObject());
            } else {
                if (f8495c) {
                    Log.d("appManagerAction", "InstallAppDelegation handleInstall");
                }
                DelegateUtils.callOnMainWithActivity(x, InstallPluginDelegateActivity.class, c.a.n0.i.a.e.b.class, bundle, new a(this, str, str2, bVar));
            }
        }
    }
}
