package b.a.p0.n.i.i.g;

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
/* loaded from: classes4.dex */
public class c<T> implements b.a.p0.n.f.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.n.f.c<T> f11112e;

    /* renamed from: f  reason: collision with root package name */
    public int f11113f;

    public c(b.a.p0.n.f.c<T> cVar) {
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
        this.f11113f = 0;
        this.f11112e = cVar;
    }

    @Override // b.a.p0.n.f.c
    public void a(T t) {
        b.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || (cVar = this.f11112e) == null) {
            return;
        }
        try {
            cVar.a(t);
        } catch (Exception e2) {
            if (b.a.p0.n.c.f11048a) {
                String str = g() + ": Except onDownloadProgress t=" + t.toString();
                String str2 = g() + ": Except onDownloadProgress e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    @Override // b.a.p0.n.f.c
    public void c(T t) {
        b.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || (cVar = this.f11112e) == null) {
            return;
        }
        try {
            cVar.c(t);
        } catch (Exception e2) {
            if (b.a.p0.n.c.f11048a) {
                String str = g() + ": Except onDownloadStart t=" + t.toString();
                String str2 = g() + ": Except onDownloadStart e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    @Override // b.a.p0.n.f.c
    public String d(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            b.a.p0.n.f.c<T> cVar = this.f11112e;
            String d2 = cVar != null ? cVar.d(t) : null;
            if (b.a.p0.n.c.f11048a) {
                String str = g() + ": getDownloadPath:" + d2;
            }
            if (d2 == null) {
                try {
                    d2 = b.a.p0.n.o.d.c(AppRuntime.getAppContext()).getAbsolutePath();
                } catch (Exception e2) {
                    if (b.a.p0.n.c.f11048a) {
                        String str2 = g() + ": getDownloadPath error: e=" + Log.getStackTraceString(e2);
                        throw e2;
                    }
                }
                if (b.a.p0.n.c.f11048a) {
                    String str3 = g() + ": getDownloadPath failed, using default path:" + d2;
                }
            }
            return d2;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.n.f.c
    public void e(T t, b.a.p0.n.h.a aVar) {
        b.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, t, aVar) == null) || (cVar = this.f11112e) == null) {
            return;
        }
        try {
            cVar.e(t, aVar);
        } catch (Exception e2) {
            if (b.a.p0.n.c.f11048a) {
                String str = g() + ": notify onDownloadError t=" + t.toString();
                String str2 = g() + ": notify onDownloadError e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    @Override // b.a.p0.n.f.c
    public void f(T t) {
        b.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || (cVar = this.f11112e) == null) {
            return;
        }
        try {
            cVar.f(t);
        } catch (Exception e2) {
            if (b.a.p0.n.c.f11048a) {
                String str = g() + ": Except onDownloading t=" + t.toString();
                String str2 = g() + ": Except onDownloading e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? b.a.p0.n.c.b().v() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.n.f.c
    public b.a.p0.n.h.a h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{t, file, Long.valueOf(j), readableByteChannel})) == null) {
            b.a.p0.n.f.c<T> cVar = this.f11112e;
            if (cVar != null) {
                return cVar.h(t, file, j, readableByteChannel);
            }
            return new b.a.p0.n.h.a(2302, "业务层默认不处理下载流");
        }
        return (b.a.p0.n.h.a) invokeCommon.objValue;
    }

    @Override // b.a.p0.n.f.c
    public void i(T t) {
        b.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, t) == null) || (cVar = this.f11112e) == null) {
            return;
        }
        try {
            cVar.i(t);
        } catch (Exception e2) {
            if (b.a.p0.n.c.f11048a) {
                String str = g() + ": Except onDownloadFinish: t=" + t.toString();
                String str2 = g() + ": Except onDownloadFinish: cb=" + this.f11112e;
                String str3 = g() + ": Except onDownloadFinish: e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    @Override // b.a.p0.n.f.c
    public void j(T t) {
        b.a.p0.n.f.c<T> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) || (cVar = this.f11112e) == null) {
            return;
        }
        try {
            cVar.j(t);
        } catch (Exception e2) {
            if (b.a.p0.n.c.f11048a) {
                String str = g() + ": Except onDownloadStop t=" + t.toString();
                String str2 = g() + ": Except onDownloadStop e=" + Log.getStackTraceString(e2);
                throw e2;
            }
        }
    }

    @Override // b.a.p0.n.f.c
    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f11112e.k() : (Map) invokeV.objValue;
    }

    @Override // b.a.p0.n.f.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bundle, set)) == null) {
            b.a.p0.n.f.c<T> cVar = this.f11112e;
            return cVar == null ? new Bundle() : cVar.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }
}
