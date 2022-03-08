package com.alibaba.fastjson.asm;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ByteVector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] data;
    public int length;

    public ByteVector() {
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
        this.data = new byte[64];
    }

    private void enlarge(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            int length = this.data.length * 2;
            int i3 = this.length + i2;
            if (length <= i3) {
                length = i3;
            }
            byte[] bArr = new byte[length];
            System.arraycopy(this.data, 0, bArr, 0, this.length);
            this.data = bArr;
        }
    }

    public ByteVector put11(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            int i4 = this.length;
            if (i4 + 2 > this.data.length) {
                enlarge(2);
            }
            byte[] bArr = this.data;
            int i5 = i4 + 1;
            bArr[i4] = (byte) i2;
            bArr[i5] = (byte) i3;
            this.length = i5 + 1;
            return this;
        }
        return (ByteVector) invokeII.objValue;
    }

    public ByteVector put12(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            int i4 = this.length;
            if (i4 + 3 > this.data.length) {
                enlarge(3);
            }
            byte[] bArr = this.data;
            int i5 = i4 + 1;
            bArr[i4] = (byte) i2;
            int i6 = i5 + 1;
            bArr[i5] = (byte) (i3 >>> 8);
            bArr[i6] = (byte) i3;
            this.length = i6 + 1;
            return this;
        }
        return (ByteVector) invokeII.objValue;
    }

    public ByteVector putByte(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int i3 = this.length;
            int i4 = i3 + 1;
            if (i4 > this.data.length) {
                enlarge(1);
            }
            this.data[i3] = (byte) i2;
            this.length = i4;
            return this;
        }
        return (ByteVector) invokeI.objValue;
    }

    public ByteVector putByteArray(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            if (this.length + i3 > this.data.length) {
                enlarge(i3);
            }
            if (bArr != null) {
                System.arraycopy(bArr, i2, this.data, this.length, i3);
            }
            this.length += i3;
            return this;
        }
        return (ByteVector) invokeLII.objValue;
    }

    public ByteVector putInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int i3 = this.length;
            if (i3 + 4 > this.data.length) {
                enlarge(4);
            }
            byte[] bArr = this.data;
            int i4 = i3 + 1;
            bArr[i3] = (byte) (i2 >>> 24);
            int i5 = i4 + 1;
            bArr[i4] = (byte) (i2 >>> 16);
            int i6 = i5 + 1;
            bArr[i5] = (byte) (i2 >>> 8);
            bArr[i6] = (byte) i2;
            this.length = i6 + 1;
            return this;
        }
        return (ByteVector) invokeI.objValue;
    }

    public ByteVector putShort(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int i3 = this.length;
            if (i3 + 2 > this.data.length) {
                enlarge(2);
            }
            byte[] bArr = this.data;
            int i4 = i3 + 1;
            bArr[i3] = (byte) (i2 >>> 8);
            bArr[i4] = (byte) i2;
            this.length = i4 + 1;
            return this;
        }
        return (ByteVector) invokeI.objValue;
    }

    public ByteVector putUTF8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            int length = str.length();
            int i2 = this.length;
            if (i2 + 2 + length > this.data.length) {
                enlarge(length + 2);
            }
            byte[] bArr = this.data;
            int i3 = i2 + 1;
            bArr[i2] = (byte) (length >>> 8);
            int i4 = i3 + 1;
            bArr[i3] = (byte) length;
            int i5 = 0;
            while (i5 < length) {
                char charAt = str.charAt(i5);
                if ((charAt >= 1 && charAt <= 127) || (charAt >= 19968 && charAt <= 40959)) {
                    bArr[i4] = (byte) charAt;
                    i5++;
                    i4++;
                } else {
                    throw new UnsupportedOperationException();
                }
            }
            this.length = i4;
            return this;
        }
        return (ByteVector) invokeL.objValue;
    }

    public ByteVector(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.data = new byte[i2];
    }
}
