package c.a.d.f.k;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<K, V> a;

    /* renamed from: b  reason: collision with root package name */
    public int f2195b;

    /* renamed from: c  reason: collision with root package name */
    public int f2196c;

    /* renamed from: d  reason: collision with root package name */
    public int f2197d;

    /* renamed from: e  reason: collision with root package name */
    public int f2198e;

    /* renamed from: f  reason: collision with root package name */
    public int f2199f;

    /* renamed from: g  reason: collision with root package name */
    public int f2200g;

    public a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2196c = i;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                c();
                this.f2197d = 0;
                this.f2198e = 0;
                this.f2199f = 0;
                this.f2200g = 0;
            }
        }
    }

    public void b(boolean z, K k, V v, V v2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), k, v, v2}) == null) {
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n(-1);
        }
    }

    public final synchronized int d() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                i = this.f2198e;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            synchronized (this) {
                if (this.f2195b + i > this.f2196c * 0.8d) {
                    n(this.f2195b - i);
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final V f(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k)) == null) {
            if (k == null) {
                return null;
            }
            synchronized (this) {
                V v = this.a.get(k);
                if (v != null) {
                    this.f2199f++;
                    return v;
                }
                this.f2200g++;
                return null;
            }
        }
        return (V) invokeL.objValue;
    }

    public final synchronized int g() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i = this.f2196c;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final V h(K k, V v) {
        InterceptResult invokeLL;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, k, v)) == null) {
            if (k == null || v == null) {
                return null;
            }
            synchronized (this) {
                this.f2197d++;
                this.f2195b += j(k, v);
                put = this.a.put(k, v);
                if (put != null) {
                    this.f2195b -= j(k, put);
                }
            }
            if (put != null) {
                b(false, k, put, v);
            }
            n(this.f2196c);
            return put;
        }
        return (V) invokeLL.objValue;
    }

    public final V i(K k) {
        InterceptResult invokeL;
        V remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k)) == null) {
            if (k == null) {
                return null;
            }
            synchronized (this) {
                remove = this.a.remove(k);
                if (remove != null) {
                    this.f2195b -= j(k, remove);
                }
            }
            if (remove != null) {
                b(false, k, remove, null);
            }
            return remove;
        }
        return (V) invokeL.objValue;
    }

    public final int j(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, k, v)) == null) {
            int m = m(k, v);
            if (m >= 0) {
                return m;
            }
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return invokeLL.intValue;
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            synchronized (this) {
                this.f2196c = i;
                n(i);
            }
        }
    }

    public final synchronized int l() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                i = this.f2195b;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public int m(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, k, v)) == null) {
            return 1;
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(int i) {
        K key;
        V value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            while (true) {
                synchronized (this) {
                    if (this.f2195b >= 0 && (!this.a.isEmpty() || this.f2195b == 0)) {
                        if (this.f2195b <= i || this.a.isEmpty()) {
                            break;
                        }
                        Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                        key = next.getKey();
                        value = next.getValue();
                        this.a.remove(key);
                        this.f2195b -= j(key, value);
                        this.f2198e++;
                    } else {
                        break;
                    }
                }
                b(true, key, value, null);
            }
        }
    }
}
