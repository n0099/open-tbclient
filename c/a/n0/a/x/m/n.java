package c.a.n0.a.x.m;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.j0;
import c.a.n0.a.x.m.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes.dex */
public class n<T extends k> extends c.a.n0.q.e.b<c.a.n0.q.h.h> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f7280b;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622708261, "Lc/a/n0/a/x/m/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622708261, "Lc/a/n0/a/x/m/n;");
                return;
            }
        }
        f7280b = c.a.n0.a.a.a;
    }

    public n(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = t;
    }

    @Override // c.a.n0.q.e.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.g() : invokeV.intValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.q.e.g
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) {
            Bundle bundle2 = new Bundle();
            if (set.contains("event_performance_ubc")) {
                this.a.n(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
                set.remove("event_performance_ubc");
            }
            return bundle2;
        }
        return (Bundle) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.q.e.e
    /* renamed from: o */
    public String d(c.a.n0.q.h.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hVar)) == null) {
            if (TextUtils.isEmpty(hVar.o)) {
                hVar.o = l();
            }
            int i = hVar.f9146h;
            if (i == 0) {
                return c.a.n0.a.x.m.u.b.b(hVar.o, String.valueOf(hVar.i));
            }
            if (i == 1) {
                return c.a.n0.a.x.m.u.b.d(hVar.o, String.valueOf(hVar.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @CallSuper
    public void p(@NonNull c.a.n0.q.h.h hVar, @Nullable c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, hVar, aVar) == null) {
        }
    }

    @CallSuper
    public void q(c.a.n0.q.h.h hVar, c.a.n0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar, bVar) == null) {
            super.e(hVar, bVar);
            c.a.n0.a.u.d.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + hVar.a);
            c.a.n0.w.d.M(hVar.a);
            if (f7280b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + hVar + ", error=" + bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
    /* renamed from: r */
    public final void i(c.a.n0.q.h.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
            super.i(hVar);
            p(hVar, t(hVar));
            if (f7280b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + hVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
    /* renamed from: s */
    public void c(c.a.n0.q.h.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
            super.c(hVar);
            if (f7280b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + hVar);
            }
        }
    }

    public final c.a.n0.a.k2.a t(c.a.n0.q.h.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, hVar)) == null) {
            if (!j0.a(new File(hVar.a), hVar.m)) {
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(12L);
                aVar.b(2300L);
                aVar.d("分包签名校验失败");
                return aVar;
            } else if (c.a.n0.a.x.m.u.b.g(hVar)) {
                return null;
            } else {
                c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
                aVar2.k(12L);
                aVar2.b(2320L);
                aVar2.d("分包解压失败");
                return aVar2;
            }
        }
        return (c.a.n0.a.k2.a) invokeL.objValue;
    }
}
