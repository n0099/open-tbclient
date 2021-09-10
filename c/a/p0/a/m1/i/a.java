package c.a.p0.a.m1.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7371c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public double f7372a;

    /* renamed from: b  reason: collision with root package name */
    public Set<Integer> f7373b;

    /* renamed from: c.a.p0.a.m1.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0295a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? b(str, 0.5d) : (a) invokeL.objValue;
        }

        public static a b(String str, double d2) {
            InterceptResult invokeCommon;
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Double.valueOf(d2)})) == null) {
                int hashCode = str.hashCode();
                if (hashCode == -2129978548) {
                    if (str.equals("simple_parser")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else if (hashCode != -585839565) {
                    if (hashCode == 544848403 && str.equals("hsv_parser")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("solid_parser")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            return new c();
                        }
                        return new d();
                    }
                    return new b(d2);
                }
                return new c();
            }
            return (a) invokeCommon.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1258108500, "Lc/a/p0/a/m1/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1258108500, "Lc/a/p0/a/m1/i/a;");
                return;
            }
        }
        f7371c = k.f7077a;
    }

    public a() {
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
        this.f7372a = 1.0d;
    }

    public abstract boolean a(Bitmap bitmap, Rect rect);

    public boolean b(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, rect)) == null) {
            if (bitmap == null || rect == null || rect.top < 0 || rect.bottom < 0 || rect.left < 0 || rect.right < 0) {
                return false;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i2 = rect.top;
            int i3 = rect.bottom;
            if (i2 >= i3 || i3 > height) {
                return false;
            }
            int i4 = rect.left;
            int i5 = rect.right;
            return i4 < i5 && i5 <= width;
        }
        return invokeLL.booleanValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            Set<Integer> set = this.f7373b;
            if (set == null) {
                this.f7373b = new TreeSet();
            } else {
                set.clear();
            }
            if (f7371c) {
                String str = "set color " + String.format("#%06X", Integer.valueOf(16777215 & i2));
            }
            this.f7373b.add(Integer.valueOf(i2));
        }
    }
}
