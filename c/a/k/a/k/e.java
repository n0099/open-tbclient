package c.a.k.a.k;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<K, V> a;

    /* renamed from: b  reason: collision with root package name */
    public int f3362b;

    /* renamed from: c  reason: collision with root package name */
    public int f3363c;

    /* renamed from: d  reason: collision with root package name */
    public int f3364d;

    /* renamed from: e  reason: collision with root package name */
    public int f3365e;

    /* renamed from: f  reason: collision with root package name */
    public int f3366f;

    /* renamed from: g  reason: collision with root package name */
    public int f3367g;

    /* renamed from: h  reason: collision with root package name */
    public int f3368h;

    public e(int i) {
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
        if (i > 0) {
            this.f3363c = i;
            this.a = new LinkedHashMap<>(0, 0.75f, true);
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
                    V v = this.a.get(k);
                    if (v != null) {
                        this.f3367g++;
                        return v;
                    }
                    this.f3368h++;
                    V a = a(k);
                    if (a == null) {
                        return null;
                    }
                    synchronized (this) {
                        this.f3365e++;
                        put = this.a.put(k, a);
                        if (put != null) {
                            this.a.put(k, put);
                        } else {
                            this.f3362b += e(k, a);
                        }
                    }
                    if (put != null) {
                        b(false, k, a, put);
                        return put;
                    }
                    g(this.f3363c);
                    return a;
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
                    this.f3364d++;
                    this.f3362b += e(k, v);
                    put = this.a.put(k, v);
                    if (put != null) {
                        this.f3362b -= e(k, put);
                    }
                }
                if (put != null) {
                    b(false, k, put, v);
                }
                g(this.f3363c);
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
    public void g(int i) {
        K key;
        V value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            while (true) {
                synchronized (this) {
                    if (this.f3362b >= 0 && (!this.a.isEmpty() || this.f3362b == 0)) {
                        if (this.f3362b <= i || this.a.isEmpty()) {
                            break;
                        }
                        Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                        key = next.getKey();
                        value = next.getValue();
                        this.a.remove(key);
                        this.f3362b -= e(key, value);
                        this.f3366f++;
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
                int i = this.f3367g + this.f3368h;
                format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f3363c), Integer.valueOf(this.f3367g), Integer.valueOf(this.f3368h), Integer.valueOf(i != 0 ? (this.f3367g * 100) / i : 0));
            }
            return format;
        }
        return (String) invokeV.objValue;
    }
}
