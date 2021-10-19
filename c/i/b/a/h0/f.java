package c.i.b.a.h0;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public final class f extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final e f33723e;

    /* renamed from: f  reason: collision with root package name */
    public final g f33724f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[] f33725g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33726h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33727i;

    /* renamed from: j  reason: collision with root package name */
    public long f33728j;

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
        this.f33726h = false;
        this.f33727i = false;
        this.f33723e = eVar;
        this.f33724f = gVar;
        this.f33725g = new byte[1];
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f33727i) {
            return;
        }
        this.f33723e.close();
        this.f33727i = true;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33728j : invokeV.longValue;
    }

    public final void n() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f33726h) {
            return;
        }
        this.f33723e.a(this.f33724f);
        this.f33726h = true;
    }

    public void o() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (read(this.f33725g) == -1) {
                return -1;
            }
            return this.f33725g[0] & 255;
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
            c.i.b.a.i0.a.f(!this.f33727i);
            n();
            int read = this.f33723e.read(bArr, i2, i3);
            if (read == -1) {
                return -1;
            }
            this.f33728j += read;
            return read;
        }
        return invokeLII.intValue;
    }
}
