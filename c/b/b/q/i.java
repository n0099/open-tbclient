package c.b.b.q;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f22765b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22766c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i() {
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

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            float[] fArr = this.a;
            int i = this.f22765b;
            if (i == fArr.length) {
                fArr = d(Math.max(8, (int) (i * 1.75f)));
            }
            int i2 = this.f22765b;
            this.f22765b = i2 + 1;
            fArr[i2] = f2;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22765b = 0;
        }
    }

    public float c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i < this.f22765b) {
                return this.a[i];
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f22765b);
        }
        return invokeI.floatValue;
    }

    public float[] d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            float[] fArr = new float[i];
            System.arraycopy(this.a, 0, fArr, 0, Math.min(this.f22765b, i));
            this.a = fArr;
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (this.f22766c && (obj instanceof i)) {
                i iVar = (i) obj;
                if (iVar.f22766c && (i = this.f22765b) == iVar.f22765b) {
                    float[] fArr = this.a;
                    float[] fArr2 = iVar.a;
                    for (int i2 = 0; i2 < i; i2++) {
                        if (fArr[i2] != fArr2[i2]) {
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
            if (this.f22766c) {
                float[] fArr = this.a;
                int i = this.f22765b;
                int i2 = 1;
                for (int i3 = 0; i3 < i; i3++) {
                    i2 = (i2 * 31) + t.b(fArr[i3]);
                }
                return i2;
            }
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public void insert(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            int i2 = this.f22765b;
            if (i <= i2) {
                float[] fArr = this.a;
                if (i2 == fArr.length) {
                    fArr = d(Math.max(8, (int) (i2 * 1.75f)));
                }
                if (this.f22766c) {
                    System.arraycopy(fArr, i, fArr, i + 1, this.f22765b - i);
                } else {
                    fArr[this.f22765b] = fArr[i];
                }
                this.f22765b++;
                fArr[i] = f2;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.f22765b);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f22765b == 0) {
                return "[]";
            }
            float[] fArr = this.a;
            j0 j0Var = new j0(32);
            j0Var.a('[');
            j0Var.c(fArr[0]);
            for (int i = 1; i < this.f22765b; i++) {
                j0Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j0Var.c(fArr[i]);
            }
            j0Var.a(']');
            return j0Var.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(int i) {
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

    public i(boolean z, int i) {
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
        this.f22766c = z;
        this.a = new float[i];
    }
}
