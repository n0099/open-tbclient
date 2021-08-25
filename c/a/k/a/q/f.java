package c.a.k.a.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f3744a;

    /* renamed from: b  reason: collision with root package name */
    public int f3745b;

    /* renamed from: c  reason: collision with root package name */
    public int f3746c;

    /* renamed from: d  reason: collision with root package name */
    public int f3747d;

    /* renamed from: e  reason: collision with root package name */
    public int f3748e;

    /* renamed from: f  reason: collision with root package name */
    public int f3749f;

    /* renamed from: g  reason: collision with root package name */
    public int f3750g;

    /* renamed from: h  reason: collision with root package name */
    public int f3751h;

    public f(int i2) {
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
        if (i2 > 0) {
            this.f3746c = i2;
            this.f3744a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public V a(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) {
            return null;
        }
        return (V) invokeL.objValue;
    }

    public void b(boolean z, K k, V v, V v2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), k, v, v2}) == null) {
        }
    }

    public final V c(K k) {
        InterceptResult invokeL;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k)) == null) {
            if (k != null) {
                synchronized (this) {
                    V v = this.f3744a.get(k);
                    if (v != null) {
                        this.f3750g++;
                        return v;
                    }
                    this.f3751h++;
                    V a2 = a(k);
                    if (a2 == null) {
                        return null;
                    }
                    synchronized (this) {
                        this.f3748e++;
                        put = this.f3744a.put(k, a2);
                        if (put != null) {
                            this.f3744a.put(k, put);
                        } else {
                            this.f3745b += e(k, a2);
                        }
                    }
                    if (put != null) {
                        b(false, k, a2, put);
                        return put;
                    }
                    g(this.f3746c);
                    return a2;
                }
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeL.objValue;
    }

    public final V d(K k, V v) {
        InterceptResult invokeLL;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, k, v)) == null) {
            if (k != null && v != null) {
                synchronized (this) {
                    this.f3747d++;
                    this.f3745b += e(k, v);
                    put = this.f3744a.put(k, v);
                    if (put != null) {
                        this.f3745b -= e(k, put);
                    }
                }
                if (put != null) {
                    b(false, k, put, v);
                }
                g(this.f3746c);
                return put;
            }
            throw new NullPointerException("key == null || value == null");
        }
        return (V) invokeLL.objValue;
    }

    public final int e(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k, v)) == null) {
            int f2 = f(k, v);
            if (f2 >= 0) {
                return f2;
            }
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return invokeLL.intValue;
    }

    public int f(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, k, v)) == null) {
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
    public void g(int i2) {
        K key;
        V value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            while (true) {
                synchronized (this) {
                    if (this.f3745b >= 0 && (!this.f3744a.isEmpty() || this.f3745b == 0)) {
                        if (this.f3745b <= i2 || this.f3744a.isEmpty()) {
                            break;
                        }
                        Map.Entry<K, V> next = this.f3744a.entrySet().iterator().next();
                        key = next.getKey();
                        value = next.getValue();
                        this.f3744a.remove(key);
                        this.f3745b -= e(key, value);
                        this.f3749f++;
                    } else {
                        break;
                    }
                }
                b(true, key, value, null);
            }
        }
    }

    public final synchronized String toString() {
        InterceptResult invokeV;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                int i2 = this.f3750g + this.f3751h;
                format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f3746c), Integer.valueOf(this.f3750g), Integer.valueOf(this.f3751h), Integer.valueOf(i2 != 0 ? (this.f3750g * 100) / i2 : 0));
            }
            return format;
        }
        return (String) invokeV.objValue;
    }
}
