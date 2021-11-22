package b.h.b.a.a0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f32625a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f32626b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32627c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f32628d;

    /* renamed from: e  reason: collision with root package name */
    public int f32629e;

    public o(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32625a = i2;
        byte[] bArr = new byte[i3 + 3];
        this.f32628d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048576, this, bArr, i2, i3) == null) && this.f32626b) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f32628d;
            int length = bArr2.length;
            int i5 = this.f32629e;
            if (length < i5 + i4) {
                this.f32628d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.f32628d, this.f32629e, i4);
            this.f32629e += i4;
        }
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.f32626b) {
                this.f32629e -= i2;
                this.f32626b = false;
                this.f32627c = true;
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32627c : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f32626b = false;
            this.f32627c = false;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            b.h.b.a.i0.a.f(!this.f32626b);
            boolean z = i2 == this.f32625a;
            this.f32626b = z;
            if (z) {
                this.f32629e = 3;
                this.f32627c = false;
            }
        }
    }
}
