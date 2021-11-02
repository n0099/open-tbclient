package b.a.p0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.m.j;
import b.a.p0.a.v2.j0;
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
public class k<T extends j> extends b.a.p0.n.f.b<b.a.p0.n.h.g> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f5567f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final T f5568e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597581891, "Lb/a/p0/a/h0/m/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597581891, "Lb/a/p0/a/h0/m/k;");
                return;
            }
        }
        f5567f = b.a.p0.a.k.f6397a;
    }

    public k(@NonNull T t) {
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
        this.f5568e = t;
    }

    @Override // b.a.p0.n.f.b
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

    @Override // b.a.p0.n.f.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) {
            Bundle bundle2 = new Bundle();
            if (set.contains("event_performance_ubc")) {
                this.f5568e.n(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
                set.remove("event_performance_ubc");
            }
            return bundle2;
        }
        return (Bundle) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.f.c
    /* renamed from: o */
    public String d(b.a.p0.n.h.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gVar)) == null) {
            if (TextUtils.isEmpty(gVar.o)) {
                gVar.o = l();
            }
            int i2 = gVar.f11077h;
            if (i2 == 0) {
                return b.a.p0.a.h0.m.r.b.b(gVar.o, String.valueOf(gVar.f11078i));
            }
            if (i2 == 1) {
                return b.a.p0.a.h0.m.r.b.d(gVar.o, String.valueOf(gVar.f11078i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @CallSuper
    public void p(@NonNull b.a.p0.n.h.g gVar, @Nullable b.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, gVar, aVar) == null) {
        }
    }

    @CallSuper
    public void q(b.a.p0.n.h.g gVar, b.a.p0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar, aVar) == null) {
            super.e(gVar, aVar);
            b.a.p0.a.e0.d.h("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + gVar.f11070a);
            b.a.p0.t.d.L(gVar.f11070a);
            if (f5567f) {
                String str = "PMSPkgSub onDownloadError " + gVar + ", error=" + aVar;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
    /* renamed from: r */
    public final void i(b.a.p0.n.h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            super.i(gVar);
            p(gVar, t(gVar));
            if (f5567f) {
                String str = "PMSPkgSub onDownloadFinish " + gVar;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.f.b, b.a.p0.n.f.c
    /* renamed from: s */
    public void c(b.a.p0.n.h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            super.c(gVar);
            if (f5567f) {
                String str = "PMSPkgSub onDownloadStart " + gVar;
            }
        }
    }

    public final b.a.p0.a.q2.a t(b.a.p0.n.h.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, gVar)) == null) {
            if (!j0.a(new File(gVar.f11070a), gVar.m)) {
                b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
                aVar.j(12L);
                aVar.b(2300L);
                aVar.c("分包签名校验失败");
                return aVar;
            } else if (b.a.p0.a.h0.m.r.b.g(gVar)) {
                return null;
            } else {
                b.a.p0.a.q2.a aVar2 = new b.a.p0.a.q2.a();
                aVar2.j(12L);
                aVar2.b(2320L);
                aVar2.c("分包解压失败");
                return aVar2;
            }
        }
        return (b.a.p0.a.q2.a) invokeL.objValue;
    }
}
