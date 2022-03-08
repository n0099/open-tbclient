package c.a.n0.c;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a;
import c.a.n0.e.d;
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
    public static volatile a f4292f;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f4293b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f4294c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f4295d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, a.InterfaceC0212a> f4296e;

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
                return;
            }
        }
        this.a = new AtomicBoolean(false);
        this.f4293b = new AtomicBoolean(false);
        this.f4294c = new AtomicBoolean(false);
        this.f4295d = new AtomicBoolean(false);
        this.f4296e = new HashMap<>();
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f4292f == null) {
                synchronized (a.class) {
                    if (f4292f == null) {
                        f4292f = new a();
                    }
                }
            }
            return f4292f;
        }
        return (a) invokeV.objValue;
    }

    public synchronized int a(a.InterfaceC0212a interfaceC0212a) {
        InterceptResult invokeL;
        int currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, interfaceC0212a)) == null) {
            synchronized (this) {
                currentTimeMillis = (int) System.currentTimeMillis();
                this.f4296e.put(Integer.valueOf(currentTimeMillis), interfaceC0212a);
            }
            return currentTimeMillis;
        }
        return invokeL.intValue;
    }

    public synchronized Pair<Boolean, a.InterfaceC0212a> b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            synchronized (this) {
                if (!this.f4296e.containsKey(Integer.valueOf(i2))) {
                    return new Pair<>(Boolean.FALSE, null);
                }
                d.a().b(i2);
                this.f4296e.remove(Integer.valueOf(i2));
                return new Pair<>(Boolean.TRUE, this.f4296e.get(Integer.valueOf(i2)));
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
            this.f4293b.set(z);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4293b.get() : invokeV.booleanValue;
    }

    public synchronized boolean h(int i2) {
        InterceptResult invokeI;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            synchronized (this) {
                containsKey = this.f4296e.containsKey(Integer.valueOf(i2));
            }
            return containsKey;
        }
        return invokeI.booleanValue;
    }

    public boolean i(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f4293b.compareAndSet(z, z2) : invokeCommon.booleanValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f4294c.set(z);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f4294c.get() : invokeV.booleanValue;
    }

    public boolean l(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f4294c.compareAndSet(z, z2) : invokeCommon.booleanValue;
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f4295d.set(z);
        }
    }

    public boolean n(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f4295d.compareAndSet(z, z2) : invokeCommon.booleanValue;
    }
}
