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
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f1075a;

    /* renamed from: b  reason: collision with root package name */
    public static long f1076b;

    /* renamed from: c  reason: collision with root package name */
    public static long f1077c;

    /* renamed from: d  reason: collision with root package name */
    public static long f1078d;

    /* renamed from: e  reason: collision with root package name */
    public static long f1079e;

    /* renamed from: f  reason: collision with root package name */
    public static long f1080f;

    /* renamed from: g  reason: collision with root package name */
    public static long f1081g;

    /* renamed from: h  reason: collision with root package name */
    public static long f1082h;

    /* renamed from: i  reason: collision with root package name */
    public static long f1083i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f1084a;

        /* renamed from: b  reason: collision with root package name */
        public long f1085b;

        /* renamed from: c  reason: collision with root package name */
        public long f1086c;

        /* renamed from: d  reason: collision with root package name */
        public long f1087d;

        /* renamed from: e  reason: collision with root package name */
        public long f1088e;

        /* renamed from: f  reason: collision with root package name */
        public long f1089f;

        /* renamed from: g  reason: collision with root package name */
        public final Map<String, Long> f1090g;

        /* renamed from: h  reason: collision with root package name */
        public final Map<String, Long> f1091h;

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
            this.f1086c = -1L;
            this.f1088e = -1L;
            this.f1090g = new HashMap();
            this.f1091h = new HashMap();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1222022317, "La/a/a/a/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1222022317, "La/a/a/a/l;");
                return;
            }
        }
        f1075a = new a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f1076b = System.currentTimeMillis();
            f1080f = SystemClock.currentThreadTimeMillis();
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f1079e = System.currentTimeMillis();
            f1083i = SystemClock.currentThreadTimeMillis();
        }
    }
}
