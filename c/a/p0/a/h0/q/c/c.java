package c.a.p0.a.h0.q.c;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.k;
import c.a.p0.a.o2.g.g;
import c.a.p0.a.y1.b.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c implements c.a.p0.a.h0.q.c.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5952b;
    public transient /* synthetic */ FieldHolder $fh;
    public final g a;

    /* loaded from: classes.dex */
    public static class a extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public static boolean a;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                if (!a && ProcessUtils.isMainProcess()) {
                    a = true;
                    new g("swan_prelink_by_preload_recorder").clear().apply();
                    boolean unused = c.f5952b;
                }
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1090070098, "Lc/a/p0/a/h0/q/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1090070098, "Lc/a/p0/a/h0/q/c/c;");
                return;
            }
        }
        f5952b = k.a;
    }

    public c() {
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
        this.a = new g("swan_prelink_by_preload_recorder");
        d();
    }

    @Override // c.a.p0.a.h0.q.c.a
    public b a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            if (f5952b) {
                String str3 = "get record : appId-" + str + ", url-" + str2;
            }
            String string = this.a.getString(e(str, str2), "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            b g2 = g(string, str, str2);
            if (f5952b) {
                String str4 = "find record - " + string;
            }
            return g2;
        }
        return (b) invokeLL.objValue;
    }

    @Override // c.a.p0.a.h0.q.c.a
    public void b(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, z) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (f5952b) {
            String str3 = "record : appId-" + str + ", url-" + str2;
        }
        String e2 = e(str, str2);
        String f2 = f(str, str2);
        if (TextUtils.isEmpty(this.a.getString(e2, "")) || z) {
            this.a.putString(e2, f2);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e.c(a.class, null);
        }
    }

    public final String e(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            String str3 = str + "_##_" + str2.hashCode();
            if (f5952b) {
                String str4 = "generateKey - " + str3;
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public final String f(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            String str3 = ProcessUtils.getCurProcessName() + "_##_" + System.currentTimeMillis();
            if (f5952b) {
                String str4 = "generateValue - " + str3;
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public final b g(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, str3)) == null) {
            String[] split = str.split("_##_");
            if (split == null || split.length < 2) {
                return null;
            }
            b bVar = new b();
            bVar.a = split[0];
            bVar.f5951b = h(split[1]);
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public final long h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            try {
                return Long.parseLong(str);
            } catch (Exception e2) {
                if (f5952b) {
                    e2.printStackTrace();
                }
                return 0L;
            }
        }
        return invokeL.longValue;
    }
}
