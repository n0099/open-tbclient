package b.a.p0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.m.k;
import b.a.p0.a.z2.j0;
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
public class n<T extends k> extends b.a.p0.q.f.b<b.a.p0.q.i.h> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f5857f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final T f5858e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597581984, "Lb/a/p0/a/h0/m/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597581984, "Lb/a/p0/a/h0/m/n;");
                return;
            }
        }
        f5857f = b.a.p0.a.k.f6863a;
    }

    public n(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5858e = t;
    }

    @Override // b.a.p0.q.f.b
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

    @Override // b.a.p0.q.f.g
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) {
            Bundle bundle2 = new Bundle();
            if (set.contains("event_performance_ubc")) {
                this.f5858e.n(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
                set.remove("event_performance_ubc");
            }
            return bundle2;
        }
        return (Bundle) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.f.e
    /* renamed from: o */
    public String d(b.a.p0.q.i.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hVar)) == null) {
            if (TextUtils.isEmpty(hVar.o)) {
                hVar.o = l();
            }
            int i2 = hVar.f11775h;
            if (i2 == 0) {
                return b.a.p0.a.h0.m.u.b.b(hVar.o, String.valueOf(hVar.f11776i));
            }
            if (i2 == 1) {
                return b.a.p0.a.h0.m.u.b.d(hVar.o, String.valueOf(hVar.f11776i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @CallSuper
    public void p(@NonNull b.a.p0.q.i.h hVar, @Nullable b.a.p0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, hVar, aVar) == null) {
        }
    }

    @CallSuper
    public void q(b.a.p0.q.i.h hVar, b.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar, bVar) == null) {
            super.e(hVar, bVar);
            b.a.p0.a.e0.d.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + hVar.f11768a);
            b.a.p0.w.d.M(hVar.f11768a);
            if (f5857f) {
                String str = "PMSPkgSub onDownloadError " + hVar + ", error=" + bVar;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
    /* renamed from: r */
    public final void i(b.a.p0.q.i.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
            super.i(hVar);
            p(hVar, t(hVar));
            if (f5857f) {
                String str = "PMSPkgSub onDownloadFinish " + hVar;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.f.b, b.a.p0.q.f.e
    /* renamed from: s */
    public void c(b.a.p0.q.i.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
            super.c(hVar);
            if (f5857f) {
                String str = "PMSPkgSub onDownloadStart " + hVar;
            }
        }
    }

    public final b.a.p0.a.u2.a t(b.a.p0.q.i.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, hVar)) == null) {
            if (!j0.a(new File(hVar.f11768a), hVar.m)) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(12L);
                aVar.b(2300L);
                aVar.d("分包签名校验失败");
                return aVar;
            } else if (b.a.p0.a.h0.m.u.b.g(hVar)) {
                return null;
            } else {
                b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                aVar2.k(12L);
                aVar2.b(2320L);
                aVar2.d("分包解压失败");
                return aVar2;
            }
        }
        return (b.a.p0.a.u2.a) invokeL.objValue;
    }
}
