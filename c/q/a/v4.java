package c.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes9.dex */
public class v4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f30500b;

    /* renamed from: c  reason: collision with root package name */
    public r4 f30501c;

    /* renamed from: d  reason: collision with root package name */
    public int f30502d;

    public v4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new byte[256];
        this.f30502d = 0;
    }

    public v4 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                this.f30500b = null;
                Arrays.fill(this.a, (byte) 0);
                this.f30501c = new r4();
                this.f30502d = 0;
                ByteBuffer asReadOnlyBuffer = wrap.asReadOnlyBuffer();
                this.f30500b = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f30500b.order(ByteOrder.LITTLE_ENDIAN);
            } else {
                this.f30500b = null;
                this.f30501c.f30425b = 2;
            }
            return this;
        }
        return (v4) invokeL.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30501c.f30425b != 0 : invokeV.booleanValue;
    }

    public final int[] c(int i2) {
        InterceptResult invokeI;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            byte[] bArr = new byte[i2 * 3];
            try {
                this.f30500b.get(bArr);
                iArr = new int[256];
                int i3 = 0;
                int i4 = 0;
                while (i3 < i2) {
                    int i5 = i4 + 1;
                    try {
                        int i6 = i5 + 1;
                        int i7 = i6 + 1;
                        int i8 = i3 + 1;
                        iArr[i3] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                        i4 = i7;
                        i3 = i8;
                    } catch (BufferUnderflowException unused) {
                        this.f30501c.f30425b = 1;
                        return iArr;
                    }
                }
            } catch (BufferUnderflowException unused2) {
                iArr = null;
            }
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return this.f30500b.get() & 255;
            } catch (Exception unused) {
                this.f30501c.f30425b = 1;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int d2 = d();
            this.f30502d = d2;
            int i2 = 0;
            if (d2 > 0) {
                while (i2 < this.f30502d) {
                    try {
                        int i3 = this.f30502d - i2;
                        this.f30500b.get(this.a, i2, i3);
                        i2 += i3;
                    } catch (Exception unused) {
                        this.f30501c.f30425b = 1;
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void f() {
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            do {
                try {
                    d2 = d();
                    this.f30500b.position(this.f30500b.position() + d2);
                } catch (IllegalArgumentException unused) {
                    return;
                }
            } while (d2 > 0);
        }
    }
}
