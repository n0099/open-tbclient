package b.a.a.a;

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
    public static final a f1131a;

    /* renamed from: b  reason: collision with root package name */
    public static long f1132b;

    /* renamed from: c  reason: collision with root package name */
    public static long f1133c;

    /* renamed from: d  reason: collision with root package name */
    public static long f1134d;

    /* renamed from: e  reason: collision with root package name */
    public static long f1135e;

    /* renamed from: f  reason: collision with root package name */
    public static long f1136f;

    /* renamed from: g  reason: collision with root package name */
    public static long f1137g;

    /* renamed from: h  reason: collision with root package name */
    public static long f1138h;

    /* renamed from: i  reason: collision with root package name */
    public static long f1139i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f1140a;

        /* renamed from: b  reason: collision with root package name */
        public long f1141b;

        /* renamed from: c  reason: collision with root package name */
        public long f1142c;

        /* renamed from: d  reason: collision with root package name */
        public long f1143d;

        /* renamed from: e  reason: collision with root package name */
        public long f1144e;

        /* renamed from: f  reason: collision with root package name */
        public long f1145f;

        /* renamed from: g  reason: collision with root package name */
        public final Map<String, Long> f1146g;

        /* renamed from: h  reason: collision with root package name */
        public final Map<String, Long> f1147h;

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
            this.f1146g = new HashMap();
            this.f1147h = new HashMap();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1418535791, "Lb/a/a/a/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1418535791, "Lb/a/a/a/m;");
                return;
            }
        }
        f1131a = new a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f1132b = System.currentTimeMillis();
            f1136f = SystemClock.currentThreadTimeMillis();
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f1135e = System.currentTimeMillis();
            f1139i = SystemClock.currentThreadTimeMillis();
        }
    }
}
