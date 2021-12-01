package c.i.d.d;

import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes7.dex */
public abstract class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteBuffer a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30630b;

    /* renamed from: c  reason: collision with root package name */
    public final int f30631c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(int i2) {
        this(i2, i2);
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
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.d.d.f, c.i.d.d.j
    public /* bridge */ /* synthetic */ j a(int i2) {
        a(i2);
        return this;
    }

    @Override // c.i.d.d.f, c.i.d.d.j
    public /* bridge */ /* synthetic */ j b(long j2) {
        b(j2);
        return this;
    }

    @Override // c.i.d.d.f
    public final HashCode e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            m();
            this.a.flip();
            if (this.a.remaining() > 0) {
                p(this.a);
                ByteBuffer byteBuffer = this.a;
                byteBuffer.position(byteBuffer.limit());
            }
            return l();
        }
        return (HashCode) invokeV.objValue;
    }

    @Override // c.i.d.d.c, c.i.d.d.f
    public final f h(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i2, i3)) == null) {
            q(ByteBuffer.wrap(bArr, i2, i3).order(ByteOrder.LITTLE_ENDIAN));
            return this;
        }
        return (f) invokeLII.objValue;
    }

    @Override // c.i.d.d.f
    public final f i(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, byteBuffer)) == null) {
            ByteOrder order = byteBuffer.order();
            try {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                q(byteBuffer);
                return this;
            } finally {
                byteBuffer.order(order);
            }
        }
        return (f) invokeL.objValue;
    }

    @Override // c.i.d.d.c
    public final f k(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.a.putChar(c2);
            n();
            return this;
        }
        return (f) invokeCommon.objValue;
    }

    public abstract HashCode l();

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.flip();
            while (this.a.remaining() >= this.f30631c) {
                o(this.a);
            }
            this.a.compact();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a.remaining() >= 8) {
            return;
        }
        m();
    }

    public abstract void o(ByteBuffer byteBuffer);

    public abstract void p(ByteBuffer byteBuffer);

    public final f q(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, byteBuffer)) == null) {
            if (byteBuffer.remaining() <= this.a.remaining()) {
                this.a.put(byteBuffer);
                n();
                return this;
            }
            int position = this.f30630b - this.a.position();
            for (int i2 = 0; i2 < position; i2++) {
                this.a.put(byteBuffer.get());
            }
            m();
            while (byteBuffer.remaining() >= this.f30631c) {
                o(byteBuffer);
            }
            this.a.put(byteBuffer);
            return this;
        }
        return (f) invokeL.objValue;
    }

    public d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n.d(i3 % i2 == 0);
        this.a = ByteBuffer.allocate(i3 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f30630b = i3;
        this.f30631c = i2;
    }

    @Override // c.i.d.d.f, c.i.d.d.j
    public final f a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.a.putInt(i2);
            n();
            return this;
        }
        return (f) invokeI.objValue;
    }

    @Override // c.i.d.d.f, c.i.d.d.j
    public final f b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            this.a.putLong(j2);
            n();
            return this;
        }
        return (f) invokeJ.objValue;
    }
}
