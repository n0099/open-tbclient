package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f27834b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27835c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l() {
        this(true, 16);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Boolean) objArr[0]).booleanValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int[] iArr = this.a;
            int i3 = this.f27834b;
            if (i3 == iArr.length) {
                iArr = g(Math.max(8, (int) (i3 * 1.75f)));
            }
            int i4 = this.f27834b;
            this.f27834b = i4 + 1;
            iArr[i4] = i2;
        }
    }

    public void b(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr) == null) {
            c(iArr, 0, iArr.length);
        }
    }

    public void c(int[] iArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, iArr, i2, i3) == null) {
            int[] iArr2 = this.a;
            int i4 = this.f27834b + i3;
            if (i4 > iArr2.length) {
                iArr2 = g(Math.max(Math.max(8, i4), (int) (this.f27834b * 1.75f)));
            }
            System.arraycopy(iArr, i2, iArr2, this.f27834b, i3);
            this.f27834b += i3;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f27834b = 0;
        }
    }

    public int[] e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 >= 0) {
                int i3 = this.f27834b + i2;
                if (i3 > this.a.length) {
                    g(Math.max(Math.max(8, i3), (int) (this.f27834b * 1.75f)));
                }
                return this.a;
            }
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i2);
        }
        return (int[]) invokeI.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (this.f27835c && (obj instanceof l)) {
                l lVar = (l) obj;
                if (lVar.f27835c && (i2 = this.f27834b) == lVar.f27834b) {
                    int[] iArr = this.a;
                    int[] iArr2 = lVar.a;
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (iArr[i3] != iArr2[i3]) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            int i3 = this.f27834b;
            if (i2 < i3) {
                int[] iArr = this.a;
                int i4 = iArr[i2];
                int i5 = i3 - 1;
                this.f27834b = i5;
                if (this.f27835c) {
                    System.arraycopy(iArr, i2 + 1, iArr, i2, i5 - i2);
                } else {
                    iArr[i2] = iArr[i5];
                }
                return i4;
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i2 + " >= " + this.f27834b);
        }
        return invokeI.intValue;
    }

    public int[] g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int[] iArr = new int[i2];
            System.arraycopy(this.a, 0, iArr, 0, Math.min(this.f27834b, i2));
            this.a = iArr;
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f27835c) {
                int[] iArr = this.a;
                int i2 = this.f27834b;
                int i3 = 1;
                for (int i4 = 0; i4 < i2; i4++) {
                    i3 = (i3 * 31) + iArr[i4];
                }
                return i3;
            }
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public void insert(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            int i4 = this.f27834b;
            if (i2 <= i4) {
                int[] iArr = this.a;
                if (i4 == iArr.length) {
                    iArr = g(Math.max(8, (int) (i4 * 1.75f)));
                }
                if (this.f27835c) {
                    System.arraycopy(iArr, i2, iArr, i2 + 1, this.f27834b - i2);
                } else {
                    iArr[this.f27834b] = iArr[i2];
                }
                this.f27834b++;
                iArr[i2] = i3;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be > size: " + i2 + " > " + this.f27834b);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f27834b == 0) {
                return "[]";
            }
            int[] iArr = this.a;
            j0 j0Var = new j0(32);
            j0Var.a('[');
            j0Var.d(iArr[0]);
            for (int i2 = 1; i2 < this.f27834b; i2++) {
                j0Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j0Var.d(iArr[i2]);
            }
            j0Var.a(']');
            return j0Var.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(int i2) {
        this(true, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public l(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f27835c = z;
        this.a = new int[i2];
    }
}
