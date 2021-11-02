package b.a.r0.l3.j0;

import android.util.SparseIntArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f20603c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f20604d;

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f20605e;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f20606f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SparseIntArray f20607a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f20608b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1519296768, "Lb/a/r0/l3/j0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1519296768, "Lb/a/r0/l3/j0/f;");
                return;
            }
        }
        f20603c = new int[]{3, 8, 13};
        f20604d = new int[]{2, 12};
        f20605e = new int[]{20};
        f20606f = new int[]{3, 13, 23};
    }

    public f(String str, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20608b = iArr;
        this.f20607a = new SparseIntArray();
    }

    public void a(int i2, int i3) {
        SparseIntArray sparseIntArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i3 < 0 || (sparseIntArray = this.f20607a) == null) {
            return;
        }
        sparseIntArray.append(i3, i2);
    }

    public int b(int i2) {
        InterceptResult invokeI;
        SparseIntArray sparseIntArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 >= 0 && (sparseIntArray = this.f20607a) != null) {
                return sparseIntArray.get(i2, -1);
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public void c(int i2) {
        SparseIntArray sparseIntArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (sparseIntArray = this.f20607a) == null) {
            return;
        }
        sparseIntArray.delete(i2);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e(0);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            SparseIntArray sparseIntArray = this.f20607a;
            if (sparseIntArray != null) {
                sparseIntArray.clear();
                int[] iArr = this.f20608b;
                if (iArr != null) {
                    for (int i3 : iArr) {
                        if (i3 >= 0) {
                            this.f20607a.append(i3 + i2, i3);
                        }
                    }
                }
            }
        }
    }
}
