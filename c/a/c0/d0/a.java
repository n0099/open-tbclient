package c.a.c0.d0;

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
    public static boolean f1810b;

    /* renamed from: c  reason: collision with root package name */
    public static long f1811c;

    /* renamed from: d  reason: collision with root package name */
    public static int f1812d;

    /* renamed from: e  reason: collision with root package name */
    public static int f1813e;

    /* renamed from: f  reason: collision with root package name */
    public static int f1814f;

    /* renamed from: g  reason: collision with root package name */
    public static int f1815g;

    /* renamed from: h  reason: collision with root package name */
    public static int f1816h;

    /* renamed from: i  reason: collision with root package name */
    public static int f1817i;

    /* renamed from: j  reason: collision with root package name */
    public static double f1818j;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1409608097, "Lc/a/c0/d0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1409608097, "Lc/a/c0/d0/a;");
                return;
            }
        }
        a = new int[]{0, 1, 2, 3};
        f1810b = true;
        f1811c = 2000L;
        f1812d = 2;
        f1813e = 2;
        f1814f = 6;
        f1815g = 4;
        f1816h = 6;
        f1817i = 30;
        f1818j = 10.0d;
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
