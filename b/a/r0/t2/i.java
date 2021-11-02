package b.a.r0.t2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class i implements b.a.r0.a2.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f23830a;

    /* renamed from: b  reason: collision with root package name */
    public k f23831b;

    public i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23830a = str;
        this.f23831b = new k(str);
    }

    @Override // b.a.r0.a2.e
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && m(str)) {
            b.a.r0.u3.b.d().j(this.f23830a, b.a.r0.u3.b.i(VideoPlatformStatic.c(), this.f23831b.d(), this.f23831b.b()));
        }
    }

    @Override // b.a.r0.a2.e
    public void b(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2}) == null) && m(str)) {
            this.f23831b.f();
            this.f23831b.i();
            this.f23831b.k();
            this.f23831b.a(new b.a.r0.s2.c(i2, AlbumActivityConfig.FROM_WRITE, i3, str2));
        }
    }

    @Override // b.a.r0.a2.e
    public void c(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2) == null) && m(str)) {
            this.f23831b.f();
            this.f23831b.a(new b.a.r0.s2.c(i2, "edit", i2, str2));
        }
    }

    @Override // b.a.r0.a2.e
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (m(str)) {
                return this.f23831b.g();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r0.a2.e
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f23831b.h() : invokeL.booleanValue;
    }

    @Override // b.a.r0.a2.e
    public void f(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048581, this, str, i2, str2) == null) && m(str)) {
            this.f23831b.f();
            this.f23831b.a(new b.a.r0.s2.c(i2, BundleOpProvider.METHOD_BUNDLE_RECORD, i2, str2));
        }
    }

    @Override // b.a.r0.a2.e
    public void g(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) && m(str)) {
            this.f23831b.f();
            this.f23831b.i();
            this.f23831b.k();
            this.f23831b.a(new b.a.r0.s2.c(402, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // b.a.r0.a2.e
    public void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) && m(str)) {
            this.f23831b.a(new b.a.r0.s2.c(503, str2, -4399, ""));
        }
    }

    @Override // b.a.r0.a2.e
    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && m(str)) {
            this.f23831b.a(new b.a.r0.s2.c(501, str2, -4399, ""));
        }
    }

    @Override // b.a.r0.a2.e
    public void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && m(str)) {
            this.f23831b.k();
            this.f23831b.a(new b.a.r0.s2.c(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // b.a.r0.a2.e
    public void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && m(str)) {
            this.f23831b.k();
            this.f23831b.j();
            this.f23831b.a(new b.a.r0.s2.c(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // b.a.r0.a2.e
    public void l(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048587, this, str, i2, str2) == null) && m(str)) {
            if (i2 != 103 && i2 != 105 && i2 != 106 && i2 != 107 && i2 != 104) {
                this.f23831b.a(new b.a.r0.s2.c(i2, str2, -4399, ""));
                return;
            }
            this.f23831b.f();
            this.f23831b.a(new b.a.r0.s2.c(i2, str2, i2, VideoPlatformStatic.g(i2)));
        }
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? (!TextUtils.equals(this.f23830a, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f23830a)) ? false : true : invokeL.booleanValue;
    }
}
