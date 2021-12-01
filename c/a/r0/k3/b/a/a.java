package c.a.r0.k3.b.a;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f18661b;

    /* renamed from: c  reason: collision with root package name */
    public int f18662c;

    /* renamed from: d  reason: collision with root package name */
    public int f18663d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18664e;

    /* renamed from: f  reason: collision with root package name */
    public int f18665f;

    /* renamed from: g  reason: collision with root package name */
    public int f18666g;

    /* renamed from: h  reason: collision with root package name */
    public int f18667h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleUser f18668i;

    /* renamed from: j  reason: collision with root package name */
    public int f18669j;

    /* renamed from: k  reason: collision with root package name */
    public int f18670k;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18666g : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18667h : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18661b : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18662c : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18663d : invokeV.intValue;
    }

    public SimpleUser f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f18668i : (SimpleUser) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f18665f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f18670k : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f18664e : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.a = j2.k("post" + currentAccount, 0);
            this.f18661b = j2.k("like" + currentAccount, 0);
            this.f18662c = j2.k("group" + currentAccount, 0);
            this.f18663d = j2.k("live" + currentAccount, 0);
            this.f18665f = j2.k("reply" + currentAccount, 1);
            this.f18670k = j2.k("reply_show_myself" + currentAccount, 0);
            this.f18666g = j2.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            this.f18667h = j2.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            this.f18664e = TbadkCoreApplication.getInst().getLocationShared();
            return (this.a == 0 && this.f18661b == 0 && this.f18662c == 0 && this.f18663d == 0 && this.f18665f == 1 && this.f18670k == 0 && this.f18666g == 0 && this.f18667h == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void l(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a = aVar.a;
        this.f18661b = aVar.f18661b;
        this.f18662c = aVar.f18662c;
        this.f18664e = aVar.f18664e;
        this.f18663d = aVar.f18663d;
        this.f18669j = aVar.f18669j;
        this.f18665f = aVar.f18665f;
        this.f18670k = aVar.f18670k;
        this.f18667h = aVar.f18667h;
        this.f18666g = aVar.f18666g;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
            j2.v("post" + currentAccount, this.a);
            j2.v("like" + currentAccount, this.f18661b);
            j2.v("group" + currentAccount, this.f18662c);
            j2.v("live" + currentAccount, this.f18663d);
            j2.v("reply" + currentAccount, this.f18665f);
            j2.v("reply_show_myself" + currentAccount, this.f18670k);
            j2.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f18666g);
            j2.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f18667h);
            TbadkCoreApplication.getInst().setLocationShared(this.f18664e);
        }
    }

    public void n(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i2) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
            j2.v(str + currentAccount, i2);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f18666g = i2;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f18667h = i2;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f18669j = i2;
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f18661b = i2;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f18662c = i2;
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f18663d = i2;
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 != 1) {
                this.f18664e = false;
            } else {
                this.f18664e = true;
            }
        }
    }

    public void v(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, simpleUser) == null) {
            this.f18668i = simpleUser;
            if (simpleUser != null) {
                x(simpleUser.show_onlyme.intValue());
            }
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (i2 == 0) {
                this.f18665f = 1;
            } else {
                this.f18665f = i2;
            }
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f18670k = i2;
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.a = i2;
        }
    }
}
