package c.a.r0.c3.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SimpleUser;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f16161a;

    /* renamed from: b  reason: collision with root package name */
    public int f16162b;

    /* renamed from: c  reason: collision with root package name */
    public int f16163c;

    /* renamed from: d  reason: collision with root package name */
    public int f16164d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16165e;

    /* renamed from: f  reason: collision with root package name */
    public int f16166f;

    /* renamed from: g  reason: collision with root package name */
    public int f16167g;

    /* renamed from: h  reason: collision with root package name */
    public int f16168h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleUser f16169i;

    /* renamed from: j  reason: collision with root package name */
    public int f16170j;
    public int k;

    public a() {
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16167g : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16168h : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16162b : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16163c : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16164d : invokeV.intValue;
    }

    public SimpleUser f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16169i : (SimpleUser) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16166f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f16161a : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f16165e : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.f16161a = j2.k("post" + currentAccount, 0);
            this.f16162b = j2.k("like" + currentAccount, 0);
            this.f16163c = j2.k("group" + currentAccount, 0);
            this.f16164d = j2.k("live" + currentAccount, 0);
            this.f16166f = j2.k("reply" + currentAccount, 1);
            this.k = j2.k("reply_show_myself" + currentAccount, 0);
            this.f16167g = j2.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            this.f16168h = j2.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            this.f16165e = TbadkCoreApplication.getInst().getLocationShared();
            return (this.f16161a == 0 && this.f16162b == 0 && this.f16163c == 0 && this.f16164d == 0 && this.f16166f == 1 && this.k == 0 && this.f16167g == 0 && this.f16168h == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void l(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f16161a = aVar.f16161a;
        this.f16162b = aVar.f16162b;
        this.f16163c = aVar.f16163c;
        this.f16165e = aVar.f16165e;
        this.f16164d = aVar.f16164d;
        this.f16170j = aVar.f16170j;
        this.f16166f = aVar.f16166f;
        this.k = aVar.k;
        this.f16168h = aVar.f16168h;
        this.f16167g = aVar.f16167g;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            j2.v("post" + currentAccount, this.f16161a);
            j2.v("like" + currentAccount, this.f16162b);
            j2.v("group" + currentAccount, this.f16163c);
            j2.v("live" + currentAccount, this.f16164d);
            j2.v("reply" + currentAccount, this.f16166f);
            j2.v("reply_show_myself" + currentAccount, this.k);
            j2.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f16167g);
            j2.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f16168h);
            TbadkCoreApplication.getInst().setLocationShared(this.f16165e);
        }
    }

    public void n(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i2) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            j2.v(str + currentAccount, i2);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f16167g = i2;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f16168h = i2;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f16170j = i2;
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f16162b = i2;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f16163c = i2;
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f16164d = i2;
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 != 1) {
                this.f16165e = false;
            } else {
                this.f16165e = true;
            }
        }
    }

    public void v(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, simpleUser) == null) {
            this.f16169i = simpleUser;
            if (simpleUser != null) {
                x(simpleUser.show_onlyme.intValue());
            }
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (i2 == 0) {
                this.f16166f = 1;
            } else {
                this.f16166f = i2;
            }
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.k = i2;
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f16161a = i2;
        }
    }
}
