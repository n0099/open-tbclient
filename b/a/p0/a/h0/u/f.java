package b.a.p0.a.h0.u;

import android.text.TextUtils;
import android.util.LruCache;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5822a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, Object> f5823b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f5824a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2093229470, "Lb/a/p0/a/h0/u/f$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2093229470, "Lb/a/p0/a/h0/u/f$b;");
                    return;
                }
            }
            f5824a = new f(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597820064, "Lb/a/p0/a/h0/u/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597820064, "Lb/a/p0/a/h0/u/f;");
                return;
            }
        }
        f5822a = k.f6397a;
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f5824a : (f) invokeV.objValue;
    }

    public synchronized <CONFIG> CONFIG a(String str, CONFIG config) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, config)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return config;
                }
                CONFIG config2 = (CONFIG) f5823b.get(str);
                if (config2 == null) {
                    return config;
                }
                if (f5822a) {
                    String str2 = "getConfig hit key: " + str;
                }
                return config2;
            }
        }
        return (CONFIG) invokeLL.objValue;
    }

    public synchronized <CONFIG> void c(String str, CONFIG config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, config) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str) && config != null) {
                    if (f5822a) {
                        String str2 = "putConfig key: " + str;
                    }
                    f5823b.put(str, config);
                }
            }
        }
    }

    public f() {
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
        f5823b = new LruCache<>(10);
    }
}
