package c.a.p0.a4.k0;

import android.util.SparseIntArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f12235c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f12236d;

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f12237e;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f12238f;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseIntArray a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f12239b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1815426836, "Lc/a/p0/a4/k0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1815426836, "Lc/a/p0/a4/k0/f;");
                return;
            }
        }
        f12235c = new int[]{3, 8, 13};
        f12236d = new int[]{2, 12};
        f12237e = new int[]{20};
        f12238f = new int[]{3, 13, 23};
    }

    public f(String str, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12239b = iArr;
        this.a = new SparseIntArray();
    }

    public void a(int i, int i2) {
        SparseIntArray sparseIntArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || i < 0 || i2 < 0 || (sparseIntArray = this.a) == null) {
            return;
        }
        sparseIntArray.append(i2, i);
    }

    public int b(int i) {
        InterceptResult invokeI;
        SparseIntArray sparseIntArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 0 && (sparseIntArray = this.a) != null) {
                return sparseIntArray.get(i, -1);
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public void c(int i) {
        SparseIntArray sparseIntArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (sparseIntArray = this.a) == null) {
            return;
        }
        sparseIntArray.delete(i);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e(0);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            SparseIntArray sparseIntArray = this.a;
            if (sparseIntArray != null) {
                sparseIntArray.clear();
                int[] iArr = this.f12239b;
                if (iArr != null) {
                    for (int i2 : iArr) {
                        if (i2 >= 0) {
                            this.a.append(i2 + i, i2);
                        }
                    }
                }
            }
        }
    }
}
