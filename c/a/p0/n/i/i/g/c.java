package c.a.p0.n.i.i.g;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
/* loaded from: classes3.dex */
public class c<T> implements c.a.p0.n.f.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.n.f.c<T> f11930e;

    /* renamed from: f  reason: collision with root package name */
    public int f11931f;

    public c(c.a.p0.n.f.c<T> cVar) {
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
        this.f11931f = 0;
        this.f11930e = cVar;
    }

    @Override // c.a.p0.n.f.c
    public void a(T t) {
        c.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || (cVar = this.f11930e) == null) {
            return;
        }
        try {
            cVar.a(t);
        } catch (Exception e2) {
            if (c.a.p0.n.c.f11864a) {
                String str = g() + ": Except onDownloadProgress t=" + t.toString();
                String str2 = g() + ": Except onDownloadProgress e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    @Override // c.a.p0.n.f.c
    public void c(T t) {
        c.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || (cVar = this.f11930e) == null) {
            return;
        }
        try {
            cVar.c(t);
        } catch (Exception e2) {
            if (c.a.p0.n.c.f11864a) {
                String str = g() + ": Except onDownloadStart t=" + t.toString();
                String str2 = g() + ": Except onDownloadStart e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    @Override // c.a.p0.n.f.c
    public String d(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            c.a.p0.n.f.c<T> cVar = this.f11930e;
            String d2 = cVar != null ? cVar.d(t) : null;
            if (c.a.p0.n.c.f11864a) {
                String str = g() + ": getDownloadPath:" + d2;
            }
            if (d2 == null) {
                try {
                    d2 = c.a.p0.n.o.d.c(AppRuntime.getAppContext()).getAbsolutePath();
                } catch (Exception e2) {
                    if (c.a.p0.n.c.f11864a) {
                        String str2 = g() + ": getDownloadPath error: e=" + Log.getStackTraceString(e2);
                        throw e2;
                    }
                }
                if (c.a.p0.n.c.f11864a) {
                    String str3 = g() + ": getDownloadPath failed, using default path:" + d2;
                }
            }
            return d2;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.n.f.c
    public void e(T t, c.a.p0.n.h.a aVar) {
        c.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, t, aVar) == null) || (cVar = this.f11930e) == null) {
            return;
        }
        try {
            cVar.e(t, aVar);
        } catch (Exception e2) {
            if (c.a.p0.n.c.f11864a) {
                String str = g() + ": notify onDownloadError t=" + t.toString();
                String str2 = g() + ": notify onDownloadError e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    @Override // c.a.p0.n.f.c
    public void f(T t) {
        c.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || (cVar = this.f11930e) == null) {
            return;
        }
        try {
            cVar.f(t);
        } catch (Exception e2) {
            if (c.a.p0.n.c.f11864a) {
                String str = g() + ": Except onDownloading t=" + t.toString();
                String str2 = g() + ": Except onDownloading e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c.a.p0.n.c.b().v() : (String) invokeV.objValue;
    }

    @Override // c.a.p0.n.f.c
    public c.a.p0.n.h.a h(T t, File file, long j2, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{t, file, Long.valueOf(j2), readableByteChannel})) == null) {
            c.a.p0.n.f.c<T> cVar = this.f11930e;
            if (cVar != null) {
                return cVar.h(t, file, j2, readableByteChannel);
            }
            return new c.a.p0.n.h.a(2302, "业务层默认不处理下载流");
        }
        return (c.a.p0.n.h.a) invokeCommon.objValue;
    }

    @Override // c.a.p0.n.f.c
    public void i(T t) {
        c.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, t) == null) || (cVar = this.f11930e) == null) {
            return;
        }
        try {
            cVar.i(t);
        } catch (Exception e2) {
            if (c.a.p0.n.c.f11864a) {
                String str = g() + ": Except onDownloadFinish: t=" + t.toString();
                String str2 = g() + ": Except onDownloadFinish: cb=" + this.f11930e;
                String str3 = g() + ": Except onDownloadFinish: e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    @Override // c.a.p0.n.f.c
    public void j(T t) {
        c.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) || (cVar = this.f11930e) == null) {
            return;
        }
        try {
            cVar.j(t);
        } catch (Exception e2) {
            if (c.a.p0.n.c.f11864a) {
                String str = g() + ": Except onDownloadStop t=" + t.toString();
                String str2 = g() + ": Except onDownloadStop e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    @Override // c.a.p0.n.f.c
    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f11930e.k() : (Map) invokeV.objValue;
    }

    @Override // c.a.p0.n.f.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bundle, set)) == null) {
            c.a.p0.n.f.c<T> cVar = this.f11930e;
            return cVar == null ? new Bundle() : cVar.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }
}
