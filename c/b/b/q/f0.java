package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class f0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public short[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f27432b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27433c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f0() {
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

    public void a(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Short.valueOf(s)}) == null) {
            short[] sArr = this.a;
            int i2 = this.f27432b;
            if (i2 == sArr.length) {
                sArr = e(Math.max(8, (int) (i2 * 1.75f)));
            }
            int i3 = this.f27432b;
            this.f27432b = i3 + 1;
            sArr[i3] = s;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f27432b = 0;
        }
    }

    public short[] c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 >= 0) {
                int i3 = this.f27432b + i2;
                if (i3 > this.a.length) {
                    e(Math.max(Math.max(8, i3), (int) (this.f27432b * 1.75f)));
                }
                return this.a;
            }
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i2);
        }
        return (short[]) invokeI.objValue;
    }

    public short d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = this.f27432b;
            if (i2 < i3) {
                short[] sArr = this.a;
                short s = sArr[i2];
                int i4 = i3 - 1;
                this.f27432b = i4;
                if (this.f27433c) {
                    System.arraycopy(sArr, i2 + 1, sArr, i2, i4 - i2);
                } else {
                    sArr[i2] = sArr[i4];
                }
                return s;
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i2 + " >= " + this.f27432b);
        }
        return invokeI.shortValue;
    }

    public short[] e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            short[] sArr = new short[i2];
            System.arraycopy(this.a, 0, sArr, 0, Math.min(this.f27432b, i2));
            this.a = sArr;
            return sArr;
        }
        return (short[]) invokeI.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (this.f27433c && (obj instanceof f0)) {
                f0 f0Var = (f0) obj;
                if (f0Var.f27433c && (i2 = this.f27432b) == f0Var.f27432b) {
                    short[] sArr = this.a;
                    short[] sArr2 = f0Var.a;
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (sArr[i3] != sArr2[i3]) {
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

    public short[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.f27432b;
            short[] sArr = new short[i2];
            System.arraycopy(this.a, 0, sArr, 0, i2);
            return sArr;
        }
        return (short[]) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f27433c) {
                short[] sArr = this.a;
                int i2 = this.f27432b;
                int i3 = 1;
                for (int i4 = 0; i4 < i2; i4++) {
                    i3 = (i3 * 31) + sArr[i4];
                }
                return i3;
            }
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public void insert(int i2, short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Short.valueOf(s)}) == null) {
            int i3 = this.f27432b;
            if (i2 <= i3) {
                short[] sArr = this.a;
                if (i3 == sArr.length) {
                    sArr = e(Math.max(8, (int) (i3 * 1.75f)));
                }
                if (this.f27433c) {
                    System.arraycopy(sArr, i2, sArr, i2 + 1, this.f27432b - i2);
                } else {
                    sArr[this.f27432b] = sArr[i2];
                }
                this.f27432b++;
                sArr[i2] = s;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be > size: " + i2 + " > " + this.f27432b);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f27432b == 0) {
                return "[]";
            }
            short[] sArr = this.a;
            j0 j0Var = new j0(32);
            j0Var.a('[');
            j0Var.d(sArr[0]);
            for (int i2 = 1; i2 < this.f27432b; i2++) {
                j0Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j0Var.d(sArr[i2]);
            }
            j0Var.a(']');
            return j0Var.toString();
        }
        return (String) invokeV.objValue;
    }

    public f0(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27433c = z;
        this.a = new short[i2];
    }
}
