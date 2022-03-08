package com.baidu.android.imsdk.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class BigEndianDataOutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] buff;
    public DataOutputStream mDos;

    public BigEndianDataOutputStream(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDos = new DataOutputStream(outputStream);
        this.buff = new byte[8];
    }

    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mDos.close();
        }
    }

    public void write(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
            this.mDos.write(bArr);
        }
    }

    public final void writeByte(byte b2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b2) == null) {
            byte[] bArr = this.buff;
            bArr[0] = b2;
            this.mDos.write(bArr, 0, 1);
        }
    }

    public final void writeInt(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            byte[] bArr = this.buff;
            bArr[0] = (byte) (i2 >> 24);
            bArr[1] = (byte) (i2 >> 16);
            bArr[2] = (byte) (i2 >> 8);
            bArr[3] = (byte) i2;
            this.mDos.write(bArr, 0, 4);
        }
    }

    public final void writeLong(long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            byte[] bArr = this.buff;
            bArr[0] = (byte) (j2 >> 56);
            bArr[1] = (byte) (j2 >> 48);
            bArr[2] = (byte) (j2 >> 40);
            bArr[3] = (byte) (j2 >> 32);
            bArr[4] = (byte) (j2 >> 24);
            bArr[5] = (byte) (j2 >> 16);
            bArr[6] = (byte) (j2 >> 8);
            bArr[7] = (byte) j2;
            this.mDos.write(bArr, 0, 8);
        }
    }

    public final void writeShort(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            byte[] bArr = this.buff;
            bArr[1] = (byte) (i2 >> 8);
            bArr[0] = (byte) i2;
            this.mDos.write(bArr, 0, 2);
        }
    }
}
