package c.a.c0.a0;

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
    public static boolean f1742b;

    /* renamed from: c  reason: collision with root package name */
    public static long f1743c;

    /* renamed from: d  reason: collision with root package name */
    public static int f1744d;

    /* renamed from: e  reason: collision with root package name */
    public static int f1745e;

    /* renamed from: f  reason: collision with root package name */
    public static int f1746f;

    /* renamed from: g  reason: collision with root package name */
    public static int f1747g;

    /* renamed from: h  reason: collision with root package name */
    public static int f1748h;

    /* renamed from: i  reason: collision with root package name */
    public static int f1749i;

    /* renamed from: j  reason: collision with root package name */
    public static double f1750j;

    /* renamed from: k  reason: collision with root package name */
    public static double f1751k;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1406837534, "Lc/a/c0/a0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1406837534, "Lc/a/c0/a0/a;");
                return;
            }
        }
        a = new int[]{0, 1, 2, 3};
        f1742b = true;
        f1743c = 2000L;
        f1744d = 2;
        f1745e = 2;
        f1746f = 6;
        f1747g = 4;
        f1748h = 6;
        f1749i = 30;
        f1750j = 10.0d;
        f1751k = 30.0d;
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
