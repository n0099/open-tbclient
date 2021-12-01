package c.a.k;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final int f3548k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f3549b;

    /* renamed from: c  reason: collision with root package name */
    public int f3550c;

    /* renamed from: d  reason: collision with root package name */
    public int f3551d;

    /* renamed from: e  reason: collision with root package name */
    public int f3552e;

    /* renamed from: f  reason: collision with root package name */
    public int f3553f;

    /* renamed from: g  reason: collision with root package name */
    public int f3554g;

    /* renamed from: h  reason: collision with root package name */
    public int f3555h;

    /* renamed from: i  reason: collision with root package name */
    public int f3556i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3557j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1342621678, "Lc/a/k/m0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1342621678, "Lc/a/k/m0;");
                return;
            }
        }
        f3548k = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        l = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        m = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        n = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        o = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
        p = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.tbds0);
        q = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    }

    public m0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f3549b = n;
        this.f3550c = p;
        this.f3551d = f3548k;
        this.f3552e = 0;
        this.f3553f = l;
        this.f3554g = m;
        this.f3555h = R.color.CAM_X0205;
        this.f3556i = q;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3557j : invokeV.booleanValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f3555h = i2;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f3552e = i2;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f3556i = i2;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f3553f = i2;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f3554g = i2;
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f3549b = i2;
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f3551d = i2;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f3557j = z;
        }
    }
}
