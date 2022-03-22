package c.a.n0.q.i.i.g;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class c<T> implements c.a.n0.q.e.e<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final c.a.n0.q.o.a f9164c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.q.e.e<T> a;

    /* renamed from: b  reason: collision with root package name */
    public int f9165b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-758518255, "Lc/a/n0/q/i/i/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-758518255, "Lc/a/n0/q/i/i/g/c;");
                return;
            }
        }
        f9164c = c.a.n0.q.o.a.e();
    }

    public c(c.a.n0.q.e.e<T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9165b = 0;
        this.a = eVar;
    }

    @Override // c.a.n0.q.e.e
    public void a(T t) {
        c.a.n0.q.e.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || (eVar = this.a) == null) {
            return;
        }
        try {
            eVar.a(t);
        } catch (Exception e2) {
            f9164c.g("PMSDownStreamCallbackGuard", "#onDownloadProgress 错误", e2);
        }
    }

    @Override // c.a.n0.q.e.e
    public void c(T t) {
        c.a.n0.q.e.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || (eVar = this.a) == null) {
            return;
        }
        try {
            eVar.c(t);
        } catch (Exception e2) {
            f9164c.g("PMSDownStreamCallbackGuard", "#onDownloadStart 错误", e2);
        }
    }

    @Override // c.a.n0.q.e.e
    public String d(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            c.a.n0.q.e.e<T> eVar = this.a;
            String d2 = eVar != null ? eVar.d(t) : null;
            if (d2 == null) {
                try {
                    return c.a.n0.q.o.e.d(AppRuntime.getAppContext()).getAbsolutePath();
                } catch (Exception e2) {
                    f9164c.g("PMSDownStreamCallbackGuard", "#getDownloadPath getPmsDir出错", e2);
                    return d2;
                }
            }
            return d2;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.n0.q.e.e
    public void e(T t, c.a.n0.q.h.b bVar) {
        c.a.n0.q.e.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, t, bVar) == null) || (eVar = this.a) == null) {
            return;
        }
        try {
            eVar.e(t, bVar);
        } catch (Exception e2) {
            f9164c.g("PMSDownStreamCallbackGuard", "#onDownloadError 错误", e2);
        }
    }

    @Override // c.a.n0.q.e.e
    public void f(T t) {
        c.a.n0.q.e.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || (eVar = this.a) == null) {
            return;
        }
        try {
            eVar.f(t);
        } catch (Exception e2) {
            f9164c.g("PMSDownStreamCallbackGuard", "#onDownloading 错误", e2);
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.n0.q.e.e
    public c.a.n0.q.h.b h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{t, file, Long.valueOf(j), readableByteChannel})) == null) {
            c.a.n0.q.e.e<T> eVar = this.a;
            if (eVar != null) {
                return eVar.h(t, file, j, readableByteChannel);
            }
            return new c.a.n0.q.h.b(2302, "业务层默认不处理下载流");
        }
        return (c.a.n0.q.h.b) invokeCommon.objValue;
    }

    @Override // c.a.n0.q.e.e
    public void i(T t) {
        c.a.n0.q.e.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, t) == null) || (eVar = this.a) == null) {
            return;
        }
        try {
            eVar.i(t);
        } catch (Exception e2) {
            f9164c.g("PMSDownStreamCallbackGuard", "#onDownloadFinish 错误", e2);
        }
    }

    @Override // c.a.n0.q.e.e
    public void j(T t) {
        c.a.n0.q.e.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) || (eVar = this.a) == null) {
            return;
        }
        try {
            eVar.j(t);
        } catch (Exception e2) {
            f9164c.g("PMSDownStreamCallbackGuard", "#onDownloadStop 错误", e2);
        }
    }

    @Override // c.a.n0.q.e.e
    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.k() : (Map) invokeV.objValue;
    }

    @Override // c.a.n0.q.e.g
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bundle, set)) == null) {
            c.a.n0.q.e.e<T> eVar = this.a;
            return eVar == null ? new Bundle() : eVar.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }
}
