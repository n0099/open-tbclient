package b.h.d.d;

import androidx.core.view.InputDeviceCompat;
import b.h.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public abstract class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f33928a;

    public a() {
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
        this.f33928a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // b.h.d.d.c, b.h.d.d.j
    public /* bridge */ /* synthetic */ j f(byte[] bArr) {
        j(bArr);
        return this;
    }

    @Override // b.h.d.d.c, b.h.d.d.f
    public f h(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i2, i3)) == null) {
            n.v(i2, i2 + i3, bArr.length);
            update(bArr, i2, i3);
            return this;
        }
        return (f) invokeLII.objValue;
    }

    @Override // b.h.d.d.f
    public f i(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, byteBuffer)) == null) {
            update(byteBuffer);
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // b.h.d.d.c
    public f j(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) {
            n.p(bArr);
            update(bArr);
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // b.h.d.d.c
    public f k(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.f33928a.putChar(c2);
            return update(2);
        }
        return (f) invokeCommon.objValue;
    }

    public abstract void update(byte b2);

    public void update(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bArr) == null) {
            update(bArr, 0, bArr.length);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.h.d.d.f, b.h.d.d.j
    public f a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.f33928a.putInt(i2);
            return update(4);
        }
        return (f) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.h.d.d.f, b.h.d.d.j
    public f b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            this.f33928a.putLong(j);
            return update(8);
        }
        return (f) invokeJ.objValue;
    }

    public void update(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, bArr, i2, i3) == null) {
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                update(bArr[i4]);
            }
        }
    }

    public void update(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, byteBuffer) == null) {
            if (byteBuffer.hasArray()) {
                update(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.limit());
                return;
            }
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                update(byteBuffer.get());
            }
        }
    }

    private f update(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            try {
                update(this.f33928a.array(), 0, i2);
                return this;
            } finally {
                this.f33928a.clear();
            }
        }
        return (f) invokeI.objValue;
    }
}
