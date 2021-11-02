package b.a.l;

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
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3257a;

    /* renamed from: b  reason: collision with root package name */
    public int f3258b;

    /* renamed from: c  reason: collision with root package name */
    public int f3259c;

    /* renamed from: d  reason: collision with root package name */
    public int f3260d;

    /* renamed from: e  reason: collision with root package name */
    public int f3261e;

    /* renamed from: f  reason: collision with root package name */
    public int f3262f;

    /* renamed from: g  reason: collision with root package name */
    public int f3263g;

    /* renamed from: h  reason: collision with root package name */
    public int f3264h;

    /* renamed from: i  reason: collision with root package name */
    public int f3265i;
    public boolean j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1143967634, "Lb/a/l/m0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1143967634, "Lb/a/l/m0;");
                return;
            }
        }
        k = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        l = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        m = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        n = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        o = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
        p = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds0);
        q = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
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
        this.f3257a = false;
        this.f3258b = n;
        this.f3259c = p;
        this.f3260d = k;
        this.f3261e = 0;
        this.f3262f = l;
        this.f3263g = m;
        this.f3264h = R.color.CAM_X0205;
        this.f3265i = q;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f3264h = i2;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f3261e = i2;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f3265i = i2;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f3262f = i2;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f3263g = i2;
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f3258b = i2;
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f3260d = i2;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j = z;
        }
    }
}
