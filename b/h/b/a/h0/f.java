package b.h.b.a.h0;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class f extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final e f33382e;

    /* renamed from: f  reason: collision with root package name */
    public final g f33383f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[] f33384g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33385h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33386i;
    public long j;

    public f(e eVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33385h = false;
        this.f33386i = false;
        this.f33382e = eVar;
        this.f33383f = gVar;
        this.f33384g = new byte[1];
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : invokeV.longValue;
    }

    public final void c() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f33385h) {
            return;
        }
        this.f33382e.a(this.f33383f);
        this.f33385h = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f33386i) {
            return;
        }
        this.f33382e.close();
        this.f33386i = true;
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (read(this.f33384g) == -1) {
                return -1;
            }
            return this.f33384g[0] & 255;
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) ? read(bArr, 0, bArr.length) : invokeL.intValue;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i2, i3)) == null) {
            b.h.b.a.i0.a.f(!this.f33386i);
            c();
            int read = this.f33382e.read(bArr, i2, i3);
            if (read == -1) {
                return -1;
            }
            this.j += read;
            return read;
        }
        return invokeLII.intValue;
    }
}
