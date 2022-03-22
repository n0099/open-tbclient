package c.a.p0.p3.b.a;

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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f16923b;

    /* renamed from: c  reason: collision with root package name */
    public int f16924c;

    /* renamed from: d  reason: collision with root package name */
    public int f16925d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16926e;

    /* renamed from: f  reason: collision with root package name */
    public int f16927f;

    /* renamed from: g  reason: collision with root package name */
    public int f16928g;

    /* renamed from: h  reason: collision with root package name */
    public int f16929h;
    public SimpleUser i;
    public int j;
    public int k;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16928g : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16929h : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16923b : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16924c : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16925d : invokeV.intValue;
    }

    public SimpleUser f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (SimpleUser) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16927f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f16926e : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.a = k.l("post" + currentAccount, 0);
            this.f16923b = k.l("like" + currentAccount, 0);
            this.f16924c = k.l("group" + currentAccount, 0);
            this.f16925d = k.l("live" + currentAccount, 0);
            this.f16927f = k.l("reply" + currentAccount, 1);
            this.k = k.l("reply_show_myself" + currentAccount, 0);
            this.f16928g = k.l(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            this.f16929h = k.l(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            this.f16926e = TbadkCoreApplication.getInst().getLocationShared();
            return (this.a == 0 && this.f16923b == 0 && this.f16924c == 0 && this.f16925d == 0 && this.f16927f == 1 && this.k == 0 && this.f16928g == 0 && this.f16929h == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void l(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a = aVar.a;
        this.f16923b = aVar.f16923b;
        this.f16924c = aVar.f16924c;
        this.f16926e = aVar.f16926e;
        this.f16925d = aVar.f16925d;
        this.j = aVar.j;
        this.f16927f = aVar.f16927f;
        this.k = aVar.k;
        this.f16929h = aVar.f16929h;
        this.f16928g = aVar.f16928g;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
            k.w("post" + currentAccount, this.a);
            k.w("like" + currentAccount, this.f16923b);
            k.w("group" + currentAccount, this.f16924c);
            k.w("live" + currentAccount, this.f16925d);
            k.w("reply" + currentAccount, this.f16927f);
            k.w("reply_show_myself" + currentAccount, this.k);
            k.w(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f16928g);
            k.w(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f16929h);
            TbadkCoreApplication.getInst().setLocationShared(this.f16926e);
        }
    }

    public void n(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
            k.w(str + currentAccount, i);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f16928g = i;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.f16929h = i;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.j = i;
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || i > 3 || i < 1) {
            return;
        }
        this.f16923b = i;
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || i > 3 || i < 1) {
            return;
        }
        this.f16924c = i;
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || i > 3 || i < 1) {
            return;
        }
        this.f16925d = i;
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            if (i != 1) {
                this.f16926e = false;
            } else {
                this.f16926e = true;
            }
        }
    }

    public void v(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, simpleUser) == null) {
            this.i = simpleUser;
            if (simpleUser != null) {
                x(simpleUser.show_onlyme.intValue());
            }
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            if (i == 0) {
                this.f16927f = 1;
            } else {
                this.f16927f = i;
            }
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.k = i;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.a = i;
        }
    }
}
