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
    public final LinkedHashMap<K, V> a;

    /* renamed from: b  reason: collision with root package name */
    public int f4171b;

    /* renamed from: c  reason: collision with root package name */
    public int f4172c;

    /* renamed from: d  reason: collision with root package name */
    public int f4173d;

    /* renamed from: e  reason: collision with root package name */
    public int f4174e;

    /* renamed from: f  reason: collision with root package name */
    public int f4175f;

    /* renamed from: g  reason: collision with root package name */
    public int f4176g;

    /* renamed from: h  reason: collision with root package name */
    public int f4177h;

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
            this.f4172c = i2;
            this.a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public V a(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k2)) == null) {
            return null;
        }
        return (V) invokeL.objValue;
    }

    public void b(boolean z, K k2, V v, V v2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), k2, v, v2}) == null) {
        }
    }

    public final V c(K k2) {
        InterceptResult invokeL;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k2)) == null) {
            if (k2 != null) {
                synchronized (this) {
                    V v = this.a.get(k2);
                    if (v != null) {
                        this.f4176g++;
                        return v;
                    }
                    this.f4177h++;
                    V a = a(k2);
                    if (a == null) {
                        return null;
                    }
                    synchronized (this) {
                        this.f4174e++;
                        put = this.a.put(k2, a);
                        if (put != null) {
                            this.a.put(k2, put);
                        } else {
                            this.f4171b += e(k2, a);
                        }
                    }
                    if (put != null) {
                        b(false, k2, a, put);
                        return put;
                    }
                    g(this.f4172c);
                    return a;
                }
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeL.objValue;
    }

    public final V d(K k2, V v) {
        InterceptResult invokeLL;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, k2, v)) == null) {
            if (k2 != null && v != null) {
                synchronized (this) {
                    this.f4173d++;
                    this.f4171b += e(k2, v);
                    put = this.a.put(k2, v);
                    if (put != null) {
                        this.f4171b -= e(k2, put);
                    }
                }
                if (put != null) {
                    b(false, k2, put, v);
                }
                g(this.f4172c);
                return put;
            }
            throw new NullPointerException("key == null || value == null");
        }
        return (V) invokeLL.objValue;
    }

    public final int e(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k2, v)) == null) {
            int f2 = f(k2, v);
            if (f2 >= 0) {
                return f2;
            }
            throw new IllegalStateException("Negative size: " + k2 + "=" + v);
        }
        return invokeLL.intValue;
    }

    public int f(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, k2, v)) == null) {
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
                    if (this.f4171b >= 0 && (!this.a.isEmpty() || this.f4171b == 0)) {
                        if (this.f4171b <= i2 || this.a.isEmpty()) {
                            break;
                        }
                        Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                        key = next.getKey();
                        value = next.getValue();
                        this.a.remove(key);
                        this.f4171b -= e(key, value);
                        this.f4175f++;
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
                int i2 = this.f4176g + this.f4177h;
                format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f4172c), Integer.valueOf(this.f4176g), Integer.valueOf(this.f4177h), Integer.valueOf(i2 != 0 ? (this.f4176g * 100) / i2 : 0));
            }
            return format;
        }
        return (String) invokeV.objValue;
    }
}
