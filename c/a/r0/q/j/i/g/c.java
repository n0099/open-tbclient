package c.a.r0.q.j.i.g;

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
/* loaded from: classes6.dex */
public class c<T> implements c.a.r0.q.f.e<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final c.a.r0.q.p.a f11660g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.q.f.e<T> f11661e;

    /* renamed from: f  reason: collision with root package name */
    public int f11662f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-189319948, "Lc/a/r0/q/j/i/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-189319948, "Lc/a/r0/q/j/i/g/c;");
                return;
            }
        }
        f11660g = c.a.r0.q.p.a.e();
    }

    public c(c.a.r0.q.f.e<T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11662f = 0;
        this.f11661e = eVar;
    }

    @Override // c.a.r0.q.f.e
    public void a(T t) {
        c.a.r0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || (eVar = this.f11661e) == null) {
            return;
        }
        try {
            eVar.a(t);
        } catch (Exception e2) {
            f11660g.g("PMSDownStreamCallbackGuard", "#onDownloadProgress 错误", e2);
        }
    }

    @Override // c.a.r0.q.f.e
    public void c(T t) {
        c.a.r0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || (eVar = this.f11661e) == null) {
            return;
        }
        try {
            eVar.c(t);
        } catch (Exception e2) {
            f11660g.g("PMSDownStreamCallbackGuard", "#onDownloadStart 错误", e2);
        }
    }

    @Override // c.a.r0.q.f.e
    public String d(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            c.a.r0.q.f.e<T> eVar = this.f11661e;
            String d2 = eVar != null ? eVar.d(t) : null;
            if (d2 == null) {
                try {
                    return c.a.r0.q.p.e.d(AppRuntime.getAppContext()).getAbsolutePath();
                } catch (Exception e2) {
                    f11660g.g("PMSDownStreamCallbackGuard", "#getDownloadPath getPmsDir出错", e2);
                    return d2;
                }
            }
            return d2;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.r0.q.f.e
    public void e(T t, c.a.r0.q.i.b bVar) {
        c.a.r0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, t, bVar) == null) || (eVar = this.f11661e) == null) {
            return;
        }
        try {
            eVar.e(t, bVar);
        } catch (Exception e2) {
            f11660g.g("PMSDownStreamCallbackGuard", "#onDownloadError 错误", e2);
        }
    }

    @Override // c.a.r0.q.f.e
    public void f(T t) {
        c.a.r0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || (eVar = this.f11661e) == null) {
            return;
        }
        try {
            eVar.f(t);
        } catch (Exception e2) {
            f11660g.g("PMSDownStreamCallbackGuard", "#onDownloading 错误", e2);
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

    @Override // c.a.r0.q.f.e
    public c.a.r0.q.i.b h(T t, File file, long j2, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{t, file, Long.valueOf(j2), readableByteChannel})) == null) {
            c.a.r0.q.f.e<T> eVar = this.f11661e;
            if (eVar != null) {
                return eVar.h(t, file, j2, readableByteChannel);
            }
            return new c.a.r0.q.i.b(2302, "业务层默认不处理下载流");
        }
        return (c.a.r0.q.i.b) invokeCommon.objValue;
    }

    @Override // c.a.r0.q.f.e
    public void i(T t) {
        c.a.r0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, t) == null) || (eVar = this.f11661e) == null) {
            return;
        }
        try {
            eVar.i(t);
        } catch (Exception e2) {
            f11660g.g("PMSDownStreamCallbackGuard", "#onDownloadFinish 错误", e2);
        }
    }

    @Override // c.a.r0.q.f.e
    public void j(T t) {
        c.a.r0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) || (eVar = this.f11661e) == null) {
            return;
        }
        try {
            eVar.j(t);
        } catch (Exception e2) {
            f11660g.g("PMSDownStreamCallbackGuard", "#onDownloadStop 错误", e2);
        }
    }

    @Override // c.a.r0.q.f.e
    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f11661e.k() : (Map) invokeV.objValue;
    }

    @Override // c.a.r0.q.f.g
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bundle, set)) == null) {
            c.a.r0.q.f.e<T> eVar = this.f11661e;
            return eVar == null ? new Bundle() : eVar.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }
}
