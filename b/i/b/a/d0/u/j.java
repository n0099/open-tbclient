package b.i.b.a.d0.u;

import b.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
public abstract class j extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f32035i;
    public int j;
    public volatile boolean k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(b.i.b.a.h0.e eVar, b.i.b.a.h0.g gVar, int i2, Format format, int i3, Object obj, byte[] bArr) {
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
                super((b.i.b.a.h0.e) objArr2[0], (b.i.b.a.h0.g) objArr2[1], ((Integer) objArr2[2]).intValue(), (Format) objArr2[3], ((Integer) objArr2[4]).intValue(), objArr2[5], ((Long) objArr2[6]).longValue(), ((Long) objArr2[7]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32035i = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void a() throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.f32013h.a(this.f32006a);
                int i2 = 0;
                this.j = 0;
                while (i2 != -1 && !this.k) {
                    g();
                    i2 = this.f32013h.read(this.f32035i, this.j, 16384);
                    if (i2 != -1) {
                        this.j += i2;
                    }
                }
                if (!this.k) {
                    e(this.f32035i, this.j);
                }
            } finally {
                v.h(this.f32013h);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : invokeV.booleanValue;
    }

    @Override // b.i.b.a.d0.u.c
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = true;
        }
    }

    public abstract void e(byte[] bArr, int i2) throws IOException;

    public byte[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f32035i : (byte[]) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            byte[] bArr = this.f32035i;
            if (bArr == null) {
                this.f32035i = new byte[16384];
            } else if (bArr.length < this.j + 16384) {
                this.f32035i = Arrays.copyOf(bArr, bArr.length + 16384);
            }
        }
    }
}
