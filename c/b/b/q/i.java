package c.b.b.q;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f27444b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27445c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i() {
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

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            float[] fArr = this.a;
            int i2 = this.f27444b;
            if (i2 == fArr.length) {
                fArr = d(Math.max(8, (int) (i2 * 1.75f)));
            }
            int i3 = this.f27444b;
            this.f27444b = i3 + 1;
            fArr[i3] = f2;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f27444b = 0;
        }
    }

    public float c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 < this.f27444b) {
                return this.a[i2];
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i2 + " >= " + this.f27444b);
        }
        return invokeI.floatValue;
    }

    public float[] d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            float[] fArr = new float[i2];
            System.arraycopy(this.a, 0, fArr, 0, Math.min(this.f27444b, i2));
            this.a = fArr;
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (this.f27445c && (obj instanceof i)) {
                i iVar = (i) obj;
                if (iVar.f27445c && (i2 = this.f27444b) == iVar.f27444b) {
                    float[] fArr = this.a;
                    float[] fArr2 = iVar.a;
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (fArr[i3] != fArr2[i3]) {
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

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f27445c) {
                float[] fArr = this.a;
                int i2 = this.f27444b;
                int i3 = 1;
                for (int i4 = 0; i4 < i2; i4++) {
                    i3 = (i3 * 31) + t.b(fArr[i4]);
                }
                return i3;
            }
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public void insert(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            int i3 = this.f27444b;
            if (i2 <= i3) {
                float[] fArr = this.a;
                if (i3 == fArr.length) {
                    fArr = d(Math.max(8, (int) (i3 * 1.75f)));
                }
                if (this.f27445c) {
                    System.arraycopy(fArr, i2, fArr, i2 + 1, this.f27444b - i2);
                } else {
                    fArr[this.f27444b] = fArr[i2];
                }
                this.f27444b++;
                fArr[i2] = f2;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be > size: " + i2 + " > " + this.f27444b);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f27444b == 0) {
                return "[]";
            }
            float[] fArr = this.a;
            j0 j0Var = new j0(32);
            j0Var.a('[');
            j0Var.c(fArr[0]);
            for (int i2 = 1; i2 < this.f27444b; i2++) {
                j0Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j0Var.c(fArr[i2]);
            }
            j0Var.a(']');
            return j0Var.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(int i2) {
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

    public i(boolean z, int i2) {
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
        this.f27445c = z;
        this.a = new float[i2];
    }
}
