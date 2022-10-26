package com.baidu.android.imsdk.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public final void writeByte(byte b) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b) == null) {
            byte[] bArr = this.buff;
            bArr[0] = b;
            this.mDos.write(bArr, 0, 1);
        }
    }

    public final void writeInt(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            byte[] bArr = this.buff;
            bArr[0] = (byte) (i >> 24);
            bArr[1] = (byte) (i >> 16);
            bArr[2] = (byte) (i >> 8);
            bArr[3] = (byte) i;
            this.mDos.write(bArr, 0, 4);
        }
    }

    public final void writeShort(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            byte[] bArr = this.buff;
            bArr[1] = (byte) (i >> 8);
            bArr[0] = (byte) i;
            this.mDos.write(bArr, 0, 2);
        }
    }

    public final void writeLong(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            byte[] bArr = this.buff;
            bArr[0] = (byte) (j >> 56);
            bArr[1] = (byte) (j >> 48);
            bArr[2] = (byte) (j >> 40);
            bArr[3] = (byte) (j >> 32);
            bArr[4] = (byte) (j >> 24);
            bArr[5] = (byte) (j >> 16);
            bArr[6] = (byte) (j >> 8);
            bArr[7] = (byte) j;
            this.mDos.write(bArr, 0, 8);
        }
    }
}
