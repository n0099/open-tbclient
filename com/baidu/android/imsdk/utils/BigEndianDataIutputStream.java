package com.baidu.android.imsdk.utils;

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
/* loaded from: classes4.dex */
public class BigEndianDataIutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] buff;
    public DataInputStream mDis;

    public BigEndianDataIutputStream(InputStream inputStream) {
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
        this.mDis = new DataInputStream(inputStream);
        this.buff = new byte[8];
    }

    private int readToBuff(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            int i3 = 0;
            while (i3 < i2) {
                int read = this.mDis.read(this.buff, i3, i2 - i3);
                if (read == -1) {
                    return read;
                }
                i3 += read;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mDis.close();
        }
    }

    public final byte readByte() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (readToBuff(1) >= 0) {
                return this.buff[0];
            }
            throw new EOFException();
        }
        return invokeV.byteValue;
    }

    public final void readFully(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) {
            this.mDis.readFully(bArr, 0, bArr.length);
        }
    }

    public final int readInt() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (readToBuff(4) >= 0) {
                byte[] bArr = this.buff;
                return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
            }
            throw new EOFException();
        }
        return invokeV.intValue;
    }

    public final long readLong() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (readToBuff(8) >= 0) {
                byte[] bArr = this.buff;
                return (((((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255)) & 4294967295L) << 32) | (4294967295L & (((bArr[6] & 255) << 8) | ((bArr[4] & 255) << 24) | ((bArr[5] & 255) << 16) | (bArr[7] & 255)));
            }
            throw new EOFException();
        }
        return invokeV.longValue;
    }

    public final short readShort() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (readToBuff(2) >= 0) {
                byte[] bArr = this.buff;
                return (short) ((bArr[1] & 255) | ((bArr[0] & 255) << 8));
            }
            throw new EOFException();
        }
        return invokeV.shortValue;
    }

    public final void skipBytes(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mDis.skipBytes(i2);
        }
    }
}
