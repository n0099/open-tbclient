package c.a.r0.s2;

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
/* loaded from: classes3.dex */
public class i implements c.a.r0.z1.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24812a;

    /* renamed from: b  reason: collision with root package name */
    public k f24813b;

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
        this.f24812a = str;
        this.f24813b = new k(str);
    }

    @Override // c.a.r0.z1.e
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && m(str)) {
            c.a.r0.s3.b.d().j(this.f24812a, c.a.r0.s3.b.i(VideoPlatformStatic.c(), this.f24813b.d(), this.f24813b.b()));
        }
    }

    @Override // c.a.r0.z1.e
    public void b(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2}) == null) && m(str)) {
            this.f24813b.f();
            this.f24813b.i();
            this.f24813b.k();
            this.f24813b.a(new c.a.r0.r2.c(i2, AlbumActivityConfig.FROM_WRITE, i3, str2));
        }
    }

    @Override // c.a.r0.z1.e
    public void c(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2) == null) && m(str)) {
            this.f24813b.f();
            this.f24813b.a(new c.a.r0.r2.c(i2, "edit", i2, str2));
        }
    }

    @Override // c.a.r0.z1.e
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (m(str)) {
                return this.f24813b.g();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.z1.e
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f24813b.h() : invokeL.booleanValue;
    }

    @Override // c.a.r0.z1.e
    public void f(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048581, this, str, i2, str2) == null) && m(str)) {
            this.f24813b.f();
            this.f24813b.a(new c.a.r0.r2.c(i2, BundleOpProvider.METHOD_BUNDLE_RECORD, i2, str2));
        }
    }

    @Override // c.a.r0.z1.e
    public void g(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) && m(str)) {
            this.f24813b.f();
            this.f24813b.i();
            this.f24813b.k();
            this.f24813b.a(new c.a.r0.r2.c(402, AlbumActivityConfig.FROM_WRITE, i2, str2));
        }
    }

    @Override // c.a.r0.z1.e
    public void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) && m(str)) {
            this.f24813b.a(new c.a.r0.r2.c(503, str2, -4399, ""));
        }
    }

    @Override // c.a.r0.z1.e
    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && m(str)) {
            this.f24813b.a(new c.a.r0.r2.c(501, str2, -4399, ""));
        }
    }

    @Override // c.a.r0.z1.e
    public void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && m(str)) {
            this.f24813b.k();
            this.f24813b.a(new c.a.r0.r2.c(301, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // c.a.r0.z1.e
    public void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && m(str)) {
            this.f24813b.k();
            this.f24813b.j();
            this.f24813b.a(new c.a.r0.r2.c(401, AlbumActivityConfig.FROM_WRITE, -4399, ""));
        }
    }

    @Override // c.a.r0.z1.e
    public void l(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048587, this, str, i2, str2) == null) && m(str)) {
            if (i2 != 103 && i2 != 105 && i2 != 106 && i2 != 107 && i2 != 104) {
                this.f24813b.a(new c.a.r0.r2.c(i2, str2, -4399, ""));
                return;
            }
            this.f24813b.f();
            this.f24813b.a(new c.a.r0.r2.c(i2, str2, i2, VideoPlatformStatic.g(i2)));
        }
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? (!TextUtils.equals(this.f24812a, str) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f24812a)) ? false : true : invokeL.booleanValue;
    }
}
