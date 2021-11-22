package b.a.q0.s.g0.s;

import android.text.Editable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.g0.s.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class a<T extends a> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f13818h = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f13819a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13820b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f13821c;

    /* renamed from: d  reason: collision with root package name */
    public int f13822d;

    /* renamed from: e  reason: collision with root package name */
    public int f13823e;

    /* renamed from: f  reason: collision with root package name */
    public int f13824f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0715a f13825g;

    /* renamed from: b.a.q0.s.g0.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0715a {
        void a(int i2, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1630069897, "Lb/a/q0/s/g0/s/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1630069897, "Lb/a/q0/s/g0/s/a;");
        }
    }

    public a() {
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
        int i4 = f13818h;
        f13818h = i4 + 1;
        this.f13819a = i4;
    }

    public void a(Editable editable, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, editable, i2, i3, i4) == null) {
            this.f13821c = editable;
            this.f13822d = i2;
            this.f13823e = i3;
            this.f13824f = i4;
        }
    }

    public void b(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.f13820b = t.h();
            this.f13821c = t.g();
            this.f13822d = t.f();
            this.f13823e = t.c();
            this.f13824f = t.d();
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13823e : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13824f : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13819a : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13822d : invokeV.intValue;
    }

    public Editable g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13821c : (Editable) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13820b : invokeV.booleanValue;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence) == null) || (editable = this.f13821c) == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f13822d, this.f13823e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f13823e = this.f13822d + charSequence.length();
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f13823e = i2;
        }
    }

    public void k(InterfaceC0715a interfaceC0715a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interfaceC0715a) == null) {
            this.f13825g = interfaceC0715a;
        }
    }

    public void l(Object obj, int i2, int i3, int i4) {
        Editable editable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048587, this, obj, i2, i3, i4) == null) || (editable = this.f13821c) == null) {
            return;
        }
        editable.setSpan(obj, i2, i3, i4);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f13822d = i2;
        }
    }

    public void n(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editable) == null) {
            this.f13821c = editable;
        }
    }

    public void o(boolean z) {
        InterfaceC0715a interfaceC0715a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            boolean z2 = this.f13820b;
            this.f13820b = z;
            if (z2 == z || (interfaceC0715a = this.f13825g) == null) {
                return;
            }
            interfaceC0715a.a(this.f13819a, z);
        }
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i2);
}
