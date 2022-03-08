package com.baidu.android.pushservice.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public DataInputStream f30895b;

    public d(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30895b = new DataInputStream(inputStream);
        this.a = new byte[8];
    }

    private int a(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            int i3 = 0;
            while (i3 < i2) {
                int read = this.f30895b.read(this.a, i3, i2 - i3);
                if (read == -1) {
                    return read;
                }
                i3 += read;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30895b.close();
        }
    }

    public final void a(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
            this.f30895b.readFully(bArr, 0, bArr.length);
        }
    }

    public final int b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (a(4) >= 0) {
                byte[] bArr = this.a;
                return (bArr[0] & 255) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
            }
            throw new EOFException();
        }
        return invokeV.intValue;
    }

    public final short c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (a(2) >= 0) {
                byte[] bArr = this.a;
                return (short) ((bArr[0] & 255) | ((bArr[1] & 255) << 8));
            }
            throw new EOFException();
        }
        return invokeV.shortValue;
    }

    public final long d() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (a(8) >= 0) {
                byte[] bArr = this.a;
                return (((((((bArr[7] & 255) << 24) | ((bArr[6] & 255) << 16)) | ((bArr[5] & 255) << 8)) | (bArr[4] & 255)) & 4294967295L) << 32) | (4294967295L & (((bArr[1] & 255) << 8) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | (bArr[0] & 255)));
            }
            throw new EOFException();
        }
        return invokeV.longValue;
    }
}
