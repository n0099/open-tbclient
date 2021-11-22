package b.a.p0.q.j.i.g;

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
/* loaded from: classes4.dex */
public class c<T> implements b.a.p0.q.f.e<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final b.a.p0.q.p.a f11807g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.q.f.e<T> f11808e;

    /* renamed from: f  reason: collision with root package name */
    public int f11809f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-955823631, "Lb/a/p0/q/j/i/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-955823631, "Lb/a/p0/q/j/i/g/c;");
                return;
            }
        }
        f11807g = b.a.p0.q.p.a.e();
    }

    public c(b.a.p0.q.f.e<T> eVar) {
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
        this.f11809f = 0;
        this.f11808e = eVar;
    }

    @Override // b.a.p0.q.f.e
    public void a(T t) {
        b.a.p0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || (eVar = this.f11808e) == null) {
            return;
        }
        try {
            eVar.a(t);
        } catch (Exception e2) {
            f11807g.g("PMSDownStreamCallbackGuard", "#onDownloadProgress 错误", e2);
        }
    }

    @Override // b.a.p0.q.f.e
    public void c(T t) {
        b.a.p0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || (eVar = this.f11808e) == null) {
            return;
        }
        try {
            eVar.c(t);
        } catch (Exception e2) {
            f11807g.g("PMSDownStreamCallbackGuard", "#onDownloadStart 错误", e2);
        }
    }

    @Override // b.a.p0.q.f.e
    public String d(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            b.a.p0.q.f.e<T> eVar = this.f11808e;
            String d2 = eVar != null ? eVar.d(t) : null;
            if (d2 == null) {
                try {
                    return b.a.p0.q.p.e.d(AppRuntime.getAppContext()).getAbsolutePath();
                } catch (Exception e2) {
                    f11807g.g("PMSDownStreamCallbackGuard", "#getDownloadPath getPmsDir出错", e2);
                    return d2;
                }
            }
            return d2;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.q.f.e
    public void e(T t, b.a.p0.q.i.b bVar) {
        b.a.p0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, t, bVar) == null) || (eVar = this.f11808e) == null) {
            return;
        }
        try {
            eVar.e(t, bVar);
        } catch (Exception e2) {
            f11807g.g("PMSDownStreamCallbackGuard", "#onDownloadError 错误", e2);
        }
    }

    @Override // b.a.p0.q.f.e
    public void f(T t) {
        b.a.p0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || (eVar = this.f11808e) == null) {
            return;
        }
        try {
            eVar.f(t);
        } catch (Exception e2) {
            f11807g.g("PMSDownStreamCallbackGuard", "#onDownloading 错误", e2);
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

    @Override // b.a.p0.q.f.e
    public b.a.p0.q.i.b h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{t, file, Long.valueOf(j), readableByteChannel})) == null) {
            b.a.p0.q.f.e<T> eVar = this.f11808e;
            if (eVar != null) {
                return eVar.h(t, file, j, readableByteChannel);
            }
            return new b.a.p0.q.i.b(2302, "业务层默认不处理下载流");
        }
        return (b.a.p0.q.i.b) invokeCommon.objValue;
    }

    @Override // b.a.p0.q.f.e
    public void i(T t) {
        b.a.p0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, t) == null) || (eVar = this.f11808e) == null) {
            return;
        }
        try {
            eVar.i(t);
        } catch (Exception e2) {
            f11807g.g("PMSDownStreamCallbackGuard", "#onDownloadFinish 错误", e2);
        }
    }

    @Override // b.a.p0.q.f.e
    public void j(T t) {
        b.a.p0.q.f.e<T> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) || (eVar = this.f11808e) == null) {
            return;
        }
        try {
            eVar.j(t);
        } catch (Exception e2) {
            f11807g.g("PMSDownStreamCallbackGuard", "#onDownloadStop 错误", e2);
        }
    }

    @Override // b.a.p0.q.f.e
    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f11808e.k() : (Map) invokeV.objValue;
    }

    @Override // b.a.p0.q.f.g
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bundle, set)) == null) {
            b.a.p0.q.f.e<T> eVar = this.f11808e;
            return eVar == null ? new Bundle() : eVar.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }
}
