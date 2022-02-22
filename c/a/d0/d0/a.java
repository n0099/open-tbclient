package c.a.d0.d0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2655b;

    /* renamed from: c  reason: collision with root package name */
    public static long f2656c;

    /* renamed from: d  reason: collision with root package name */
    public static int f2657d;

    /* renamed from: e  reason: collision with root package name */
    public static int f2658e;

    /* renamed from: f  reason: collision with root package name */
    public static int f2659f;

    /* renamed from: g  reason: collision with root package name */
    public static int f2660g;

    /* renamed from: h  reason: collision with root package name */
    public static int f2661h;

    /* renamed from: i  reason: collision with root package name */
    public static int f2662i;

    /* renamed from: j  reason: collision with root package name */
    public static double f2663j;
    public static double k;
    public static double l;
    public static long m;
    public static long n;
    public static double o;
    public static double p;
    public static double q;
    public static double r;
    public static double[] s;
    public static AtomicBoolean t;
    public static final Object u;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1142548864, "Lc/a/d0/d0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1142548864, "Lc/a/d0/d0/a;");
                return;
            }
        }
        a = new int[]{0, 1, 2, 3};
        f2655b = true;
        f2656c = 2000L;
        f2657d = 2;
        f2658e = 2;
        f2659f = 6;
        f2660g = 4;
        f2661h = 6;
        f2662i = 30;
        f2663j = 10.0d;
        k = 30.0d;
        l = 2.0d;
        m = 500L;
        n = 3000L;
        o = 999.0d;
        p = 8.0d;
        q = 3.0d;
        r = 1.0d;
        s = new double[]{999.0d, 8.0d, 3.0d, 1.0d};
        t = new AtomicBoolean(false);
        u = new Object();
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? t.get() : invokeV.booleanValue;
    }

    public static Object b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? u : invokeV.objValue;
    }
}
