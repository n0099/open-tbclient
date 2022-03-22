package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f22774b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22775c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l() {
        this(true, 16);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Boolean) objArr[0]).booleanValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int[] iArr = this.a;
            int i2 = this.f22774b;
            if (i2 == iArr.length) {
                iArr = g(Math.max(8, (int) (i2 * 1.75f)));
            }
            int i3 = this.f22774b;
            this.f22774b = i3 + 1;
            iArr[i3] = i;
        }
    }

    public void b(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr) == null) {
            c(iArr, 0, iArr.length);
        }
    }

    public void c(int[] iArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, iArr, i, i2) == null) {
            int[] iArr2 = this.a;
            int i3 = this.f22774b + i2;
            if (i3 > iArr2.length) {
                iArr2 = g(Math.max(Math.max(8, i3), (int) (this.f22774b * 1.75f)));
            }
            System.arraycopy(iArr, i, iArr2, this.f22774b, i2);
            this.f22774b += i2;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f22774b = 0;
        }
    }

    public int[] e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i >= 0) {
                int i2 = this.f22774b + i;
                if (i2 > this.a.length) {
                    g(Math.max(Math.max(8, i2), (int) (this.f22774b * 1.75f)));
                }
                return this.a;
            }
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
        }
        return (int[]) invokeI.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (this.f22775c && (obj instanceof l)) {
                l lVar = (l) obj;
                if (lVar.f22775c && (i = this.f22774b) == lVar.f22774b) {
                    int[] iArr = this.a;
                    int[] iArr2 = lVar.a;
                    for (int i2 = 0; i2 < i; i2++) {
                        if (iArr[i2] != iArr2[i2]) {
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

    public int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            int i2 = this.f22774b;
            if (i < i2) {
                int[] iArr = this.a;
                int i3 = iArr[i];
                int i4 = i2 - 1;
                this.f22774b = i4;
                if (this.f22775c) {
                    System.arraycopy(iArr, i + 1, iArr, i, i4 - i);
                } else {
                    iArr[i] = iArr[i4];
                }
                return i3;
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f22774b);
        }
        return invokeI.intValue;
    }

    public int[] g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            int[] iArr = new int[i];
            System.arraycopy(this.a, 0, iArr, 0, Math.min(this.f22774b, i));
            this.a = iArr;
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f22775c) {
                int[] iArr = this.a;
                int i = this.f22774b;
                int i2 = 1;
                for (int i3 = 0; i3 < i; i3++) {
                    i2 = (i2 * 31) + iArr[i3];
                }
                return i2;
            }
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public void insert(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            int i3 = this.f22774b;
            if (i <= i3) {
                int[] iArr = this.a;
                if (i3 == iArr.length) {
                    iArr = g(Math.max(8, (int) (i3 * 1.75f)));
                }
                if (this.f22775c) {
                    System.arraycopy(iArr, i, iArr, i + 1, this.f22774b - i);
                } else {
                    iArr[this.f22774b] = iArr[i];
                }
                this.f22774b++;
                iArr[i] = i2;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.f22774b);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f22774b == 0) {
                return "[]";
            }
            int[] iArr = this.a;
            j0 j0Var = new j0(32);
            j0Var.a('[');
            j0Var.d(iArr[0]);
            for (int i = 1; i < this.f22774b; i++) {
                j0Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j0Var.d(iArr[i]);
            }
            j0Var.a(']');
            return j0Var.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(int i) {
        this(true, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public l(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f22775c = z;
        this.a = new int[i];
    }
}
