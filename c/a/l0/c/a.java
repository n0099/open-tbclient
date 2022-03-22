package c.a.l0.c;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.l0.a;
import c.a.l0.d.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f3524f;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f3525b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f3526c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f3527d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, a.InterfaceC0197a> f3528e;

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
                return;
            }
        }
        this.a = new AtomicBoolean(false);
        this.f3525b = new AtomicBoolean(false);
        this.f3526c = new AtomicBoolean(false);
        this.f3527d = new AtomicBoolean(false);
        this.f3528e = new HashMap<>();
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f3524f == null) {
                synchronized (a.class) {
                    if (f3524f == null) {
                        f3524f = new a();
                    }
                }
            }
            return f3524f;
        }
        return (a) invokeV.objValue;
    }

    public synchronized int a(a.InterfaceC0197a interfaceC0197a) {
        InterceptResult invokeL;
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, interfaceC0197a)) == null) {
            synchronized (this) {
                currentTimeMillis = (int) System.currentTimeMillis();
                this.f3528e.put(Integer.valueOf(currentTimeMillis), interfaceC0197a);
            }
            return currentTimeMillis;
        }
        return invokeL.intValue;
    }

    public synchronized Pair<Boolean, a.InterfaceC0197a> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            synchronized (this) {
                if (!this.f3528e.containsKey(Integer.valueOf(i))) {
                    return new Pair<>(Boolean.FALSE, null);
                }
                j.a().b(i);
                this.f3528e.remove(Integer.valueOf(i));
                return new Pair<>(Boolean.TRUE, this.f3528e.get(Integer.valueOf(i)));
            }
        }
        return (Pair) invokeI.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.a.set(z);
        }
    }

    public boolean e(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.a.compareAndSet(z, z2) : invokeCommon.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f3525b.set(z);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3525b.get() : invokeV.booleanValue;
    }

    public synchronized boolean h(int i) {
        InterceptResult invokeI;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            synchronized (this) {
                containsKey = this.f3528e.containsKey(Integer.valueOf(i));
            }
            return containsKey;
        }
        return invokeI.booleanValue;
    }

    public boolean i(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f3525b.compareAndSet(z, z2) : invokeCommon.booleanValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f3526c.set(z);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f3526c.get() : invokeV.booleanValue;
    }

    public synchronized boolean l(int i) {
        InterceptResult invokeI;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            synchronized (this) {
                containsKey = this.f3528e.containsKey(Integer.valueOf(i));
            }
            return containsKey;
        }
        return invokeI.booleanValue;
    }

    public boolean m(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f3526c.compareAndSet(z, z2) : invokeCommon.booleanValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f3527d.set(z);
        }
    }

    public boolean o(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f3527d.compareAndSet(z, z2) : invokeCommon.booleanValue;
    }
}
