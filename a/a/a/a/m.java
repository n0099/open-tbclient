package a.a.a.a;

import android.os.SystemClock;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f1083a;

    /* renamed from: b  reason: collision with root package name */
    public static long f1084b;

    /* renamed from: c  reason: collision with root package name */
    public static long f1085c;

    /* renamed from: d  reason: collision with root package name */
    public static long f1086d;

    /* renamed from: e  reason: collision with root package name */
    public static long f1087e;

    /* renamed from: f  reason: collision with root package name */
    public static long f1088f;

    /* renamed from: g  reason: collision with root package name */
    public static long f1089g;

    /* renamed from: h  reason: collision with root package name */
    public static long f1090h;

    /* renamed from: i  reason: collision with root package name */
    public static long f1091i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f1092a;

        /* renamed from: b  reason: collision with root package name */
        public long f1093b;

        /* renamed from: c  reason: collision with root package name */
        public long f1094c;

        /* renamed from: d  reason: collision with root package name */
        public long f1095d;

        /* renamed from: e  reason: collision with root package name */
        public long f1096e;

        /* renamed from: f  reason: collision with root package name */
        public long f1097f;

        /* renamed from: g  reason: collision with root package name */
        public final Map<String, Long> f1098g;

        /* renamed from: h  reason: collision with root package name */
        public final Map<String, Long> f1099h;

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
            this.f1094c = -1L;
            this.f1096e = -1L;
            this.f1098g = new HashMap();
            this.f1099h = new HashMap();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1222022286, "La/a/a/a/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1222022286, "La/a/a/a/m;");
                return;
            }
        }
        f1083a = new a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f1084b = System.currentTimeMillis();
            f1088f = SystemClock.currentThreadTimeMillis();
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f1087e = System.currentTimeMillis();
            f1091i = SystemClock.currentThreadTimeMillis();
        }
    }
}
