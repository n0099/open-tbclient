package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class w0<K> extends v0<K> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public transient long[] f34145i;

    /* renamed from: j  reason: collision with root package name */
    public transient int f34146j;
    public transient int k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w0(int i2) {
        this(i2, 1.0f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final int E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (int) (this.f34145i[i2] >>> 32) : invokeI.intValue;
    }

    public final int F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (int) this.f34145i[i2] : invokeI.intValue;
    }

    public final void G(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            long[] jArr = this.f34145i;
            jArr[i2] = (jArr[i2] & 4294967295L) | (i3 << 32);
        }
    }

    public final void H(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            if (i2 == -2) {
                this.f34146j = i3;
            } else {
                I(i2, i3);
            }
            if (i3 == -2) {
                this.k = i2;
            } else {
                G(i3, i2);
            }
        }
    }

    public final void I(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            long[] jArr = this.f34145i;
            jArr[i2] = (jArr[i2] & (-4294967296L)) | (i3 & 4294967295L);
        }
    }

    @Override // c.i.d.c.v0
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.a();
            this.f34146j = -2;
            this.k = -2;
        }
    }

    @Override // c.i.d.c.v0
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.f34146j;
            if (i2 == -2) {
                return -1;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // c.i.d.c.v0
    public void n(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            super.n(i2, f2);
            this.f34146j = -2;
            this.k = -2;
            long[] jArr = new long[i2];
            this.f34145i = jArr;
            Arrays.fill(jArr, -1L);
        }
    }

    @Override // c.i.d.c.v0
    public void o(int i2, K k, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), k, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.o(i2, k, i3, i4);
            H(this.k, i2);
            H(i2, -2);
        }
    }

    @Override // c.i.d.c.v0
    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            int C = C() - 1;
            H(E(i2), F(i2));
            if (i2 < C) {
                H(E(C), i2);
                H(i2, F(C));
            }
            super.p(i2);
        }
    }

    @Override // c.i.d.c.v0
    public int s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            int F = F(i2);
            if (F == -2) {
                return -1;
            }
            return F;
        }
        return invokeI.intValue;
    }

    @Override // c.i.d.c.v0
    public int t(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) ? i2 == C() ? i3 : i2 : invokeII.intValue;
    }

    @Override // c.i.d.c.v0
    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.y(i2);
            long[] jArr = this.f34145i;
            int length = jArr.length;
            long[] copyOf = Arrays.copyOf(jArr, i2);
            this.f34145i = copyOf;
            Arrays.fill(copyOf, length, i2, -1L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(int i2, float f2) {
        super(i2, f2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
