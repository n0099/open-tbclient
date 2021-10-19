package c.p.a.e.b.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.f.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f35133a;

    /* renamed from: b  reason: collision with root package name */
    public String f35134b;

    public d() {
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

    public static c.p.a.e.b.n.a G(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            a.H(context);
            return new c.p.a.e.b.n.a();
        }
        return (c.p.a.e.b.n.a) invokeL.objValue;
    }

    public void A(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            f.c().s(list);
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            f.c().C(i2);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f35133a = str;
    }

    @Deprecated
    public void D(int i2, c.p.a.e.b.f.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, cVar) == null) || cVar == null) {
            return;
        }
        f.c().q(i2, cVar, com.ss.android.socialbase.downloader.constants.f.f76194a, true);
    }

    @Deprecated
    public void E(int i2, c.p.a.e.b.f.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z)}) == null) || cVar == null) {
            return;
        }
        f.c().g(i2, cVar, com.ss.android.socialbase.downloader.constants.f.f76194a, true, z);
    }

    public void F(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rVar) == null) {
            e.R(rVar);
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? f.c().B(i2) : invokeI.booleanValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            c(i2, true);
        }
    }

    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            f.c().w(i2, z);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            f.c().z(i2, true);
        }
    }

    public w e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? f.c().L(i2) : (w) invokeI.objValue;
    }

    public DownloadInfo f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? f.c().G(i2) : (DownloadInfo) invokeI.objValue;
    }

    public DownloadInfo g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) ? f.c().o(str, str2) : (DownloadInfo) invokeLL.objValue;
    }

    public List<DownloadInfo> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? f.c().d(str) : (List) invokeL.objValue;
    }

    public c.p.a.e.b.f.e i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? f.c().H(i2) : (c.p.a.e.b.f.e) invokeI.objValue;
    }

    public List<DownloadInfo> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? f.c().A(str) : (List) invokeL.objValue;
    }

    public File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? l(this.f35133a, true) : (File) invokeV.objValue;
    }

    public final File l(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(1048593, this, str, z)) != null) {
            return (File) invokeLZ.objValue;
        }
        File file = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file2 = new File(str);
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (!file2.isDirectory()) {
                    if (!z) {
                        return null;
                    }
                    file2.delete();
                    file2.mkdirs();
                }
                return file2;
            } catch (Throwable unused) {
                file = file2;
                return file;
            }
        } catch (Throwable unused2) {
        }
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? l(this.f35134b, false) : (File) invokeV.objValue;
    }

    public r n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? e.q() : (r) invokeV.objValue;
    }

    public int o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? f.c().E(i2) : invokeI.intValue;
    }

    public List<DownloadInfo> p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? f.c().u(str) : (List) invokeL.objValue;
    }

    public List<DownloadInfo> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? f.c().x(str) : (List) invokeL.objValue;
    }

    public boolean r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? f.c().t(i2).b() : invokeI.booleanValue;
    }

    public boolean s(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, downloadInfo)) == null) ? f.c().l(downloadInfo) : invokeL.booleanValue;
    }

    public boolean t(int i2) {
        InterceptResult invokeI;
        boolean F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            if (c.p.a.e.b.l.a.a(4194304)) {
                synchronized (this) {
                    F = f.c().F(i2);
                }
                return F;
            }
            return f.c().F(i2);
        }
        return invokeI.booleanValue;
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            f.c().y(i2);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            f.c().v();
        }
    }

    public void w(c.p.a.e.b.f.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, qVar) == null) {
            f.c().i(qVar);
        }
    }

    @Deprecated
    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            f.c().f(i2, null, com.ss.android.socialbase.downloader.constants.f.f76194a, true);
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            f.c().D(i2);
        }
    }

    public void z(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, list) == null) {
            f.c().k(list);
        }
    }
}
