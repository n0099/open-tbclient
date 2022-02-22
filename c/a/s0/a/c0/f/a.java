package c.a.s0.a.c0.f;

import android.annotation.SuppressLint;
import androidx.annotation.IntRange;
import c.a.s0.a.e0.d;
import c.a.s0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5616b;

    /* renamed from: c  reason: collision with root package name */
    public static int f5617c;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1331535915, "Lc/a/s0/a/c0/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1331535915, "Lc/a/s0/a/c0/f/a;");
                return;
            }
        }
        f5616b = k.a;
        f5617c = 5;
    }

    public a(@IntRange(from = 1) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c(i2, false);
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 >> f5617c : invokeI.intValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public boolean b(@IntRange(from = 0) int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < 0) {
                d.c("Component-DiffBitMap", "diff < 0: " + i2);
                if (f5616b) {
                    throw new IndexOutOfBoundsException("diff < 0: " + i2);
                }
                return false;
            }
            int[] iArr = this.a;
            int length = (iArr.length << f5617c) - 1;
            if (i2 <= length) {
                return ((1 << i2) & iArr[a(i2)]) != 0;
            }
            String str = "diff > " + length + ": " + i2;
            d.c("Component-DiffBitMap", str);
            if (f5616b) {
                throw new IndexOutOfBoundsException(str);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void c(@IntRange(from = 1) int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 <= 0) {
                String str = "number <= 0: " + i2;
                d.c("Component-DiffBitMap", str);
                if (f5616b) {
                    throw new NegativeArraySizeException(str);
                }
                i2 = 500;
            }
            int[] iArr = new int[a(i2 - 1) + 1];
            this.a = iArr;
            int length = iArr.length;
            if (z) {
                for (int i3 = 0; i3 < length; i3++) {
                    this.a[i3] = -1;
                }
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void d(@IntRange(from = 0) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 < 0) {
                d.c("Component-DiffBitMap", "diff < 0: " + i2);
                if (f5616b) {
                    throw new IndexOutOfBoundsException("diff < 0: " + i2);
                }
                return;
            }
            int[] iArr = this.a;
            int length = (iArr.length << f5617c) - 1;
            if (i2 > length) {
                String str = "diff > " + length + ": " + i2;
                d.c("Component-DiffBitMap", str);
                if (f5616b) {
                    throw new IndexOutOfBoundsException(str);
                }
                return;
            }
            int a = a(i2);
            iArr[a] = (1 << i2) | iArr[a];
        }
    }

    public a(@IntRange(from = 1) int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        c(i2, z);
    }
}
