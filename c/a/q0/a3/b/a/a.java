package c.a.q0.a3.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
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
    public int f15456a;

    /* renamed from: b  reason: collision with root package name */
    public int f15457b;

    /* renamed from: c  reason: collision with root package name */
    public int f15458c;

    /* renamed from: d  reason: collision with root package name */
    public int f15459d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15460e;

    /* renamed from: f  reason: collision with root package name */
    public int f15461f;

    /* renamed from: g  reason: collision with root package name */
    public int f15462g;

    /* renamed from: h  reason: collision with root package name */
    public int f15463h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleUser f15464i;

    /* renamed from: j  reason: collision with root package name */
    public int f15465j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15462g : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15463h : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15457b : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15458c : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15459d : invokeV.intValue;
    }

    public SimpleUser f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f15464i : (SimpleUser) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f15461f : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f15456a : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f15460e : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.f15456a = j2.k("post" + currentAccount, 0);
            this.f15457b = j2.k("like" + currentAccount, 0);
            this.f15458c = j2.k("group" + currentAccount, 0);
            this.f15459d = j2.k("live" + currentAccount, 0);
            this.f15461f = j2.k("reply" + currentAccount, 1);
            this.k = j2.k("reply_show_myself" + currentAccount, 0);
            this.f15462g = j2.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            this.f15463h = j2.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            this.f15460e = TbadkCoreApplication.getInst().getLocationShared();
            return (this.f15456a == 0 && this.f15457b == 0 && this.f15458c == 0 && this.f15459d == 0 && this.f15461f == 1 && this.k == 0 && this.f15462g == 0 && this.f15463h == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void l(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f15456a = aVar.f15456a;
        this.f15457b = aVar.f15457b;
        this.f15458c = aVar.f15458c;
        this.f15460e = aVar.f15460e;
        this.f15459d = aVar.f15459d;
        this.f15465j = aVar.f15465j;
        this.f15461f = aVar.f15461f;
        this.k = aVar.k;
        this.f15463h = aVar.f15463h;
        this.f15462g = aVar.f15462g;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
            j2.v("post" + currentAccount, this.f15456a);
            j2.v("like" + currentAccount, this.f15457b);
            j2.v("group" + currentAccount, this.f15458c);
            j2.v("live" + currentAccount, this.f15459d);
            j2.v("reply" + currentAccount, this.f15461f);
            j2.v("reply_show_myself" + currentAccount, this.k);
            j2.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f15462g);
            j2.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f15463h);
            TbadkCoreApplication.getInst().setLocationShared(this.f15460e);
        }
    }

    public void n(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i2) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
            j2.v(str + currentAccount, i2);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f15462g = i2;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f15463h = i2;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f15465j = i2;
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f15457b = i2;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f15458c = i2;
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 > 3 || i2 < 1) {
            return;
        }
        this.f15459d = i2;
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 != 1) {
                this.f15460e = false;
            } else {
                this.f15460e = true;
            }
        }
    }

    public void v(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, simpleUser) == null) {
            this.f15464i = simpleUser;
            if (simpleUser != null) {
                x(simpleUser.show_onlyme.intValue());
            }
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (i2 == 0) {
                this.f15461f = 1;
            } else {
                this.f15461f = i2;
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
            this.f15456a = i2;
        }
    }
}
