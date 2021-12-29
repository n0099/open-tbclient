package c.i.b.a.d0.u;

import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes9.dex */
public abstract class j extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f30109i;

    /* renamed from: j  reason: collision with root package name */
    public int f30110j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f30111k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(c.i.b.a.h0.e eVar, c.i.b.a.h0.g gVar, int i2, Format format, int i3, Object obj, byte[] bArr) {
        super(eVar, gVar, i2, format, i3, obj, -9223372036854775807L, -9223372036854775807L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {eVar, gVar, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.i.b.a.h0.e) objArr2[0], (c.i.b.a.h0.g) objArr2[1], ((Integer) objArr2[2]).intValue(), (Format) objArr2[3], ((Integer) objArr2[4]).intValue(), objArr2[5], ((Long) objArr2[6]).longValue(), ((Long) objArr2[7]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30109i = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30111k : invokeV.booleanValue;
    }

    @Override // c.i.b.a.d0.u.c
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30110j : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f30111k = true;
        }
    }

    public abstract void d(byte[] bArr, int i2) throws IOException;

    public byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30109i : (byte[]) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            byte[] bArr = this.f30109i;
            if (bArr == null) {
                this.f30109i = new byte[16384];
            } else if (bArr.length < this.f30110j + 16384) {
                this.f30109i = Arrays.copyOf(bArr, bArr.length + 16384);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                this.f30085h.a(this.a);
                int i2 = 0;
                this.f30110j = 0;
                while (i2 != -1 && !this.f30111k) {
                    f();
                    i2 = this.f30085h.read(this.f30109i, this.f30110j, 16384);
                    if (i2 != -1) {
                        this.f30110j += i2;
                    }
                }
                if (!this.f30111k) {
                    d(this.f30109i, this.f30110j);
                }
            } finally {
                v.h(this.f30085h);
            }
        }
    }
}
