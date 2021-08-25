package c.a.p0.s.f0.s;

import android.text.Editable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.f0.s.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class a<T extends a> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f13945h = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f13946a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13947b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f13948c;

    /* renamed from: d  reason: collision with root package name */
    public int f13949d;

    /* renamed from: e  reason: collision with root package name */
    public int f13950e;

    /* renamed from: f  reason: collision with root package name */
    public int f13951f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0684a f13952g;

    /* renamed from: c.a.p0.s.f0.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0684a {
        void a(int i2, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1137776822, "Lc/a/p0/s/f0/s/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1137776822, "Lc/a/p0/s/f0/s/a;");
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
        int i4 = f13945h;
        f13945h = i4 + 1;
        this.f13946a = i4;
    }

    public void a(Editable editable, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, editable, i2, i3, i4) == null) {
            this.f13948c = editable;
            this.f13949d = i2;
            this.f13950e = i3;
            this.f13951f = i4;
        }
    }

    public void b(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.f13947b = t.h();
            this.f13948c = t.g();
            this.f13949d = t.f();
            this.f13950e = t.c();
            this.f13951f = t.d();
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13950e : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13951f : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13946a : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13949d : invokeV.intValue;
    }

    public Editable g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13948c : (Editable) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13947b : invokeV.booleanValue;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence) == null) || (editable = this.f13948c) == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f13949d, this.f13950e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f13950e = this.f13949d + charSequence.length();
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f13950e = i2;
        }
    }

    public void k(InterfaceC0684a interfaceC0684a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interfaceC0684a) == null) {
            this.f13952g = interfaceC0684a;
        }
    }

    public void l(Object obj, int i2, int i3, int i4) {
        Editable editable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048587, this, obj, i2, i3, i4) == null) || (editable = this.f13948c) == null) {
            return;
        }
        editable.setSpan(obj, i2, i3, i4);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f13949d = i2;
        }
    }

    public void n(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editable) == null) {
            this.f13948c = editable;
        }
    }

    public void o(boolean z) {
        InterfaceC0684a interfaceC0684a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            boolean z2 = this.f13947b;
            this.f13947b = z;
            if (z2 == z || (interfaceC0684a = this.f13952g) == null) {
                return;
            }
            interfaceC0684a.a(this.f13946a, z);
        }
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i2);
}
