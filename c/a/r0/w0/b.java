package c.a.r0.w0;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<d2> f26448a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26449b;

    /* renamed from: c  reason: collision with root package name */
    public w0 f26450c;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f26451d;

    /* renamed from: e  reason: collision with root package name */
    public String f26452e;

    /* renamed from: f  reason: collision with root package name */
    public String f26453f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26454g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26455h;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.w0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1245b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static b f26456a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1546308058, "Lc/a/r0/w0/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1546308058, "Lc/a/r0/w0/b$b;");
                    return;
                }
            }
            f26456a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C1245b.f26456a : (b) invokeV.objValue;
    }

    public boolean a(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2Var)) == null) {
            if (d2Var == null) {
                return false;
            }
            if (this.f26448a.size() > 29) {
                w0 w0Var = this.f26450c;
                if (w0Var != null) {
                    w0Var.b(1);
                }
                return false;
            }
            this.f26448a.add(d2Var);
            w0 w0Var2 = this.f26450c;
            if (w0Var2 != null) {
                w0Var2.c(this.f26448a.size(), 1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Iterator<d2> it = this.f26448a.iterator();
            while (it.hasNext()) {
                d2 next = it.next();
                if (next != null) {
                    next.g4(false);
                }
            }
            this.f26448a.clear();
            w0 w0Var = this.f26450c;
            if (w0Var != null) {
                w0Var.c(0, 1);
            }
        }
    }

    public AntiData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26451d : (AntiData) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26452e : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26453f : (String) invokeV.objValue;
    }

    public List<d2> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26448a : (List) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26455h : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f26449b : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f26454g : invokeV.booleanValue;
    }

    public void k(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || ListUtils.isEmpty(list) || ListUtils.isEmpty(this.f26448a)) {
            return;
        }
        Iterator<d2> it = this.f26448a.iterator();
        while (it.hasNext()) {
            d2 next = it.next();
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (StringHelper.equals(list.get(i2), next.f0())) {
                    it.remove();
                    break;
                } else {
                    i2++;
                }
            }
        }
        w0 w0Var = this.f26450c;
        if (w0Var != null) {
            w0Var.c(this.f26448a.size(), 1);
        }
    }

    public void l(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d2Var) == null) {
            this.f26448a.remove(d2Var);
            w0 w0Var = this.f26450c;
            if (w0Var != null) {
                w0Var.c(this.f26448a.size(), 1);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p(false, false);
            b();
        }
    }

    public void n(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, antiData) == null) {
            this.f26451d = antiData;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f26455h = z;
        }
    }

    public void p(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f26449b = z;
            w0 w0Var = this.f26450c;
            if (w0Var != null) {
                w0Var.a(z, z2, 1);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f26452e = str;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f26453f = str;
        }
    }

    public void s(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, w0Var) == null) {
            this.f26450c = w0Var;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f26454g = z;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26449b = false;
        this.f26448a = new ArrayList<>();
    }
}
