package c.a.e.e.k;

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

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f2307a;

    /* renamed from: b  reason: collision with root package name */
    public int f2308b;

    /* renamed from: c  reason: collision with root package name */
    public int f2309c;

    /* renamed from: d  reason: collision with root package name */
    public int f2310d;

    /* renamed from: e  reason: collision with root package name */
    public int f2311e;

    /* renamed from: f  reason: collision with root package name */
    public int f2312f;

    /* renamed from: g  reason: collision with root package name */
    public int f2313g;

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2309c = i2;
        this.f2307a = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                c();
                this.f2310d = 0;
                this.f2311e = 0;
                this.f2312f = 0;
                this.f2313g = 0;
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                i2 = this.f2311e;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            synchronized (this) {
                if (this.f2308b + i2 > this.f2309c * 0.8d) {
                    n(this.f2308b - i2);
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
                V v = this.f2307a.get(k);
                if (v != null) {
                    this.f2312f++;
                    return v;
                }
                this.f2313g++;
                return null;
            }
        }
        return (V) invokeL.objValue;
    }

    public final synchronized int g() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i2 = this.f2309c;
            }
            return i2;
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
                this.f2310d++;
                this.f2308b += j(k, v);
                put = this.f2307a.put(k, v);
                if (put != null) {
                    this.f2308b -= j(k, put);
                }
            }
            if (put != null) {
                b(false, k, put, v);
            }
            n(this.f2309c);
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
                remove = this.f2307a.remove(k);
                if (remove != null) {
                    this.f2308b -= j(k, remove);
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

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            synchronized (this) {
                this.f2309c = i2;
                n(i2);
            }
        }
    }

    public final synchronized int l() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                i2 = this.f2308b;
            }
            return i2;
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
    public void n(int i2) {
        K key;
        V value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            while (true) {
                synchronized (this) {
                    if (this.f2308b >= 0 && (!this.f2307a.isEmpty() || this.f2308b == 0)) {
                        if (this.f2308b <= i2 || this.f2307a.isEmpty()) {
                            break;
                        }
                        Map.Entry<K, V> next = this.f2307a.entrySet().iterator().next();
                        key = next.getKey();
                        value = next.getValue();
                        this.f2307a.remove(key);
                        this.f2308b -= j(key, value);
                        this.f2311e++;
                    } else {
                        break;
                    }
                }
                b(true, key, value, null);
            }
        }
    }
}
