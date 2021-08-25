package c.a.o0.a.f1.c;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5647b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, Object> f5648a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.o0.a.f1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0180b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f5649a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2037435115, "Lc/a/o0/a/f1/c/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2037435115, "Lc/a/o0/a/f1/c/b$b;");
                    return;
                }
            }
            f5649a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-788711405, "Lc/a/o0/a/f1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-788711405, "Lc/a/o0/a/f1/c/b;");
                return;
            }
        }
        f5647b = k.f7049a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0180b.f5649a : (b) invokeV.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.f5648a != null) {
                    this.f5648a.evictAll();
                }
            }
        }
    }

    public synchronized <RESULT> RESULT b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                RESULT result = (RESULT) this.f5648a.get(str);
                if (result == null) {
                    if (f5647b) {
                        String str2 = "doesn't hit the cache result, key = " + str;
                    }
                    return null;
                }
                try {
                    if (f5647b) {
                        String str3 = "hit the cache result, key = " + str;
                    }
                    return result;
                } catch (Exception e2) {
                    if (f5647b) {
                        Log.getStackTraceString(e2);
                    }
                    return null;
                }
            }
        }
        return (RESULT) invokeL.objValue;
    }

    public synchronized <RESULT> void d(String str, RESULT result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, result) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str) && result != null) {
                    if (f5647b) {
                        String str2 = "putConfig key: " + str;
                    }
                    this.f5648a.put(str, result);
                }
            }
        }
    }

    public synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f5647b) {
                    String str2 = "removeConfig key: " + str;
                }
                this.f5648a.remove(str);
            }
        }
    }

    public b() {
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
        this.f5648a = new LruCache<>(10);
    }
}
